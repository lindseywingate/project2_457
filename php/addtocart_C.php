<?php
session_start();
if(!isset($_SESSION['user_id']) || time() - $_SESSION['login_time'] > 1800) {
	echo "Your session has expired. Please login again.";
	header("Location: people.aero.und.edu/~lwingate/457/exercise1/login.php");
}
else {
	$user =$_SESSION['user_id'];
//search database books for user
//if duplicate books, no action
//list all books from database and selected
//have option to change number of books in input
//show up to date amount

	$username = "lindseywingate";
    $password = "password";
    $database = "lindseywingate";
    $host     = "mysqldev.aero.und.edu";
    $conn = mysql_connect( $host, $username, $password );
    mysql_select_db( $database, $conn );

	$bookstoadd = $_POST['books'];

	var_dump($bookstoadd);
	echo "<br>";

	$c = 1;
	foreach($bookstoadd as $book) {
		$query = "select title, price, ISBN from books where ISBN = '$book'";
		$result = mysql_query($query) or die();
		$num = mysql_numrows($result);
		$i=0;

		while($i<$num) {
			$row=mysql_result($result, $i, 'title');
			$price=mysql_result($result, $i, 'price');
			$ISBN=mysql_result($result, $i, 'ISBN');
			$i++;	
			$query = "insert into shoppingcart (name, title, ISBN, price, quantity) VALUES ('$user', '$row', '$ISBN', $price, 1)";
			$result = mysql_query($query);	
		}
	}
	header("Location: http://people.aero.und.edu/~lwingate/457/exercise1/shoppingcart_C.php");
}
?>
