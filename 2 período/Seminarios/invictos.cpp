#include <stdio.h>
#include <stdlib.h>
int main()
{
	int tam;
	int in=0;
	int o=0;
	int n=0;
	int j=0;
	scanf("%d",&tam);
	char partidas[tam];
	for(in=0;in<tam; in++)
	{
		scanf(" %c",&partidas[in]);
	}
	for(in=0;in<tam;in++)
	{
		while(partidas[in]!='D')
		{
			j++;
			in++;
		}
			if(j>o)
                        {
                                        o=j;
                                        n=in;
                        }
	j=0;
	}
	printf("%d\n",o);
	printf("%d  %d",n-(o-1),n);
	return 0;
}
