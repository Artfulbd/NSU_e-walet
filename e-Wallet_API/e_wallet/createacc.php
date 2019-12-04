<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Headers: access");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Allow-Credentials: true");
    header('Content-Type: application/json');
    include_once '../personal/nirapotta.php';
    include_once '../personal/connection.php';


    $kit = new tools();
    $conObg = new ConnectTo('wallet');
    $link = $conObg->giveLink();
    $data = json_decode(file_get_contents("php://input"));
    if($link == null){
        http_response_code(404);
        echo json_encode(array("status" => "Connection problem on server"));
    }else if($data == null || !property_exists($data, 'id') ||
             !property_exists($data,'pin') || !property_exists($data, 'key') ||
             !property_exists($data, 'ans') || ! property_exists($data, 'qstn')){
        $conObg->detach();
        echo "Get Lost";
    }else if( !$kit->test_input($data->id) || !$kit->test_input($data->pin) || !$kit->test_input($data->key)
    || !$kit->test_input($data->ans)|| !$kit->test_input($data->qstn) ){
        $conObg->detach();     
        echo "You  fool, Get Lost";
    }else if(strlen($data->pin) != 4){
        http_response_code(200);
        echo json_encode(array('status'=> 'invalid pin size'));
   
    }else{ // do everything here, key is needed to intify request source. 
        $id = $data->id;
        $qry = "SELECT name, ans FROM `user_data` WHERE nsuId = $id and
        (SELECT count(*) FROM `req_data` WHERE appKey = $data->key) = 1 and
          not EXISTS (SELECT * FROM `wallet` WHERE nsuId = $id)";
        $res = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);
        //print_r($res);
        if($res != null && $res[0]['ans'] == ''){
            $name = $res[0]['name'];
            $xData = new purData;    // to make post req
            $load = [
                'key' => "rds api key",
                'name' => $name ,
                'id' => $id 
                ];
                // making post request
            $status = $xData->make_req($xData->get_create_url(), $load );
            if($status == 'success'){  //means bank excepted
                // rds table entry
                $hashAns = password_hash($data->ans,PASSWORD_DEFAULT);
                $hashPin = password_hash($data->pin,PASSWORD_DEFAULT);
                $qry = "UPDATE `user_data` SET `secQues`='$data->qstn',`ans`='$hashAns' WHERE nsuID = $id and  not EXISTS (SELECT * FROM `wallet` WHERE nsuId = $id)";
                mysqli_query($link, $qry);
                $qry = "INSERT INTO `wallet`(`nsuId`, `hashPin`, `onOrOf`) VALUES ($id,'$hashPin',0)";
                mysqli_query($link, $qry);
                $conObg->detach();
                http_response_code(200);
                echo json_encode(array('status'=> 'ok'));
            


            }else{
                $conObg->detach();
                http_response_code(200);
                echo json_encode(array('status'=> 'connection problem,Please try again later'));
            }
        }
        else{
            echo "Get lost";
        }
    }

        













?>