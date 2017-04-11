use strict;

my %data = ("first", "Tom", "last" => 'Stokke', major => 'computer Science', credits => 200 );

$data{city} = "Grand Forks";

foreach my $key (sort keys %data)
{
   printf "%-10s %-20s\n", $key, $data{$key};
}

