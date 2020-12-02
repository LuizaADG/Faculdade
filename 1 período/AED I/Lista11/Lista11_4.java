//Data:04/05/17
//Objetivo: Colocar um arranjo de 5 triangulos e comparar dois deles e um deles com um estático
//Resposta da 4 e 5
import java.util.Scanner;
public class Lista11_4
{
   public static void main (String[]args)
   {
      Scanner s=new Scanner(System.in);
      double []tri={1,1,1};
      Triangulo[]triangulos =new Triangulo[5];//Array que tem os triangulos
      triangulos[0]=new Triangulo("T1",3,4,5);
      triangulos[1]=new Triangulo("T2",6,5,4);
      triangulos[2]=new Triangulo("T3",1,1,1);
      triangulos[3]=new Triangulo("T4",3,4,5);
      triangulos[4]=new Triangulo("T5",8,1,1);
      // 1 triangulo
      System.out.println("No triangulo "+triangulos[0].getTriangulo()+" O primeiro lado= "+triangulos[0].getA()+
                         " O segundo= "+triangulos[0].getB()+
                         " O terceiro = "+triangulos[0].getC());
      System.out.println("O perimetro="+triangulos[0].perimetro());
      System.out.println("O tipo ="+triangulos[0].tipo());   
      // 2 triangulo
      System.out.println("No triangulo "+triangulos[1].getTriangulo()+" O primeiro lado= "+triangulos[1].getA()+
                         " O segundo= "+triangulos[1].getB()+
                         " O terceiro = "+triangulos[1].getC());
      System.out.println("O perimetro="+triangulos[1].perimetro());
      System.out.println("O tipo ="+triangulos[1].tipo());
      // 3 triangulo
      System.out.println("No triangulo "+triangulos[2].getTriangulo()+" O primeiro lado= "+triangulos[2].getA()+
                         " O segundo= "+triangulos[2].getB()+
                         " O terceiro = "+triangulos[2].getC());                                
      System.out.println("O perimetro="+triangulos[2].perimetro());
      System.out.println("O tipo ="+triangulos[2].tipo());   
      // 4 triangulo
      System.out.println("No triangulo "+triangulos[3].getTriangulo()+" O primeiro lado= "+triangulos[3].getA()+
                         " O segundo= "+triangulos[3].getB()+
                         " O terceiro = "+triangulos[3].getC());                                
      System.out.println("O perimetro="+triangulos[3].perimetro());
      System.out.println("O tipo ="+triangulos[3].tipo());
      // 5 triangulo
      System.out.println("No triangulo "+triangulos[4].getTriangulo()+" O primeiro lado= "+triangulos[4].getA()+
                         " O segundo= "+triangulos[4].getB()+
                         " O terceiro = "+triangulos[4].getC());                                
      System.out.println("O perimetro="+triangulos[4].perimetro());
      System.out.println("O tipo ="+triangulos[4].tipo());             
      int c;
      int i;
      do //usuario digita os triangulos que quer comparar
      {
         System.out.println("Digite o numero dos triangulos a serem comparados");
         i=s.nextInt();
         c=s.nextInt();
         if ((c>5&&c<1)||(i>5&&i<1)) System.out.println("Erro");
      }while((c>5&&c<1)||(i>5&&i<1)); 
      if(triangulos[i-1].getA() ==triangulos[c-1].getA())//comparando os triangulos
      {
         if(triangulos[i-1].getB()== triangulos[c-1].getB())
         {
            if(triangulos[i-1].getC()==triangulos[c-1].getC())
            {
               System.out.println("Sao iguais");
            }else{
               System.out.println("Sao diferentes");
            }
         }else{
            System.out.println("Sao diferentes");
         }
      }else{
         System.out.println("Sao diferentes");
      }
      double A=triangulos[0].getA();
      double B=triangulos[0].getB();
      double C=triangulos[0].getC();
      Triangulo.iguais(tri,A,B,C);
   }
}
class Triangulo
{
   private String triangulo;
   private double A;
   private double B;
   private double C;
   public Triangulo(String t, int A, int B, int C)
   {
      setTriangulo(t);
      setA(A);
      setB(B);
      setC(C);
   }
   public void setTriangulo(String t)//método que identifica o triangulo
   {
      this.triangulo=t;
   }
   //método que identifica os lados
   public void setA(int A)
   {
      this.A=A;
   }
   public void setB(int B)
   {
      this.B=B;
   }
   public void setC(int C)
   {
      this.C=C;
   }
   //método para retornar os lados
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
   public String getTriangulo()//método para retornar o nome do triangulo
   {
      return this.triangulo;
   }
   public double perimetro()//método para calcular perímetro
   {
      return getA()+getB()+getC();
   }
   public String tipo()//método para classificar o triangulo
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
            if(getA()!=getC() && getB()!=getC()&& getA()!=getB());
            {
               tipo="escaleno";
            }
         }   
      }   
      return tipo;
   }
   public static void iguais(double[]tri,double A, double B, double C)//método para comparar outros dois triangulos
   {
      System.out.println("Comparacao entre dois triangulos, o estatico e um dos outros.");
      if(A==tri[0])//comparando os triangulos
      {
         if(B== tri[1])
         {
            if(C==tri[2])
            {
               System.out.println("Sao iguais");
            }else{
               System.out.println("Sao diferentes");
            }
         }else{
            System.out.println("Sao diferentes");
         }
      }else{
         System.out.println("Sao diferentes");
      }

   }
}