<?php 
session_start();
if(!isset($_SESSION['user_id']) || time() - $_SESSION['login_time'] > 1800) {
	echo "Your session has expired. Please login again.";

}	
else {
	$username = "lindseywingate";
	$password = "password";
	$database = "lindseywingate";
	$host = "mysqldev.aero.und.edu";

	$conn = mysql_connect( $host, $username, $password );
	mysql_select_db( $database, $conn );
	$user = $_SESSION['user_id'];

	$query_p = "select name, id from users where username = '$user'";
	$name = mysql_query($query_p);
	$n = mysql_result($name, 0, 'name');
	$a = mysql_result($name, 0, 'id');
	

	echo  "
	<html>
		<h2>Customer Homepage</h2>
		<hr>
		<h3>Personal Information</h3>
		Name: $n<br> 
		User Identification Number: $a<br>
		<hr>
		<h3>Book History</h3> 
		";
		$query_b = "select * from purchases where customername = '$user'";
		$books = mysql_query($query_b);
		$num = mysql_numrows($books);
		$i = 0;
		$total = 0;
		while($i<$num) {
			$title = mysql_result($books, $i, 'title');
			$price = mysql_result($books, $i, 'price');
			$ISBN  = mysql_result($books, $i, 'ISBN');
			$quantity = mysql_result($books, $i, 'quantity');
			$id = mysql_result($books, $i, 'id');
			$total = $total + $price*$quantity;
			$i++;
			echo $quantity ."     <a href='listbookdetails_C.php?isbn=$ISBN'>$title</a><br>"; 
		}
		echo "<br>Total: \$$total";	
		echo "	
		<hr>
		<form method='post' action='listtitles_C.php'>
		<h3>Search by Book Title:<h3>
		<input type='text' size='32' name='title' value='Web'>
			<input type='submit' name='act' value='Search'> 
		</form> 
		<br><hr>
		<h3>Other</h3>
		<form method='post' action='shoppingcart_C.php'>
			<input type='submit' name='act' value='View Shopping Cart'>
		</form>
		<form method='post' action='logout.php'>
			<input type='submit' name='logout' value='Logout'>
		</form>
	    <button><a href='userhome.php' download>Show Source</a></button><br><br>	
	</html>
";

#list their own info (id, name, hyperlinked titles and quantities of purchased books, and total amount spent on books

#show details of a book by clicking on linked titles (isbn, title, and price)

}
?>
