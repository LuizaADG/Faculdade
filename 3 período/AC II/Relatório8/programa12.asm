#Comentários
#Dobrar k
#Só tem valor de x
#Fim de comentários
.text
.globl p12
p12:
	addi $t0,$zero,0x1001         #armazenar endereço 0x1001
	sll  $t0,$t0,16               #shift nele para deixá-lo 0x10010000
	ori  $t0,$t0,0x000c           #endereço 0x1001000c
	lw   $t1,0($t0)               #armazena em t1 o endereço guardado em t0
	lw   $t2,0($t1)               #armazena em t2 o endereço guardado em t1 
	lw   $t3,0($t2)               #armazena em t3 o endereço guardado em t2 
	lw   $t4,0($t3)               #armazena em t4 o valor de k
	
	sll  $t4,$t4,1		     #multiplica por 2 o valor de t4
	sw   $t4,0($t3) 	
	
.data
	k:.word 2
	mem1:.word 0x10010000
	mem2:.word 0x10010004
	x:.word 0x10010008	
	