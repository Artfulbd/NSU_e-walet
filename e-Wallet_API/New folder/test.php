<?php
    $unique = substr(hash('sha256', mt_rand() . microtime()), 0, 15);
    echo "*".$unique."*".strlen($unique);

?>