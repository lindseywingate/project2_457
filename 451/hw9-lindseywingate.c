/*Code was written by Lindsey Wingate*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <ctype.h>
#include <sys/types.h>
#include <signal.h>
#include <semaphore.h>
#include <unistd.h>

typedef struct str_ph {
    FILE*file;
    int num;
}ph;

ph one, two, three, four, five;
pthread_mutex_t mutex;

FILE*results;
int process=0;

void *read_thread(void *ptr);
void printresults(void);

int main(void) {
    pthread_mutex_init(&mutex, NULL);
    FILE*file1, *file2, *file3, *file4, *file5;
    int end=0;  
    file1=fopen("drive1.data", "r");
    file2=fopen("drive2.data", "r");
    file3=fopen("drive3.data", "r");
    file4=fopen("drive4.data", "r");
    file5=fopen("drive5.data", "r");
    one.file=file1;
    two.file=file2;
    three.file=file3;
    four.file=file4;
    five.file=file5;
    one.num=0;
    two.num=1;
    three.num=2;
    four.num=3;
    five.num=4;

    pthread_t thread1, thread2, thread3, thread4, thread5;
    pthread_create(&thread1, NULL, (void*)&read_thread, (void*)&one);
    pthread_detach(thread1);
    pthread_create(&thread2, NULL, (void*)&read_thread, (void*)&two);
    pthread_detach(thread2);
pthread_create(&thread3, NULL, (void*)&read_thread, (void*)&three);
    pthread_detach(thread3);
    pthread_create(&thread4, NULL, (void*)&read_thread, (void*)&four);
    pthread_detach(thread4);
    pthread_create(&thread5, NULL, (void*)&read_thread, (void*)&five);
    pthread_detach(thread5);

    printresults();

    pthread_exit(&end);
    fclose(file1);
    fclose(file2);
    fclose(file3);
    fclose(file4);
    fclose(file5);

    return 0;
}

void *read_thread(void *arg) {
    ph *point;
    point=((ph*)(arg));
    int c;

    while(!feof(point->file)) {
        pthread_mutex_lock(&mutex);
        if(process%5!=point->num) {
        }
        else {
            pthread_mutex_unlock(&mutex);
            c=fgetc(point->file);
    //      printf("Process %d % NUM %d CHAR %c\n", process, point->num, c);        
            results=fopen("results.txt", "a");
            fputc(c, results);
            fclose(results);
            process++;
        }
        pthread_mutex_unlock(&mutex);
    }
}

void printresults(void) {
    FILE *fp;
    int c;
    int n = 0;
    fp = fopen("results.txt", "r");
    do {
        c=fgetc(fp);
        if(feof(fp)) {
break;
        }
        if(c>47&&c<58||c>65&&c<91||c>96&&c<123) {
        printf("%c", c);
        }
    }while(1);

    fclose(fp);
    fp=fopen("results.txt", "w");
    fclose(fp);
}

