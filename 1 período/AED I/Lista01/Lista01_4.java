import java.util.Scanner;
public class Lista01_4
{
   public static void main (String [] args)
   {
      Scanner s= new Scanner (System.in);
      double altura,
             peso;
      altura=s.nextDouble();
      peso= (62.1*altura)-44.7;
      System.out.print("O peso ideal é"+peso);
   }   
}              