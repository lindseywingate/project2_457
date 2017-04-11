use strict;
use Data::Dumper;

my ($name, $header, @headerInfo, $result, $line, @scores, %data);

$result = open (CSVFILE, 'Book11.csv');
if (!$result)
{
   print "Unable to find data file\n";
   die "\n";
}

chomp ($header = <CSVFILE>);
($name, @headerInfo) = split (",", $header);
while (chomp ($line = <CSVFILE>))
{
   ($name, @scores) = split (",", $line);
   #print "$name -> @scores\n";
   for (my $index = 0; $index < scalar (@headerInfo); ++$index)
   {
      #$data{$name}->{$headerInfo[$index]} = $scores[$index];
      $data{$name}->[$index] = $scores[$index];
   }
}

print Dumper (\%data), "\n";


