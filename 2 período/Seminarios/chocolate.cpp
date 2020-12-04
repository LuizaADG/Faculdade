#include <stdio.h>
#include <stdlib.h>
int main ()
{
	int n,i;
	int pedacos=0;
	do
	{
    		scanf("%d", &n);
  	} while (n <= 0);
	int array[n];
	for( i=0; i<n;i++)
	{
		scanf("%d",&array[i]);
	}
	for(int j=0;j<n;j++)
	{
		pedacos+=array[j]-1;
	}
	printf("%d",pedacos);
	return 0;
}
