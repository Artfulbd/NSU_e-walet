<?php
    $username = '';
    $key = 12345;
    $loginURL = "http://localhost/eWalletAPI/rds/login.php";
    $createURL = "http://localhost/eWalletAPI/e_wallet/createacc.php";
    $switchURL = "http://localhost/eWalletAPI/e_wallet/switchTrans.php";
    $balanceURL = "http://localhost/eWalletAPI/e_wallet/balance.php";
    $changeURL = "http://localhost/eWalletAPI/e_wallet/changePin.php";
    $allHisURL = "http://localhost/eWalletAPI/e_wallet/viewAllHis.php";
    $singleHisURL = "http://localhost/eWalletAPI/e_wallet/singleHistory.php";

    $GLOBALS['id'] = '';
    $GLOBALS['pass'] = '';
    $GLOBALS['name'] = '';
    $GLOBALS['address'] = '';
    $GLOBALS['flag'] = '';
    $GLOBALS['qstn'] = '';
    $GLOBALS['success'] = '';
        function make_req($url, $load ){
        //url-ify the data for the POST
            $json_string = json_encode($load);

            //open connection
            $ch = curl_init();

            //set the url, number of POST vars, POST data
            curl_setopt($ch,CURLOPT_URL, $url);
            curl_setopt($ch,CURLOPT_POST, true);
            curl_setopt($ch,CURLOPT_POSTFIELDS, $json_string);

            //So that curl_exec returns the contents of the cURL; rather than echoing it
            curl_setopt($ch,CURLOPT_RETURNTRANSFER, true); 

            //execute post
            $result = curl_exec($ch);
            return $result;
        }
?>
