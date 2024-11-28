<?php
	$loadBalanceURL = "https://nfb.grayscalehost.com/eWalletAPI/BanglaBankApi/load.php";
	$msg = "";
	if(isset($_POST['load'])){
		if(is_numeric($_POST['id']) && is_numeric($_POST['am'])){
			$load = [
				'key' => '1234',
				'id' =>$_POST['id'],
				'am' =>$_POST['am']
			];
			include_once 'Temp/global.php';
			$res = make_req($loadBalanceURL, $load ); 
			if(strlen($res) == 7 ){
				$res = $_POST['am'];
				$msg = "Balance $res taka is loaded to mentioned ID's account.";
			}else{
				$msg = "Sorry, try again later.";
			}
		}else{
			$msg = "please fillup both field perfectly";
		}
		
	}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Bank Data</title>
</head>
</head>
<body>

	<title>Page Title</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		/* Style the body */
		body {
			font-family: Arial;
			margin: 0;
		}

		/* Header/Logo Title */
		.header {
			padding: 30px;
			text-align: center;
			background: #1abc9c;
			color: white;
			font-size: 30px;
		}

		/* Page Content */
		.content {padding:20px;}
	</style>
</head>
<body>

	<div class="header">
		<h1>Some Bank limited</h1>
		<p><?php echo $msg;?></p>
	</div>
	<body>
		<div class="form1" align="center">
		<form action="#" method="POST">
				<p>
					Enter User ID: 
					<input type="text" name="id">
				</p>
				<p>
					Enter Amount: 
					<input type="text" name="am">
				</p>
				<p>
					<input type="submit" value=" Load " name="load">
				</p>
			</form>		
		</div>
	</body>
	</html>