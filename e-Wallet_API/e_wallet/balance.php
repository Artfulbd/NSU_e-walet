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
    }else if($data == null || !property_exists($data, 'id') || !property_exists($data, 'key') || !property_exists($data, 'pass') ){
        $conObg->detach();
        echo "Get Lost";
    }else if( !$kit->test_input($data->id) || !$kit->test_input($data->key) || !$kit->test_input($data->pass) ){
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
            if(password_verify($data->pass, $res[0]['hasPass'])){
                $conObg->detach();
                $load = [
                    'key' => "some bank key",
                    'id' => $data->id
                    ];
               //making post request
               $xData = new purData; 
               $balance = $xData->make_req($xData->get_balance_url(), $load );
               $balance = trim($balance);

                http_response_code(200);
                echo json_encode(array(
                    "status"=> "ok",
                    "balance" => $balance
                ));
              
            }else{ 
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
