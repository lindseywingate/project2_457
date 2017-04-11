is_top:
beq   $a0, 6, is_top_left_corner
beq   $a0, 8, return_top
beq   $a0, 10, return_top
beq   $a0, 12, return_top
beq   $a0, 14, return_top
beq   $a0, 16, is_top_right_corner
j     is_bottom
is_bottom:
beq   $a0, 251, is_bottom_left_corner
beq   $a0, 253, return_bottom
beq   $a0, 255, return_bottom
beq   $a0, 257, return_bottom
beq   $a0, 259, return_bottom
beq   $a0, 261, is_bottom_right_corner
j     is_right
is_right:
beq   $a0, 65,  return_right
beq   $a0, 114, return_right
beq   $a0, 163, return_right
beq   $a0, 212, return_right
beq   $a0, 261, return_right
j     is_left
is_left:
beq   $a0, 55, return_left
beq   $a0, 57, return_left
beq   $a0, 59, return_left
beq   $a0, 61, return_left
beq   $a0, 63, return_left
addi  $a1, $a1, 0
jr    $ra
return_left:
addi  $a1, $a1, 1
jr    $ra
return_right:
addi  $a1, $a1, 2
jr    $ra
return_top:
addi  $a1, $a1, 3
jr    $ra
return_bottom:
addi  $a1, $a1, 4
jr    $ra
is_top_left_corner:
addi  $a1, $a1, 5
jr    $ra
is_top_right_corner:
addi $a1, $a1, 6
jr $ra
is_bottom_left_corner:
addi $a1, $a1, 7
jr $ra
is_bottom_right_corner:
addi $a1, $a1, 8
jr   $ra


######################## system ship placement ###################
placement:
xor   $a0,$a0,$a0
li    $a1, 2
li    $v0, 42			
syscall

bne   $a1, 0, put_horizontal
addi  $t0, $a3, 49
lh    $t1, offset3($t0)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, '*'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)    

put_horizontal:
addi  $t0, $a3, 2
lh    $t1, offset3($t0)   		# Load $t1 with the offset value (of the translated index).
lb    $t4, sys_board($t1)     		# load board piece into $t4
li    $t3, '*'            		# Put the marker in $t3.
sb    $t3, sys_board($t1)
jr    $ra