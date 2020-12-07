#Comentários
#a=2
#b=3
#c=4
#d=5
#x=(a+b)-(c+d)
#y=a-b+X
#b=x-y
#a->s0,b->s1,c->s2,d->s3,x->s4,y->s5
#Fim comentários
.text
.globl p1
p1:
	addi $s0,$zero,2    #a=2
	addi $s1,$zero,3    #b=3
	addi $s2,$zero,4    #c=4
	addi $s3,$zero,5    #d=5
	add  $t0,$s0,$s1    #t0=(a+b)
	add  $t1,$s2,$s3    #t1=(c+d)
	sub  $s4,$t0,$t1    #x=t0-t1   
	sub  $t2,$s0,$s1    #t2=a-b
	add  $s5,$s4,$t2    #y=t2+x	
	sub  $s1,$s4,$s5    #b=x-y