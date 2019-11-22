<?php
    class purData {
        public $data;
        public $sec;
        public $list;
        public $ano;

        // post request to bank server, cURL
        function purchase_req($url, $key, $from, $to, $am, $load ){   
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
    }  

    class tools {
        private $beg = "giveIds ";  //space mandatory
        function isBeg($in) {
            return (strcmp($this->dec($in), $this->beg) == 0)? true: false;
        }
        function give_data($xData){
            $xData->data = $this->dec($xData->data);
            $xData->sec = $this->dec($xData->sec);
            $xData->list = $this->dec($xData->list);
            $xData->ano = $this->dec($xData->ano);
            return $xData;
        }
        function gen_trid(){
            $new_trid = substr(hash('sha256', mt_rand() . microtime()), 0, 15);
            return $new_trid;
        }

        function test_input($data) {
            $holdOn = $data;
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return strcmp($holdOn,$data)? false : true;
        }

        private function enc($t){
            $main = "";
            $store = "";
            $s = explode(" ", $t);  // substring
            $r; $h; $l;
            foreach ($s as $st) {
                $l = strlen($st);
                for($i = 0; $i < $l; $i++){
                    $r = rand(95,123);
                    $h = ord($st[$i]);  //charat
                    $h = ($h + $r) % 127;
                    $store = $store.strval($r)." ".strval($h)." ";
                }
                $main =$main.$store."| ";
                $store = "";
            }
            return $main;
        }
    
        private function dec($t){
            $b = true;
            $main = ""; $h1 = ""; $h2 = "";
            $s = explode(" ", $t);
            $i = 0; $h = 0; $ho = 0;
            try {
                foreach($s as $st){
                    if(strcmp($st,"|") == 0) $main = $main." ";
                    else{
                        if($i % 2 == 0)$h1 = $st;
                        else{
                            $h2 = $st;
                            $ho = intval($h1);
                            $h = (127 - $ho ) + intval($h2);
                            if($ho < 94 || $ho > 123 ){
                                $b = false;
                                break;
                            }
                            if($h == 137 || $h == 10) $main = $main.'<br>';
                            else $main = $main.chr($h);
                        }
                        $i++;                    
                    }
    
                }
              }catch(Exception $e) {
                    $b = false;
              }
              if($b && strcmp($main,"") != 0)return $main;
              else return " Wrong code...";
    
        }
   }
    
?>