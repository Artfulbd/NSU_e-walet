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
    }else if($data == null || !property_exists($data, 'id') || !property_exists($data, 'key') || !property_exists($data, 'pass') || !property_exists($data, 'trid')){
        $conObg->detach();
        echo "Get Lost";
    }else if( !$kit->test_input($data->id) || !$kit->test_input($data->pass) || !$kit->test_input($data->key) || !$kit->test_input($data->trid)){
        $conObg->detach();     
        echo "You  fool, Get Lost";
    }
    else{ // do everything here, key is needed to intify request source.        
        $qry = "SELECT hashPin FROM `wallet` WHERE nsuId = $data->id 
                                       and
              (SELECT count(*) FROM `req_data` WHERE appKey = $data->key) = 1";
       // this qry will check app key, if valid then check id

        $res = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);
        if($res != null && password_verify($data->pass, $res[0]['hashPin'])){
                       
            $qry = "SELECT list FROM `history` WHERE trid = '$data->trid'";
            $res = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);
            $conObg->detach();
            $data =  $res[0]['list'];
            if($res != null){
                http_response_code(200);
                echo json_encode(array("status"=> "ok","data"=> "$data"));
            }else{
                http_response_code(200);
                echo json_encode(array('status'=> 'not ok'));
            }
                        
        }else{  // invalid app key
            $conObg->detach();
             echo "Get Lost, you fool.";
        }
    }
?>
