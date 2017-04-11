<?php
$title=$_GET['name'];

$user = "lindseywingate";
$pass = "password";
$database = "lindseywingate";
$host = "mysqldev.aero.und.edu";

$conn = mysql_connect ($host, $user, $pass); //Connect to database
mysql_select_db($database, $conn);

$query = "Select P.customername, U.id from purchases P, users U where U.name = P.customername and P.title = '$title';";
$result = mysql_query($query);

while($row=mysql_fetch_assoc($result)) {
    foreach($row as $key=>$value) {
        echo $key .": ". $value . "<br>";
    }       
    echo "<br>";
}
    echo"<button><a href='login.php' download>Show Source</a></button><br><br>";
?>
