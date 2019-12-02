 <?php 
		    $walletPin = $_POST['walletPin'];      
      
      //database connection
      $conn= new mysqli('localhost','root','','test');
      if ($conn->connect_error)
        {
          die('Connection Failed : '.$conn->connect_error);
        }
      else {
        $stmt = $conn->prepare("insert into off_Transaction(walletPin) values(?) ");
        $stmt->bind_param("i",$walletPin);
        $stmt->execute();
        echo "Transaction Stopped Successfully";
        $stmt->close();
        $conn->close();
      }

  ?>




<!-- Html Starts -->


<?php include 'Temp/Header.php'; ?>


  <form action="Off_Transaction.php" method="POST">
        
         <fieldset>


                <h2>Enter Your E_Wallte Pin to Stop transaction</h2> 
                E_Wallet Pin :
                <input type="Password" name="walletPin" required><br>
                Note : By pressing submit you will be no loger further avaiable for transaction<br>
                <input type="submit" value="Submit"><br>

            

        </fieldset>
  </form>

<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->