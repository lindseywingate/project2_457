#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/shm.h>
#include <semaphore.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <time.h>
#include <stdlib.h>

int toString(char a[]) {
	int c, sign, offset, n;
	if (a[0] == '-') {
		sign = -1;
	}
	if (sign == -1) {
		offset = 1;
	}
	else {
		offset = 0;
	}
	n = 0;
	for (c = offset; a[c] != '\0'; c++) {
		n = n * 10 + a[c] - '0';
	}
	if (sign == -1) {
		n = -n;
	}
	return n;
}

int main(int argc, char *argv[]) {
	//printf("\nFILENAME: %s\n PIPEID %s\n SEMID %s\n SHAREDMEMID %s\n", argv[0], argv[1], argv[2], argv[3]);
	int value;
	int pipeid = toString(argv[1]);
	int semid = toString(argv[2]);
	int memid = toString(argv[3]);
//check if semaphore is free
	value = semctl(semid, 0, GETVAL);
	if(value==1) {
		semctl(semid, 0, SETVAL, 0);
		FILE*stuff;
		int c;
		stuff = fopen(argv[0], "r");

		time_t t;
		srand((unsigned) time(&t));
		int r = rand() % 10;

		while(r>0) {
		c=fgetc(stuff);
			putchar(c);
			r--;
		}
		fclose(stuff);	
	}

	semctl(semid, 0, SETVAL, 1);

	return 0;	
}
