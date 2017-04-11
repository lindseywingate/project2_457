#!/usr/bin/perl

use CGI qw(:standard);

print header(), start_html(-title=>"Sample input page", -BGCOLOR=>'ffffff' );

print start_form (-method=>'post', -action=>'/cgi-bin/setCookieInfo.pl');

print "initial web page for storing data", br, br;

print "First name", textfield (-name=>'txtFirstName'), br, br;

print "Last name", textfield (-name=>'txtLastName'), br, br;

print submit( -name=>'cmdRun', value=>'Run script');

print end_form(), end_html();



