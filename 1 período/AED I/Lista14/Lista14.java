//Data:24/05/17
import java.util.Scanner;
public class Lista14
{
   public static void main(String[]args)
   {
      FigGeom[]F=new FigGeom [300];
      Circulo[]C= new Circulo[100];
      Quadrado[]Q=new Quadrado[100];
      Triangulo[]T=new Triangulo[100]; 
      int opcao=-1;
      do
      {
         opcao=menu();
         switch(opcao)
         {
            case 0: break;//sai do programa
            case 1: //caso a escolhida seja circulos
                     escolheu1(C);
                     break;
             case 2://caso a escolhida seja quadrados
                     escolheu2(Q);
                     break;
            case 3://caso a escolhida seja triangulos
                     escolheu3(T);
                     break;
            case 4://caso seja escrever os perimetros de todos                            
                     if(Quadrado.getQuantQ()==0&&Triangulo.getQuantT()==0)
                     { 
                        for (int i=0; i<Circulo.getQuantC();i++)
                        {
                          F[i]=C[i];
                        }
                     }//caso so circulos sejam criados
                     if(Circulo.getQuantC()==0&&Triangulo.getQuantT()==0)
                     { 
                        for (int i=0; i<Quadrado.getQuantQ();i++)
                        {
                          F[i]=Q[i];
                        }
                     }//caso so quadrados sejam criados
                     if(Circulo.getQuantC()==0&&Quadrado.getQuantQ()==0)
                     { 
                        for (int i=0; i<Triangulo.getQuantT();i++)
                        {
                          F[i]=T[i];
                        }
                     }//caso so triangulos sejam criados
                     else if(Triangulo.getQuantT()==0&&Quadrado.getQuantQ()>0&&Circulo.getQuantC()>0)
                     {   
                        for (int i=0; i<Circulo.getQuantC();i++)
                        {
                          F[i]=C[i];
                        }//os primeiros termos de figGeom são circulos
                        for(int j=Circulo.getQuantC();j<(Circulo.getQuantC()+Quadrado.getQuantQ()); j++)
                        {
                           for(int h=0; h<Quadrado.getQuantQ(); h++)
                           {
                              F[j]=Q[h];
                           }   
                        }//os termos de figGeom depois de circulos são quadrados
                     }//caso so quadrados e circulos sejam criados  
                      else if(Quadrado.getQuantQ()==0&&Triangulo.getQuantT()>0&&Circulo.getQuantC()>0)
                      {   
                        for (int i=0; i<Circulo.getQuantC();i++)
                        {
                          F[i]=C[i];
                        }//os primeiros termos de figGeom são circulos
                        for(int j=Circulo.getQuantC();j<(Circulo.getQuantC()+Triangulo.getQuantT()); j++)
                        {
                           for(int h=0; h<Triangulo.getQuantT(); h++)
                           {
                              F[j]=T[h];
                           }   
                        }//os termos de figGeom depois de circulos são triangulos
                     }//caso so triangulos e circulos sejam criados 
                     else if(Triangulo.getQuantT()>0&&Quadrado.getQuantQ()>0&&Circulo.getQuantC()==0)
                     {   
                        for (int i=0; i<Quadrado.getQuantQ();i++)
                        {
                          F[i]=Q[i];
                        }//os primeiros termos de figGeom são quadrados
                        for(int j=Triangulo.getQuantT();j<(Triangulo.getQuantT()+Quadrado.getQuantQ()); j++)
                        {
                           for(int h=0; h<Triangulo.getQuantT(); h++)
                           {
                              F[j]=Q[h];
                           }   
                        }//os termos de figGeom depois quadrados são triangulos
                     }//caso so triangulos e quadrados sejam criados    
                     if(Circulo.getQuantC()>0&&Quadrado.getQuantQ()>0&&Triangulo.getQuantT()>0)
                     {   
                        for (int i=0; i<Circulo.getQuantC();i++)
                        {
                          F[i]=C[i];
                        }
                        for(int j=Circulo.getQuantC();j<(Circulo.getQuantC()+Quadrado.getQuantQ()); j++)
                        {
                           for(int h=0; h<Quadrado.getQuantQ(); h++)
                           {
                              F[j]=Q[h];
                           }   
                        }//os termos de figGeom depois  circulos são quadrados                       
                         for(int t=(Circulo.getQuantC()+Quadrado.getQuantQ()); t<F.length;t++)
                        {        
                          for( int y=0; y<Triangulo.getQuantT(); y++)
                          {
                             F[t]=T[y];
                          }  
                        }//os ultimos termos de figGeom são triangulos
                    }//caso todos as classes sejam criadas    
                    int a=Circulo.getQuantC()+Quadrado.getQuantQ()+Triangulo.getQuantT();
                   FigGeom.escPeri(F,a);
                   break;
            case 5://caso seja escrever a area
                      if(Quadrado.getQuantQ()==0&&Triangulo.getQuantT()>0&&Circulo.getQuantC()>0)
                      {   
                        for (int i=0; i<Circulo.getQuantC();i++)
                        {
                          F[i]=C[i];
                        }//os primeiros termos de figGeom são circulos
                        for(int j=Circulo.getQuantC();j<(Circulo.getQuantC()+Triangulo.getQuantT()); j++)
                        {
                           for(int h=0; h<Triangulo.getQuantT(); h++)
                           {
                              F[j]=T[h];
                           }   
                        }//os termos de figGeom depois de circulos são triangulos
                     }//caso so triangulos e circulos sejam criados 
                     else if(Triangulo.getQuantT()>0&&Quadrado.getQuantQ()>0&&Circulo.getQuantC()==0)
                     {   
                        for (int i=0; i<Quadrado.getQuantQ();i++)
                        {
                          F[i]=Q[i];
                        }//os primeiros termos de figGeom são quadrados
                        for(int j=Triangulo.getQuantT();j<(Triangulo.getQuantT()+Quadrado.getQuantQ()); j++)
                        {
                           for(int h=0; h<Triangulo.getQuantT(); h++)
                           {
                              F[j]=Q[h];
                           }   
                        }//os termos de figGeom depois quadrados são triangulos
                     }//caso so triangulos e quadrados sejam criados    
                     if(Circulo.getQuantC()>0&&Quadrado.getQuantQ()>0&&Triangulo.getQuantT()>0)
                     {   
                        for (int i=0; i<Circulo.getQuantC();i++)
                        {
                          F[i]=C[i];
                        }
                        for(int j=Circulo.getQuantC();j<(Circulo.getQuantC()+Quadrado.getQuantQ()); j++)
                        {
                           for(int h=0; h<Quadrado.getQuantQ(); h++)
                           {
                              F[j]=Q[h];
                           }   
                        }//os termos de figGeom depois  circulos são quadrados                       
                         for(int t=(Circulo.getQuantC()+Quadrado.getQuantQ()); t<F.length;t++)
                        {        
                          for( int y=0; y<Triangulo.getQuantT(); y++)
                          {
                             F[t]=T[y];
                          }  
                        }//os ultimos termos de figGeom são triangulos
                    }//caso todos as classes sejam criadas    
                    int b=Circulo.getQuantC()+Quadrado.getQuantQ()+Triangulo.getQuantT();
                   FigGeom.escArea(F,b);
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
         System.out.println("Digite 4 para saber todos os perimetros");
         System.out.println("Digite 5 para saber todos as areas");
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
                        escrPeri(C, j);
                        j++;
                     }while(j<Circulo.getQuantC());
                         break;
             case 3:int l=0;//caso area
                    do
                    {
                      System.out.println("A area do circulo"+(l+1)+"= ");
                      escrArea(C, l);
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
                       escrPeri(Q, m);
                       m++;
                   }while(m<Quadrado.getQuantQ());
                   break;   
           case 3:int n=0; //caso area
                  do
                  {
                     System.out.println("A area do quadrado"+(n+1)+"= ");
                     escrArea(Q, n);
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
                     escrPeri(T, v);
                     v++;
                  }while(v<Triangulo.getQuantT());
                  break;
           case 3:int u=0; //caso area
                  do
                  {
                    System.out.println("A area do triangulo"+(u+1)+"= ");
                    escrArea(T, u);
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
   public static void escrPeri(FigGeom []F, int i)//metodo para escrever perimetro
   {
      System.out.println(F[i].perimetro());
   }
   public static void escrArea(FigGeom []F, int i)//metodo para escrever area
   {
      System.out.println(F[i].area());
   }
}//fim da classe pública
abstract class FigGeom
{
   public abstract double perimetro();
   public abstract double area();
   public static void escPeri(FigGeom []F, int a)//metodo para escrever o perimetro
   {
      for(int i=0; i<a;i++)
      {
         System.out.println(F[i].perimetro());
      }   
   }
   public static void escArea(FigGeom []F, int b)//metodo para escrever a area
   {
      for (int i=0; i<b;i++)
      {
         System.out.println(F[i].area());
      }   
   }
}//fim da superclasse
class Circulo extends FigGeom
{
   private static int quant=0;
   private double raio;
   Circulo(double x)//construtor
   {
      setRaio(x);
      this.quant++;
   }
   Circulo()//construtor
   {
      setRaio();
      this.quant++;
   }
   public void setRaio(double x)//colocar raio
   {
      this.raio=x;
   }
   public void setRaio()//quando não tem nada digitado em raio
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o raio do circulo");
         this.raio=s.nextDouble();
      }while(this.raio<0);
   }
   public double getRaio()//metodo de acesso ao raio
   {
      return this.raio;
   }
   public static int getQuantC()//metodo de acesso a quantidade de circulos
   {
      return quant;
   }
   public double perimetro()//calcular o perimetro de um circulo
   {
      return 2.0*Math.PI*this.getRaio();
   }
   public double area()//calcular a area de um circulo
   {
      return Math.PI*Math.pow(this.getRaio(),2);
   }
}//fim da classe Circulo
class Quadrado extends FigGeom
{
   private static int quant=0;
   private double lado;
   Quadrado(double x)//construtor
   {
      setLado(x);
      this.quant++;
   }
   Quadrado()//construtor
   {
      setLado();
      this.quant++;
   }
   public void setLado(double x)//colocar lado
   {
      this.lado=x;
   }
   public void setLado()//quando não tem nada digitado em lado
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o lado do quadrado");
         this.lado=s.nextDouble();
      }while(this.lado<0); 
   }
   public double getLado()//metodo de acesso ao lado
   {
      return this.lado;
   }
   public static int getQuantQ()//metodo de acesso a quantidade de quadrados
   {
      return quant;
   }
   public double perimetro()//calcular o perimetro de um quadrado
   {
      return 4.0*this.getLado();
   }
   public double area()//calcular a area de um quadrado
   {
      return this.getLado()*this.getLado();
   }
}//fim da classe Quadrado
class Triangulo extends FigGeom
{
   private static int quant=0;
   private double A;
   private double B;
   private double C;
   Triangulo(double x, double y, double z)//construtor
   {
      setLados(x,y,z);
      this.quant++;
   }
   Triangulo()//construtor
   {
      setLados();
      quant++;
   }
   public void setLados(double x, double y, double z)// colocar lados
   {
      this.A=x;
      this.B=y;
      this.C=z;
   }
   public void setLados()//quando nenhum valor é digitado
   {
      setA();
      setB();
      setC();
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
   public static int getQuantT()//metodo de acesso a quantidade de triangulos
   {
      return quant;
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
}//fim da classe de triangulo