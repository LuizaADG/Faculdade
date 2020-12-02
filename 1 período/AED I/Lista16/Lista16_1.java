//Data:07/06/17
import java.io.File;
import java.io.IOException;
public class Lista16_1
{
   public static void main(String[]args)
   {      
      File arquivo = new File("exemplo.txt");
      try
      {
         if( arquivo.createNewFile() )//criação do arquivo
          {
            System.out.println("Foi criado o arquivo exemplo.txt");
          }
      }//fim de try
      catch(IOException ioException)
      {
         System.out.print(ioException);
      }//fim de catch
       if( arquivo.exists() )
       {
          System.out.println("Nome: " + arquivo.getName());
          System.out.println("Tamanho: " + arquivo.length());
          System.out.println("Diretorio: "+ arquivo.getPath());
       } //fim de if
       else {
           System.out.println("Arquivo inexistente.");
      }//fim de else
   }//fim de main      	
}//fim da classe   
