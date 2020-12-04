module clock (clk);
	output
    		clk;
	reg
    		clk; 
	initial
    		begin
    			clk = 1'b0;
		end
	always
	    begin
	    #12 clk = ~clk;
	end 
endmodule // clock ( ) 
 
module Exemplo_0901; 
 wire  clk;
 clock u1 ( clk ); 
    initial
        begin
        $display ( "Aluno: Luiza Ávila - 587490" );
        $display ( "Exemplo_0901.v" );
        $monitor("%b", clk);
        #120
        $finish;
    end 
endmodule // Exemplo_0901 ( )
