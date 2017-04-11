<?php
session_start();
echo"
<html>
<head>
    <h3>Upload the Book List</h3>
</head>
<body>
	<form action='uploadxml.php' method='post' enctype='multipart/form-data'>
		A book list (XML):<br /><br class='s' />
		<input type='file' name='file' id='file' size='60'>
		<br><br>
		<input type='submit' name='act' value='Upload'>
		<input type='reset' value='Reset'>
		<input type='reset' value='Main Menu' onclick=\"window.location.href='http://people.aero.und.edu/~lwingate/457/exercise1/adminhome.php' \" />
	</form>
	<button><a href='adminhome.php' download>Show Source</a></button><br><br>

</body>
</html>
";
?>
