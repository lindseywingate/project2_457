open (INFILE, "numbers.txt") or die ("Unable to open the data file");
#open (INFILE, "<numbers.txt") or die ("Unable to open the data file");
#$result = open (INFILE, "numbers.txt");
#if (!$result)
#{
#   die ("Unable to open the data file");
#}

#$line = <INFILE>;
#while (!eof(INFILE))
#{
#   print "$line\n";
#$line = <INFILE>;
#}

while (chomp ($line = <INFILE>))
{
   print "$line\n";
}

close(INFILE);