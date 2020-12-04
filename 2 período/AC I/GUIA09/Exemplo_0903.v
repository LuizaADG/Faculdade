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
        #12
        clk = ~clk;
    end
endmodule 

module pulse1 ( signal, clock );
    input
        clock;
    output
        signal;
    reg 
        signal;
    always
        @ ( clock )
        begin
            signal = 1'b1;
            #3
            signal = 1'b0;
            #3
            signal = 1'b1;
            #3
            signal = 1'b0;
        end
endmodule // pulse 

module pulse2 ( signal, clock );
    input
        clock;
    output
        signal;
    reg 
        signal;
    always
        @ ( clock )
        begin
            signal = 1'b1;
            #6
            signal = 1'b0;
            #6
            signal = 1'b1;
            #6
            signal = 1'b0;
        end
endmodule // pulse 
 
module Exemplo_0903; 
    wire
        clock;
    clock clk ( clock ); 
    wire
        p1, p2; 
    pulse1 u1( p1, clock );
    pulse2 u2( p2, clock );
    initial
        begin 
        $display ( "Exemplo0903.v" );
        $display ( "Aluno: Luiza Ávila - 587490" );
        $display ( "CLK P1 P2" );
        $monitor(" %b   %b  %b", clock, p1, p2);
        #120
        $finish;
        end 
endmodule // Exemplo_0903
