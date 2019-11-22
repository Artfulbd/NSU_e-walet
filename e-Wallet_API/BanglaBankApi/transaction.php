<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Headers: access");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Allow-Credentials: true");
    header('Content-Type: application/json');
    include_once '../personal/nirapotta.php';
    include_once '../personal/connection.php';
    $conObg = new ConnectTo('wallet');
    $mykit = new tools;
    $link = $conObg->giveLink();
    $req = json_decode(file_get_contents("php://input"));
    
    if( $req == null ||
        !property_exists($req, 'clientFrom') ||
        !property_exists($req, 'clientTo')  ||
        !property_exists($req, 'am')        ||
        !property_exists($req, 'key')       ||
        !$mykit->test_input($req->clientFrom)  ||
        !$mykit->test_input($req->clientTo) ||
        !$mykit->test_input($req->am) ||
        !$mykit->test_input($req->key) ){
         echo "Just wait, local police will approach you anytime.";
    }else{
            /*echo $req->clientFrom;
            echo $req->clientTo;
            echo $req->am;
            echo $req->key;   */
            // for transaction, make sure storage engine is innoDB 

            http_response_code(200);
            echo $mykit->gen_trid();
    }
    
  
?>