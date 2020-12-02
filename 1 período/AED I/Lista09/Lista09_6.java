import java.util.Scanner;
public class Lista09_6
{
   public static void main(String[]args)
   {
      int[] A={1, 2, 4, 10, 7, 11};
      int j=0;
      int soma=0;
      contarPares(A,soma,j); 
   }
   public static void contarPares(int[]X,int soma, int j)
   {
      int resposta= contarPareseq(X,soma,j);
      System.out.print("Ha "+resposta+" pares no arranjo");
   }
   public static int contarPareseq(int []Y,int soma, int j)
   //conta os pares em arranjo de maneira recursiva
   {
      if (j==Y.length-1)
      {
         if(Y[j]%2==0)
         {
            return soma=soma+1;
         }
         else 
         {
            return soma;
         }
      }
      else
      {   
         if(Y[j]%2==0)
         {   
            return contarPareseq(Y, soma=soma+1, j=j+1);
         }
         else
         {
            return contarPareseq(Y, soma, j=j+1);
         } 
      }     
   }
}  