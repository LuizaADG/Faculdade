#Comentários
#x->s1,y->s0
#Fim de Comentários
.text
.globl p18
p18:
	addi $t0,$zero,0x1001	#ir para o primeiro endereço
	sll  $t0,$t0,16		#shift para o endereço ficar 0x10010000
	add  $t1,$zero,$t0	#armazenar o endereço de t0
	lw   $s1,0($t0)		#carregar numero na primeira posição
	
	slt $t1,$s1,$zero		
	beq $t1,$zero,maior	#se x<0 t0=1, else t0=0
menor:
	mult $s1,$s1		#x^2
	mflo $s2		#s2=x^2	
	mult $s2,$s2		#x^4
	mflo $s3		#s3=x^4
	addi $s0,$s3,-1
	j fim
maior:	
	beq $s1,$zero,menor
	mult $s1,$s1		#x^2
	mflo $s2		#s2=x^2	
	mult $s2,$s1		#x^3
	mflo $s3		#s3=x^3
	addi $s0,$s3,1		#y=s3+1
	j fim
	
fim:	sw $s0,4($t0)		#armazenar numero	
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional
.data 
	x:.word -4