<?php 

	session_start();
	if($_SESSION['name'] == ''){
		header('Location: index.php');
	  }  
	$balance = 0;
	include_once 'Temp/global.php';
        $load = [
          'key' => $key,
          'id' =>  $_SESSION['id'],
          'pass' =>$_SESSION['pass']
		];
		$res = make_req($balanceURL, $load ); 
	    $sz = strlen($res);
        if($sz == 8 || $sz == 19){// get lost
          $_SESSION['success'] = "Problem on server, please try again later";
          header('Location: home.php');
        }else{
          //valid
          $res = json_decode($res, true);
          if(strcmp($res['status'],'ok') == 0){
            $balance = $res['balance'];
          }else if(strcmp($res['status'],'invalid') == 0){
            $er = "Problem on server";
          }else{
            $_SESSION['success'] = $res['status'];
            header('Location: home.php');
          }

        }

include 'Temp/Header.php'; 
?>


	<h1 align = "center";>Your current balance is <?php echo $balance ?> taka.</h1><br>

<?php include 'Temp/Footer.php'; ?>