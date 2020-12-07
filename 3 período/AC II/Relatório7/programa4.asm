#Comentários
#x=3
#y=4
#z=4(15x+67y)
#x->s0, y->s1,z->s2
#Fim de comentários
.text
.globl p4
p4:
	addi $s0,$zero,3     #x=3
	addi $s1,$zero,4     #y=4
	
	add  $t0,$zero,$s0   #t0=x
	sll  $s0,$s0,4       #s0=16x
	sub  $s0,$s0,$t0     #t1=t0-s0=16x-x=15x
	
	add  $t0,$zero,$s1   #t0=y
	add  $t0,$t0,$t0     #t0=2y
	add  $t0,$t0,$s1     #t0=3y
	sll  $s1,$s1,6       #s1=64y
	add  $s1,$s1,$t0     #s1=67y
	
	add  $s2,$zero,$s0   #z=15x
	add  $s2,$s2,$s1     #z=15x+67y
	
	sll  $s2,$s2,2       #z=4(15x+67y)