#include <stdio.h>
#include <omp.h>
#include <time.h>
#include <stdlib.h> 
#define REPETICOES 100
int array[1500000];
int tam=1500000;
 void swap(int i, int j) {
   int temp = array[i];
   array[i] = array[j];
   array[j] = temp;
}
void quicksortRec (int esq, int dir) {
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
   if (esq < j)  quicksortRec(esq, j);
   if (i < dir)  quicksortRec(i, dir);
}
void quicksort() {
   quicksortRec(0, tam-1);
}
int main(){
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
			for(int i=0; i<tam;i++){
				array[i] = rand();	
	        }
			tempoInicial = omp_get_wtime();	
	 		quicksort();
			tempoFinal = omp_get_wtime();
		   	somaTempo += tempoFinal - tempoInicial;
	    } 

		tempo = somaTempo / REPETICOES;
		printf("Tempo: %f\n",tempo);
	}
return 0;
} 
