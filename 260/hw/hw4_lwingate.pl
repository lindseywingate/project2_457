#Lindsey Wingate, 1011265, program #3
#This program gathers information from random websites
use LWP::Simple;
use strict;
use warnings;

#NFL TEAM PORTION
print "Enter your NFL team:\n";
my $input = <STDIN>;
chomp $input;
$input = lc($input);#change to lower case for easy comparison

my $count=0;#used to fetch scores after name found by regex
my $bool="false";#used to indicate whether team was found or not
my $nfl_html = get('http://www.nfl.com/standings'); #get the html to search
my @nfl_stuff = split /\n/, $nfl_html; #split html into array for easy search
foreach my $j (@nfl_stuff) { #go through and find!
	my $l=lc($j);#set each array element to lower case for comparison
	$count = $count + 1; 
	if ($l =~ /[\s]+$input/) { #if the line matches the search
		$bool="true";#indicate team was found
		$l = join ' ', split ' ', $j;
		print("\n$l\n");#print team as listed on website
		printf("Wins: %s\n",substr $nfl_stuff[$count+6], -6, -5); #print stats
		printf("Losses: %s\n",substr $nfl_stuff[$count+14], -6, -5);	
		printf("Ties: %s\n", substr $nfl_stuff[$count+22], -6, -5);	
			
	}	
}
if($bool eq "false") {
	print("There was no team found that matches your search.\n");
}

#NORTH DAKOTA POPULATION
print("\n");
my $html = get('https://en.wikipedia.org/wiki/North_Dakota');
my @stuff = split /\n/, $html;
foreach my $line (@stuff) {
	if($line =~ /(<td style=\"padding-left:8px;\">)[7][0-9]{2}[,][0-9]{3}[<\/td>]+/) {
		my @a = split('>', $line);
		printf("The population of North Dakota is: %s\n\n", substr $a[1], 0, -4);
	}
}

#NUMBER OF UND TWEETS
my $html4 = get('https://twitter.com/myUND');
my @array = split /\n/, $html4;
foreach my $lino (@array) {
	if($lino =~ /(<span class=\"ProfileNav-value\" data-is-compact=\"false\">)[67]{1}[,][0-9]{3}[<\/span>]+/) {
		my @another = split />/, $lino;
		printf("The number of tweets on the UND Twitter page is: %s\n\n", substr $another[1], 0, -6);
	}
}

#PROFESSORS AND INTERESTS
my $html3 = get('http://cs.und.edu/People/');
my @stuff_array = split /\n/, $html3;
foreach my $line3 (@stuff_array) {
	if($line3 =~ /(<h3>)[a-zA-Z' ]+(<\/h3>)/) {
		my @temp = split /[<>]/, $line3;
		printf("$temp[5]\n");
	}
	if($line3 =~ /(<li >)[a-zA-Z, ]+(<\/li>)/) {
		my @temp2 = split /(li)/, $line3;
		foreach my $i (@temp2) {
			$i = substr $i, 2, -2; 
			if($i =~ /^[^<>=]+$/) {
				print("\t$i\n");
			}
		}
	}
}
print("\n");	


#MONEY STUFF
my $html5 = get('http://money.cnn.com/data/markets/dow');
my @more_stuff = split /\n/, $html5;
foreach my $line5 (@more_stuff) {
	if($line5 =~ /(Delayed Data)/) {
		my @search_string = split />/, $line5;
		foreach my $t (@search_string) {
			if($t =~ /([0-9]{2}[,][0-9]{3}[.][0-9]{2}(<\/span))/) {
				printf("Today's Dow Jones Industrial Average is %s\n", substr $t, 0, -6);
			}
		}
		my @search2 = split /</, $line5;
		foreach my $r (@search2) {
			if ($r =~ /(span class=\"negData\">[-]*[0-9]{2}+[.][0-9]{2}$)/) {
				printf("The daily change is %s\n\n", substr $r, -6);
			}		
		}
	}
}

#MY IP ADDRESS
#my $html2 = get('https://www.whatismyip.com');
#my @html_stuff = split /\n/, $html2;
#foreach my $c (@html_stuff) {
#	if($c =~ /(<p><b>)[0-9]+[.][0-9]+[.][0-9]+[.][0-9]+(<\/b>)*/) {
#		print("$c\n");	
#	}
#}


