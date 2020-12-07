#Comentários
#x->s0,z->s1,y->s2
#Fim e comentários
.text
.globl p11
p11:
	addi $t0,$zero,0x1001       #t0=0x1001
	sll  $t0,$t0,16		    #t0=0x10010000
	lw   $s0,0($t0)		    #x=valor de t0
	lw   $s1,4($t0)		    #z=valor de t0+4bits
	
	addi $t1,$zero,0x493E       #t1=0x493e
	sll  $t1,$t1,4             #t1=0x493e0
	
	sub  $s2,$s0,$s1            #y=x-z
	add  $s2,$s2,$t1            #y=y+300000
	
	sw   $s2,8($t0)             #armazenar valor
.data
x: .word 100000
z: .word 200000
y: .word 0 # esse valor deverá ser sobrescrito após a execução do programa.