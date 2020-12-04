#include<omp.h>
#include<stdlib.h>
#include<stdio.h>

#define REPETICOES 100
	
int array[10000];
int tam=10000;

void selectionSort() {
   for (int i = 0; i < (tam - 1); i++) {
      int indice = i;
	#pragma omp parallel
	{ 
		int local_min=i;	
		#pragma omp for      
		for (int j = (i + 1); j < tam; j++){
		     if (array[indice] < array[local_min]){
		        local_min = j;
		     }
		  }
		#pragma omp critical
		if(array[local_min]<array[indice]){
			indice=local_min;		
		}	
	}
	  if(i!=indice){	
      	int auxiliar = array[indice];
      	array[indice] = array[i];
      	array[i] = auxiliar;
		}
   }
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
	 		selectionSort();
			tempoFinal = omp_get_wtime();
		   	somaTempo += tempoFinal - tempoInicial;
	    } 

		tempo = somaTempo / REPETICOES;
		printf("Tempo: %f\n",tempo);
	}
return 0;
}
