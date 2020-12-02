import java.util.Scanner;
public class Lista08_4
{
   public static void main(String [] args)
   {
      int n;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite um número");
      n=s.nextInt();
      System.out.println(f2(n));
   }
   public static int f2(int n) 
   {
      int f=0;
      if (n == 0 ||n==1)f=1;
      else f=(f2(n-1)+ 2 *f2(n-2));//O numero -1 +2 vezes o numero-2
      return f;//exemplo: f(4)=11
   }     
}