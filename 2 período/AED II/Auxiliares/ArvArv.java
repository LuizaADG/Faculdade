/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1044297
 */
public class ArvArv {

    No1 raiz;

    public ArvArv() {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char c : s.toCharArray()) {
            raiz = inserir(c, raiz);
        }
    }

    private No1 inserir(char c, No1 i) {
        if (i == null) {
            i = new No1(c);
        } else if (c < i.primeiraLetra) {
            i.esq = inserir(c, i.esq);
        } else if (c > i.primeiraLetra) {
            i.dir = inserir(c, i.dir);
        } else {
            throw new RuntimeException("Repetido");
        }

        return i;
    }

    public void inserir(String str) {
        No1 no = pesquisar(str.charAt(0));
        no.outra = inserir(str, no.outra);
    }

    //onde vou inserir
    public No1 pesquisar(char chave) {
        No1 no = raiz;
        while (no.primeiraLetra != chave) {
            if (chave < no.primeiraLetra) {
                no = no.esq;
            } else {
                no = no.dir;
            }
        }
        return no;
    }

    private No2 inserir(String str, No2 i) {
        if (i == null) {
            i = new No2(str);
        } else if (str.compareTo(i.elemento) < 0) {
            i.esq = inserir(str, i.esq);
        } else if (str.compareTo(i.elemento) > 0) {
            i.dir = inserir(str, i.dir);
        } else {
            throw new RuntimeException("Repetido");
        }

        return i;
    }

    public boolean pesquisar(String str) {
        return pesquisar(str, raiz);
    }

    private boolean pesquisar(String str, No1 i) {
        char c = str.charAt(0);
        if (i == null) {
            return false;
        } else if (i.primeiraLetra == c) {
            return pesquisar2(str, i.outra);
        } else if (c < i.primeiraLetra) {
            return pesquisar(str, i.esq);
        } else {
            return pesquisar(str, i.dir);
        }
    }

    private boolean pesquisar2(String str, No2 i) {
        if (i == null) {
            return false;
        } else if (i.elemento.equals(str)) {
            return true;
        } else if (str.compareTo(i.elemento) < 0) {
            return pesquisar2(str, i.esq);
        } else {
            return pesquisar2(str, i.dir);
        }
    }

}

class No1 {

    No1 esq;
    No1 dir;
    char primeiraLetra;
    No2 outra;

    public No1(char primeiraLetra) {
        this.primeiraLetra = primeiraLetra;
    }

}

class No2 {

    No2 esq;
    No2 dir;
    String elemento;

    public No2(String elemento) {
        this.elemento = elemento;
    }

}
