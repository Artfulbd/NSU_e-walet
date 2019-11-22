<?php

    class ConnectTo{
        private $host = 'localhost';
        private $user = 'root';
        private $pass = '';
        private $ewalletdb = 'ewalet';
        private $bankdb = '';
        private $link;
        function __construct($dbFor) {
            $db =  strcmp($dbFor,'wallet') ? (strcmp($dbFor,'bank')?'faulty' : $this->bankdb) : $this->ewalletdb;
            if(strcmp($db,'faulty'))$this->link = mysqli_connect($this->host , $this->user , $this->pass,$db) or die("cannot connect");
            else $this->link = null;
        }
        function giveLink(){
            return $this->link;
        }
        function init_transaction(){
                $mySqli = new mysqli($this->host , $this->user , $this->pass,$this->bankdb);
                return $mySqli;
        }
        
    }
 ?>
