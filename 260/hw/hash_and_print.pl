use strict;

my %data = ("first", "Lindsey", "last" => "Wingate", major => "computer science", credits => 20);

$data{city} = "grand forks"; #adding a scalar, $ for individual item
foreach my $key (sort keys %data) #returns array of keys
{
	printf "%-10s %-20s\n", $key, $data{$key};
}



	
