// -------------------------
// Exemplo_0803
// Nome: Luiza Ávila
// Matricula: 587490
// Theldo,favor checar no Logisim. Lá está funcionando
// -------------------------
// -------------------------
module comparador(input a, input b, input d ,output Resp1, output Resp2,output Resp3,output s);//metodo de comparador
and AND1(Resp1,a,~b);
and AND2(Resp2,~a,d);
not not1(Resp3,s);
or OR1(s,Resp1, Resp2);
endmodule

module comparadorCompleto(input a, input b, input c, input d,output s1,output s2,output ss);
    wire sa;
    wire sb;
    wire sc;
    wire sd;
    wire se;
    wire sf;
    comparador u1(a,b,d,sa,sb,se,s1);
    comparador u2(c,d,b,sc,sd,sf,s2);
    and AND3(ss,s1,s2);
endmodule

module main(output ss, input s1, input s2);
    reg//variaveis de entrada, podemos mudar os valores
        A0,A1,A2,A3;
    comparadorCompleto q(A0, A1, A2, A3,s1,s2,ss);
    initial 
    begin
        //Partes que apresentam na tela
    //-------------------------------------------------------------
         $display("Exemplo_0803 - Luiza Ávila - 587490");
        $monitor("%2b  %2b  %2b  %2b %2b %2b %2b\n", A3, A2, A1, A0,ss,s1,s2);
    //-------------------------------------------------------------
    //Valores nas variaveis
    A0 = 0;
	A1 = 0;
	A2 = 0;
	A3 = 0;
      $finish ;
    end
endmodule

