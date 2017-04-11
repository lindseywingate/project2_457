.data
     sys_board:   .ascii   "\n\n    . . . . . .     . . . . . .      0 1 2 3 4 5"
             .ascii     "\n    . . . . . .     . . . . . .      6 7 8 9 a b"
             .ascii     "\n    . . . . . .     . . . . . .      c d e f g h"
             .ascii     "\n    . . . . . .     . . . . . .      i j k l m n"
             .ascii     "\n    . . . . . .     . . . . . .      o p q r s t"
             .asciiz    "\n    . . . . . .     . . . . . .      u v w x y z\n"
             
 offset3: .half     6,   8,  10,  12,  14,  16  
             .half    55,  57,  59,  61,  63,  65
             .half   104, 106, 108, 110, 112, 114
             .half   153, 155, 157, 159, 161, 163
             .half   202, 204, 206, 208, 210, 212
             .half   251, 253, 255, 257, 259, 261
      
    offset4: .half    22,  24,  26,  28,  30,  32  
             .half    71,  73,  75,  77,  79,  81
             .half   120, 122, 124, 126, 128, 130
             .half   169, 171, 173, 175, 177, 179
             .half   218, 220, 222, 224, 226, 228
             .half   267, 269, 271, 273, 275, 277
             
    cruiser_op: .ascii   "cde"
             .ascii   "def"
             .ascii   "efg"
             .ascii   "fgh"
             .ascii   "ijk"
            #.ascii   "jkl" 
             .ascii   "klm" 
             
             .text
 main:
       xor   $a0, $a0, $a0     # Set a seed number.
       li    $a1, 6            # random number 0 to 5
       li    $v0, 42           # random number generator
       syscall
 
       li    $t2, 'O'
       mul   $a0, $a0, 3
      
       lb    $t0, cruiser_op($a0)
       
       sub   $t0, $t0, 'a'
       mul   $t0, $t0, 2         #creates offset index to grab
       add   $t0, $t0, 10
       lh    $t1, offset3($t0)   # Load $t1 with the offset of the index $t0.  
       sb    $t2, sys_board($t1)     # Put the marker at the location, board+offset.

       add   $a0, $a0, 1
       lb    $t0, cruiser_op($a0)
       sub   $t0, $t0, 'a'
       mul   $t0, $t0, 2
       add   $t0, $t0, 10
       lh    $t1, offset3($t0)   # Load $t1 with the offset of the index $t0.    
       sb    $t2, sys_board($t1)     # Put the marker at the location, board+offset.

       add   $a0, $a0, 1
       lb    $t0, cruiser_op($a0)
       sub   $t0, $t0, 'a'
       mul   $t0, $t0, 2
       add   $t0, $t0, 10
       lh    $t1, offset3($t0)   # Load $t1 with the offset of the index $t0.       
       sb    $t2, sys_board($t1)     # Put the marker at the location, board+offset.

	la    $a0, sys_board
       li    $v0, 4
       syscall    
       
      li   $v0, 10
      syscall