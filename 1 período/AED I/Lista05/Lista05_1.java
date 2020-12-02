import java.util.Scanner;
public class Lista05_1
{
   public static void main (String[]args)
   {
      double base,
              x=1;
      int exp;
      boolean ERRO;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite a base");
      base=s.nextDouble();
      do
      {
         System.out.println("Digite o expoente");
         exp=s.nextInt();
         ERRO=exp<0;
      }while(ERRO);    
      if (exp > 0)
      {
         for(int i=1;i<=exp;i++)
         {
            x=x*base;
         }
      }        
   System.out.println(base + " ^ " + exp + " = "+x);   
   }
}                        