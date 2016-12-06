/*This code was written by Lindsey Wingate*/
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <stdio.h>
#include <semaphore.h>

int main(void){
	int semid;
	key_t key = 100;

//create semaphore set. semget(key# to identify group, number of sems in group, permissions)
	semid = semget(key, 3, 0666 | IPC_CREAT);//shmget() requests memory. Leading 0 is required to indicate an octal number for translation to binary 
	if (semid < 0) {
		printf("Didn't create set.\n");
	}
//initialize semaphores. semctl(semid, semnum, cmd, arg) semnum selects semaphore within array by index, cmd is flag. 
	semctl(semid, 0, SETVAL, 1); 
	semctl(semid, 1, SETVAL, 0);  
	semctl(semid, 2, SETVAL, 0); 

	return 0;
}
/*This code was written by Lindsey Wingate*/
