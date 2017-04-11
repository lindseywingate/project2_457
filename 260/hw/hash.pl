use strict;
use Data::Dumper;

my ($name, $header, @headerinfo, $result, $line, @scores, %data);

$result = open(CSVFILE, 'Book11.csv');

if(!$result) {
	print "Unable to find";
	die "\n";
}

chomp ($header =<CSVFILE>);
($name, $headerinfo) = split (",", $header);

while(chomp ($line = <CSVFILE>) {
	($name, @scores) = split (",", $line);
	for (my $index = 0; $index < scalar (@headerinfo); ++$index) {
		$data{$name}->($headerinfo[$index]) = $scores[$index];	
	}	

}
print Dumper (\%data), "\n";
