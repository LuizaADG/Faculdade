/*
* Adapted from: http://w...content-available-to-author-only...s.org/sieve-of-eratosthenes

Nota do professor: Faltou Paralelizar o loop Principal*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

/*
Luiza Ávila
	Sequêncial
		5761455

		real	0m7.657s
		user	0m6.525s
		sys	0m0.087s


	Paralelo
		5761455

		real	0m5.837s
		user	0m10.375s
		sys	0m0.196s


	Paralelo com reduce
		5761455

		real	0m5.052s
		user	0m5.058s
		sys	0m0.112s

Speedup = 1,515637371


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
		for (int p=2; p <= sqrt_n; p++)
		{
			// If prime[p] is not changed, then it is a prime
			if (prime[p] == true)
			{
				// Update all multiples of p
				for (int i=p*2; i<=n; i += p)
					prime[i] = false;
			}
		}
	

	// count prime numbers
	#pragma omp parallel for reduction (+ : primes)
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
