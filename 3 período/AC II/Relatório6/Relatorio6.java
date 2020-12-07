import java.io.*;
import java.util.*;

public class Relatorio6 {
    public static void main(String[] args) {
        BufferedReader leitura = null;
        try { 
            //System.out.print("File exist.:" +new File("testeula.txt").exists());         
           // new File("testeula.txt").exists();
            //PrintWriter writer = new PrintWriter("testeula.txt", "UTF-8");
            leitura = new BufferedReader(new FileReader("testeula.txt"));//Busca o arquivo requerido
        }catch (IOException e) {
            System.out.println("Falha no arquivo");
        }//fim de catch
        if (leitura != null){//caso o arquivo não esteja em branco
            try {
               escreveArquivo(leitura);
            }catch (IOException e) {
               System.out.println("Erro na escrita");
            }
        }    
        leitura = null;
        try { 
            leitura = new BufferedReader(new FileReader("teste.hex"));//Buscar o .hex
        }
        catch (IOException e) {
            System.out.println("Falha no arquivo .hex");
        }
        //Mandar as instrucoes
        if (leitura != null)
            try { 
               arduino(leitura); 
            }catch (Exception e) { 
               System.out.println("Deu problema em mandar pro arduino"); 
            }
    }//fim de main
/*
Método para escrever o arquivo .hex
*/
    public static void escreveArquivo(BufferedReader arquivo) throws IOException{
        BufferedWriter arquivoHex = new BufferedWriter((new FileWriter("teste.hex")));
        char A = '0';
        char B = '0';
        char S = '0';

        //Ler repetidas vezes (2) para descartar a palavra "inicio:"
        String str = arquivo.readLine(); 
        str = arquivo.readLine().trim();
        while (!str.equals("fim.")) {//loop ocorre até achar "fim."
            if(str.startsWith("A=")){
               A = str.charAt(2);
            }else if (str.startsWith("B=")){  
               B = str.charAt(2);
            }else if (str.equals("zeroL;")){
               S = '0';
            }else if (str.equals("umL;")){
               S = '1';
            }else if (str.equals("An;")){
               S = '2';
            }else if (str.equals("Bn;")){
               S = '3';
            }else if (str.equals("AouB;")){
               S = '4';
            }else if (str.equals("AeB;")){
               S = '5';
            }else if (str.equals("AxorB;")){
               S = '6';
            }else if (str.equals("AnandB;")){
               S = '7';
            }else if (str.equals("AnorB;")){
               S = '8';
            }else if (str.equals("AxnorB;")){
               S = '9';
            }else if (str.equals("AnouB;")){
               S = 'A';
            }else if (str.equals("AouBn;")){
               S = 'B';
            }else if (str.equals("AneB;")){
               S = 'C';
            }else if (str.equals("AeBn;")){
               S = 'D';
            }else if (str.equals("AnouBn;")){
               S = 'E';
            }else if (str.equals("AneBn;")){
               S = 'F';
            }
            //Checar para não gerar instruções nas linhas de valores
            if (!str.startsWith("A=") && !str.startsWith("B=") && !str.equals("fim.")) {
                arquivoHex.write(Character.toString(A) + Character.toString(B) + Character.toString(S)+ '\n');//escreve no arquivo
            }
            str = arquivo.readLine().trim();
        }//fim do while
        arquivoHex.close();//fecha arquivo
    }//fim do método escreveArquivo
/*
Método para construir processo e mandar para o arduino
*/
    public static void arduino(BufferedReader arquivo) throws Exception {
        ProcessBuilder pb;
        Process p;
        String instr= arquivo.readLine();//instruções
        Scanner chave = new Scanner(System.in);//recebe chaves
        while(instr != null) {
            //System.out.print("Entrou");
            pb = new ProcessBuilder("envia.exe","COM5", instr);
            System.out.println("Instr:"+instr);
            System.out.println("Chave:"+chave);
            p = pb.start();
            p.waitFor();
            chave.nextLine();
            instr = arquivo.readLine();
            System.out.println("Instr:"+instr);
        }//fim de while
    }//fim de arduino
}//fim de Classe