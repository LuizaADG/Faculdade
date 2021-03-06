
/**
* Trabalho de compiladores - Analisador Lexico
* Professor: Alexei Machado
* 
* @author Jorge Luiz
* @author Luiza Avila
* @author Stefany Gaspar
*
*Classe para executar o analisador Sintatico
*
*/
import java.io.BufferedReader;
import java.io.FileReader;

public class AnalisadorSintatico {
    AnalisadorLexico analisadorlexico;
    TabelaSimbolos tabelasimbolos;
    Simbolo simbolo;
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

        // System.out.println("this.simbolo.token:" + this.simbolo.token);
        // System.out.println("tokenesperado:" + tokenesperado);

        if (this.simbolo.token == tokenesperado) {
            // System.out.println("EU ENTRO PELO MENOS");
            this.simbolo = analisadorlexico.maquinaDeEstados();
            // System.out.println("FINAL:" + this.simbolo.token);

        } else {
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha);
                System.out.println("fim de arquivo nao esperado.");
                System.exit(0);
            } else {
                // System.out.println("CASA TOKEN");
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");

                System.exit(0);
            }
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica S -> { A } { B }*
     */
    public void S() {
        // System.out.println("LEXEMA:" + this.simbolo.lexema);
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
            // System.out.println("DEU ERRO!");
            System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");

        }
        System.out.println((analisadorlexico.linha-1)+" linhas compiladas");
    }

    /**********************************************
     * Declaracoes
     ***********************************************************/
    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica A -> var E |
     * const id = D;
     */
    public void A() {
        // System.out.println("simbolo token: " + this.simbolo.token);
        if (this.simbolo.token == this.tabelasimbolos.VAR) {

            CasaToken(this.tabelasimbolos.VAR);
            do {
                E();
            } while (this.simbolo.token == this.tabelasimbolos.INTEGER
                    || this.simbolo.token == this.tabelasimbolos.CHAR);

        }
        if (this.simbolo.token == this.tabelasimbolos.CONST) {

            CasaToken(this.tabelasimbolos.CONST);
            CasaToken(this.tabelasimbolos.identificador);
            CasaToken(this.tabelasimbolos.IGUAL);
            if (this.simbolo.token == this.tabelasimbolos.MENOR || this.simbolo.token == this.tabelasimbolos.CHAR
                    || this.simbolo.token == this.tabelasimbolos.constante) {
                while (this.simbolo.token == this.tabelasimbolos.MENOR || this.simbolo.token == this.tabelasimbolos.CHAR
                        || this.simbolo.token == this.tabelasimbolos.constante) {
                    D();
                    CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
                }
            }
        } else {
            // Caso nenhum token seja os que o A espera
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha);
                System.out.println("fim de arquivo nao esperado.");
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
    public void E() {
        if (this.simbolo.token == this.tabelasimbolos.INTEGER) {
            CasaToken(this.tabelasimbolos.INTEGER);
            if (this.simbolo.token == this.tabelasimbolos.identificador) {
                while (this.simbolo.token == this.tabelasimbolos.identificador) {
                    C();
                }
            }
            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
            E();
        } else if (this.simbolo.token == this.tabelasimbolos.CHAR) {
            CasaToken(this.tabelasimbolos.CHAR);
            if (this.simbolo.token == this.tabelasimbolos.identificador) {
                while (this.simbolo.token == this.tabelasimbolos.identificador) {
                    C();
                }
            }

            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
            E();
        }
        // else{
        // //Caso nenhum token seja os que o D espera
        // if(analisadorlexico.fimDeArquivo){
        // System.out.println(analisadorlexico.linha + " : fim de arquivo nao
        // esperado");
        // System.exit(0);
        // }
        // else{
        // System.out.println("TNE E");
        // System.out.printanalisadorlexico.lina + " : token nao esperado  ." +
        // this.simbolo.lexema + " ]");
        // System.exit(0);
        // }
        // }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica C ->
     * id([=D]|['['num']']) | id([=D]|['['num']']),C
     */
    public void C() {
        // System.out.println("" + this.simbolo.token);
        CasaToken(this.tabelasimbolos.identificador);
        if (this.simbolo.token == this.tabelasimbolos.IGUAL) {
            // System.out.println("ENTRA NO IF C");
            CasaToken(this.tabelasimbolos.IGUAL);
            if (this.simbolo.token == this.tabelasimbolos.MENOS || this.simbolo.token == this.tabelasimbolos.CHAR) {
                D();
            }
        } else if (this.simbolo.token == this.tabelasimbolos.COLCHETE_ABERTO) {
            // System.out.println("ENTRA NO ELSE IF C");
            CasaToken(this.tabelasimbolos.COLCHETE_ABERTO);
            // System.out.println("CONSTANTE:" + this.tabelasimbolos.constante);
            CasaToken(this.tabelasimbolos.constante);
            // System.out.println("SIMBOLO TOKEN:" + this.simbolo.token);
            CasaToken(this.tabelasimbolos.COLCHETE_FECHADO);
            
        } if (this.simbolo.token == this.tabelasimbolos.VIRGULA) {
            CasaToken(this.tabelasimbolos.VIRGULA);
            C();
        }
        // }else{
        // //Caso nenhum token seja os que o C espera
        // if(analisadorlexico.fimDeArquivo){
        // System.out.println(analisadorlexico.linha + " : fim de arquivo nao
        // esperado");
        // System.exit(0);
        // }else{
        // System.out.printanalisadorlexico.lina + " : token nao esperado  ." +
        // this.simbolo.lexema + " ]");
        // System.exit(0);
        // }
        // }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica D -> [-]num |
     * _char
     */
    public void D() {
        if (this.simbolo.token == this.tabelasimbolos.MENOS) {
            CasaToken(this.tabelasimbolos.MENOS);
            if (this.simbolo.token == this.tabelasimbolos.constante) {
                CasaToken(this.tabelasimbolos.constante);
            }
        } else if (this.simbolo.token == this.tabelasimbolos.constante) {
            CasaToken(this.tabelasimbolos.constante);
        } else if (this.simbolo.token == this.tabelasimbolos.CHAR) {
            CasaToken(this.tabelasimbolos.CHAR);
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
        if (this.simbolo.token == this.tabelasimbolos.identificador) {

            CasaToken(this.tabelasimbolos.identificador);
            CasaToken(this.tabelasimbolos.IGUAL);
            F();
            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
        } else if (this.simbolo.token == this.tabelasimbolos.FOR) {

            CasaToken(this.tabelasimbolos.FOR);
            CasaToken(this.tabelasimbolos.identificador);
            CasaToken(this.tabelasimbolos.IGUAL);
            F();
            CasaToken(this.tabelasimbolos.TO);
            F();
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
                // System.out.println("entrO CHAVES ABERTAS: " + this.simbolo.token);

                CasaToken(this.tabelasimbolos.CHAVES_ABERTO);
                if (this.simbolo.token == this.tabelasimbolos.identificador
                        || this.simbolo.token == this.tabelasimbolos.FOR || this.simbolo.token == this.tabelasimbolos.IF
                        || this.simbolo.token == this.tabelasimbolos.READLN
                        || this.simbolo.token == this.tabelasimbolos.WRITE
                        || this.simbolo.token == this.tabelasimbolos.WRITELN
                        || this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {
                    B();
                    // System.out.println("TERMINOOO BBBBBBBBBBB: ");
                }
                // System.out.println("TESTE: " + this.simbolo.token);

                CasaToken(this.tabelasimbolos.CHAVES_FECHADO);
            }
        } else if (this.simbolo.token == this.tabelasimbolos.IF) {
            CasaToken(this.tabelasimbolos.IF);
            F();
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
            }
        } else if (this.simbolo.token == this.tabelasimbolos.CHAVES_ABERTO) {

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
        } else if (this.simbolo.token == this.tabelasimbolos.PONTO_VIRGULA) {

            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
        } else if (this.simbolo.token == this.tabelasimbolos.READLN) {
            CasaToken(this.tabelasimbolos.READLN);
            CasaToken(this.tabelasimbolos.PARENTESES_ABERTO);
            CasaToken(this.tabelasimbolos.identificador);
            CasaToken(this.tabelasimbolos.PARENTESES_FECHADO);
            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
        } else if (this.simbolo.token == this.tabelasimbolos.WRITE) {
            // System.out.println("antes do G");
            CasaToken(this.tabelasimbolos.WRITE);
            G();
            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
        } else if (this.simbolo.token == this.tabelasimbolos.WRITELN) {

            CasaToken(this.tabelasimbolos.WRITELN);
            G();
            // System.out.println("CASA TOKEN ;;;;;;;;;;");

            CasaToken(this.tabelasimbolos.PONTO_VIRGULA);
            // System.out.println("TESTE: PEGA ;");

        } else {
            // System.out.println("ELSE");
            // Caso nenhum token seja os que o B espera
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha);
                System.out.println("fim de arquivo nao esperado.");
                System.exit(0);
            } else {
                // System.out.println("TNE B");
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");

                System.exit(0);
            }
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica B -> id = F; |
     * For id=F to F [step num] do (B|'{'{B}'}') | if F then (B|'{'{B}'}') [else
     * (B|'{'{B}'}')] | ; | readln'('id')'; | write(G); | writeln(G);
     */

    public void G() {
        // System.out.println("G simbolo token: " + this.simbolo.token);
        if (this.simbolo.token == this.tabelasimbolos.MAIS || this.simbolo.token == this.tabelasimbolos.MENOS
                || this.simbolo.token == this.tabelasimbolos.NOT || this.simbolo.token == this.tabelasimbolos.constante
                || this.simbolo.token == this.tabelasimbolos.CHAR
                || this.simbolo.token == this.tabelasimbolos.PARENTESES_ABERTO
                || this.simbolo.token == this.tabelasimbolos.identificador) {
            F();
        }
        // if(this.simbolo.token == this.tabelasimbolos.VIRGULA){
        // System.out.println("IF DO G");
        // CasaToken(this.tabelasimbolos.VIRGULA);
        // G();
        // }
    }

    /***************************************
     * Expressao
     ************************************/
    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica F -> H (= | <>
     * |<| > |<= | >=) H
     */
    public void F() {
        H();
        if (this.simbolo.token == this.tabelasimbolos.IGUAL) {
            CasaToken(this.tabelasimbolos.IGUAL);
            H();
        } else if (this.simbolo.token == this.tabelasimbolos.DIFERENTE) {
            CasaToken(this.tabelasimbolos.DIFERENTE);
            H();
        } else if (this.simbolo.token == this.tabelasimbolos.MAIOR) {
            CasaToken(this.tabelasimbolos.MAIOR);
            H();
        } else if (this.simbolo.token == this.tabelasimbolos.MENOR) {
            CasaToken(this.tabelasimbolos.MENOR);
            H();
        } else if (this.simbolo.token == this.tabelasimbolos.MENOR_IGUAL) {
            CasaToken(this.tabelasimbolos.MENOR_IGUAL);
            H();
        } else if (this.simbolo.token == this.tabelasimbolos.MAIOR_IGUAL) {
            CasaToken(this.tabelasimbolos.MAIOR_IGUAL);
            H();
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica H -> [+|-]I {(+ |
     * - | 'or')I}
     */
    public void H() {
        if (this.simbolo.token == this.tabelasimbolos.MAIS) {
            CasaToken(this.tabelasimbolos.MAIS);
        } else if (this.simbolo.token == this.tabelasimbolos.MENOS) {
            CasaToken(this.tabelasimbolos.MENOS);
        }
        I();
        while (this.simbolo.token == this.tabelasimbolos.MAIS || this.simbolo.token == this.tabelasimbolos.MENOS
                || this.simbolo.token == this.tabelasimbolos.OR) {
            if (this.simbolo.token == this.tabelasimbolos.MAIS) {
                CasaToken(this.tabelasimbolos.MAIS);
                I();
            } else if (this.simbolo.token == this.tabelasimbolos.MENOS) {
                CasaToken(this.tabelasimbolos.MENOS);
                I();
            } else if (this.simbolo.token == this.tabelasimbolos.OR) {
                CasaToken(this.tabelasimbolos.OR);
                I();
            }
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica I -> J{(* | 'and'
     * | / | %)J}
     */
    public void I() {
        J();
        while (this.simbolo.token == this.tabelasimbolos.ASTERISCO || this.simbolo.token == this.tabelasimbolos.BARRA
                || this.simbolo.token == this.tabelasimbolos.PORCENTAGEM
                || this.simbolo.token == this.tabelasimbolos.AND) {
            if (this.simbolo.token == this.tabelasimbolos.ASTERISCO) {
                CasaToken(this.tabelasimbolos.ASTERISCO);
                J();
            } else if (this.simbolo.token == this.tabelasimbolos.BARRA) {
                CasaToken(this.tabelasimbolos.BARRA);
                J();
            } else if (this.simbolo.token == this.tabelasimbolos.PORCENTAGEM) {
                CasaToken(this.tabelasimbolos.PORCENTAGEM);
                J();
            } else if (this.simbolo.token == this.tabelasimbolos.AND) {
                CasaToken(this.tabelasimbolos.AND);
                J();
            }
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica J -> (K | not K)
     */
    public void J() {
        if (this.simbolo.token == this.tabelasimbolos.NOT) {
            CasaToken(this.tabelasimbolos.NOT);
            K();
        } else if (this.simbolo.token == this.tabelasimbolos.PARENTESES_ABERTO) {
            K();
        } else if (this.simbolo.token == this.tabelasimbolos.constante) {
            K();
        } else if (this.simbolo.token == this.tabelasimbolos.identificador) {
            K();
        }
    }

    /**
     * Metodo correspondente ao simboolo nao-terminal da gramatica K -> num | _char
     * | '('F')' | id
     */
    public void K() {
        if (this.simbolo.token == this.tabelasimbolos.PARENTESES_ABERTO) {
            CasaToken(this.tabelasimbolos.PARENTESES_ABERTO);
            F();
            if (this.simbolo.token == this.tabelasimbolos.VIRGULA) {
                // System.out.println("ENTRA NA VIRGULA");
                CasaToken(this.tabelasimbolos.VIRGULA);
                G();
            }
            // F();
            CasaToken(this.tabelasimbolos.PARENTESES_FECHADO);
        } else if (this.simbolo.token == this.tabelasimbolos.constante) {
            CasaToken(this.tabelasimbolos.constante);
        } else if (this.simbolo.token == this.tabelasimbolos.identificador) {
            CasaToken(this.tabelasimbolos.identificador);
        } else if (this.simbolo.token == this.tabelasimbolos.CHAR) {
            CasaToken(this.tabelasimbolos.CHAR);
        } else {
            // Caso nenhum token seja os que o F espera
            if (analisadorlexico.fimDeArquivo) {
                System.out.println(analisadorlexico.linha);
                System.out.println("fim de arquivo nao esperado.");
                System.exit(0);
            } else {
                // System.out.println("TNE K");
                System.out.println(analisadorlexico.linha + "\ntoken nao esperado [" + this.simbolo.lexema + "].");

                System.exit(0);
            }
        }
    }
}
