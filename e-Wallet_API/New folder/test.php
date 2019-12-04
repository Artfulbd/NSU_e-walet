<?php
     $hold = '$2y$10$R66GKyXkjlLNKuHQqdhmTe1oBn3V3mCqW2enGxj2yHvCbZjHPX20S';
     $pass = "1234";
     $hash = password_hash($pass,PASSWORD_DEFAULT);
     //echo $hash.'<br>';
     if(password_verify($pass, $hold)){
         echo "Matched";
     }else{
         echo "NOt matched";
     } 

?>