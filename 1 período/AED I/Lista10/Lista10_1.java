//Nome do programa:Copia da Matriz 
//Data da elaboração: 26/04/17  
//Autor: Luiza
public class Lista10_1
{
   public static void main (String[]args)
   {
      double M[][]={{1,3,5,7},{2,4,6,8},{1,2,3,4},{5,6,7,8}};
      double N[][]= new double [4][4];
      copiaMatriz(M,N);
   }
   public static void copiaMatriz(double [][]M, double [][]N)
//Objetivo: copiar o valor de uma matriz em outra 
//Argumentos:duas matrizes reais 
//Valor gerado: não há
   {
      for (int i=0; i<M.length; i++)
      {
         for (int j=0; j<M.length; j++)
         {
            N[i][j]=M[i][j];
         }
      }
   }   
}