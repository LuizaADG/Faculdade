import java.util.Scanner;

public class Teste {
    public static void main(String[] args){
        System.out.println("Testando Árvore - isso AEEEEEEHHH!!!");
        Scanner read = new Scanner(System.in);
        Arvore a1 = new Arvore();
        Arvore a2 = new Arvore();
        int valor;
        for(int i = 0; i < 5; i++){
            System.out.println("Digita um numero rapaizzZX:");
            valor = read.nextInt();
            a1.inserir(valor);
        }
        System.out.println("Arvore 2 agora");
        for(int i = 0; i < 5; i++){
            System.out.println("Digita um numero rapaizzZX:");
            valor = read.nextInt();
            a2.inserir(valor);
        }
        System.out.println("\nArvore 1:");
        a1.mostrar();
        System.out.println("\nArvore 2:");
        a2.mostrar();
        System.out.println("\nArvore Fusão:");
        Arvore a3 = a1.fusao(a2);
        a3.mostrar();
    }
}
class Arvore{
    private No raiz;
    public Arvore(){
        this.raiz = null;
    }
    public No getRaiz(){
        return this.raiz;
    }
    public void inserir(int elemento){
        No tmp = new No(elemento);
        if(raiz == null)
            raiz = tmp;
        else
            raiz = inserir(tmp, raiz);
    }
    public No inserir(No tmp, No pesquisa){
        if(pesquisa == null)
            pesquisa = tmp;
        else if(tmp.elemento > pesquisa.elemento)
            pesquisa.dir = inserir(tmp, pesquisa.dir);
        else if(tmp.elemento < pesquisa.elemento)
            pesquisa.esq = inserir(tmp, pesquisa.esq);
        return pesquisa;
    }
    public boolean pesquisa(int elemento){
        return pesquisa(elemento, raiz);
    }
    public boolean pesquisa(int elemento, No pesquisa){
        if(pesquisa == null)
            return false;
        if(elemento > pesquisa.elemento)
            return pesquisa(elemento, pesquisa.dir);
        if(elemento < pesquisa.elemento)
            return pesquisa(elemento, pesquisa.esq);
        return true;
    }
    public void mostrar(){
        System.out.printf("[");
        mostrar(raiz);
        System.out.printf(" ]");
    }
    public void mostrar(No no){
        if(no == null)
            return;
        mostrar(no.esq);
        System.out.printf(" %d", no.elemento);
        mostrar(no.dir);
    }
    //Tentativa DBZ de fusão!!!!
    public int getMenor(){
        No aux = raiz;
        while(aux.esq != null)
            aux = aux.esq;
        return aux.elemento;
    }
    public int getMaior(){
        No aux = raiz;
        while(aux.dir != null)
            aux = aux.dir;
        return aux.elemento;
    }

    public Arvore fusao(Arvore a2){
        Arvore fusao = new Arvore();
        No aux1 = this.raiz;
        No aux2 = a2.getRaiz();
        insereArvore(aux1, fusao);
        insereArvore(aux2, fusao);
        return fusao;
    }
    public void insereArvore(No no, Arvore recebedora){
        if(no == null)
            return;
        insereArvore(no.esq, recebedora);
        recebedora.inserir( no.elemento);
        insereArvore(no.dir, recebedora);
    }

}

//Inicio do nó
class No{
    No esq;
    No dir;
    int elemento;
    public No(){
        this(0);
    }
    public No(int elemento){
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }
}
