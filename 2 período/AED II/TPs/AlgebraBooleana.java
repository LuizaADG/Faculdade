public class AlgebraBooleana {
    /*************************************************************************************
     * A resolucao do exercicio consiste em buscar a menor operacao da string,
     * resolve-la, e remontar a string original substituindo o enunciado da operacao
     * por seu resultado. O processo se repete ate que nao hajam mais operacoes
     ***********************************************************************************/
    public static void main(String[] args) {
        String str = MyIO.readLine();

        while (!equals(str, "0")) {
            boolean output = false;

            boolean[] inputs = new boolean[Character.getNumericValue(str.charAt(0))];
            for (int i = 0, p = 2; i < inputs.length; i++, p+=2)
                inputs[i] = str.charAt(p) == '1';

            while (contains(str, '(')) {
                int[] indexes = operationSubstring(str);
                String operationSubstring = substring(str ,indexes[0], indexes[1]);
                
                char tipo = operationSubstring.charAt(indexOf(operationSubstring, '(') - 1);
                output = evaluate(tipo, getOperands(operationSubstring, inputs));

                if (output)
                    str = replace(str, indexes[0], indexes[1], '1');
                else
                    str = replace(str, indexes[0], indexes[1], '0');
            }

            if (output)
                MyIO.println("1");
            else
                MyIO.println("0");

            str = MyIO.readLine();
        }
    }

    /****************************************************************************
     * O metodo operationSubstring retorna o index inicial e o index final de uma
     * substring que corresponde a uma unica operacao booleana da string original
     *
     * Ele e a base da classe, pois sempre retorna uma string com uma formatacao
     * padronizada no estilo: operacaoBooleana(operando1, operando2)
     ***************************************************************************/
    public static int[] operationSubstring(String str) {
        int indexOfStart;
        int indexOfEnd = str.length() - 1;
        int recuo = 0;
        int i;

        for (i = str.length() - 2; i > 0 && str.charAt(i) != '('; i--) {
            if (str.charAt(i) == ')') {
                indexOfEnd = i;
            }
        }

        indexOfStart = i;

        switch (str.charAt(indexOfStart - 1)) {
            case 't':
                recuo = 3;
                break;
            case 'd':
                recuo = 3;
                break;
            case 'r':
                recuo = 2;
                break;
        }

        indexOfStart -= recuo;

        return new int[]{indexOfStart, indexOfEnd};
    }

    /****************************************************************************
     * O metodo getOperands recebe a substring gerada por operationSubstring e
     * os inputs iniciais, providenciados pelo Verde.
     *
     * O metodo, entao, retorna os operandos descritos na forma de um array de
     * booleans. Essencialmente, a string recebida de operationSubstring
     * agora tem um formato como: operacaoBooleana(true, true)
     ****************************************************************************/
    public static boolean[] getOperands(String str, boolean[] inputs) {
        String operandIdentifiers = "";
        for (int i = 0; i < str.length() - 1; i++)
            if (Character.isUpperCase(str.charAt(i)) || Character.isDigit(str.charAt(i)))
                operandIdentifiers = operandIdentifiers + str.charAt(i);

        boolean[] operands = new boolean[operandIdentifiers.length()];

        for (int i = 0; i < operandIdentifiers.length(); i++) {
            if (Character.isLetter(operandIdentifiers.charAt(i)))
                operands[i] = inputs[operandIdentifiers.charAt(i) - 'A'];
            else
                operands[i] = (operandIdentifiers.charAt(i) == '1');
        }

        return operands;
    }

    /********************************************************************************
     * O metodo evaluate finalmente retorna o resultado da operacao. Ele recebe
     * apenas um caractere para indicar o tipo da operacao a ser realizada no array
     * de booleans fornecido por getOperands, e o array em si
     ********************************************************************************/
    public static boolean evaluate(char tipo, boolean[] localInputs) {
        /*Inicializacao da variavel 'resultado' e redundante, visto que os inputs
         *fornecidos pelo Verde sao consistentes e sempre disparam um dos 3 cases,
         *mas o compilador me enche o raio do saco se nao inicializar*/

        boolean resultado = false;
        int initialSize = localInputs.length;

        switch (tipo) {
            //Last letter of 'not'
            case 't':
                resultado = !localInputs[0];
                break;

            //Last letter of 'or'
            case 'r':
                for (int i = initialSize - 1; i > 0; i--) {
                    resultado = localInputs[i] || localInputs[i - 1];
                    localInputs[i] = resultado;
                    localInputs[i-1] = resultado;
                }
                break;

            //Last letter of 'and'
            case 'd':
                for (int i = initialSize - 1; i > 0; i--) {
                    resultado = localInputs[i] && localInputs[i - 1];
                    localInputs[i] = resultado;
                    localInputs[i-1] = resultado;
                }
                break;
        }
        return resultado;
    }

    /************************************************************
     * Metodo substituto para String.equals()
     * Recebe como parametro as duas strings a serem comparadas
     ************************************************************/
    public static boolean equals(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) != str1.charAt(i))
                return false;

        return true;
    }

    /************************************************
     * Metodo substituto para String.contains()
     * Recebe como parametro a string a ser buscada
     * e o char que se deseja pesquisar
     ***********************************************/
    public static boolean contains(String str, char c) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == c)
                return true;

        return false;
    }

    /*****************************************************************
     * Metodo substituto para String.substring()
     * Recebe como parametro alem da string, os indexes
     * de comeco e do fim da substring desejada
     * (Ao contrario do metodo original, ambos indexes sao inclusivos)
     ******************************************************************/
    public static String substring(String str, int i1, int i2) {
        String s = "";

        for(int i = i1; i <= i2; i++)
            s = s + str.charAt(i);

        return s;
    }

    /*************************************************************
     * Metodo substituto para String.replace()
     * Recebe como parametro a string original,
     * indexes de comeco e termino da parte a ser substituida,
     * e o char que se deseja inserir no lugar da parte delimitada
     *************************************************************/
    public static String replace(String original, int i1, int i2, char c) {
        String s = "";

        for (int i = 0; i < i1; i++)
            s = s + original.charAt(i);

        s = s + c;

        for (int i = i2 + 1; i < original.length(); i++)
            s = s + original.charAt(i);

        return s;
    }

    /***********************************************
     * Metodo substituto para String.indexOf()
     * Retorna -1 caso nao encontre o char desejado
     **********************************************/
    public static int indexOf(String str, char c) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == c)
                return i;
        return -1;
    }
}
