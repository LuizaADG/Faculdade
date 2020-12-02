import java.util.Scanner;
public class AreaRetangulo
{
   public static void main (String[]args)
   {
   double lado1,
          lado2,
          area;
   Scanner s= new Scanner(System.in);
   System.out.println("Insira lado1");
   lado1=s.nextDouble();
   System.out.println("Insira lado2");
   lado2=s.nextDouble();
   System.out.println("Seu resultado é:");
   area=(lado1)*(lado2);
   System.out.print(area);
   }
}          