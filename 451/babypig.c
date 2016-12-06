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
	printf("Piggy is working!");	
	printf("THIS %s, %s", argv[0], argv[1]);
/*	int value, semid, filename, piggy; 
	long piggy_num, key, mem_id;
	char *ptr;		

	key = strtol(argv[2]);
	memid = strtol(argv[3]);

	printf("key: %lu", key);

	piggy_num = 1;
	argv[0] = filename;
	argv[1] = piggy;
	argv[2] = key;
	argv[3] = mem_id; 	

	semid = semget(200, 5, 0666);
	value = semctl(semid, piggy_num, GETVAL);
	
	if(value==1) {
		semctl(semid, piggy_num, SETVAL, 0);
		if(piggy_num == 4) {
			semctl(semid, 0, SETVAL, 1);	
		}
		else {
			semctl(semid, piggy_num+1, SETVAL, 1);
		}
	}		
*/
}





/*baby pig code written by Lindsey Wingate*/
