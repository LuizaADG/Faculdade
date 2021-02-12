import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;  
import java.util.ArrayList;
import java.util.Scanner;


public class Server
{
    
    private static final int PORTA = 6789;
    private static final int MAXIMO_PESSOAS = 10;

    
    // Manter listas das conexoes e dos fluxos
    private ArrayList<Socket> todasConexoes = new ArrayList<>();
    private ArrayList<ObjectInputStream> listaInput = new ArrayList<>();
    private ArrayList<ObjectOutputStream> listaOutput = new ArrayList<>();
    
    private int quantClientes;
  
    private int quantidadeVotosA;
    private int quantidadeVotosB;
    private int quantidadeVotosC;

    private ServerSocket servidor;       
    
    
    private void inicializarServidor() throws IOException
    {
        System.out.println("Servidor inicializado ...");


            // Criar o socket do servidor para aceitar conexoes de clientes   
            this.servidor = new ServerSocket(Server.PORTA, Server.MAXIMO_PESSOAS);

           /******************Parte de conexão ao servidor do código. Fica parado até conectar, quando um cliente se conecta, 
            * adicionamos ele à lista, criamos uma stream para troca de dados e criamos uma thread para ele************************/
            while (true)
            {
                    try
                    {
                        Socket conexao = this.aguardarConexao();	            
                        this.todasConexoes.add(conexao);
                        this.quantClientes++;
                        ObjectInputStream input = this.criarInputStream(conexao);
                        ObjectOutputStream output = this.criarOutputStream(conexao);
                        this.listaInput.add(input);
                        this.listaOutput.add(output);
                        
                        new Thread(new Runnable()
                            {
                                @Override
                                public void run() {
                                    threadCliente(conexao, input, output);
                                }
                            }).start();

                    }catch(IOException ioe){
                        ioe.printStackTrace();
                    }
            }
    }

    private Socket aguardarConexao() throws IOException
    {
        System.out.println("Esperando cliente...");
        Socket conexao = this.servidor.accept();
        System.out.println("Novo cliente conectado: " + conexao.getInetAddress().getHostName());  
        return conexao;
    }
    
    
    private void threadCliente(Socket conexao, ObjectInputStream input, ObjectOutputStream output)
    {        
        
        this.msg(output, "Voce esta conectado!");
        this.msg(output, "Vote 1 para Charlize Theron");
        this.msg(output, "Vote 2 para Rita Lee");
        this.msg(output, "Vote 3 para Dua Lipa");
        
        while (true)  
        { 
            try 
            { 
				// Receber voto do cliente
				int voto = (int)input.readObject();
				System.out.println("Voto do cliente: " + voto);
                  
                if(voto==1)
                {
                	System.out.println("Voto contabilizado para o Charlize Theron!");
                    this.quantidadeVotosA++;
                }
                else if(voto==2)
                {
                    System.out.println("Voto contabilizado para o Rita Lee!");
                    this.quantidadeVotosB++;
                }
                else if(voto==3)
                {
                	System.out.println("Voto contabilizado para o Dua Lipa!");
                    this.quantidadeVotosC++;
                }
                System.out.println("Total de clientes simultaneos: " + this.quantClientes);
                System.out.println("Quant. votos Charlize Theron: " + quantidadeVotosA);
                System.out.println("Quant. votos Rita Lee: " + quantidadeVotosB);
                System.out.println("Quant. votos Dua Lipa: " + quantidadeVotosC);
            } 
            catch(ClassNotFoundException classNotFoundException)
            {
                System.out.println("Não tratamos isso.");
            }
            catch (IOException ioe)
            { 
            	System.out.println("Algo inesperado aconteceu");
            	break;
            } 
            break;
        }
        
        try
        {
        	// Tentar fechar a conexa e os fluxos de entrada e de saida com o cliente
            this.fecharConexaoCliente(conexao);
            System.out.println("Conexao finalizada!");
		    this.fecharFluxosCliente(input, output);
        }
        catch(EOFException eofe)
        {
        	System.out.println("EOFException: " + eofe.getMessage());
        }
        catch(IOException ioe)
        {
        	System.out.println("IOException: " + ioe.getMessage());
        }
        
        this.quantClientes--;
    }
    
/**Parte de enviar mensagens para o cliente */
	private void msg(ObjectOutputStream output, String mensagem)
    {
        try
        {
        	System.out.println("[SERVER] - Enviando mensagem para o cliente: " + mensagem);
            output.writeObject(mensagem);
            output.flush();
        }
        catch(IOException ioe)
        {
            System.out.println("ERRO: Nao consegui enviar a mensagem");
        }
    }    


    private ObjectOutputStream criarOutputStream(Socket conexao) throws IOException
    {
        ObjectOutputStream output = new ObjectOutputStream(conexao.getOutputStream());
        
        // Limpar a stream antes
        output.flush();
        return output;
    }
    
    
    private ObjectInputStream criarInputStream(Socket conexao) throws IOException
    {
        return new ObjectInputStream(conexao.getInputStream());
    }

    
    private void fecharConexaoCliente(Socket conexao) throws IOException
    {
        System.out.println("Fechando conexão com o cliente...");
        conexao.close();
        this.todasConexoes.remove(conexao);
    }
    
    
    private void fecharFluxosCliente(ObjectInputStream input, ObjectOutputStream output) throws IOException
    {
    	input.close();
    	output.close();
		this.listaInput.remove(input);
		this.listaOutput.remove(output);
    }    
    
    
// ------------------------------ METODO PRINCIPAL ------------------------------

    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
        server.inicializarServidor();
    }
    
}