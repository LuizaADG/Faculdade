package academia;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Registro {

    private int m_ClienteID;
    private String m_Nome;
    private String m_Email;
    private char m_Sexo;
    private String m_Login;
    private String m_Senha;
    private long m_DataNascimento;
    private String m_Logradouro;
    private int m_NumeroResidencia;
    private String m_Complemento;
    private String m_Bairro;
    private String m_CEP;
    private String m_Cidade;
    private String m_Estado;
    private String m_Pais;

    /**
     * Construtores 1) Construtor incompleto sem dados do cliente -> existe =
     * false 2) Construtor incompleto/ com os dados principais -> existe = true;
     * 3) Construtor completo, todos os parametros est�o sendo recebidos ->
     * existe = true;
     */
    Cliente() {
        setExiste(false);
        setNome("");
        setEmail("");
        setSexo(' ');
        setLogin("");
        setSenha("");
        setDataNascimento(0);
        setLogradouro("");
        setNumeroResidencia(0);
        setComplemento("");
        setBairro("");
        setCEP("");
        setCidade("");
        setEstado("");
        setPais("");
        setNomeArquivo("Cliente.db");
    }

    Cliente(String nome, String email, char sexo, String login, String senha) {
        setExiste(true);
        setNome(nome);
        setEmail(email);
        setSexo(sexo);
        setLogin(login);
        setSenha(senha);
        setDataNascimento(0);
        setLogradouro("");
        setNumeroResidencia(0);
        setComplemento("");
        setBairro("");
        setCEP("");
        setCidade("");
        setEstado("");
        setPais("");
        setNomeArquivo("Cliente.db");
    }

    Cliente(Arquivo arquivo, String nome, String email, char sexo, String login, String senha, long nascimento, String logradouro,
            int numero, String complemento, String bairro, String cep, String cidade, String estado, String pais) {
        setClienteID(arquivo);
        setExiste(true);
        setNome(nome);
        setEmail(email);
        setSexo(sexo);
        setLogin(login);
        setSenha(senha);
        setDataNascimento(nascimento);
        setLogradouro(logradouro);
        setNumeroResidencia(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCEP(cep);
        setCidade(cidade);
        setEstado(estado);
        setPais(pais);
        setNomeArquivo("Cliente.db");
    }

    //Getters   
    public int getClienteID() {
        return m_ClienteID;
    }

    public String getNome() {
        return m_Nome;
    }

    public String getEmail() {
        return m_Email;
    }

    public char getSexo() {
        return m_Sexo;
    }

    public String getLogin() {
        return m_Login;
    }

    public long getDataNascimento() {
        return m_DataNascimento;
    }

    public String getDataNascimentoString() {
        return this.CalculaData(m_DataNascimento);
    }

    public String getSenha() {
        return m_Senha;
    }

    public String getLogradouro() {
        return m_Logradouro;
    }

    public int getNumeroResidencia() {
        return m_NumeroResidencia;
    }

    public String getComplemento() {
        return m_Complemento;
    }

    public String getBairro() {
        return m_Bairro;
    }

    public String getCEP() {
        return m_CEP;
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

    //Setters
    public void setClienteID(Arquivo arquivo) {
        Cliente cliente = new Cliente();
        try {
            this.m_ClienteID = getUltimocodigo(arquivo.getAccess(cliente));
            this.COD = m_ClienteID;
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void setClienteID(int m_ClienteID) {
            this.m_ClienteID = m_ClienteID;
        }

    public void setNome(String m_Nome) {
        this.m_Nome = m_Nome;
    }

    public void setEmail(String m_Email) {
        this.m_Email = m_Email;
    }

    public void setSexo(char m_Sexo) {
        this.m_Sexo = m_Sexo;
    }

    public void setLogin(String m_Login) {
        this.m_Login = m_Login;
    }

    public void setSenha(String m_Senha) {
        this.m_Senha = m_Senha;
    }

    public void setDataNascimento(long m_DataNascimento) {
        this.m_DataNascimento = m_DataNascimento;
    }

    public void setLogradouro(String m_Logradouro) {
        this.m_Logradouro = m_Logradouro;
    }

    public void setNumeroResidencia(int m_NumeroResidencia) {
        this.m_NumeroResidencia = m_NumeroResidencia;
    }

    public void setComplemento(String m_Complemento) {
        this.m_Complemento = m_Complemento;
    }

    public void setBairro(String m_Bairro) {
        this.m_Bairro = m_Bairro;
    }

    public void setCEP(String m_CEP) {
        this.m_CEP = m_CEP;
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

    //_--------------------------------------------------------------------------  
    private boolean ehBissexto(int p_Ano) {
        return (((p_Ano % 4 == 0) || (p_Ano % 400 == 0)) && !(p_Ano % 100 == 0));
    }

    private int getNumDiasMes(int p_Mes, int p_Ano) {
        int v_NumDias = 0;
        switch (p_Mes) {
            case 1:
                v_NumDias = 31;
                break;
            case 2:
                if (ehBissexto(p_Ano)) {
                    v_NumDias = 29;
                } else {
                    v_NumDias = 28;
                }
                break;
            case 3:
                v_NumDias = 31;
                break;
            case 4:
                v_NumDias = 30;
                break;
            case 5:
                v_NumDias = 31;
                break;
            case 6:
                v_NumDias = 30;
                break;
            case 7:
                v_NumDias = 31;
                break;
            case 8:
                v_NumDias = 31;
                break;
            case 9:
                v_NumDias = 30;
                break;
            case 10:
                v_NumDias = 31;
                break;
            case 11:
                v_NumDias = 30;
                break;
            case 12:
                v_NumDias = 31;
                break;
        }
        return v_NumDias;
    }

    public long CalculaData(String p_Data) {
        String[] v_Data = p_Data.split("/");
        long v_DataLong = 0;
        if (v_Data.length == 3) {
            v_DataLong = CalculaData(Integer.parseInt(v_Data[0]), Integer.parseInt(v_Data[1]), Integer.parseInt(v_Data[2]));
        }
        return v_DataLong;
    }

    private long CalculaData(int p_Dia, int p_Mes, int p_Ano) {
        int v_AnoBase = 1900;
        int v_MesBase = 01;
        int v_DiaBase = 01;
        long v_NumeroDias = -1;
        if ((0 < p_Mes && p_Mes <= 12)
                && (0 < p_Dia && p_Dia <= getNumDiasMes(p_Mes, p_Ano))
                && p_Ano > v_AnoBase) {
            v_NumeroDias = 1;
            while (v_AnoBase != p_Ano) {
                if (ehBissexto(v_AnoBase)) {
                    v_NumeroDias += 366;
                } else {
                    v_NumeroDias += 365;
                }
                v_AnoBase++;
            }

            while (v_MesBase < p_Mes) {
                v_NumeroDias += this.getNumDiasMes(v_MesBase, p_Ano);
                v_MesBase++;
            }

            while (v_DiaBase < p_Dia) {
                v_NumeroDias++;
                v_DiaBase++;
            }
        }
        return v_NumeroDias;
    }

    private String CalculaData(long p_Data) {
        int v_AnoBase = 1900;
        int v_MesBase = 01;

        while ((p_Data > 366 && ehBissexto(v_AnoBase)) || (p_Data > 365 && !ehBissexto(v_AnoBase))) {
            if (ehBissexto(v_AnoBase)) {
                p_Data -= 366;
            } else {
                p_Data -= 365;
            }
            v_AnoBase++;
        }

        while (p_Data > getNumDiasMes(v_MesBase, v_AnoBase)) {
            p_Data -= getNumDiasMes(v_MesBase, v_AnoBase);
            v_MesBase++;
        }

        String v_Data = p_Data + "/" + v_MesBase + "/" + v_AnoBase;
        return v_Data;
    }

//----------------- Arquivo --------------------------------------------
    public byte[] concatenaArray(byte[] array1, byte[] array2) {
        byte[] array = new byte[array1.length + array2.length];
        int i, j;
        for (i = 0; i < array1.length; i++) {
            array[i] = array1[i];
        }
        for (j = 0; j < array2.length; j++) {
            array[i + j] = array2[i + j];
        }
        return array;
    }

    public String toString(Cliente cliente) {
        return ("\n Codigo: " + cliente.getClienteID()
                + "\n Nome: " + cliente.getNome()
                + "\n E-mail: " + cliente.getEmail()
                + "\n Sexo: " + cliente.getSexo()
                + "\n Login: " + cliente.getLogin()
                + "\n Senha: " + cliente.getSenha()
                + "\n DataNascimento: " + cliente.getDataNascimentoString()
                + "\n Logradouro: " + cliente.getLogradouro()
                + "\n Numero residencial: " + cliente.getNumeroResidencia()
                + "\n Complemento: " + cliente.getComplemento()
                + "\n Bairro: " + cliente.getBairro()
                + "\n CEP: " + cliente.getCEP()
                + "\n Cidade: " + cliente.getCidade()
                + "\n Estado: " + cliente.getEstado()
                + "\n Pais: " + cliente.getPais());
    }

    @Override
    public String toString() {
        return toString(this);
    }

    @Override
    public String toStringNumbers() {
        return ("\n Codigo: " + this.getClienteID()
                + "\n 1  - Nome: " + this.getNome()
                + "\n 2  - E-mail: " + this.getEmail()
                + "\n 3  - Sexo: " + this.getSexo()
                + "\n 4  - Login: " + this.getLogin()
                + "\n 5  - Senha: " + this.getSenha()
                + "\n 6  - DataNascimento: " + this.getDataNascimentoString()
                + "\n 7  - Logradouro: " + this.getLogradouro()
                + "\n 8  - Numero residencial: " + this.getNumeroResidencia()
                + "\n 9  - Complemento: " + this.getComplemento()
                + "\n 10 - Bairro: " + this.getBairro()
                + "\n 11 - CEP: " + this.getCEP()
                + "\n 12 - Cidade: " + this.getCidade()
                + "\n 13 - Estado: " + this.getEstado()
                + "\n 14 - Pais: " + this.getPais());
    }

    @Override
    public int getByte() {
        int m_TamanhoBytes = 4; //COD
        try {
            m_TamanhoBytes += 4; //existe
            m_TamanhoBytes += 32;//ClienteID;
            m_TamanhoBytes += this.m_Nome.getBytes("UTF-8").length;//Nome;
            m_TamanhoBytes += this.m_Email.getBytes("UTF-8").length;//Email;
            m_TamanhoBytes += 4;//Sexo;
            m_TamanhoBytes += this.m_Login.getBytes("UTF-8").length;//Login;
            m_TamanhoBytes += this.m_Senha.getBytes("UTF-8").length;//Senha;
            m_TamanhoBytes += 32;//DataNascimento;
            m_TamanhoBytes += this.m_Logradouro.getBytes("UTF-8").length;//Logradouro;
            m_TamanhoBytes += 4;//NumeroResidencia;
            m_TamanhoBytes += this.m_Complemento.getBytes("UTF-8").length;//Complemento;
            m_TamanhoBytes += this.m_Bairro.getBytes("UTF-8").length; //Bairro
            m_TamanhoBytes += this.m_CEP.getBytes("UTF-8").length; //CEP
            m_TamanhoBytes += this.m_Cidade.getBytes("UTF-8").length; //Cidade
            m_TamanhoBytes += this.m_Estado.getBytes("UTF-8").length; //Estado
            m_TamanhoBytes += this.m_Pais.getBytes("UTF-8").length; //Pais
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return m_TamanhoBytes;
    }

    @Override
    public void lerObjeto(RandomAccessFile arq) throws IOException {
        //arq.readInt();
        setClienteID(arq.readInt());
        setExiste(arq.readBoolean());
        setNome(arq.readUTF());
        setEmail(arq.readUTF());
        setSexo(arq.readChar());
        setLogin(arq.readUTF());
        setSenha(arq.readUTF());
        setDataNascimento(arq.readLong());
        setLogradouro(arq.readUTF());
        setNumeroResidencia(arq.readInt());
        setComplemento(arq.readUTF());
        setBairro(arq.readUTF());
        setCEP(arq.readUTF());
        setCidade(arq.readUTF());
        setEstado(arq.readUTF());
        setPais(arq.readUTF());
    }

    @Override
    public void escreveObjeto(RandomAccessFile arq) throws IOException {
        //arq.writeInt(this.getByte());
        arq.writeInt(this.m_ClienteID);
        arq.writeBoolean(getExiste());
        arq.writeUTF(getNome());
        arq.writeUTF(getEmail());
        arq.writeChar(getSexo());
        arq.writeUTF(getLogin());
        arq.writeUTF(getSenha());
        arq.writeLong(getDataNascimento());
        arq.writeUTF(getLogradouro());
        arq.writeInt(getNumeroResidencia());
        arq.writeUTF(getComplemento());
        arq.writeUTF(getBairro());
        arq.writeUTF(getCEP());
        arq.writeUTF(getCidade());
        arq.writeUTF(getEstado());
        arq.writeUTF(getPais());
    }
}
