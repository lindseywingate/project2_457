#Lindsey Wingate
#lindseymwingate@gmail.com
#Program 1
#Part One: Collection of name and random prints
#Part Two: Collection of number and more random prints
use strict;

sub main
{
	print "PART ONE\n";
	print "Please enter a first and last name and press enter: \n";
	my $name = <STDIN>;
	my $newname = uc $name;
	my @splitname = split(' ', $name);
	print "First name:  @splitname[0]\n";
	print "Last name:   @splitname[1]\n";
	print "Last, First: @splitname[1], @splitname[0]\n";
	print "Uppercase:   $newname";	
	print "Full name:   @splitname[0] @splitname[1]\n";
	print "PART TWO\n";
	print "Please enter a three digit number and press enter: \n";
	my $num = <STDIN>;
	#my @splitnum = split('', $num); could use this if worried substring won't work
	print "Hundred: ", substr($num, 0, 1), "\n";
	print "Ten:     ", substr($num, 1, 1), "\n";
	print "One:     ", substr($num, 2, 2);
	print "Number:  ", $num;
}

main();
