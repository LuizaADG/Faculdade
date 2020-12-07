char entrada = '0';   
int led13 = 13;
int led12 = 12;
int led11 = 11;
int led9 = 9;
int led8 = 8;
int led7 = 7;
int led6 = 6;
int led5 = 5;
int led4 = 4;
int i;
void setup() {
	Serial.begin(9600);     // abre a porta serial a 9600 bps
	pinMode(led13,OUTPUT);  // S1 vermelho
	pinMode(led12,OUTPUT);  // S1 amarelo
	pinMode(led11,OUTPUT);  // S1 verde
	pinMode(led9,OUTPUT);   // S2 vermelho
	pinMode(led8,OUTPUT);   // S2 amarelo
	pinMode(led7,OUTPUT);   // S2 verde
	pinMode(led6,OUTPUT);   // S3 vermelho
	pinMode(led5,OUTPUT);   // S3 amarelo
	pinMode(led4,OUTPUT);   // S3 verde
}

void loop() {
	
	// verifica se existe dados a ser lido
	if (Serial.available() > 0) {
		// le o dado
		entrada = Serial.read();
		
		if (entrada == '1'){
			digitalWrite(led12,LOW);//apaga amarelo S1
			digitalWrite(led13,HIGH);//acende vermelho S1
			digitalWrite(led9,LOW);//apaga vermelho S2
			digitalWrite(led7,HIGH);//acende verde S2
			digitalWrite(led6,LOW);//apaga vermelho S3
			digitalWrite(led4,HIGH);//acende verde S3
		}
		if (entrada == '2'){
			digitalWrite(led13,HIGH);//acende vermelho S1
			digitalWrite(led7,LOW);//apaga verde S2
			digitalWrite(led8,HIGH);//acende amarelo S2
			digitalWrite(led4,LOW);//apaga verde S3
			digitalWrite(led5,HIGH);//acende amarelo S3
		}
		if (entrada == '3'){
			digitalWrite(led8,LOW);//apaga amarelo S2
			digitalWrite(led9,HIGH);//acende vermelho S2
			digitalWrite(led5,LOW);//apaga amarelo S3
			digitalWrite(led6,HIGH);//acende vermelho S3
			digitalWrite(led13,LOW);//apaga vermelho S1
			digitalWrite(led11,HIGH);//acende verde S1
		}
		if (entrada == '4'){
			digitalWrite(led11,LOW);//apaga verde S1
			digitalWrite(led12,HIGH);//acende amarelo S1
			digitalWrite(led9,HIGH);//acende vermelho S2
			digitalWrite(led6,HIGH);//acende vermelho S3
		}
	}
}
