#!/usr/bin/perl

use CGI qw(:standard);
use DBI;

my $username = "root";
my $password = "password";

my $dsn = "DBI:mysql:namesdb:localhost";
my $dbh = DBI->connect ($dsn, $username, $password, {PrintError => 0});

if (!$dbh)
{
   print header();
   print start_html(-title=>"All Names 2", -BGCOLOR=>'EEEEEE');
   print "<body>";
   print "Unable to connect to the database";
   print "</body>";
   print "</html>";
   exit;
}

print header();

print start_html(-title=>"All Names 2", -BGCOLOR=>'EEEEEE');
print "<body>";
my $idFromButton;
my $sql = "SELECT nameid, firstname, lastname from tblnames";
my $sth = $dbh->prepare($sql);
my $recordCount = $sth->execute();  #$sth->rows
if ($recordCount > 0)
{
   print "Matching records<br><br>\n";

   while (my $hashRef = $sth->fetchrow_hashref() )
   {
       print start_form (-action=>'/cgi-bin/showPersonalInfo.pl', -method=>'POST', -target=>'info'); 
       print $hashRef->{'firstname'}, " ", $hashRef->{lastname}, 
             " <input name=btn".$hashRef->{'nameid'}." type=submit value=Go>", 
             " <input name=id type=hidden value=".$hashRef->{'nameid'}.">";
       #print "<a href=\"showPersonalInfo.pl?id=". $hashRef->{'nameid'}, "\" target=\"info\">", 
       #       $hashRef->{'firstname'}, " ", $hashRef->{lastname}, 
       #       "</a>", "<br />\n";
      print end_form;
      print "<br />\n\n";
   }   
}
else
{
   print "Unable to find any matching records<br>\n";
}
print "</body>";
print "</html>";


