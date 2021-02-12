import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;  
import java.util.Scanner;

public class Cliente 
{    

	// Constantes
    private static final String IP_SERVIDOR = "127.0.0.1";
    private static final int PORTA_SERVIDOR = 6789;

	// Variaveis de controle de conexao e fluxo
    private Socket conexao;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    // Variaveis para trocar mensagens com o servidor
    private String mensagem = "";
    
	/**
	 * Metodo usado para iniciar o backend do Cliente.
	 */
    public void inicializar()
    {
        try
        {
            /****Conectar ao servidor*****/
            System.out.println("Tentando conectar ao servidor...");
	        this.conexao = new Socket(InetAddress.getByName(IP_SERVIDOR), PORTA_SERVIDOR);
            System.out.println("Conectado a: " + this.conexao.getInetAddress().getHostName());
            
            /*****Criação de fluxos****/
            this.output = new ObjectOutputStream(this.conexao.getOutputStream());
            this.output.flush();
            this.input = new ObjectInputStream(this.conexao.getInputStream());
            System.out.println("Fluxos de entrada e saida prontos!");

            /****Conectado****/
            do
            {
                    Scanner scanner = new Scanner(System.in);
                    try{
                        // Obter as perguntas da eleição
                        for(int i=0;i<4;i++){
                            String respostaServidor = (String)this.input.readObject();
                            System.out.println("Mensagem recebida do servidor: " + respostaServidor);
                        }
                        int voto = scanner.nextInt();//scannear do prompt
                        this.enviarMsgParaServidor(output,voto);
                    }catch(ClassNotFoundException cnfe)
                    {
                        System.out.println("Algo deu errado");
                    }
                    catch(IOException ioe)
                    {
                        break;
                    }
             
            }while(!mensagem.equals("[SERVER] - END"));
        
        }
        catch(EOFException eofe)
        {
            System.out.println("Cliente finalizou a conexão!");
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
            fechar();
        }
    }
    
    /**
     * Fechar a conexao e os fluxos com o servidor
     */
    private void fechar()
    {
        System.out.println("Fechando conexão...");
        try
        {
            this.output.close();
            this.input.close();
            this.conexao.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
        
    private void enviarMsgParaServidor(ObjectOutputStream output, int voto)
    {
        try
        {
            this.output.writeObject(voto);
            this.output.flush();
            System.out.println("[CLIENTE] - Mensagem enviada para o servidor: " + voto);
        }
        catch(IOException ioe)
        {
            System.out.println("Algo deu errado ao enviar o voto");
        }
    }   

	public static void main(String args[]) 
    {
        Cliente cliente = new Cliente();
        
        cliente.inicializar(); // Inicializando a conexao com o servidor
        
    } // fim main()
 
} // fim Cliente