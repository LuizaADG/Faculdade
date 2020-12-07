#Comentários
#x=0x7FFFFFFFF
#y=300000
#y=0x493E0
#z=x-4y
#x->s0, y->s1,z->s2
#Fim de comentários
.text
.globl p6
p6:
	addi $s0,$zero,0x7FFF      #x=0X7FFF
	sll  $s0,$s0, 16           #x=16 bits para a esquerda
	addi $s0,$s0,0XFFFF	   #x=0X7FFFFFFFF
	
	addi $s1,$zero,0x493E      #y=0x493E
	sll  $s1,$s1,4            #y=0x493E0
	
	add  $t0,$zero,$s1         #t0=y
	sll  $s1,$t0,2             #s1=4y
	
	sub $s2,$s0,$s1            #z=x-y       