 <?php
    session_start();
    $er = "";
    if(isset($_POST["commit"])){
      if(strlen($_POST["pin1"]) != 4 && strlen($_POST["old"]) != 4){
        $er = "Pin length must be 4 digit long !";
      }else if(!is_numeric($_POST["pin1"]) && !is_numeric($_POST["old"])){
        $er = "Pin can only be number!";
      }else if(strcmp($_POST["pin1"],$_POST["pin2"]) == 0 ){ // valid inpute
        include_once 'Temp/global.php';
        $load = [
          'key' => $key,
          'id' => $_SESSION['id'] ,
          'pass' =>$_SESSION['pass'],
          'pin' => $_POST['old'],
          'ans' =>$_POST['ans'],
          'new' =>$_POST["pin1"]
        ];
        $res = make_req($changeURL , $load);
        $sz = strlen($res);
        if($sz == 8){// get lost
          $_SESSION['success'] = "Problem on server, please try again later";
          header('Location: home.php');
        }else if( $sz == 19){
          $er = "Wrong pin or answer";
        }else{
          //valid
          $res = json_decode($res, true);
          if(strcmp($res['status'],'ok') == 0){
            $_SESSION['success'] = "e_Wallet pin changed successfully";
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
    
?>






<!-- Html Starts -->


<?php include 'Temp/Header.php'; ?>

<div class="Change_E_Wallet_Pin">
  <div class="page-header">
    <h1>Change Your E_Wallet Pin</h1>
  </div>

  <form action="#" method="post" >
    <fieldset>


      
   
      Enter old e_Wallet Pin:<br>
        <input type="password" placeholder="Old Wallet Pin" class="col-xs-10 col-sm-5" name="old" required>
     <br>
      <br>

      Enter New Pin:<br>
        <input type="password" placeholder="New Wallet Pin" class="col-xs-10 col-sm-5" name="pin1" required>
      <br>
      <br>

     Re-enter pin:<br>
     
        <input type="password" placeholder="Confirm Wallet Pin" class="col-xs-10 col-sm-5" name="pin2" required>
      <br>
      <br>

      <h1><?php echo $_SESSION['qstn']; ?></h1>

      <br>
      Enter answer carefully: <br>
      
        <textarea name="ans" placeholder="Enter Your Security Question Answer" rows="2" cols="55" required></textarea><br>
        <?php echo $er;?>
        <br>
      <br>


      <div class="col-md-offset-5 col-md-6">
        <input type="submit" name="commit" value=" Change " class="btn btn-info">
      </div>

    </fieldset>
  </form>
</div>



<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
