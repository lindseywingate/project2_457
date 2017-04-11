<?php
$customername=$_GET['name'];

$user = "lindseywingate";
$pass = "password";
$database = "lindseywingate";
$host = "mysqldev.aero.und.edu";

$conn = mysql_connect ($host, $user, $pass); //Connect to database
mysql_select_db($database, $conn);

$query = "Select p.title, p.quantity, p.ISBN from purchases p where p.customername = '$customername'";
$result = mysql_query($query);

while($row=mysql_fetch_assoc($result)) {
    foreach($row as $key=>$value) {
		echo $key .": ". $value . "<br>";
    }
    echo "<br>    <button><a href='login.php' download>Show Source</a></button><br><br>";
}
?>
