#Comentários
#x->s0,y->s1,z->s2
#Fim de Comentários
.text
.globl p19
p19:
	addi $s0,$zero,0x186A	#numero x(parte)
	sll  $s0,$s0,8		#numero x inteiro
	addi $s1,$zero,0x1388	#numero y(parte)
	sll  $s1,$s1,4		#numero y inteiro
	addi $s2,$zero,0x61A8	#numero z(parte)
	sll  $s2,$s2,4		#numero z inteiro

	mult $s1,$s0		#x*y
	mflo $t0		#t0=x*y
	div  $t0,$s3		#t0/z
	mflo $t1
				
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional