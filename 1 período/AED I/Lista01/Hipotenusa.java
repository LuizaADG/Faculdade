import java.util.Scanner;
public class Hipotenusa
{
   public static void main (String[]args)
   {
   double base,
          altura,
          quadradobase,
          quadradoaltura,
          hipotenusa;
  Scanner s= new Scanner(System.in);
  System.out.println("Insira a base");
  base=s.nextDouble();
  System.out.println("Insira a altura");
  altura=s.nextDouble();
  System.out.println("O valor da hipotenusa é");
  quadradobase=Math.pow(base,2);
  quadradoaltura=Math.pow(altura,2);
  hipotenusa=Math.sqrt(quadradoaltura+quadradobase);
  System.out.print(hipotenusa);
  }
}           