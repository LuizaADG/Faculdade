#Comentários
#x=1
#y=5x+15
#x->s0, y->s1
#Fim de comentários
.text
.globl p2
p2:
	addi $s0,$zero,1       #x=1   
	add  $t0,$zero,$s0     #t0=x
	add  $t0,$t0,$t0       #t0=2x
	add  $t0,$t0,$t0       #t0=4x
	add  $s1,$zero,$t0     #y=t0
	add  $s1,$s0,$t0       #y=5x
	addi $s1,$s1,15        #y=5x+15  