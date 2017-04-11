/*This code was written by Lindsey Wingate*/
#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <stdio.h>
#include <semaphore.h>
#include <time.h>

void *piggy(void *arg);
void *read_thread(void *ptr);

typedef struct str_ph{
	FILE*file;
	int num;
}ph;

ph _p1, _p2, _p3, _p4, _p5;
pthread_mutex_t mutex;	

FILE*hw10;
int process=0;

int main(void) {
	pthread_mutex_init(&mutex, NULL);
	FILE*file;
	int end=0;
	file = fopen("test.txt", "r");
	file = fopen("test.txt", "r");
	file =	fopen("test.txt", "r");
	file = fopen("test.txt", "r");
	file = fopen("test.txt", "r");
	_p1.file = file;
	_p2.file = file;
	_p3.file = file;
	_p4.file = file;
	_p5.file = file;
	_p1.num = 0;
	_p2.num = 1;
	_p3.num = 2;
	_p4.num = 3;
	_p5.num = 4;
	
	pthread_t pig1, pig2, pig3, pig4, pig5;
	pthread_create(&pig1, NULL, (void*)&piggy, (void*)&_p1);
	pthread_detach(&pig1);
	pthread_create(&pig2, NULL, (void*)&piggy, (void*)&_p2);
	pthread_detach(&pig2);
	pthread_create(&pig3, NULL, (void*)&piggy, (void*)&_p3);
	pthread_detach(&pig3);
	pthread_create(&pig4, NULL, (void*)&piggy, (void*)&_p4);
	pthread_detach(&pig4);
	pthread_create(&pig5, NULL, (void*)&piggy, (void*)&_p5);
	pthread_detach(&pig5);

	pthread_exit(&end);
	fclose(file);
	fclose(file2);
	fclose(file3);
	fclose(file4);
	fclose(file5);
	return 0;
}

void *piggy(void *arg){
	ph *point;
	point=((ph*)(arg));
	int c;
	
	time_t t;
	srand((unsigned) time(&t));
	int r = rand() % 10;
	int i;
	pthread_mutex_lock(&mutex);
	if(process%5!=point->num) {
		//do nothing
	}
	else {
		pthread_mutex_unlock(&mutex);
		hw10 = fopen("hw10.out", "a");
		for (i = 1; i < r; i++) {
			c=fgetc(point->file);
			printf("Num:%d %c\n",point->num, c);
			fputc(c, hw10);
		}
		fclose(hw10);
		process++;		
	}
	pthread_mutex_unlock(&mutex);
}
/*This code was written by Lindsey Wingate*/
