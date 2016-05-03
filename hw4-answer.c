nclude <stdio.h>
#include <stdlib.h>
#include <string.h>

#define base 10

char *vector(char array[], int *length) {
char *temp;
    // Make new dynamic array.
    temp = (char*)calloc(*length+base, sizeof(char));
    // Copy data to new array.	
    memcpy(temp, array, *length);
    // Increment & record new length.		
    *length += base;	
    // Free old array.			
    free(array);
    // Return new array.				
    return temp;				
}

int main(void) {
int  i, j;
int  size = base;
char *array;
char *output;
char text[] = "HW 4 input: ";

    // Initialize the array to hold base# characters.
    array = (char*)calloc(base, sizeof(char));

    // Prompt for input.
    printf("Enter characters: ");
    j = 0;
    for (i = 0; ; i++) {
       array[i] = getchar();
       if (array[i] == '\n') break;		// Return detected.
       j++;
       if (j == base) {
          j = 0; 
          array = vector(array, &size);		// Adjust vector length.	
       }
    }

    // Append string terminator.
    array[i] = '\0';

    // Prepare output.
    output = (char*)calloc(strlen(text)+strlen(array)+1, sizeof(char));
    strcpy(output, text);
    strcat(output, array);
    printf("%s\n", output);

    // Free dynamic memory.
    free(output);
    free(array);
    return 1;
}

