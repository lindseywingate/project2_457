#Lindsey Wingate
#lindseymwingate@gmail.com
#program #2
#this program takes input and calculates the students GPA

use strict;

my @data = (); #array for data input
my $total_creds = 0;


print "Enter the students name: ";
my $name = <>;
print "Students name: $name";

do {
	print "Enter a class: ";
	my $class = <STDIN>;
	if ($class =~ /^\s*$/) { #if class is empty, skip to printing final results
		exit;
	}
	print "Enter the number of credits: ";
	my $credits = <STDIN>;
	my $total_creds = $total_creds + $credits;
	print "Enter the grade received: ";
	my $grades = <STDIN>;
} while (1);

print "Transcript for $name";
print "Credits taken: $total_creds";
