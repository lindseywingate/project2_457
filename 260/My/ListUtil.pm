#This code was written by Lindsey Wingate
#1011265
#Program Number 3
#Description: This module contains various subroutines that perform actions on lists. When included in a file, the subroutines act like functions when called.
#!/usr/local/bin/perl
package My::ListUtil;
use strict;
use warnings;
use syntax 'junction';
use Exporter qw(import);
our @EXPORT_OK = qw(printarray name addItem removeItem isInList saveToFile loadFromFile count);
use 5.010;

sub printarray {
	my @array = @_;
	print "@array\n";
}

sub name {
	my $thing = $_[0];
	if ($thing eq "") {
		return $thing;	
	}
	else {
		my $name = "things_to_do";
		print "Internal List Name Saved.\n";
	}	
}

sub count {
	my (@array, $num) = (@_, '');
	$num = @array;
	return $num;
}

sub addItem {
	my (@array) = (@_);
	my $removed = splice(@array, -1); #take item off end of array to check if already in 
	my $result = isInList(@array, $removed);	
	if ($result eq "true") {
		print "Already in list. Cannot be added.\n";
	}
	else {
		push(@array, $removed);
		print "ARRAY WITH NEW ITEM@array\n";
	}
	
	#if not already in array, add	
}
sub removeItem {
}

sub isInList {
	my (@array) = (@_);
	my $removed = splice(@array, -1);
	foreach my $n (@array) {
		if ($n eq $removed) {
			return "true";
			break;
		}
	}
	return "false";
}

sub saveToFile {

}
sub loadFromFile {

}

sub list {

}
1;
#This code was written by Lindsey Wingate
