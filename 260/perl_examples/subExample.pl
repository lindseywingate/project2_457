use strict;

my ($x, $y, $answer);

sub addTwoValues
{
   my $result;
   $result = $_[0] + $_[1];
   return $result
}

sub addTwoValues2
{
   $_[0] = $_[0] + $_[1];
   return $_[0];
}

sub addTwoValues3
{
   #my ($firstValue, $secondValue) = (shift @_, shift);
   my $firstValue = shift @_;
   my $secondValue = shift;
   my $thirdValue = shift;
   
   my $result = $firstValue + $secondValue;
   return $result;
}

sub addValues
{
   my $result;
   while (@_)
   #while (scalar(@_) > 0)
   {
      $result += shift;
   }
   return $result;
}

#main
$x = 10;
$y = 20;
my @array1 = (1, 2, 3, 4, 5);
my @array2 = (21, 22, 23, 24, 25);

$answer = addTwoValues ($x, $y);
print "Sum of $x and $y is $answer\n";

$answer = addTwoValues2 ($x, $y);
print "Sum of $x and $y is $answer\n";

$answer = addTwoValues3 ($x, $y);
print "Sum of $x and $y is $answer\n";

$answer = addValues (1, 2, 3, 4, 5);
print "Sum of the values is $answer\n";

$answer = addValues ($x, $y, 3);
print "Sum of the values is $answer\n";

$answer = addValues (1..100);
print "Sum of the values is $answer\n";

$answer = addValues (@array1, @array2);
print "Sum of the values is $answer\n";

$answer = addTwoValues (@array1, @array2);
print "Sum of the values is $answer\n";
