use strict;

my ($x, $y, $answer);

sub addTwoValues
{
	my $result;
	$result = $_[0] + $_[1];
	return $result;
}

sub addTwoValues2
{
	my ($firstValue, $secondValue) = (shift @_, shift);
	my $result = $firstValue-$secondValue;
	return $result;
}

sub addtwo3
{
	my $firstValue = shift @_;#shifting out of array. don't need @_ but can use`
	my $secondValue = shift;

	my $result = $firstValue + $secondValue;
	return $result;
}

#main
$x = 10;
$y = 20;

$answer = addtwo3($x, $y);
print "Sum of $x and $y is $answer\n";

$answer = addTwoValues2($x, $y);
print "Sum of $x and $y is $answer\n";

$answer = addTwoValues ($x, $y);
print "Sum of $x and $y is $answer\n";
