#Comentários
#Ler numeros na tela e falar qual o maior
#s0->1 numero,s1->2 numero,s2->3 numero
#Fim de comentários
.text
.globl p23
p23:
	addi $v0,$zero,4	#chamar handler
	la   $a0,msg1		#endereço do label
	syscall	
	addi $v0,$zero,5	#chamar handler
	syscall 
	move $s0,$v0
	
	addi $v0,$zero,4	#chamar handler
	la   $a0,msg1		#endereço do label
	syscall	
	addi $v0,$zero,5	#chamar handler
	syscall 
	
	move $s1,$v0
	addi $v0,$zero,4	#chamar handler
	la   $a0,msg1		#endereço do label
	syscall	
	addi $v0,$zero,5	#chamar handler
	syscall 
	move $s2,$v0
troca:
	slt  $t0, $s1, $s0	# se s1 < s0
	bne  $t0, $zero, troca01# trocar s0 e s1	
volta:	
	slt  $t0, $s2, $s1	# se s2 < s1
	bne  $t0, $zero, troca12# troca s1 e s2
	
	la   $a0, msg2		# endereço do label
	addi $v0, $zero, 4	# chamar handler
	syscall			
	add  $a0,$zero,$s2	# carregar maior numero
	addi $v0, $0, 1		# carregar handler
	syscall			
	
	la   $a0, msg3		# carregar handler
	addi $v0, $zero, 4	# chamar handler
	syscall			
	add  $a0,$zero ,$s0	# chamar handler
	addi $v0, $zero, 1	# carregar handler
	syscall			

	addi $v0, $0, 10	# carregar handler
	syscall				
	
troca01: 
	move $t0, $s0		# {
	move $s0, $s1		#    troca s0 e s1
	move $s1, $t0		# 
	j volta			# }	
troca12:	
	move $t0, $s1		# {
	move $s1, $s2		#    troca s1 e s2
	move $s2, $t0		#
	j troca			# }		
.data
	msg1:.ascii "Digite o numero"
	msg2:.ascii "O maior= "
	msg3:.ascii "O menor= "
