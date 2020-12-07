package trabalhoaciii;

/**
 *
 * @author LuizHG
 */
public class Registrador {
    private String nome;
    private int dado;
    /**
     * Classe registrador, o que esta classe tem.... Nome e Dado
     * Apenas armazena o dado.
     * @param nome 
     */
    
    public Registrador(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }
}
