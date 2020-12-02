import java.util.Scanner;
public class Lista08_8ate13
{
   public static void main(String[]args)
   {
   Scanner s= new Scanner(System.in);
   SolucoesAritmeticas.primeiro();   
   SolucoesAritmeticas.segundo();  
   SolucoesAritmeticas.terceiro(); 
   SolucoesAritmeticas.quarto(); 
   SolucoesAritmeticas.quinto(); 
   SolucoesAritmeticas.sexto();
   }//fim main
}
class SolucoesAritmeticas
{
   public static void primeiro()
   {
      int m,
          n,
        soma;
      Scanner s= new Scanner(System.in);
      System.out.println("O primeiro programa somará de um numero ate outro");
      System.out.println("Digite o 1 numero");
      m=s.nextInt();
      System.out.println("Digite o ultimo numero");
      n=s.nextInt(); 
      soma=somaNM(m,n);  
      System.out.println(soma); 
   }
   public static void segundo()
   {
       double x,
             fat;
      Scanner s= new Scanner(System.in);   
      System.out.println("O segundo programa realizara o fatorial de um numero");
      System.out.println("Digite o numero");
      x=s.nextDouble();
      fat=fatorial(x);
      System.out.println(fat);
   }
   public static void terceiro()
   {
       int expo;
       double base,
             pot; 
      Scanner s= new Scanner(System.in);
      System.out.println("O terceiro programa realizara potenciacao");
      System.out.println("Digite a base");
      base=s.nextDouble();
      System.out.println("Digite o expoente");
      expo=s.nextInt();
      pot=potenciacao(base,expo);
      System.out.println(pot);
   }
   public static void quarto()
   {
      int v,
          fib;
      Scanner s=new Scanner(System.in);
      System.out.println("O quarto programa digitara o termo equivalente em fibonacci ");
      System.out.println("Digite o numero");
      v=s.nextInt();
      fib=fibo(v);
      System.out.println(fib);
   }
   public static void quinto()
   {
      int a;
      Scanner s= new Scanner(System.in);
      System.out.println("O quinto programa contara do numero ate 0");
      System.out.println("Digite o numero"); 
      a= s.nextInt();
      contRegressiva(a);
   }
   public static void sexto()
   {
      Scanner s= new Scanner(System.in);
      double y,
             cubos;
      System.out.println("O sexto programa somara o cubo do numero com o de seus atencessores ate 0");      
      System.out.println("Digite o numero");
      y=s.nextInt();
      cubos=somaN(y);
      System.out.println(cubos);
   }
   public static int somaNM(int m, int n)
   {
      int soma=0;
      if (m<n)
      {
         soma = m + somaNM(m+1,n);
      }else
      {
         soma = m;
      }
      return soma; 
   }//fim somaNM
   public static double fatorial(double x)
   {
      double fat=0;
      if(x==0)
      {
         fat=1;
      }else if (x>0)
      {
         fat=x*fatorial(x-1);
      }
      return fat;  
   }
   public static double potenciacao(double b, int e)
   {
      double pot=0;
      if(e==0)
      {
         pot=1;
      }else if (e>0)
      {
         pot=b*potenciacao(b,e-1);
      }
      return pot;
   }
   public static int fibo (int v)
   {
      int fib=0;
      if (v==1 ||v==2)
      {
         fib=1;
      }else
      {
         fib=fib+fibo(v-1)+fibo(v-2);
      }
      return fib;
   }
   public static int contRegressiva(int a)
   {
      if (a>=0)
      {
         System.out.println(a);
         contRegressiva(a-1);
      }   
      return a;
   }
    public static double somaN(double y)
   {
      double cubos=0;
      if(y==0)
      {
         cubos=0;
      }else 
      {
         cubos=cubos+Math.pow(y,3)+somaN(y-1);
      }
      return cubos;
   }
}//fim solucoesAritmeticas
