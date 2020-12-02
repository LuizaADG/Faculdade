import java.util.Scanner;
public class Lista09_5
{
   public static void main(String[]args)
   {
      int[] A={1, 2, 4, 10, 7, 11};
      contarPares(A); 
   }
   public static void contarPares(int[]X)
   {
      int resposta= contarPareseq(X);
      System.out.print("Ha "+resposta+" pares no arranjo");
   }
   public static int contarPareseq(int []Y)
   {
      int soma=0;
      for(int i=0;i<Y.length;i++)
      {
         if(Y[i]%2==0)
         {
            soma=soma+1;
         }
      }
      return soma;
   }
}  