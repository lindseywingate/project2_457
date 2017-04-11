<?php

//2D array
$cars = array (
	array("Volvo", 22, 18),
	array("BMW", 15, 13),
	array("Saab", 4, 2),
	array("Land Rover", 18, 15)
	);

echo $cars[0][0].": In stock: ".$cars[0][1].", sold: ".$cars[0][2].".\n ";
echo $cars[1][0].": In stock: ".$cars[1][1].", sold: ".$cars[1][2].".\n ";
echo $cars[2][0].": In stock: ".$cars[2][1].", sold: ".$cars[2][2].".\n ";
echo $cars[3][0].": In stock: ".$cars[3][1].", sold: ".$cars[3][2].".\n ";

date_default_timezone_set("America/New_York");

echo "Today is " . date("D.M.Y") . "\n";
echo "The time is " . date("h:i:sa") . "\n";
echo "Today is " . date("l") . "\n";

?>
