#!/usr/bin/perl

use CGI qw(:standard);

print header(), start_html(-title=>"Invalid info");

print "Unable to verify the information. To enter the information go ",
      a ( {-href=>'/cgi-bin/getCookieInfo.pl', -target=>'_blank'}, "here"), br;

print end_html();

