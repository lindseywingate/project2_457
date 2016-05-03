nclude <stdlib.h>
#include <stdio.h>
#include <string.h>

struct circle {
   char first[20];
   char last[20];
   int  start;
} directory[10], temp;

struct list {
   int phoneNo;
   int next;
} linkedList[50];

/*******************************************************************/
void Insert(char *first, char *last, int count, int number[]) {
int i, j;
int start, current, next;
   // Search directory for name, if found it exists and return.
   for (i = 0; i < 10; i++) {
       if (!strcmp(first, directory[i].first) && !strcmp(last, directory[i].last)) {
          return;
       }
   }
   // Find first open space in list.
   for (i = 0; i < 50; i++) {
       if (linkedList[i].phoneNo == -1) {
          start = i;
          break;
       } 
   }
   // Append onto directory.
   for (i = 0; i < 10; i++) {
       if (directory[i].start == -1) {
          strcpy(directory[i].first, first);
          strcpy(directory[i].last, last);
          directory[i].start = start;
          break;
       }
   }
   // Insert into list.
   j = 0;
   linkedList[start].phoneNo = number[j++];
   current = start;
   next    = (start + 1);
   for (i = next; i < 50; i++) {
       if (linkedList[i].phoneNo == -1) {
          if (j == count) {
             linkedList[current].next = -1;             
             break;
          } else {            
             linkedList[current].next = i;
             linkedList[i].phoneNo = number[j++];
          }
          current = i;
       }
   }
}


/*******************************************************************/
void Delete(char *first, char *last) {
int i, j;
int current, next; 
int start = -1;
   // Search directory for name, if not found return.
   for (i = 0 ; i < 10; i++) {
       if (!strcmp(first, directory[i].first) && !strcmp(last, directory[i].last)) {
          start = directory[i].start;
          // Erase directory entry.
          strcpy(directory[i].first, "");
          strcpy(directory[i].last, "");
          directory[i].start = -1;
       }
   }
   if (start == -1) return;
   // Erase from linked list. 
   current = start;
   while (1) {
      next = linkedList[current].next;
      linkedList[current].phoneNo = -1;
      if (next == -1) break;
      linkedList[current].next    = -1;
      current = next;
   }
}


/*******************************************************************/
int main(void) {
char action;
char junk;
int  count;
int  i, j;
int  *numbers;
FILE *data;
   // Initialize directory and list.
   for (i = 0; i < 10; i++) {
       strcpy(directory[i].first, "");
       strcpy(directory[i].last, "");
       directory[i].start = -1;
   }
   for (i = 0; i < 50; i++) {
       linkedList[i].phoneNo = -1;
       linkedList[i].next    = -1; 
   }
   // Read data file.
   data = fopen("hw8data.txt", "r");
   while (1) {
      fscanf(data, "%c", &action);
      if (action == 'Q') break;
      fscanf(data, "%s", temp.first);
      fscanf(data, "%s", temp.last);
      fscanf(data, "%d", &count);
      numbers = calloc(count, sizeof(int));
      for (i = 0; i < count; i++) {
          fscanf(data, "%d", &numbers[i]);
      }     
      fscanf(data, "%c", &junk);
      if (action == 'I') Insert(temp.first, temp.last, count, numbers);
      if (action == 'R') Delete(temp.first, temp.last);
      free(numbers);
   }
   // Display list.
   printf("Display\n");
   for (i = 0; i < 50; i++) {
       printf("%d > %d %d\n", i, linkedList[i].phoneNo, linkedList[i].next);
   }
   // Exit.
   return 1; 
}
