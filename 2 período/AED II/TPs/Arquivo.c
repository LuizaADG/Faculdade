#include <stdio.h>
#include <stdlib.h>
int main()
{
	int num=0;	
	scanf("%d",&num);//ler o numero de linhas
	FILE *arq=fopen("pub2.out","w");//abrir e criar arquivo
	if(arq==NULL)//quando o arquivo acabar
	{
		exit(0);//sair
	}
        double j=0;
	for(int i=0;i<num;i++)
	{
		scanf("%lf",&j);//ler a linha onde esta
		fprintf(arq,"%2f\n",j);//escreve no arquivo
	}//fim de for
	fclose(arq);//fechar arquivo
	arq=fopen("pub2.out","r");//abrir para ler
	double aux=num;
	for(int t=num; t>0;--t)
	{
               	printf("t=%lf\n",aux);
		fscanf(arq,"%lf",&aux);
               	printf("%.3lf\n",aux);
        }

return 0;
}	

