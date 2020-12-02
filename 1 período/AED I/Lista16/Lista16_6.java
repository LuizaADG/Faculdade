//Data:07/06/17
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class Lista16_6
{
   public static void main(String[]args)
   {
      try
      {
        OutputStream os = new FileOutputStream("exemplo.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("\nPUC Minas");
        bw.write("\nCiencia da Computacao");
        bw.close();
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
      finally
      {
         System.err.println("Excessoes tratadas na main");
      }//fim de finally
   }//fim de main
}//fim da classe         