#Lindsey Wingate
#lindseymwingate@gmail.com
#program #2
#this program takes input and calculates the students GPA
#!/usr/local/bin/perl

use strict;
my $total_creds = 0;
my $passed_creds = 0;
my $gpa = 0;

print "Enter the students name: ";
my $name = <>;
print "Students name: $name";

while (1) {
	print "Enter a class: ";
	my $class = <STDIN>;
	if($class=~ /^\s*$/) {
		last;
	}
	print "Enter the number of credits: ";
	my $credits = <STDIN>;
	$total_creds = $total_creds + $credits;
	print "Enter the grade received: ";
	my $grades = <STDIN>;
}
 
print "\nTranscript for $name";
print "\nCredits taken: $total_creds";
print "\nCredits passed: $passed_creds";
print "\nSemester GPA: $gpa";
