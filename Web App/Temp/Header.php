<?php include_once 'temp/global.php'?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Online Portal | North South University</title>
    <meta name="description" content="NSU Student Information Management System" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap/font-awesome.min.css" />
    <link rel="stylesheet" href="css/bootstrap/chosen.min.css" />
    <link rel="stylesheet" href="css/bootstrap/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="css/bootstrap/main.css" />

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <link rel="stylesheet" type="text/css" href="css/Change_E_Wallet_Pin.css">
    <link rel="stylesheet" type="text/css" href="css/Create_E_Wallet.css">
    <link rel="stylesheet" type="text/css" href="css/Check_Balance.css">
    <link rel="stylesheet" type="text/css" href="css/Off_Transaction.css">
    <link rel="stylesheet" type="text/css" href="css/Transaction_History.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/main.min.js"></script>

</head>

<body class="no-skin ">

    <div id="navbar" class="navbar navbar-default navbar-collapse student-header">
        <div class="navbar-container  container" id="navbar-container">
            <div class="navbar-header pull-left">
                <a href="#" class="navbar-brand">
                    <img src="Imgs/logo-wide.png" style="max-width:340px">
                </a>
                <button class="pull-right navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#sidebar">
                    <span class="sr-only">Toggle sidebar</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

        </div>
        <div class="clearfix"></div>
    </div>
    <div class="main-container ace-save-state " id="main-container">
        <div id="sidebar" class="sidebar h-sidebar navbar-collapse collapse ace-save-state">
            <ul class="nav nav-list">
                <li class="hover blank" style="width:189px">&nbsp;</li>
                <li class="hover">
                    <a href="Home.php">
                        <i class="menu-icon fa fa-home"></i>
                        <span class="menu-text">Home</span>
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="hover  ">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-user"></i>
                        <span class="menu-text"> Profile </span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="hover">
                            <a href="home.php">
                                <i class="menu-icon fa fa-caret-right"></i> Student Information
                            </a>

                            <b class="arrow"></b>
                        </li>

                    </ul>
                </li>
                <li class="hover  ">
                    <a href="#">
                        <i class="menu-icon fa fa-money"></i>
                        <span class="menu-text">Payments</span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                    <?php
                    $status = $_SESSION['flag'] == 1?"Off":"On";
                    $site = $status."_Transaction.php";
                    if($_SESSION['qstn'] == '')echo '
                        <li class="hover">
                            <a href="Create_E_Wallet.php">
                                <i class="menu-icon fa fa-caret-right"></i> Create E_Wallet
                            </a>

                            <b class="arrow"></b>
                        </li> '; 
                        
                       else echo "
                        <li class='hover'>
                            <a href='$site'>
                                <i class='menu-icon fa fa-caret-right'></i> $status Transaction
                            </a>

                            <b class='arrow'></b>
                        </li>
                        <li class='hover'>
                            <a target='_blank' href='Check_Balance.php'>
                                <i class='menu-icon fa fa-caret-right'></i> Check Balance
                            </a>

                            <b class='arrow'></b>
                        </li>
                        <li class='hover'>
                            <a href='Transaction_History.php'>
                                <i class='menu-icon fa fa-caret-right'></i> Transaction History
                            </a>

                            <b class='arrow'></b>
                        </li>
                        <li class='hover'>
                            <a href='Change_E_Wallet_Pin.php'>
                                <i class='menu-icon fa fa-caret-right'></i> Change E_Wallet Pin
                            </a>

                            <b class='arrow'></b>
                        </li>"; 
                        
                        ?>


                    </ul>
                </li>





                <li class="hover">
                    <a href="home.php?out=true">
                        <i class="menu-icon fa fa-power-off"></i>
                        <span class="menu-text">Logout</span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>
                </li>
            </ul>
            <!-- /.nav-list -->
        </div>