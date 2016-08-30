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
	my $temp = $num;
	my $num1 = $num%10;
	$num/=10; 
	my $num2 = $num%10;
	$num/=10;
	my $num3 = $num%10;

	print "Hundred: ", $num3, "\n";
	print "Ten:     ", $num2, "\n";
	print "One:     ", $num1, "\n";
	print "Number:  ", $temp;
}

main();
