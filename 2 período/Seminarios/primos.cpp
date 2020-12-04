#include <stdio.h>
#include <stdlib.h>
int main ()
{
	int i;
  	int div = 0;
	int tam;
	scanf("%d",&tam);
	int x[tam];
  	for(int j=0;j<tam;j++)
	{
        	do
		{
    			scanf("%d", &x[j]);
  		} while (x[j] <= 0);
	}
  	for(int m=0;m<tam;m++)
	{
		div=0;
		for (i = 1; i <= x[m]; i++)
		{
			if (x[m] % i == 0)
			{
     				div++;
    			}
  		}
			 if (div==2)
                                printf("SIM\n");
                        else
                                printf("NAO\n");
	}
 return 0;
}
