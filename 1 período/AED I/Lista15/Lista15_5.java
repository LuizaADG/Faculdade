//Data:11/05/17
import java.util.InputMismatchException;//implementação da excessaõ do tipo incompatível
import java.util.Scanner;
public class Lista15_5
{
   public static void main(String[]args)
   {
      int opcao=-1;
      int i;
      Scanner s=new Scanner(System.in);
      Triangulo[]triangulos =new Triangulo[100];//arranjo de triangulos. Não estático
      String tipo="s";
      do
      {
         try
         {
            opcao=menu();
            switch(opcao)/*realiza ações dependendo do numero escolhido, realiza enquanto não escolhe 0*/ 
            {
               case 0:
                  break;
               case 1:i=Triangulo.getCont();//criação de um novo triangulo(max 100) à medida que o usuário escolhe
                  if(i<triangulos.length)
                  {
                     triangulos[i]=new Triangulo();
                     triangulos[i].leTriangulo();
                  }  
                  break;
               case 2:Triangulo.listagem(triangulos);
                  break;
               case 3: System.out.println("Existem "+Triangulo.quantIguais(triangulos)+" triangulos iguais");
                  break;
               case 4:submenu(tipo,triangulos);
                  break;
               case 5:System.out.println("Existem "+ Triangulo.condicao(triangulos)+" existentes de "+Triangulo.getCont());
                  break;  
            }
         }
         catch(InputMismatchException inputMismatchException)
         {
            System.err.printf("\nException:%s\n",inputMismatchException);
            s.nextLine();
            System.out.println("Somente numeros reais");
         }//fim de catch
         catch(ArithmeticException arithmeticException)	
         {
            System.err.printf("\nException: %s\n", arithmeticException);
            s.nextLine();
            System.out.println("Zero é um valor inválido. Tente novamente.\n");
         }
         catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
         {
            System.err.printf("\nException: %s\n", arrayIndexOutOfBoundsException);
            s.nextLine();
            System.out.println("Ultrapassa o array.\n");
         }
         catch(NullPointerException nullPointerException)
         {
            System.err.printf("\nException: %s\n", nullPointerException);
            s.nextLine();
            System.out.println("Referencia ao objeto nao existe.\n");
         }            
      }while(opcao!=0);                       
   }
   public static int menu()//apresenta opções ao usuario, sem valor de retorno
   {
      Scanner s=new Scanner(System.in);
      System.out.println("Digite 0 para sair");
      System.out.println("Digite 1 para criar um triangulo");
      System.out.println("Digite 2 para listar os triangulos existentes");
      System.out.println("Digite 3 para saber quantos triangulos sao iguais");
      System.out.println("Digite 4 para listar triangulos de tipo escolhido");
      System.out.println("Digite 5 para verificar valores invalidos");
      int opcao=s.nextInt();
      return opcao;
   }
   public static void submenu(String tipo,Triangulo[]triangulos)throws InputMismatchException//usuário digita qual tipo de triangulo deseja
   {                                                            //sem valor de retorno
      Scanner s= new Scanner (System.in);
      System.out.println("Digite o tipo de triangulo desejado");
      tipo=s.next();
      System.out.println("Do tipo "+tipo+" existem "+Triangulo.quantosTipo(tipo,triangulos)+" triangulos");
   }
}//fim classe pública
class Triangulo//classe de triangulos
{
   private double A;//lados
   private double B;
   private double C;
   private static int cont=0;//contador
   Triangulo()throws ArrayIndexOutOfBoundsException//construtor
   {
      this.cont++;
   }
   public void leTriangulo()throws ArrayIndexOutOfBoundsException//acesso a introdução dos lados
   {
      setA();
      setB();
      setC();
   }
   public static int getCont()throws NullPointerException//acesso ao contador
   {
      return cont;
   }
   public void setA()throws InputMismatchException//colocar os lados
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o 1 lado do triangulo");
         this.A=s.nextDouble();
      }while(this.A<0);   
   }
   public void setB()throws InputMismatchException
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o 2 lado do triangulo");
         this.B=s.nextDouble();
      }while(this.B<0);   
   }
   public void setC()throws InputMismatchException
   {
      do
      {
         Scanner s=new Scanner (System.in);
         System.out.println("Digite o 3 lado do triangulo");
         this.C=s.nextDouble();
      }while(this.C<0);   
   }
   public double getA()throws NullPointerException//acesso de outras classes aos objetos privados
   {
      return this.A;
   }
   public double getB()throws NullPointerException
   {
      return this.B;
   }
   public double getC()throws NullPointerException
   {
      return this.C;
   }
   public double perimetro()//método para calcular o perímetro
   {
      return getA()+getB()+getC();
   }
   public static void listagem(Triangulo[]triangulos)//lista os triangulos,seus lados e seus perimetros
   {                                                 //sem valor de retorno 
      if(cont==0)
      {
         System.out.println("Nenhum triangulo feito");
      }else{
         for(int i=0;i<cont;i++)
         {
            System.out.println("No triangulo "+(i+1)+
               " O primeiro lado= "+triangulos[i].getA()+
               " O segundo= "+triangulos[i].getB()+
               " O terceiro = "+triangulos[i].getC());
            System.out.println("O perimetro="+triangulos[i].perimetro());
         }
      }   
   }
   public static int quantIguais(Triangulo[]triangulos)throws ArrayIndexOutOfBoundsException//método que determina quantidade de triangulos iguais 
   {                                                   //retorna quantidade
      int quant=0;
      for(int i=0; i<cont; i++)
      {
         for(int j=1; j<cont;j++)
         {   
            if(triangulos[i].getA()==triangulos[j].getA()||triangulos[i].getA()==triangulos[j].getB()||triangulos[i].getA()==triangulos[j].getC())
            {
               if(triangulos[i].getB()==triangulos[j].getA()||triangulos[i].getB()==triangulos[j].getB()||triangulos[i].getB()==triangulos[j].getC())
               {
                  if(triangulos[i].getC()==triangulos[j].getA()||triangulos[i].getC()==triangulos[j].getB()||triangulos[i].getC()==triangulos[j].getC())
                  {
                     quant++;
                  }//fim if 
               }//fim if 
            }//fim if
         }//fim for                       
      }//fim for
      return quant;
   }//fim metodo
   public static int quantosTipo(String tipo, Triangulo[]triangulos)
   {
      String t=tipo;
      int quant=0;
      if(t.charAt(1)=='q')//caso o escolhido seja equilatero
      {                   //retorna quantidade
         for(int i=0; i<cont; i++)
         {
            if(triangulos[i].getA()==triangulos[i].getB()&&triangulos[i].getA()==triangulos[i].getC())
            {
               quant++;
            }
         }      
      }
      if(t.charAt(0)=='i')//caso o escolhido seja isosceles
      {                   //retorna quantidade 
         for(int i=0; i<cont; i++)
         {
            if((triangulos[i].getA()!=triangulos[i].getC()||triangulos[i].getA()!=triangulos[i].getB())&&(triangulos[i].getB()==triangulos[i].getC() || triangulos[i].getA()==triangulos[i].getB()||triangulos[i].getA()==triangulos[i].getC()))
            {
               quant++;
            }
         }
      }
      if(t.charAt(2)=='c')//caso o escolhido seja escaleno
      {                   //retorna quantidade
         for(int i=0; i<cont; i++)
         {
            if((triangulos[i].getC()!=triangulos[i].getA()) && (triangulos[i].getB()!=triangulos[i].getC())&& (triangulos[i].getA()!=triangulos[i].getB()));
            {
               quant++;
            }         
         }
      }
      return quant;   
   }   
   public static int condicao(Triangulo[]triangulos)throws NullPointerException//quantidade de triangulos que atendem a ondição de existência 
   {                                                //retorna quantidade
      int num=0;
      for(int i=0; i<cont; i++)
      {
         if(triangulos[i].getA()-triangulos[i].getB()<triangulos[i].getC()&& triangulos[i].getA()+triangulos[i].getB()>triangulos[i].getC()|| -1*(triangulos[i].getA()-triangulos[i].getB())<triangulos[i].getC()&& triangulos[i].getA()+triangulos[i].getB()>triangulos[i].getC())
         {
            if(triangulos[i].getC()-triangulos[i].getA()<triangulos[i].getB()&& triangulos[i].getA()+triangulos[i].getC()>triangulos[i].getB()|| -1*(triangulos[i].getC()-triangulos[i].getA())<triangulos[i].getB()&& triangulos[i].getA()+triangulos[i].getC()>triangulos[i].getB())
            {
               if(triangulos[i].getC()-triangulos[i].getB()<triangulos[i].getA()&& triangulos[i].getC()+triangulos[i].getB()>triangulos[i].getA()|| -1*(triangulos[i].getC()-triangulos[i].getB())<triangulos[i].getA()&& triangulos[i].getC()+triangulos[i].getB()>triangulos[i].getA())
               {
                  num++;
               }//fim if   
            }//fim if
         }//fim if
      }//fim for
      return num;      
   }//fim metodo
}//fim classe