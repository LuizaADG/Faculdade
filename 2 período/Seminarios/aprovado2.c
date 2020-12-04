#include <stdio.h>
#include <string.h>
int main()
{
	int quant;
	printf("Escreva quantos alunos");
	scanf("%d",&quant);
	double p1=0;
	double p2=0;
	double p3=0;
	double p4=0;
	char nome[200];
	int maiorNota;
	for(int i=0;i<quant;i++)
	{
		char n[200];
		int prova1,prova2,prova3,prova4;
		printf("Digite o nome do aluno e suas notas");
		scanf("%s",n);
		scanf("%d %d %d %d",&prova1,&prova2,&prova3,&prova4);
		p1=p1+prova1;
		p2=p2+prova2;
		p3=p3+prova3;
		p4=p4+prova4;
		if(i==0||prova1+prova2+prova3+prova4>maiorNota)
		{
			strncpy(nome,n,200);
			maiorNota=prova1+prova2+prova3+prova4;
		}
	}
	printf("PROVA 1 %.2f\n",p1/(double)quant);
	printf("PROVA 2 %.2f \n",p2/(double)quant);
	printf("PROVA 3 %.2f\n",p3/(double)quant);
	printf("PROVA 4 %.2f\n",p4/(double)quant);
	printf("%s %d",nome, maiorNota);
return 0;
}
