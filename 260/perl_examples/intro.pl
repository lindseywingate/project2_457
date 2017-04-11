use strict;
my ($value1, $value2, $value3, $answer1, $answer2, $answer3);
my $vehicle;

$vehicle = "motorcycle";
print "he drives a ", $vehicle, "\n";

print STDOUT "she drives a $vehicle\n";
print 'she \'drives a $vehicle\n';

print "\n";
print "\n";


print "He has several ${vehicle}s\n";
print "He has several $vehicle", "s\n";

$value1 = 123.456;
$value2 = "45";
$value3 = 2;

$answer1 = $value1 * $value2;
$answer2 = $value2 + $value3;
$answer3 = substr($value1, 3, 1);

print "Answer1 is $answer1\n";
print "Answer2 is $answer2\n";
print "Answer3 is $answer3\n";
$answer1 = "  34asdfasdf" * "2asdfasdf";
print "Answer1 is $answer1\n";

print "Contents of the current dir\n ", `dir`, "\n";

print "The current date is \n ", `date /t`, "\n";
