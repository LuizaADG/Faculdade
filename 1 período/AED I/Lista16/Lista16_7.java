//Data:07/06/17
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class Lista16_7
{
   public static void main(String[]args)
   {
      File novo=new File ("novo.txt");
      try (FileWriter fw= new FileWriter(novo))
      {
         fw.write("Olá");
         fw.write("Mundo");
         fw.flush();
         numeroCaracteres("novo.txt");
      }
      catch (IOException ioException)
      {
         System.out.print(ioException);
      }   
   }//fim de main
   public static void numeroCaracteres(String nomeArq)
   {
      File novo = new File(nomeArq);
      int soma=0;
      try( FileReader fr = new FileReader(novo) )//lê o arquivo
      {
         int  s = fr.read();
         while( s != -1)//enquanto o arquivo não acaba
            {
                soma++;
                s--;
            } //fim de while
      System.out.print(soma); 
      } 
      catch(IOException ioException)
      {
         System.out.print(ioException);
      }      
   }//fim de numeroCaracteres
}//fim da classe