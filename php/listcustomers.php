<?php

$user = "lindseywingate";
$pass = "password";
$database = "lindseywingate";
$host = "mysqldev.aero.und.edu";

$conn = mysql_connect ($host, $user, $pass); //Connect to database
mysql_select_db($database, $conn);

$query = "select id, name, total from users where type_user = 'C ' order by name asc;";
$result = mysql_query($query);

echo "
<h2>Customers</h2>
<p>*Click on the hyperlinked names to see the books that the customer has purchased.</p>
";
while($row=mysql_fetch_assoc($result)) {
    foreach($row as $key=>$value) {
		if($key== 'name') { 
			 echo "<a href='printbooks.php?name=$value'>" .$key .": ". $value . "</a><br>";
		}
		else {
			echo $key .": ". $value . "<br>";
		}
    }   
}
echo "<br>	<button><a href='listcustomers.php' download>Show Source</a></button><br><br>";
?>
