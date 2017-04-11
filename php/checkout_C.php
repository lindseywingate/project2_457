<?php
session_start();
$user = $_SESSION['user_id'];
$username = "lindseywingate";
$password = "password";
$database = "lindseywingate";
$host  = "mysqldev.aero.und.edu";

$conn = mysql_connect( $host, $username, $password );
mysql_select_db( $database, $conn );

//get data from shopping cart
$query = "select * from shoppingcart where name = '$user'";
$result = mysql_query($query) or die();
//get userid
$query2 = "select id from users where username='$user'";
$result2 = mysql_query($query2) or die();
$num = mysql_numrows($result);
$id = mysql_result($result2, 0, 'id');
$i = 0;
//add entries from shopping cart to purchases table
while($i<$num) {
	$ISBN=mysql_result($result, $i, 'ISBN');
	$title=mysql_result($result, $i, 'title');
    $quantity=mysql_result($result,$i, 'quantity');
	$name=mysql_result($result, $i, 'name');
	$price=mysql_result($result, $i, 'price');

	//check to see if entry for book already exists
	$exists = "select * from purchases where customername='$user' and ISBN = '$ISBN'";   
	$e_result = mysql_query($exists) or die();
	$x = mysql_numrows($e_result);
	if($x>0) {
		$query3 = "update purchases set quantity = quantity + $quantity where ISBN = '$ISBN'";
		$result3 = mysql_query($query3);
	}
	$query4 = "insert into purchases values ('$name', '$title', '$quantity', $price, '$ISBN', '$id')";
	$result4 = mysql_query($query4);
	$i++;
}
$clear_table = "delete from shoppingcart where name='$user'";
$results = mysql_query($clear_table);
header("Location: http://people.aero.und.edu/~lwingate/457/exercise1/userhome.php");
?>
