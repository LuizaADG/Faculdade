#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>
#define NUM_THREADS     128
#define REPETICOES 100
#include <math.h>
double pow(double x, double y);
float powf(float x, float y);
long double powl(long double x, long double y);
double g(double x);
double gd (double x);
void *PrintHello(void *threadid);
int main()
{
	int i=0;
	int j=0;
	int m;
	FILE *pont_arq;
	pont_arq= fopen("Arq","r");
	fscanf(pont_arq,"%d %d",&i,&j);
	int matriz[i][j];
	double entrada;
	int w[j-1];
	double alfa=0.6;
	double erro=0;
	double somaTempo=0;
	double tempo=0;
	int rc;	
	pthread_t thread[NUM_THREADS];	
	for(int t=0; t<i;t++)
	{		
		for(int k=0; k<j; k++)
		{
			fscanf(pont_arq,"%d",&m);
			matriz[t][k]=m;
		}
	} 
	for(int i=1;i<=NUM_THREADS;i*2)
	{		
		rc = pthread_create(&threads[i], NULL, PrintHello, (void *)i);	
		if (rc){
         		printf("ERROR; return code from pthread_create() is %d\n", rc);
         		exit(-1);
     	 	}	
		for(double v=1;v<REPETICOES;v++)
		{
			time_t tempoInicial=time(NULL);			
			int k=0;			
			for(int t=0; t<i; t++)
			{
				entrada=0;
				for(k=0;k<i-2;k++)
				{
					entrada=entrada+w[k]*matriz[t][k];
				}
				double q=g(entrada);
				erro=matriz[t][k]-q;
				for(int k=0;k<i-2;k++)
				{
					double q=gd(entrada);
					w[j]=w[j]+alfa*erro*matriz[t][k]*q;
				}
			k++;
			}	
		time_t tempoFinal = time(NULL) - tempoInicial;
		somaTempo = somaTempo + (tempoFinal - tempoInicial);
		}
		tempo = somaTempo / REPETICOES;
		printf("Numero da thread: %d Tempo: %f \n",rc,tempo);
   }
pthread_exit(NULL);
}//fim de main
double g(double x)
{
	double resp=1/(1+pow(2.70,-x));
	return resp;
}
double gd (double x)
{
	double resp=(pow (2.70,-x))/(pow (1+pow (2.70,-x),2));
	return resp;
}
void *PrintHello(void *threadid)
{
   long tid;
   tid = (long)threadid;
   printf("Hello World! It's me, thread #%ld!\n", tid);
   pthread_exit(NULL);
}
