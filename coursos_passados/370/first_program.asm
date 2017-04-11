.data #always has data and text section
    mymessage:    .asciiz    "Hello, World!\n"

.text #instructions
    li $v0, 4 #prepare for printing-putting value 4 into register shows you want to print to screen
    la $a0, mymessage #put value (hello world) into register
    syscall #do now
    
    