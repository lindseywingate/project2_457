#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/shm.h>
#include <semaphore.h>
#include <sys/ipc.h>
#include <sys/sem.h>

int main(int argc, char *argv[]) {
	char filename[100]; //used for filename passed in
	int i, semid, memid;
	key_t key = 200;
	printf("%s\n", argv[1]);

	semid = semget(key, 0, IPC_CREAT);//create semaphore
	if(semid==-1)
		perror("semget: semaphore creation failed.");
	memid = shmget(key, 1, IPC_CREAT | 0666);//create sharedmem
	if(memid==-1)
		perror("shmget: shared memory creation failed."); 	

	//create process ID's for piggies
	pid_t _p1, _p2, _p3, _p4, _p5;

	_p1 = fork();
	_p2 = fork();
	_p3 = fork();
	_p4 = fork();
	_p5 = fork();

	int pipe1[2];
	pipe(pipe1);
	int write = pipe1[1];
	char memid_c[10];
	char semid_c[10];
	char _p1_c[10];
	char write_c[10];
	sprintf(write_c, "%d", write);	
	sprintf(semid_c, "%d", semid);
	sprintf(memid_c, "%d", memid);
	sprintf(_p1_c, "%d", _p1);
	
	if(_p1 == 0) {//process was successfully created
		char *args[] = {argv[1], _p1_c, semid_c, memid_c, write_c, NULL}; 
		execvp("./pig", args);	
		close(pipe1[1]);
		int nbytes;	
		char readbuffer[80];
		nbytes = read(pipe1[0], readbuffer, sizeof(readbuffer));
		printf("Received string: %s", readbuffer);
	}		
	return 0;
}
