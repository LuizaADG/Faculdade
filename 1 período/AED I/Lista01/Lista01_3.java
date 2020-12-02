import java.util.Scanner;
public class Lista01_3
{
   public static void main (String [] args)
   {
      Scanner s= new Scanner (System.in);
      double altura,
             peso;
      altura=s.nextDouble();
      peso= (72.7*altura)-58;
      System.out.print("O peso ideal é"+peso);
   }   
}             