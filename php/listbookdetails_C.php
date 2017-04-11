<?php
$user = "lindseywingate";
$pass = "password";
$database = "lindseywingate";
$host = "mysqldev.aero.und.edu";

$conn = mysql_connect ($host, $user, $pass); //Connect to database
mysql_select_db($database, $conn);

$book=$_GET['isbn'];

$query = "select * from books where ISBN = '$book'";
$result = mysql_query($query);
while($row=mysql_fetch_assoc($result)) {
	foreach($row as $key=>$value) {
		echo $key .": ". $value . "<br>";
	}
	echo "<br>";
	echo"
	<form method='post' action='userhome.php'>
		<input type='submit' value='Back'>
	</form>
    <button><a href='listbookdetails_C.php' download>Show Source</a></button><br><br>
	";
}
?>
