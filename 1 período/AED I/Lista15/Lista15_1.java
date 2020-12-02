//Data:31/05/17
import java.util.InputMismatchException;//implementação da excessaõ do tipo incompatível
import java.util.Scanner;
public class Lista15_1
{
   public static void main (String[]args)
   {
      Scanner s=new Scanner(System.in);
      double a=0,
             b=0;
      boolean continuaLaco=true;//variavel para continuar caso dê errado    
      do
      {
         try
         {
            System.out.println("Digite o 1 numero");
            a=s.nextDouble();
            System.out.println("Digite o 2 numero");
            b=s.nextDouble();
            System.out.println(a+b);
            continuaLaco=false;//mudar a variavel pois nenhum caractere foi excessão  
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