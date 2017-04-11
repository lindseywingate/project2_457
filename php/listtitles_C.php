<html><body>
<?php 
if ( $_POST['act'] == "Search" ) {
	$username = "lindseywingate";
	$password = "password";
	$database = "lindseywingate";
	$host		 = "mysqldev.aero.und.edu";
 
	$conn = mysql_connect( $host, $username, $password );
	mysql_select_db( $database, $conn );

	$title = $_POST['title']; 

	echo"
	<form action='addtocart_C.php' method='post'>";
	#start by querying title entered:
	$boolean = false;
	$query = "select * from books where title like '%$title%'";
	$result = mysql_query($query);
	$num = mysql_numrows($result);
	#if there were no matches, break down search to key words and search each of those
	if($num<1) {
		$keywords = explode(" ", $title);
		foreach($keywords as $word) {
			$query = "select * from books where title like '%$word%'";
			$result = mysql_query( $query );
			$num = mysql_numrows( $result );
			$i = 0;
			echo "<b>Like \"$word\": <br></b>";
			if($num==0) {
				print "No books found for this keyword.<br><hr>";
			}
			while ( $i < $num ) {
				$boolean = true;
				$title = mysql_result( $result, $i, "title" );
				$ISBN = mysql_result( $result, $i, "ISBN" );
				$cost = mysql_result ( $result, $i, "price" );
				echo "<input type='checkbox' name='books[]' value=$ISBN>Title: $title<br>ISBN: $ISBN<br>Price: $cost<br><br>";
				$i++;
			}
		}
	#if no matches found at all, for search or keyword, print all books
	if($boolean == false) {
			print "<h4>Other Books Available:</h4>";
			$newquery = "select * from books";
			$finalresults = mysql_query($newquery);
			$y = 0;
			$count = mysql_numrows($finalresults);
			while($y<$count) {
				$title = mysql_result( $finalresults, $y, "title" );
				$ISBN = mysql_result( $finalresults, $y, "ISBN" );
				$cost = mysql_result ( $finalresults, $y, "price" );
				echo "<input type='checkbox' name='books[]' value=$ISBN>Title: $title<br>ISBN: $ISBN<br>Price: $cost<br><br>";
				$y++;
			}
		}
	}
	#matches were found on first phrase entered - doesn't break up into keywords
	else {
		$i=0;
		while ( $i < $num ) { 
                $boolean = true;
                $title = mysql_result( $result, $i, "title" );
                $ISBN = mysql_result( $result, $i, "ISBN" );
                $cost = mysql_result ( $result, $i, "price" );
                echo "<input type='checkbox' name='books[]' value=$ISBN>Title: $title<br>ISBN: $ISBN<br>Price: $cost<br><br>";
                $i++;
		}
	}
	echo "
	<input type='submit' name='checkboxsubmit' value='Add to Cart'>
	</form>";
	mysql_close( );
}
echo"     <button><a href='listtitles_C.php' download>Show Source</a></button><br><br>";
?>

</body></html>

