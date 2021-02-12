#include <stdio.h>
#include <stdlib.h>

long long num_passos = 1000000000;
double passo;

void entrar(){
    printf("ENTREI AQUI!");
}

int main(){
   int i;
   double x, pi, soma=0.0;
   passo = 1.0/(double)num_passos;
	
   double a[16], b[16], c[16];
  for (int i = 0; i < 16; i++) {
    if (a[i] != 5 ||
        b[i] != 2 ||
        c[i] != 0) {
      printf("failedn");
      exit(1);
      }
  }
   

   for(i=0; i < num_passos; i++){
      x = (i + 0.5)*passo;
      soma = soma + 4.0/(1.0 + x*x);
   }
   pi = soma*passo;

   for(int j = 0; j <  rand()%num_passos; j++){ 
        entrar();
    } 
	
   printf("O valor de PI é: %f\n", pi);
   return 0;
}

/*
*Luiza Ávila
*devec.c:9:1: note: not vectorized: not enough data-refs in basic block.-> não tem dados suficientes para auto-vetorizar o loop
*devec.c:33:4: note: not vectorized: latch block not empty.-> assume que a condição do loop está final, quando está tudo no header
*devec.c:18:10: note: not vectorized: control flow in loop.-> alguma operação não pode ser computada ou o fluxo do loop é muito complexo
*devec.c:27:4: note: not vectorized: relevant stmt not supported: soma_29 = _11 + soma_43;-> não pode ser vetorizado
*devec.c:14:10: note: not vectorized: no grouped stores in basic block.-> não há como vetorizar as agrupações
*/
