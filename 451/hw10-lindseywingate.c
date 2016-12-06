/*This code was written by Lindsey Wingate*/
/*mama checks semaphore to see if free
mama forked and exec five piggies, passing:
	filename
	pipe identifiers
	semaphore identifier
	shared memory identifier as command line args
little pigs names: _p1, _p2, etc

little pig runs?
	checks semaphore
	if free, locks. else, waits until free
	generates random number N 1-10 and reads that many chars
	passes name plus chars to mother pig and adds N to shared memory
	mama pig extracts chars from pipe and writes to file hw10.out and frees semaphore

last little piggy passes last chars and final N to mama pig
then signals all other pigs to shut down
*watch for EOF

final N will always be equal or greater than the actual num of chars read.

FUNCTIONS USED:
FORK, EXE (6), PIPE (no FIFOS), SEMGET, SEMOP, SEMCTL, SHMGET, SHMAT. 
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

//void ChildProcess(void);
//void ParentProcess(void);

int main(int argc, char *argv[]) {
	char filename[100];
	int i, semid;
	key_t key = 200;
	//printf("%s\n", argv[i]);
	//initialize semaphores
	semid = semget(key, 5, 0666 | IPC_CREAT);
	if(semid<0) {
		printf("Didn't create semaphore set.");
	}	
	semctl(semid, 0, SETVAL, 1);
	semctl(semid, 1, SETVAL, 0);
	semctl(semid, 2, SETVAL, 0);
	semctl(semid, 3, SETVAL, 0);
	semctl(semid, 4, SETVAL, 0);
	int size = 0;
	int sharedmemoryidentifier;
	//initialize shared memory space
	shmget(key, size, IPC_CREAT | 0666);
	//shmctl() allows shared memory access to other processes 
	//shmat() shared segment attched to process address space
	//shmget(key_t key access with sema id, size_t size in bytes of requested mem, shmflg specifies initial access permissions and creation control flags)
	//initialize pipes
	int pipe1[2];
	pid_t _p1;
//	int pipe2[2];
//	pid_t _p2;
//	int pipe3[2];
//	pid_t _p3;
//	int pipe4[2];
//	pid_t _p4;
//	int pipe5[2];
//	pid_t _p5;
	//pipe children off
	pipe(pipe1);
//	pipe(pipe2);
//	pipe(pipe3);
//	pipe(pipe4);
//	pipe(pipe5);


	system("gcc -o pig babypig.c");
	if((_p1 = fork()) == -1) {
		perror("fork");
	}
	if(_p1 == 0) { //close 0, for writing. close 1 for reading
		execvp("./pig", (char*[]){"./pig", argv[1], NULL});	
		close(pipe1[1]);
		//nbytes = read(pipe1[0], readbuffer, sizeof(readbuffer));
		//printf("Received string: %s", readbuffer);	
	}
}

/*If the parent wants to receive data from the child, it should close fd1, and the child should close fd0. If the parent wants to send data to the child, it should close fd0, and the child should close fd1. Since descriptors are shared between the parent and child, we should always be sure to close the end of pipe we aren't concerned with. On a technical note, the EOF will never be returned if the unnecessary ends of the pipe are not explicitly closed. tidp.org/LDP/lpg/node11.html */

/*	pid_t pid;
	pid = fork();
	if (pid==0) 
		ChildProcess();	
	else
		ParentProcess();

void ChildProcess(void)
{
	int i;
	for (i=1; i<=MAX_COUNT; i++)
		printf("THIS LINE IS FROM CHILD< VALUE = %d\n", i);
	printf("Child process is done\n");
}

void ParentProcess(void) 
{
	 int   i;
     for (i = 1; i <= MAX_COUNT; i++)
          printf("This line is from parent, value = %d\n", i);
     printf("*** Parent is done ***\n");

}
*/
/*This code was written by Lindsey Wingate*/
