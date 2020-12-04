package academia;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Guimarães
 */
public class Modalidades extends Registro {

    private int m_ModalidadesID;
    private String m_Nome;
    private String m_Descricao;
    private String m_Nome_Professor;
    private char m_Turno;

    /*Construtores*/
    public Modalidades() {
        this.setExiste(false);
        this.setNome("");
        this.setDescricao("");
        this.setNomeProfessor("");
        this.setTurno(' ');
    }

    public Modalidades(Arquivo arquivo, String nome, String descricao, String nomeProfessor, char turno) {
        this.setModalidadeID(arquivo);
        this.setExiste(true);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setNomeProfessor(nomeProfessor);
        this.setTurno(turno);
        setNomeArquivo("Modalidade.db");

    }


    /*Getters*/
    public int getModalidadeID() {
        return this.m_ModalidadesID;
    }

    public String getNome() {
        return this.m_Nome;
    }

    public String getDescricao() {
        return this.m_Descricao;
    }

    public String getNomeProfessor() {
        return this.m_Nome_Professor;
    }

    public char getTurno() {
        return this.m_Turno;
    }
    /*Setters*/

    public void setModalidadeID(Arquivo arquivo) {
        Modalidades modalidade = new Modalidades();
        try {
            this.m_ModalidadesID = getUltimocodigo(arquivo.getAccess(modalidade));
            this.COD = m_ModalidadesID;
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setModalidadeID(int m_modalidadesID) {
        this.m_ModalidadesID = m_modalidadesID;
    }

    public void setNome(String nome) {
        this.m_Nome = nome;
    }

    public void setDescricao(String descricao) {
        this.m_Descricao = descricao;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.m_Nome_Professor = nomeProfessor;
    }

    public void setTurno(char turno) {
        this.m_Turno = turno;
    }

    @Override
    public int getByte() {
        int m_TamanhoBytes = 4; //COD
        try {
            m_TamanhoBytes += 4; //existe
            m_TamanhoBytes += 32;//ModalidadeID;
            m_TamanhoBytes += this.m_Nome.getBytes("UTF-8").length;//Nome;
            m_TamanhoBytes += this.m_Descricao.getBytes("UTF-8").length;//Descricao;
            m_TamanhoBytes += this.m_Nome_Professor.getBytes("UTF-8").length;//Nome Professor
            m_TamanhoBytes += 4;//Turno;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return m_TamanhoBytes;
    }

    @Override
    public String toString() {
        return ("\n Codigo: " + this.getModalidadeID()
                + "\n Nome: " + this.getNome()
                + "\n Descrição: " + this.getDescricao()
                + "\n Professor: " + this.getNomeProfessor()
                + "\n Turno: " + this.getTurno());
    }

    @Override
    public String toStringNumbers() {
        return ("\n1 - Codigo: " + this.getModalidadeID()
                + "\n2 - Nome: " + this.getNome()
                + "\n3 - Descrição: " + this.getDescricao()
                + "\n4 - Professor: " + this.getNomeProfessor()
                + "\n5 - Turno: " + this.getTurno());

    }

    @Override
    public void escreveObjeto(RandomAccessFile arq) throws IOException {
        arq.writeInt(this.getModalidadeID());
        arq.writeBoolean(this.getExiste());
        arq.writeUTF(this.getNome());
        arq.writeUTF(this.getDescricao());
        arq.writeUTF(this.getNomeProfessor());
        arq.writeChar(this.getTurno());

    }

    @Override
    public void lerObjeto(RandomAccessFile arq) throws IOException {
        setModalidadeID(arq.readInt());
        setExiste(arq.readBoolean());
        setNome(arq.readUTF());
        setDescricao(arq.readUTF());
        setNomeProfessor(arq.readUTF());
        setTurno(arq.readChar());
    }

}
