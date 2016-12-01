#!/usr/bin/perl -w

#Lindsey Wingate, 1011265, Program 5
#This program allows a user to interact with a database of songs. The user may add a song, update a song, delete a song, or search for a song by artist\/title or name of album.

use DBI;
use strict;

#Connect to database
my $user = 'root';
my $password = 'password';
my $dsn = "DBI:mysql:fall13prog5:localhost";
my $dbh = DBI->connect($dsn, $user, $password);
if(!$dbh) {
	print "Unable to connect to database";
	exit;
}

while(1) {
	print "\n\tPlease make a selection. Press 0 to exit.\n
	Press a to add a new song.\n
	Press b to update an existing song.\n
	Press c to print a list of existing songs.\n
	Press d to search by artist, title, or both.";
	my $main_sel = <STDIN>;
	chomp($main_sel);
	if($main_sel eq '0') {
		exit;
	}
	if($main_sel eq 'a') {
		print"test1";
	}
	if($main_sel eq 'b') {
		print"test2";
	}
	if($main_sel eq 'c') {
		print"test3";
	}
	if($main_sel eq 'd') {
		print"test4";
	}
}

#This code was written by Lindsey Wingate

