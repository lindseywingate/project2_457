/*This code was written by Lindsey Wingate*/
/*FORK, EXE (6), PIPE (no FIFOS), SEMGET, SEMOP, SEMCTL, SHMGET, SHMAT. 
POSIX not allowed
*/
#include <stdio.h> /*required for print statements*/
#include <unistd.h> /*required for POSIX operating system*/
#include <sys/types.h> /*required for definitions of types*/
#include <sys/shm.h> /*shared memory segment control structures and prototypes*/ 
#include <semaphore.h> /*allows semaphore library*/
#include <sys/ipc.h> 
#include <sys/sem.h>
#define MAX_COUNT 10

void read_from_pipe (int file) {
	FILE *stuff;
	int c;
	stuff = fdopen(file,"r");
	while((c=fgetc(stuff)) !=EOF)
		putchar(c);
	fclose(stuff);
}

int main(int argc, char *argv[]) {
	char filename[100];
	int i, semid;
	key_t key = 200;
	printf("%s\n", argv[1]);

	//initialize semaphores
	semid = semget(key, 1, 0666 | IPC_CREAT);
	if(semid<0) {
		printf("Didn't create semaphore set.");
	}	
	semctl(semid, 0, SETVAL, 1);
	
	//initialize shared memory space
	int sharedmemoryidentifier = shmget(key, 0, IPC_CREAT | 0666);
	
	//initialize pipes
	int pipe1[2];
	pid_t _p1;
	pipe(pipe1);
	
	char memid_c[10];
	sprintf(memid_c, "%d", sharedmemoryidentifier);
		
	system("gcc -o pig babypig.c");

	if((_p1 = fork()) == -1) {
		perror("fork");
	}
	if(_p1 == 0) { //close 0, for writing. close 1 for reading
		char *args[] = {argv[1], "_p1", "200", memid_c, NULL};//filename, pipe id, sem id, shared mem id
		execvp("./pig", args);	
		close(pipe1[1]);
		read_from_pipe(pipe1[0]);
	}
	return 0;
}
/* tldp.org/LDP/lpg/node11.html */



/*This code was written by Lindsey Wingate*/
