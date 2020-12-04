#include <stdio.h>

int main()
{
	int n;
	int aux=0;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		char nome[200];
		int nota;
		scanf("%s",nome);
		scanf("%d",&nota);
		if(nota>=60)
		{
			printf("%s APROVADO\n",nome);
			aux++;
		}else{
			printf("%s REPROVADO\n",nome);
		}
	}
	printf("%d APROVADOS\n",aux);
	int rep=n-aux;
	printf("%d REPROVADOS\n",rep);
	double  porc=((double)aux/(double) n)*100;
	printf("%d%%",(int)porc);

return 0;
}
