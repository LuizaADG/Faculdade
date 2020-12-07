#Comentários
#Escrever vetor de tamanho 100
#vet[i]=2i+1
#Depois escrever soma
#100->s0,soma->s1,aux->s2
#Fim  de comentários
.text
.globl p15
p15: 
	addi $s0,$zero,100	#flag=100
	addi $s1,$zero,0	#soma=0
	addi $s2,$zero,0	#aux=0
	addi $t0,$zero,0x1001	#ir para o primeiro endereço
	sll  $t0,$t0,16		#shift para o endereço ficar 0x10010000
do:
	sll  $t1,$s2,1		#2i  
	addi $t1,$t1,1		#2i+1  
	
	sw   $t1,0($t0)		#armazenar t1 no endereço de t0
	add  $s1,$s1,$t1	#soma=soma+t1
	addi $s2,$s2,1		#aux=aux+1
	add  $t0,$t0,4		#prox endereço
	bne  $s2,$s0,do		#se aux!=flag
	
	sw  $s1,0($t0)