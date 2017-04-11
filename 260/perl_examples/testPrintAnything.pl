BEGIN
{
   push (@INC, "./utils");
}
use strict;
use PrintAnything;

print "INC folders - @INC\n";
print $0;

my @array = (1, 2, 3, 4);
my %hash = (name => 'Tom',
            city => "Grand Forks",
            state => "ND",
           );
my $class = "Perl 260";

print "Version of PrintAnything ", $version, "\n\n";
print "Letters from PrintAnything ", @letters, "\n\n";
PrintAnything::printAnything ("What class is this? ", \$class);
printAnything \$class;
PrintAnything::sayHello;
#printAnything \@array;
#printAnything "Code reference ", \&sayHello;
#printAnything "Hash info ", \%hash;
          
          
