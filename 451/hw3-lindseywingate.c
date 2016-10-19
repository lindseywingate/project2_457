/*This code was written by Lindsey Wingate */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <ctype.h>
#include <sys/types.h>
#include <signal.h>
//two structs. one for searching, one for holding
struct things {
    char*word;
}*word_array;

struct thread_data {
    int size;
    char *word;//pointer to word the thread will search for
};

//finds number of words. called upon by thread
void *search_strings(void *arg) {
    int x;
    int c=0;
    int end=1;
    struct thread_data box=*((struct thread_data*)arg);//holds word searching for
    for (x=0; x<box.size; x++) {
        if (!strcmp(box.word, word_array[x].word)) {
            c++;
        }
    }
    printf("\n%s appeared %d times\n", box.word, c);
    pthread_exit(&end); //stop using thread 
}

int main(void)
{
    pthread_t thread1;
    pthread_t thread2;
    FILE*file;//pointer to text file
    int total_num_w=0;//total num of words in file
    int total_num_c=0;//total num of chars in file
    int num_c=0;//total num of chars in each word, varies with loop
    char c;
    system ("wget http://rmarsh.cs.und.edu/CLASS/CS451/HOMEWORK/hw3-data.txt");
    file=fopen("hw3-data.txt", "r");
    //check if file sucks.
    if (file==NULL) {
        return(-1);
    }
    do {
        c=fgetc(file);//c is next character in array
        if(feof(file)) {//if end of file, get out of loop
            break;
        }
        total_num_c++;
        if(c==' ') { //if space, just finished a word. add to count						
			total_num_w++;
        }
        //printf("%c", c);//checking everything works
    }
    while(1);
    //printf("Total number of words in file: %d \n Total number of chars in file: %d\n", total_num_w, total_num_c);
    rewind(file);
    word_array=calloc(total_num_w, sizeof(*word_array));
    char word[1024];//leaves space for adding to word   
    char letter;
    int x,y;
    for(x=0; x<total_num_w; x++) {
        fscanf(file, "%s", word);
        for(y=0; word[y]; y++) { //this loop changes each char in the word to lowercase
            word[y]=tolower(word[y]);
        }
        word_array[x].word=calloc(strlen(word),sizeof(char));
        strcpy(word_array[x].word, word);//assign lower case word to word in struct
    }
    fclose(file);
    //initialize    
    struct thread_data things1 = {total_num_w, "polar"};
    struct thread_data things2 = {total_num_w, "test"};
    //thread id, attribute object, thread functions, and pointer to data to be searched 
    pthread_create(&thread1, NULL, &search_strings, (void*)&things1);

    pthread_create(&thread2, NULL, &search_strings, (void*)&things2);
    //bring it all back together    
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);
    free(word_array);
    return 0;
}
/*This code was written by Lindsey Wingate*/

