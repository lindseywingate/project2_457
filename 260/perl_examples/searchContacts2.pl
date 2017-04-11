use strict;

my ($regEx, @contacts, $input, @charClasses, $letter);

@charClasses =
(
"[0]",
"[1]",
"[2abcABC]",
"[3def]",
"[4ghi]",
"[5jkl]",
"[6mno]",
"[7pqrs]",
"[8tuv]",
"[9wxyz]",
);

@contacts = (
"Tom Stokke:73337",
"Whomever:746-1234",
"Help Desk: 7-HELP",
"Csci Office:701-777-4107",
"Someone else:(218)-987-6543",
"Patty:701-770-1236",
);
#$betweenLetters = '';
my $betweenLetters = '.*?';
while (chomp ($input = <STDIN>))
#while ($input = "to3")
{
   $input =~ tr/0-9a-zA-Z//cd;
   print "Working with $input\n\n";
   if ($input eq "") { exit }
   $regEx = "";
   for (my $i = 0; $i < length ($input); $i++)
   {
      $letter = substr ($input, $i, 1);
      foreach my $class (@charClasses)
      {
         if ($letter =~ /$class/)
         {
            $regEx .= '('. $betweenLetters. ')'. '('.  $class . ')';
         }
      }
      #$regEx .= $charClasses[$letter];
   }
   print "$regEx\n\n";
   print length ($input), "\n";
   my $count = 0;
   foreach my $contact (@contacts)  
   {
      if ($contact =~ /$regEx/)
      #if ($contact =~ s/($regEx)/\[$1\]/)
      {
         print $`;
         no strict;         
         foreach my $index (1..length($input)*2)
         {
            if ($index % 2 == 0)
               { print '['. ${$index} . ']'; }
            else   
               { print ${$index}; }
         }
         use strict;         
         print $';
         print "\n";  
         print "\nFound match in $contact\n\n";
         $count++;
      }
   }
   if ($count == 0)
   {
      print "Unable to find any matches\n";
   }
}

