use strict;

print "Max value for the list ";
my $maxValue;
 $maxValue = <STDIN>;
if ($maxValue > 0)
{
   open (OUTFILE, ">numbers.txt") or die ("Why can't I created a file?");
   #open (OUTFILE, ">", "numbers.txt") or die ("Why can't I created a file?");
   for (my $value = 1; $value <= $maxValue; ++$value)
   {
      print OUTFILE "$value\n";
   }
   close (OUTFILE);
}   

<>