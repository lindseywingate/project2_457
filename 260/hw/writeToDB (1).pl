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

my $firstName = getInput ("Enter first name ");
my $lastName = getInput ("Enter last name ");
my $city = getInput ("Enter city ");
my $state = getInput ("Enter state ");

my $sql = "INSERT INTO tblnames (FirstName, LastName, City, State) VALUES ('$firstName', '$lastName', '$city', '$state' )";
my $result = $dbh->do ($sql);
if ($result)
{
   print "Info added to the table";
}
else
{
   print "Unable to add the info to the table";
}









