<?php 
    session_start();
    $allHisURL;
    include_once 'Temp/global.php';
        $load = [
          'key' => $key,
          'id' => $_SESSION['id'] ,
          'pass' =>$_SESSION['pass']
        ];
        
        $res = make_req($allHisURL , $load);
        $sz = strlen($res);
        if($sz == 8 || $sz == 19 || $sz == 28){// get lost
            $_SESSION['success'] = "Problem on server, please try again later";
            header('Location: home.php');
        }else{
            $res = json_decode($res, true);
        }
        
include_once 'Temp/Header.php'; ?>

<div align="center">
<?php

            if($res){
                echo "<table>";
                echo "<caption><h1>Transaction  History</h1></caption>";
                echo "<tr>";
                echo "<th>Sl no.</th>";
                echo "<th>Transaction ID</th>";
                echo "<th>Description</th>";
                echo "<th>Debit</th>";
                echo "<th>Credit</th>";
                echo "<th>Balance</th>";
                echo "<th>Transaction Date</th>";
                echo "<th>Show Details</th>";
                echo "</tr>";
                $i = 1;
                foreach ($res as $row){ 
                    $hold = $row['trid'];
                    echo "<tr>";
                    echo "<td>" . $i . "</td>";
                    echo "<td>" . $row['trid'] . "</td>";
                    echo "<td>" . $row['des'] . "</td>";
                    echo "<td>" . $row['deb'] . "</td>";
                    echo "<td>" . $row['crd'] . "</td>";
                    echo "<td>" . $row['bal'] . "</td>";
                    echo "<td>" . $row['trDate'] . "</td>";
                    if(strcmp($row['des'],'Balance credited') == 0){
                        echo "<td>"."no details"."<td>";
                    
                    }else{
                        echo "<td>"."<a href='singleHis.php?trid=$hold' target='_blank'>details</a>"."<td>";
                    
                    }
                      echo "</tr>";  
                    $i = $i + 1;    
                }
        echo "</table>";
        }else echo "<h1>Nothing to show</h2>";
?>
</div>

<?php include 'Temp/Footer.php'; ?>


<!-- Html Endss -->
