#include <stdio.h>
#include <omp.h>
#include <math.h>
double pow(double x, double y);
float powf(float x, float y);
long double powl(long double x, long double y);
double g(double x);
double gd (double x);
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
	do
	{
		for(int t=0; t<i; t++)
		{
			entrada=0;
			for(int k=0;k<i-2;k++)
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
		}	
	}while(erro>-1||(entrada>100 && g(entrada)>100));		
	fclose(pont_arq);
	return 0;
}
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
