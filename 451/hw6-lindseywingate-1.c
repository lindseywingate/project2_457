/*This code was written by Lindsey Wingate*/
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <stdio.h>
#include <semaphore.h>

int toString(char a[]) {
  int c, sign, offset, n;
  if (a[0] == '-') {  // Handle negative integers
    sign = -1;
  }
  if (sign == -1) {  // Set starting position to convert
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
