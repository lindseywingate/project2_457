#Lindsey Wingate, 1011265, program #3
#This program gathers information from random websites
use LWP::Simple;
use strict;
use warnings;
use HTTP::Tiny;

my $html = get('https://en.wikipedia.org/wiki/North_Dakota');
	my @stuff = split /\n/, $html;
	foreach my $line (@stuff) {
		if($line =~ /[7][0-9]{2},[0-9]{3}/) {
			print $line;		
		}
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

#my $html3 = get('http://cs.und.edu/People/');
#	my @stuff_array = split /\n/, $html3;
#	foreach my $line3 (@stuff_array) {
#		if($line3 =~ /(<h3>)[a-zA-Z' ]+(<\/h3>)/) {
#			my @temp = split /[<>]/, $line3;
#			printf("$temp[5]\n");
#		}
#		if($line3 =~ /(<li >)[a-zA-Z, ]+(<\/li>)/) {
#			my @temp2 = split /(li)/, $line3;
#			foreach my $i (@temp2) {
#				$i = substr $i, 2, -2; 
#				if($i =~ /^[^<>=]+$/) {
#					print("\t$i\n");
#				}
#			}
#		}
#	}
	

my $html4 = get('https://twitter.com/myUND');
	print $html4;

my $html5 = get('http://money.cnn.com/data/markets/dow');
	print $html5;

