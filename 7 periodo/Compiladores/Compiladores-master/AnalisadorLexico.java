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

import java.io.*;

//Classe que le um arquivo e pega digito por digito para formar o lexema
public class AnalisadorLexico{

    public BufferedReader codigo;
    public TabelaSimbolos tabelaSimbolos;
    public String lexema;
    public String tipoConst;
    public char ultimaLetra;
    public int linha;
    public boolean errorCompilacao;
    public boolean devolve;
    public boolean fimDeArquivo;
    
    /**
     * Metodo construtor analisador lexico
     * @param bufferedReader arquivo que sera lido
     * @param tabelaSimbolos tabela de simbolos
     */
    public AnalisadorLexico(BufferedReader bufferedReader, TabelaSimbolos tabelaSimbolos){
        this.codigo = bufferedReader;
        this.tabelaSimbolos = tabelaSimbolos;
        ultimaLetra = ' ';
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
                    //System.out.println(lexema + " Achou uma constante.");
                    Simbolo simboloConst = new Simbolo(tabelaSimbolos.constante, lexema, tipoConst);
                    //System.out.println("Lexema(CONST) : " + lexema + " Tipo : " + tipoConst + " Tamanho = 0");
                    return simboloConst;
                }else {
                    //System.out.println(lexema + " Achou um indetificador.");
                    Simbolo simboloIdentificador = tabelaSimbolos.InserirIdentificador(lexema);
                    //System.out.println("Lexema(ID) : " + lexema);
                    return simboloIdentificador;
                }
            }else{
                //System.out.println("Lexema(PR) : " + lexema);
                return tabelaSimbolos.BuscarLexema(lexema);
            }
        }else{
            // System.out.println((linha-1)+" linhas compiladas");
            // System.exit(0);

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
                ultimaLetra = (char) codigo.read(); //Novo caracter 
            }
        }catch(Exception e){
            System.out.println("Error ao acessar arquivo");
            System.out.println(e);
        }
        return ultimaLetra;
    }

    /**
     * Metodo para mostrar erros durante a execucao do analisador lexico
     * @param char caracter que gerou o erro
     */
    public void MostrarErro(char caracter) {
        lexema += caracter;
        if(Util.VerificarCaracterValido(caracter)) {
            System.out.println(linha);
            System.out.println("lexema nao identificado " + '[' + lexema + "].");
        }else{
            if(Util.fimDeArquivo == caracter) {
                System.out.println(linha);
                System.out.println("fim de arquivo nao esperado.");
            }else {
                System.out.println(linha);
                System.out.println("caractere invalido.");
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
        // // System.out.println("Caracter Estado 0:" + caracter);

        if(Util.VerificarCaracterEspecialEToken(caracter)) {
            lexema += caracter;
            if(caracter == Util.barra) {
                // // System.out.println("Caracter Estado 0 transicao pro 9:" + caracter);
                return 9;      
            } else if(caracter == Util.menor) {
                return 1;
            }else if(caracter == Util.abreParenteses || caracter == Util.fechaParenteses || caracter == Util.pontoEVirgula || caracter == Util.virgula
                    || caracter == Util.abreChaves || caracter == Util.fechaChaves || caracter == Util.porcentagem || caracter == Util.menos || caracter == Util.abreColchetes
                    || caracter == Util.fechaColchetes || caracter == Util.mais || caracter == Util.asterisco || caracter == Util.igual) { 
                return 13;
            }else if(caracter == Util.maior) {
                return 2;
            }else if (caracter == Util.aspas || caracter == Util.aspas2) {
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
            // System.out.println("ENTRANDO NO ESTADO 8, LEXEMA: " + lexema);
            return 8;
        }else if(Util.VerificarQuebraDeLinha(caracter)) {
            if(Util.barraN == caracter || Util.novalinha == caracter) {
                linha++;
            }
            return 0;
        }else if(Util.fimDeArquivo == caracter){
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
        // System.out.println("Caracter Estado 1:" + caracter);    
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
        // System.out.println("Caracter Estado 2:" + caracter);
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
        // System.out.println("Caracter Estado 3:" + caracter);
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
        // System.out.println("Caracter Estado 4:" + caracter);
        if(Util.VerificarDigito(caracter)){
            lexema += caracter;
            return 3;
        }else if(caracter=='x'){
            lexema +=caracter;
            return 5;
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
        // System.out.println("Caracter Estado 5:" + caracter);
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
        // System.out.println("Caracter Estado 6:" + caracter);
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
        if(caracter == Util.barraN || caracter == '$' || caracter == Util.novalinha){
            MostrarErro(caracter);
            return 13;
        } else if(caracter == Util.aspas  || caracter ==  Util.aspas2){
            lexema += caracter;
            return 13;
        }
        // // System.out.println("Caracter Estado 7:" + caracter);
        // if(Util.VerificarCaracterValido(caracter) && (caracter != Util.aspas || caracter !=  Util.aspas2)
        //                                           || caracter == Util.espaco){
        //     lexema += caracter;
        //     return 7; 
        // } else { //if(Util.aspas == caracter || Util.aspas2 == caracter){
        // //     System.out.println("Caracter Estado 7: ENTREIII");
        //     lexema += caracter;
        //     return 13;
        // } 
        // MostrarErro(caracter);
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
                // System.out.println("LEXEMA PRIMEIRO IF ESTADO 8:" + lexema);
                devolve = true;
                return 13;
        } else if(Util.VerificarLetra(caracter) || Util.VerificarDigito(caracter) || 
            caracter == Util.sublinhado || caracter == Util.pontoFinal){
            lexema += caracter;
            // System.out.println("ESTADO 8 LEXEMA:" + lexema);
            return 8;
        }
        // // System.out.println("Caracter Estado 8:" + caracter);   
        // if(Util.VerificarDigito(caracter) || Util.VerificarLetra(caracter) || caracter == Util.sublinhado || 
        //                                      caracter == Util.pontoFinal){
        //     lexema += caracter;
        //     return 8;
        // }else if(Util.VerificarCaracterValido(caracter) && !(Util.VerificarDigito(caracter) || 
        //         Util.VerificarLetra(caracter) || caracter == Util.sublinhado || caracter == Util.pontoFinal)){
        //     devolve = true;
        //     return 13;
        // }
        MostrarErro(caracter);
        return 13;
    }

    /**
     * Metodo para analisar o estado 9 da maquina de estados
     * @return int o proximo estado
     */
    public int Estado9(){
        char caracter = LerCaracter();

        // System.out.println("Caracter Estado 9:" + caracter);
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

        // System.out.println("Caracter Estado 10:" + caracter);
        if(caracter == Util.asterisco){
            return 11;
        }else if (caracter != Util.asterisco && Util.VerificarCaracterValido(caracter)) {
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
        // System.out.println("Caracter Estado 11:" + caracter);
        if(caracter == Util.asterisco){
            return 11;
        }else if(caracter == Util.barra){
            return 0;
        }else if(Util.VerificarCaracterValido(caracter)){
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
        // System.out.println("Caracter Estado 12:" + caracter);
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
