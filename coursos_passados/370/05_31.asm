.data
	mychar:	.asciiz	"m"
	age:	.word	26
	PI:	.float	3.14
	mydub:	.double	7.202#in random access memory
	zerodub:.double	0.0
	num1:	.word	5
	num2:	.word	10
	num3:	.word	26
	num4:	.word	31

.text
	#multiplication
	#mult
	addi	$t0, $zero, 2000
	addi	$t1, $zero, 10
	
	mult	$t0,$t1 #product stored in hi/lo because larger nums
	
	mflo	$s0	#move from lo and stores in register you specify
	#display to screen
	li	$v0,	1
	add	$a0,$zero,$s0 #print out an int which is stored in zero (the product)
	syscall
	
	#mul
	#get values into registers without RAM
	addi	$s0, $zero, 10	#add 10+0, store result in $s0
	addi	$s1, $zero, 4	#add 4+0, store result in $s1
	
	mul	$t0, $s0, $s1	#destination/result of mult=$t0
	#restriction with mul: greatest range is two 16 bit numbers
	
		#displaying the product
	li	$v0,	1
	add	$a0,$zero,$t0
	syscall		

	#sub two nums
	lw	$s0,	num3 #$s0=26
	lw	$s1,	num4 #$s1=31
	
	sub $t0, $s0, $s1	#$t0=$s0-$s1
	
	li	$v0,	1	
	move	$a0, $t0	#move value from t0 to a0
	syscall
	
	#adding two nums
	lw	$t0,	num1($zero) #moving vals from memory to registers
	lw	$t1,	num2($zero)
	
	add	$t2,$t0,$t1		#t2=$t0+t1
	
	li	$v0,	1
	add	$a0,$zero,$t2		#print $t2	
	syscall
	
	#printing double
	ldc1	$f2,	mydub #need two registers to hold double, always specify pair (even register nums)
	ldc1	$f0,	zerodub
	li	$v0,	3 #print a double
	add.d	$f12,$f2,$f0 #adds zero to # in f2, f2 into f12
	syscall

	#printing float
	li	$v0,	2 #code for float
	lwc1 	$f12,	PI#always put in f12 (in coproc 1)
	syscall

	#printing int
	li	$v0,	1
	#one is the code for ints
	lw 	$a0,	age
	syscall
		
	#print char				
	li	$v0,	4
	la	$a0,	mychar
	syscall