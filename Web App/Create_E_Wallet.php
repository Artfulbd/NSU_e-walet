<?php
    session_start();
    if($_SESSION['name'] == ''){
      header('Location: index.php');
    }   
    $ansEr = "";
    $pinEr = "";
  if(isset($_POST['submit']))
  {
      $pin1 = $_POST['pin1'];
      $pin2 = $_POST['pin2'];
      $ans1 = $_POST['ans1'];
      $ans2 = $_POST['ans2'];  
      if(strlen($pin1) != 4){
        $pinEr = "Pin length must be 4 digit long !";
      }else if(!is_numeric($pin1)){
        $pinEr = "Pin can only be number!";
      } else if(strcmp($pin1,$pin2) == 0 && strcmp($ans1,$ans2) == 0){  // means valid
        // call here
        include_once 'Temp/global.php';
        $load = [
          'key' => $key,
          'id' => $_SESSION['id'] ,
          'pass' =>$_SESSION['pass'],
          'pin' => $_POST['pin1'],
          'qstn'  => $_POST['qstn'] ,
          'ans' =>$_POST['ans1']
        ];
        $res = make_req($createURL, $load );                     
        if(strlen($res) == 15){
          $res = json_decode($res, true);
          if(strcmp($res['status'],'ok') == 0){
            $_SESSION['success'] = "e-Wallet account ceated successfully";
            $_SESSION['flag'] = 1;
            $_SESSION['qstn'] =  $_POST['qstn'];
          }else{
            $_SESSION['success'] = $res['status'];
          }
            
        }else{
          $_SESSION['success'] = $res;
        } // end of valid

        header('Location: home.php');
      }else if(strcmp($pin1,$pin2) != 0 && strcmp($ans1,$ans2) == 0){
          $pinEr = "Pin doesn't match !";
      }
      else if(strcmp($pin1,$pin2) == 0 && strcmp($ans1,$ans2) != 0){
          $ansEr = "Answer doesn't match !";
      }else{
          $ansEr = "Answer doesn't match !";
          $pinEr = "Pin doesn't match !";
      }
}


?>



<!-- Html Starts -->


<?php include_once 'Temp/Header.php'; ?>



<form action="#" method="POST">
  <fieldset>
    <div class="infoBox">
      <div class="page-header">
        <h1>Sign up for E Wallet</h1>
      </div>
      
      Enter Your Pin for E Wallet:<br>
      <input type="Password" placeholder="must be 4 digit" name="pin1" required>
      <br>
      <br>
      Confirm Pin :<br>
      <input type="Password" placeholder="must be 4 digit"  name="pin2" required> 
      <br>
       <span style="color:red; font-weight: bold"><?php echo $pinEr;?></span>
      
      <br> 
      <br>
      Enter Your Security Question :<br>
      <textarea name="qstn" placeholder="Enter Your Security Question" rows="2" cols="55"  required></textarea>
      <br>
      <br>
      Enter Your Security Question's Answer: <br>
      <textarea name="ans1" placeholder="Enter answer here" rows="2" cols="55"  required></textarea>
      <br>
      <br>
      Re-enter Security Question's Answer: <br>
      <textarea name="ans2" placeholder="Re-nter answer here" rows="2" cols="55"  required></textarea>
      <br>
      <span style="color:red; font-weight: bold"><?php echo $ansEr;?></span>
      <br>
      <br>
      <p><input type="submit" name="submit" value=" Create " class="btn btn-info"></p>
    </div>
    <br>




  </fieldset>
</form>

<?php include 'Temp/Footer.php'; ?>