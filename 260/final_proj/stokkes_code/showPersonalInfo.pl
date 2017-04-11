#!/usr/bin/perl

use CGI qw(:standard);
use DBI;

my $username = "root";
my $password = "password";

my $dsn = "DBI:mysql:namesdb:localhost";
my $dbh = DBI->connect ($dsn, $username, $password, {PrintError => 0});

my $id;
if (-t) #means it's being run from the terminal
{
   #print "-t";
   $id = 1330;
}
else
{
   #print "here";
   $id = param('id');
}


if (!$dbh || !$id)
{
   print header();
   print start_html(-title=>"Personal Info", -BGCOLOR=>'EEEEEE');
   print "<body>";
   print "Unable to connect to the database";
   print "</body>";
   print "</html>";
   exit;
}

print header();

print start_html(-title=>"Personal Info", -BGCOLOR=>'EEEEEE');
print "<body>";

my $sql = "SELECT * from tblnames where nameID = $id";
my $sth = $dbh->prepare($sql);
my $recordCount = $sth->execute();  #$sth->rows
if ($recordCount > 0)
{
   for my $control (param())
   {
      if ($control =~ /btn(\d+)/)
      {
         print "id from button $1<br><br>";
      }
   }

   my $hashRef = $sth->fetchrow_hashref();
   print "<table>\n";
   print Tr ( td ("First name"), td ($hashRef->{'FirstName'}));
   print Tr ( td ("Last name"), td ($hashRef->{'LastName'}));
   print Tr ( td ("City"), td ($hashRef->{'City'}));
   print Tr ( td ("State"), td ($hashRef->{'State'}));
   print "</table>\n";
}
else
{
   print "Unable to find any matching records<br>\n";
}
print "</body>";
print "</html>";


