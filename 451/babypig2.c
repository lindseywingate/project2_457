#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/shm.h>
#include <semaphore.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
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
	int write_value = toString(argv[4]); 
//check if semaphore is free
	value = semctl(semid, 0, GETVAL);
	if(value==1) {
		semctl(semid, 0, SETVAL);
		FILE*stuff;
		int c;
		stuff = fopen(argv[0], "r");

		time_t t;
		srand((unsigned) time(&t));
		int r = rand() % 10;
		int count = 0;
		while(count<1) {
			c=fgetc(stuff);
				//putchar(c);
				char string[] = "Hello World!\n";
				write(write_value, string, (strlen(string)+1));
				printf("sending string...%s", string);
				count++;
		}
		semctl(semid, 1, SETVAL);	
		fclose(stuff);
	}

	return 0;	
}
