<?php
#This page is used to login to the bookstore
echo "
<html>
<head>
	<h3>Login to the Bookstore</h3>
</head>
<body>
	<form action='checklogin.php' method='post'>
	Username: <input type='text' name='username' value='username'><br><br>
	Password: <input type='text' name='password' value='password'><br><br>
	<input type='submit' name='thisone' value='Login' >
	<input type='reset' name='thatone' value='Clear'>
	</form>

	<form action='clearall.php' method='post'>
		<input type='submit' name='clearall' value='Clear All Database Tables'> 
	</form>

	<button><a href='login.php' download>Show Source</a></button><br><br>

</body>
</html>

";
?>
