/**
* Trabalho de compiladores - LC
* Arquivo contendo classes Simbolo, TabelaSimbolos, Util, AnalisadorLexico e AnalisadorSintatico
* Professor: Alexei Machado
*
* @author Jorge Luiz
* @author Luiza Avila
* @author Stefany Gaspar
*/

import java.util.HashMap;

import javax.sound.midi.SysexMessage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

//Classe referente ao simbolo
class Simbolo{

    public byte token;
    public String lexema;
    public byte tipo;
    public int tamanho;
    public byte classe;

    public static final byte semClasse = 0;
    public static final byte classeVAR = 1;
    public static final byte classeCONST = 2;

    public static final byte semTipo = 0;
    public static final byte tipoInteiro = 1;
    public static final byte tipoCaractere = 2;

    /**
     * Metodo construtor
     */
    public Simbolo(){
    }

    /**
     * Metodo construtor
     */
    public Simbolo(byte token, String lexema){
        this.token = token;
        this.lexema = lexema;
        this.tipo = 0;
        this.classe = 0;
    }

    /**
      * Metodo construtor simbolos
      */
      public Simbolo(byte token, String lexema, byte tipo) {
          this.token = token;
          this.lexema = lexema;
          this.tipo = tipo;
      }

    /**
     * Metodo construtor simbolos
     */
    public Simbolo(byte token, String lexema, byte tipo, int tamanho) {
        this.token = token;
        this.lexema = lexema;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.classe = 0;
    }
}

//Criacao de tabela de simbolos
class TabelaSimbolos{
    public HashMap<String, Simbolo> tabela = new HashMap<String, Simbolo>();

    public final static byte identificador = 0;

    public final static byte CONST = 1;
    public final static byte VAR = 2;
    public final static byte INTEGER = 3;
    public final static byte CHAR = 4;
    public final static byte FOR = 5;
    public final static byte IF = 6;
    public final static byte ELSE = 7;
    public final static byte AND = 8;
    public final static byte OR = 9;
    public final static byte NOT = 10;
    public final static byte IGUAL = 11;
    public final static byte TO = 12;
    public final static byte PARENTESES_ABERTO = 13;
    public final static byte PARENTESES_FECHADO = 14;
    public final static byte MENOR = 15;
    public final static byte MAIOR = 16;
    public final static byte DIFERENTE = 17;
    public final static byte MAIOR_IGUAL = 18;
    public final static byte MENOR_IGUAL = 19;
    public final static byte VIRGULA = 20;
    public final static byte MAIS = 21;
    public final static byte MENOS = 22;
    public final static byte ASTERISCO = 23;
    public final static byte BARRA = 24;
    public final static byte PONTO_VIRGULA = 25;
    public final static byte CHAVES_FECHADO = 26;
    public final static byte CHAVES_ABERTO = 27;
    public final static byte THEN = 28;
    public final static byte READLN = 29;
    public final static byte STEP = 30;
    public final static byte WRITE = 31;
    public final static byte WRITELN = 32;
    public final static byte PORCENTAGEM = 33;
    public final static byte COLCHETE_ABERTO = 34;
    public final static byte COLCHETE_FECHADO = 35;
    public final static byte DO = 36;
    public final static byte CIFRAO = 37;
    public final static byte constante = 38;

    /**
     * Metodo construtor da tabela de simbolos
     */
    public TabelaSimbolos(){
        tabela.clear();
        tabela.put("id", new Simbolo(identificador, "id"));
        tabela.put("var", new Simbolo(VAR, "var"));
        tabela.put("integer", new Simbolo(INTEGER, "integer"));
        tabela.put("char", new Simbolo(CHAR, "char"));
        tabela.put("for", new Simbolo(FOR, "for"));
        tabela.put("if", new Simbolo(IF, "if"));
        tabela.put("else", new Simbolo(ELSE, "else"));

        tabela.put("and", new Simbolo(AND, "and"));
        tabela.put("or", new Simbolo(OR, "or"));
        tabela.put("not", new Simbolo(NOT, "not"));
        tabela.put("to", new Simbolo(TO, "to"));
        tabela.put("<>", new Simbolo(DIFERENTE, "<>"));
        tabela.put("=", new Simbolo(IGUAL, "="));
        tabela.put("<=", new Simbolo(MENOR_IGUAL, "<="));

        tabela.put(">=", new Simbolo(MAIOR_IGUAL, ">="));
        tabela.put(">", new Simbolo(MAIOR, ">"));
        tabela.put("<", new Simbolo(MENOR, "<"));
        tabela.put("(", new Simbolo(PARENTESES_ABERTO, "("));
        tabela.put(")", new Simbolo(PARENTESES_FECHADO, ")"));
        tabela.put(",", new Simbolo(VIRGULA, ","));
        tabela.put("+", new Simbolo(MAIS, "+"));

        tabela.put( "-", new Simbolo(MENOS, "-"));
        tabela.put("*", new Simbolo(ASTERISCO, "*"));
        tabela.put( "/", new Simbolo(BARRA, "/"));
        tabela.put(";", new Simbolo(PONTO_VIRGULA, ";"));
        tabela.put( "{", new Simbolo(CHAVES_ABERTO, "{"));
        tabela.put("}", new Simbolo(CHAVES_FECHADO, "}"));
        tabela.put("then", new Simbolo(THEN, "then"));

        tabela.put("readln", new Simbolo(READLN, "readln"));
        tabela.put("step", new Simbolo(STEP, "step"));
        tabela.put("write", new Simbolo(WRITE, "write"));
        tabela.put("writeln", new Simbolo(WRITELN, "writeln"));

        tabela.put("%", new Simbolo(PORCENTAGEM, "%"));
        tabela.put("[", new Simbolo(COLCHETE_ABERTO, "["));
        tabela.put("]", new Simbolo(COLCHETE_FECHADO, "]"));
        tabela.put("do", new Simbolo(DO, "do"));
        tabela.put("const", new Simbolo(CONST, "const"));
        tabela.put("$", new Simbolo(CIFRAO, "cifrao"));
    }

    /**
     * Metodo para buscar o lexema na tabela
     * @param lexema String lexema
     * @return Simbolo
     */
    public Simbolo BuscarLexema(String lexema) {
        return tabela.get(lexema.toLowerCase());
    }

    public void PrintTabelaCerta() {
        int i = 0;
        for (String lexema : tabela.keySet()) {
            if(tabela.get(lexema.toLowerCase()).token == 0 || tabela.get(lexema.toLowerCase()).token == 37)
            System.out.println("Token: " + tabela.get(lexema.toLowerCase()).token + " Lexema: " + tabela.get(lexema.toLowerCase()).lexema + " Tamanho: " + tabela.get(lexema.toLowerCase()).tamanho + " Tipo: " + tabela.get(lexema.toLowerCase()).tipo);
            i++;
        }
    }
    /**
     * Metodo para inserir um identificador na tabela
     * @param lexema String lexema
     * @return Simbolo simbolo adicionado
     */
    public Simbolo InserirIdentificador(String lexema) {
        Simbolo simbolo = new Simbolo (identificador,lexema.toLowerCase());
        tabela.put(lexema.toLowerCase(),simbolo);
        return simbolo;
    }

    /**
     * Metodo para inserir um simbolo na tabela
     * @param Simbolo Simbolo novo
     * @return Simbolo simbolo adicionado
     */
    public Simbolo InserirSimbolo(Simbolo novo) {
        tabela.put(novo.lexema.toLowerCase(),novo);
        return novo;
    }

    public Simbolo inserir_constante(String lexema) {
        Simbolo simbolo = new Simbolo (constante,lexema);
        tabela.put(lexema,simbolo);
        return simbolo;
    }
}

class Util{

    public static char sublinhado = '_';
    public static char pontoFinal = '.';
    public static char virgula = ',';
    public static char pontoEVirgula = ';';
    public static char eComercial = '&';
    public static char doisPontos = ':';
    public static char abreParenteses = '(';
    public static char fechaParenteses = ')';
    public static char abreColchetes = '[';
    public static char fechaColchetes = ']';
    public static char abreChaves = '{';
    public static char fechaChaves = '}';
    public static char mais = '+';
    public static char menos = '-';
    public static char aspas = '\"';
    public static char apostofro = '\'';
    public static char barra = '/';
    public static char porcentagem = '%';
    public static char circunflexo = '^';
    public static char arroba = '@';
    public static char esclamacao = '!';
    public static char interrogacao = '?';
    public static char menor = '<';
    public static char maior = '>';
    public static char igual = '=';
    public static char asterisco = '*';

    public static char tab = 9;
    public static char barraN = 10;
    public static char novalinha = 11;
    public static char cursorInicio = 13;
    public static char fimDeArquivo = 65535;
    public static char espaco = 32;
    public static int tamanhoMaxVetor = 32768;

    /**
     * Metodo para verificar se eh letra
     * @param caracter caracter que sera avaliado
     * @return boolean
     */
    public static boolean VerificarLetra(char caracter){
        return (caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z');
    }

    /**
     * Metodo para verificar se caracter eh digito
     * @param caracter caracter que sera avaliado
     * @return boolean
     */
    public static boolean VerificarDigito(char caracter){
        return caracter >= '0' && caracter <= '9';
    }

    /**
     * Metodo para verificar se eh hexadecimal ou nao
     * @param c caracter que sera avaliado
     * @return boolean
     */
    public static boolean VerificarHexadecimal(char caracter) {
        return caracter >= 'A' && caracter <= 'F';
    }

    /**
     * Metodo para verificar se eh caracter especial
     * @param caracter caracter que sera avaliado
     * @return boolean
     */
    public static boolean VerificarCaracterEspecial(char caracter) {
        return caracter == sublinhado || caracter == pontoFinal || caracter == virgula || caracter == pontoEVirgula || caracter == eComercial ||
        caracter == doisPontos || caracter == abreParenteses || caracter == fechaParenteses || caracter == abreColchetes || caracter == fechaColchetes ||
        caracter == abreChaves || caracter == fechaChaves || caracter == mais || caracter == menor || caracter == aspas || caracter == apostofro ||
        caracter == barra || caracter == porcentagem || caracter == circunflexo || caracter == arroba || caracter == esclamacao || caracter == interrogacao ||
        caracter == menor || caracter == maior || caracter == igual || caracter == asterisco || caracter == menos || caracter == espaco;
    }

    /**
     * Metodo para verificar se eh caracter especial e token
     * @param c caracter que sera avaliado
     * @return boolean
     */
    public static boolean VerificarCaracterEspecialEToken(char caracter) {
        return caracter == sublinhado || caracter == pontoFinal || caracter == virgula || caracter == pontoEVirgula ||
        caracter == abreParenteses || caracter == fechaParenteses || caracter == abreColchetes || caracter == fechaColchetes ||
        caracter == abreChaves || caracter == fechaChaves || caracter == mais || caracter == menor || caracter == aspas || caracter == apostofro ||
        caracter == barra || caracter == porcentagem || caracter == menor || caracter == maior ||
        caracter == igual || caracter == asterisco || caracter == menos;
    }

    /**
     * Metodo para verificar se eh quebra de linhas
     * @param caracter caracter que sera avaliado
     * @return boolean
     */
    public static boolean VerificarQuebraDeLinha(char caracter) {
        return caracter == barraN || caracter == novalinha || caracter == cursorInicio || caracter == espaco || caracter =='\t';
    }

    /**
     * Metodo para verificar se eh caracter valido
     * @param caracter caracter que sera avaliado
     * @return boolean
     */
    public static boolean VerificarCaracterValido(char caracter) {
        return ( VerificarLetra(caracter) || VerificarDigito(caracter) || VerificarCaracterEspecial(caracter));
    }

}

/**
* Trabalho de compiladores - Analisador Lexico
* Professor: Alexei Machado
*
* @author Jorge Luiz
* @author Luiza Avila
* @author Stefany Gaspar
*
*Classe para formar Lexema
*
*/

//Classe que le um arquivo e pega caracter por caracter para formar o lexema
class AnalisadorLexico{

    public BufferedReader codigo;
    public TabelaSimbolos tabelaSimbolos;
    public String lexema;
    public String tipoConst;
    public char ultimaLetra;
    public char letraAtual;
    public int linha;
    public boolean errorCompilacao;
    public boolean devolve;
    public boolean fimDeArquivo;

    public String cod = "";
    /**
     * Metodo construtor analisador lexico
     * @param bufferedReader arquivo que sera lido
     * @param tabelaSimbolos tabela de simbolos
     */
    public AnalisadorLexico(BufferedReader bufferedReader, TabelaSimbolos tabelaSimbolos){
        this.codigo = bufferedReader;
        this.tabelaSimbolos = tabelaSimbolos;
        letraAtual = ' ';
        linha = 1;
        errorCompilacao = devolve = fimDeArquivo = false;
    }


    /**
     * Metodo da maquina de estados do analisador lexico
     * @return Simbolo retorna o simbolo criado
     */
    public Simbolo maquinaDeEstados() {
        int estadoAtual = 0;
        int estadoFinal = 13;

        while(estadoAtual != estadoFinal){
            switch (estadoAtual) {
                case 0:
                    estadoAtual = Estado0();
                    break;
                case 1:
                    estadoAtual = Estado1();
                  break;
                case 2:
                    estadoAtual = Estado2();
                  break;
                case 3:
                    estadoAtual = Estado3();
                  break;
                case 4:
                    estadoAtual = Estado4();
                  break;
                case 5:
                    estadoAtual = Estado5();
                    break;
                case 6:
                    estadoAtual = Estado6();
                    break;
                case 7:
                    estadoAtual = Estado7();
                    break;
                case 8:
                    estadoAtual = Estado8();
                    break;
                case 9:
                    estadoAtual = Estado9();
                    break;
                case 10:
                    estadoAtual = Estado10();
                    break;
                case 11:
                    estadoAtual = Estado11();
                    break;
                case 12:
                    estadoAtual = Estado12();
                    break;
                case 13:
                    break;
                default:
                    break;
              }
        }
        if(!fimDeArquivo) {
            if(tabelaSimbolos.BuscarLexema(lexema) == null) {
                if(lexema.charAt(0) == '"' || lexema.charAt(0) == '\'' || Util.VerificarDigito(lexema.charAt(0))) {
                  // INSERE NOVA CONSTANTE
                    Simbolo simboloConst = new Simbolo(tabelaSimbolos.constante, lexema);//tipoConst
                    return simboloConst;
                }
                else {
                  // INSERE NOVO IDENTIFICADOR
                    Simbolo simboloIdentificador = tabelaSimbolos.InserirIdentificador(lexema);
                    return simboloIdentificador;
                }
            }else{
                // EXISTE
                return tabelaSimbolos.BuscarLexema(lexema);
            }
        }else{
            return new Simbolo((byte)38,lexema);
        }
    }

    /**
     * Metodo para ler uma caracter
     * @return retorna a caracter lida
     */
    public char LerCaracter() {
        try {
            if(devolve) {
                devolve = false; //Ultimo caracter
            }else{
                ultimaLetra = letraAtual;
                letraAtual = (char) codigo.read(); //Novo caracter
            }
        }catch(Exception e){
            System.out.println("Error ao acessar arquivo");
            System.out.println(e);
        }
        return letraAtual;
    }

    /**
     * Metodo para mostrar erros durante a execucao do analisador lexico
     * @param char caracter que gerou o erro
     */
    public void MostrarErro(char caracter) {
        if(lexema == ""){
            lexema += caracter;
        }
        if(Util.VerificarCaracterValido(caracter)) {
            System.out.println(linha + "\nlexema nao identificado " + '[' + lexema + "].");
        }else{
            if(Util.fimDeArquivo == caracter) {
                System.out.println(linha + "\nfim de arquivo nao esperado.");
            }else {
                System.out.println(linha + "\ncaractere invalido.");
            }
        }
        errorCompilacao = true;
        System.exit(0);
    }

    /**
     * Metodo para analisar o estado 0 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado0() {
        lexema = "";
        char caracter = LerCaracter();

        if(Util.VerificarCaracterEspecialEToken(caracter)) {
            lexema += caracter;
            if(caracter == Util.barra) {
                return 9;
            } else if(caracter == Util.menor) {
                return 1;
            }else if(caracter == Util.abreParenteses || caracter == Util.fechaParenteses
                    || caracter == Util.pontoEVirgula || caracter == Util.virgula
                    || caracter == Util.abreChaves || caracter == Util.fechaChaves
                    || caracter == Util.porcentagem || caracter == Util.menos
                    || caracter == Util.abreColchetes || caracter == Util.fechaColchetes
                    || caracter == Util.mais || caracter == Util.asterisco || caracter == Util.igual) {
                return 13;
            }else if(caracter == Util.maior) {
                return 2;
            }else if (caracter == Util.aspas) {
                return 7;
            }
            else if (caracter == Util.apostofro) {
                return 12;
            }
            return 13;
        } else if(Util.VerificarDigito(caracter)) {
            lexema += caracter;
            tipoConst = "Integer";
            if(caracter != '0'){
                return 3;
            } else {
               return 4;
            }
        }else if(Util.VerificarLetra(caracter) || caracter == Util.sublinhado || caracter == Util.pontoFinal) {
            lexema += caracter;
            return 8;
        }else if(Util.VerificarQuebraDeLinha(caracter)) {
            if(Util.barraN == caracter || Util.novalinha == caracter) {
                linha++;
            }
            return 0;
        }else if(Util.fimDeArquivo == caracter){
            if(Util.barraN == ultimaLetra || Util.novalinha == ultimaLetra){
                linha--;
            }
            fimDeArquivo = true;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 1 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado1() {
        char caracter = LerCaracter();
        if(Util.VerificarCaracterEspecialEToken(caracter)) {
            lexema += caracter;
            if(caracter == Util.maior || caracter == Util.igual) {
                return 13; //Estado final
            }
        } else if(Util.VerificarCaracterValido(caracter) == true) {
            devolve = true;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 2 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado2() {
        char caracter = LerCaracter();
        if(Util.VerificarCaracterEspecialEToken(caracter)) {
            lexema += caracter;
            if(caracter == Util.igual) {
                return 13; //Estado final
            }
        } else if(Util.VerificarCaracterValido(caracter)) {
            devolve = true;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 3 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado3(){
        char caracter = LerCaracter();
        if(Util.VerificarDigito(caracter)) {
            lexema += caracter;
            return 3;
        }else if(Util.VerificarCaracterValido(caracter)){
            devolve=true;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 4 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado4(){
        char caracter = LerCaracter();
        if(Util.VerificarDigito(caracter)){
            lexema += caracter;
            return 3;
        }else if(caracter=='x'){
            lexema +=caracter;
            return 5;
        } else if (!(Util.VerificarDigito(caracter)) && (caracter!='x')){
            devolve=true;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 5 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado5(){
        char caracter = LerCaracter();
        if(Util.VerificarDigito(caracter) || Util.VerificarHexadecimal(caracter)) {
            lexema += caracter;
            return 6;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 6 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado6(){
        char caracter = LerCaracter();
        if(Util.VerificarDigito(caracter) || Util.VerificarHexadecimal(caracter)) {
            lexema += caracter;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 7 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado7(){
        char caracter = LerCaracter();
        if(caracter == Util.barraN || caracter == '$' || caracter == Util.novalinha ||
            !Util.VerificarCaracterValido(caracter)){
            MostrarErro(caracter);
            return 13;
        } else if(caracter == Util.aspas){
            lexema += caracter;
            return 13;
        }
        lexema += caracter;
        return 7;
    }

    /**
     * Metodo para analisar o estado 8 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado8(){
        char caracter = LerCaracter();
        if(!Util.VerificarLetra(caracter) && !Util.VerificarDigito(caracter) &&
            caracter != Util.sublinhado && caracter != Util.pontoFinal){
                devolve = true;
                return 13;
        } else if(Util.VerificarLetra(caracter) || Util.VerificarDigito(caracter) ||
            caracter == Util.sublinhado || caracter == Util.pontoFinal){
            lexema += caracter;
            return 8;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 9 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado9(){
        char caracter = LerCaracter();

        if(caracter == Util.asterisco){
            return 10;
        }else if(Util.VerificarCaracterValido(caracter)){
            devolve = true;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }

     /**
     * Metodo para analisar o estado 10 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado10(){
        char caracter = LerCaracter();
        if(caracter == Util.asterisco){
            return 11;
        }else if (caracter != Util.asterisco && Util.VerificarCaracterValido(caracter)) {
            return 10;
        }else if(Util.VerificarQuebraDeLinha(caracter)){
            return 10;
        }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 11 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado11(){
        char caracter = LerCaracter();
        if(caracter == Util.asterisco){
            return 11;
        }else if(caracter == Util.barra){
            return 0;
        }else if(Util.VerificarCaracterValido(caracter) || Util.VerificarQuebraDeLinha(caracter)){
            return 10;
        }
        MostrarErro(caracter);
        return 13;
    }


    /**
     * Metodo para analisar o estado 12 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado12(){
        char caracter = LerCaracter();
        if(Util.VerificarDigito(caracter) || Util.VerificarLetra(caracter) || Util.sublinhado == caracter || Util.pontoFinal == caracter){
            lexema+=caracter;
            return 12;
        }else if(Util.apostofro==caracter){
            lexema+=caracter;
            return 13;
        }
        MostrarErro(caracter);
        return 13;
    }
}


/**
*
*Classe para executar o analisador Sintatico
*
*/

class AnalisadorSintatico {
    AnalisadorLexico analisadorlexico;
    TabelaSimbolos tabelasimbolos;
    Simbolo simbolo;
    Simbolo novoSimbolo = new Simbolo();
    BufferedReader file;


    /**
     * Construtor da classe
     *
     * @param BufferedReader file - arquivo a ser lido
     */
    public AnalisadorSintatico(BufferedReader file) {
        this.file = file;
        this.tabelasimbolos = new TabelaSimbolos();
        this.analisadorlexico = new AnalisadorLexico(this.file, this.tabelasimbolos);
        this.simbolo = analisadorlexico.maquinaDeEstados();
    }

    /**
     * Metodo para identificar se o simbolo e' igual ao token esperado, se for, o
     * proximo simbolo e' lido, se nao uma mensagem de erro e' chamada
     *
     * @param byte tokenesperado - o token que se espera
     */
    public void CasaToken(byte tokenesperado) {
        if (this.simbolo.token == tokenesperado) {

            this.simbolo = analisadorlexico.maquinaDeEstados();
        } else {

            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha + "\nfim de arquivo nao esperado.");
                System.exit(0);
            } else {
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");
                System.exit(0);
            }
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica S -> { A } { B }*
     */
    public void S() {
        if (this.simbolo.token == this.tabelasimbolos.VAR || this.simbolo.token == this.tabelasimbolos.CONST) {
            while (this.simbolo.token == this.tabelasimbolos.VAR || this.simbolo.token == this.tabelasimbolos.CONST) {
                A();
            }
        }
        if (this.simbolo.token == this.tabelasimbolos.identificador || this.simbolo.token == this.tabelasimbolos.FOR
                || this.simbolo.token == this.tabelasimbolos.IF || this.simbolo.token == this.tabelasimbolos.READLN
                || this.simbolo.token == this.tabelasimbolos.WRITE || this.simbolo.token == this.tabelasimbolos.WRITELN
                || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
            while (this.simbolo.token == this.tabelasimbolos.identificador
                    || this.simbolo.token == this.tabelasimbolos.FOR || this.simbolo.token == this.tabelasimbolos.IF
                    || this.simbolo.token == this.tabelasimbolos.READLN
                    || this.simbolo.token == this.tabelasimbolos.WRITE
                    || this.simbolo.token == this.tabelasimbolos.WRITELN
                    || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                B();
            }
        }
        if (analisadorlexico.fimDeArquivo == false) {
            System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");
            System.exit(0);
        }
        System.out.println((analisadorlexico.linha)+" linhas compiladas.");
        System.exit(0);
    }

    /**********************************************
     * Declaracoes
     ***********************************************************/
    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica A -> var E |
     * const id = D;
     */
    public void A() {
        //byte classe;
        if (this.simbolo.token == this.tabelasimbolos.VAR) {
            CasaToken(this.tabelasimbolos.VAR);
            novoSimbolo.classe = 1;
            do {
                E(novoSimbolo);
            } while (this.simbolo.token == this.tabelasimbolos.INTEGER
                    || this.simbolo.token == this.tabelasimbolos.CHAR);

        }
        if (this.simbolo.token == this.tabelasimbolos.CONST) {
            novoSimbolo.classe = 2;
            CasaToken(this.tabelasimbolos.CONST);
            if(this.simbolo.tipo != 0){
              System.out.println(this.analisadorlexico.linha + "\nidentificador ja declarado [" + this.simbolo.lexema + "].");
              System.exit(0);
            } else{
              this.simbolo.classe = novoSimbolo.classe;
              this.simbolo.tipo = novoSimbolo.tipo;
              CasaToken(this.tabelasimbolos.identificador);
              CasaToken(this.tabelasimbolos.IGUAL);
              if (this.simbolo.token == this.tabelasimbolos.MENOS || this.simbolo.token == this.tabelasimbolos.CHAR
                      || this.simbolo.token == this.tabelasimbolos.constante) {
                        if(this.simbolo.token == this.tabelasimbolos.CHAR){
                          this.simbolo.classe = 1;
                        } else {
                          this.simbolo.classe = 2;
                        }
                  while (this.simbolo.token == this.tabelasimbolos.MENOS || this.simbolo.token == this.tabelasimbolos.CHAR
                          || this.simbolo.token == this.tabelasimbolos.constante) {
                      D(novoSimbolo);
                      CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
                  }
              }
            }
      }else {
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha + "\nfim de arquivo nao esperado.");
                System.exit(0);
            } else {
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");
                System.exit(0);
            }
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica E
     * ->(integer|char) C;E
     */
    public void E(Simbolo novoSimbolo) {
        if (this.simbolo.token == this.tabelasimbolos.INTEGER) {
            CasaToken(this.tabelasimbolos.INTEGER);
            novoSimbolo.tipo = 1;
            if (this.simbolo.token == this.tabelasimbolos.identificador) {
                while (this.simbolo.token == this.tabelasimbolos.identificador) {
                    C(novoSimbolo);
                }
            }
            E(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.CHAR) {
            CasaToken(this.tabelasimbolos.CHAR);
            novoSimbolo.tipo = 2;
            if (this.simbolo.token == this.tabelasimbolos.identificador) {
                while (this.simbolo.token == this.tabelasimbolos.identificador) {
                    C(novoSimbolo);
                }
            }
            //CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
            E(novoSimbolo);
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica C ->
     * id([=D]|['['num']']) | id([=D]|['['num']']),C
     */
    public void C(Simbolo novoSimbolo) {
      if(this.simbolo.tipo != 0){
        System.out.println(this.analisadorlexico.linha + "\nidentificador ja declarado [" + this.simbolo.lexema + "].");
        System.exit(0);
      } else{
            this.simbolo.tipo = novoSimbolo.tipo;
            this.simbolo.classe = novoSimbolo.classe;
            CasaToken(this.tabelasimbolos.identificador);

            if (this.simbolo.token == this.tabelasimbolos.IGUAL) {
                CasaToken(this.tabelasimbolos.IGUAL);
                if (this.simbolo.token == this.tabelasimbolos.MENOS || this.simbolo.token == this.tabelasimbolos.CHAR) {
                    D(novoSimbolo);
                }
                D(novoSimbolo);
            } else if (this.simbolo.token == this.tabelasimbolos.COLCHETE_ABERTO) {
                CasaToken(this.tabelasimbolos.COLCHETE_ABERTO);
                this.simbolo.tamanho = Integer.valueOf(this.simbolo.lexema);
                if(this.simbolo.tamanho > Util.tamanhoMaxVetor){
                  System.out.println(this.analisadorlexico.linha + "\ntamanho do vetor excede o maximo permitido.");
                  System.exit(0);
                } else{
                  CasaToken(this.tabelasimbolos.constante);
                  CasaToken(this.tabelasimbolos.COLCHETE_FECHADO);
                }
            }
            if (this.simbolo.token == this.tabelasimbolos.VIRGULA) {
                CasaToken(this.tabelasimbolos.VIRGULA);
                C(novoSimbolo);
            } else {
                CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
            }
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica D -> [-]num |
     * _char
     */
    public void D(Simbolo novoSimbolo) {
        if (this.simbolo.token == this.tabelasimbolos.MENOS) {
            CasaToken(this.tabelasimbolos.MENOS);
            if (this.simbolo.token == this.tabelasimbolos.constante) {
              if(this.simbolo.classe == novoSimbolo.classe){
                CasaToken(this.tabelasimbolos.constante);
              } else {
                System.out.println(this.analisadorlexico.linha + "\ntipos incompativeis.");
                System.exit(0);
              }
            }
        } else if (this.simbolo.token == this.tabelasimbolos.constante) {
          if(this.simbolo.classe == novoSimbolo.classe){

            CasaToken(this.tabelasimbolos.constante);
          } else {
            System.out.println(this.analisadorlexico.linha + "\ntipos incompativeis.");
            System.exit(0);
          }
        } else if (this.simbolo.token == this.tabelasimbolos.CHAR) {
          if(this.simbolo.classe == novoSimbolo.classe){

            CasaToken(this.tabelasimbolos.CHAR);
          } else {
            System.out.println(this.analisadorlexico.linha + "\ntipos incompativeis.");
            System.exit(0);
          }
        }
    }

    /***************************************
     * Comandos
     ************************************/
    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica B -> id = F; |
     * For id=F to F [step num] do (B|'{'{B}'}') | if F then (B|'{'{B}'}') [else
     * (B|'{'{B}'}')] | ; | readln'('id')'; | write(G); | writeln(G);
     */
    public void B() {
        Simbolo simboloAux = new Simbolo();
        simboloAux.tipo = 0;
        if (this.simbolo.token == this.tabelasimbolos.identificador) {
            if(this.simbolo.tipo == 0){
                System.out.println(this.analisadorlexico.linha + "\nidentificador nao declarado [" + this.simbolo.lexema + "].");
                System.exit(0);
              }else{
                CasaToken(this.tabelasimbolos.identificador);
                CasaToken(this.tabelasimbolos.IGUAL);
                F(novoSimbolo);
                CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
            }
        } else if (this.simbolo.token == this.tabelasimbolos.FOR) {
            CasaToken(this.tabelasimbolos.FOR);
            novoSimbolo.tipo = this.simbolo.tipo;
            novoSimbolo.classe = this.simbolo.classe;
            if(this.simbolo.tipo == 0){
              System.out.println(this.analisadorlexico.linha + "\nidentificador nao declarado [" + this.simbolo.lexema + "].");
              System.exit(0);
            }else{
            CasaToken(this.tabelasimbolos.identificador);
            CasaToken(this.tabelasimbolos.IGUAL);
            F(novoSimbolo);
            CasaToken(this.tabelasimbolos.TO);
            F(novoSimbolo);
            if (this.simbolo.token == this.tabelasimbolos.STEP) {
                CasaToken(this.tabelasimbolos.STEP);
                CasaToken(this.tabelasimbolos.constante);
            }
            CasaToken(this.tabelasimbolos.DO);
            if (this.simbolo.token == this.tabelasimbolos.identificador || this.simbolo.token == this.tabelasimbolos.FOR
                    || this.simbolo.token == this.tabelasimbolos.IF || this.simbolo.token == this.tabelasimbolos.READLN
                    || this.simbolo.token == this.tabelasimbolos.WRITE
                    || this.simbolo.token == this.tabelasimbolos.WRITELN
                    || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                B();
            } else if (this.simbolo.token == this.tabelasimbolos.CHAVES_ABERTO) {

                CasaToken(this.tabelasimbolos.CHAVES_ABERTO);
                if (this.simbolo.token == this.tabelasimbolos.identificador
                        || this.simbolo.token == this.tabelasimbolos.FOR || this.simbolo.token == this.tabelasimbolos.IF
                        || this.simbolo.token == this.tabelasimbolos.READLN
                        || this.simbolo.token == this.tabelasimbolos.WRITE
                        || this.simbolo.token == this.tabelasimbolos.WRITELN
                        || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                            while(this.simbolo.token == this.tabelasimbolos.identificador
                            || this.simbolo.token == this.tabelasimbolos.FOR || this.simbolo.token == this.tabelasimbolos.IF
                            || this.simbolo.token == this.tabelasimbolos.READLN
                            || this.simbolo.token == this.tabelasimbolos.WRITE
                            || this.simbolo.token == this.tabelasimbolos.WRITELN
                            || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA){
                                B();
                            }
                }

                CasaToken(this.tabelasimbolos.CHAVES_FECHADO);
            }
            }
        } else if (this.simbolo.token == this.tabelasimbolos.IF) {
            CasaToken(this.tabelasimbolos.IF);
            F(simboloAux);
            CasaToken(this.tabelasimbolos.THEN);
            if (this.simbolo.token == this.tabelasimbolos.identificador || this.simbolo.token == this.tabelasimbolos.FOR
                    || this.simbolo.token == this.tabelasimbolos.IF || this.simbolo.token == this.tabelasimbolos.READLN
                    || this.simbolo.token == this.tabelasimbolos.WRITE
                    || this.simbolo.token == this.tabelasimbolos.WRITELN
                    || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                B();
                if (this.simbolo.token == this.tabelasimbolos.ELSE) {

                    CasaToken(this.tabelasimbolos.ELSE);
                    if (this.simbolo.token == this.tabelasimbolos.identificador
                            || this.simbolo.token == this.tabelasimbolos.FOR
                            || this.simbolo.token == this.tabelasimbolos.IF
                            || this.simbolo.token == this.tabelasimbolos.READLN
                            || this.simbolo.token == this.tabelasimbolos.WRITE
                            || this.simbolo.token == this.tabelasimbolos.WRITELN
                            || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                        B();
                    } else if (this.simbolo.token == this.tabelasimbolos.CHAVES_ABERTO) {
                        CasaToken(this.tabelasimbolos.CHAVES_ABERTO);
                        if (this.simbolo.token == this.tabelasimbolos.identificador
                                || this.simbolo.token == this.tabelasimbolos.FOR
                                || this.simbolo.token == this.tabelasimbolos.IF
                                || this.simbolo.token == this.tabelasimbolos.READLN
                                || this.simbolo.token == this.tabelasimbolos.WRITE
                                || this.simbolo.token == this.tabelasimbolos.WRITELN
                                || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                            B();
                        }
                        CasaToken(this.tabelasimbolos.CHAVES_FECHADO);
                    }
                }
            }else if (this.simbolo.token == this.tabelasimbolos.CHAVES_ABERTO) {

                CasaToken(this.tabelasimbolos.CHAVES_ABERTO);
                if (this.simbolo.token == this.tabelasimbolos.identificador || this.simbolo.token == this.tabelasimbolos.FOR
                        || this.simbolo.token == this.tabelasimbolos.IF || this.simbolo.token == this.tabelasimbolos.READLN
                        || this.simbolo.token == this.tabelasimbolos.WRITE
                        || this.simbolo.token == this.tabelasimbolos.WRITELN
                        || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                    B();
                }
                CasaToken(this.tabelasimbolos.CHAVES_FECHADO);
                if (this.simbolo.token == this.tabelasimbolos.ELSE) {
                    CasaToken(this.tabelasimbolos.ELSE);
                    if (this.simbolo.token == this.tabelasimbolos.identificador
                            || this.simbolo.token == this.tabelasimbolos.FOR || this.simbolo.token == this.tabelasimbolos.IF
                            || this.simbolo.token == this.tabelasimbolos.READLN
                            || this.simbolo.token == this.tabelasimbolos.WRITE
                            || this.simbolo.token == this.tabelasimbolos.WRITELN
                            || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                        B();
                    } else if (this.simbolo.token == this.tabelasimbolos.CHAVES_ABERTO) {
                        CasaToken(this.tabelasimbolos.CHAVES_ABERTO);
                        if (this.simbolo.token == this.tabelasimbolos.identificador
                                || this.simbolo.token == this.tabelasimbolos.FOR
                                || this.simbolo.token == this.tabelasimbolos.IF
                                || this.simbolo.token == this.tabelasimbolos.READLN
                                || this.simbolo.token == this.tabelasimbolos.WRITE
                                || this.simbolo.token == this.tabelasimbolos.WRITELN
                                || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                            B();
                        }
                        CasaToken(this.tabelasimbolos.CHAVES_FECHADO);
                    }
                }
            }
        } else if (this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {

            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
        } else if (this.simbolo.token == this.tabelasimbolos.READLN) {
            CasaToken(this.tabelasimbolos.READLN);
            CasaToken(this.tabelasimbolos.PARENTESES_ABERTO);
            if(this.simbolo.tipo == this.simbolo.semTipo ){
                System.out.println(this.analisadorlexico.linha + "\nidentificador nao declarado [" + this.simbolo.lexema + "].");
                System.exit(0);
            }else{
                if(this.simbolo.classe ==this.simbolo.classeCONST){
                    System.out.println(this.analisadorlexico.linha + "\nclasse de identificador incompativel [" + this.simbolo.lexema + "].");
                    System.exit(0);
                }else{
                    CasaToken(this.tabelasimbolos.identificador);
                    if(this.simbolo.token == this.tabelasimbolos.COLCHETE_ABERTO){
                        CasaToken(this.tabelasimbolos.COLCHETE_ABERTO);
                        if(this.simbolo.token == this.tabelasimbolos.constante){
                            CasaToken(this.tabelasimbolos.constante);
                        } else {
                            if(this.simbolo.tipo == 0){
                                System.out.println(this.analisadorlexico.linha + "\nidentificador nao declarado [" + this.simbolo.lexema + "].");
                                System.exit(0);
                            }else{
                                CasaToken(this.tabelasimbolos.identificador);
                            }
                        }
                        CasaToken(this.tabelasimbolos.COLCHETE_FECHADO);
                    }
                    CasaToken(this.tabelasimbolos.PARENTESES_FECHADO);
                    CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
                }
            }
        } else if (this.simbolo.token == this.tabelasimbolos.WRITE) {

            CasaToken(this.tabelasimbolos.WRITE);
            G(simboloAux);
            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
        } else if (this.simbolo.token == this.tabelasimbolos.WRITELN) {

            CasaToken(this.tabelasimbolos.WRITELN);
            G(simboloAux);

            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
        } else {
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha + "\nfim de arquivo nao esperado.");
                System.exit(0);
            } else {
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");
                System.exit(0);
            }
        }
    }

    /**
     * Metodo correspondente ao simbolo nao-terminal da gramatica B -> id = F; |
     * For id=F to F [step num] do (B|'{'{B}'}') | if F then (B|'{'{B}'}') [else
     * (B|'{'{B}'}')] | ; | readln'('id')'; | write(G); | writeln(G);
     */

    public void G(Simbolo novoSimbolo) {
        if (this.simbolo.token == this.tabelasimbolos.MAIS || this.simbolo.token == this.tabelasimbolos.MENOS
                || this.simbolo.token == this.tabelasimbolos.NOT || this.simbolo.token == this.tabelasimbolos.constante
                || this.simbolo.token == this.tabelasimbolos.CHAR
                || this.simbolo.token == this.tabelasimbolos.PARENTESES_ABERTO
                || this.simbolo.token == this.tabelasimbolos.identificador) {
            F(novoSimbolo);
        }
    }

    /***************************************
     * Expressao
     ************************************/
    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica F -> H (= | <>
     * |<| > |<= | >=) H
     */
    public void F(Simbolo novoSimbolo) {
        H(novoSimbolo);
        if (this.simbolo.token == this.tabelasimbolos.IGUAL) {
            CasaToken(this.tabelasimbolos.IGUAL);
            H(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.DIFERENTE) {
            CasaToken(this.tabelasimbolos.DIFERENTE);
            H(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.MAIOR) {
            CasaToken(this.tabelasimbolos.MAIOR);
            H(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.MENOR) {
            CasaToken(this.tabelasimbolos.MENOR);
            H(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.MENOR_IGUAL) {
            CasaToken(this.tabelasimbolos.MENOR_IGUAL);
            H(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.MAIOR_IGUAL) {
            CasaToken(this.tabelasimbolos.MAIOR_IGUAL);
            H(novoSimbolo);
        }

    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica H -> [+|-]I {(+ |
     * - | 'or')I}
     */
    public void H(Simbolo novoSimbolo) {
        if (this.simbolo.token == this.tabelasimbolos.MAIS) {
            CasaToken(this.tabelasimbolos.MAIS);
        } else if (this.simbolo.token == this.tabelasimbolos.MENOS) {
            CasaToken(this.tabelasimbolos.MENOS);
        }
        I(novoSimbolo);
        while (this.simbolo.token == this.tabelasimbolos.MAIS || this.simbolo.token == this.tabelasimbolos.MENOS
                || this.simbolo.token == this.tabelasimbolos.OR) {
            if (this.simbolo.token == this.tabelasimbolos.MAIS) {
                CasaToken(this.tabelasimbolos.MAIS);
                I(novoSimbolo);
            } else if (this.simbolo.token == this.tabelasimbolos.MENOS) {
                CasaToken(this.tabelasimbolos.MENOS);
                I(novoSimbolo);
            } else if (this.simbolo.token == this.tabelasimbolos.OR) {
                CasaToken(this.tabelasimbolos.OR);
                I(novoSimbolo);
            }
        }

    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica I -> J{(* | 'and'
     * | / | %)J}
     */
    public void I(Simbolo novoSimbolo) {
        J(novoSimbolo);
        while (this.simbolo.token == this.tabelasimbolos.ASTERISCO || this.simbolo.token == this.tabelasimbolos.BARRA
                || this.simbolo.token == this.tabelasimbolos.PORCENTAGEM
                || this.simbolo.token == this.tabelasimbolos.AND) {
            if (this.simbolo.token == this.tabelasimbolos.ASTERISCO) {
                CasaToken(this.tabelasimbolos.ASTERISCO);
                J(novoSimbolo);
            } else if (this.simbolo.token == this.tabelasimbolos.BARRA) {
                CasaToken(this.tabelasimbolos.BARRA);
                J(novoSimbolo);
            } else if (this.simbolo.token == this.tabelasimbolos.PORCENTAGEM) {
                CasaToken(this.tabelasimbolos.PORCENTAGEM);
                J(novoSimbolo);
            } else if (this.simbolo.token == this.tabelasimbolos.AND) {
                CasaToken(this.tabelasimbolos.AND);
                J(novoSimbolo);
            }
        }

    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica J -> (K | not K)
     */
    public void J(Simbolo novoSimbolo) {
        if (this.simbolo.token == this.tabelasimbolos.NOT) {
            CasaToken(this.tabelasimbolos.NOT);
            K(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.PARENTESES_ABERTO) {
            K(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.constante) {
            K(novoSimbolo);
        } else if (this.simbolo.token == this.tabelasimbolos.identificador) {
            K(novoSimbolo);
        } else {
            // Caso nenhum token seja os que o F espera
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha + "\nfim de arquivo nao esperado.");
                System.exit(0);
            } else {
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");
                System.exit(0);
            }
        }

    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica K -> num | _char
     * | '('F')' | id
     */
    public void K(Simbolo novoSimbolo) {
        if (this.simbolo.token == this.tabelasimbolos.PARENTESES_ABERTO) {
            CasaToken(this.tabelasimbolos.PARENTESES_ABERTO);
            F(novoSimbolo);
            if (this.simbolo.token == this.tabelasimbolos.VIRGULA) {
                while(this.simbolo.token == this.tabelasimbolos.VIRGULA){
                    CasaToken(this.tabelasimbolos.VIRGULA);
                     G(novoSimbolo);
                }

            }
            CasaToken(this.tabelasimbolos.PARENTESES_FECHADO);
        } else if (this.simbolo.token == this.tabelasimbolos.constante) {
            if(this.simbolo.tipo == novoSimbolo.tipo){
                CasaToken(this.tabelasimbolos.constante);
              } else {
                System.out.println(this.analisadorlexico.linha + "\ntipos incompativeis.");
                System.exit(0);
              }
        } else if (this.simbolo.token == this.tabelasimbolos.identificador) {
          if(this.simbolo.tipo != this.simbolo.semTipo){
            CasaToken(this.tabelasimbolos.identificador);
          } else {
            System.out.println(this.analisadorlexico.linha + "\nidentificador nao declarado [" + this.simbolo.lexema + "].");
            System.exit(0);
          }
            if(this.simbolo.token == this.tabelasimbolos.COLCHETE_ABERTO){
                CasaToken(this.tabelasimbolos.COLCHETE_ABERTO);
                if(this.simbolo.token == this.tabelasimbolos.constante){
                    CasaToken(this.tabelasimbolos.constante);
                } else {
                    CasaToken(this.tabelasimbolos.identificador);
                }
                CasaToken(this.tabelasimbolos.COLCHETE_FECHADO);
            }
        } else if (this.simbolo.token == this.tabelasimbolos.CHAR) {
            CasaToken(this.tabelasimbolos.CHAR);
        } else {
            // Caso nenhum token seja os que o F espera
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha + "\nfim de arquivo nao esperado.");
                System.exit(0);
            } else {
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");
                System.exit(0);
            }
        }

    }
}

public class LC{
    public static void main(String[]args) throws Exception{
        try{
            //System.setProperty("file.encoding", "UTF-8");
            //InputStreamReader isr = new InputStreamReader(System.in);
           // BufferedReader br = new BufferedReader(isr);

            //InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
            //BufferedReader br = new BufferedReader(isr);

            FileReader arq = new FileReader("ERRO.txt"); 
            BufferedReader lerArq = new BufferedReader(arq);
            TabelaSimbolos tabelaSimbolos = new TabelaSimbolos();
            AnalisadorSintatico sintatico = new AnalisadorSintatico(lerArq);
            sintatico.S();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
