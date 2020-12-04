#include <stdio.h>
#include <omp.h>
#include <time.h>
#include <stdlib.h> 
#define REPETICOES 100
int array[5000];
int tam=5000;
int numThreads=128;
 void swap(int i, int j) {
   int temp = array[i];
   array[i] = array[j];
   array[j] = temp;
}
void quicksortRec (int esq, int dir,int numThreads) {
   int i = esq, j = dir;
   int pivo = array[(dir+esq)/2];
   while (i <= j) {
      while (array[i] < pivo) i++;
      while (array[j] > pivo) j--;
      if (i <= j) {
         swap(i, j);
         i++;
         j--;
      }
   }
	if(numThreads > 1) {
	omp_set_num_threads(numThreads);
			 #pragma omp parallel sections
			{
				#pragma omp section
				{
					if(esq<j) quicksortRec(esq, j,numThreads-1);
				}
				#pragma omp section
				{
					if(i<dir) quicksortRec(i, dir,numThreads-1);
				}
			}
	}else{
	   if (esq < j)  quicksortRec(esq, j,1);
	   if (i < dir)  quicksortRec(i, dir,1);
	}
}
void quicksort() {
   quicksortRec(0, tam-1,numThreads);
}
int main(){
	double tempoInicial;
	double tempoFinal;
	double somaTempo=0;
	double tempo=0;		
	for(int v=1; v<REPETICOES; v++)
	{
		for(int i=0; i<tam;i++){
			array[i] = rand();	
	    }
		tempoInicial = omp_get_wtime();	
		quicksort();
		tempoFinal = omp_get_wtime();
	   	somaTempo += tempoFinal - tempoInicial;
	} 

		tempo = somaTempo / REPETICOES;
		printf("Tempo: %lf\n",tempo);
return 0;
} 
