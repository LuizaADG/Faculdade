#include <stdio.h>
#include <stdlib.h>
int isInt(double pos)//metodo para decidir se eh inteiro ou nao
{
	int resp=0;	
	int posi=(int)pos;//transforma o numero em inteiro
	if((pos-posi)==0)//se o numero menos ele inteiro igualar a zero
	{
		resp=1;//retorna verdade
	}else{//caso nao
		resp=0;//retorna mentira
	}
	return resp;
}
int main()
{
	int num=0;	
	scanf("%d",&num);//ler o numero de linhas
	FILE *arq=fopen("pub2.out","wb");//abrir e criar arquivo
	if(arq==NULL)//quando nao abre 
	{
		exit(0);//sair
	}
    double j=0;
	for(int i=0;i<num;i++)
	{
		scanf("%lf",&j);//ler a linha onde esta	
		fwrite(&j,8,1,arq);//escreve no arquivo
	}//fim de for
	fclose(arq);//fechar arquivo
	arq=fopen("pub2.out","rb");//abrir para ler
	double numeroLido=0;
	for(int posicao=8*num;posicao>0;posicao=posicao-8)//posicao de acordo com os bits de double
	{
				fseek(arq,posicao-8,SEEK_SET);//vai para posiçao				
				fread(&numeroLido,sizeof(double),1,arq);//le o numero
				if(isInt(numeroLido)==1)//checar se o numero eh inteiro
				{
					printf("%d\n",(int)numeroLido);//se for, imprime ele inteiro
				}else{
					printf("%g\n",numeroLido);
				}
    }
return 0;
}	


