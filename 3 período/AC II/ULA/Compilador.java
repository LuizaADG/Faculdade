import java.io.*;
import java.util.Scanner;

public class Compilador {
    public static void main(String[] args) {
        //Buscar o arquivo com os mnemonicos
        BufferedReader reader = null;
        try { reader = new BufferedReader(new FileReader("testeula.ula"));}
        catch (IOException e) {System.out.println("Instruction file not found");}

        //Fazer o .hex
        if (reader != null)
            try {compile(reader);}
            catch (IOException e) {System.out.println("Error in compilation");}

        //Abrir o .hex
        reader = null;
        try { reader = new BufferedReader(new FileReader("testeula.hex"));}
        catch (IOException e) {System.out.println("Hex file not found");}

        //Mandar as instrucoes
        if (reader != null)
            try { send(reader); }
            catch (Exception e) { System.out.println("Error in execution"); }
    }

    public static void compile(BufferedReader reader) throws IOException{
        BufferedWriter writer = new BufferedWriter((new FileWriter("testeula.hex")));
        char A = '0';
        char B = '0';
        char opCode = '0';

        //Lê-se 2 vezes para descartar a linha "inicio:"
        String str = reader.readLine(); str = reader.readLine().trim();
        while (!str.equals("fim.")) {
            if      (str.startsWith("A="))  A = str.charAt(2);
            else if (str.startsWith("B="))  B = str.charAt(2);
            else if (str.equals("zeroL;"))  opCode = '0';
            else if (str.equals("umL;"))    opCode = '1';
            else if (str.equals("An;"))     opCode = '2';
            else if (str.equals("Bn;"))     opCode = '3';
            else if (str.equals("AouB;"))   opCode = '4';
            else if (str.equals("AeB;"))    opCode = '5';
            else if (str.equals("AxorB;"))  opCode = '6';
            else if (str.equals("AnandB;")) opCode = '7';
            else if (str.equals("AnorB;"))  opCode = '8';
            else if (str.equals("AxnorB;")) opCode = '9';
            else if (str.equals("AnouB;"))  opCode = 'A';
            else if (str.equals("AouBn;"))  opCode = 'B';
            else if (str.equals("AneB;"))   opCode = 'C';
            else if (str.equals("AeBn;"))   opCode = 'D';
            else if (str.equals("AnouBn;")) opCode = 'E';
            else if (str.equals("AneBn;"))  opCode = 'F';

            //Check para não gerar instruções nas linhas de atribuicoes
            if (!str.startsWith("A=") && !str.startsWith("B=") && !str.equals("fim.")) {
                writer.write(Character.toString(A) + Character.toString(B) + Character.toString(opCode) + '\n');
            }
            str = reader.readLine().trim();
        }
        writer.close();
    }

    public static void send(BufferedReader reader) throws Exception {
        ProcessBuilder pb;
        Process p;
        String instruction = reader.readLine();
        Scanner keyIn = new Scanner(System.in);

        while(instruction != null) {
            pb = new ProcessBuilder("envia.exe","com8", instruction);
            p = pb.start();
            p.waitFor();
            keyIn.nextLine();
            instruction = reader.readLine();
        }
    }
}