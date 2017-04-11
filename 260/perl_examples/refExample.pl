use strict;

my @values1 = (12, 23, 34, 45, 56, 67, 78);
my @values2 = (1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3);

my @newArray = sumArrays (\@values1, \@values2);
print "Data in newArray ", @newArray, "\n";
my $newArrayRef = sumArrays (\@values1, \@values2);
print "Data in newArrayRef ", @$newArrayRef, "\n";
print "Data from sumArray ", sumArrays (\@values1, \@values2), "\n";

my @array = (1, 2, 3, 4);

my $arrayRef1 = \@array;
my $arrayRef2 = [5, 6, 7, 8];
my $arrayRef3 = (9, 10, 11, 12);

print "Print data in array ", @array, "\n";
print "Print location of array ", \@array, "\n";
print "Print location of array from ref ", $arrayRef1, "\n";
print "\n";
print "Print data in array ", @$arrayRef2, "\n";
print "Print location of array2 from ref ", $arrayRef2, "\n";
print "\n";
print "Print location of array3 from ref ", $arrayRef3, "\n";

if (ref($arrayRef1) eq 'HASH')
{
   my %badHash = %$arrayRef1;
   print "Keys from badHash ", keys %badHash, "\n";
}
else
{
   print "not a reference to hash - bad idea\n";
}   

sub sumArrays
{
   my ($localRef1, $localRef2) = (shift, shift); #remove two ref's from @_
   
   my @summedValues;
   my $maxIndex = scalar (@$localRef1);
   $maxIndex = scalar(@$localRef2) if (scalar($localRef2) > $maxIndex);
   for (my $index = 0; $index < $maxIndex; ++$index)
   {
      $summedValues[$index] = $localRef1->[$index] + $localRef2->[$index];
   }
   if (wantarray)
   {
      print "return an array\n";
      return @summedValues;
   }
   else
   {
      print "return a ref to an array\n";
      return \@summedValues;
   }
   
}

