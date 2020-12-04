#include <stdio.h>
#include <stdlib.h>
int  main()
{
	int n[10];
	int sP=0;
	int soma=0;
	int maior=0;
	float media=0;
	int quantmenorMedia=0;
	for(int i=0; i<10; i++)
	{
		printf("\nDigite o numero\n");
		scanf("%d",&n[i]);
	}
	for(int j=0; j<10;j++)
	{
		if(n[j]%2==0)
		{
			sP=sP+n[j];
		}
		if(n[j]>maior)
		{
			maior=n[j];
		}
		soma=soma+n[j];
	}
	media=(float)soma/10;
	for(int o=0; o<10; o++)
	{
		if(n[o]<media)
		{
			quantmenorMedia++;
		}
	}
	printf("%d\n",sP);
	printf("%d\n",maior);
	printf("%.2f\n",media);
	printf("%d\n",quantmenorMedia);
return 0;
}
