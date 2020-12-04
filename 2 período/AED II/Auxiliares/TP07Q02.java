
import java.io.File;

/**
 * Questao do TP7 - AEDs II - 1o/2017
 */
/**
 * Classe teste
 *
 * @author Alefe Lucas S. Torres
 */
public class TP07Q02 {

    private static final int FLAG = 0;//Flag para parar a leitura.

    private static final String MATRICULA = "573061";

    /**
     * Questão 2 TP7
     * 
     * @param args - strings passadas no terminal
     * @throws java.lang.Exception Caso ocorra tentativa de remocao na pilha
     * vazia
     */
    public static void main(String[] args) throws Exception {
        MyIO.setCharset("ISO-8859-1");
        int linha = MyIO.readInt();
        ArvArv arvarv = new ArvArv();
        while (linha != FLAG) {
            Municipio municipio = Municipio.ler(linha);
            arvarv.inserir(municipio);

            linha = MyIO.readInt();
        }
        operacoes(arvarv);

        File arquivo = new File("./" + MATRICULA + "_arvoreArvore.txt.");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        Arq.openWrite(arquivo.getName());
        double start = System.nanoTime();

        pesquisa(arvarv);

        double elapsed = System.nanoTime() - start;
        elapsed /= 1000000000;
        Arq.print(String.format("%s\t%.6f\t%d\n", MATRICULA, elapsed, arvarv.comparacoes));
        Arq.close();
    }

    /**
     * Le os IDs e os pesquisa na arvore
     *
     * @param arvarv - Arvore de municipios
     */
    public static void pesquisa(ArvArv arvarv) {
        int id = MyIO.readInt();
        while (id != -1) {
            MyIO.println(arvarv.pesquisa(id) ? "SIM" : "NAO");
            id = MyIO.readInt();
        }
    }

    /**
     * Le os comandos e executa as operacoes de insercao e remocao
     *
     * @param arvarv - a arvore de municipios
     * @throws Exception Caso ocorra tentativa de remocao na pilha vazia
     */
    public static void operacoes(ArvArv arvarv) throws Exception {
        int comandos = MyIO.readInt();
        for (int i = 0; i < comandos; i++) {
            String comando = MyIO.readString();
            execComando(arvarv, comando);
        }
    }

    /**
     * Executa os comandos de insercao e remocao
     *
     * @param comando - o comando a ser executado
     * @param arvarv - a arvore de municipios
     * @throws java.lang.Exception Caso ocorra tentativa de remocao na arvore
     * vazia
     */
    public static void execComando(ArvArv arvarv, String comando) throws Exception {
        if (comando.equals("I")) {
            arvarv.inserir(Municipio.ler(MyIO.readInt()));
        } else if (comando.equals("R")) {
            int id = MyIO.readInt();
            Municipio r = arvarv.remover(id);
            // if(r != null) MyIO.println("(R) " + r.getNome());
        } else {
            throw new Exception("Comando inválido");
        }
    }

}

/**
 * Classe Municipio (Entidade), com os atributos lidos dos arquivos do diretorio
 * /tmp/
 *
 * @author Alefe Lucas S. Torres
 */
class Municipio {

    private static final int COUNT = 5570; //Numero total de municipios nos arquivos
    private static Municipio[] municipios; //Arranjo para guardar TODOS os municipios dos arquivos

    private static final String CHARSET = "ISO-8859-1"; //Encoding dos arquivos
    private static final String DIR = "/tmp/"; //diretorio dos arquivos

    //Arquivos
    private static final String VARIAVEIS_EXTERNAS = "variaveisexternas.txt";
    private static final String RECURSOS_HUMANOS = "recursoshumanos.txt";
    private static final String PLANEJAMENTO_URBANO = "planejamentourbano.txt";
    private static final String GESTAO_AMBIENTAL = "gestaoambiental.txt";
    private static final String RECURSOS_PARA_GESTAO = "recursosparagestao.txt";
    private static final String ARTICULACAO_INTERINSTITUCIONAL = "articulacaoointerinstitucional.txt";

    //variaveisexternas.txt
    private int id; //A1
    private String regiao; //A199
    private int codigoUF; //A200
    private String UF; //A201
    private String nome; //A202
    private int populacao; //A204

    //recursoshumanos.txt
    private int numeroFuncionarios; //A2
    private int numeroComissionados; //A5

    //planejamentourbano.txt
    private String escolaridade; //A16
    private int atualizacaoPlano; //A19

    //gestaoambiental.txt
    private String estagio; //A143

    //recursosparagestao.txt
    private int atualizacaoCadastro; //A63

    //articulacaoointerinstitucional.txt
    private boolean consorcio; //A152

    /**
     * Construtor padrao
     */
    public Municipio() {
    }

    /**
     * Construtor informando os campos
     *
     * @param id - A1
     * @param regiao - A199
     * @param codigoUF - A200
     * @param UF - A201
     * @param nome - A202
     * @param populacao - A204
     * @param numeroFuncionarios - A2
     * @param numeroComissionados - A5
     * @param escolaridade - A16
     * @param atualizacaoPlano - A19
     * @param estagio - A143
     * @param atualizacaoCadastro - A63
     * @param consorcio - A152
     */
    public Municipio(int id, String regiao, int codigoUF, String UF, String nome, int populacao, int numeroFuncionarios, int numeroComissionados, String escolaridade, int atualizacaoPlano, String estagio, int atualizacaoCadastro, boolean consorcio) {
        this.id = id;
        this.regiao = regiao;
        this.codigoUF = codigoUF;
        this.UF = UF;
        this.nome = nome;
        this.populacao = populacao;
        this.numeroFuncionarios = numeroFuncionarios;
        this.numeroComissionados = numeroComissionados;
        this.escolaridade = escolaridade;
        this.atualizacaoPlano = atualizacaoPlano;
        this.estagio = estagio;
        this.atualizacaoCadastro = atualizacaoCadastro;
        this.consorcio = consorcio;
    }

    /**
     * Tenta converter uma String para inteiro, caso falhe, assume o valor zero.
     * Usado para leitura de campos dos arquivos onde se espera um valor inteiro
     * mas nao ha.
     *
     * @param str A String com o campo lido
     * @return O valor em inteiro
     */
    public static int parseInt(String str) {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            value = 0;
        }
        return value;
    }

    /**
     * Codigo do municipio - A1
     *
     * @return o ID do municipio.
     */
    public int getId() {
        return id;
    }

    /**
     * Codigo do municipio - A1
     *
     * @param id - o ID do municipio
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Nome do muncipio - A200
     *
     * @return o nome do municipio.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Nome do muncipio - A200
     *
     * @param nome - o nome do municipio.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sigla da Unidade da Federacao - A201
     *
     * @return o UF do municipio.
     */
    public String getUF() {
        return UF;
    }

    /**
     * Sigla da Unidade da Federacao - A201
     *
     * @param UF - o UF do municipio.
     */
    public void setUF(String UF) {
        this.UF = UF;
    }

    /**
     * Codigo da Unidade da Federacao - A200
     *
     * @return o codigo UF do municipio.
     */
    public int getCodigoUF() {
        return codigoUF;
    }

    /**
     * Codigo da Unidade da Federacao - A200
     *
     * @param codigoUF - o codigo UF do municipio.
     */
    public void setCodigoUF(int codigoUF) {
        this.codigoUF = codigoUF;
    }

    /**
     * Populacao estimada de 2015 - A204
     *
     * @return a populacao do municipio
     */
    public int getPopulacao() {
        return populacao;
    }

    /**
     * Populacao estimada de 2015 - A204
     *
     * @param populacao - a populacao do municipio
     */
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    /**
     * Total de funcionarios ativos da administracao direta
     *
     * @return o numero de funcionarios
     */
    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    /**
     * Total de funcionarios ativos da administracao direta
     *
     * @param numeroFuncionarios - o numero de funcionarios
     */
    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    /**
     * Escolaridade do gestor - A16
     *
     * @return a escolaridade
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * Escolaridade do gestor - A16
     *
     * @param escolaridade
     */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * Estagio atual da gestao ambiental - A143
     *
     * @return estagio
     */
    public String getEstagio() {
        return estagio;
    }

    /**
     * Estagio atual da gestao ambiental - A143
     *
     * @param estagio
     */
    public void setEstagio(String estagio) {
        this.estagio = estagio;
    }

    /**
     * Ultimo ano de atualizacao completa do cadastro do IPTU E ISS - A63
     *
     * @return o ano da atualizacao
     */
    public int getAtualizacaoCadastro() {
        return atualizacaoCadastro;
    }

    /**
     * Ultimo ano de atualizacao completa do cadastro do IPTU E ISS - A63
     *
     * @param atualizacaoCadastro - o ano da atualizacao
     */
    public void setAtualizacaoCadastro(int atualizacaoCadastro) {
        this.atualizacaoCadastro = atualizacaoCadastro;
    }

    /**
     * Se o municipio faz parte de consorcio publico na area de educacao
     * intermunicipal
     *
     * @return true ou false
     */
    public boolean isConsorcio() {
        return consorcio;
    }

    /**
     * Se o municipio faz parte de consorcio publico na area de educacao
     * intermunicipal
     *
     * @param consorcio
     */
    public void setConsorcio(boolean consorcio) {
        this.consorcio = consorcio;
    }

    /**
     * Total de funcionarios ativos da administracao direta - Somente
     * comissionados - A5
     *
     * @return total de funcionarios
     */
    public int getNumeroComissionados() {
        return numeroComissionados;
    }

    /**
     * Total de funcionarios ativos da administracao direta - Somente
     * comissionados - A5
     *
     * @param numeroComissionados - total de funcionarios
     */
    public void setNumeroComissionados(int numeroComissionados) {
        this.numeroComissionados = numeroComissionados;
    }

    /**
     * Ano da ultima atualizacao do plano diretor - A19
     *
     * @return o ano
     */
    public int getAtualizacaoPlano() {
        return atualizacaoPlano;
    }

    /**
     * Ano da ultima atualizacao do plano diretor - A19
     *
     * @param atualizacaoPlano - o ano
     */
    public void setAtualizacaoPlano(int atualizacaoPlano) {
        this.atualizacaoPlano = atualizacaoPlano;
    }

    /**
     * Regiao do municipio - A199
     *
     * @return regiao
     */
    public String getRegiao() {
        return regiao;
    }

    /**
     * Regiao do municipio - A199
     *
     * @param regiao
     */
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    /**
     * Clona o objeto corrente, campo a campo.
     *
     * @return O objeto clonado
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Exibe as informacoes do municipio, isto e, os atributos do objeto
     * corrente.
     *
     * @see toString()
     */
    public void imprimir() {
        MyIO.println(this.toString());
    }

    /**
     * Sobreescreve o metodo toString() para ser utilizado ao imprimir os dados
     * deste objeto.
     *
     * @return String com as informacoes dos atributos.
     */
    @Override
    public String toString() {
        return id + " "
                + nome + " "
                + UF + " "
                + codigoUF + " "
                + populacao + " "
                + numeroFuncionarios + " "
                + numeroComissionados + " "
                + escolaridade + " "
                + estagio + " "
                + atualizacaoPlano + " "
                + regiao + " "
                + atualizacaoCadastro + " "
                + consorcio;
    }

    /**
     * Faz uma leitura completa dos arquivos com instanciacao de todos os
     * objetos Municipio, armazena no arranjo "municipios", e entao retorna o
     * objeto Municipio da linha especificada no parametro. Caso a leitura dos
     * arquivos ja tiver sido feita, ela nao e refeita, apenas retorna a
     * instancia pedida no parametro.
     *
     * @param linha - A linha onde se encontra os dados de um municipio nos
     * arquivos.
     * @return O objeto Municipio da linha respectiva.
     */
    public static Municipio ler(int linha) {

        if (municipios == null) {
            municipios = new Municipio[COUNT];
            Arq.openRead(DIR + VARIAVEIS_EXTERNAS, CHARSET);
            Arq.readLine();

            for (int i = 0; i < municipios.length && Arq.hasNext(); i++) {
                municipios[i] = new Municipio();
                int id = Arq.readInt();
                String[] campos = Arq.readLine().split("\t");

                municipios[i].setId(id);

                municipios[i].setRegiao(campos[1]);
                municipios[i].setCodigoUF(parseInt(campos[2]));
                municipios[i].setUF(campos[3]);
                municipios[i].setNome(campos[4]);
                municipios[i].setPopulacao(parseInt(campos[6]));

            }

            Arq.openRead(DIR + RECURSOS_HUMANOS, CHARSET);
            Arq.readLine();

            for (int i = 0; i < municipios.length && Arq.hasNext(); i++) {

                String[] campos = Arq.readLine().split("\t");

                municipios[i].setNumeroFuncionarios(parseInt(campos[4]));
                municipios[i].setNumeroComissionados(parseInt(campos[7]));
            }

            Arq.openRead(DIR + PLANEJAMENTO_URBANO, CHARSET);
            Arq.readLine();

            for (int i = 0; i < municipios.length && Arq.hasNext(); i++) {
                String[] campos = Arq.readLine().split("\t");

                municipios[i].setEscolaridade(campos[5]);
                municipios[i].setAtualizacaoPlano(parseInt(campos[8]));
            }

            Arq.openRead(DIR + GESTAO_AMBIENTAL, CHARSET);
            Arq.readLine();

            for (int i = 0; i < municipios.length && Arq.hasNext(); i++) {
                String[] campos = Arq.readLine().split("\t");
                municipios[i].setEstagio(campos[7]);
            }

            Arq.openRead(DIR + RECURSOS_PARA_GESTAO, CHARSET);
            Arq.readLine();

            for (int i = 0; i < municipios.length && Arq.hasNext(); i++) {
                String[] campos = Arq.readLine().split("\t");

                municipios[i].setAtualizacaoCadastro(parseInt(campos[6]));
            }

            Arq.openRead(DIR + ARTICULACAO_INTERINSTITUCIONAL, CHARSET);
            Arq.readLine();

            for (int i = 0; i < municipios.length && Arq.hasNext(); i++) {
                String[] campos = Arq.readLine().split("\t");
                municipios[i].setConsorcio(campos[5].equals("Sim"));
            }
        }

        return municipios[linha - 1];

    }

}

/**
 * No de arvore de arvore contendo codigo uf
 *
 * @author Alefe Lucas S. Torres
 */
class No1 {

    public No1 esq;
    public No1 dir;
    public No2 outra;
    public int uf;

    /**
     * Construtor que recebe uf
     *
     * @param uf - elemento
     */
    public No1(int uf) {
        this.uf = uf;
    }
}

/**
 * No de arvore de arvore contendo Municipio
 *
 * @author Alefe Lucas S. Torres
 */
class No2 {

    public No2 esq;
    public No2 dir;
    public Municipio municipio;

    /**
     * Construtor que recebe municipio
     *
     * @param municipio - elemento
     */
    public No2(Municipio municipio) {
        this.municipio = municipio;
    }
}

/**
 * Arvore (UF) de Arvore de Municipio
 *
 * @author Alefe Lucas S. Torres
 */
class ArvArv {

    /**
     * Numero de comparacoes para as questoes do TP7
     */
    public int comparacoes;

    /**
     * Less than - verifica se o valor A e menor que o valor B. Usado para
     * incrementar o numero de comparacoes no TP7
     *
     * @param a - valor A
     * @param b - valor B
     * @return true se A < B, false caso contrario
     */
    private boolean lt(double a, double b) {
        this.comparacoes++;
        return a < b;
    }

    /**
     * Greater than - verifica se o valor A e maior que o valor B. Usado para
     * incrementar o numero de comparacoes no TP7
     *
     * @param a - valor A
     * @param b - valor B
     * @return true se A > B, false caso contrario
     */
    private boolean gt(double a, double b) {
        this.comparacoes++;
        return a > b;
    }

    /**
     * Less or equal than - verifica se o valor A e menor ou igual ao o valor B.
     * Usado para incrementar o numero de comparacoes no TP7
     *
     * @param a - valor A
     * @param b - valor B
     * @return true se A <= B, false caso contrario
     */
    private boolean le(double a, double b) {
        this.comparacoes++;
        return a <= b;
    }

    /**
     * Greater or equal than - verifica se o valor A e maior ou igual ao o valor
     * B. Usado para incrementar o numero de comparacoes no TP7
     *
     * @param a - valor A
     * @param b - valor B
     * @return true se A >= B, false caso contrario
     */
    private boolean ge(double a, double b) {
        this.comparacoes++;
        return a >= b;
    }

    /**
     * Equal - verifica se o valor A e igual ao valor B. Usado para incrementar
     * o numero de comparacoes no TP7
     *
     * @param a - valor A
     * @param b - valor B
     * @return true se A == B, false caso contrario
     */
    private boolean eq(double a, double b) {
        this.comparacoes++;
        return a == b;
    }

    private No1 raiz;

    /**
     * Construtor - já insere os codigos UF na ordem dada
     */
    public ArvArv() {
        int[] ufs = {
            29, 21, 50, 14, 25, 35, 52, 12, 16, 23,
            27, 32, 42, 51, 53, 11, 13, 15, 17, 22,
            24, 26, 28, 31, 33, 41, 43};

        for (int uf : ufs) {
            raiz = inserir(uf, raiz);
        }
    }

    /**
     * Insere um codigo UF
     *
     * @param uf - o codigo a ser inserido
     * @param i - No para uso na recursividade
     * @return No para uso na recursividade
     */
    private No1 inserir(int uf, No1 i) {
        if (i == null) {
            i = new No1(uf);
        } else if (uf < i.uf) {
            i.esq = inserir(uf, i.esq);
        } else if (uf > i.uf) {
            i.dir = inserir(uf, i.dir);
        } else {
            throw new ArrayIndexOutOfBoundsException("Erro");
        }
        return i;
    }

    /**
     * Pesquisa um No por UF e retorna-o
     *
     * @param uf - a chave da pesquisa
     * @return O no pesquisado
     */
    private No1 pesquisarUf(int uf) {
        No1 i = raiz;
        while (i != null && i.uf != uf) {
            if (uf < i.uf) {
                i = i.esq;
            } else {
                i = i.dir;
            }
        }
        return i;
    }

    /**
     * Insere um municipio na estrutura
     *
     * @param municipio - o municipio a ser inserido
     */
    public void inserir(Municipio municipio) {
        No1 noUF = pesquisarUf(municipio.getCodigoUF());
        noUF.outra = inserir(municipio, noUF.outra);
    }

    /**
     * Insere um municipio na estrutura
     *
     * @param municipio - o municipio a ser inserido
     * @param i - No para uso na recursividade
     * @return No para uso na recursividade
     */
    private No2 inserir(Municipio municipio, No2 i) {
        if (i == null) {
            i = new No2(municipio);
        } else if (municipio.getId() < i.municipio.getId()) {
            i.esq = inserir(municipio, i.esq);
        } else if (municipio.getId() > i.municipio.getId()) {
            i.dir = inserir(municipio, i.dir);
        }
        return i;
    }

    /**
     * Pesquisa um municipio por ID
     *
     * @param id - a chave da pesquisa
     * @return true se encontrou, false caso contrario
     */
    public boolean pesquisa(int id) {
        System.out.print("raiz ");
        return pesquisa(id, raiz);
    }

    /**
     * Pesquisa um municipio por ID
     *
     * @param id - a chave da pesquisa
     * @param i - No para uso na recursividade
     * @return true se encontrou, false caso contrario
     */
    private boolean pesquisa(int id, No1 i) {
        boolean achou = false;
        if (i != null) {
            System.out.print("esq ");
            achou = pesquisa(id, i.esq);
            if (!achou) {
                System.out.print("raiz ");
                achou = pesquisa(id, i.outra);
                if (!achou) {
                    System.out.print("dir ");
                    achou = pesquisa(id, i.dir);
                }
            }
        }
        return achou;

    }

    /**
     * Pesquisa um municipio por ID
     *
     * @param id - a chave da pesquisa
     * @param i - No para uso na recursividade
     * @return true se encontrou, false caso contrario
     */
    private boolean pesquisa(int id, No2 i) {
        boolean encontrou;
        if (i == null) {
            encontrou = false;
        } else if (gt(id, i.municipio.getId())) {
            System.out.print("dir ");
            encontrou = pesquisa(id, i.dir);
        } else if (lt(id, i.municipio.getId())) {
            System.out.print("esq ");
            encontrou = pesquisa(id, i.esq);
        } else {
            encontrou = true;
        }
        return encontrou;
    }

    /**
     * Remove um municipio da estrutura
     *
     * @param id - a chave de pesquisa
     * @return O municipio removido
     */
    public Municipio remover(int id) {
        return remover(id, raiz);
    }

    /**
     * Remove um municipio da estrutura
     *
     * @param id - a chave de pesquisa
     * @param i - No para uso na recursividade
     * @return O municipio removido
     */
    private Municipio remover(int id, No1 i) {
        Municipio municipio;
        if (i == null) {
            municipio = null;
        } else {
            municipio = remover(id, i.outra);
            if (municipio == null) {
                municipio = remover(id, i.esq);
                if (municipio == null) {
                    municipio = remover(id, i.dir);
                }
            }

        }
        return municipio;
    }

    /**
     * Remove um elemento iterativamente da subarvore
     *
     * @param id - a chave de pesquisa
     * @return O municipio removido
     */
    private Municipio remover(int id, No2 raiz) {
        Municipio resp = null;
        No2 i = raiz;
        No2 pai = null;
        while (i != null) {
            if (i.municipio.getId() < id) {
                pai = i;
                i = i.dir;
            } else if (i.municipio.getId() > id) {
                pai = i;
                i = i.esq;
            } else {
                resp = i.municipio;
                if (i.dir == null) {
                    if (pai.dir == i) {
                        pai.dir = i.esq;
                    } else {
                        pai.esq = i.esq;
                    }
                } else if (i.esq == null) {
                    if (pai.dir == i) {
                        pai.dir = i.dir;
                    } else {
                        pai.esq = i.dir;
                    }
                } else {
                    No2 rev;
                    for (rev = i.esq; rev.dir.dir != null; rev = rev.dir);
                    i.municipio = rev.dir.municipio;
                    rev.dir = rev.dir.esq;
                }
                i = null;
            }
        }
        return resp;
    }

}
