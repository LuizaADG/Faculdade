import java.util.Scanner;
public class AreaCirculo
{
   public static void main (String[]args)
   {
   Scanner r= new Scanner(System.in);
   double raio,
          pi,
          area;
   raio= r.nextDouble();
   pi=3.14;
   area=pi*raio*raio;
   System.out.print(area);
   }
}          