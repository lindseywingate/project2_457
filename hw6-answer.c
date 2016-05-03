nclude <stdio.h>
#include <stdlib.h>
 
struct node {
   int  data;
   struct node *right;
   struct node *left;
};     
 
int main(int argc, char *argv[]) {
   int i, n;
   struct node *previous, *current, *head, *tail;
 
   // Check command line input(s).
   if (argc == 2) {
      printf("Command line argument:\t %s\n", argv[1]);
   } else if (argc > 2) {
      printf("Too many arguments supplied.\n");
      exit(0);
   } else {
      printf("One argument expected.\n");
      exit(0);
   }
   printf("\n");

   // Build bi-directional linked list.
   head = NULL;
   tail = NULL;
   n = atoi(argv[1]);
   for(i = 0; i <= n; i++) { 
      current = (struct node *)
      malloc(sizeof(struct node));
      current->data = i;
      printf("Input data:\t\t %d\n", current->data);
      if (i == 0) {
         // Handle first input (special case).
         head          = current;
         current->left = NULL;
      } else {
         current->left   = previous;
         previous->right = current;
      }
      current->right = NULL;
      tail           = current;
      previous       = current;
   }
   printf("\n");

   // In order list.
   current = head; 
   while (current) {
      printf("Left to right output:\t %d\n", current->data);
      current = current->right;
   }
   printf("\n");
	
   // Reverse order list.
   current = tail; 
   while (current) {
      printf("Right to left output:\t %d\n", current->data);
      current = current->left;
   }
 
   return 0;
}
 

