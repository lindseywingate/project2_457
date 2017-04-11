<?php
$cereals = array("Honey Bunches of Oats", "Raisin Nut Bran", "Honey Nut Cheerios", "Granola");
//ascending sort
sort($cereals);
foreach($cereals as $c){
	print"$c \n";
}
print "\n";
//descending sort
rsort($cereals);
foreach($cereals as $c){
	print"$c \n";
}

$kitties["Selva"] = "Brown";
$kitties["Io"] = "White";
$kitties["Winston"] = "Orange";
$kitties["Sylvie"] = "Black";

print "\n";
print "Kitties: \n";
foreach($kitties as $k => $k_v) {
	print "$k, $k_v \n";
}

//ascending value sort
asort($kitties);
foreach($kitties as $k => $k_v) {
	print "$k, $k_v \n";
}
//ascending key sort
ksort($kitties);
foreach($kitties as $k => $k_v) {
	print "$k, $k_v \n";
}
//descending value sort
arsort($kitties);
foreach($kitties as $k => $k_v) {
	print "$k, $k_v \n";
}
//descending key sort
krsort($kitties);
foreach($kitties as $k => $k_v) {
	print "$k, $k_v \n";
}

echo $_SERVER["SCRIPT_NAME"];
print "\n";
echo $_SERVER["PHP_SELF"];
print "\n";
echo $_SERVER["HTTP_HOST"];
?>
