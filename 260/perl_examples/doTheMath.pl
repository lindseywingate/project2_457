#!/usr/bin/perl

use CGI qw(:standard);

my $first = param("txtFirstVal");
my $second = param("txtSecondVal");
my $result;
if ($first && $second)
{
   print header();
   print start_html(-title=>"Math Operation Example", -BGCOLOR=>'EEEEEE');
   print "<body>";
   if (param ('btnAdd'))
      { $result = $first + $second; }
   elsif (param ('btnSub'))
      { $result = $first - $second; }
   elsif (param ('btnMult'))
      { $result = $first * $second; }
   elsif (param ('btnDiv'))
      { $result = $first / $second; }
   printf "The result is %10.2f<br>\n", $result;
   print "</body>";
   print "</html>";
}
else
{
   print header();
   print start_html(-title=>"Math Operation Example", -BGCOLOR=>'EEEEEE');
   print "<body>";
   print "Missing required information, please enter both values", br, "\n";
   print "Missing first input" . br . "\n"  if (!$first);
   print "Missing second input" . br . "\n" if (!$second);
   print "</body>";
   print "</html>";
}


