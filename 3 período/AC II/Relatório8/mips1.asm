.text
.globl main
#x->s0
#y->s1
#z->s2
#k->s3
main: 
	addi $t0,$zero,0x1001
	sll  $t1,$t0,16
	lw   $s0,0($t1)
	
	addi $t2,$t1,4
	lw   $s1,0($t2)
	
	addi $t3,$t1,8
	lw   $s2,0($t3)
	
	add $t4,$s0,$s1
	add $s4,$t4,$s2
	sw  $s4,12($t0)
	
.data
	x: .word 1
	y: .word 3
	z: .word 5
	k: .word 7
