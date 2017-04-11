#!/usr/bin/perl

use CGI qw(:standard);
my $first = cookie ('txtFirst');
my $last = cookie ('txtLast');


if ($first && $last)
{
   print header(), start_html(-title=>"Show user info");
   print "Hello $first $last", br;
   print end_form(), end_html();
}
else
{
   #should go to a page where you see an error message
   #print redirect (-location=>'/cgi-bin/notLoggedIn.pl'), start_html(), "Going away now (like you'll see this", br, end_html();
   print header (-Refresh => "3; URL=/cgi-bin/notLoggedIn.pl"), start_html(), "Going away in 3 seconds", br, end_html();
}



