.data
board:		.ascii   	   	"\n\n    . . . . . .      0 1 2 3 4 5"
		.ascii    		 "\n    . . . . . .      6 7 8 9 a b"
		.ascii    		 "\n    . . . . . .      c d e f g h"
		.ascii    		 "\n    . . . . . .      i j k l m n"
		.ascii    		 "\n    . . . . . .      o p q r s t"
		.asciiz   		 "\n    . . . . . .      u v w x y z\n"
		
statement1:	.asciiz			"\nStart Showing a One-Player Gomoku Game."
statement2:	.asciiz			"\nEnter the next move: (0..z) "
statement3:	.asciiz			"\nContinue? (y/n) "    
statement4:	.asciiz			"\nNew game? (y/n)"
duplicate:	.asciiz			"\n***** Duplicate move! *****"
wrong:		.asciiz			"\n***** Wrong move! ******"
end:		.asciiz			"\n-- The program is finished running. --"
gameisatie:	.asciiz			"\n I'm sorry but the game is tied."

urplayerO:	.asciiz			"\nYou are the player O. Enter the next move: (0..z)"
computerX:	.asciiz			"\nI (the System) am the player X and my move is: "
xwins:		.asciiz			"\nComputer (X) won!"
owins:		.asciiz			"\nYou (O) won!"
buf:		.space	2		# space for input strings 

addr:		.half     6,   8,  10,  12,  14,  16  
		.half    39,  41,  43,  45,  47,  49
		.half    72,  74,  76,  78,  80,  82
		.half   105, 107, 109, 111, 113, 115
		.half   138, 140, 142, 144, 146, 148
		.half   171, 173, 175, 177, 179, 181

won:		.ascii   "1237el6ci                        "      # 0
		.ascii   "0232348fm7dj                     "      # 1
		.ascii   "0131343459gn8ek                  "      # 2
		.ascii   "0121242459fl8di                  "      # 3
		.ascii   "123235agm9ej                     "      # 4
		.ascii   "234bhnafk                        "      # 5
		.ascii   "7890ciciodkr                     "      # 6
		.ascii   "68989a0elels1djdjp               "      # 7
		.ascii   "67979a9ab2ekekq3di1fmfmt         "      # 8
		.ascii   "67878a8ab2gn3flflr4ejejo         "      # 9
		.ascii   "78989b4gmgmsfkp5fk               "      # a
		.ascii   "89a5hnhntglq                     "      # b
		.ascii   "def06i6ioioujqx                  "      # c
		.ascii   "cefefg6krkry17j7jpjpv38i         "      # d
		.ascii   "cdfdfgfgh07l7lslsz28k8kqkqw49j9jo"      # e
		.ascii   "cdedegegh18m8mt39l9lrlrx5akakpkpu"      # f
		.ascii   "defefh29n4amamsmsyblqlqv         "      # g
		.ascii   "efg5bnbntntzmrw                  "      # h
		.ascii   "jkl06c6cocou38d                  "      # i
		.ascii   "iklklmcqx17d7dpdpv49e9eo         "      # j
		.ascii   "ijljlmlmn6drdry28e8eqeqw5afafpfpu"      # k
		.ascii   "ijkjkmkmn07e7esesz39f9frfrxbgqgqv"      # l
		.ascii   "jklkln18f8ft4agagsgsyhrw         "      # m
		.ascii   "klm29g5bhbhthtz                  "      # n
		.ascii   "pqr6ciciu9ej                     "      # o
		.ascii   "oqrqrs7djdjvafkfku               "      # p
		.ascii   "oprprsrstcjx8ekekwbglglv         "      # q
		.ascii   "opqpqsqst6dkdky9flflxhmw         "      # r
		.ascii   "pqrqrt7elelzagmgmy               "      # s
		.ascii   "qrs8fmbhnhnz                     "      # t
		.ascii   "ciofkpvwx                        "      # u
		.ascii   "uwxwxydjpglq                     "      # v
		.ascii   "uvxvxyxyzekqhmr                  "      # w
		.ascii   "uvwvwywyzcjqflr                  "      # x
		.ascii   "vwxwxzdkrgms                     "      # y
		.ascii   "wxyelshnt                        "      #		
													
.text
main:

clearboard:
li	$t3,36				# number of fields to clear
li	$t8,0				# field counter

loop:
mul	$t0, $t8, 2			# Each offset is two-byte's long.
lh	$t1, addr($t0)			# Load $t1 with the offset of the index $t0.
li	$t2, '.'			# Put the piece '.' in $t2.
sb	$t2, board($t1)			# Put the piece at the location, board+offset.
addi	$t8,$t8,1			# next field
bne	$t3,$t8,loop
 
li	$v0,4				# print a string
la	$a0,statement1			# print statement 1
syscall

xor $a0,$a0,$a0				# Set a seed number.
li $a1, 2				# random number 0 to 1
li $v0, 42				# random number generator
syscall					# $a0 now contains the new random number

startpiece:
move	$t5,$a0				# move a0 value of random seed into t5
bgtz	$t5,startmarkX			# even numbers
beqz	$t5,playerOstarts		# odd numbers

startmarkX: 				

continueyes:
li	$t2, 'X'			# then X
printboard:
li	$v0,4				# print a string
la	$a0,board			# print the board    
syscall
 
# computer plays
li	$v0,4				# print a string
la	$a0,computerX			# print statement 2
syscall
# CODE FOR RANDOM move
computer_move:
xor $a0,$a0,$a0				# Set a seed number.
li $a1, 36				# random number 0 to 35
li $v0, 42				# random number generator
syscall
# random move is now in $a0, store in $t0 
move	$t0, $a0

# check duplicate move
mul	$t0, $t0, 2			# Each offset is two-byte long.
jal	check_duplicate_move
beqz    $a0,checkoddoreven		# ok: continue
j	computer_move			# not ok: choose again

checkoddoreven:
li	$t2, 'X'			# computer move

markX:
# do some waiting to assume intelligence :)
li	$v0,32
la	$a0,2000		
syscall
# markX code
lh	$t1, addr($t0)			# Load $t1 with the offset of the index $t0.
sb	$t2, board($t1)			# Put the piece at the location, board+offset.

#check if won, given than $t0 was the last move
jal check_won
beqz $a0,no_comp_win
#player O won
li	$v0,4				# print a string
la	$a0,board			# print the board 
syscall
li	$v0,4
la	$a0,xwins
syscall
j newgame

no_comp_win:
#check if its a tie
jal check_tie
bnez 	$a0,handle_tie

playerOstarts:
li	$v0,4				# print a string
la	$a0,board			# print the board 
syscall
li	$v0,4				# print a string
la	$a0,urplayerO			# print statement 2
syscall
li	$v0,8				# read a string
la	$a0,buf				# buffer
li	$a1,2				# length of buffer
syscall
 
# convert the ascii value in buf to an index for the board
lb	$t0,buf				# read buf

#check if legal move
move $a0,$t0
jal legal_move
beqz $a0,error

#convert to index
move $a0,$t0
jal ascii_to_index
move $t0,$a0

# check duplicate move
mul	$t0, $t0, 2			# Each offset is two-byte long.
jal	check_duplicate_move
beqz    $a0,checkoddoreven2		# ok: continue
li	$v0,4				# print a string
la	$a0,duplicate			# print duplicate error
syscall
j	playerOstarts

checkoddoreven2:
li	$t2, 'O'			# other piece

# assign input to board, input is in $t0, and already multiplied by 2
markX2:
lh	$t1, addr($t0)			# Load $t1 with the offset of the index $t0.
sb	$t2, board($t1)			# Put the piece at the location, board+offset.
li	$v0,4				# print a string
la	$a0,board			# print the board    
syscall

 #check if won, given than $t0 was the last move
 jal check_won
 beqz $a0,doyouwanttocontinue
 #player O won
 li	$v0,4
 la	$a0,owins
 syscall
 j newgame
 
#check if its a tie
jal check_tie
bnez 	$a0,handle_tie
 
# Do you want to continue
doyouwanttocontinue:
li	$v0,4				# print a string
la	$a0,statement3			# print statement 3
syscall
li	$v0,8				# read a string
la	$a0, buf			# buffer
li	$a1, 2				# length of buffer
syscall
 
# if continue = y can use beq statement and jump up to continueyes
lb	$t0,buf
li	$t1,'y'
beq	$t0,$t1,continueyes

newgame:
li	$v0,4				# print a string
la	$a0,statement4			# print statement 4
syscall
li	$v0,8				# read a string
la	$a0, buf			# buffer
li	$a1, 2				# length of buffer
syscall
 
# if newgame=y can use beq statement and jump up to main for new game
lb	$t0,buf
li	$t1,'y'
beq	$t0,$t1,clearboard		# to do: clear all board values to initial
j exit
 
error:
# print error for wrong user input
li	$v0,4				# print a string
la	$a0,wrong			# print wrong
syscall
j 	playerOstarts
 
exit:
li	$v0,10				# exit
syscall
 
#print that its a tie, jump to newgame
handle_tie:
li	$v0,4				# print a string
la	$a0,gameisatie			# print gameisatie
syscall
j	newgame

# function to convert ascii to index, inplace conversion of $a0
# only 0-9 or a-z is allowed
ascii_to_index:
blt $a0,'a',numeric
# a-z: convert by subtracting 'a' and adding 10
subi $a0,$a0,'a'
addi $a0,$a0,10
jr $31 # done: return
numeric:
# 0-9: convert by subtracting '0'
subi $a0,$a0,'0'
jr $31	# done: return
 
# function to check if $a0 is in the range of 0-9 or a-z, makes $a0 0 if out of range
legal_move:
bgt $a0,'z',legal_move_false
blt $a0,'0',legal_move_false
bgt $a0,'9',legal_move_a_z
j legal_move_true
legal_move_a_z:
blt $a0,'a',legal_move_false
legal_move_true:
li $a0,1
jr $31 # done: return
legal_move_false:
li $a0,0
jr $31 # done: return
 
# function $a0 = check_tie()
check_tie:
li	$t3,36				# number of fields to check
li	$t8,0				# field counter
li	$a0,0				# assume it will not be a tie
check_tie_loop:
mul	$t0, $t8, 2			# Each offset is two-byte's long.
lh	$t1, addr($t0)			# Load $t1 with the offset of the index $t0.
lb	$t2, board($t1)			# load the piece from the location, board+offset.
beq	$t2,'.',it_is_not_a_tie		# if there is only one '.', its not a tie
addi	$t8,$t8,1			# next field
bne	$t3,$t8,check_tie_loop
li $a0,1
it_is_not_a_tie:
jr $31 # done
#end function

#function $a0=check_duplicated_move($t0)
check_duplicate_move:
li	$a0,0				# assume its not duplicate
lh	$t1, addr($t0)			# Load $t1 with the offset of the index $t0.
lb	$t2,board($t1)			# Load piece from board into $t2
beq	$t2,'.',it_is_not_a_duplicate_move	# true if not a duplicated move
li	$a0,1
it_is_not_a_duplicate_move:
jr $31 # done


 #function $a0=check_won($t0), $t1 and $t2 are used as temporary variable, $t0 is already 2byte index
 check_won:
 move $28,$31	# store return register as we are doing function calls from this function
 # read piece of last move ($t0) into $t2
 lh	$t1, addr($t0)			# Load $t1 with the offset of the index $t0.
 lb	$t2, board($t1)			# read the piece at the location, board+offset.
 # convert 2byte index back to normal index
 sra $t0,$t0,1	# divide by 2
 # calculate index to correct won string
 mul $t0,$t0,33	# 33 is the length of each won string
 # loop over all (11) groups of 3 moves in selected string,
 li $a1,0
 won_loop:
 li	$t3,0			# use $t3 as comparison accumulator
 lb	$a0,won($t0)	# get first board position
 jal	ascii_to_index	# convert to index
 sll	$a0,$a0,1 	# convert to 2 byte index
 lh	$t1, addr($a0)	# Load $t1 with the offset of the index $t0.
 lb	$t1, board($t1)	# read the piece at the location, board+offset.
 sub 	$t1,$t1,$t2	# compare with last move
 or	$t3,$t3,$t1	# remember difference
 add	$t0,$t0,1	# next
 lb	$a0,won($t0)	# get second board position
 jal	ascii_to_index	# convert to index
 sll	$a0,$a0,1 	# convert to 2 byte index
 lh	$t1, addr($a0)	# Load $t1 with the offset of the index $t0.
 lb	$t1, board($t1)	# read the piece at the location, board+offset.
 sub 	$t1,$t1,$t2	# compare with last move
 or	$t3,$t3,$t1	# remember difference
 add	$t0,$t0,1	# next
 lb	$a0,won($t0)	# get third board position
 jal	ascii_to_index	# convert to index
 sll	$a0,$a0,1 	# convert to 2 byte index
 lh	$t1, addr($a0)	# Load $t1 with the offset of the index $t0.
 lb	$t1, board($t1)	# read the piece at the location, board+offset.
 sub 	$t1,$t1,$t2	# compare with last move
 or	$t3,$t3,$t1	# remember difference
 add	$t0,$t0,1	# next
 beqz	$t3,winning 	# if $t3 is now zero it means a winning combination is found
 add	$a1,$a1,1	# loopcounter++
 bne $a1,11,won_loop
 li $a0,0 		# no winning combination
 jr $28
 winning:
 li $a0,1		# won!
 jr $28
