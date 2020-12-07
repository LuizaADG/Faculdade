#Comentários
#Lê o tamanho do vetor
#soma os numeros e armazena
#flag->s0,aux->s1,soma->s2
#Fim de comentários
.text
.globl p24
p24:
	addi $v0,$zero,4	#chamar handler
	la   $a0,msg		#endereço do label
	syscall	
	addi $v0,$zero,5	#chamar handler
	syscall 
	move $s0,$v0		#s0=tamanho do vetor
	addi $s0,$s0,-1		#subtrai pois já vou guardar 1
	addi $s1,$zero,0	#aux=0
	addi $t0,$zero,0x1001	#ir para o primeiro endereço
	sll  $t0,$t0,16		#shift para o endereço ficar 0x1001000
	addi $t1,$zero,1	#x=1
	addi $s2,$zero,1	#soma=1
	sw   $t1,0($t0)		#primeiro endereço=1
loop:
	addi $t0,$t0,4		#proximo endereço
	addi $t1,$t1,2		#t1=t1+2
	sw   $t1,0($t0)		#primeiro endereço=x+2
	add  $s2,$s2,$t1	#soma=soma+prox. numero
	addi $s1,$s1,1		#aux=aux+1
	bne  $s1,$s0,loop
	
	sw   $s2,4($t0)		#guardar a soma
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional
		
.data
	msg:.ascii "Digite o tamanho do vetor"