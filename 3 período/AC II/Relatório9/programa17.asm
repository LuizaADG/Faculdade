#Comentários
#x->s1,y->s0
#Fim de Comentários
.text
.globl p17
p17:
	addi $t0,$zero,0x1001	#ir para o primeiro endereço
	sll  $t0,$t0,16		#shift para o endereço ficar 0x10010000
	add  $t1,$zero,$t0	#armazenar o endereço de t0
	lw   $s1,0($t0)		#carregar numero na primeira posição
	
	addi $t2,$zero,2	#t2=2
	div  $s1,$t2		#dividir x por 2
	mfhi $s2		#levar resto da divisão para s2
	bne  $s2,$zero,impar	#se for impar
	
	mult $s1,$s1		#x^2
	mflo $s3		#s3=x^2
	mult $s3,$s3		#x^4
	mflo $s4		#s4=x^4
	mult $s3,$s1		#x^3
	mflo $s5		#s5=x^3
	add $s0,$s5,$s4	        #s0=x^4+x^3
	sll  $s3,$s3,1		#s3=2(x^2)
	sub  $s0,$s0,$s3	#y=s0-s3
	j fim			#va para a linha fim
impar:
	mult $s1,$s1		#x^2
	mflo $s3		#s3=x^2
	mult $s3,$s3		#x^4
	mflo $s4		#s4=x^4
	mult $s3,$s1		#x^3
	mflo $s5		#s5=x^3
	mult $s4,$s1		#x^5
	mflo $s6		#s6=x^5
	sub  $s7,$s6,$s5	#s7=s6-s5
	addi $s0,$s7,1		#y=s7+1
	
fim:	sw $s0,4($t0)		#armazenar numero	
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional  
.data 
	x:.word 3
