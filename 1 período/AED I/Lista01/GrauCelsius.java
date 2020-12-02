import java.util.Scanner;
public class GrauCelsius
{
   public static void main(String[] args)
   {
      Scanner leia = new Scanner (System.in);
      double Farenheit,
          Celsius;
      Farenheit= leia.nextDouble();
      Celsius=(5.0/9)*(Farenheit)-32;
      System.out.print(Celsius);
   }
}              