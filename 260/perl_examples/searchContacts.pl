use strict;

my ($regEx, @contacts, $input, @charClasses, $letter, $index);

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
            $regEx .=  '(' . $betweenLetters. ')' . '(' . $class . ')';
         }
      }
      #$regEx .= $charClasses[$letter];
   }
   print "$regEx\n\n";
   my $count = 0;
   foreach my $contact (@contacts)  
   {
      if ($contact =~ /$regEx/i)
      #if ($contact =~ s/($regEx)/\[$1\]/)
      {
         no strict; 
         print "$`";
         foreach $index (1..length($input)*2)
         {
            if ($index %2 == 0) #need square brackets $2, $4, $6, ...
               { print '[' . ${$index} . ']'; }
            else   
               { print ${$index}; } #doesn't need square brackets - the "stuff" between the matches
         }
         print "$'";
         print "\n\n";
         use strict; 
         #print "Found match in $contact\n\n";
         $count++;
      }
   }
   if ($count == 0)
   {
      print "Unable to find any matches\n";
   }
}

