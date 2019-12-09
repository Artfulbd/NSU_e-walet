 <?php
  if(isset($_POST['submit']))
  {
      $walletPin = $_POST['walletPin'];

      //database connection
      $conn= new mysqli('localhost','root','','test');
      if ($conn->connect_error)
        {
          die('Connection Failed : '.$conn->connect_error);
        }
      else 
        {
          $stmt = $conn->prepare("insert into off_Transaction(walletPin) values(?) ");
          $stmt->bind_param("i",$walletPin);
          $stmt->execute();
          echo "Transaction Stopped Successfully";
          $stmt->close();
          $conn->close();
        }


  }
		  
  ?>




<!-- Html Starts -->


<?php include 'Temp/Header.php'; ?>


  <form action="Off_Transaction.php" method="POST">

         <fieldset>
              <div class="infoBoxOffTransaction">
                <div class="page-header"><h2>Enter Your E_Walltet Pin to Stop transaction</h2></div>
                <p>
                E_Wallet Pin :
                <input type="Password" name="walletPin" required>
                </p>
                <p>Note : By pressing submit you will be no loger further avaiable for transaction</p>
              </div>


              <div class="col-md-offset-5 col-md-6">
                  <input type="submit" name="commit" value=" Off_Transaction " class="btn btn-info">
              </div>

        </fieldset>
  </form>

<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
