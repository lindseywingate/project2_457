
ffset1:
	   .half     6,   8,  10,  12,  14,  16
           .half    55,  57,  59,  61,  63,  65
           .half   104, 106, 108, 110, 112, 114
           .half   153, 155, 157, 159, 161, 163
           .half   202, 204, 206, 208, 210, 212
           .half   251, 253, 255, 257, 259, 261
offset2:
	   .half    22,  24,  26,  28,  30,  32
           .half    71,  73,  75,  77,  79,  81
           .half   120, 122, 124, 126, 128, 130
           .half   169, 171, 173, 175, 177, 179
           .half   218, 220, 222, 224, 226, 228
           .half   267, 269, 271, 273, 275, 277

put_2_right
put_2_left
put_2_up
put_2_down
put_horizontal
put_vertical

middle: 0
top_row: 1
top_left: 2
top_right: 3
bottom_left: 4
bottom_right: 5
bottom_row: 6
left_side: 7
right_side: 8

random_orientation:
xor  $a0, $a0, $a0
li   $a2, 4
li   $v0, 42

beq  $a2, 0, check_top2
beq  $a2, 1, check_bottom2
beq  $a2, 2, check_left2
beq  $a2, 3, check_right2

check_top2:
sub   $a2, $a2, 49
lh    $t1, offset3($a2)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
beq   $t4, '0',	random_cruiser	# if already contains 0, retry random #
sub   $a2, $a2, 49
lh    $t1, offset3($a2)
lb    $t4, sys_board($t1)
beq   $t4, '0', random_cruiser
j     put_top

check_bottom2:
add   $a2, $a2, 49
lh    $t1, offset3($a2)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
beq   $t4, '0',	random_cruiser	# if already contains 0, retry random #
add   $a2, $a2, 49
lh    $t1, offset3($a2)
lb    $t4, sys_board($t1)
beq   $t4, '0', random_cruiser
j     put_bottom

check_left2:
sub   $a2, $a2, 2
lh    $t1, offset3($a2)			# Load with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
beq   $t4, '0',	random_cruiser	# if already contains 0, retry random #
sub   $a2, $a2, 2
lh    $t1, offset3($a2)
lb    $t4, sys_board($t1)
beq   $t4, '0', random_cruiser
j     put_left

check_right2:
add   $a2, $a2, 2
lh    $t1, offset3($a2)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
beq   $t4, '0',	random_cruiser	# if already contains 0, retry random #
add   $a2, $a2, 2
lh    $t1, offset3($a2)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
beq   $t4, '0',	random_cruiser	# if already contains 0, retry random #
j     put_right

put_top:
put_bottom:
put_left:
put_right:




################################################more....

destroyer draft that sucked
xor   $a0,$a0,$a0			#seed number
li    $a1, 36				#set range 0-35
li    $v0, 42				#randomly choose number
syscall
mul   $t0, $a0, 2				#translate index to compare for edges
lh    $t1, offset3($t0)			
lb    $t4, sys_board($t1)			# load board piece into $t4
li    $t3, '$'					# Put the marker in $t3.
sb    $t3, sys_board($t1)			# Put the marker in the offset index player left board
move  $a0, $t1
beq   $a0, 6, tobottom_2
beq   $a0, 16, tobottom_2
beq   $a0, 251, totop_2
beq   $a0, 261, totop_2
beq   $a0, 8, tobottom_2
beq   $a0, 10, tobottom_2
beq   $a0, 12, tobottom_2
beq   $a0, 14, tobottom_2
beq   $a0, 65, toleft_2
beq   $a0, 114, toleft_2
beq   $a0, 163, toleft_2
beq   $a0, 212, toleft_2
beq   $a0, 261, toleft_2
beq   $a0, 259, totop_2
beq   $a0, 257, totop_2
beq   $a0, 255, totop_2
beq   $a0, 253, totop_2
beq   $a0, 202, toright_2
beq   $a0, 153, toright_2
beq   $a0, 104, toright_2
beq   $a0, 55, toright_2

toleft_2:
sub   $t0, $a0, 2
lh    $t1, offset3($t0)			
lb    $t4, sys_board($t1)			
li    $t3, '0'					
sb    $t3, sys_board($t1)			
sub   $t0, $t0, 2
lh    $t1, offset3($a2)			
lb    $t4, sys_board($t1)			
li    $t3, '0'					
sb    $t3, sys_board($t1)			

toright_2:
add   $t0, $a0, 2
lh    $t2, offset3($t0)			
lb    $t4, sys_board($t2)			
li    $t3, '0'					
sb    $t3, sys_board($t1)			
add   $t0, $t0, 2
lh    $t1, offset3($a2) 
lb    $t4, sys_board($t1)		
li    $t3, '0'					
sb    $t3, sys_board($t1)			

tobottom_2:
add   $t0, $a0, 49
lh    $t2, offset3($t0)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t2)			# load board piece into $t4
li    $t3, '0'					# Put the marker in $t3.
sb    $t3, sys_board($t1)		# Put the marker in the offset index player left board
add   $t0, $t0, 49
lh    $t1, offset3($a2)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
li    $t3, '0'					# Put the marker in $t3.
sb    $t3, sys_board($t1)		# Put the marker in the offset index player left board

totop_2:
sub   $t0, $a0, 49
lh    $t1, offset3($t0)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
li    $t3, '0'					# Put the marker in $t3.
sb    $t3, sys_board($t1)     
sub   $t0, $t0, 49
lh    $t1, offset3($a2)			# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)			# load board piece into $t4
li    $t3, '0'					# Put the marker in $t3.
sb    $t3, sys_board($t1) 
