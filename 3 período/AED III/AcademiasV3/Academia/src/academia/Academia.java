package academia;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiza Ávila
 */
public class Academia extends Registro{

    private int m_AcademiaID;
    private String m_Nome;//nome da academia
    private String m_Logradouro;//nome da rua
    private int m_NumeroAcademia;//numero da academia
    private String m_Complemento;//caso seja em predio
    private String m_Bairro;//bairro 
    private String m_Cidade;//cidade
    private String m_Estado;//estado
    private String m_Pais;//pais
    private int m_Classif;//Classificação da academia de 1 a 5
    //private Modalidades mod
    /*
      Construtores-vazio (existe falso) e com dados (existe verdadeiro)-independentemente se for completo ou não
    */

      Academia(){
        setExiste(false);
        setNome("");
        setLogradouro("");
        setNumeroAcademia(0);
        setComplemento("");
        setBairro("");
        setCidade("");
        setEstado("");
        setPais("");
        setClassif(0);
        setNomeArquivo("Academia.db");//arquivo de dados da academia
      }
      Academia(String nome) {
        setExiste(true);
        setNome(nome);
        setLogradouro("");
        setNumeroAcademia(0);
        setComplemento("");
        setBairro("");
        setCidade("");
        setEstado("");
        setPais("");
        setClassif(0);
        setNomeArquivo("Academia.db");
    }
        Academia(Arquivo arquivo, String nome, String logradouro,int numero, String complemento, String bairro,
                String cidade, String estado, String pais, int classif) {
        setExiste(true);
        setAcademiaID(arquivo);
        setNome(nome);
        setLogradouro(logradouro);
        setNumeroAcademia(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
        setPais(pais);
        setClassif(classif);
        setNomeArquivo("Academia.db");
    }
        public void setAcademiaID(Arquivo arquivo) {
        Academia academia = new Academia();
        try {
            this.m_AcademiaID = getUltimocodigo(arquivo.getAccess(academia));
            this.COD = m_AcademiaID;
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        /*
        Métodos para setar valores de academia
        */
    public void setAcademiaID(int m_AcademiaID) {
            this.m_AcademiaID = m_AcademiaID;
    }

    public void setNome(String m_Nome) {
        this.m_Nome = m_Nome;
    }
    public void setLogradouro(String m_Logradouro) {
        this.m_Logradouro = m_Logradouro;
    }

    public void setNumeroAcademia(int m_NumeroAcademia) {
        this.m_NumeroAcademia = m_NumeroAcademia;
    }

    public void setComplemento(String m_Complemento) {
        this.m_Complemento = m_Complemento;
    }

    public void setBairro(String m_Bairro) {
        this.m_Bairro = m_Bairro;
    }

    public void setCidade(String m_Cidade) {
        this.m_Cidade = m_Cidade;
    }

    public void setEstado(String m_Estado) {
        this.m_Estado = m_Estado;
    }

    public void setPais(String m_Pais) {
        this.m_Pais = m_Pais;
    }
    private void setClassif(int m_Classif) {
        this.m_Classif = m_Classif;
    }
    /*
    Métodos para retornar o valor de cada atribuição
    */
    public int getAcademiaID() {
        return m_AcademiaID;
    }

    public String getNome() {
        return m_Nome;
    }

    public String getLogradouro() {
        return m_Logradouro;
    }

    public int getNumeroAcademia() {
        return m_NumeroAcademia;
    }

    public String getComplemento() {
        return m_Complemento;
    }

    public String getBairro() {
        return m_Bairro;
    }

    public String getCidade() {
        return m_Cidade;
    }

    public String getEstado() {
        return m_Estado;
    }

    public String getPais() {
        return m_Pais;
    }
    public int getClassif() {
        return m_Classif;
    }
    /*
    Método que coleta os bytes de cada academia
    */
    @Override
    public int getByte() {
         int m_TamanhoBytes = 4; //COD
        try {
            m_TamanhoBytes += 4; //existe
            m_TamanhoBytes += 32;//AcademiaID;
            m_TamanhoBytes += this.m_Nome.getBytes("UTF-8").length;//Nome;
            m_TamanhoBytes += this.m_Logradouro.getBytes("UTF-8").length;//Logradouro;
            m_TamanhoBytes += 4;//NumeroAcademia;
            m_TamanhoBytes += this.m_Complemento.getBytes("UTF-8").length;//Complemento;
            m_TamanhoBytes += this.m_Bairro.getBytes("UTF-8").length; //Bairro
            m_TamanhoBytes += this.m_Cidade.getBytes("UTF-8").length; //Cidade
            m_TamanhoBytes += this.m_Estado.getBytes("UTF-8").length; //Estado
            m_TamanhoBytes += this.m_Pais.getBytes("UTF-8").length; //Pais
            m_TamanhoBytes += 4;//Classificação;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return m_TamanhoBytes;
    }
    
    /*
    Métodos para retornar cada uma das características de uma academia
    */
    @Override
    public String toString() {
        return ("\n Codigo: " + this.getAcademiaID()
                + "\n Nome: " + this.getNome()
                + "\n Logradouro: " + this.getLogradouro()
                + "\n Número da Academia: " + this.getNumeroAcademia()
                + "\n Complemento: " + this.getComplemento()
                + "\n Bairro: " + this.getBairro()
                + "\n Cidade: " + this.getCidade()
                + "\n Estado: " + this.getEstado() 
                + "\n País: "   + this.getPais()
                + "\n Classificação: " +this.getClassif());
    }
    /*
   
    */
    @Override
    public String toStringNumbers() {
            return ("\n Codigo: " + this.getAcademiaID()
                + "\n1- Nome: " + this.getNome()
                + "\n2- Logradouro: " + this.getLogradouro()
                + "\n3- Número da Academia: " + this.getNumeroAcademia()
                + "\n4- Complemento: " + this.getComplemento()
                + "\n5- Bairro: " + this.getBairro()
                + "\n6- Cidade: " + this.getCidade()
                + "\n7- Estado: " + this.getEstado() 
                + "\n8- País: "   + this.getPais()
                + "\n9- Classificação: " +this.getClassif());

    }

    @Override
    public void escreveObjeto(RandomAccessFile arq) throws IOException {
        arq.writeInt(this.m_AcademiaID);
        arq.writeBoolean(getExiste());
        arq.writeUTF(getNome());
        arq.writeUTF(getLogradouro());
        arq.writeInt(getNumeroAcademia());
        arq.writeUTF(getComplemento());
        arq.writeUTF(getBairro());
        arq.writeUTF(getCidade());
        arq.writeUTF(getEstado());
        arq.writeUTF(getPais());
        arq.writeInt(getClassif());
    }

    @Override
    public void lerObjeto(RandomAccessFile arq) throws IOException {
        setAcademiaID(arq.readInt());
        setExiste(arq.readBoolean());
        setNome(arq.readUTF());
        setLogradouro(arq.readUTF());
        setNumeroAcademia(arq.readInt());
        setComplemento(arq.readUTF());
        setBairro(arq.readUTF());
        setCidade(arq.readUTF());
        setEstado(arq.readUTF());
        setPais(arq.readUTF());
        setClassif(arq.readInt());
    }
    
}
