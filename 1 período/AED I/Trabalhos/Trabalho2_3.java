//Nome do programa: Encontrar o minmax
//Data da elaboração: 29/04/17  
//Autor: Luiza
public class Trabalho2_3
{
   public static void main (String[]args)
   {
      double[][]M= {{1,2,3},{1,10,20},{25,2,0}};
      double minmax=minmax(M);
      System.out.println("O valor min max= "+minmax);
   }
   public static double minmax(double[][]M)
//Objetivo: calcular o minmax da matriz 
//Argumentos:matriz real   
//Valor gerado: real minmax  
   {
      double l=menorMatriz(M);
      double maior=0;
      for(double j=0; j<M[0].length;j++)
      {
         if(M[(int)l][(int)j]> maior)
         {
            maior=M[(int)l][(int)j];
         }
      }
   return maior;   
   }
   public static double menorMatriz (double [][]M)
//Objetivo: calcular a linha em que se encontra o menor valor da matriz 
//Argumentos:matriz real   
//Valor gerado: real linha em que o menor valor está
   {
      double menor=M[0][0];
      double linha=0;
      for(double i=0; i<M.length; i++)
      {
         for(double j=0; j<M[0].length;j++)
         {
            if(M[(int)i][(int)j]<=menor)
            {
               linha=i;
            }
         }
      }
   return linha;      
   }
}