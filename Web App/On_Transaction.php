<?php
    session_start();
    $er = "";
    if($_SESSION['name'] == ''){
      header('Location: index.php');
    }  
    if(isset($_POST['commit']))
    {
      $pin = $_POST['pin'];
      $ans = $_POST['ans'];
      if(!is_numeric($_POST['pin']) || strlen($_POST['pin']) != 4){
        $er = "Pin must be valid";
      }else{
        include_once 'Temp/global.php';
        $load = [
          'key' => $key,
          'id' =>  $_SESSION['id'],
          'pass' =>$_SESSION['pass'],
          'pin' => $_POST['pin'],
          'curr'  => $_SESSION['flag'] ,
          'ans' =>$_POST['ans']
        ];
        $res = make_req($switchURL, $load ); 

        $sz = strlen($res);
        if($sz == 8 || $sz == 19){// get lost
          $_SESSION['success'] = "Problem on server, please try again later";
          header('Location: home.php');
        }else{
          //valid
          $res = json_decode($res, true);
          if(strcmp($res['status'],'ok') == 0){
            $_SESSION['success'] = "e-Wallet transaction switched off successfully";
            $_SESSION['flag'] = 1;
            header('Location: home.php');
          }else if(strcmp($res['status'],'invalid') == 0){
            $er = "Wrong pin or answer";
          }else{
            $_SESSION['success'] = $res['status'];
            header('Location: home.php');
          }

        }
      }
    }
    //echo $_SESSION['flag'];

?>




<!-- Html Starts -->


<?php include 'Temp/Header.php'; ?>


<form action="On_Transaction.php" method="POST">

 <fieldset>
        <div class="infoBoxOffTransaction">
          <h2>Enter Your E_Walltet Pin to on transaction</h2>
          <br>
          <br>
          E_Wallet Pin :
          <br>
          <input type="Password" name="pin" placeholder='Pin' equired>
          <div class:"noti"><?php echo $er;?></div>
          <br>
          <br>
          <h1><?php echo $_SESSION['qstn']; ?></h1>
          Enter your answer: <br>
          <textarea name="ans" placeholder="Answer" rows="2" cols="55" required></textarea>
          <br>
          <br>
          Note : By pressing submit you will be available for transaction again
          <br>
          <br>
          <div class="col-md-offset-5 col-md-6">
          <input type="submit" name="commit" value=" On_Transaction " class="btn btn-info">
          </div>

        </div>


        
</fieldset>
</form>

<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
