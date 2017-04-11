#!/usr/bin/perl

use DBI;
use strict;

sub getInput
{
   my $prompt = shift;
   print $prompt;
   chomp (my $value = <STDIN>);
   $value =~ s|\'|\\'|g;
   return $value;
}

my $username = "root";
my $password = "password";

my $dsn = "DBI:mysql:namesdb:localhost";
my $dbh = DBI->connect ($dsn, $username, $password);

if (!$dbh)
{
   print "Unable to connect to the database";
   exit;
}

sub displayRecords
{
   my $sql = "SELECT nameid, firstname, lastname, city, state from tblnames";
   my $sth = $dbh->prepare($sql);
   my $recordCount = $sth->execute();
   if ($sth)
   {
      printf "%-8s %-15s %-15s %-20s %-5s\n", "nameid", "firstname", "lastname", "city", "state";
      while (my $hashRef = $sth->fetchrow_hashref() )
      {
          printf "%8d %-15s %-15s %-20s %-5s\n", $hashRef->{nameid}, $hashRef->{firstname}, $hashRef->{lastname}, 
                                                 $hashRef->{city},$hashRef->{state};
      }   
   }
}

displayRecords();
my $recid = getInput ("Enter record number to change ");
my $fieldToChange = getInput ("Enter field to change ");
my $newValue = getInput ("Enter new value for $fieldToChange: ");
$newValue =~ s|\'|\\'|g;

my $sql = "UPDATE tblnames SET $fieldToChange = '$newValue' WHERE nameid = $recid;";
my $result = $dbh->do ($sql);
if ($result)
{
   print "Updated info in the table\n\n";
   displayRecords();
}
else
{
   print "Unable to update the info inf in the table";
}









