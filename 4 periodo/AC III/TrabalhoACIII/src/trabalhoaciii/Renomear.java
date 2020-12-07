package trabalhoaciii;

/**
 *
 * @author lu1zh
 */
public class Renomear {
    static int[] array;
    Renomear() {
         array = new int[32];
        for (int i = 0; i < 32; i++) {
            array[i] = 0;
        }
    }
    
    public static void incrementar(Registrador r){
        int pos = Integer.parseInt(r.getNome().replace("S", ""));
        array[pos]++;
        
    }
    public static void diminuir(Registrador r){
        int pos = Integer.parseInt(r.getNome().replace("S", ""));
        if(array[pos] > 0){
            array[pos] = 0;
        }
    }
    
    public static int getCont(Registrador r){
        int pos = Integer.parseInt(r.getNome().replace("S", ""));
        return array[pos];
    }
    
    public static int getPos(Registrador r){
        return Integer.parseInt(r.getNome().replace("S", ""));
    }
}

