//Data:07/06/17
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
public class Lista16_5
{
   public static void main(String[]args)
   {
      try
      {
        InputStream is = new FileInputStream("exemplo.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine(); // lê a primeira linha 
        while (str != null) 
        {
           System.out.println(str);
    	     str = br.readLine();
        }//fim de while
        br.close();
      }//fim de try
      catch(IOException ioexception)
      {
          System.err.println(ioexception);
      }//fim de catch
   }//fim de main   
}//fim da classe   