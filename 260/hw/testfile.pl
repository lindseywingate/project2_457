use strict;
use warnings;

use SongList;
use Data::Dumper;

my $boop= new SongList();

#$boop->addSong("bob", '4:30');
#$boop->addSong("jeff", '2:30');

#print Dumper($boop);
#print ($boop->isSongInList("bob"),"\n");

#print ("\n you have: ",$boop->numberOfSongs()," songs in your list!\n");

#print "\n",$boop->printSongs(), "\n";

#$boop->setTitle("ThisIsATitle!");
#my $here=$boop->getTitle();
#print Dumper($boop);
#print ($here," \n");
print ("\n",$boop->loadList("songs.txt"));
#print Dumper($boop);
print "\n",$boop->printSongs(), "\n";
