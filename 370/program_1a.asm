.data
board:     .ascii   "\n\n    . . . . . .     . . . . . .      0 1 2 3 4 5"
           .ascii     "\n    . . . . . .     . . . . . .      6 7 8 9 a b"
           .ascii     "\n    . . . . . .     . . . . . .      c d e f g h"
           .ascii     "\n    . . . . . .     . . . . . .      i j k l m n"
           .ascii     "\n    . . . . . .     . . . . . .      o p q r s t"
           .asciiz    "\n    . . . . . .     . . . . . .      u v w x y z\n"

offset1:   .half     6,   8,  10,  12,  14,  16
           .half    55,  57,  59,  61,  63,  65
           .half   104, 106, 108, 110, 112, 114
           .half   153, 155, 157, 159, 161, 163
           .half   202, 204, 206, 208, 210, 212
           .half   251, 253, 255, 257, 259, 261

offset2:   .half    22,  24,  26,  28,  30,  32
           .half    71,  73,  75,  77,  79,  81
           .half   120, 122, 124, 126, 128, 130
           .half   169, 171, 173, 175, 177, 179
           .half   218, 220, 222, 224, 226, 228
           .half   267, 269, 271, 273, 275, 277

cruiser:     .asciiz    "\nEnter the cruiser 3x[0-9a-z]: "
cruiser_in:  .space  4
destroyer:   .asciiz    "\nEnter the destroyer 2x[0-9a-z]: "
destroy_in:  .space  3
submarine:   .asciiz    "\nEnter the submarine [0-9a-z]: "
sub_in:	     .space  2
shot:	     .asciiz    "\nEnter the next shot [0-9a-z]: "
shot_input:  .space  2
new:	     .asciiz     "\nNew game? (y/n):"
buf:         .space  200
var1:        .word   3

.text
.globl main
#main procedure/function in program
main:
#print board
li    $v0,    4
la    $a0,    board
syscall

#get ships and add to board
#cruiser
li    $v0,    4        #loads space
la    $a0,    cruiser        #loads cruiser statement
syscall

#get input, store in word
la    $a0,    cruiser_in    #sets $a0 to space allocated
li    $a1,    4           #gets length of space
li    $v0,    8        #load opcode (8)
syscall                #sees 8, asks for input, puts string in $a0

#gets first byte from cruiser
la    $t0,    cruiser_in
lb    $a0,    ($t0)
jal	find_spot

#gets second byte from cruiser
add   $t0, $t0, 1
lb    $a0, ($t0)
jal	find_spot

#gets third byte from cruiser
add   $t0, $t0, 1
lb    $a0,    ($t0)
jal	find_spot

#destroyer
li    $v0,    4
la    $a0,    destroyer
syscall

#get input, store in word
la    $a0,    destroy_in
li    $a1,    3
li    $v0,    8
syscall

#gets first byte from cruiser
la    $t0,    destroy_in
lb    $a0,    ($t0)
jal find_spot

#gets second byte from cruiser
add   $t0, $t0, 1
lb    $a0,    ($t0)
jal find_spot

#submarine
li    $v0,    4
la    $a0,    submarine
syscall

la    $a0,    sub_in
li    $a1,    2
li    $v0,    8
syscall

#gets first byte from sub
la    $t0,    sub_in
lb    $a0,    ($t0)
jal find_spot

loop:
 #shot
li    $v0,    4
la    $a0,    shot
syscall

la    $a0,    shot_input
li    $a1,    2
li    $v0,    8
syscall

#gets first byte from sub
la    $t0,    shot_input
lb    $a0,    ($t0)
jal find_spot2
j   loop	#jumps back to ask for another shot again

# Exit the program.
li      $v0,     10
syscall

#place spot for shot on board 2



#place spot for shot on board 1
find_spot2:
blt  $a0, '0', not_number2        #if less than 0, not a number. tests to see if letter
bgt  $a0, '9', not_number2        #if greater than 9, not a number. tests to see if letter
sub  $s0, $a0, '0'               #otherwise, subtracts difference for ascii value
sub  $s1, $a0, '0'		 #for board 2
mul  $s0, $s0, 2         # Each offset is two-byte long.
mul  $s1, $s1, 2
lh   $t1, offset1($s0)   # Load $t1 with the offset of the index $t0.
lh   $t3, offset2($s1)
li   $t2, '+'            # Put the marker X in $t2.
sb   $t2, board($t1)
sb   $t2, board($t3)
la   $a0, board
li   $v0, 4
syscall
jr   $ra

not_number2:   
blt   $a0, 'a', not_letter2    #if v0 is less than a, not a letter. 
bgt   $a0, 'z', not_letter2    #if v0 is more than z, not a letter.
sub   $s0, $a0, 'a'           #otherwise, subtract/add the difference of ascii value
sub   $s1, $a0, 'a'
add   $s0, $s0, 10
add   $s1, $s0, 36	   
mul   $s0, $s0, 2         # Each offset is two-byte long.
mul   $s1, $s1, 2
lh    $t1, offset1($s0)   # Load $t1 with the offset of the index $t0.
lh    $t3, offset1($s1)
li    $t2, '+'            # Put the marker X in $t2.
sb    $t2, board($t1)
sb    $t2, board($t3)
la    $a0, board
li    $v0, 4
syscall
jr    $ra

not_letter2: 
la    $a0, board    #prints board again
li    $v0, 4
syscall
jr    $ra
la    $a0, board    #prints board again
li    $v0, 4
li    $v0, 10	    #exits
syscall

# places ship on board 1	##################

find_spot:
blt  $a0, '0', not_number       #if less than 0, not a number. tests to see if letter
bgt  $a0, '9', not_number        #if greater than 9, not a number. tests to see if letter
sub  $s0, $a0, '0'               #otherwise, subtracts difference for ascii value

#add to board
mul  $s0, $s0, 2         # Each offset is two-byte long.
lh   $t1, offset1($s0)   # Load $t1 with the offset of the index $t0.
li   $t2, '0'            # Put the marker X in $t2.
sb   $t2, board($t1)
la   $a0, board
li   $v0, 4
syscall
jr   $ra

not_number:   
blt   $a0, 'a', not_letter    #if v0 is less than a, not a letter. 
bgt   $a0, 'z', not_letter    #if v0 is more than z, not a letter.
sub   $s0, $a0, 'a'           #otherwise, subtract/add the difference of ascii value
add   $s0, $s0, 10
mul   $s0, $s0, 2         # Each offset is two-byte long.
lh    $t1, offset1($s0)   # Load $t1 with the offset of the index $t0.
li    $t2, '0'            # Put the marker 0 in $t2.
sb    $t2, board($t1)
la    $a0, board
li    $v0, 4
syscall
jr    $ra

not_letter: 
la     $a0, board    #prints board again
li     $v0, 4
syscall
jr     $ra
la     $a0, board    #prints board again
li     $v0, 4
li     $v0, 10
syscall
