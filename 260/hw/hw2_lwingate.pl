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
my $credit_hours;
my $final_gpa;

print "Enter the students name: ";
my $name = <STDIN>;
chomp ($name);

while (1) {
	print "Enter a class: ";
	$class = <STDIN>;
	if($class=~ /^\s*$/) {
		last;
	}
	print "Enter the number of credits: ";
	$credit_hours = <STDIN>;
	chomp($credit_hours);
	print "\nEnter the grade received: ";
	$grade = <STDIN>;
	chomp($grade);
	if($grade eq 'a') {
			my $addme_a = 4 * $credit_hours;
			$gpa = $gpa + $addme_a;
			$passed_creds = $passed_creds + $credit_hours;
		}
	elsif($grade eq 'b') {
			my $addme_b = 3 * $credit_hours;
			$gpa = $gpa + $addme_b;
			$passed_creds = $passed_creds + $credit_hours;
		}
	elsif($grade eq 'c') {
			my $addme_c = 2 * $credit_hours;
			$gpa = $gpa + $addme_c;
			$passed_creds = $passed_creds + $credit_hours;	
		}	
	elsif($grade eq 'd') {
			$gpa = $gpa + $credit_hours;			
			$passed_creds = $passed_creds + $credit_hours;		
		}
	elsif($grade eq 'f') {
			$gpa = $gpa + 0;
		}
	$total_creds = $total_creds + $credit_hours;
}
if($passed_creds eq 0) {
	$final_gpa = 0;	
}
else {
	$final_gpa = $gpa/$total_creds; 
}
print "\nTranscript for $name";
printf "\nCredits taken: %10i \nCredits passed: %9i \nSemester GPA: %11.2f\n", $total_creds, $passed_creds, $final_gpa;
