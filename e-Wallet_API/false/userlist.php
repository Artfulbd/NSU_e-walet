<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Headers: access");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Allow-Credentials: true");
    header('Content-Type: application/json');
    include_once '../personal/nirapotta.php';
    include_once '../personal/connection.php';
    $conObg = new ConnectTo('wallet');
    $link = $conObg->giveLink();
    $data = json_decode(file_get_contents("php://input"));

    if($link == null){
        http_response_code(404);
        echo json_encode(array("status" => "Connection problem on server"));
    }else if($data == null || !property_exists($data, 'data'))echo "Get Lost";
    else{
        $mykit = new tools;
        $cmd = $data->data;
        if($mykit->test_input($cmd)  &&  $mykit->isBeg($cmd)){
            $query = "SELECT * FROM `regusers`";
            $hold = mysqli_fetch_all(mysqli_query($link, $query), MYSQLI_ASSOC);
            if($hold != null){
                $conObg->detach();
                $product_arr = array(
                    "ids" => $hold
                );
                http_response_code(200);
                echo json_encode($product_arr);
            }else{
                http_response_code(404);
                echo json_encode(array("status" => "thiknai"));
            }
        
        }
        else echo "Get Lost";
    }
    
  
?>