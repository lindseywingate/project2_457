#!/usr/bin/perl

use CGI qw(:standard);

@inputs = param();

print header(), start_html(-title=>'Different Controls');

foreach $control (@inputs)
{
   print $control, "&nbsp;&nbsp;&nbsp;", param($control), br, "\n";
}

print br, "Environment info", br, "\n";
foreach $control (keys %ENV)
{
   print $control, "&nbsp;&nbsp;&nbsp;", $ENV{$control}, br, "\n";
}

print end_html();
