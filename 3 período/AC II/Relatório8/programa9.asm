#Comentários
## x1->$s0,x2->$s1,x3->$s2,x4->$s3,soma->
#Fim de comentários
.text
.globl p9
p9:
	addi $t0,$zero,0x1001       #t0=0x1001
	sll  $t0,$t0,16		    #t0=0x10010000
	lw   $s0,0($t0)		    #s0=valor de t0
	lw   $s1,4($t0)             #s1=valor de t0+4bits
	lw   $s2,8($t0)	            #s2=valor de t0+8bits
	lw   $s3,12($t0)            #s3=valor de t0+12 bits
	
	add $t1,$s0,$s1             #t1=s0+s1
	add $t1,$t1,$s2             #t1=t1+s2
	add $t1,$t1,$s3             #t1=t1+s3
	
	sw  $t1,16($t0)             #armazenar o valor da soma
.data
	x1: .word 15
	x2: .word 25
	x3: .word 13
	x4: .word 17
	soma:.word -1
