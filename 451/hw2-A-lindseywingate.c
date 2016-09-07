#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <signal.h>

int main(void) {
int   i, j;
int   ExitCode1 = 1;
pid_t PID1;
int counter=0;
/* Read execv man pages about the following 3 lines. */
char  *path1   = "/usr/X11R6/bin/xclock";
char  *arg1_0  = "xclock";
char  *arg1_1  = NULL;
int input;
	while (counter<5) {
		printf("Spawning a child.\n");
		printf("-----------------\n");

		PID1 = fork();
	   /* The child's code.                                      */
		if (PID1 == 0) {
			printf("CHILD: Hello from child.\n");
			printf("CHILD: Starting XCLOCK..\n");
			/* Start XCLOCK in the forked process.                 */
			execlp(path1, arg1_0, arg1_1);
		}
		counter++;
	}
	sleep(4);
/* The parent's code.                                     */
   if (PID1 != 0) {
		printf("\nENTER 1 TO KILL OFF PROCESSES.\n\n");
		scanf("%d", &input);
		if(input==1) {
			printf("PARENT: Children exited with code: %d\n", kill(PID1, 9));
			waitpid(PID1, &ExitCode1, 0);
		}	
	}
return 0;   
}

