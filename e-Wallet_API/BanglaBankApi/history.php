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
        !property_exists($req, 'key')       ||
        !$mykit->test_input($req->id)  ||
        !$mykit->test_input($req->key) ){
         echo "Just wait, local police will approach you anytime.";
    }else{
            $qry = "SELECT trDate, des, deb, crd, bal, trid 
            FROM `tr_his` t join user_map u on t.uClId = u.clId 
            WHERE u.gId = $req->id and des <> 'initial' ORDER BY t.trDate DESC";
            $res = mysqli_query($link, $qry);
            if($res){
                $res = mysqli_fetch_all($res, MYSQLI_ASSOC);
                if(count($res)){
                    http_response_code(200);
                    //print_r($res);
                    echo json_encode($res);
                }else{
                    echo "Just wait, local police will approach you anytime.";
                }
                
            }else{
                http_response_code(200);
                echo "sorry try again later";
            }           
            $conObg->detach();     
            
    }

    /*foreach ($res as $row)
            {
                //print_r($row['trDate']);
                echo "Date".$row['trDate']." Dis: ".$row['des']." Amount ".$row['bal']." Trid".$row['trid']."<br>";
            }*/
    
  
?>

