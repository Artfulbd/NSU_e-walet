 <?php
 if(isset($_POST["Commit"]))
 {
    //connect_establishing
    /* Attempt MySQL server connection. Assuming I am running MySQL
    server with default setting (user 'root' with no password) */
    $conn = mysqli_connect("localhost", "root", "", "test");
    // Check connection
    if($conn === false)
    {
     die("ERROR: Could not connect. " . mysqli_connect_error());
   }
   else
   { 
     $rdsPass = mysqli_real_escape_string($conn,$_POST['rdsPass']);
     $oldWalletPin =  mysqli_real_escape_string($conn,$_POST['oldWalletPin']);
     $newWalletPin =  mysqli_real_escape_string($conn,$_POST['newWalletPin']);
     $confirmWalletPin =  mysqli_real_escape_string($conn,$_POST['confirmWalletPin']);
     $securityQuestion =  mysqli_real_escape_string($conn,$_POST['securityQuestion']);
     $securityQuestionAnswer =  mysqli_real_escape_string($conn,$_POST['securityQuestionAnswer']);


     $sql="INSERT into change_e_wallet_pin (rdsPass,oldWalletPin,newWalletPin,confirmWalletPin,securityQuestion,securityQuestionAnswer) VALUES ('$rdsPass','$newWalletPin','$confirmWalletPin','$securityQuestion','$securityQuestionAnswer');";
     if (mysqli_query($conn,$sql))
     {
       echo "Records Added Successfully";
     }
     else{
      echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);
    }
     // close connection
    mysqli_close($conn);

  }
}


?>






<!-- Html Starts -->


<?php include 'Temp/Header.php'; ?>

<div class="Change_E_Wallet_Pin">
  <div class="page-header">
    <h1>Change Your E_Wallet Pin</h1>
  </div>

  <form action="Change_E_Wallet_Pin.php" method="post" >
    <fieldset>


      Enter Your RDS Password:<br>
      <div class="col-sm-9">
        <input type="password" placeholder="RDS Password" class="col-xs-10 col-sm-5" name="rdsPass" required>
      </div><br>
      <br>
      Enter Your old E Wallet Pin:<br>
      <div class="col-sm-9">
        <input type="password" placeholder="Old Wallet Pin" class="col-xs-10 col-sm-5" name="oldWalletPin" required>
      </div><br>
      <br>

      Enter Your New Pin for E Wallet:<br>
      <div class="col-sm-9">
        <input type="password" placeholder="New Wallet Pin" class="col-xs-10 col-sm-5" name="newWalletPin" required>
      </div><br>
      <br>

      Confirm Pin for E Wallet:<br>
      <div class="col-sm-9">
        <input type="password" placeholder="Confirm Wallet Pin" class="col-xs-10 col-sm-5" name="confirmWalletPin" required>
      </div><br>
      <br>

      Enter Your Security Question : <br>
      <div class="col-sm-9">
        <textarea name="securityQuestion" placeholder="Enter Your Security Question" rows="2" cols="55" required></textarea><br>
      </div><br>
      <br>

      <br>
      Enter Your Security Question's Answer: <br>
      <div class="col-sm-9">
        <textarea name="securityQuestionAnswer" placeholder="Enter Your Security Question Answer" rows="2" cols="55" required></textarea><br>
      </div><br>
      <br>


      <div class="col-md-offset-5 col-md-6">
        <input type="submit" name="commit" value=" Save " class="btn btn-info">
      </div>

    </fieldset>
  </form>
</div>



<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
