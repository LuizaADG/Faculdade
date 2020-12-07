#Comentários
#Ler TEMP da memória
#Testar se é maior ou igual a 30
#Testar se é menor ou igula a 50
#Se for os dois, flag=1, caso contrário, flag=0
#s0->1,s1->0
#Fim de comentários
.text
.globl p14
p14:
	addi $s0,$zero,1	      #armazenar 1 em s0
	addi $s1,$zero,0	      #armazenar 0 em s1
	
	addi $t0,$zero,0x1001         #armazenar endereço 0x1001
	sll  $t0,$t0,16               #shift nele para deixá-lo 0x10010000
	lw   $t1,0($t0)		      #armazenar em t1 o valor de TEMP
	
	beq  $t1,30,flag1             #se for igual a 30 para o fim
	beq  $t1,50,flag1             #se for igual a 50 para o fim
	
	add  $t2,$zero,$t1	      #t2=temp
	add  $t3,$zero,$t1	      #t3=temp
	
	addi $t2,$t2,-30	      #subtrair de temp 30
	sra  $t2,$t2,31 	      #shift que mantém o sinal
	beq  $t2,0,teste50            #se o número for maior que 30 testar em 50
	j flag0			      #caso contrário, ir para flag0
teste50:
	addi $t2,$t2,-50	      #subtrair de temp 50
	sra  $t2,$t2,31 	      #shift que mantém o sinal
	bne  $t2,0,flag1              #se o número for menor que 50 vai para flag1
	j flag0			      #caso contrário, ir para flag0
flag1:	
	sw $s0,4($t0)		     #colocar 1 em flag 
	j fim	
flag0:	
	sw $s1,4($t0)		     #colocar 0 em flag 
	j fim
fim:	
.data
	TEMP:.word 40
	flag:-1	
