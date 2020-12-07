.text
.globl main
main:
	#addi $s0,$zero,5       #s0=5
	addi $s1,$zero,2	#s1=2
	addi $v0,$zero,4	#chamar handler
	la   $a0,msg1		#endereço do label
	syscall
	addi $v0,$zero,5	#chamar handler
	syscall 
	move $s0,$v0		#s0=v0
	add $s2,$s0,$s1		#soma
	move $a0,$s2		#a0=s2
	addi $v0,$zero,1	#chamar handler 1
	syscall
	#div  $s0,$s1		#dividir 5*2
	#mflo $s3		#levar valor de lo para s3
	#mfhi $s4		#valor de hi para s4
	#move $s0,$s1		#mover valor de s1 para s0
	#li   $s2,0x12345678	#armazenar em s2 o valor maior de 32 bits
	#la   $s5,x		#pegar endereço de x
	#lw   $s6,y		#pegar valor de y
	
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional 
.data 
	x:.word 5 
	y:.word 7  
	msg1: .asciiz "\n Digite o número \n"