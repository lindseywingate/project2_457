/*This is the piggy! by Lindsey Wingate*/
#include <stdio.h> /*required for print statements*/
#include <unistd.h> /*required for POSIX operating system*/
#include <sys/types.h> /*required for definitions of types*/
#include <sys/shm.h> /*shared memory segment control structures and prototypes*/ 
#include <semaphore.h> /*allows semaphore library*/
#include <sys/ipc.h> 
#include <sys/sem.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int semid, sharedmemid;
	char str[20];
	int pipe1[2], nbytes;
	pid_t _p1;
	char readbuffer[80];	

	printf("Piggy is working!");	
//	printf("ARG1%s, ARG2%s, ARG3%s, ARG4%s", argv[0], argv[1], argv[2], argv[3]);

 	strcpy(str, argv[2]);
	semid = atoi(str);
	strcpy(str, argv[3]);
	sharedmemid = atoi(str); 

	printf("\nFILENAME: %s\n PIPEID %s\n SEMID %d\n SHAREDMEMID %d\n", argv[0], argv[1], semid, sharedmemid);  

	semid = semget(200, 5, 0666);

	close(pipe1[0]);
	nbytes = read(pipe1[0], readbuffer, sizeof(readbuffer));
	printf("Received string: %s", readbuffer);	
	
}





/*baby pig code written by Lindsey Wingate*/
