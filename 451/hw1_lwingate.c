/*written by Lindsey Wingate*/
#include <stdlib.h>
#include <stdio.h>

int main(void)
{
	system("mkdir JUNK");
	system("cd JUNK");
	system("cp /etc/* .");
	system("ls r* > listR");
	system("ls a* > listA");
	system("ls m* > listM");
	system("rm r*");
	system("rm a*");
	system("rm m*");
	system("ls * > listX");
	system("cat listR > list");
	system("cat listA >> list");
	system("cat listM >> list");
	system("cat ListX >> list");
	system("sort list > sorted");
	system("cp sorted ..");
	system("cd ..");
	system("rm -rf JUNK");
}
/*written by Lindsey Wingate*/
