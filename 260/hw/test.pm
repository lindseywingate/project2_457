#use Exporter;
package SongList;
use Data::Dumper;

sub new #done
{
my $songData = shift; #this is all the stuff to do with a song
	my $data = {
		songGroup=>{},   
		title=>''   
		   };
        bless($data,$songData); 
        return $data;
}

sub addSong #done
{
   my ($data,$song,$time) = (shift,shift,shift);#dont forget parenthesis 
	$data->{songGroup}->{$song}=$time #sets for data,in song hash, for the song, the time.
   

}

sub removeSong #done
{
   my ($data, $lookFor)=(shift, shift);
	if (isSongInList($data,$lookFor)) # remember this needs to be comma seperated
	{
	  delete($data->{songGroup}->{$lookFor});
	}
	else
	{
	print" Song not found!!!! \n";
	}
   
}

sub isSongInList #done 
{
   my ($data,$check)=(shift,shift);
	my $thingy = $data->{songGroup}; #oh. Thats why. for some reason grabbing the key is arbitrary
	foreach my $key(sort keys %$thingy)
	{
	   if ($key eq $check){
	       return 1;
	   }
	}
	 return 0;
}





sub numberOfSongs #done
{
	my $data=shift;
	my $amount=0;
	my $boop = $data->{songGroup}; #oh. Thats why. for some reason grabbing the key is arbitrary
	foreach my $key(sort keys %$boop)
		{
		 $amount++;
		}
	return $amount;
}

sub clear #done
{
	my $data=shift;
	delete $data->{songGroup};
	$data->{songGroup}={};

}

sub printSongs#done
{ 
	my ($data,$returnMe)=(shift, "");
	my $boop = $data->{songGroup};
	foreach my $key(sort keys %$boop)
		{
		   my $temp= sprintf("%05s\n",$boop->{$key});
		   $returnMe.="$key\t\t\t$temp";
		}
	return $returnMe;
}

sub saveList
{
 my $data=shift;
}

sub loadList#done
{
	my ($data,$inFile)=(shift,shift);
	my $line,@value;
	open (INFILE, "<", $inFile) or die ("Unable to find input file.\n");
	while (chomp($line=<INFILE>))
	{
	@value=split(",",$line);
	$data->{songGroup}->{@value[0]}=@value[1]
	}
}



sub setTitle #done
{
 my ($data, $newTitle)=(shift,shift);
	$data->{title}=$newTitle;
 
}

sub getTitle #done
{
	 my $data=shift;
	return $data->{title};
}

return 1;
