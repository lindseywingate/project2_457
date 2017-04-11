use strict;

my (@data, $month, $delim, $day, $year, $line);

$month = '(\D|\b)(1[0-2]|0?\d)';
$delim = '([\/-])';
$day = '([0-2]?\d|3[01])';
$year = '((\d\d)?\d\d)(\D|\b)';
@data = (
'today is 10/3/16',
'tomorrow is 10-04-2016',
'this shouldn\' work 1-4/14',
'123-23-3456',
'1.2.34.56',
'1-2-34-56',
'asdfad 13-2-12456 asdfqa',
'5-32-2345 asdf',
'5 - 4 - 2011 shouldn\'t work',
'the first test will be between 10/17 and 10/21/16.'
);
foreach $line (@data)
{
   while ($line =~ /$month$delim$day(\3$year)?/g)
   {
      print "Found a date $2-$4-$6 in $line\n";
   }
   
}   

