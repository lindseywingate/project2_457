#!/usr/bin/perl

use CGI qw(:standard);

my ($first, $last, $firstCookie, $lastCookie);

$first = param ('txtFirstName');
$last = param ('txtLastName');

if ($first && $last)
{
   $firstCookie = cookie ( -name=>'txtFirst', -value=>$first, -expires=>'+15s');
   $lastCookie  = cookie ( -name=>'txtLast',  -value=>$last,  -expires=>'+15s');
   #print header(-cookie=>[$firstCookie, $lastCookie]), start_html(-title=>"Sample input page", -BGCOLOR=>'ffffff' );
   #print "header info ", header(-cookie=>[$firstCookie, $lastCookie]);
   #print end_form(), end_html();
   print redirect (-cookie=>[$firstCookie, $lastCookie], -location=>'/cgi-bin/showCookieInfo.pl'), start_html(), end_html();
}
else
{
   #should go to a page where you see an error message
   print redirect (-location=>'/cgi-bin/notLoggedIn.pl'), start_html(), end_html();
}



