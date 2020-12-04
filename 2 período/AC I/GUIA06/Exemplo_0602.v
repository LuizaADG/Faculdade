// -------------------------
// Exemplo_0602 - GATES
// Nome: Luiza Ávila
// Matricula: 587490
// -------------------------
// -------------------------
// f6_gate
// -------------------------
module f6 ( output s1, output s2,input a,input b );
and AND1(s1,a,b);
or OR1(s2,a,b);
// descrever por portas
endmodule // f6
// -------------------------
// multiplexer
// -------------------------
module mux ( output s,input sa,input sb,input select );
// definir dados locais
wire notselect;
wire sa;
wire sb;
// descrever por portas
not NOT1 ( notselect, select );
and AND1 ( sa, a, select );
and AND2 ( sb, b, select );
or OR1 (s,sa,sb);
endmodule // mux
module test_f6;
// ------------------------- definir dados
reg x;
reg y;
reg s;
wire w;
wire z;
f6 modulo ( w, w, x, y );
mux MUX1 ( z, x, y, s );
// ------------------------- parte principal
initial
begin : main
$display("Exemplo_0602 - Luiza Ávila - 587490");
$display("Test LU's module");
$display(" x y s z");
x = 1'b0; y = 1'b1; s = 1'b0;
// projetar testes do modulo
#1 $monitor("%4b %4b %4b %4b", x, y, s, z );
#1 s = 1'b1;
end
endmodule // test_f6
