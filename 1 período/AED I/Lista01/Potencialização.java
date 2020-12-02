import java.util.Scanner;
public class Potencialização
{
   public static void main (String[]args)
   {
   Scanner s= new Scanner (System.in);
   double base,
          expo,
          resultado;
   System.out.println("Insira a base");
   base=s.nextDouble();     
   System.out.println("Insira o expoente");
   expo=s.nextDouble();
   resultado=Math.pow(base,expo);
   System.out.println("O resultado é"+resultado);
   }
}    