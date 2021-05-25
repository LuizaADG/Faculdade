import java.net.*;
import java.io.*;
import java.util.*; 
public class UDPClient{
    public static void main(String args[]){ 
        // args give message contents and destination hostname
        DatagramSocket aSocket = null;
		try {
           
			aSocket = new DatagramSocket();    
			InetAddress aHost = InetAddress.getByName(args[0]);
            int serverPort = 6789;
            File arquivo = new File("quotes.txt");
            Scanner sc = new Scanner(arquivo);
            String strEnvio = "";
            while(sc.hasNext()){
                strEnvio = strEnvio+sc.nextLine();
              }
            byte[] bytEnvio = strEnvio.getBytes();	
            DatagramSocket socket = new DatagramSocket();      
            socket.setSoTimeout(3000); 
            boolean continueSending = true;
            int counter = 0;
            while (continueSending && counter < 10) {                                      
			DatagramPacket request =
                 new DatagramPacket(bytEnvio,  bytEnvio.length, aHost, serverPort);
                aSocket.send(request);			                        
                byte[] buffer = new byte[1000];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
                aSocket.receive(reply);
                continueSending = false;
                System.out.println("Reply: " + new String(reply.getData()));
                counter++;	
            }
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}