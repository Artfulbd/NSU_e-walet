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
    
    
    if($link == null){
        http_response_code(404);
        echo json_encode(array("status" => "Connection problem on server"));
    }else if($req == null ||
            !property_exists($req, 'data') ||
            !property_exists($req, 'sec')  ||
            !property_exists($req, 'body') ||
            !property_exists($req, 'ano')  ||
            !$mykit->test_input($req->data) ||
            !$mykit->test_input($req->sec)   ||
            !$mykit->test_input($req->body) ||
            !$mykit->test_input($req->ano) ){
        $conObg->detach();
        echo "Get Lost";
    }else{
            $xData = new purData;              // to store extracted data, but first validate
            $xData->data = $req->data;
            $xData->sec = $req->sec;
            $xData->list= $req->body;
            $xData->ano = $req->ano;
            $isValid = false;
            
            
            $xData = $mykit->give_data($xData);
            $am = "";
            $from = "";
            $to = "";
            $pin = strtok($xData->sec, ' ');
            
            if(strlen($pin) == 4){    // to choose algorithm
                $am = strtok( $xData->data, ';');
                $from = strtok(' ');
                $isValid = true;
            }else{
                $am = strtok( $xData->data, ';');
                $from = $pin;
                $pin = strtok(' ');
                $isValid = true;
            }
            if($isValid){
                $to = strtok( $xData->ano, ' ');
                $qry = 'SELECT api_key FROM `bank` WHERE bankId = 1';
                $hold = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);

                $qry = "SELECT hashPin FROM `wallet` WHERE nsuId = $from and onOrOF = 1";  //check pin here
                $hold2 = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);

                if($hold != null && $hold2 != null){
                    $key = $hold[0]['api_key'];
                    if(password_verify($pin, $hold2[0]['hashPin'])){
                        $load = [
                            'key' => $key,
                            'clientFrom' => $from ,
                            'clientTo' => $to ,
                            'am' => $am
                            ];
                            //making post request
                      // $trid = $xData->purchase_req($url, $key, $from, $to, $am, $load );
                      $trid = $xData->make_req($xData->get_purchaser_url(), $load );
                       $qry = "INSERT INTO `history`(`trid`, `list`) VALUE ('$trid','$xData->list')"; 
                       $count = 0;
                       do{
                        $hold = mysqli_query($link, $qry);
                        if($count>3)break;
                        $count = $count+1;
                       }while($hold==1);
                       
                       if($count == 4){
                           $hold = $trid."  ".$xData->list;
                           $qry = "INSERT INTO `manual_job`(`qry`) VALUES ('$hold')";
                           mysqli_query($link, $qry);
                            http_response_code(200);
                            echo json_encode(array("status" => "manual","trid" => $trid));
                       }else{
                            http_response_code(200);
                            echo json_encode(array("status" => "ok","trid" => $trid));
                       }
                       $conObg->detach();  //closing link
                    }else {
                        http_response_code(200);
                        echo json_encode(array("status" => "invalid"));
                    }
                }else {
                    http_response_code(200);
                    echo json_encode(array("status" => "error"));
                }



            }
            else echo "Get Lost";

        
    }
    
  
?>