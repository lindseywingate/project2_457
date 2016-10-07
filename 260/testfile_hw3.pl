#This is a test file for FileUtil
#!/user/local/bin/perl
use strict;
use warnings;
use My::ListUtil qw(name addItem removeItem isInList saveToFile loadFromFile count);

my @things_to_do = ();

my $thing='thisthing';
name($thing);
@things_to_do = addItem('not', @things_to_do);
@things_to_do = addItem('in', @things_to_do);
@things_to_do = addItem('here', @things_to_do);
@things_to_do = addItem('here', @things_to_do);
#isInList(@things_to_do, 'thisthing');
#Written by Lindsey Wingate
