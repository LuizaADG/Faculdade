import java.util.Scanner;
public class SomaNCubos
{
   public static void main(String[]args)
   {
      Scanner s= new Scanner(System.in);
      double y,
             cubos;
      System.out.println("Digite o numero");
      y=s.nextInt();
      cubos=somaN(y);
      System.out.println(cubos);
   }
   public static double somaN(double y)
   //calcula soma dos cubos começando por 1 até o numero escolhido
   {
      double cubos=0;
      if(y==0)
      {
         cubos=0;
      }else 
      {
         cubos=cubos+Math.pow(y,3)+somaN(y-1);
      }
      return cubos;
   }
}