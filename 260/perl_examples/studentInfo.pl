use Data::Dumper;

my (%studentInfo);


$studentInfo{1}->{'first'} = "Courtney";
$studentInfo{1}->{'last'} = "C";
$studentInfo{1}{'city'} = "Grand Forks";
$studentInfo{1}{programs}[1]{'possible'} = 100;
$studentInfo{1}{programs}[1]{'score'} = 90;
$studentInfo{1}{programs}[0]{'possible'} = 100;
$studentInfo{1}{programs}[0]{'score'} = 100;

$studentInfo{2}{'first'} = "Tom";
$studentInfo{2}{'last'} = "S";
$studentInfo{2}{'city'} = "Grand Forks";

$studentInfo{3}{'first'} = "Steven";
$studentInfo{3}{'last'} = "H";
$studentInfo{3}{'city'} = "Grand Forks";

foreach my $id (sort keys %studentInfo)
{
   print "$studentInfo{$id}{first}\n";
}

print Dumper (\%studentInfo);
