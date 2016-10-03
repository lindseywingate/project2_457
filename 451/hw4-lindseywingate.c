/*This code was written by Lindsey Wingate*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <ctype.h>
#include <sys/types.h>
#include <signal.h>
#include <semaphore.h>

typedef struct str_ph{
	FILE*file;
	int num;
}ph;

int count=0;   
char array[1000];
int process=0;
pthread_mutex_t mutex;
int mut;

ph one; //initialize structs to hold pointer to files and assigned num for each thread
ph two;

void *read_thread(void *ptr);

int main(void) {
	pthread_mutex_init(&mutex, NULL);
	FILE*file1; //initialize file handlers
	FILE*file2;		
	file1=fopen("data1.txt", "r");
	file2=fopen("data2.txt", "r");
	one.file=file1;	//set pointer to thread
	two.file=file2;
	one.num=0; //set number
	two.num=1;

	pthread_t thread1;
	pthread_t thread2;
	
	pthread_create(&thread1, NULL, (void*)&read_thread, (void*)&one);//thread itself, pthread attribute, entry point (void pointer), pass to the threads)
	pthread_create(&thread2, NULL, (void*)&read_thread, (void*)&two);
	pthread_join(thread1, NULL);
	pthread_join(thread2, NULL);
	
	fclose(file1);
	fclose(file2);

	printf("THE MESSAGE IS: ");
	int y;
	for(y=0; y<48; y++) {
		printf("%c", array[y]);
	}
return 0;	
}

void *read_thread(void *arg) {
	char c;
	int end=1;
	ph *point;
	point=((ph*)(arg));//cast pointer to struct back to struct pointer	
	
	while(!feof(point->file)) {
		pthread_mutex_lock(&mutex);
		if(process%2!=point->num) {
			//if it's not equal, don't allow process to continue
		}
		else { // if it IS equal, allow process to put char in array
			pthread_mutex_unlock(&mutex);
			c=fgetc(point->file);
			if(c!='\n'&&c!='\r'&&c!='\0') {
				array[count] = c;
				count++;
				process++;
			}
		}
	
		pthread_mutex_unlock(&mutex);
	}
	pthread_exit(&end);

}
/*This code was written by Lindsey Wingate*/
