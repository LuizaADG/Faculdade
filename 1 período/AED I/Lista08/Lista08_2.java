import java.util.Scanner;
public class Lista08_2
{
   public static void main(String [] args)
   {
      int n;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite um número");
      n=s.nextInt();
      System.out.println(f1(n));
   }
   public static int f1(int n) 
   {
      int f1=0;
      if (n == 0)f1=1;
     else f1=(n * f1(n-1));
     return f1;
   }      
} 