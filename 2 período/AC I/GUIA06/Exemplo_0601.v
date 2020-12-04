// -------------------------
// Exemplo_0601 - GATES
// Nome: Luiza Ávila
// Matricula: 587490
// -------------------------
// -------------------------
module f6 ( output s1,output s2,input a,input b );
// descrever por expressao
assign s1 = (a && b);
assign s2 = (a || b);
endmodule // f6
module test_f6;
// ------------------------- definir dados
reg x;
reg y;
wire a, b;
f6 modulo ( a, b, x, y );
// ------------------------- parte principal
initial
begin : main
$display("Exemplo_0601 - Luiza Ávila - 589740");
$display("Test module");
$display(" x y a b");
// projetar testes do modulo
$monitor("%4b %4b %4b %4b", x, y, a, b);
#1 x = 1'b0; y = 1'b0;
#1 x = 1'b0; y = 1'b1;
#1 x = 1'b1; y = 1'b0;
#1 x = 1'b1; y = 1'b1;
end
endmodule // test_f6



