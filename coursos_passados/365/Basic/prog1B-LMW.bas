05 LET X = 0
20 INPUT "Please enter a score for a test on a scale from 0-100" X 
30 IF X < 0 THEN EXIT
40 IF X < 60 THEN GOTO 130
50 IF X < 70 THEN GOTO 120 
60 IF X < 80 THEN GOTO 110
70 If X < 90 THEN GOTO 100
80 IF X > 89 THEN GOTO 90
90 PRINT "The student got an A"
95 IF X > 0 THEN GOTO 20
100 PRINT "The student got a B"
105 IF X > 0 THEN GOTO 20
110 PRINT "The student got a C"
115 IF X > 0 THEN GOTO 20
120 PRINT "The student got a D"
125 IF X > 0 THEN GOTO 20
130 PRINT "The student got an F"
140 IF X > 0 THEN GOTO 20
