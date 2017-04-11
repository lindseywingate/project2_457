use strict;
use warnings;

my (@names, @sortedNames, @values, @sortedValues);

@names = (); #initial names to an empty list
@names = ("Fred", "scott", "Tom", "Bob", "angie");

@values = (110, 34, 1001, 4, 7, -366);

@sortedValues = sort {$b <=> $a} (@values);

#print "@names\n";
#print "\n";
#print @names, "\n";
#print "\n";

#print "First name is the list $names[0]\n";
#print "Last name is the list  ", $names[-1], "\n";

#for (my $x = 0; $x < scalar (@sortedValues); ++$x)
for (my $x = 0; $x <= $#sortedValues; ++$x)
{
   print "$sortedValues[$x]\n";
   print "\n";
}

#foreach my $x (@values)
#{
#   #print "$x\n";
#   $x *= 2;
#}

#foreach my $x (@values)
#{
#   print "$x\n";
#}

