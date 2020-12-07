#x=2
#y=3
#z=x-y
#x-s0,y-s1,z-s2
.text
.globl main 
main:
	addi $s0,$zero,2 #x=2
	addi $s1,$zero,3 #y=3
	sub  $s2,$s0,$s1 #z=x-y
	sll  $zero,$zero,0
	