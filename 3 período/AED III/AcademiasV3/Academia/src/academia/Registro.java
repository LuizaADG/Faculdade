package academia;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author wisney
 */
abstract class Registro {
    protected int COD;
    private static String nomeArquivo;
    private boolean existe;

    public int getCOD() {
        return this.COD;
    }


    public abstract int getByte();
    public abstract String toString();
    public abstract String toStringNumbers();
    public abstract void escreveObjeto(RandomAccessFile arq) throws IOException;
    public abstract void lerObjeto(RandomAccessFile arq) throws IOException;

    /*Sets*/
    /*Atribui o valor no exite em cada registro -->  sendo assim fala se o registro esta excluido ou não*/
    public void setExiste(boolean p_Existe) {
        this.existe = p_Existe;
    }
    /*Registra o nome do arquivo que sera utilizado para armazenar os dados*/

    public void setNomeArquivo(String p_nomeArquivo) {
        Registro.nomeArquivo = p_nomeArquivo;
    }

    /*Gets*/
    /*Retorna o valor do exite*/
    public boolean getExiste() {
        return this.existe;
    }
    /*Retorna o nome do arquivo que sera utilizado para armazenar os dados*/

    public String getNomeArquivo() {
        return Registro.nomeArquivo;
    }

    /*Retorna o valor do ultimo código e aumenta 1 {O ultimo código fica na pos 0 do arq}*/
    public int getUltimocodigo(RandomAccessFile arq) throws Exception {
        arq.seek(0);
        int id = arq.readInt();
        arq.seek(0);
        arq.writeInt(id + 1);
        return id;
    }
    

}
