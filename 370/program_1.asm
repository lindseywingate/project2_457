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
      
    offset2: .half    22,  24,  26,  28,  30,  32  
             .half    71,  73,  75,  77,  79,  81
             .half   120, 122, 124, 126, 128, 130
             .half   169, 171, 173, 175, 177, 179
             .half   218, 220, 222, 224, 226, 228
             .half   267, 269, 271, 273, 275, 277
  
  cruiser:	.asciiz	"\nEnter the cruiser 3x[0-9a-z]: "
  cruiser_in:	.word	0
  destroyer:	.asciiz	"\nEnter the destroyer 2x[0-9a-z]: "
  destroy_in:	.word	0
  submarine:	.asciiz	"\nEnter the submarine [0-9a-z]: "
  sub_in:	.word	0
  shot:		.asciiz "\nEnter the next shot [0-9a-z]: "
  shot_input:	.space	1
  new:		.asciiz "\nNew game? (y/n):"
  buf:		.space	200
  var1:		.word	3

.text
.globl main
#main procedure/function in program
    main:
	#print board
	li	$v0,	4
	la	$a0,	board
	syscall
	
	#get ships and add to board
	#cruiser
	li 	$v0,	4		#loads space
	la	$a0,	cruiser		#loads cruiser statement
	syscall
	li	$v0,	8		#loads space	
	la	$a0,	buf		#enter chars here
	li	$a1,	200		#loads entered characters into register
	syscall				
	
	#get individual characters
	#la	$t0, 	buf
	#lw	$a2,	1($t0)
	#li	$v0,	1
	#syscall

	#add to board
			
	#destroyer
	li 	$v0,	4
	la	$a0,	destroyer
	syscall
	li	$v0,	8
	la	$a0,	buf
	li	$a1,	200
	syscall
	
	#add to board
	
	#submarine
	li 	$v0,	4
	la	$a0,	submarine
	syscall
	li	$v0,	8
	la	$a0,	buf
	li	$a1,	200
	syscall
	
	#add to board
	
	#print shot string
	li 	$v0,	4	#receives string
	la	$a0,	shot 	#address of string to print
	syscall			#print the string
	
	
	#getting shot from user
	li	$v0,	12	#prepare to receive input
	la	$a0,	shot_input
	li	$a1,	1
	syscall
	
       	blt   $v0, '0', not_number		#if less than 0, not a number. tests to see if letter
       	bgt   $v0, '9', not_number		#if greater than 9, not a number. tests to see if letter
	sub  $t0, $v0, '0'			#otherwise, subtracts difference for ascii value
	j    add_board				#add to board

not_number:    	blt   $v0, 'a', not_letter	#if v0 is less than a, not a letter. 
        	bgt   $v0, 'z', not_letter	#if v0 is more than z, not a letter.
        	sub   $t0, $v0, 'a'		#otherwise, subtract/add the difference of ascii value
        	add   $t0, $t0, 10		
		
add_board:	mul  $t0, $t0, 2         # Each offset is two-byte long.
    		lh   $t1, offset1($t0)   # Load $t1 with the offset of the index $t0.
     		li   $t2, 'X'            # Put the marker X in $t2.
     		sb   $t2, board($t1)
     		 
not_letter:    	la      $a0, board	#prints board again
        	li      $v0, 4
        	syscall
	
	# Exit the program.
       li      $v0, 	10
       syscall
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
