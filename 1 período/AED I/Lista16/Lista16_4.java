//Data:07/06/17
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;
public class Lista16_4 { 
   public static void main(String[]args)
   {
      lerTexto("exemplo.txt");
   }      
   public static void lerTexto(String nomeArq)
   {
    try  
    { 
        File arquivo = new File(nomeArq); 
        Scanner scanner = new Scanner(arquivo); 
        while(scanner.hasNext())//enquanto tem algo no arquivo 
        { 
          System.out.println(scanner.nextLine()); 
        } //fim de while
        scanner.close(); 
    }//fim de try
    catch (FileNotFoundException fileNotFoundException) 
    { 
        fileNotFoundException.printStackTrace(); 
    } //fim de catch
  } //fim de lerTexto
}//fim da classe LerArquivo