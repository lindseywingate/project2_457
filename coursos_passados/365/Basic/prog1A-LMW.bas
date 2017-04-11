10 INPUT "Please insert the cost of a product" X 
20 INPUT "Please insert the amount of cash paid for the product" Y 
30 PRINT X 
40 PRINT Y 
50 IF Y>=X THEN GOTO 60 
55 IF X>Y THEN GOTO 120
60 LET Z = (Y-X)*100
65 PRINT Z
70 IF Z>100 THEN LET dollars = Z\100
71 IF Z<100 THEN GOTO 80
72 LET dollars = INT(dollars)
75 PRINT "Dollars: " PRINT dollars
77 LET Z = Z-(dollars*100)
80 IF Z>25 THEN LET quarters = Z\25
81 IF Z<25 THEN GOTO 90
82 LET quarters = INT(quarters)
85 PRINT "Quarters: " PRINT quarters
87 LET Z = Z-(quarters*25)
90 IF Z>10 THEN LET dimes = Z\10
91 IF Z<10 THEN GOTO 100
92 LET dimes = INT(dimes)
95 PRINT "Dimes: " PRINT dimes
97 LET Z = Z-(dimes*10)
100 IF Z>5 THEN LET nickels = Z\5
101 IF Z<5 THEN GOTO 110
102 LET nickels = INT(nickels)
105 PRINT "Nickels: " PRINT nickels
107 LET Z = Z-(nickels*5)
110 IF Z>1 THEN LET pennies = Z\1
111 IF Z<1 THEN GOTO 117
112 LET pennies = INT(pennies)
113 PRINT "Pennies: " PRINT pennies
115 LET Z = Z - pennies
117 END
120 PRINT "Insufficient amount was paid."
125 END 
