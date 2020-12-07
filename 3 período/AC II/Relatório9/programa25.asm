#Comentários
#Lê o grau em fahrenheit e calcula em celsius
#Fim de comentários
.text
.globl p25
p25:
	addi $v0,$zero,4	#chamar handler
	la   $a0,msg		#endereço do label
	syscall	
	addi $v0,$zero,5	#chamar handler
	syscall 
	move $s0,$v0		#s0=temp. em fahrenheit
	
	addi $t0,$zero,5	#t0=5
	addi $t1,$zero,9	#t1=9
	addi $t2,$zero,10	#t2=10
	
	addi $s0,$s0,-32	#Fº-32
	mult $s0,$t0		#5*t3
	mflo $s0
	div  $s0,$t1		#s0/9
	mflo $t3		#t3 armazena o resultado
	mfhi $t4
	mult $t4,$t2		#multplico o resto por 10
	mflo $t4		#armazeno em t4
	div  $t4,$t1		#divido t4/9
	mflo $t5		#armazeno em t5
				
	add  $a0,$zero,$t3	# carregar numero inteiro
	addi $v0, $zero, 1	# carregar handler
	syscall	
	la   $a0, ponto		# endereço do label		
	addi $v0,$zero,4	#carregar handler
	syscall
	add  $a0,$zero,$t5	# carregar numero inteiro
	addi $v0, $zero, 1	# carregar handler
	syscall	
		
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional  
.data
	msg:.ascii "Digite a temperatura em fahrenheit"	
	ponto:.ascii "."	