import java.util.Scanner;
public class Lista06_1
{
   public static int lerIdade()
   {
      Scanner s= new Scanner(System.in);
      int n;
      do
      {
         System.out.println("Digite a idade. Digite 0 para parar.");
         n=s.nextInt();
         if(n<0||n>150)System.out.println("ERRO");
      }while (n<0||n>150);
      return n;
   }//fim lerIdade()  
   public static void main(String[]args)
   {
      int i=0,
          idade,
          soma=0;
      double media;    
      Scanner s=new Scanner(System.in);
         idade=lerIdade();
         while(idade!=0) 
         {
            i++;
            soma=soma+idade;
            idade=lerIdade();
         }//fim while    
      media=(double)soma/(double)i;
      System.out.println("A media="+media);
   }//fim main
}//fim class             