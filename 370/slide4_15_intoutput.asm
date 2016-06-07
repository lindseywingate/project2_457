       .data
 val:  .word   0 
       .text 
 main:
       li  $v0, 5
       syscall 
       # Enter "12345".
       sw  $v0, val
       la  $a0, val
       li  $v0, 1
       syscall