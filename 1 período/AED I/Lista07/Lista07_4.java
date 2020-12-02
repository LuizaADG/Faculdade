//Nome do programa: Lista07_4
//Data da elaboração: 02/04/17
//Autor: Luiza
//Objetivo: Calcula a potenciação
//Argumentos: base, expoente, potencia
//Valor gerado: potencia
import java.util.Scanner;
public class Lista07_4
{
   public static void main(String[]args)
   {
      int base,
          exp;
      double    pot;
     base= leituraBase();
     exp=leituraExpo();
     pot = potenciacao(base,exp);
     escreva(pot);      
   }
   public static int leituraBase()
   {
      int base;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite a base");
      base=s.nextInt();
      return base;
   }
   public static int  leituraExpo()
   {
      int exp;
      Scanner s= new Scanner(System.in); 
      System.out.println("Digite o expoente");
      exp=s.nextInt();
      return exp;
   }
   public static double potenciacao (int base, int exp)
   {
      double pot;
      pot=Math.pow((double)base,(double)exp);
      return pot;
   }
   public static void escreva(double pot)
   {
      System.out.println("O valor =" +pot);
   }
}