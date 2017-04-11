use Percent;
use LimitRange;
use Data::Dumper;

tie $value1, Percent;  #class TIESCALAR
tie $value2, LimitRange, 23, -4, 68;  #class TIESCALAR

print "$value1\n";  #calls FETCH

for ($i = -10; $i <= 110; $i++)
{
   $value1 = $i; #calls STORE
   print "$value1\n"; #calls FETCH
}   

for ($i = -10; $i <= 110; $i++)
{
   $value2 = $i; #calls STORE
   print "$value2\n"; #calls FETCH
}   


