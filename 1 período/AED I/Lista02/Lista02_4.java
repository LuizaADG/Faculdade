import java.util.Scanner;
public class Lista02_4
{
   public static void main(String[]args)
   {
      int ano;
      boolean porq,
              porc,
              porqc; 
      Scanner s=new Scanner(System.in);
      System.out.print("Digite um ano");
      ano=s.nextInt ();
      porq=ano%4==0;
      porc=ano%100==0;
      porqc=ano%400==0;
      if(porq)
      {
         if (porc)
         {
            if (porqc)
            {
               System.out.print("O ano é bissexto");
            }   
            else
            {
               System.out.print ("O ano não é bissexto");
            }
         }  
        else
        {
         System.out.print ("O ano é bissexto");
        }
      }  
      else 
      {
         System.out.print ("O ano não é bissexto");
      }
   }
}                      