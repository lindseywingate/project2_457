#get input, store in word
	la	$a0,	destroy_in
	la	$a1,	destroy_in
	li	$v0,	8
	syscall
	
	#print out to confirm input
	la	$a0,	destroy_in
	li	$v0,	4
	syscall