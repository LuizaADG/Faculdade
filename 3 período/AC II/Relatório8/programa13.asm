#Coment�rios
#Ler A da mem�ria
#Identificar se � negativo
#Encontrar m�dulo
#Reescrever sobre A
#Fim de coment�rios
.text
.globl p13
p13:
	addi $t0,$zero,0x1001         #armazenar endere�o 0x1001
	sll  $t0,$t0,16               #shift nele para deix�-lo 0x10010000
	lw   $t1,0($t0)		      #armazenar em t1 o valor de A
	add  $t2,$zero,$t1            #armazenar no registrador t1 o valor de t0
	sra  $t2,$t2,31               #fazer um shift armazenando o sinal
	beq  $t2,0,fim                #se for igual a 0 pular para fim
	sub  $t1,$zero,$t1            #encontrar m�dulo
	sw   $t1,0($t0)		      #armazenar valor novo de A	
fim:
.data
	A:.word -3