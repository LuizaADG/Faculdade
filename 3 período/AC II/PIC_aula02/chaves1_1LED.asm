RADIX DEC	
#INCLUDE <P16F628A.INC>		;ARQUIVO PADR�O MICROCHIP PARA 16F628A
__CONFIG H'3F10'

	CBLOCK	0x20	;ENDERE�O INICIAL DA MEM�RIA DE USU�RIO
	ANDAR
	CONTADOR1
	CONTADOR2
	CONTADOR3
	CONTADOR4
	CONTADORFOR
	ENDC			;FIM DO BLOCO DE MEM�RIA		

#DEFINE	BOTAO	PORTA,2	;PORTA DO BOT�O
					; 0 -> PRESSIONADO
					; 1 -> LIBERADO

#DEFINE	LED	PORTB,0	;PORTA DO LED Terreo
				; 0 -> APAGADO
				; 1 -> ACESO
#DEFINE	ANDAR1		PORTB,1	;1� andar
#DEFINE	ANDAR2		PORTB,2	;2� andar
#DEFINE	ANDAR3		PORTB,3	;3� andar
#DEFINE	ANDAR4		PORTB,4	;4� andar
#DEFINE	CONTROLE	PORTB,5	;CONTROLE DA PORA TODA

	ORG	0x00		;ENDERE�O INICIAL DE PROCESSAMENTO
	GOTO	INICIO
	
INICIO
	CLRF	PORTA		;LIMPA O PORTA
	CLRF	PORTB		;LIMPA O PORTB
	BSF STATUS, RP0			;ALTERA PARA O BANCO 1
	MOVLW	B'00000100'
	MOVWF	TRISA		;DEFINE RA2 COMO ENTRADA E DEMAIS COMO SA�DAS
	CLRF	TRISB		;DEFINE TODO O PORTB COMO SA�DA
	CLRF	INTCON		;TODAS AS INTERRUP��ES DESLIGADAS
	BCF STATUS, RP0 ;RETORNA PARA O BANCO 0
	MOVLW	B'00000111'
	MOVWF	CMCON		;DEFINE O MODO DO COMPARADOR ANAL�GICO

MAIN
	CALL SEC1 ;1.000045 SEGUNDOS
	CALL SEC2 ;2.000094 SEGUNDOS
	CALL SEC4 ;4.000192 SEGUNDOS
	CALL SEC8 ;8.000390 SEGUNDOS
	GOTO MAIN

SEC8 ;5 STACK
	CALL SEC4
	CALL SEC4
	RETURN

SEC4 ;4 STACK
	CALL SEC2
	CALL SEC2
	RETURN

SEC2 ;3 STACK
	CALL SEC1
	CALL SEC1
	RETURN
;--------------------------- Delay 1.000045 -------------------------------
SEC1 ;2 STACK NA PILHA				
	MOVLW	20
	MOVWF	CONTADOR1
	ATRASO1		
			MOVLW	185
			MOVWF	CONTADOR2
			CALL BOTAOPRECIONADO ;50.002000 microsegundos
		ATRASO2
					MOVLW	88
					MOVWF	CONTADOR3					
				ATRASO3
					DECFSZ	CONTADOR3
					GOTO	ATRASO3	
			DECFSZ	CONTADOR2
			GOTO	ATRASO2	
		DECFSZ	CONTADOR1
		GOTO	ATRASO1			
	RETURN
;--------------------------- Delay 1.000045 -------------------------------
;--------------------------- Teste com o botao -------------------------------
BOTAOPRECIONADO ;1 STACK
	GOTO ATRASO
TESTEBOTAO ;40.000000
	BTFSC	BOTAO		;O BOT�O EST� PRESSIONADO?
	GOTO	BOTAO_LIB	;N�O, ENT�O TRATA BOT�O LIBERADO
	GOTO	BOTAO_PRES	;SIM, ENT�O TRATA BOT�O PRESSIONADO
;--------------------------- Teste com o botao -------------------------------
;--------------------------- Operacoes com o botao -------------------------------
BOTAO_LIB
	BCF	LED		;APAGA O LED
	RETURN;GOTO 	MAIN		;RETORNA AO LOOP PRINCIPAL

BOTAO_PRES
	BSF	LED		;ACENDE O LED
	RETURN ;GOTO 	MAIN		;RETORNA AO LOOP PRINCIPAL
;--------------------------- Operacoes com o botao -------------------------------
;--------------------------- Atraso para reconhecimento do botao -------------------------------
ATRASO
	GOTO NEXT01
	NEXT01
	MOVLW	134
	MOVWF	CONTADORFOR					
FOR
	DECFSZ	CONTADORFOR
	GOTO	FOR
	GOTO TESTEBOTAO
;--------------------------- Atraso para reconhecimento do botao -------------------------------
;--------------------------- LED ANDAR -------------------------------
ANDAR
	

END			;OBRIGAT�RIO
