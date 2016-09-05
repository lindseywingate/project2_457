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

/* Read execv man pages about the following 3 lines. */
char  *path1   = "/usr/X11R6/bin/xclock";
char  *arg1_0  = "xclock";
char  *arg1_1  = NULL;

   printf("Spawning a child.\n");
   printf("-----------------\n");

   PID1 = fork();

   /* The child's code.                                      */
   if (PID1 == 0) {
      printf("CHILD: Hello from child.\n");
      printf("CHILD: Starting XCLOCK..\n");

      /* Start XCLOCK in the forked process.                 */
      execlp(path1, arg1_0, arg1_1);

      /* The 2 lines below will terminate a user-written     */
      /* child process. But, will not work when we execute   */
      /* XCLOCK. Why?                                        */
//      printf("CHILD 1: Exiting with code: %d\n", ExitCode1);
//      exit(ExitCode);
   }

   /* The parent's code.                                     */
   if (PID1 != 0) {
      /* You need to add a prompt here or something that     */
      /* will let you decide when to kill off the processes. */

      /* Sends kill signal and wiats for child to die off.   */
      printf("PARENT: Child exited with code: %d\n", kill(PID1, 9));
      waitpid(PID1, &ExitCode1, 0);
   } 

   return 0;   
}

