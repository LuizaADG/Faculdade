#Coment�rios
#Colocar no registrador 8 o valor 0xffffffff
#Fim de coment�rios
.text
.globl p7
p7:
	ori $8, $0, 0x01    #colocar valor 1
	sll $8,$8,31	    #shift at� ficar na 1a posi��o
	sra $8,$8,31	    #shift para encher de 1s