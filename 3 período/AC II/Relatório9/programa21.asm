#Comentários
#x->s0,y->s1,aux->s2
#Fim de Comentários
.text
.globl p21
p21:
	addi $t0,$zero,0x1001	#ir para o primeiro endereço
	sll  $t0,$t0,16		#shift para o endereço ficar 0x10010000
	add  $t1,$zero,$t0	#armazenar o endereço de t0
	lw   $s0,0($t0)		#carregar numero na primeira posição
	lw   $s1,4($t0)		#carregar numero da segunda posição
	addi $s2,$zero,0	#aux=0
	add  $t2,$zero,$s0	#t2=x
	addi $s1,$s1,-1		#s1=s1-1
loop:	
	mult $t2,$s0		#x*s1
	mflo $s0		#s3=s1
	addi $s2,$s2,1	        #aux=aux+1
	bne  $s2,$s1,loop	#se aux não for menor que y
	
	sw   $s0,8($t0)		#armazenar valor do resultado na terceira posição
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional		
	
.data
	x:.word 4
	y:.word	3