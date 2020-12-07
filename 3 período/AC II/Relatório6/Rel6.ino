#define Bit 4 // Numero de bits das entradas
#define Led1 13 // pinos em que estao ligados os LEDs
#define Led2 12
#define Led3 11
#define Led4 10
// hexas de entrada recebidos pelo programa em java
char Ain;
char Bin;
char Opin;
// valores em bit das entradas e saida em arrays booleanos
bool A[Bit];
bool B[Bit];
bool S[Bit];
void setup() {
	Serial.begin(9600);
	pinMode(Led1, OUTPUT);
	pinMode(Led2, OUTPUT);
	pinMode(Led3, OUTPUT);
	pinMode(Led4, OUTPUT);
}//fim
void loop() {
	if (Serial.available() > 0) {
		Ain = Serial.read();
		delay(10);
		Bin = Serial.read();
		delay(10);
		Opin = Serial.read();
		delay(10);
		if(Serial.read() == '\n') {
			Serial.print(Ain);
			Serial.print(Bin);
			Serial.println(Opin);		
			byte auxA = hexDec(Ain);// converte os valores hexa da entrada em decimal
			byte auxB = hexDec(Bin);
			decBin(auxA, A);// converte valores em decimal para binario (coluna de bool)
			decBin(auxB, B);
			MUX(Ain, Bin, Opin);// direciona a saida de acordo com a selecao
			ascender();// ascende os leds com o resultado da ULA
		}//fim if2
	}//fim if1
}//fim
byte hexDec(char c) {
	byte aux = c;
	if(aux >= 65){
		 aux = aux - 55;
	}	
	return aux;
}//fim
void decBin(byte dec, bool bin[]) {	
	for(byte i = 0; i < Bit; i++) {
		bin[i] = dec % 2;
		dec = dec / 2;
	}//fim de for
}//fim
void ascender() {
	digitalWrite(LED_0, S[0]);
	digitalWrite(LED_1, S[1]);
	digitalWrite(LED_2, S[2]);
	digitalWrite(LED_3, S[3]);
}

void MUX(byte ain, byte bin, char Op) {
/*
Ordem dos cases: zeroL,umL,An,Bn,AouB,AeB,AxorB,AnandB,AnorB,AxnorB,AnouB,AouBn,AneB,AeBn,AnouBn,AneBn
*/	
	switch(Op) {
		case '0': {
					decBin(0, S);
					break;
		}
		case '1': {
					decBin(pow(2, Bit) - 1, S);
					break;
		}
		case '2': {
					nt(A, S);
					break;
		}
		case '3': {
					nt(B, S);
					break;
		}
		case '4': {
					OR(A, B, S);
					break;
		}
		case '5': {
					AND(A, B, S);
					break;
		}
		case '6': {
					XOR(A, B, S);
					break;
		}
		case '7': {
					bool AeB[Bit];
					AND(A, B, AeB);
					nt(AeB,S);
					break;
		}
		case '8': {
					bool AorB[Bit];			
					OR(A, B, AorB);
					nt(AorB, S);
					break;
		}
		case '9': {		
					bool AxorB[Bit];
					XOR(A, B, AxorB);
					nt(AxorB, S);
					break;
		}
		case 'A': {
					bool An[Bit];				
					nt(A, An); '
					OR(An, B, S);
					break;
		}
		case 'B': {
					bool Bn[Bit];
					nt(B, Bn); '
					OR(A, Bn, S);
					break;
		}
		case 'C': {
	 				bool An[Bit];			
					nt(A, An); 
					AND(An, B, S);
					break;
		}
		case 'D': {
					bool Bn[Bit];		
					nt(B, Bn); 
					AND(A, Bn, S);
					break;
		}
		case 'E': {
					bool An[Bit];
					bool Bn[Bit];
					nt(A, An);
					nt(B, Bn);
					OR(An, Bn, S);
					break;
		}
		case 'F': {
					bool An[Bit];
					bool Bn[Bit];
					nt(A, An);
					nt(B, Bn);
					AND(An, Bn, S);
					break;
		}
	}//fim de switch
}//fim
void XOR(bool a[], bool b[], bool s[]) {
	 for(int i = 0; i < Bit; i++) {
		s[i] = a[i] ^ b[i];
	}
}//fim
void AND(bool a[], bool b[], bool s[]) {
	for(int i = 0; i < Bit; i++) {
		s[i] = a[i] & b[i];
	}
}//fim
void OR(bool a[], bool b[], bool s[]) {
	for(int i = 0; i < Bit; i++) {
		s[i] = a[i] | b[i];
	}
}//fim
void nt(bool bin[], bool aux[]) {
	for(int i = 0; i < Bit; i++) {
		aux[i] = ! bin[i];
	}
}//fim


