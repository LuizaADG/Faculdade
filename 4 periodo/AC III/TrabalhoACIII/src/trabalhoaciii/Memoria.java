package trabalhoaciii;

/**
 *
 * @author LuizHG
 */
public class Memoria {
    public static Instrucao[] memoriaPrincipal;
    public static Registrador[] bancoRegistradores;
    private static int cont = 0;
    public static int instrucoesLidas = 0;
    
    public Memoria(){
        this(1000, 32);
    }
    
    public static int getCont(){
        return cont;
    }
    
    public Memoria(int tamMP, int tamBR){
        memoriaPrincipal = new Instrucao[tamMP];
        bancoRegistradores = new Registrador[tamBR];
        
        for(int i = 0; i < tamBR; i++)
            bancoRegistradores[i] = new Registrador("S"+i);
        
    }
    
    public static void inserirInstrucaoMemoria(Instrucao i){
        memoriaPrincipal[cont] = i;
        cont++;
    }
    
    public static void mostrarMemoria(){
        for(int i = 0; i < cont; i++){
            System.out.println(memoriaPrincipal[i].toString());
        }
    }
    
    public static void mostrarRegistradores(){
        for(int i=0; i < 32; i++){
            System.out.println(bancoRegistradores[i].getNome() + "\nDado: " + bancoRegistradores[i].getDado() + 
                    "\n-------------------------");
        }
    }
    
    public static int quantMemoria(){
        return cont;
    }
    
    public static String[][] memoriatoArrayString(){
        String[][] array = new String[cont][1];
        for(int i = 0; i < cont; i++){
            array[i][0] = memoriaPrincipal[i].toString();
            //array[i][1] = memoriaPrincipal[i].toString();
        }
        return array;
    } 
    
}
