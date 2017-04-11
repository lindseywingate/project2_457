$data = " aklj aslk ew lk dko @#$2435435 sklj sdf 2334 zzz @$#%^$%^&";
$data2 = "secretpassword";

#replace character from the first group
#with corresponding character from the second group
$data =~ tr/a-z/A-T/;
print "$data\n";

$data =~ tr/AEIOU/aeiou/;
print "$data\n";

#replace all blank spaces with a period
$data =~ tr/ /./;
print "$data\n";

#removed all periods, lower case a-m and the upper case K
$data =~ tr/.a-mK//d;
print "$data\n";

#keep just the digits (0-9)
$data =~ tr/0-9a-zA-Z//cd;
print "$data\n";

