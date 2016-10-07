#This code was written by Lindsey Wingate, 1011265, Program Number 3
#Description: This module contains various subroutines that perform actions on lists. When included in a file, the subroutines act like functions when called.
#!/usr/local/bin/perl
package My::ListUtil;
use strict;
use warnings;
use syntax 'junction';
use Exporter qw(import);
our @EXPORT_OK = qw(name addItem removeItem isInList saveToFile loadFromFile list count);
use 5.010;

#array stored in module
our @things_to_do = qw();

sub name {
	my $thing = $_[0];
	if ($thing eq "") {
		return $thing;	
	}
	else {
		my $name = $thing;
	}	
}

sub addItem {
	my $item = shift;
	my $result = isInList($item);
	if ($result eq "true") {
		return "false";
	}
	else {
		push(@things_to_do, $item);
		return "true";
	}
}

sub removeItem {
	my $item = shift;
	my $bool = isInList($item);
	my $count=0;
	foreach my $a (@things_to_do) {
		if($a eq $item) {	
			splice(@things_to_do, $count, 1);
			$count = $count + 1;
			return "true";
		}
	}
	return "false";	
}

sub isInList {
	my $thing = shift;
	foreach my $n (@things_to_do) {
		if ($n eq $thing) {
			return "true";
		}
	}
	return "false";
}

sub saveToFile {
	my $file = shift; #get name of file
	open (my $handle, ">", $file) or die ("File could not be opened."); #open file
	foreach my $x (@things_to_do) {
		print $handle $x;
	}	
}

sub loadFromFile {
	@things_to_do = ();
	my $usefile = shift;
	open (my $handle, "<", $usefile) or die ("File could not be opened.");
	while(my $row = <$handle>) {
		chomp $row;
		addItem($row);
	}
}

sub list {
	my @i = @_;
	if(@i) { #checks if i had value passed in
		if($i[0] eq "-type") {
			if($i[1] eq "array") { #return array
				return @things_to_do;
			}
			if($i[1] eq "ref") { #return reference
				my $ref = \@things_to_do;
				return $ref;
			}
			else {
				print "no argument included after -type\n";
			}
		}
	}
	if(@i[0] eq "") { #if nothing passed in, return reference 
		my $myref = \@things_to_do;
		return $myref;
	}	
}

sub count {
	my $num;
	$num = @things_to_do;
	return $num;
}
1;
#sub printarray {
#	my @array = @_;
#	print "@array\n";
#}
#This code was written by Lindsey Wingate
