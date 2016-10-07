use strict;
use warnings;
use My::ListUtil qw(printarray name addItem removeItem isInList saveToFile loadFromFile count);

my @array = <test test1 test2 test3>;
print "$array[1]\n";

my $count = count(@array);
print "$count\n";

my $name = 'lindsey';
name($name);

printarray(@array);

addItem(@array, 'lindsey');
addItem(@array, 'jen');
addItem(@array, 'test2');
