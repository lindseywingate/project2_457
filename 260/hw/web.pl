use strict;

sub setText
{
	my %params= { 
		text=>'',
		font=>'Arial',
		pointSize=>10,
		bold=>0,
		underline=>0,
		italics=>0,
		color=> '#000000',
		};
	if ((scalar@_) == 0) #no arguments passed
	{
		return;
	}
}
$params{'text'} = shift;
while (@_) {
	my ($key, $value) = (shift, shift);
	#params{$key} = $value;
	$key = substr ($key, 1);
	if ($value) {
		$params{$key} = $value;
	}
}
setText ('example 1');
setText ('example 2', -pointSize=>12);
setText ('example 3', -bold=>1, -color=>'#000000FF');


