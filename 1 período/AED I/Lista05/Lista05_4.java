import java.util.Scanner;
public class Lista05_4
{
   public static void main(String[]args)
   {
      int n,
          fat=1;
      Scanner s=new Scanner(System.in);
      do
      {
         System.out.println("Digite o numero inteiro da fatorial.");
         n=s.nextInt();
         if (n<0)System.out.println("Valor inválido");
      }while(n<0);
      while(n>=0)
      {     
         fat=1;
         for(int i=1; i<=n;i++)
         {
            fat=fat*i;
         }  
         if (n==0) System.out.println("1");  
         if(n!=0||n>0) System.out.println(+n+"! = "+fat);
         System.out.println("Digite o numero inteiro da fatorial.Digite um nºnegativo p/sair.");
         n=s.nextInt();
      }     
   System.out.println("Obrigada por usar o programa");      
   }
}             