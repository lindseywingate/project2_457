<?php
#This page is used to check the login credentials

if ($_POST["thisone"] == "Login") { //If the user logs in
	$user = "lindseywingate";
	$pass = "password";
	$database = "lindseywingate";
	$host = "mysqldev.aero.und.edu";

	$conn = mysql_connect ($host, $user, $pass); //Connect to database
	mysql_select_db($database, $conn);
	
	$username = $_POST['username']; //Get variables user entered
	$password = $_POST['password'];

	$query = "select * from users where username = '$username' && password ='$password'";//check database for username/password the user entered	

	$result = mysql_query($query); //get results from table
	$num = mysql_numrows($result); //how many are there?

	if($num) { //if there are results, start a session
		session_start();
		$_SESSION['login_time'] = time();
		$_SESSION['user_id'] = $username;
		$row = mysql_fetch_assoc($result); //check the user type and direct them to the appropriate home page
		if($row['type_user']=="C") {
			echo "Customer";
			header("Location: http://people.aero.und.edu/~lwingate/457/exercise1/userhome.php");
			exit();
		}
		elseif($row['type_user']=="A") {
			echo "Admin";
			header("Location: http://people.aero.und.edu/~lwingate/457/exercise1/adminhome.php");
		}
	}
	else {
		echo "Your login credentials were incorrect. Please try again.";
	}
}

?>
