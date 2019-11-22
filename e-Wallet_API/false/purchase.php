<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Headers: access");
    header("Access-Control-Allow-Methods: GET");
    header("Access-Control-Allow-Credentials: true");
    header('Content-Type: application/json');
    include_once '../personal/nirapotta.php';

    //$link = mysqli_connect('localhost' , 'root' , '', 'ewalet') or die("cannot connect");

    
        $mykit = new tools;
        $cmd = "115 91 99 77 117 108 109 83 123 69 118 91 114 102 | ";
        $cmd = $mykit->dec($cmd);
        echo $cmd;
        
    
  
?>