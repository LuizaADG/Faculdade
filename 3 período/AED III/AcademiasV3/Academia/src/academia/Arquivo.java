package academia;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {
    //Variaveis globais

    private File arq;
    private RandomAccessFile raf;
    

    private void existArquivo(Registro registro) throws Exception {//Cria o arquivo se não estiver criado
        arq = new File(registro.getNomeArquivo());                 //Caso não esteja criado, ele cria o arquivo e coloca um inteiro 0, será o ID
        if (!arq.exists()) {
            arq.createNewFile();
            raf = new RandomAccessFile(arq, "rw");
            raf.seek(0);
            raf.writeInt(0);
            raf.close();
        }
    }

    /*Método que retorna o acesso do File da classe arquivo, usado para o set dos metodos que precisam acessar o arquivo*/
    public RandomAccessFile getAccess(Registro registro) {
        try {
            existArquivo(registro);
            raf = new RandomAccessFile(arq, "rw");
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return raf;
    }

    /*Método gerado para inserir um registro no arquivo - recebe uma classe registro e inclui no arq do registro*/
    public void incluiArq(Registro registro) {
        try {
            existArquivo(registro);
            raf = new RandomAccessFile(arq, "rw");
            raf.seek(raf.length());
            registro.escreveObjeto(raf);
            raf.close();
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Método que mostra na tela todos os arquivos já inseridos que não fotam excluidos, ou seja, boolean exite = true*/
    public void listarArq(Registro registro) {
        try {
            existArquivo(registro);
            raf = new RandomAccessFile(arq, "rw");
            raf.seek(4);
            long pos = 4;
            while (pos < raf.length()) {
                registro.lerObjeto(raf);
                pos = pos + registro.getByte();
                if (registro.getExiste()) {
                    System.out.println(registro.toString());
                }
            }
            raf.close();
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Método que mostra na tela o arquivo que existe o código a chave "Código"*/
    public void mostraRegistro(Registro registro, int codigo) {
        try {
            existArquivo(registro);
            raf = new RandomAccessFile(arq, "rw");
            long aux = pegaporCodigo(registro, codigo);
            if (aux < 0) {
                System.out.println("Não existe o registro com o código informado!");
                return;
            }
            raf.seek(aux);
            registro.lerObjeto(raf);
            if (registro.getExiste()) {
                System.out.println(registro.toString());
            }
            raf.close();
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Método que retorna um long, posição onde vai iniciar a leitura do Registro*/
    public long pegaporCodigo(Registro registro, int codigo) throws FileNotFoundException, IOException{
        raf = new RandomAccessFile(arq,"rw");
        raf.seek(4);
        boolean achou = false;
        long posicao = 0;
        int code;
        while(!achou && raf.getFilePointer() < raf.length()){
            code = raf.readInt();
            if(code == codigo){
                posicao = (raf.getFilePointer() - 4);
                achou = true;
            }else{
                posicao = -1;
            }// End else
            raf.seek(raf.getFilePointer() - 4);
            registro.lerObjeto(raf);
        }// End while()
        return posicao;
    }// End remover
    
    /*Método que deleta o registro que foi cadastrado, recebe como paramentro um código*/
    public void apagaRegistro(Registro registro, int codigo) {
        try{
            long posicao = pegaporCodigo(registro, codigo);
            if(posicao < 0){
                System.out.println("Não existe o registro com o código informado!");
                return;
            }
            else{
                raf = new RandomAccessFile(arq,"rw");
                raf.seek(posicao);
                raf.readInt();
                raf.writeBoolean(false);
            }
        }catch(Exception e){
        }
        
    }

}
