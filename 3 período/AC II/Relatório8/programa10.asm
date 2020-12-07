#Comentários
#x->s0,z->s1,y->s2
#Fim de comentários
.text
.globl p10
p10:
	addi $t0,$zero,0x1001       #t0=0x1001
	sll  $t0,$t0,16		    #t0=0x10010000
	lw   $s0,0($t0)		    #x=valor de t0
	lw   $s1,4($t0)		    #z=valor de t0+4bits
	
	add  $t1,$zero,$s0   #t1=x
	sll  $s0,$s0,7       #s0=128x
	sub  $s0,$s0,$t1     #s0=128x-x=127x
	
	add  $t2,$zero,$s1    #t2=z
	sll  $s1,$s1,6        #s1=64z
	add  $s1,$s1,$t2      #s1=64z+z=65z
	
	sub  $s2,$s0,$s1       #s2=s0-s1(127x-65z)
	addi $s2,$s2,1         #s2=s2+1
	
	sw   $s2,8($t0)       #armazenar valor
	
.data
	x: .word 5
	z: .word 7
	y: .word 0 # esse valor deverá ser sobrescrito após a execução do programa.