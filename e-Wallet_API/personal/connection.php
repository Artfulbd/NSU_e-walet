<?php

    class ConnectTo{
        private $host = 'localhost';
        private $user = 'nfb_artful';
        private $pass = '#include<stdio.s>';
        private $ewalletdb = 'nfb_ewallet';
        private $bankdb = 'nfb_bank';
        private $link;
        function __construct($dbFor) {
            $db =  strcmp($dbFor,'wallet') ? (strcmp($dbFor,'bank')?'faulty' : $this->bankdb) : $this->ewalletdb;
            if(strcmp($db,'faulty'))$this->link = mysqli_connect($this->host , $this->user , $this->pass,$db) or die("cannot connect");
            else $this->link = null;
        }
        function giveLink(){
            return $this->link;
        }
        function detach(){
            mysqli_close($this->link);
        }
        
    }
 ?>