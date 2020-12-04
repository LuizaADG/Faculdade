;************** AULA 01 - PROGRAMA PARA PISCAR LED *****************
LIST   P=PIC16F628A
RADIX DEC	
#INCLUDE <P16F628A.INC>
	__CONFIG _INTRC_OSC_NOCLKOUT & _WDT_OFF & _PWRTE_ON & _BODEN_OFF & _LVP_OFF & _CP_OFF & _MCLRE_OFF & _CPD_OFF 
	;ou __CONFIG H'3F10'

	CBLOCK	0x20	;ENDERE�O INICIAL DA MEM�RIA DE
					;USU�RIO
	CONTADOR1
	CONTADOR2
	ENDC			;FIM DO BLOCO DE MEM�RIA		
	
	ORG	0x00		;ENDERE�O INICIAL DE PROCESSAMENTO
	GOTO	INICIO
		
INICIO
	CLRF	PORTA		;LIMPA O PORTA
	CLRF	PORTB		;LIMPA O PORTB
	BSF STATUS, RP0
	CLRF TRISB
	BCF STATUS, RP0

REPETE
	BSF PORTB, 1
	CALL ATRASO
	BCF PORTB, 1
	CALL ATRASO
	GOTO REPETE


ATRASO				
	MOVLW	10
	MOVWF	CONTADOR1	
ATRASO1				
	DECFSZ	CONTADOR1	
	GOTO	ATRASO1		 
						
	RETURN				


END