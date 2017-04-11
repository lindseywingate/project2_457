use strict;

my ($regex, @contacts, $input);

@charClasses = 
(
"[1]",
"[2abcABC]",
"[3def]",
"[4ghi]",
"[5jkl]"
"[6mno]",
"[7pqrs]",
"[8tuv]",
"[9wxyz]",
"[0]",
);

@contacts = (
"Tom Stokke: 73337",
"blah: 4255318745",
"jordan:2072991111",
"another:(425)3135195",
);

while (chomp ($input = <STDIN>)) {
	if ($input eq "") {
		exit;
	}
	for(my $i=0; $i<length($input); $i++) {
		$letter = substr($input, $1, i);
		$regEx = "some char class";
	}

}
