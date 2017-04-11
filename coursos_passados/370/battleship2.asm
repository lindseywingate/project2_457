.data
board:     .ascii   "\n\n    . . . . . .     . . . . . .      0 1 2 3 4 5"
           .ascii     "\n    . . . . . .     . . . . . .      6 7 8 9 a b"
           .ascii     "\n    . . . . . .     . . . . . .      c d e f g h"
           .ascii     "\n    . . . . . .     . . . . . .      i j k l m n"
           .ascii     "\n    . . . . . .     . . . . . .      o p q r s t"
           .asciiz    "\n    . . . . . .     . . . . . .      u v w x y z\n"
sys_board: .ascii   "\n\n    . . . . . .     . . . . . .      0 1 2 3 4 5"
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
offset3:   .half     6,   8,  10,  12,  14,  16	#These two offsets are for the positions on the sys_board
           .half    55,  57,  59,  61,  63,  65
           .half   104, 106, 108, 110, 112, 114
           .half   153, 155, 157, 159, 161, 163
           .half   202, 204, 206, 208, 210, 212
           .half   251, 253, 255, 257, 259, 261
offset4:   .half    22,  24,  26,  28,  30,  32
           .half    71,  73,  75,  77,  79,  81
           .half   120, 122, 124, 126, 128, 130
           .half   169, 171, 173, 175, 177, 179
           .half   218, 220, 222, 224, 226, 228
           .half   267, 269, 271, 273, 275, 277
buf:         .space  200
var1:        .word   3
new_resp:    .space  2
cruiser:     .asciiz    "\nEnter the cruiser 3x[0-9a-z]: "
cruiser_in:  .space  4
destroyer:   .asciiz    "\nEnter the destroyer 2x[0-9a-z]: "
destroy_in:  .space  3
submarine:   .asciiz    "\nEnter the submarine [0-9a-z]: "
sub_in:	     .space  2
shot:	     .asciiz  	"\nYour turn:\n Next shot [0-9a-z] or peek(/): "
shot_input:  .space  2
system:	     .asciiz    "\nSystem's turn:"
invalid:     .asciiz    "\nInvalid input"
you_won:     .asciiz	"\nYou won!"
system_won:  .asciiz	"\nThe system won :("
new:	     .asciiz     "\nNew game? (y/n):"
thanks:      .asciiz    "\nThanks for playing!"
.text
.globl main
#main procedure/function in program
main:
clearboard:
li    $t3, 36
li    $t7, 0
#clears first board
clearing:
mul    $t0, $t7, 2		#offset = 2 bytes
lh     $t1, offset1($t0)        #$t1 with offset1 index
lh     $t5, offset2($t0)        #t5 with offset2 index
li     $t2, '.'			#reset with .
sb     $t2, board($t1)   	#replace with .
sb     $t2, board($t5)		#do the same thing on second board
addi   $t7, $t7, 1		#next
bne    $t3, $t7, clearing
clearsysboard:			#clears the system board
li    $t3, 36
li    $t7, 0
#clears second board
clear2:
mul    $t0, $t7, 2		#offset = 2 bytes
lh     $t1, offset3($t0)        #$t1 with offset1 index
lh     $t5, offset4($t0)        #t5 with offset2 index
li     $t2, '.'			#reset with .
sb     $t2, sys_board($t1)   	#replace with .
sb     $t2, sys_board($t5)		#do the same thing on second board
addi   $t7, $t7, 1		#next
bne    $t3, $t7, clear2
#print board
li    $v0,    4
la    $a0,    board
syscall
############## places systems ships first ###########################################
#first random seed # for submarine
xor   $a0,$a0,$a0			#seed number
li    $a1, 36				#set range 0-35
li    $v0, 42				#randomly choose number
syscall
#places submarine
mul   $t0, $a0, 2			# Each offset is two-byte long.
lh    $t1, offset3($t0)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'S'            		# Put the marker in $t3.	
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
#random seed # for destroyer
random_num_destroyer:
xor   $a0,$a0,$a0			#seed number
li    $a1, 36				#set range 0-35
li    $v0, 42				#randomly choose number
syscall
#places destroyer1
mul   $t0, $a0, 2			# Each offset is two-byte long.
lh    $t1, offset3($t0)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
beq   $t4, '0',	random_num_destroyer	# if already contains 0, retry random #
li    $t3, 'D'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
move  $a2, $t0
jal   placement
#j     random_cruiser
beq   $a1, 0, put_anywhere		#not on edge or in corner
beq   $a1, 1, in_first_row		#on top edge
beq   $a1, 2, in_top_left		#in top left corner
beq   $a1, 3, in_top_right		#in top right corner
beq   $a1, 4, in_bottom_left		#in bottom left corner
beq   $a1, 5, in_bottom_right		#in bottom right corner
beq   $a1, 6, in_sixth_row		#in bottom edge
beq   $a1, 7, on_left_side		#on left side edge
beq   $a1, 8, on_right_side		#on right side edge
put_anywhere:
xor   $a0,$a0,$a0
li    $s0, 4
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left
beq   $s0, 1, put_piece_right
beq   $s0, 2, put_piece_top
beq   $s0, 3, put_piece_bottom
in_first_row:
xor   $a0,$a0,$a0
li    $s0, 3
li    $v0, 42			
syscall
beq  $s0, 0, put_piece_bottom
beq  $s0, 1, put_piece_left
beq  $s0, 2, put_piece_left
in_top_left:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_right
beq   $s0, 1, put_piece_bottom
in_top_right:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left
beq   $s0, 1, put_piece_bottom
in_bottom_left:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_right
beq   $s0, 1, put_piece_top
in_bottom_right:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left
beq   $s0, 1, put_piece_top
in_sixth_row:
xor   $a0,$a0,$a0
li    $s0, 4
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left
beq   $s0, 1, put_piece_top
beq   $s0, 2, put_piece_right
on_left_side:			
beq   $s0, 0, put_piece_right
#beq   $s0, 1, put_piece_top
#beq   $s0, 2, put_piece_bottom
on_right_side:
beq   $s0, 0, put_piece_left
#beq   $s0, 1, put_piece_top
#beq   $s0, 2, put_piece_bottom
put_piece_left:
sub   $a2, $a2, 2
lh    $t1, offset3($a2)   		# Load with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'D'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
j     random_cruiser
put_piece_right:
add   $a2, $a2, 2
lh    $t1, offset3($a2)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'D'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
j     random_cruiser
put_piece_top:
sub   $a2, $a2, 49
lh    $t1, offset3($a2)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'D'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
j     random_cruiser
put_piece_bottom:
add   $a2, $a2, 49
lh    $t1, offset3($a2)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'D'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board

###############################system's cruiser ###################################################
random_cruiser:
#random seed # for cruiser
xor   $a0,$a0,$a0			#seed number
li    $a1, 36				#set range 0-35
li    $v0, 42				#randomly choose number
syscall
#places cruiser1
mul   $a0, $a0, 2			# Each offset is two-byte long.
lh    $t1, offset3($a0)   		# Load $t1 with the offset value (of the translated index).
move  $a3, $t0
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'C'            		# Put the marker in $t3.
beq   $t4, '0', random_cruiser   	#if already contains 0, retry random #
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
jal   placement2

beq   $a1, 0, put_anywhere2		#not on edge or in corner
beq   $a1, 1, in_first_row2		#on top edge
beq   $a1, 2, in_top_left2		#in top left corner
beq   $a1, 3, in_top_right2		#in top right corner
beq   $a1, 4, in_bottom_left2		#in bottom left corner
beq   $a1, 5, in_bottom_right2		#in bottom right corner
beq   $a1, 6, in_sixth_row2		#in bottom edge
beq   $a1, 7, on_left_side2		#on left side edge
beq   $a1, 8, on_right_side2		#on right side edge
put_anywhere2:
xor   $a0,$a0,$a0
li    $s0, 4
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left2
beq   $s0, 1, put_piece_right2
beq   $s0, 2, put_piece_top2
beq   $s0, 3, put_piece_bottom2
in_first_row2:
xor   $a0,$a0,$a0
li    $s0, 3
li    $v0, 42			
syscall
beq  $s0, 0, put_piece_bottom2
beq  $s0, 1, put_piece_left2
beq  $s0, 2, put_piece_left2
in_top_left2:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_right2
beq   $s0, 1, put_piece_bottom2
in_top_right2:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left2
beq   $s0, 1, put_piece_bottom2
in_bottom_left2:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_right2
beq   $s0, 1, put_piece_top2
in_bottom_right2:
xor   $a0,$a0,$a0
li    $s0, 2
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left2
beq   $s0, 1, put_piece_top2
in_sixth_row2:
xor   $a0,$a0,$a0
li    $s0, 4
li    $v0, 42			
syscall
beq   $s0, 0, put_piece_left2
beq   $s0, 1, put_piece_top2
beq   $s0, 2, put_piece_right2
on_left_side2:			
beq   $s0, 0, put_piece_right2
on_right_side2:
beq   $s0, 0, put_piece_left2
put_piece_left2:
sub   $a2, $a2, 2
lh    $t1, offset3($a2)   		# Load with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'C'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
j     player_ships
put_piece_right2:
add   $a2, $a2, 2
lh    $t1, offset3($a2)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'C'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
j     player_ships
put_piece_top2:
sub   $a2, $a2, 49
#change $a0 to proper spot
lh    $t1, offset3($a2)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'C'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
j     player_ships
put_piece_bottom2:
add   $a2, $a2, 49
lh    $t1, offset3($a2)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, 'C'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)     		# Put the marker in the offset index player left board
j     player_ships
############## places ships for system ##########################################
placement:
bgt  $a2, 5, first_row 
bgt  $a2, 16, second_row
bgt  $a2, 65, third_row
bgt  $a2, 114, fourth_row
bgt  $a2, 163, fifth_row
bgt  $a2, 212, sixth_row
bgt  $a2, 261, thankyou
first_row:
bgt  $a2, 16, second_row 		#if bigger than 16, belongs in another row
beq  $a2, 6, top_left_corner
beq  $a2, 16, top_right_corner
add  $a1, $a1, 1
jr   $ra
top_left_corner:
add  $t0, $t0, 2
move $a0, $t0
jr   $ra
top_right_corner:  
add  $t0, $t0, 3
move $a0, $t0
jr   $ra
bottom_left_corner:
add  $t0, $t0, 4
move $a0, $t0
jr   $ra
bottom_right_corner:
add  $t0, $t0, 5
move $a1, $t0
jr   $ra
second_row:
bgt  $a2, 65, third_row			#if bigger than 65, belongs in another row
beq  $a2, 55, left_side
beq  $a2, 65, right_side
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
third_row:
bgt  $a2, 114, fourth_row		#if bigger than 114, belongs in another row
beq  $a2, 104, left_side
beq  $a2, 114, right_side
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
fourth_row:
bgt  $a2, 163, fifth_row		#if bigger than 163, belongs in sixth row
beq  $a2, 153, left_side
beq  $a2, 163, right_side
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
fifth_row:
bgt  $a2, 212, sixth_row
beq  $a2, 202, left_side
beq  $a2, 212, right_side
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
sixth_row:
beq  $a2, 251, bottom_left_corner
beq  $a2, 261, bottom_right_corner
add  $t0, $t0, 6
move $a1, $t0
jr   $ra
left_side:
add  $t0, $t0, 7
move $a1, $t0
jr   $ra
right_side:
add  $t0, $t0, 8
move $a1, $t0
jr   $ra
################ places cruiser #####################################################
placement2:
bgt  $a2, 5, first_row2
bgt  $a2, 16, second_row2
bgt  $a2, 65, third_row2
bgt  $a2, 114, fourth_row2
bgt  $a2, 163, fifth_row2
bgt  $a2, 212, sixth_row2
bgt  $a2, 261, thankyou
first_row2:
bgt  $a2, 16, second_row2 		#if bigger than 16, belongs in another row
beq  $a2, 6, top_left_corner2
beq  $a2, 16, top_right_corner2
add  $a1, $a1, 1
jr   $ra
top_left_corner2:
add  $t0, $t0, 2
move $a0, $t0
jr   $ra
top_right_corner2:  
add  $t0, $t0, 3
move $a0, $t0
jr   $ra
bottom_left_corner2:
add  $t0, $t0, 4
move $a0, $t0
jr   $ra
bottom_right_corner2:
add  $t0, $t0, 5
move $a1, $t0
jr   $ra
second_row2:
bgt  $a2, 65, third_row2			#if bigger than 65, belongs in another row
beq  $a2, 55, left_side2
beq  $a2, 65, right_side2
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
third_row2:
bgt  $a2, 114, fourth_row2		#if bigger than 114, belongs in another row
beq  $a2, 104, left_side2
beq  $a2, 114, right_side2
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
fourth_row2:
bgt  $a2, 163, fifth_row2		#if bigger than 163, belongs in sixth row
beq  $a2, 153, left_side2
beq  $a2, 163, right_side2
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
fifth_row2:
bgt  $a2, 212, sixth_row2
beq  $a2, 202, left_side2
beq  $a2, 212, right_side2
add  $t0, $t0, 0
move $a1, $t0
jr   $ra
sixth_row2:
beq  $a2, 251, bottom_left_corner2
beq  $a2, 261, bottom_right_corner2
add  $t0, $t0, 6
move $a1, $t0
jr   $ra
left_side2:
add  $t0, $t0, 7
move $a1, $t0
jr   $ra
right_side2:
add  $t0, $t0, 8
move $a1, $t0
jr   $ra
################ get ships from player and adds to board ############################
player_ships:
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
la   $t0, cruiser_in
lb   $a0, ($t0)
jal	find_spot
#gets second byte from cruiser
add  $t0, $t0, 1
lb   $a0, ($t0)
jal   find_spot
#gets third byte from cruiser
add  $t0, $t0, 1
lb   $a0, ($t0)
jal   find_spot
la   $a0, board
li   $v0, 4
syscall
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
la   $a0, board
li   $v0, 4
syscall
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
#sets counters for X's placed
li    $s7,   6		#if this counter gets down to 0, the player won!
li    $s6,   6		#if this counter gets down to 0, the system won :(

#prints board to begin
la   $a0, board
li   $v0, 4
syscall

################################## players turn ##############################
loop:
beq   $s7, 0, player_won    #branch if user has sunk all ships
beq   $s6, 0, sys_won
li    $v0,    4
la    $a0,    shot
syscall
 #gets shot input
la    $a0,    shot_input
li    $a1,    2
li    $v0,    8
syscall
#gets shot byte
la    $t0,    shot_input
lb    $a0,    ($t0)
jal mark_hit

###########################system's turn ###############################################
system_turn:
li    $v0,4				# print a string
la    $a0,system		        # print statement 2
syscall
system_turn_noprint:
xor   $a0,$a0,$a0			#seed number
li    $a1, 36				#set range 0-35
li    $v0, 42				#randomly choose number
syscall
mul   $s0, $a0, 2			# Each offset is two-byte long.
mul   $t0, $a0, 2
lh    $t1, offset1($s0)   		# Load $t1 with the offset value (of the translated index).
lh    $t2, offset4($t0)  	 	# Load $t2 with offset4 value
lb    $t4, board($t1)     		# load board piece into $t4
li    $t3, '+'            		# Put the marker in $t3.
beq   $t4, 'X', system_turn_noprint     #eliminate duplicates
beq   $t4, '0', player_ship_hit   	# if value is a ship, replace with X instead

sb    $t3, board($t1)     		# Put the marker in the offset index player left board
sb    $t3, sys_board($t2)    	 	# Put the marker in system right board
la    $a0, board
li    $v0, 4
syscall
j     loop	#jumps back to ask for another shot again
player_ship_hit:
li   $t5, 'X'
sb   $t5, board($t1)
sb   $t5, sys_board($t2)
sub  $s6, $s6, 1
la   $a0, board
li   $v0, 4
syscall
j     loop
#Exit the program
#li      $v0,     10
#syscall
################### Places shots when player takes turn ##################################
mark_hit:
blt  $a0, '0', mark_letter      #if less than 0, not a number. tests to see if letter
bgt  $a0, '9', mark_letter      #if greater than 9, not a number. tests to see if letter
sub  $s0, $a0, '0'              #otherwise, subtracts difference for ascii value
sub  $s1, $a0, '0'		#for board 2
mul  $s0, $s0, 2         	# Each offset is two-byte long.
mul  $s1, $s1, 2	
lh   $t1, offset2($s0)   	# Load $t1 with the offset value (of the translated index).
lh   $t2, offset3($s1)  	# '' for board 2
lb   $t4, sys_board($t2)   	# load board piece into $t4
li   $t3, '+'            	# Put the marker in $t3.
beq  $t4, '0', ship_hit  	# if value is a ship, replace with X instead
sb   $t3, board($t1)    	# Put the marker in the offset index player left board
sb   $t3, sys_board($t2)    	# Put the marker in system right board
la   $a0, board
li   $v0, 4
syscall
jr   $ra

mark_letter:   
blt   $a0, 'a', invalid_input    #if v0 is less than a, not a letter. 
bgt   $a0, 'z', invalid_input    #if v0 is more than z, not a letter.
sub   $s0, $a0, 'a'           	 #otherwise, subtract/add the difference of ascii value
sub   $s1, $a0, 'a'
add   $s0, $s0, 10
add   $s1, $s0, 0	 	 #don't need to add 10 for the location  
mul   $s0, $s0, 2         	 # Each offset is two-byte long.
mul   $s1, $s1, 2
lh    $t1, offset2($s0)   	 # Load $t1 with the offset at the index $s0.
lh    $t2, offset3($s1)   	 # Load $t2 with offset of the left sys board at index $s1
lb    $t4, sys_board($t2)
li    $t3, '+'                   # Put the marker in $t2.
beq   $t4, '0', ship_hit
sb    $t3, board($t1)
sb    $t3, sys_board($t2)
la    $a0, board
li    $v0, 4
syscall
jr    $ra
invalid_input: 
beq   $a0, '/', peek
la    $a0, invalid   #prints board again
li    $v0, 4
syscall
jr    $ra
peek:
la    $a0, sys_board
li    $v0, 4
syscall
jr    $ra
la    $a0, board    #prints board again
li    $v0, 4
li    $v0, 10	    #exits
syscall
ship_hit:
li   $t5, 'X'
sb   $t5, board($t1)
sb   $t5, sys_board($t2)
sub  $s7, $s7, 1
la   $a0, board
li   $v0, 4
syscall
############### places players ships #########################################
find_spot:
blt  $a0, '0', not_number       #if less than 0, not a number. tests to see if letter
bgt  $a0, '9', not_number       #if greater than 9, not a number. tests to see if letter
sub  $s0, $a0, '0'              #otherwise, subtracts difference for ascii value
#add to board
mul  $s0, $s0, 2         	# Each offset is two-byte long.
lh   $t1, offset1($s0)  	# Load $t1 with the offset of the index $t0.
li   $t2, '0'            	# Put the marker in $t2.
sb   $t2, board($t1)
jr   $ra
not_number:   
blt   $a0, 'a', not_letter    	#if v0 is less than a, not a letter. 
bgt   $a0, 'z', not_letter   	#if v0 is more than z, not a letter.
sub   $s0, $a0, 'a'           	#otherwise, subtract/add the difference of ascii value
add   $s0, $s0, 10
mul   $s0, $s0, 2         	# Each offset is two-byte long.
lh    $t1, offset1($s0)   	# Load $t1 with the offset of the index $t0.
li    $t2, '0'            	# Put the marker in $t2.
sb    $t2, board($t1)
jr    $ra
not_letter: 
la     $a0, board    		#prints board again
li     $v0, 4
syscall
jr     $ra
la     $a0, board   		#prints board again
li     $v0, 4
li     $v0, 10
syscall
######################## check for duplicates #####################
check_dup:
li	$a0,0				# set 'boolean' value
lh	$t1, offset4($t0)		# Load $t1 with offset of position we are checking (offset4).
lb	$t2, board($t1)			
beq	$t2, '.', not_dup		# if not duplicate, quit with $a0 = 0
li	$a0,1				# else, $a0 = 1
#do not need to print error message because is considered "internal service error"
#and user does not need to know the computer needs to retry
not_dup:
jr $31 # done
######################## end of game stuff ########################
player_won:
la    $a0, you_won
li    $v0, 4
syscall
j newgame
sys_won:
la    $a0, system_won
li    $v0, 4
syscall
j newgame
######################### new game ################################
newgame:
la    $a0, new
li    $v0, 4
syscall
li    $v0, 8
la    $a0, new_resp
li    $a1, 2
syscall
lb    $t0, new_resp
li    $t1, 'y'
beq   $t0, $t1, clearboard 	#if user enters y, new game. go back to top
bne   $t0, $t1, thankyou   	#else, print thank you and quit
thankyou:
la    $a0, thanks 		#prints thank you
li    $v0, 4
syscall 
li    $v0, 10 			#quits game
syscall
