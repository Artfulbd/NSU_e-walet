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


  <div class="page-header">
    <h1 align="center">Change Your E_Wallet Pin</h1>
  </div>

  <form class="form-horizontal" action="#" method="post" >
   


      
   
             <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Old e_Wallet Pin : </label>

                <div class="col-sm-9">
                    <input type="password"  placeholder="Pin" class="col-xs-10 col-sm-5"
                    name="old" required />
                </div>
            </div>
             <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> New e_Wallet Pin : </label>

                <div class="col-sm-9">
                    <input type="password"  placeholder="Pin" class="col-xs-10 col-sm-5"
                    name="pin1"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Re-enter pin : </label>

                <div class="col-sm-9">
                    <input type="password"  placeholder="Confirm Wallet Pin" class="col-xs-10 col-sm-5"
                           name="pin2"/>
                </div>
            </div>
            
            <div class="col-sm-4 text-justify" style="margin-left: 25%">
                    <span style="color:red; font-weight: bold"><?php echo $er;?></span>
                </div>
            <br>
            
             <div class="space-16"></div>

            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-2">  </label>



                <div class="col-sm-9">
                    <!-- Security Question -->
                    <h2 style="color:#FFC300"><?php echo $_SESSION['qstn']; ?></h2>

       
                </div>
                

                                </div>
            
            
            
            
            
            
            

      

      <div class="space-4"></div>
      
     <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Enter answer carefully :</label> 
      
                 <div class="col-sm-9">
                    <input type="text" placeholder="Enter here" class="col-xs-10 col-sm-5"
                    name="ans" required>
                </div>
                <div class="col-sm-4 text-justify" style="margin-left: 25%">
                    <span class="middle">Note : <span style="color: green;font-weight: bold">Enter your answer Carefully.</span></span>
                </div>
      
     
      </div>

      <div class="space-4"></div>


            <div class="clearfix form-actions">
                <div class="col-md-offset-5 col-md-6">
                    <input type="submit" name="commit" value=" Confirm " class="btn btn-info"/>
                </div>
            </div>

   
  </form>
<?php include 'Temp/Footer.php'; ?>