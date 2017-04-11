@data = (
"this is cs260",
"the easiest class is CS435",
"CS399 is Android programming",
"C S242 shouldn't work",
"",
"CS23 is almost a class name",
"you might have cs161 and cs260N this semester",
"CS12345",
"your favorite class is csci435 or cs 199 ",
"your favorite class is csci 435",
"your favorite class is cs 199 ",
);

foreach $line (@data)
{
   if ($line =~ /((cs|CS)(ci)? ?\d\d\d)/)
   #if ($line =~ /[cC][sS]/)
   {
      #print "$line\n";
      #print ">$1<\n>$2<\n\n";
      print "$1\n";
   }
}

