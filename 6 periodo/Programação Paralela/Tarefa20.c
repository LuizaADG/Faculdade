#include <stdio.h>
#include <stdlib.h>
/*
Luiza Ávila
Silly Sort
	Paralela p/GPU
		test passed

		real	0m0,363s
		user	0m1,275s
		sys	0m0,004s
	Paralela p/multicore
		test passed

		real	0m0,641s
		user	0m1,185s
		sys	0m0,008s
	Sequencial
		test passed

		real	0m1,161s
		user	0m1,161s
		sys	0m0,000s

*/
int main() 
{
   int i, j, n = 30000; 

   // Allocate input, output and position arrays
   int *in = (int*) calloc(n, sizeof(int));
   int *pos = (int*) calloc(n, sizeof(int));   
   int *out = (int*) calloc(n, sizeof(int));   

   // Initialize input array in the reverse order
   for(i=0; i < n; i++)
      in[i] = n-i;  

   // Print input array
   //   for(i=0; i < n; i++) 
   //      printf("%d ",in[i]);
    #pragma omp target map(to:pos[:n]) map(to:in[:n])
    #pragma omp teams distribute parallel for simd
   // Silly sort (you have to make this code parallel)
   for(i=0; i < n; i++) 
      for(j=0; j < n; j++)
	     if(in[i] > in[j]) 
            pos[i]++;	

   // Move elements to final position
   for(i=0; i < n; i++) 
      out[pos[i]] = in[i];
   
   // print output array
   //   for(i=0; i < n; i++) 
   //      printf("%d ",out[i]);

   // Check if answer is correct
   for(i=0; i < n; i++)
      if(i+1 != out[i]) 
      {
         printf("test failed\n");
         exit(0);
      }

   printf("test passed\n"); 
}  
