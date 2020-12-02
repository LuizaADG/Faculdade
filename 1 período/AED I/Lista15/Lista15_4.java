//Data:04/06/17
import java.util.Scanner;
import java.util.InputMismatchException;//implementação da excessaõ do tipo incompatível
public class Lista15_4
{
   public static void main(String[]args)
   {
      int opcao=-1;
      Scanner s=new Scanner(System.in);
      boolean continua=true;
      do
      {
         try
         {
            opcao=menu();//opção do usuário
            switch(opcao)
            {
               case 0: 
                  break; 
               case 1:ad();
                  break;
               case 2:sub();
                  break;
               case 3:multip();
                  break;
               case 4:div();       
                  break;       
            }//fim de switch
         }//fim de try
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
      }while(opcao!=0);   
   }//fim de main
   public static int menu()
   {
      int op=0;
      Scanner s=new Scanner(System.in);
      System.out.println("0 para Sair");
      System.out.println("1 para Adicao");
      System.out.println("2 para Substracao");
      System.out.println("3 para Multiplicacao");
      System.out.println("4 para Divisao");
      op=s.nextInt();  
      return op;
   }//fim de menu
   public static void ad()
   {
      double a=ler1();
      double b=ler2();
      double ad=a+b;
      System.out.println("O resultado = "+ad);
   }
   public static void sub()
   {
      double a=ler1();
      double b=ler2();
      double sub=a-b;
      System.out.println("O resultado = "+sub);
   }
   public static void multip()
   {
      double a=ler1();
      double b=ler2();
      double m=a*b;
      System.out.println("O resultado = "+m);
   }
   public static void div()throws ArithmeticException
   {
      double a=ler1();
      double b=ler2();
      double div=a/b;
      System.out.println("O resultado = "+div);
   }
   public static double ler1()throws InputMismatchException
   {
      double a=0;
      Scanner s=new Scanner(System.in);
      System.out.println("Digite o 1 numero");
      a=s.nextDouble();
      return a;
   }//fim de ler1
   public static double ler2()throws InputMismatchException
   {
      double b=0;
      Scanner s=new Scanner(System.in);
      System.out.println("Digite o 2 numero");
      b=s.nextDouble();
      return b;      
   }//fim de ler2
}//fim de class