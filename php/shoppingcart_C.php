<?php
session_start();
$user = $_SESSION['user_id'];

$username = "lindseywingate";
$password = "password";
$database = "lindseywingate";
$host        = "mysqldev.aero.und.edu";

$conn = mysql_connect( $host, $username, $password );
mysql_select_db( $database, $conn );
echo "<h3>Shopping Cart</h3>";
echo "<form action='updatequantity_C.php' method='post'>";
$query = "select * from shoppingcart where name='$user'";
$result = mysql_query($query) or die();
$num = mysql_numrows($result);
$i = 0;
$total = 0;
while($i<$num) {
	$title=mysql_result($result, $i, 'title');
    $price=mysql_result($result, $i, 'price');
    $ISBN=mysql_result($result, $i, 'ISBN');
	$quantity=mysql_result($result,$i, 'quantity');
    $i++;   
	echo "<input type='text' name='post[$ISBN]' value=$quantity size=2>".$title."<br>";
	$total = $total + $price*$quantity;
}
echo "
<br>Total: \$$total<br><br>
<input type='submit' value='Submit Changes'></form>
<form method='post' action='checkout_C.php'>
	<input type='submit' value='Checkout'>
</form>
<form method='post' action='userhome.php'>
	<input type='submit' value='Home'>
</form>
<button><a href='shoppingcart_C.php' download>Show Source</a></button><br><br>";

?>
