<?php
#This page lists all the books by title with their ISBN #'s and price
#The admin can click the book and see all the customers that have bought it

$user = "lindseywingate";
$pass = "password";
$database = "lindseywingate";
$host = "mysqldev.aero.und.edu";

$conn = mysql_connect ($host, $user, $pass); //Connect to database
mysql_select_db($database, $conn);

$query = 'select * from books order by title asc';
$result = mysql_query($query);


echo "
<h2>Books</h2>
<p>*Click on the hyperlinked titles to see the customers that have bought this book.</p>
";
while($row=mysql_fetch_assoc($result)) {
	foreach($row as $key=>$value) {
		if($key == 'title') {	
			echo "<a href='printcustomer.php?name=$value'>" .$key .": ".$value ."</a><br>";
		}
		else {
			echo $key .": ". $value . "<br>";
		}
	}
	echo "<br>";
}
echo "<button><a href='listbooks.php' download>Show Source</a></button><br><br>";
?>
