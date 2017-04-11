use strict 'vars';

use Student;
use Data::Dumper;

my $student1 = Student::new(Student, 1);
my $student2 = new Student(2);

$student1->setID (11);
Student::setID ($student2, 22);

$student1->setProgramScore (1, 90, 100);
$student1->setProgramScore (2, 90);
$student1->setProgramScore (3, 80, 120);
#print Dumper($student1), "\n";
#print Dumper($student2), "\n";

