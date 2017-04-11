#!/usr/bin/perl

use CGI qw(:standard);

print header(), start_html(-title=>"Different Controls");
print start_form (-action=>'/cgi-bin/showInputs.pl', -method=>'get', -target=>'outputWindow');

print "Enter your information", br;

print "Name ", textfield (-name=>'txtName', -size=>40), br, br, "\n";

print "Year in school ", popup_menu (-name=>'cboYear', -size=>5,
                                     -values=>['Freshman', 'Sophomore', 'Junior', 'Senior'],
                                     -default=>'Freshman'), br, br, "\n";
                 
print "Year in school ", popup_menu (-name=>'cboYear2', -size=>1,
                                     -values=>['Freshman', 'Sophomore', 'Junior', 'Senior'],
                                     -default=>'Freshman'), br, br, "\n";
print "Grade ", radio_group (-name=>'rdoGrade', -values=>['A', 'B', 'C', 'D', 'F'], -default=>'F'), br, br;

print "Classes taken ", checkbox_group (-name=>'cs160', -values=>'cs160', -default=>'cs160' ),
                        checkbox_group (-name=>'cs161', -values=>'cs161' ),
                        checkbox_group (-name=>'cs242', -values=>'cs242' ), br, br;

print submit (-name=>'btnGo', -value=>'Go');

print end_form(), end_html();
