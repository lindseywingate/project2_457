#subroutines use name:
#legal names - "identifier"
	#case-sensitive, alphanumeric
	#includes . _ and $
	#up to 31 chars long
	#first char NOT numeric
	
#stack pointer- not for general purpose use
$31 1000 400 500
#500
#400
#1000

#syscall: read or print values to input/output

#slide 4.15 practice
#one byte each :)
#s1:     a
#s1+1:   b 
#s1+2:   c
#s1+3|s2 x
#s2+1:   y
#s2+2:   z
#s2+3:   O	

    .data
s1: .ascii    "abc"
s2: .asciiz   "xyz"

    .text
main:
    la $a0, s1
    li $v0, 4
    syscall

    
    		
	