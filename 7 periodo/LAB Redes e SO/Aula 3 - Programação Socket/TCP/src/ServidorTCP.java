import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class ServidorTCP
{
	//MÉTODO PRINCIPAL DA CLASSE
	public static void main (String args[])
	{
		try
		{
			int PortaServidor = 7000;
			int n=0;
			//INICIALIZA UM SERVIÇO DE ESCUTA POR CONEXÕES NA PORTA ESPECIFICADA
			System.out.println(" -S- Aguardando conexao (P:"+PortaServidor+")...");
			ServerSocket socktServ = new ServerSocket(PortaServidor);
			while(n<3){
				//ESPERA (BLOQUEADO) POR CONEXÕES			
				Socket conSer = socktServ.accept(); //RECEBE CONEXÃO E CRIA UM NOVO CANAL (p) NO SENTIDO CONTRÁRIO (SERVIDOR -> CLIENTE)
				System.out.println(" -S- Conectado ao cliente ->" + conSer.toString());
			
				//CRIA UM PACOTE DE ENTRADA PARA RECEBER MENSAGENS, ASSOCIADO À CONEXÃO (p)
				ObjectInputStream sServIn = new ObjectInputStream(conSer.getInputStream());
				System.out.println(" -S- Recebendo mensagem...");
				Object msgIn = sServIn.readObject(); //ESPERA (BLOQUEADO) POR UM PACOTE
				System.out.println(" -S- Recebido: " + msgIn.toString());
				
				//CRIA UM PACOTE DE SAÍDA PARA ENVIAR MENSAGENS, ASSOCIANDO-O À CONEXÃO (p)
				ObjectOutputStream sSerOut = new ObjectOutputStream(conSer.getOutputStream());
				sSerOut.writeObject("RETORNO " + msgIn.toString() + " - TCP"); //ESCREVE NO PACOTE
				System.out.println(" -S- Enviando mensagem resposta...");
				sSerOut.flush(); //ENVIA O PACOTE

				//FINALIZA A CONEXÃO
				
				conSer.close();
				System.out.println(" -S- Conexao finalizada...");
				n++;
			}
			socktServ.close();
		}
		catch(Exception e) //SE OCORRER ALGUMA EXCESSÃO, ENTÃO DEVE SER TRATADA (AMIGAVELMENTE)
		{
			System.out.println(" -S- O seguinte problema ocorreu : \n" + e.toString());
		}
	}
}