.data 
  board:	.ascii	"\n\n	. . . . . .	. . . . . .	0 1 2 3 4 5"
  		.ascii 	"\n	. . . . . .	. . . . . .	6 7 8 9 a b"
  		.ascii 	"\n	. . . . . .	. . . . . .	c d e f g h"
  		.ascii  "\n	. . . . . .	. . . . . .	i j k l m n"
  		.ascii  "\n	. . . . . .	. . . . . .	o p q r s t"
  		.asciiz "\n	. . . . . .	. . . . . .	u v w x y z\n"

  offset1:	.half	6,	8,	10,	12,	14,	16
  		.half	55,	57,	59,	61,	63,	65
  		.half	104,	106,	108,	110,	112,	114 	
  		.half 	153,	155,	157,	159,	161,	163
  		.half	202,	204,	206,	208,	210,	212
  		.half	251,	253,	255,	257,	259,	261
  		
  offset2:	.half	22,	24,	26,	28,	30,	32
  		.half	71,	73,	75,	77,	79,	81
  		.half	120,	122,	124,	126,	128,	130
  		.half	169,	171,	173,	175,	177,	179
  		.half	218,	220,	222,	224,	226,	228
  		.half	267,	269,	271,	273,	275,	277
  
  cruiser:	.asciiz	"\nEnter the cruiser 3x[0-9a-z]: "
  destroyer:	.asciiz	"\nEnter the destroyer 2x[0-9a-z]: "
  submarine:	.asciiz	"\nEnter the submarine [0-9a-z]: "
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
	#li 	$v0,	4
	#la	$a0,	cruiser
	#syscall
	#li	$v0,	8
	#la	$a0,	buf
	#li	$a1,	200
	#syscall
	
	#add to board
	
	#destroyer
	#li 	$v0,	4
	#la	$a0,	destroyer
	#syscall
	#li	$v0,	8
	#la	$a0,	buf
	#li	$a1,	200
	#syscall
	
	#add to board
	
	#submarine
	#li 	$v0,	4
	#la	$a0,	submarine
	#syscall
	#li	$v0,	8
	#la	$a0,	buf
	#li	$a1,	200
	#syscall
	
	#add to board
	
	#print shot string
	li 	$v0,	4	#receives string
	la	$a0,	shot 	#address of string to print
	syscall			#print the string
	#getting shot from user
	li	$v0,	8	#prepare to receive input
	la	$a0,	shot_input
	li	$a1,	1
	syscall
	
	jal	conversion	#jump and link - stores address in $ra
	
	
	
	#used to put X in offset table
	mul 	$t0,$t0,2
	lh	$t1, offset1($t0)
	li	$t2, 'X'
	sb	$t2, board($t1)
	
	#print board
	li	$v0,	4
	la	$a0,	board
	syscall
	
	# Exit the program.
       li      $v0, 	10
       syscall
	
#--------------------------------SUBROUTINES----------------------------------#
    conversion:
	#push to stack
	addi 	$sp, $sp, -4
	sw	$a0, 0($sp)	#store word-contents stored in stack, index: 0
	
	addi	$t1, $zero, 10 	#static value to compare for translating
	
	#if equal or greater than 10, it is a letter
	#else, program will continue to translate numbers
	blt	$a0, $t1, number	#if $a0 is equal or greater than $t1, then translate letter
	sub	$t0, $a0, 90		#subtract 90 to decode letter
	lw	$t0, 0($sp)
	addi	$sp,$sp, 4
	syscall
      	#letter:
	#sub	$t0, $a0, 87
	#pop from stack
	#lw	$t0, ($sp)
	#addiu	$sp, $sp, 4
	
	jr $ra	#returns back to main
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
