//Data:31/05/17
import java.util.InputMismatchException;//implementa��o da excessa� do tipo incompat�vel
import java.util.Scanner;
public class Lista15_1
{
   public static void main (String[]args)
   {
      Scanner s=new Scanner(System.in);
      double a=0,
             b=0;
      boolean continuaLaco=true;//variavel para continuar caso d� errado    
      do
      {
         try
         {
            System.out.println("Digite o 1 numero");
            a=s.nextDouble();
            System.out.println("Digite o 2 numero");
            b=s.nextDouble();
            System.out.println(a+b);
            continuaLaco=false;//mudar a variavel pois nenhum caractere foi excess�o  
         }//fim de try
         catch(InputMismatchException inputMismatchException)
         {
            System.err.printf("\nException:%s\n",inputMismatchException);
            s.nextLine();
            System.out.println("Somente reais");
         }//fim de catch       
      }while(continuaLaco);//fim do do      
   }
}