#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/shm.h>
#include <semaphore.h>
#include <sys/ipc.h>
#include <sys/sem.h>

int main(int argc, char *argv[]) {
	//printf("\nFILENAME: %s\n PIPEID %s\n SEMID %s\n SHAREDMEMID %s\n", argv[0], argv[1], argv[2], argv[3]);

	FILE*stuff;
	int c;
	stuff = fopen(argv[0], "r");
	while((c=fgetc(stuff)) !=EOF)
		putchar(c);
	fclose(stuff);		
}
