<!-- Html Starts -->



<?php 
    session_start();
    $msg = "Nothing to show";
    if($_SESSION['name'] == ''){
        header('Location: index.php');
    }
    if (isset($_GET['trid'])) {  
        include_once 'Temp/global.php';
        $load = [
          'key' => $key,
          'id' => $_SESSION['id'] ,
          'pass' =>$_SESSION['pass'],
          'trid' =>$_GET['trid']
        ];
        
        $res = make_req($singleHisURL , $load);
        $sz = strlen($res);
        if($sz == 8 || $sz == 19 || $sz == 28){// get lost
            $msg = "Problem on server, please try again later";
        }else{
            $res = json_decode($res, true);
            if(strcmp($res['status'],'ok') == 0){
                $msg = $res['data'];
          }else {
            $er = "Wrong pin or answer";
          }
        }               
        
    }else $msg = "Problem on server, please try again later";
    include_once 'Temp/global.php';
        $load = [
          'key' => $key,
          'id' => $_SESSION['id'] ,
          'pass' =>$_SESSION['pass']
        ];
        
        $res = make_req($allHisURL , $load);
        $sz = strlen($res);
        if($sz == 8 || $sz == 19 || $sz == 28){// get lost
            $_SESSION['success'] = "Problem on server, please try again later";
            header('Location: home.php');
        }else{
            $res = json_decode($res, true);
        }
        
include_once 'Temp/Header.php'; ?>



<!-- Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password) -->
<div align="center">
<?php

           echo "<h1>$msg</h1>";

?>
</div>

<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
