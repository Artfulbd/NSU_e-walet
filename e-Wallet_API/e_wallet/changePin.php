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
    }else if($data == null || !property_exists($data, 'id') || !property_exists($data, 'key') || !property_exists($data, 'ans') || !property_exists($data, 'pin') || !property_exists($data, 'new') || !property_exists($data, 'pass') ){
        $conObg->detach();
        echo "Get Lost";
    }else if(strlen($data->new) != 4 || !$kit->test_input($data->id) || !$kit->test_input($data->pin) || !$kit->test_input($data->key) || !$kit->test_input($data->ans) || !$kit->test_input($data->new) || !$kit->test_input($data->pass) ){
        $conObg->detach();     
        echo "You  fool, Get Lost";
    }
    else{ // do everything here, key is needed to intify request source.        
        $qry = "SELECT w.hashPin,  u.ans, u.hasPass
        FROM `wallet` w join user_data u 
        on w.nsuId = u.nsuId WHERE w.nsuId = $data->id
        and (SELECT count(*) FROM `req_data` WHERE appKey = $data->key) = 1";

       // this qry will check app key, if valid then check id
        $res = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);
        if($res != null){
            // verifying pin and security answer
            if(password_verify($data->pass, $res[0]['hasPass']) && password_verify($data->pin, $res[0]['hashPin']) && password_verify($data->ans, $res[0]['ans'])){ 
                $hash = password_hash($data->new,PASSWORD_DEFAULT);
                $qry = "UPDATE `wallet` SET `hashPin`='$hash' WHERE nsuId = $data->id";
                mysqli_query($link, $qry);
                $conObg->detach();

                http_response_code(200);
                echo json_encode(array('status'=> 'ok'));
              
            }else{ // wrong pin
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
