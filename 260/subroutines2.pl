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
	if (ref ($localRef) eq 'SCALAR')
	{
		print "$$localRef\n"; #ref to scalar. 
		print "\n";
	}
	elsif (ref ($localRef) eq 'HASH')
	{
		foreach my $item(key %$localRef) 
		{
			print = "$item\n";
		}
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
