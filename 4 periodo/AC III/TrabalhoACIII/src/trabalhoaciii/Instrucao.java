package trabalhoaciii;

/**
 *
 * @author LuizHG
 */
public class Instrucao {

    String instrucao;
    int tempoCiclo;
    Registrador r1;
    Registrador r2;
    Registrador r3;
    int numero;
    int ciclosDeStall;

    public Instrucao(String instrucao) {
        this.ciclosDeStall = 0;
        instrucao = instrucao.toLowerCase();
        String[] array = instrucao.split("_");
        /**
         * Esta parte separa os atributos da string instrução Quando a operação
         * é SW, LW, ADDI lw_S1,10(s2) primeiro faz o split no '_' e coloca a
         * primeira string no atributo instrução O r1 fica com a parte do s1, ou
         * seja, o primeiro registrador O r2 fica com a parte numérica + o
         * registrador que foi dito O r3 fica com um registrador coringa que não
         * tem dados e que o nome é 0.
         */
        this.instrucao = array[0];
        if (array[0].equals("lw") || array[0].equals("sw") || array[0].equals("addi")) {
            array[1] = array[1].replace("s", "");
            String[] registradores = array[1].split(",");
            r1 = Memoria.bancoRegistradores[Integer.parseInt(registradores[0])];
            registradores[1] = registradores[1].replace(")", "");
            registradores[1] = registradores[1].replace("(", " ");
            registradores = registradores[1].toString().split(" ");
            if (array[0].equals("addi")) {
                r2 = Memoria.bancoRegistradores[Integer.parseInt(registradores[0])];
                this.numero = Integer.parseInt(registradores[1]);
                r3 = new Registrador("0");

                this.tempoCiclo = 2;
            } else {
                r2 = Memoria.bancoRegistradores[Integer.parseInt(registradores[0])
                        + Memoria.bancoRegistradores[Integer.parseInt(registradores[1])].getDado()];
                r3 = new Registrador("0");

                this.tempoCiclo = 3;//Caso a instrução seja um lw ou um sw

            }
        } /**
         * Esta parte abaixo também separa os atributos com partes da String
         * Instruçoes que estão nelas: BNE, BEQ O registrador R1 e R2 apresentam
         * os registradores onde serão comparados O R3 é o registrador coringa
         */
        else if (array[0].equals("beq") || array[0].equals("bne")) {
            array[1] = array[1].replace("s", "");
            String[] registradores = array[1].split(",");
            r1 = Memoria.bancoRegistradores[Integer.parseInt(registradores[0])];
            r2 = Memoria.bancoRegistradores[Integer.parseInt(registradores[1])];
            r3 = new Registrador("0");
            this.tempoCiclo = 2;
        } /**
         * Esta parte abaixo também separa os atributos com partes da String
         * Instruçoes que estão nelas: ADD, SUB, MUL Ela distribui como os
         * comando sem assembly R1,R2,R3
         */
        else {
            array[1] = array[1].replace("s", "");
            String[] registradores = array[1].split(",");
            r1 = Memoria.bancoRegistradores[Integer.parseInt(registradores[0])];
            r2 = Memoria.bancoRegistradores[Integer.parseInt(registradores[1])];
            r3 = Memoria.bancoRegistradores[Integer.parseInt(registradores[2])];
            if (array[0].equals("mul")) {
                this.tempoCiclo = 3;
            } else {
                this.tempoCiclo = 2;//Caso a instrução seja um add ou um sup
            }
        }
        /**
         * System.out.println("Instrução: " + this.instrucao);
         * System.out.println("Ciclo: " + this.tempoCiclo);
         * System.out.println("Registrador: " + this.r1.getNome()); if(r2 !=
         * null) System.out.println("Registrador: " + this.r2.getNome()); if(r3
         * != null) System.out.println("Registrador: " + this.r3.getNome());
         * System.out.println("======================================================");
         *
         */
      
    }

    public String toString() {
        String resposta = "";
        String nomeR1 = r1.getNome();
        String nomeR2 = r2.getNome();
        String nomeR3 = r3.getNome();
        
        if (Renomear.getCont(r1) > 1) {
            nomeR1 = Character.toString((char)(Renomear.getPos(r1) + 97));
        }
        if (Renomear.getCont(r2) > 1) {
            nomeR2 = Character.toString((char)(Renomear.getPos(r2) + 97));
        }
        
        if (r3.getNome() != "0") {
            if (Renomear.getCont(r3) > 1) {
                nomeR3 = Character.toString((char)(Renomear.getPos(r3) + 97));
            }
            
            return ("[" + this.instrucao + "_" + nomeR1 + "," + nomeR2 + "," + nomeR3 + "]");
        }
        
        return ("[" + this.instrucao + "_" + nomeR1 + "," + nomeR2 + "]");
    }
    
    public String getInstrucao() {
        if (r3.getNome() != "0") {
            return ("[" + this.instrucao + "_" + this.r1.getNome() + "," + this.r2.getNome() + "," + this.r3.getNome() + "]");
        }
        
        return ("[" + this.instrucao + "_" + this.r1.getNome() + "," + this.r2.getNome() + "]");
    }
}
