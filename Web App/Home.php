
<?php
    
    if (isset($_GET['out'])) {                 /// log out
        $_SESSION['pass'] ='';
        $_SESSION['id'] = '';
        $_SESSION['name'] = '';
        $_SESSION['address'] = '';
        $_SESSION['flag'] = '';
        $_SESSION['qstn'] = '';
        session_destroy();
        header('Location: index.php');
    }
    session_start();
    include_once 'Temp/Header.php';
    
    if($_SESSION['name'] == ''){
        header('Location: index.php');
    }
    
    $success = $_SESSION['success'];
    $name = $_SESSION['name'];
    $studentId = $_SESSION['id'];



?>

<!-- Html Starts -->


<?php  ?>

    </div>
<script type="text/javascript">
    </script>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        Welcome &nbsp;<?php echo $name;?>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<?php echo "<div float:center;>$success</div>";?></h1>
                </div>
                <div class="row">
                    
                    <div class="clearfix"></div>
                    <div class="col-xs-12">
                                                <div id="user-profile-1" class="user-profile row">
                            <div class="col-xs-12 col-sm-4 center">
                                <div>
                                    <span class="profile-picture"><img id="avatar" class="editable img-responsive"
                                    alt="Avatar" src="https://rds3.northsouth.edu/assets/images/avatars/profile-pic.jpg"
                                    width="160"/></span>
                                    <div class="space-4"></div>
                                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                        <div class="inline position-relative">
                                            <a href="#" class="user-title-label">
                                                <span class="white">&nbsp;<?php echo $name; ?>&nbsp;&nbsp;</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="space-6"></div>
                                <div class="profile-contact-info">
                                    <div class="profile-contact-links align-left">
                                        <a href="#" class="btn btn-link">
                                            <i class="ace-icon fa fa-cog bigger-120 green"></i>
                                            <?php echo $studentId; ?>
                                        </a>

                                        <a href="#" class="btn btn-link">
                                            <i class="ace-icon fa fa-envelope bigger-120 pink"></i>
                                            <?php echo $studentId."@northsouth.edu"; ?>
                                        </a>
                                        <a href="#" class="btn btn-link">
                                            <i class="ace-icon fa fa-globe bigger-125 blue"></i>
                                            Degree: BS in CSE
                                        </a>
                                        <a href="#" class="btn btn-link">
                                            <i class="ace-icon fa fa-book bigger-125 green"></i>
                                            Curriculum Name: BS in CSE - 130 Credit Curriculum
                                        </a>
                                    </div>

                                    

                                </div>

                            </div>





                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
