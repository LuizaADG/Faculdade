// -------------------------
// Exemplo_0801 - FULL ADDER
// Nome: Luiza Ávila
// Matricula: 587490
// -------------------------
// -------------------------
module meioSomador(a, b, Res, CarryIn);//metodo de meioSomador
input
    a,b;
output
    Res,CarryIn;
assign Res = a || b;
assign CarryIn = a && b;
endmodule

module somador(a, b, Cin, Soma, Cout);
    input
        a,b,Cin;
    output
        Soma,Cout;
    wire
        carry1,carry2,soma1,soma2;
    //operações....Chama o método de meio somador levando os paramentros
    //e retornando a soma e o carry;
    meioSomador u1(a, b, soma1, carry1);
    meioSomador u2(Cin, soma1, Soma, carry2);
    or u3(Cout, carry1, carry2);
endmodule

module main;
    reg//variaveis de entrada, podemos mudar os valores
        A0,A1,A2,A3,
        B0,B1,B2,B3,
        CarryIn;
    wire//Variaveis resultantes
        S0,S1,S2,S3,
        Cout1, Cout2, Cout3,
        CarryOut;
    somador s1(A0, B0, CarryIn, S0, Cout1);
    somador s2(A1, B1, Cout1, S1, Cout2);
    somador s3(A2, B2, Cout2, S2, Cout3);
    somador s4(A3, B3, Cout3, S3, CarryOut);
  initial 
    begin
        //Partes que apresentam na tela
    //-------------------------------------------------------------
             $display("Exemplo_0801 - Luiza Ávila - 587490");
        $monitor("%2b  %2b  %2b  %2b\n%2b  %2b  %2b  %2b\n%2b  %2b  %2b  %2b\nCarry_out: %2b", A3, A2, A1, A0, B3, B2, B1, B0, S3, S2, S1, S0, CarryOut); 
    //-------------------------------------------------------------
    //Valores nas variaveis
    CarryIn = 0;
    A0 = 1;
    B0 = 0;
	A1 = 0;
	A2 = 1;
	A3 = 0;
    B0 = 0;
    B1 = 1;
    B2 = 1;
    B3 = 1;
      $finish ;
    end
endmodule

