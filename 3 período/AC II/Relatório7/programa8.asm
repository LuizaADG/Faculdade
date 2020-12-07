#Comentários
#$8= 0x12345678
#$9 = 0x12
#$10 = 0x34
#$11 = 0x56
#$12 = 0x78
#Fim de comentários
.text
.globl p8
p8:
	addi $8, $0, 0x1234    #reg8=0x1234
	sll  $8,$8,16          #reg8=0x12340000
	addi $8,$8,0x5678      #reg8=0x12345678
#reg9	
	addi $9,$zero,0xFF     #reg9=0xFF
	sll  $9,$9,24          #coloca os FF no início
	and  $9,$9,$8	       #fazer um and para ter resultado requerido
	srl  $9,$9,24          #reg9=0x12  
#reg10
	addi $10,$zero,0xFF     #reg9=0xFF
	sll  $10,$10,16         #coloca os FF no início
	and  $10,$10,$8	        #fazer um and para ter resultado requerido
	srl  $10,$10,16          #reg9=0x12  
#reg11
	addi $11,$zero,0xFF     #reg9=0xFF
	sll  $11,$11,8         #coloca os FF no início
	and  $11,$11,$8	        #fazer um and para ter resultado requerido
	srl  $11,$11,8          #reg9=0x12  	
#reg12	
	addi $12,$zero,0xFF     #reg12=0xFF
	and  $12,$12,$8	        #fazer um and para ter resultado requerido
	
	