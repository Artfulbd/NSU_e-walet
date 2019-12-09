 <?php
    if(isset($_POST['commit']))
    {
      $rdsPass1 = $_POST['rdsPass1'];
      $newWalletPin1 = $_POST['newWalletPin1'];
      $confirmWalletPin1 = $_POST['confirmWalletPin1'];


      //database connection
      $conn= new mysqli('localhost','root','','test');
      if ($conn->connect_error)
        {
          die('Connection Failed : '.$conn->connect_error);
        }
      else 
        {
          $stmt = $conn->prepare("insert into create_e_wallet(rdsPass,newWalletPin,confirmWalletPin) values(?,?,?) ");
          $stmt->bind_param("sii",$rdsPass1,$newWalletPin1,$confirmWalletPin1);
          $stmt->execute();
          echo "Wallet Created Successfully";
          $stmt->close();
          $conn->close();
        }
    }
      	

  ?>



<!-- Html Starts -->


<?php include 'Temp/Header.php'; ?>



<form action="Create_E_Wallet.php" method="POST" autocomplete="on">
<fieldset>
<div class="infoBox" align="center">
  <div class="page-header">
        <h1>Sign up for E Wallet</h1>
  </div>
  Enter Your RDS Password:<br>
  <input type="Password" name="rdsPass1" required><br>
  Enter Your New Pin for E Wallet:<br>
  <input type="Password" name="newWalletPin1" required><br>
  Confirm Pin for E Wallet:<br>
  <input type="Password" name="confirmWalletPin1" autocomplete="off" required><br> 
  <br>
  <p><input type="submit" name="commit" value=" Save " class="btn btn-info"></p>
</div>
  <br>
	
        
  

</fieldset>
</form>

<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
