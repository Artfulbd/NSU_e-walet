 <?php
      $rdsPass = $_POST['rdsPass'];
      $oldWalletPin = $_POST['oldWalletPin'];
      $newWalletPin = $_POST['newWalletPin'];
      $confirmWalletPin = $_POST['confirmWalletPin'];
      $securityQuestion = $_POST['securityQuestion'];
      $securityQuestionAnswer = $_POST['securityQuestionAnswer'];
      //database connection
      $conn= new mysqli('localhost','root','','test');
      if ($conn->connect_error)
        {
          die('Connection Failed : '.$conn->connect_error);
        }
      else {
        $stmt = $conn->prepare("insert into change_e_wallet_pin(rdsPass,oldWalletPin,newWalletPin,confirmWalletPin,securityQuestion,securityQuestionAnswer) values(?,?,?,?,?,?) ");
        $stmt->bind_param("siiiss",$rdsPass,$oldWalletPin,$newWalletPin,$confirmWalletPin,$securityQuestion,$securityQuestionAnswer);
        $stmt->execute();
        echo "Pin Changed Successfully";
        $stmt->close();
        $conn->close();
      }

  ?>






<!-- Html Starts -->


<?php include 'Temp/Header.php'; ?>

<form action="Change_E_Wallet_Pin.php" method="post" >
<fieldset>
  <legend>Required information for Changing Pin</legend>
  <h2>Change Your E_Wallet Pin</h2>
  Enter Your RDS Password:<br>
  <input type="Password" name="rdsPass" required><br>
  Enter Your old E Wallet Pin:<br>
  <input type="Password" name="oldWalletPin" required><br>
  Enter Your New Pin for E Wallet:<br>
  <input type="Password" name="newWalletPin" required><br>
  Confirm Pin for E Wallet:<br>
  <input type="Password" name="confirmWalletPin"required><br>
    Enter Your Security Question : <br>
    <textarea name="securityQuestion" rows="2" cols="30" required></textarea><br>
    Enter Your Security Question's Answer: <br>
    <textarea name="securityQuestionAnswer" rows="2" cols="30" required></textarea><br>

  <input type="submit" value="Submit"><br>
</fieldset>
</form>


<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->