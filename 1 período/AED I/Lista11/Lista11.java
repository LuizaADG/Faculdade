//Data:04/05/17
//Objetivo: colocar lados no triangulo, calcular perímetro e classificar o triangulo
//Resposta da 1,2 e 3 
import java.util.Scanner;
public class Lista11
{
   public static void main (String[]args)
   {
      Triangulo T;
      T= new Triangulo();
      T.setA();
      T.setB();
      T.setC();
      System.out.println("O primeiro lado= "+T.getA()+"O segundo= "+T.getB()+"O terceiro = "+T.getC());
      System.out.println("O perimetro="+T.perimetro());
      System.out.println("O tipo ="+T.tipo());   
   }
}
//Classe viculada a main
class Triangulo
{
//Decalaração dos lados
   private double A;
   private double B;
   private double C;
//métodos para colocar os lados   
   public void setA()
   {
      Scanner s=new Scanner (System.in);
      System.out.println("Digite o 1 lado do triangulo");
      this.A=s.nextDouble();
   }
   public void setB()
   {
      Scanner s=new Scanner (System.in);
      System.out.println("Digite o 2 lado do triangulo");
      this.B=s.nextDouble();
   }
   public void setC()
   {
      Scanner s=new Scanner (System.in);
      System.out.println("Digite o 3 lado do triangulo");
      this.C=s.nextDouble();
   }
//métodos para retornar ao usuário os lados   
   public double getA()
   {
      return this.A;
   }
   public double getB()
   {
      return this.B;
   }
   public double getC()
   {
      return this.C;
   }
//método para calcular perímetro   
   public double perimetro()
   {
      return getA()+getB()+getC();
   }
//método para classificar o triangulo   
   public String tipo()
   {
      String tipo;
      if(getA()==getB()&&getA()==getC())
      {
         tipo="equilatero";
      }else {
         if((getA()!=getC()||getA()!=getB())&&(getB()==getC() || getA()==getB()||getA()==getC()))
         {
            tipo="isosceles";
         }else
         {
            if(getA()!=getC() && getB()!=getC()&& getA()!=getC());
            {
               tipo="escaleno";
            }
         }   
      }   
      return tipo;
   }
}