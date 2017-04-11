<?php
session_start();

$user = $_SESSION['user_id'];
$quantities = $_POST['post'];

$username = "lindseywingate";
$password = "password";
$database = "lindseywingate";
$host = "mysqldev.aero.und.edu";

$conn = mysql_connect( $host, $username, $password );
mysql_select_db( $database, $conn );

foreach($quantities as $q=>$u) {
	$query = "update shoppingcart set quantity=$u where ISBN='$q'";
	$result = mysql_query($query);
	echo "$q and quantity: $u<br>";	
}

$query1 = "delete from shoppingcart where quantity=0";
mysql_query($query1);

header("Location: http://people.aero.und.edu/~lwingate/457/exercise1/shoppingcart_C.php");

?>
