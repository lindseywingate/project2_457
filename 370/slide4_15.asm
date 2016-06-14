       .data
 X:    .byte  1
 Y:    .half  2
       .text 
 main: 
       li  $t0, 1
       sh  $t0, X+2
       lh  $a0, Y
       li  $v0, 1
       syscall