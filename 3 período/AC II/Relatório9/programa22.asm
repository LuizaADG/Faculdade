.data
	hello:.ascii "Hello World!"
.text
.globl p22
p22:    addi $v0,$zero,4	#chamar handler
	la   $a0,hello		#endereço do label
	syscall	
	addi $v0,$zero,10	#chamar o handler 10 
	syscall			#chamar sistema operacional