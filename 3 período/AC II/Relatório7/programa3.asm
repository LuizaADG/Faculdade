#Comentários
#x=3
#y=4
#z=4(15x+67y)
#x->s0, y->s1,z->s2
#Fim de comentários
.text
.globl p3
p3:
	addi $s0,$zero,3     #x=3
	addi $s1,$zero,4     #y=4
	
	add  $t0,$zero,$s0   #t0=x
	add  $t0,$t0,$t0     #t0=2x
	add  $t0,$t0,$t0     #t0=4x
	add  $t0,$t0,$t0     #t0=8x
	add  $t0,$t0,$t0     #t0=16x
	sub  $t1,$t0,$s0     #t1=t0-s0=16x-x=15x
	
	add  $t2,$zero,$s1   #t2=y
	add  $t2,$t2,$t2     #t2=2y
	add  $t3,$zero,$t2   #t3=2y
	add  $t3,$t3,$s1     #t3=3y
	add  $t2,$t2,$t2     #t2=4y
	add  $t2,$t2,$t2     #t2=8y
	add  $t2,$t2,$t2     #t2=16y	
	add  $t2,$t2,$t2     #t2=32y
	add  $t2,$t2,$t2     #t2=64y
	add  $t4,$zero,$t2   #t4=64y
	add  $t4,$t4,$t3     #t4=67y
	
	add  $s2,$zero,$t4   #s2=67y
	add  $s2,$s2,$t1     #s2=67y+15x
	
	add  $s2,$s2,$s2     #s2=2(67y+15x)
	add  $s2,$s2,$s2     #s2=4(67y+15x)	