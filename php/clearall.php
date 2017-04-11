<?php
#this page clears all the data in the database system so Dr. Hu can test my system

if($_POST['clearall'] = "clearall" ) {
    $username = "lindseywingate";
    $password = "password";
    $database = "lindseywingate";
    $host        = "mysqldev.aero.und.edu";
 
    $conn = mysql_connect( $host, $username, $password );
    mysql_select_db( $database, $conn );

	$books = "truncate books";
	$purchases = "truncate purchases";
	$shoppingcart = "truncate shoppingcart";
	$users = "truncate users";

	mysql_query($books);
	mysql_query($purchases);
	mysql_query($shoppingcart);
	mysql_query($users);

	header("Location: http://people.aero.und.edu/~lwingate/457/exercise1/adminhome.php");
}


?>
