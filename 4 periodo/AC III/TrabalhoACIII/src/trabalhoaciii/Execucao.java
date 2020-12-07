package trabalhoaciii;

import java.util.ArrayList;

/**
 *
 * @author LuizHG
 */
//Memória
public class Execucao {
    public static int quantRealizadas;
    public static int clockExe;
    ArrayList<UnidadeFuncional> unidades;
    ArrayList<String> realizadas;
    JanelaInstrucao janelinha;
    
    
    public Execucao(int q_alu, int q_sw, int q_lw, int q_br, JanelaInstrucao j){
        quantRealizadas = 0;
        clockExe = 0;
        this.janelinha = j;
        unidades = new ArrayList();
        try{
            for(int i = 0; i < q_alu; i++)  unidades.add(new UnidadeFuncional('a'));
            for(int i = 0; i < q_sw; i++)  unidades.add(new UnidadeFuncional('s'));
            for(int i = 0; i < q_lw; i++)  unidades.add(new UnidadeFuncional('l'));
            for(int i = 0; i < q_br; i++)  unidades.add(new UnidadeFuncional('b'));
        }catch(Exception e){
            System.err.println("Erro ao criar alguma porta");
            System.exit(-1);
        }
        
        realizadas = new ArrayList();
    }
    
    public int buscaUnidadeFuncionalDesocupada(char c){
        int und = -1;
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).tipo == c){
                if(unidades.get(i).ocupada == false){
                    und = i;
                    i = unidades.size();
                }
            }
        }
        return und;
    }
    
    public boolean inserirInstrucao(Instrucao i){
        boolean inseriu = false;
        char c = i.instrucao.charAt(0);
        if(c == 'm')
            c = 'a';
        int pos = this.buscaUnidadeFuncionalDesocupada(c);
        if(pos != -1){
            unidades.get(pos).inserirInstrucao(i);
            inseriu = true;
        }
        return inseriu;
    }
    public void mostrarEx(){
        System.out.println("=============== Mostrando Ex ======================");
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).ocupada == true){
                System.out.println(unidades.get(i).tipo + " " + unidades.get(i).i.toString());
            }
            else{
                System.out.println(unidades.get(i).tipo + " Sem Instrução");
            }
        }
        System.out.println("======================FIM Ex ======================");
    }
 
    public String[][] execucaotoArrayString(){
        String[][] array = new String[unidades.size()][1];
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).ocupada == true){
                array[i][0] = (Character.toUpperCase(unidades.get(i).tipo) + "| " + unidades.get(i).i.toString());
            }
            else{
                array[i][0] = (Character.toUpperCase(unidades.get(i).tipo) + "| Sem Instrução");
            }
        }
        return array;
    }
    
    public String[][] executadostoArrayString(){
        if(realizadas.isEmpty()) {
            return new String[Memoria.getCont()][1];
        }
        
        String[][] array = new String[realizadas.size()][1];
        for(int i = 0; i < realizadas.size(); i++){
            array[i][0] = realizadas.get(i);
        }
        
        return array;
    }
    
    public void clock(){
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).ocupada == true){
                unidades.get(i).ciclosRealizados = unidades.get(i).ciclosRealizados + 1;
                if(unidades.get(i).ciclosRealizados == unidades.get(i).i.tempoCiclo){
                    realizadas.add(unidades.get(i).fazerInstrucao());
                }
            }
        }
        
        if(!(Memoria.instrucoesLidas == Memoria.getCont() && janelinha.janela.size() == 0)) {
            clockExe++;
        }        
        System.out.println("clockExe: " + clockExe + "<-----------------------------------------------------");

    }
    
    /*
    public boolean estaExecutando() {
        boolean resposta = false;
    }
    */
    public boolean todasLivres(){
        boolean resposta = true;
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).ocupada == true)
                resposta = false;
            i = unidades.size();
        }
        return resposta;
    }
}

class UnidadeFuncional{
    char tipo;
    boolean ocupada;
    int ciclosRealizados;
    Instrucao i;
    /*
        Tipos de unidades funcional
        alu, sw, lw, br
    */
    public UnidadeFuncional(char tipo) throws Exception{
        tipo = Character.toLowerCase(tipo); 
        if(tipo == 'a' || tipo == 's' || tipo == 'l' || tipo == 'b'){
            this.tipo = tipo;
            this.ocupada = false;
        }
        else{
           throw new Exception("Erro ao criar a Unidade funcional, tipo de unidade invalida");
        }
    }
    
    public void inserirInstrucao(Instrucao i){
        this.ciclosRealizados = 0;
        this.ocupada = true;
        this.i = i;
    }
    
    public String fazerInstrucao(){
        String instrucao = this.i.instrucao.toLowerCase();
        String ret;
        ret = this.i.getInstrucao();
        if(instrucao.equals("add")){i.r1.setDado(i.r2.getDado() + i.r3.getDado());}
        else if(instrucao.equals("sub")){i.r1.setDado(i.r2.getDado() - i.r3.getDado());}
        else if(instrucao.equals("mul")){i.r1.setDado(i.r2.getDado() * i.r3.getDado());}
        else if(instrucao.equals("addi")){i.r1.setDado(i.r2.getDado() + i.numero);}
        else if(instrucao.equals("bne")){/*Nada*/}
        else if(instrucao.equals("beq")){/*Nada*/}
        else if(instrucao.equals("lw")){i.r1.setDado(i.r2.getDado());}
        else if(instrucao.equals("sw")){i.r2.setDado(i.r1.getDado());}
        this.ocupada = false;
        this.ciclosRealizados = 0;
        Execucao.quantRealizadas++;
        //System.out.println("Realizadas: " + Execucao.quantRealizadas);
        Renomear.diminuir(i.r1);
        Renomear.diminuir(i.r2);
        if(!i.r3.getNome().equals("0"))
            Renomear.diminuir(i.r3);
        this.i = null;
        
        return ret;
    }
}
