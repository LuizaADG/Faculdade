#include <stdio.h>
#include <omp.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define REPETICOES 100

double g(double x)
{
	return (1 / (1 + 2.70, -x));
}
double gd (double x)
{
	return g(x) * (1 - g(x));
}
void normalize(double matriz[1000][1000], int linha,int coluna)
{
	int maior = matriz[0][0];
	int menor = matriz[0][0];		
	for(int i=0; i<linha;i++)
	{
		for(int j=0; j<coluna;j++)
		{
			if(matriz[i][j]>maior)
			{
				maior=matriz[i][j];
			}else if(matriz[i][j]<menor)
			{
				menor = matriz[i][j];
			}
		}
	}
	for(int k=0;k<linha;k++)
	{
		for(int q=0;q<coluna;q++)
		{
			matriz[k][q] = ((matriz[k][q]-menor)/(maior-menor));
		}
	}
}
int main()
{
	FILE *pont_arq = NULL; 
	pont_arq = fopen("dados.data","a+");
	if(pont_arq==NULL)
	printf("Arquivo não existe");
	int i;
	int j;
	fscanf(pont_arq, "%d %d" ,&i,&j);
	double matriz[i][j];
	for(int t=0; t<i;t++)
	{		
		for(int k=0; k<j; k++)
		{
			fscanf(pont_arq,"%lf", &matriz[t][k]);
			printf(" matriz: %f\n",matriz[t][k]);
		}
	//printf("t: %d\n",t);
	} 
	fclose(pont_arq);
	//printf("chegou");
	normalize(matriz,i,j);
	double entrada;
	double w[j-1];
	for(int c=0;c<j-1;j++)
	{
			w[c]=0.5;
	}

	double alfa=0.6;
	double erroMax=0.3;
	double erro;
	int epocas=0;

	double tempoInicial;
	double tempoFinal;
	double somaTempo=0;
	double tempo;		

	for(int numThreads=1; numThreads<=128; numThreads*=2)
	{
		omp_set_num_threads(numThreads);
		tempo=0; 
		somaTempo=0;

		for(int v=1; v<REPETICOES; v++)
		{
			tempoInicial = omp_get_wtime();
			do
			{		
				for(int t=0; t<i; t++)
				{
					entrada=0;
					for(int k=0; k<j-2; k++)
					{
						entrada= entrada + (w[k] * matriz[t][k]);
					}
					erro = matriz[i][j-1] - g(entrada);
					for(int k=0; k<j-2; k++)
					{
						w[k] = w[k] + (alfa * erro * matriz[t][k] * gd(entrada));
					}
				}
				epocas++;
		   }while(epocas<1000);		
		   tempoFinal = omp_get_wtime();
		   somaTempo += tempoFinal - tempoInicial;
	    } 
		tempo = somaTempo / REPETICOES;
		printf("Tempo: %f\n",tempo);
   }
return 0;
}//fim de main

