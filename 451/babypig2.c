#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/shm.h>
#include <semaphore.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <time.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	//printf("\nFILENAME: %s\n PIPEID %s\n SEMID %s\n SHAREDMEMID %s\n", argv[0], argv[1], argv[2], argv[3]);

	FILE*stuff;
	int c;
	stuff = fopen(argv[0], "r");

	time_t t;
	srand((unsigned) time(&t));
	int r = rand() % 10;

	while((c=fgetc(stuff)) !=EOF)
		putchar(c);
	fclose(stuff);	
	printf("NUMBER IS: %d", r);
	return 0;	
}
