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
    }else if($data == null || !property_exists($data, 'id') || !property_exists($data, 'key') || !property_exists($data, 'ans') || !property_exists($data, 'pin') || !property_exists($data, 'curr') || !property_exists($data, 'pass')){
        $conObg->detach();
        echo "Get Lost";
    }else if( !$kit->test_input($data->id) || !$kit->test_input($data->pin) || !$kit->test_input($data->key) || !$kit->test_input($data->ans) || !$kit->test_input($data->curr) || !$kit->test_input($data->pass) ){
        $conObg->detach();     
        echo "You  fool, Get Lost";
    }
    else{ // do everything here, key is needed to intify request source.        
        $qry = "SELECT hashPin FROM `wallet` WHERE nsuId = $data->id 
                                       and
              (SELECT count(*) FROM `req_data` WHERE appKey = $data->key) = 1";
       // this qry will check app key, if valid then check id

        $res = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);

        $qry = "SELECT hasPass, ans FROM `user_data` WHERE nsuId = $data->id";
        $res2 = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);

        if($res != null && $res2 != null){
            if(password_verify($data->pin, $res[0]['hashPin']) &&    // verifying pin
               password_verify($data->pass, $res2[0]['hasPass']) && // verifying pass
                password_verify($data->ans, $res2[0]['ans'])){     //verifying ans
                          
            $target = $data->curr ? 0 : 1;
            $qry = "UPDATE `wallet` SET `onOrOf`= $target WHERE nsuId = $data->id";
            mysqli_query($link, $qry);
            $conObg->detach();
            
            http_response_code(200);
            echo json_encode(array('status'=> 'ok'));
               

            }else{ // wrong pin, pass or anss
                $conObg->detach();
                http_response_code(200);
                echo json_encode(array('status'=> 'invalid'));
            }

            
        }else{  // invalid app key
            $conObg->detach();
             echo "Get Lost, you fool.";
        }
    }
?>
