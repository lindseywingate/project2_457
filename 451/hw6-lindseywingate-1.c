/*This code was written by Lindsey Wingate*/
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <stdio.h>
#include <semaphore.h>

int main(void) {
	int value;
	int semid;

	semid = semget(100, 3, 0666);
	value = semctl(semid, 0, GETVAL);

	if(value==1) {
		printf("Executing process #1.\n");
		semctl(semid, 0, SETVAL, 0);
		semctl(semid, 1, SETVAL, 1);
	}

return 0;
}
/*This code was written by Lindsey Wingate*/
