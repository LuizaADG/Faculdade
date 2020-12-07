#Comentários
#x=100000
#x=0x186A0
#y=200000
#y=0x30D40
#z=x+y
#x->s0, y->s1,z->s2
#Fim de comentários
.text
.globl p5
p5:
	addi $s0,$zero,0x186A      #x=0x186A
	sll  $s0,$s0, 4            #x=0x186A0
	
	addi $s1,$zero,0x30D4      #y=0x30D4
	sll  $s1,$s1,4             #y=0x30D40
	
	add  $s2,$s1,$s0           #z=x+y