import java.util.Scanner;
public class Lista06_5
{
   public static void main(String[]args)
   {
      int n,
         fat;
      char resp;
      n=leia();
      fat=fatorial(n);
         Scanner leia= new Scanner(System.in);
      System.out.println("Digite 's' se quiser sair e 'c' para continuar");
      resp= leia.next().charAt(0);
      do
      {
         n=leia();
         fat=fatorial(n);
         System.out.println("Digite 's' se quiser sair e 'c' para continuar");
         resp= leia.next().charAt(0);
         }while(resp!='s');   
   }
   public static int leia()
   {
      int x;
      Scanner leia= new Scanner(System.in);
      do
      {
         System.out.println("Digite o numero inteiro da fatorial.");
         x=leia.nextInt();
         if (x<0)System.out.println("Valor inválido");
      }while(x<0);
      return x;
   }
   public static int fatorial(int n)
   {
      int fat=1;
      for(int i=1; i<=n;i++)
      {
         fat=fat*i;
      } 
      if (n==0) System.out.println("1"); 
      if(n!=0||n>0) System.out.println(+n+"! = "+fat);  
      return fat;
   } 
}