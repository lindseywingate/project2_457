#!/usr/bin/perl

use CGI qw(:standard);

#print 'Content-type: text/html', "\n\n";
print header();

print start_html(-title=>"First Perl Script, using the CGI module", -BGCOLOR=>'EEEEEE');
#print "<html>";
#print "<header><title>First Perl script</title></header>";
print "<body>";

my @controls = param();
foreach $controlName (@controls)
{
    print $controlName, " ", param($controlName), br, "\n";
}
print "First Perl Script\n\n";
print "I hope it works :-)";
print "<br><br>";
print "Hi ", param ("txtFirstName"), " I see you live in ", param("txtCity"), "<br />\n";
print "</body>";
print "</html>";


