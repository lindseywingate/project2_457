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
	#add a new song
	if($main_sel eq 'a') {
		print "Press 1 to go back to main.\nEnter Artist: \n";
		my $artist = <STDIN>;
		chomp($artist);
		if($artist eq '1') {
			next;
		}
		if($artist eq '') {
			print "No null values are allowed.";
			next;
		}	
		print "Enter Song Title: \n";
		my $song = <STDIN>;
		chomp($song);
		if($song eq '') {
			print "No null values are allowed.";
			next;	
		}
		print "Enter Album Title: \n";
		my $album = <STDIN>;
		chomp($album);
		if($album eq '') {
			print "No null values are allowed.";
			next;
		}
		print "Enter Length of Song. Must be in format Minutes:Seconds: \n";
		my $song_length = <STDIN>;
		chomp($song_length);
		if($song_length eq '') {
			print "No null values are allowed.";
			next;
		}
		my $newquery = "insert into tblnames (artist, title, album, time) values ('$artist', '$song', '$album', '$song_length')";
		my $sth = $dbh->prepare($newquery);
		my $rc = $sth->execute();
	}
	#update existing song
	if($main_sel eq 'b') {
		#print available songs with their id's
		my $sql2="select songid, title from tblsongs";
		my $sth = $dbh->prepare($sql2);
		my $rc = $sth->execute();
		if ($sth) {
			printf("Songs:\n");
			while (my $hashRef = $sth->fetchrow_hashref()) {
				printf("%d-%s\n", $hashRef->{songid}, $hashRef->{title});
			}
		}
		print "Press 0 to go back to main.\nWhat song number would you like to update?\n";
		my $song_replacement = <STDIN>;
		chomp($song_replacement);
		if($song_replacement eq '0') {
			next;
		}
		print "Press a to update the song name.\nPress b to update the artist.\nPress c to update the album.\nPress d to update the time.\nPress 1 to go back to the main menu.\n";
		my $update_sn = <STDIN>;
		chomp($update_sn);
		if($update_sn eq '1') {
			next;
		}
		if($update_sn eq 'a') {
			print "Please enter the new song name for song $song_replacement\n";
			my $sn_rep = <STDIN>;
			chomp($sn_rep);
			my $sql3 = "UPDATE tblnames SET song = '$sn_rep' WHERE nameid = '$update_sn'";
			my $sth = $dbh->prepare($sql3);
			my $rc = $sth->execute();
		}
		if($update_sn eq 'b') {
			print "Please enter the new artist name for song $song_replacement\n";
			my $artist_update = <STDIN>;
			chomp($artist_update);
			my $sql4 = "UPDATE tblnames SET artist = $artist_update WHERE nameid = $update_sn";
			my $sth = $dbh->prepare($sql4);
			my $rc = $sth->execute();
		}
		if($update_sn eq 'c') {
			print "Please enter the new album name for song $song_replacement\n";
			my $album_rep = <STDIN>;
			chomp($album_rep);
			my $sql5 = "UPDATE tblnames SET album = $album_rep WHERE nameid = $update_sn";
			my $sth = $dbh->prepare($sql5);
			my $rc = $sth->execute();	
		}
		if($update_sn eq 'd') {
			print "Please enter the new song length for song $song_replacement\n";
			my $length = <STDIN>;
			chomp($length);
			my $sql6 = "UPDATE tblnames SET time = $length WHERE time = $update_sn";
			my $sth = $dbh->prepare($sql6);
			my $rc = $sth->execute();
		}
	}
	#print list of existing songs in database
	if($main_sel eq 'c') {
		my $sql="select title from tblsongs";
		my $sth = $dbh->prepare($sql);
		my $rc = $sth->execute();
		if ($sth) {
			printf("Songs:\n");
			while (my $hashRef = $sth->fetchrow_hashref()) {
				printf("%s\n", $hashRef->{title});
			}
		}
		next;	
	}

	#search by artist or title
	if($main_sel eq 'd') {
		print "Press 1 to go back to main.\nEnter an artist or song title.\n";
		my $artist_song = <STDIN>;
		chomp($artist_song);
		my $sql_search = "SELECT artist, title from tblsongs where artist like '%$artist_song%' or title like '%$artist_song%'";
		my $sth = $dbh->prepare($sql_search);
		my $rc = $sth->execute();
		if ($sth) {
			printf("Song-Artist:\n");
			while (my $hashRef = $sth->fetchrow_hashref()) {
				printf("%s-%s\n", $hashRef->{title}, $hashRef->{artist});
			}
		}

		next;		
	}

	#search by album title
	if($main_sel eq 'e') {
		print "Press 1 to go back to main.\nEnter an album title.\n";
		my $album = <STDIN>;
		chomp($album);
		my $album_search = "SELECT title, time from tblsongs where album like '%$album%'";
		my $sth = $dbh->prepare($album_search);
		my $rc = $sth->execute();
		if($sth) {
			printf("Songs in Album $album:\n");
			while(my $hashRef=$sth->fetchrow_hashref()) {
				printf("%s-%s\n", $hashRef->{time}, $hashRef->{title});
			}
		}		
		next;
	}
}

#This code was written by Lindsey Wingate
