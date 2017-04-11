.text
 main: 
       li   $a0, 2147483647
       # The largest signed word
       #  is 2,147,483,647
       addu $a0, $a0, 1
       li   $v0, 1
       syscall                 
       li   $v0, 10
       syscall