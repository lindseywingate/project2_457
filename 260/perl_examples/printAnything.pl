use strict;

sub sayHello
{
   print "Hello World";
}

sub printAnything
{
   while (@_)
   {
      my $localRef = shift;
      if (ref ($localRef) eq 'ARRAY')
      {
         foreach my $item (@$localRef)
         {
            print "$item\n";
         }
         print "\n";
      }
      elsif (ref ($localRef) eq 'SCALAR')
      {
         print "$$localRef\n";      
         print "\n";
      }
      elsif (ref ($localRef) eq 'HASH')
      {
         foreach my $key (sort keys %$localRef)
         {
            printf "%-15s%-15s\n", $key, $localRef->{$key};
            #printf "%-15s%-15s\n", $key, $$localRef{$key};
         }
      }
      elsif (ref ($localRef) eq 'CODE')
      {
         &$localRef; #run the code referred to in $localRef
         print "\n";
      }
      
      elsif (ref ($localRef) eq "")
      {
         print "$localRef\n----------\n";      
      }
   }   
}

my @array = (1, 2, 3, 4);
my %hash = (name => 'Tom',
            city => "Grand Forks",
            state => "ND",
           );
my $class = "Perl 260";

&printAnything ("What class is this? ", \$class);
printAnything \$class;
printAnything \@array;
printAnything "Code reference ", \&sayHello;
printAnything "Hash info ", \%hash;
          
          
