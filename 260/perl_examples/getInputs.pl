#!/usr/bin/perl

use CGI qw(:standard);

$previouslyRan = param() ? 1 : 0;
$oneHasValue = param('txtOne');
$twoHasValue = param('txtTwo');
$threeHasValue = param('txtThree');

if ($oneHasValue && $twoHasValue && $threeHasValue)
{
   print redirect ("/cgi-bin/showInputs.pl?txtOne=$oneHasValue&txtTwo=$twoHasValue&txtThree=$threeHasValue");
   exit();
}

print header(), start_html(), start_form(-action=>'/cgi-bin/getInputs.pl', -method=>'get');

print "One ", textfield(-name=>'txtOne', -size=>10), br;
print "you must enter a value in this field" . br if (!$oneHasValue && $previouslyRan);
print br;

print "Two ", textfield(-name=>'txtTwo', -size=>10), br;
print "you must enter a value in this field" . br if (!$twoHasValue && $previouslyRan);
print br;

print "Three ", textfield(-name=>'txtThree', -size=>10), br;
print "you must enter a value in this field" . br if (!$threeHasValue && $previouslyRan);
print br;

print submit (-name=>'cmdRun', -value=>'Submit data'), "\n";

print end_form(), end_html();

