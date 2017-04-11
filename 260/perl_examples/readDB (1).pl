#!/usr/bin/perl

use DBI;
use strict;

my $username = "root";
my $password = "password";

my $dsn = "DBI:mysql:namesdb:localhost";
my $dbh = DBI->connect ($dsn, $username, $password);

if (!$dbh)
{
   print "Unable to connect to the database";
   exit;
}

print "Enter search criteria ";
my $searchCriteria = <STDIN>;
chomp $searchCriteria;

#my $where = "";
#my $where = " where firstname = '$searchCriteria' or lastname = '$searchCriteria' ";
my $currentRecord = 0;
my $where = " where firstname like '%$searchCriteria%' or lastname like '%$searchCriteria%' ";
my $sql = "SELECT firstname, lastname from tblnames " . $where;
print "$sql\n";
my $sth = $dbh->prepare($sql);
my $recordCount = $sth->execute();
print "Returned value from execute $rc\n\n";
if ($sth)
{
   while (my $hashRef = $sth->fetchrow_hashref() )
   {
       print $hashRef->{'firstname'}, " ", $hashRef->{lastname}, "\n";
   }   
}
else
{
   print "Problem with the SQL statement";
}


$dbh->disconnect();
