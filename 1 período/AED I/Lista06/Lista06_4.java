import java.util.Scanner;
public class Lista06_4
{
   public static void main (String[]args)
   {
      int n;
      n=leia();
      if (bissexto(n))
      {
         System.out.println("O ano é bissexto");
      }else
      {
         System.out.println("O ano não é bissexto");
      }      
   }
   public static int leia()
   {
      int x;
      do
      {
         Scanner s= new Scanner(System.in);
         System.out.println("Digite um ano");
         x=s.nextInt();
         if (x<0) System.out.println("Valor invalido");
      }while(x<0);   
      return x;
   }
   public static boolean bissexto(int n)
   {
      boolean bissexto=false,
              porq,
              porc,
              porqc; 
      porq=n%4==0;
      porc=n%100==0;
      porqc=n%400==0;
      if(porq)
      {
         if (porc)
         {
            if (porqc)
            {
               bissexto=true;
            }else
            {
               bissexto=false;
            }
         }else
         {
            bissexto=true;
         }
      }  
      return bissexto; 
   }
}//fim class                