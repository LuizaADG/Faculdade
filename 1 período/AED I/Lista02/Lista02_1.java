import java.util.Scanner;
public class Lista02_1
{
   public static void main (String[]args)
   {
      int A;
      boolean Ehpar;
      Scanner s= new Scanner(System.in);
      System.out.print("Escreva um número");
      A= s.nextInt();
      Ehpar=A%2==0;
      if(Ehpar)
         {
         System.out.println("O número"+A+"é par");
         } 
      else
         {
         System.out.println(" O número"+A+"é ímpar");
         }
   }
}             
       