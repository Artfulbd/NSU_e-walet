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

    // set transaction cost here(taka), IT IS IMPORTANT
    $cost = 0;
    
    if( $req == null ||
        !property_exists($req, 'clientFrom') ||
        !property_exists($req, 'clientTo')  ||
        !property_exists($req, 'am')        ||
        !property_exists($req, 'key')       ||
        !$mykit->test_input($req->clientFrom)  ||
        !$mykit->test_input($req->clientTo) ||
        !$mykit->test_input($req->am) ||
        !$mykit->test_input($req->key) || $req->am < 0 ){
         echo "Just wait, local police will approach you anytime.";
    }else{
        
            $qryf = "SELECT bal, clId FROM `tr_his` t join user_map u on t.uClId = u.clId 
            WHERE u.gId = $req->clientFrom and 
            trDate = (SELECT max(trDate) FROM `tr_his` t join user_map u 
                    on t.uClId = u.clId 
                    WHERE u.gId = $req->clientFrom)";

            $qryt = "SELECT bal, clId FROM `tr_his` t join user_map u on t.uClId = u.clId 
            WHERE u.gId = $req->clientTo and 
            trDate = (SELECT max(trDate) FROM `tr_his` t join user_map u 
                    on t.uClId = u.clId 
                    WHERE u.gId = $req->clientTo)";

            mysqli_autocommit($link, false);

            $reqf = mysqli_query($link, $qryf);
            $reqt = mysqli_query($link, $qryt);
            if($reqf && $reqt){
                $reqt = mysqli_fetch_all($reqt , MYSQLI_ASSOC);
                $reqf = mysqli_fetch_all($reqf , MYSQLI_ASSOC);
                if($reqf && $reqt){
                    $f_id = $reqf[0]['clId'];
                    $t_id = $reqt[0]['clId'];
    
                    $f_bal = $reqf[0]['bal'];
                    $t_bal = $reqt[0]['bal'];
    
                    //making new balance
                    $t_bal = $t_bal + $req->am;
                    $f_bal = $f_bal - $req->am - $cost;
    
                    //checking possibility
                    $insuff = false;
                    if($f_bal > 0){
                        $tridF = $mykit->gen_trid();
                        $tridT = $mykit->gen_trid();
                        $currTime = date('Y-m-d H.i.s', time());
        
                        // making query
                        $qry = "INSERT INTO `tr_his` (`uClId`, `trid`, `des`, `deb`, `crd`, `bal`, `trDate`) 
                                           VALUES 
                        ($f_id, '$tridF', 'NSU e-Wallet. Debit', $req->am, 0, $f_bal, '$currTime'),
                        ($t_id, '$tridT', 'NSU e-Wallet. Credit', 0,$req->am, $t_bal, '$currTime')";
        
                        $res = mysqli_query($link, $qry);
                        if($res){
                            mysqli_commit($link);
                            http_response_code(200);
                            echo $tridF;                   //successfull transaction, send trid
                        }else{
                            mysqli_rollback($link);
                            http_response_code(200);
                            echo "Try again later.";
                        } 
                        
                    }else{
                        mysqli_rollback($link);
                        http_response_code(200);
                        echo "Insufficient balance";
                    } 

                }else{
                    mysqli_rollback($link);
                    http_response_code(200);
                    echo "Just wait, local police will approach you anytime.";
                }

            }else{
                
                mysqli_rollback($link);
                http_response_code(200);
                echo "Try again later";
                
        }
        $conObg->detach();

                
            
    }
    
  
?>