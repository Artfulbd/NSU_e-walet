<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Headers: access");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Allow-Credentials: true");
    header('Content-Type: application/json');
    include_once '../personal/nirapotta.php';
    include_once '../personal/connection.php';

    $kit = new tools();
    $conObg = new ConnectTo('bank');
    $linkk = $conObg->giveLink();
    $data = json_decode(file_get_contents("php://input"));
    if($linkk == null){
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
        //make a fake transaction with balence 0 for every client ID creation

        mysqli_autocommit($linkk, false);
        $prb = false;
        $qry = "INSERT INTO `user_map`( `name`, `gId`) VALUES ('$data->name',$data->id);";
        $res = mysqli_query($linkk, $qry);
        if($res){
            $qry = "SELECT clId FROM user_map WHERE gId = $data->id";
            $res = mysqli_query($linkk, $qry);
        }else $prb = true;

        if(!$prb){
            $res = mysqli_fetch_all($res, MYSQLI_ASSOC);
            $trid = $kit->gen_trid();
            $currTime = date('Y-m-d H:i:s a', time());
            $id = $res[0]['clId'];
            $qry = "INSERT INTO `tr_his`(`uClId`, `trid`, `des`, `deb`, `crd`, `bal`, `trDate`)
                    VALUES  ($id,'$trid','initial',0,0,0,'$currTime')";
            $res = mysqli_query($linkk, $qry);
        }
        if(!$prb && $res){
            mysqli_commit($linkk);
            http_response_code(200);
            echo "success";
        } else {
            mysqli_roollback($linkk);
            http_response_code(200);
            echo "try again later";
        }
        
        $conObg->detach();
    }
?>