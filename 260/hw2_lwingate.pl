#Lindsey Wingate
#lindseymwingate@gmail.com
#program #2
#this program takes input and calculates the students GPA
#!/usr/local/bin/perl

use Switch;
use strict;

my $total_creds = 0;
my $passed_creds = 0;
my $gpa = 0;
my $class;
my $grade;
print "Enter the students name: ";
my $name = <>;

while (1) {
	print "Enter a class: ";
	$class = <STDIN>;
	if($class=~ /^\s*$/) {
		last;
	}
	print "Enter the number of credits: ";
	my $credit_hours = <STDIN>;
	print "\nEnter the grade received: ";
	$grade = <STDIN>;
	chomp($grade);
	print "\n GRADE: $grade hi";
	if($grade eq 'a') {
			print "\nA";
			my $addme_a = 4 * $credit_hours;
			$gpa = $gpa + $addme_a;
			$passed_creds = $passed_creds + $credit_hours;
		}
	elsif($grade eq 'b') {
			print "\nB";
			my $addme_b = 3 * $credit_hours;
			$gpa = $gpa + $addme_b;
			$passed_creds = $passed_creds + $credit_hours;
		}
	elsif($grade eq 'c') {
			print "\nC";
			my $addme_c = 2 * $credit_hours;
			$gpa = $gpa + $addme_c;
			$passed_creds = $passed_creds + $credit_hours;	
		}	
	elsif($grade eq 'd') {
			print "\nD";
			$gpa = $gpa + $credit_hours;			
			$passed_creds = $passed_creds + $credit_hours;		
		}
	$total_creds = $total_creds + $credit_hours;
}
my $final_gpa = $gpa/$passed_creds; 

print "\nTranscript for $name";
print "\nCredits taken: $total_creds";
print "\nCredits passed: $passed_creds";
printf "\nSemester GPA %1.2f", $final_gpa;
