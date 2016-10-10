#persistence: ability for something to stick around in scope of method in which it is created
use strict;

package Student;

sub new {
	#first arg to constructor MUST be class type
	my $classType = shift;

	#set up a reference to the data struc, contains the "instance" variable
	my $data = {
		'first' => "Lindsey",
		last => "",
		id => "",
		program_scores => []
	}
	if (@_) {# needs at least one arg
		$data->[id] = shift;
	}
	
1;
