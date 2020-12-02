//Data: 17/05/17
import java.util.Scanner;
public class Lista13
{
   public static void main(String[]args)
   {
      Circulo C[]=new Circulo[100];// arranjo de circulos
      Quadrado Q[]=new Quadrado[100];//arranjo de quadrados
      Triangulo T[]=new Triangulo[100];//arranjo de triangulos
      int opcao=menu();
      do
      {
         switch(opcao)
         {
            case 0: break;//sai do programa
            case 1: //caso a escolhida seja circulos
                     escolheu1(C);
                     opcao=menu();
                     break;
             case 2://caso a escolhida seja quadrados
                     escolheu2(Q);
                     opcao=menu();
                     break;
            case 3://caso a escolhida seja triangulos
                     escolheu3(T);
                     opcao=menu();
                     break;
         }    
      }while(opcao!=0); 
   }//fim de main
   public static int menu()//metodo para acessar os arranjos 
   {
      int opcao;
      Scanner s=new Scanner(System.in);
      do 
      {
         System.out.println("Digite 0 para sair");
         System.out.println("Digite 1 para acessar Circulos");
         System.out.println("Digite 2 para acessar Quadrados");
         System.out.println("Digite 3 para acessar Triangulos");
         opcao=s.nextInt();
         if(opcao<0)System.out.println("Erro");
      }while(opcao<0); 
      return opcao;     
   }//fim menu
   public static void escolheu1(Circulo [] C)//método que apresenta opções da classe circulo
   {
      int op=-1;
       do
       {
         op=submenu1();
          switch(op)
          {
             case 0: break;
             case 1:int i=Circulo.getQuantC();//criação de um novo circulo(max 100) à medida que o usuário escolhe
                    if(i<C.length)
                     {
                        C[i]=new Circulo();
                     }  
                      break;
              case 2:int j=0;//caso perimetro 
                     do
                     {
                        System.out.println("O perimetro do circulo"+(j+1)+"= ");
                        escPeri(C, j);
                        j++;
                     }while(j<Circulo.getQuantC());
                         break;
             case 3:int l=0;//caso area
                    do
                    {
                      System.out.println("A area do circulo"+(l+1)+"= ");
                      escArea(C, l);
                      l++;
                    }while(l<Circulo.getQuantC());
                         break;
          }      
                        
      } while(op!=0);     
   }//fim de escolheu1
   public static void escolheu2(Quadrado []Q)//método que apresenta opções da classe quadrado
   {
      int op1=-1;
      do
      {
         op1=submenu2();
         switch(op1)
         {
            case 0: break;
            case 1:int i=Quadrado.getQuantQ();//criação de um novo quadrado(max 100) à medida que o usuário escolhe
                   if(i<Q.length)
                   {
                     Q[i]=new Quadrado();
                   }  
                   break;
            case 2:int m=0;//caso perimetro 
                   do
                   {
                       System.out.println("O perimetro do quadrado"+(m+1)+"= ");
                       escPeri(Q, m);
                       m++;
                   }while(m<Quadrado.getQuantQ());
                   break;   
           case 3:int n=0; //caso area
                  do
                  {
                     System.out.println("A area do quadrado"+(n+1)+"= ");
                     escArea(Q, n);
                     n++;
                  }while(n<Quadrado.getQuantQ());
                  break;
         }      
      } while(op1!=0);
   }//fim de escolheu2
   public static void escolheu3(Triangulo[]T)//método que apresenta opções da classe triangulo
   {
      int op2=-1;
      do
      {
         op2=submenu3();
         switch(op2)
         {
           case 0: break;
           case 1:int i=Triangulo.getQuantT();//criação de um novo triangulo(max 100) à medida que o usuário escolhe
                  if(i<T.length)
                  {
                     T[i]=new Triangulo();
                  }  
                  break;
           case 2:int v=0; //caso perimetro
                  do
                  {
                     System.out.println("O perimetro do triangulo"+(v+1)+"= ");
                     escPeri(T, v);
                     v++;
                  }while(v<Triangulo.getQuantT());
                  break;
           case 3:int u=0; //caso area
                  do
                  {
                    System.out.println("A area do triangulo"+(u+1)+"= ");
                    escArea(T, u);
                    u++;
                  }while(u<Triangulo.getQuantT());
                  break;
         }      
      } while(op2!=0);
   }//fim de escolheu3
   public static int submenu1()//metodo para acessar as opções do arranjo de circulo
   {
      int oc=-1;
      Scanner s=new Scanner(System.in);
      do 
      {
         System.out.println("Digite 0 para sair da classe");
         System.out.println("Digite 1 para criar um círculo");
         System.out.println("Digite 2 para saber os perímetros dos círculos");
         System.out.println("Digite 3 para saber a área dos círculos");
         oc=s.nextInt();
         if(oc<0)System.out.println("Erro");
      }while(oc<0); 
      return oc;
   }//fim submenu1
   public static int submenu2()//metodo para acessar as opções do arranjo de quadrados
   {
      int opcao=-1;
      Scanner s=new Scanner(System.in);
      do 
      {
         System.out.println("Digite 0 para sair da classe");
         System.out.println("Digite 1 para criar um quadrado");
         System.out.println("Digite 2 para saber os perímetros dos quadrados");
         System.out.println("Digite 3 para saber a área dos quadrados");
         opcao=s.nextInt();
         if(opcao<0)System.out.println("Erro");
      }while(opcao<0); 
      return opcao;
   }//fim submenu2
   public static int submenu3()//metodo para acessar as opções do arranjo de triangulo
   {
      int opcao=-1;
      Scanner s=new Scanner(System.in);
      do 
      {
         System.out.println("Digite 0 para sair da classe");
         System.out.println("Digite 1 para criar um triangulo");
         System.out.println("Digite 2 para saber os perímetros dos triangulos");
         System.out.println("Digite 3 para saber a área dos triangulos");
         opcao=s.nextInt();
         if(opcao<0)System.out.println("Erro");
      }while(opcao<0); 
      return opcao;
   }//fim submenu3
   public static void escPeri(FigGeom []F, int i)//metodo para escrever perimetro
   {
      System.out.println(F[i].perimetro());
   }
   public static void escArea(FigGeom []F, int i)//metodo para escrever area
   {
      System.out.println(F[i].area());
   }
}//fim da classe pública
abstract class FigGeom  //superclasse
{
   public abstract double perimetro();
   public abstract double area();
}
class Circulo extends FigGeom//classe de circulos
{
   private double raio;
   private static int quantC=0;//contador
   Circulo()//construtor
   {
      this.quantC++;
      setRaio();
   }
      public static int getQuantC()//acesso ao contador
   {
      return quantC;
   }
   public void setRaio()//determinar raio
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o raio do circulo");
         this.raio=s.nextDouble();
      }while(this.raio<0);   
   }
   public double getRaio()//acesso ao raio do circulo
   {
      return this.raio;
   }
   public double perimetro()//calculo do perimetro de um circulo
   {
      return 2.0*Math.PI*this.getRaio();
   }
   public double area()//calculo da area de um circulo
   {
      return Math.PI*Math.pow(this.getRaio(),2);
   }
}//fim de circulo
class Quadrado extends FigGeom//classe de quadrados
{
   private double lado;
   private static int quantQ=0;//contador
   Quadrado()//construtor
   {
      this.quantQ++;
      setLado();
   }
      public static int getQuantQ()//acesso ao contador
   {
      return quantQ;
   }
   public void setLado()//determinar valor dos lados do quadrado
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o lado do quadrado");
         this.lado=s.nextDouble();
      }while(this.lado<0);   
   }
   public double getLado()//acesso ao valor dos lados do quadrado
   {
      return this.lado;
   }
   public double perimetro()//calculo do perimetro de um quadrado
   {
      return 4.0*this.getLado();
   }
   public double area()//calculo da area de um quadrado
   {
      return this.getLado()*this.getLado();
   }
}//fim Quadrado
class Triangulo extends FigGeom//classe de triangulos
{
   private double A;//lado1
   private double B;//lado2
   private double C;//lado3
   private static int quantT=0;//contador
   Triangulo()//construtor
   {
      this.quantT++;
      setA();
      setB();
      setC();
   }
   public static int getQuantT()//acesso ao contador
   {
      return quantT;
   }
   public void setA()//colocar os lados
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o 1 lado do triangulo");
         this.A=s.nextDouble();
      }while(this.A<0);   
   }
   public void setB()
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o 2 lado do triangulo");
         this.B=s.nextDouble();
      }while(this.B<0);   
   }
   public void setC()
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o 3 lado do triangulo");
         this.C=s.nextDouble();
      }while(this.C<0);   
   }
   public double getA()//acesso de outras classes aos objetos privados
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
   public double perimetro()//calcular o perimetro de um triangulo
   {
      return this.getA()+this.getB()+this.getC();
   }
   public double area()//calcular a area de um triangulo 
   {
      double p=perimetro()/2.0;
      double result=p*(p-this.getA())*(p-this.getB())*(p-this.getC());
      return Math.sqrt(result);
   }
}//fim Triangulo