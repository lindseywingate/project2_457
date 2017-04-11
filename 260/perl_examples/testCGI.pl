#!/usr/bin/perl

use CGI qw(:standard);

print header(), start_html (-title=>'Testing the Perl script',
                            -BGCOLOR => 'white');

print "The Perl script works!", br;

print end_html();
