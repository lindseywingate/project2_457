#!/usr/bin/perl

use DBI;
use CGI qw(:standard);
use DBD::mysql;

print header(), start_html();

my $dbh = DBI->connect ("DBI:mysql:testDB:database=lindseywingate;host=localhost", "lwingate", "new0929*") or die ("Couldn't make connection to database: $DBI::errstr");

my $sth = $dbh->prepare (q { SELECT * FROM tblNames ORDER BY id} ) or die ("Cannot prepare statement: ", $dbh->errstr(), "\n");

$sth->execute() or die ("Cannot execute statement: ", $sth->errstr(), "\n");

my @array;

print "ID Name       State\n", br, br;
while (@array = $sth->fetchrow_array() ) 
{
   printf "%2d %-10s %2s\n", @array;
   print br();
}

$dbh->disconnect();
$sth->finish();

print end_html();

