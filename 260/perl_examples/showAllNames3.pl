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

my $page = param('page');
my $resultsPerPage = 10;
if (!$page)
   { $page = 0 };

print header();

print start_html(-title=>"All Names", -BGCOLOR=>'EEEEEE');
print "<body>";

my $sql = "SELECT nameid, firstname, lastname from tblnames limit " . ($page * $resultsPerPage) . ", $resultsPerPage";
my $sth = $dbh->prepare($sql);
my $recordCount = $sth->execute();  #$sth->rows
my $numOfLastRecord = $page * $resultsPerPage + $recordCount + 1;
my $sth2 = $dbh->prepare ("SELECT COUNT(*) from tblnames;");
my $recordsFromCount = $sth2->execute();
my $totalRecords = $sth2->fetchrow_arrayref()->[0];
if ($recordCount > 0)
{
   print "Matching records<br><br>\n";
   print "<table border = 1>";
   while (my $hashRef = $sth->fetchrow_hashref() )
   {
       #print $hashRef->{'firstname'}, " ", $hashRef->{lastname}, "<br />\n";
       #print "<a href=\"showPersonalInfo.pl?id=". $hashRef->{'nameid'}, "\" target=\"info\">", 
       #       $hashRef->{'firstname'}, " ", $hashRef->{lastname}, 
       #       "</a>", "<br />\n";
       print Tr (td("<a href=\"showPersonalInfo.pl?id=".$hashRef->{'nameid'}."\" target=\"info\">".$hashRef->{'firstname'}."</a>"), 
                 td("<a href=\"showPersonalInfo.pl?id=".$hashRef->{'nameid'}."\" target=\"info\">".$hashRef->{'lastname'}."</a>")), "\n";
   }   
   print "</table>";
   print br, br;
   if ($page > 0)
      { print "<a href='/cgi-bin/showAllNames3.pl?page=", $page - 1, "'>Prev</a>"; }
   else
      { print "Prev"; }
   print "&nbsp;&nbsp;&nbsp;";
   if ($numOfLastRecord < $totalRecords)
      { print "<a href='/cgi-bin/showAllNames3.pl?page=", $page + 1, "'>Next</a>", br; }
   else
      { print "Next", br; }
}
else
{
   print "Unable to find any matching records<br>\n";
}
print "</body>";
print "</html>";


