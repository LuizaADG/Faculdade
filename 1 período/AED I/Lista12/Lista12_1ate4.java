import java.util.Scanner;
public class Lista12_1ate4
{
   public static void main (String[]args)
   {
      Scanner s=new Scanner(System.in);
      double []tri={1,1,1};
      Triangulo[]triangulos =new Triangulo[5];//Array que tem os triangulos. Não estático
      triangulos[0]=new Triangulo(3,4,5);
      triangulos[1]=new Triangulo(6,5,4);
      triangulos[2]=new Triangulo(1,1,1);
      triangulos[3]=new Triangulo(3,4,5);
      triangulos[4]=new Triangulo(8,9,1);
      for(int i=0; i<Triangulo.getCont();i++)
      {
         System.out.println("No triangulo "+(i+1)+" O primeiro lado= "+triangulos[i].getA()+
                            " O segundo= "+triangulos[i].getB()+
                            " O terceiro = "+triangulos[i].getC());
         System.out.println("O perimetro="+triangulos[i].perimetro());
         System.out.println("O tipo ="+triangulos[i].tipo());
         if(triangulos[i].condicao())
         {
            System.out.println("O triangulo existe");
         }else{
            System.out.println("O triangulo nao existe");
         }   
      }         
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
}//fim classe pública
class Triangulo//classe de triangulo 
{
   private static int cont=0;//contador
   private double A;
   private double B;
   private double C;
   public Triangulo(int A, int B, int C)//construtor
   {
      this.setA(A);
      this.setB(B);
      this.setC(C);
      cont++;
   }
   public Triangulo()
   {
      this.setA(0);
      this.setB(0);
      this.setC(0);
      cont++;
   }
  //método que identifica os lados
   public void setA(int A)
   {
      if(A<0) 
      {
         this.A=0;   
      }else{
         this.A=A;
      }
   }
   public void setB(int B)
   {
      if(B<0) 
      {
         this.B=0;   
      }else{
         this.B=B;
      }   
   }
   public void setC(int C)
   {
      if(C<0) 
      {
         this.C=0;   
      }else{
         this.C=C;
      }   
   }
   //método para acessar os lados
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
   public static int getCont()
   {
      return cont;
   }
   public double perimetro()//método para calcular perímetro
   {
      return getA()+getB()+getC();
   }
   public String tipo()//método para classificar o triangulo
   {                   //sem valor de retorno
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
   public static void iguais(double[]tri,double A, double B, double C)//método para comparar outros dois triangulos
   {                                                                  //sem valor de retorno
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
   public boolean condicao()//método que determina existencia ou não do triangulo
   {                        //retorna boolean 
      boolean existe=true;
         if(getA()-getB()<getC()&& getA()+getB()>getC()|| -1*(getA()-getB())<getC()&& getA()+getB()>getC())
         {
            if(getC()-getA()<getB()&& getA()+getC()>getB()|| -1*(getC()-getA())<getB()&& getA()+getC()>getB())
            {
               if(getC()-getB()<getA()&& getC()+getB()>getA()|| -1*(getC()-getB())<getA()&& getC()+getB()>getA())
               {
                  existe=true;
               }else{
                  existe=false;
               }
            }
         }
   return existe;      
   }
}