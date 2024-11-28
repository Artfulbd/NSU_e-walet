<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Headers: access");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Allow-Credentials: true");
    header('Content-Type: application/json');
    include_once '../personal/nirapotta.php';
    include_once '../personal/connection.php';
    $conObg = new ConnectTo('bank');
    $mykit = new tools;
    $link = $conObg->giveLink();
    $req = json_decode(file_get_contents("php://input"));
    
    if( $req == null ||
        !property_exists($req, 'id') ||
        !property_exists($req, 'am') ||
        !property_exists($req, 'key')||
        !$mykit->test_input($req->id)  ||
        !$mykit->test_input($req->am) ||
        !$mykit->test_input($req->key) ){
         echo "Just wait, local police will approach you anytime.";
    }else{
            $prb = true;
            mysqli_autocommit($link, false);
            $qry = "SELECT bal,uClId FROM `tr_his` t join user_map u on t.uClId = u.clId 
            WHERE u.gId = $req->id and 
            trDate = (SELECT max(trDate) FROM `tr_his` t join user_map u 
                      on t.uClId = u.clId 
                      WHERE u.gId = $req->id)";
            $res =  mysqli_query($link, $qry);

            if($res){
                $res =  mysqli_fetch_all($res, MYSQLI_ASSOC);

                $currTime = date('Y-m-d H.i.s', time());
                $id  = $res[0]['uClId'];
                $bal = $res[0]['bal'] + $req->am;
                $trid = $mykit->gen_trid();

                $qry = "INSERT INTO `tr_his` (`uClId`, `trid`, `des`, `deb`, `crd`, `bal`, `trDate`) 
                VALUES ($id, '$trid', 'Balance credited', 0, $req->am, $bal, '$currTime')";
                $res = mysqli_query($link,$qry);
                
                if($res)$prb = false;
            }
            http_response_code(200);
            
            if(!$prb){
                mysqli_commit($link);
                echo "success";
            }else{
                mysqli_rollback($link);
                echo "sorry";
            }
    }
    
  
?>