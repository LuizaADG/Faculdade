import java.util.Scanner;
public class Lista06_2
{
   public static void main(String[]args)
   {
      int n;
      System.out.println("Digite o numero");             
      Scanner s= new Scanner(System.in);
      n=s.nextInt();
      if (verifica(n))
      {
         System.out.println("O numero e par");
      }else   
      {
         System.out.println("O numero e impar");
      }     
   }
   public static boolean verifica(int n)
   {
      boolean par=false;
      if (n%2==0)par=true;
      return par;
   }      
}   