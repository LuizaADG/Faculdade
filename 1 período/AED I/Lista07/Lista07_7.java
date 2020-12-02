//Nome do programa: Lista07_7
//Data da elaboração: 02/04/17
//Autor: Luiza
//Objetivo: Revela se uma ano é bissexto ou não
//Argumentos: ano, bissexto(boolean)
//Valor gerado: (boolean) bissexto
import java.util.Scanner;
public class Lista07_7
{
   public static void main (String[]args)
   {
      int n;
      n=leia();
      if (EhBissexto(n))
      {
         System.out.println("O ano não é bissexto");
      }else
      {
         System.out.println("O ano é bissexto");
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
   public static boolean EhBissexto(int n)
   {
      boolean bissexto=true,
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
               bissexto=false;
            }else
            {
               bissexto=true;
            }
         }else
         {
            bissexto=false;
         }
      }  
      return bissexto; 
   }
}//fim class                