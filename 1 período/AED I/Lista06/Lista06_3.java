import java.util.Scanner;
public class Lista06_3
{
   public static void main(String[]args)
   {
      double i,
             n,
          maior;
      n=leia(); 
      i=leia();
      maior=maior(n,i);
      System.out.println("O maior numero= "+maior);    
   }
   public static double maior (double n, double i)
   {
      double maior=n;
      if (i>maior)maior=i;
      return maior;
   }
   public static double leia()
   {
      double x;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite número");
      x=s.nextDouble();
      return x;
   }   
}