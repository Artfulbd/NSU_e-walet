<?php
 
    $email = $pass = '';
    $errors = array('name' => '', 'pass' => '');
    if(isset($_POST['submit'])){
      $name = $_POST['name'];
      $pass = $_POST['pass'];
      if(empty($_POST['name'])){
        $errors['name'] = 'ID is required';
      } 
      if(empty($_POST['pass'])){
        $errors['pass'] = 'Password is required';
      }

      if(!array_filter($errors))
      {
        
        include_once 'Temp/global.php'; 
             //echo $res[0]['name'];
         $load = [
         'key' => $key,
         'id' => $_POST['name'] ,
         'pass' => $_POST['pass'] ];
        $res = make_req($loginURL, $load );
        if(strlen($res) == 28){
            $errors['pass'] = $res;
        }else if(strlen($res) <=20){
            $errors['pass'] = "wrong password";
        }else{
           
            $res = json_decode($res, true);
            if(strlen($res['ststus'],'invalid')){
                $errors['pass'] = "wrong password";
            }else{
                session_start();
                $_SESSION['pass'] = $_POST['pass'];
                $_SESSION['id'] = $_POST['name'];
                $_SESSION['name'] = $res['name'];
                $_SESSION['address'] = $res['add'];
                $_SESSION['flag'] = $res['flag'];
                $_SESSION['qstn'] = $res['qstn'];
                $_SESSION['success'] = "";
                header('Location: home.php');
            }
            

        }
          
      }

    }// end of postcheck
 ?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <title>NSU Portal | North South University</title>
    <link rel="stylesheet" href="https://rds3.northsouth.edu/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://rds3.northsouth.edu/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://rds3.northsouth.edu/assets/css/login-style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script type="text/javascript" src="https://rds3.northsouth.edu/assets/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="https://rds3.northsouth.edu/assets/js/login.js"></script>
    <script type="text/javascript">
    var ctoday = 1575734021000;
    </script>
</head>

<body>
    <div id="navbar" class="navbar navbar-default navbar-collapse faculty-header">
        <div class="navbar-container  container" id="navbar-container">
            <div class="navbar-header pull-left">
                <a href="#" class="navbar-brand">
                    <img src="imgs/logo-wide.png" style="max-width:340px">
                </a>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>

    <div class="main-container ace-save-state container" id="main-container">
        <div class="page-content main-content">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 text-center" style="margin-top:20px;margin-bottom:20px;">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3">
                    <div class="login-form">
                        <h3>RDS</h3>
                        <div class="row">
                            <div class="col-md-3 text-center">
                                <img src="imgs/login.png" width="80" height="80" style="margin-top:10px;">
                            </div>
                            <div class="col-md-9">
                                <form method="post" action="#">

                                    <p class="headings">NSU Portal : Login<br /><br /></p>
                                    <div class="row">
                                        <div class="col-md-3">Username</div>
                                        <div class="col-md-9">
                                            <div class="form-group ">
                                                <input type="text" name="name" maxlength="10" class="form-control"
                                                    placeholder="Enter your NSU id" id="UserName" autofocus
                                                    >
                                                <i class="fa fa-user"></i>
                                                <div><?php echo $errors['name']; ?></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3">Password</div>
                                        <div class="col-md-9">
                                            <div class="form-group ">
                                                <input type="password" name="pass" class="form-control"
                                                    placeholder="Enter your password" id="password" autofocus
                                                    >
                                                <i class="fa fa-lock"></i>
                                                <div><?php echo $errors['pass']; ?></div>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" name="submit" value="Submit"
                                        class="btn btn-success pull-right" />
                                    <div class="clearfix" style="margin-bottom:10px;"></div>
                                </form>

                            </div>
                        </div>
                        <div class="clearfix"></div>
                    

                        </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="footer-inner">
                    <div class="footer-content">
                        <span class="blue">Developed &amp; Maintained By Full_of_BUGS</span>
               </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>