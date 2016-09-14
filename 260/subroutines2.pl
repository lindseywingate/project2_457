use strict;

sub printAnything
{
	my $localRef = shift;
	if (ref ($localRef) eq 'ARRAY')
	{
		#have reference, need array
		foreach my $item(@$localRef)
		{
			print "$item\n";
		}
		print "\n";
	}
}

my @array = (1, 2, 3, 4);
my $hash = (name => 'Tom',
			city=> 'Grand Forks',
			state=> 'ND',
			);
my $class = "Perl 260";

printAnything \$class, "\n";
printAnything \@array, "\n";
#printAnything \%hash, "\n";
