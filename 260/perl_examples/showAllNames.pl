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
   print start_html(-title=>"All Names", -BGCOLOR=>'EEEEEE');
   print "<body>";
   print "Unable to connect to the database";
   print "</body>";
   print "</html>";
   exit;
}

print header();

print start_html(-title=>"All Names", -BGCOLOR=>'EEEEEE');
print "<body>";

my $sql = "SELECT nameid, firstname, lastname from tblnames";
my $sth = $dbh->prepare($sql);
my $recordCount = $sth->execute();  #$sth->rows
if ($recordCount > 0)
{
   print "Matching records<br><br>\n";
   while (my $hashRef = $sth->fetchrow_hashref() )
   {
       #print $hashRef->{'firstname'}, " ", $hashRef->{lastname}, "<br />\n";
       print "<a href=\"showPersonalInfo.pl?id=". $hashRef->{'nameid'}, "\" target=\"info\">", 
              $hashRef->{'firstname'}, " ", $hashRef->{lastname}, 
              "</a>", "<br />\n";
   }   
}
else
{
   print "Unable to find any matching records<br>\n";
}
print "</body>";
print "</html>";


