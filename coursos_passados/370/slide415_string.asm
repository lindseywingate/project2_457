.data
s1:	.ascii	"abc"
s2:	.asciiz	"xyz"

.text
main:
	la $a0, s1
	li $v0, 4
	syscall