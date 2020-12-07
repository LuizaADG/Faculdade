package trabalhoaciii;

import java.util.ArrayList;

public class JanelaInstrucao {

    public int tam;
    public Execucao ex;
    public ArrayList<Instrucao> janela;

    public JanelaInstrucao(int tamanho) {
        tam = tamanho;
        janela = new ArrayList<Instrucao>(tamanho);
        ex = new Execucao(2, 1, 1, 1, this);
    }

    public void inserir() {
        int aux = 4;
        if (Memoria.instrucoesLidas > Memoria.quantMemoria() - 3) {
            aux = Memoria.quantMemoria() - Memoria.instrucoesLidas;
        }
            for (int i = 0; i < aux; i++) {
                Instrucao atual = Memoria.memoriaPrincipal[Memoria.instrucoesLidas];
                janela.add(atual);
                Memoria.instrucoesLidas = Memoria.instrucoesLidas + 1;
            }
    }

    public Instrucao[] getAnteriores(Instrucao atual) {
        Instrucao[] anteriores = new Instrucao[3];
        System.out.println("Instrucao atua: " + atual.toString());
        for (int j = 0; j < 3; j++) {

            if (janela.indexOf(atual) - j - 1 >= 0) {
                anteriores[j] = janela.get(janela.indexOf(atual) - j - 1);
                System.out.println("-------------Instrucao anterior: " + anteriores[j].toString());
            }
        }
        //System.out.println("Retornando");
        return anteriores;
    }

    public void renomear(Instrucao i) {
        Registrador t1 = i.r2;
        Registrador t2 = i.r3;
    }

    public boolean dependenciaFalsa(Instrucao atual, Instrucao[] anteriores) {

        System.out.println("Dependencia falsa entrou!!");
        for (int i = 0; i < anteriores.length; i++) {
            if (anteriores[i] != null && (anteriores[i].r1 == atual.r1 || anteriores[i].r2 == atual.r1 || anteriores[i].r3 == atual.r1)) {
                System.out.println("===========> Dependencia falsa ");
                Renomear.incrementar(atual.r1);
                return true;
            }
        }

        //Detecta write-after-read
        /*
        for (int i = 0; i < anteriores.length; i++) {
            if (anteriores[i] != null && (anteriores[i].r2.getNome().equals(atual.r1.getNome()) || anteriores[i].r3.getNome().equals(atual.r1.getNome()))) {
                System.out.println("===========> Dependencia falsa ");
                return true;
            }
        }
        */

        return false;
    }

    public boolean dependenciaVerdadeira(Instrucao atual, Instrucao[] anteriores) {

        //System.out.println("Dependencia Verdadeira entrou!!\n Tam array: " + anteriores.length);
        //Detecta read-after-write
        for (int i = 0; i < anteriores.length; i++) {
            if (anteriores[i] != null && (anteriores[i].r1.getNome().equals(atual.r2.getNome()) || anteriores[i].r1.getNome().equals(atual.r3.getNome()))) {
                // System.out.println("Dependencia verdadeira Confirmada!!");
                return true;
            }
        }

        return false;
    }

    public void despacharEx() {
        Instrucao[] removidos = new Instrucao[100];
        int c = 0;
        for (int i = 0; i < janela.size(); i++) {
            Instrucao atual = janela.get(i);
            Instrucao[] anteriores = getAnteriores(atual);

            if (dependenciaVerdadeira(atual, anteriores)) {
                atual.ciclosDeStall = 2;
            } else if (dependenciaFalsa(atual, anteriores)) {
                renomear(atual);
            }
            if (despacharEx(janela.get(i))) {
                removidos[c] = janela.get(i);
                c++;
            }
        }
        for (int i = 0; i < c; i++) {
            janela.remove(removidos[i]);
        }
    }

    public boolean despacharEx(Instrucao instr) {
        boolean resposta = false;
        if (instr.ciclosDeStall > 0) {
            System.out.println("Congelando instrucao " + instr.toString());
            System.out.println("Ciclos: " + instr.ciclosDeStall);
            instr.ciclosDeStall--;
        } else {
            System.out.println("CiclosElse: " + instr.ciclosDeStall);
            if (ex.inserirInstrucao(instr)) {
                resposta = true;
            }
        }
        return resposta;
    }

    public void mostrar() {
        for (int i = 0; i < janela.size(); i++) {
            if (janela.get(i) != null) {
                System.out.println(i + " : " + janela.get(i).toString());
            }
        }
    }

    public void clock() {
        this.inserir();
        this.mostrar();
        ex.clock();
        this.despacharEx();
        ex.mostrarEx();

    }

    public String[][] jantoArrayString() {
        String[][] array = new String[tam][1];
        for (int i = 0; i < tam; i++) {
            if (i < janela.size()) {
                array[i][0] = janela.get(i).toString();
            } else {
                array[i][0] = " ";
            }
        }
        return array;
    }

}
