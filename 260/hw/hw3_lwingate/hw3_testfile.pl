use strict;
use warnings;
use My::ListUtil qw(addItem name addItem removeItem isInList saveToFile loadFromFile list count);

#tests name func
my $name = 'lindsey';
my $newname = name($name);
print "new name stored internally: $newname\n";

#tests addItem func
addItem('jen');
addItem('sarah');
addItem('lindsey');
addItem('christine');
my $num = count();

#tests removeItem func
removeItem('sarah');
my $num2 = count();

#tests saveToFile func
saveToFile('test.txt');

loadFromFile('test.txt');

#tests list func
my $test1 = list("");
print "$test1\n";
my @test2 = list("-type", "array");
print "@test2\n";
my $test3 = list("-type", "ref");
print "$test3\n";
