//Data:04/06/17
import java.util.InputMismatchException;//implementação da excessaõ do tipo incompatível
import java.util.Scanner;
public class Lista15_3
{
   public static void main(String[]args)
   {
      double a= ler1();//metodo que lê o primeiro numero
      double b=ler2();//metodo que lê o segundo numero
      double soma=soma(a,b);//metodo que soma os numeros
      imprimeSoma(soma);//metodo que imprime o resultado       
   }//fim de main
   public static double ler1()
   {
      boolean continuaLaco=true;//variavel para continuar caso dê errado
      double a=0;
      Scanner s=new Scanner(System.in);
      do
      {
         try
         {
            System.out.println("Digite o 1 numero");
            a=s.nextDouble();
            continuaLaco=false;//mudar a variavel pois nenhum caractere foi excessão
         }//fim de try   
         catch(InputMismatchException inputMismatchException)
         {
               System.err.printf("\nException:%s\n",inputMismatchException);
               s.nextLine();
               System.out.println("Somente reais");
         }//fim de catch
      }while(continuaLaco);//fim do do                
   return a;      
   }//fim de ler1
   public static double ler2()
   {
      boolean continuaLaco=true;//variavel para continuar caso dê errado
      double b=0;
      Scanner s=new Scanner(System.in);
      do
      {
         try
         {
            System.out.println("Digite o 2 numero");
            b=s.nextDouble();
            continuaLaco=false;//mudar a variavel pois nenhum caractere foi excessão
         }//fim de try   
         catch(InputMismatchException inputMismatchException)
         {
               System.err.printf("\nException:%s\n",inputMismatchException);
               s.nextLine();
               System.out.println("Somente reais");
         }//fim de catch
      }while(continuaLaco);//fim do do
   return b;      
   }//fim de ler2
   public static double soma(double x, double z)
   {
      double a=x;
      double b=z;
      double soma=a+b;
      return soma;
   }//fim de soma
   public static void imprimeSoma(double soma)
   {
      System.out.println(soma);
   }//fim de imprimeSoma
}