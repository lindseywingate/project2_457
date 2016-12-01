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
	print "\nPlease make a selection. Press 0 to exit.\nPress a to add a new song.\nPress b to update an existing song.\nPress c to print a list of existing songs.\nPress d to search by artist or title.\nPress e to search by album title.\n";

	my $main_sel = <STDIN>;
	chomp($main_sel);
	if($main_sel eq '0') {
		exit;
	}
	if($main_sel eq 'a') {
		print "Press 1 to go back to main.\nEnter Artist: \n";
		my $artist = <STDIN>;
		chomp($artist);
		if($artist eq '1') {
			next;
		}
		print "Enter Song Title: \n";
		my $song = <STDIN>;
		chomp($song);
		print "Enter Album Title: \n";
		my $album = <STDIN>;
		chomp($album);
		print "Enter Length of Song. Must be in format Minutes:Seconds: \n";
		my $song_length = <STDIN>;
		chomp($song_length);
	}
	if($main_sel eq 'b') {
		print "Press 1 to go back to main.\nEnter existing song.\n";
		my $song = <STDIN>;
		chomp($song);
		if($song eq '1') {
			next;
		}
		
	}
	if($main_sel eq 'c') {
		#print list of existing songs from database
		next;	
	
	}
	if($main_sel eq 'd') {
		print "Press 1 to go back to main.\nEnter an artist or song title.\n";
		my $artist_song = <STDIN>;
		chomp($artist_song);
		next;
	}
	if($main_sel eq 'e') {
		print "Press 1 to go back to main.\nEnter an album title.\n";
		my $album = <STDIN>;
		chomp($album);
		next;
	}


}

#This code was written by Lindsey Wingate

