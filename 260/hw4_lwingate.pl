#Lindsey Wingate, 1011265, program #3
#This program gathers information from random websites
use LWP::Simple qw(get);
use strict;
use warnings;
use HTTP::Tiny;

my $url = 'https://en.wikipedia.org/wiki/North_Dakota';
my $response = HTTP::Tiny->new->get($url);
if ($response->{success}) {
	my $html = $response->{content};
	print $html;
;}

