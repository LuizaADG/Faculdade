import java.util.Scanner;
public class Lista03_5
{
   public static void main(String[]args)
   {
      Scanner s=new Scanner(System.in);
      int idade,
          soma=0,
          c=0,
          n;
      System.out.print("Digite o numero de pessoas");    
      n=s.nextInt();    
      while (c<n)
      {
         System.out.print("Digite a "+(c+1)+" idade");
         idade=s.nextInt();
         c=c+1;
         soma=soma+idade;
      }
   double media=(double)soma/(double)c;
   System.out.print("A media é"+media);
   }
}             