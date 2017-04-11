$data = "I'm in CS260 right now";
$officeNumber = "My office number is 777-3337";
$officeNumber2 = "You can contact the CS department at 777-4107 or 777-3330";

$data =~ s/260/435/;

print "$data\n";

$officeNumber =~ s/(\d{3}-\d{4})/(701)-$1/;
print "$officeNumber\n";

$officeNumber2 =~ s/(\d{3}-\d{4})/(701)-$1/g;
print "$officeNumber2\n";
