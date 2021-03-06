/**
* Trabalho de compiladores - Main
* Professor: Alexei Machado
* 
* @author Jorge Luiz
* @author Luiza Avila
* @author Stefany Gaspar
*/


import java.io.*;

public class Main{
    public static void main(String[]args) throws Exception{
        try{
            System.setProperty("file.encoding", "UTF-8");

            String fileName = args[0];
            TabelaSimbolos tabelaSimbolos = new TabelaSimbolos();
            BufferedReader code = new BufferedReader(new FileReader(fileName));
            //tabelaSimbolos.MostrarTabela();

            AnalisadorSintatico sintatico = new AnalisadorSintatico(code);
            sintatico.S();

            // Teste do lexico 
            // AnalisadorLexico analisador = new AnalisadorLexico(code,tabelaSimbolos);
            // while(analisador.maquinaDeEstados() != null) {
            //    Simbolo simbolo = analisador.maquinaDeEstados();
            //    //System.out.println(" " + simbolo.token);
            // }
            //System.out.println("Fim de arquivo");
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}