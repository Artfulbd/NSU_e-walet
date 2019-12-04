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
             !property_exists($data,'name') || !property_exists($data, 'key')){
        $conObg->detach();
        echo "Get Lost";
    }else if( !$kit->test_input($data->id) || !$kit->test_input($data->name) || !$kit->test_input($data->key)){
        $conObg->detach();     
        echo "You  fool, Get Lost";
    }
    else{ // do everything here, key is needed to intify request source. 
            http_response_code(200);
            echo "success";













       /* $qry = "SELECT name, address, hasPass FROM `user_data` WHERE nsuId = $data->id 
                                       and
              (SELECT count(*) FROM `req_data` WHERE appKey = $data->key) = 1";
       // this qry will check app key, if valid then check id
       
        $res = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);
        if($res != null){
            
            
        }else{  // invalid app key
            $conObg->detach();
             echo "Get Lost, you fool.";
        }*/
    }
?>