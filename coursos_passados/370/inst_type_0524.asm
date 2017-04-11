#Types of Instruction

R: add	$t1, $t2, $t3	#$t1 = $t2 + $t3
			#rd = rs + rt
			#refer to one of general purpose registers, 5 bit for rs, rd, rt 
			#opcode  = number of instruction (64 instructions) so need to use func to compliment
		
I: li	$v0, 4		#$v0 = 4
			#rd = imm
			#beq = branch equals
I: beq	$t1, $t2, L10	#if $t1 == $t2 then L10 (label)
			#   rs  == rd 	    offset