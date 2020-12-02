//Data:07/06/17
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Lista16_3
{
   public static void main(String[]args)
   {      
      File arquivo = new File("exemplo.txt");
      try( FileReader fr = new FileReader(arquivo) )//lê o arquivo
      {
         int  c = fr.read();
         while( c != -1)//enquanto o arquivo não acaba
         {
           System.out.print( (char) c );
           c = fr.read();
         } //fim de while
      } //fim de try
      catch(IOException ioException)
      { 
         System.out.print(ioException);
      }//fim de catch
   }//fim de main
}//fim de classe         