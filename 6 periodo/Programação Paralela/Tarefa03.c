/*
* Adapted from: http://w...content-available-to-author-only...s.org/sieve-of-eratosthenes
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

/*
Bruno Luiz Dias Alves de Castro
Luiza Ávila
Wisney Tadeu de Almeida Assis dos Santos
	Sequêncial
		5761455

		real	0m1,749s
		user	0m1,705s
		sys	0m0,044s

	Paralelo
		5761455

		real	0m1,112s
		user	0m3,510s
		sys	0m0,044s

*/

int sieveOfEratosthenes(int n)
{
	// Create a boolean array "prime[0..n]" and initialize
	// all entries it as true. A value in prime[i] will
	// finally be false if i is Not a prime, else true.
	int primes = 0; 
	bool *prime = (bool*) malloc((n+1)*sizeof(bool));
	int sqrt_n = sqrt(n);

	memset(prime, true,(n+1)*sizeof(bool));
	#pragma omp parallel num_threads(4) // seta o número de threads em 2 
    	{
		for (int p=2; p <= sqrt_n; p++)
		{
			// If prime[p] is not changed, then it is a prime
			if (prime[p] == true)
			{
				// Update all multiples of p
				#pragma omp for schedule(static , 8)
				for (int i=p*2; i<=n; i += p)
					prime[i] = false;
			}
		}
	}
	

	// count prime numbers
	for (int p=2; p<=n; p++)
	if (prime[p])
	 primes++;

	return(primes);
}

int main()
{
	int n = 100000000;
	printf("%d\n",sieveOfEratosthenes(n));
	return 0;
} 
