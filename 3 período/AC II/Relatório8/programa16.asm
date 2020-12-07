#Comentários
#vetor de tamanho 100
#ordenar de acordo com a bolha
#Depois escrever soma
#100->s0,aux->s1
#Fim  de comentários
.text
.globl p16
p16:
	addi $s0,$zero,100	#flag=100
	addi $s1,$zero,0	#aux=0
	addi $t0,$zero,0x1001	#ir para o primeiro endereço
	sll  $t0,$t0,16		#shift para o endereço ficar 0x10010000
	add  $t1,$zero,$t0	#armazenar o endereço de t0
loopInt:
	lw   $t2,0($t0)		#carregar numero na primeira posição
	lw   $t3,4($t0)		#carregar segundo numero
	sub  $t4,$t3,$t2	#testar se um é maior que o outro
	sra  $t4,$t4,31		#shift mantendo o sinal
	bne  $t4,$zero,trocar	#trocar os números, caso não seja
return:
	addi $s1,$s1,1		#aux=aux+1
	add  $t0,$t0,4		#prox endereço
	bne  $s1,$s0,loopInt    #se aux!=flag	
	addi $s0,$s0,-1		#flag=flag-1
	addi $s1,$zero,0	#aux=0
	andi $t0,$t1,-1		
	bne  $s0,$zero,loopInt
	j fim
trocar:
	sw   $t3,0($t0)	        #trocando	
	sw   $t2,4($t0)
	j return
fim:
.data
	a:.word 25
	b:.word 24
	c:.word 23
	d:.word 22
	e:.word 21
	f:.word 20
	g:.word 19
	h:.word 18
	i:.word 17
	j:.word 16
	k:.word 15
	l:.word 14
	m:.word 13
	n:.word 12
	o:.word 11
	p:.word 10
	q:.word 9
	r:.word 8
	s:.word 7
	t:.word 6
	u:.word 5
	v:.word 4
	w:.word 3
	x:.word 2
	y:.word 1
	z:.word 0	