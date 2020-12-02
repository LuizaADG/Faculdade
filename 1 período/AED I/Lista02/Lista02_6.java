import java.util.Scanner;
public class Lista02_6
{
   public static void main (String []args)
   {
      double x1,
             x2,
             y,
             a,
             b,
             c,
             delta;
      Scanner s=new Scanner(System.in);
      System.out.print("Digite os numeros q multiplicam x²,x e o outro numero da equação de 2ºgrau");
      a=s.nextDouble();
      b=s.nextDouble();
      c=s.nextDouble();
      delta= Math.pow(b,2)-(4*a*c);
      if(delta>=0)
      {
      x1=(-b+(Math.sqrt(delta)))/2*a;
      x2=(-b-(Math.sqrt(delta)))/2*a;
      System.out.print(x1+ "e" +x2);
      }
      else
      {
      System.out.print("Impossivel calcular");
      }
   }
}         
       