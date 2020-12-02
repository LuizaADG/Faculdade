import java.util.Scanner;
public class Lista04_5
{
   public static void main(String[]args)
   {
      int n,
          i=1,
          soma=0;
      double media;    
      Scanner s=new Scanner(System.in);
      do
      {
         do
         {
            System.out.println("Digite o numero. Caso queira parar, digite 0");
            n=s.nextInt();
            if (n<0)System.out.println("ERRO"); 
         }while(n<0);
      soma=n+soma;   
      if (n!=0)i++;
      }while(n!=0);      
      media=(double)soma/(double)(i-1);
      System.out.println("A media ="+media);            
   }   
}