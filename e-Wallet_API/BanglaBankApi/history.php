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
            /*echo $req->clientFrom;
            echo $req->clientTo;
            echo $req->am;
            echo $req->key;   */
            // for transaction, make sure storage engine is innoDB 
            //INSERT INTO `tr_his` (`uClId`, `trid`, `des`, `deb`, `crd`, `bal`, `trDate`) VALUES ('1', 'a1d1861a37d8582', 'e-Wallet', '110', '0', '500', '2019-12-09 11:42:08')

            //close link
            $qry = "SELECT trDate, des, deb, crd, bal, trid FROM `tr_his` t join user_map u on t.uClId = u.clId WHERE u.gId = $req->id";
           
            $res = mysqli_fetch_all(mysqli_query($link, $qry), MYSQLI_ASSOC);
            $conObg->detach();
                      

            http_response_code(200);
            print_r($res);

            
    }

    /*foreach ($res as $row)
            {
                //print_r($row['trDate']);
                echo "Date".$row['trDate']." Dis: ".$row['des']." Amount ".$row['bal']." Trid".$row['trid']."<br>";
            }*/
    
  
?>

