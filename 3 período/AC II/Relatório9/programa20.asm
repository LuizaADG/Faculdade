#Comentários
#vetor de tamanho 100
#ordenar pares depois impares
#100->s0,aux->s1
#Fim  de comentários
.text
.globl p20
p20:
	addi $s0,$zero,100	#flag=100
	addi $s1,$zero,0	#aux=0
	addi $t0,$zero,0x1001	#ir para o primeiro endereço
	sll  $t0,$t0,16		#shift para o endereço ficar 0x10010000
	sw   $s1,0($t0)		#armazenar 0
loop:
	addi $s1,$s1,1		#aux=aux+1
	sw   $s1,200($t0)	#armazenar numero
	addi $s1,$s1,1		#aux=aux+1	
	addi $t0,$t0,4		#próximo endereço
	sw   $s1,0($t0)		#armazenar proximo numero
	bne  $s1,$s0,loop	#continuar ate fim do loop
	
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional			
	