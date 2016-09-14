use strict;
use warnings;

my (@names, @sortednames, @values, @sortedvals);

@names = (); #empty initalization
@names = ("Fred", "Bob", "George", "Phil");

@values = (110, 32, 1110, 4, 7, -136);


@sortedvals = sort{$a <=> $b}(@values); #anonymous subroutine {cmp compares} 
#@sortedvals = (@values); #array of CHARS, treats like strings

#print "@names\n";
#print "\n";
#print @names, "\n";

#print "First name in the list $names[0]\n";
#print "Last name in the list ", $names[-1],"\n";

for (my $x = 0; $x < scalar (@sortedvals); ++$x)
#or for(my $x=0; $x<$sortedvals; ++$x)
{
	print "$sortedvals[$x]\n"; #make sure use $ for scalars
	#print "@values[$x]\n"; #gives slice of double dim array. not written well
	print "\n";
}

#foreach my $x (@values)
#{
#	print "$x\n";
#}

