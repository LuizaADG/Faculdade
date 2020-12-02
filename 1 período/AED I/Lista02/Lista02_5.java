import java.util.Scanner;
public class Lista02_5
{
   public static void main (String[]args)
   {
     char a;
     double b,
            c,
            d,
            e,
            f,
            g;     
     Scanner leia=new Scanner(System.in);
     System.out.print("Digite dois numeros");
     b=leia.nextDouble();
     c=leia.nextDouble();
     d=b+c;
     e=b-c;
     f=b*c;
     g=b/c;
     System.out.print("Digite o tipo de operação (adição,subtração,multiplicação ou divisão)");
     a=leia.nextLine().charAt(0);
     if(a=='a')
     {
      System.out.print(d);
     }
     else if (a=='s')
     { 
      System.out.print(e);
     }
     else if (a=='m')
     {
      System.out.print(f);
     }
     else if (a=='d')
     {
      System.out.print(g);
     }
   }
}           
             