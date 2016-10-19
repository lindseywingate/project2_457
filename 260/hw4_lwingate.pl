#Lindsey Wingate, 1011265, program #3
#This program gathers information from random websites
use LWP::Simple;
#use strict;
#use warnings;
use HTTP::Tiny;

my $url = 'https://en.wikipedia.org/wiki/North_Dakota';
my $response = HTTP::Tiny->new->get($url);
if ($response->{success}) {
	my $search_string = "<td style=\"padding-left:8px;\">756,927</td>";
	my $html = $response->{content};
	foreach my $line ($html) {
		if($line =~ m/$search_string/) {
			print "The population of North Dakota in Est. 2015 is 756, 927\n";	
		}
	}
}
else {
	print "Was unable to open $url";
}

#my $url2 = 'http://www.whatsmyip.org/';
#$response = HTTP::Tiny->new->get($url2);
#if ($response->{success}) {
#	my $html2 = $response->{content};
#	foreach my $line2 ($html2) {
	#	print $line2;
	#	print "****************************\n";
#	}
#}
#else {
#	print "Was unable to open $url2\n";
#}

my $url3 = 'http://cs.und.edu/People/';
$response = get($url3);
	my $search_string3 = "^[  [a-zA-Z]+[ ][a-zA-Z]+";
	my $html3 = $response->{content};
	foreach my $line3 ($html3) {
		if($line3 =~ m/$search_string3/) {
			print "Name found in line $line3";	
		}
	}

#my $url4 = 'https://twitter.com/myUND';
#$response = HTTP::Tiny->new->get($url4);
#if ($response->{success}) {
#	my $html4 = $response->{content};
#	foreach my $line4 ($html4) {
	#	print $line4;
	#	print "**************************************\n";
#	}
#}
#else {
#	print "Was unable to open $url4\n";
#}

#my $url5 = 'http://money.cnn.com/data/markets/dow';
#$response = HTTP::Tiny->new->get($url5);
#if ($response->{success}) {
#	my $html5 = $response->{content};
#	foreach my $line5 ($html5) {
	#	print $line5;
	#	print "************************************\n";
#	}
#}
#else {
#	print "Was unable to open $url2\n";
#}
