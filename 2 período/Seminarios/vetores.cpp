#include <stdio.h>

int main()
{
	int tam;
	scanf("%d", &tam);
   int n[tam];
   
   int sP=0;
	int maior=0;
	float media=0;
	int quantmenorMedia=0;
   
	for(int i=0; i<tam; i++)
	{
		int k;
      scanf("%d",&k);
      n[i]=k;
		if(k%2==0)
		{
			sP+=k;
		}
		if(i==0||k>maior)
		{
			maior=k;
		}
		media+=k;
	}
	media/=(double)tam;
	for(int o=0; o<tam; o++)
	{
		if(n[o]<media)
		{
			quantmenorMedia++;
		}
	}
	printf("%d\n",sP);
	printf("%d\n",maior);
	printf("%f\n",media);
	printf("%d\n",quantmenorMedia);
return 0;
}
