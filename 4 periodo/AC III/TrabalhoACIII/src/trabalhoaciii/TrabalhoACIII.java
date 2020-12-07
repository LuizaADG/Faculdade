package trabalhoaciii;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author LuizHG
 */
public class TrabalhoACIII {

    static Memoria m;
    static JanelaInstrucao j;
    static TesteInterface teste;
    static Renomear rn;

    public static void main(String[] args) {
        m = new Memoria();
        rn = new Renomear();
        /**
         * Esta parte faz a leitura de um documento txt onde se encontra a
         * trace, e preenche a memória com as instruções.
         */
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Lu/Downloads/AC3/TrabalhoACIII/Trace/trace.txt"));
            //"C:/Luiz/TrabalhoACIII/Trace/trace.txt"));
            while (br.ready()) {
                Memoria.inserirInstrucaoMemoria(new Instrucao(br.readLine()));
            }
        } catch (Exception erroLeittura) {
        }

        j = new JanelaInstrucao(32);
        teste = new TesteInterface("ACIII", j);
    }

    public static void clock() {
        j.inserir();
        teste.mostrarJanela();
        j.ex.clock();
        j.despacharEx();
        teste.mostrarExecucao();
        teste.mostrarExecutados();
    }

    /*
    public void clock() {
        this.inserir();
        this.mostrar();
        ex.clock();
        this.despacharEx();
        ex.mostrarEx();

    }
     */
}
