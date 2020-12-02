//Data: 07/06/17
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Lista16_2
{
   public static void main(String[]args)
   {      
      File arquivo = new File("exemplo.txt");
      try( FileWriter fw = new FileWriter(arquivo) )
      {
         fw.write("Luiza\n");//coloca no arquivo (exemplo.txt)as informações
         fw.write("587490\n");
         fw.write("33441617\n");
         fw.write("e-mail\n");
         fw.flush();//limpa o buffer
      }//fim de try
      catch(IOException ioException)
      {
         System.out.print(ioException);
      }//fim de catch
   }//fim de main
}//fim da classe   