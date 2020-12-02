//Nome do programa: Maior valor Acima  
//Data da elaboração: 28/04/17  
//Autor: Luiza
public class Lista10_7
{
   public static void main(String[]args)
   {
      double [][]M= {{1,2,3,4},{3,2,11,6},{1,17,3,8},{2,0,10,4}};
      double l=acimaDiag(M);
      System.out.println("O maior valor="+l);
   }  
   public static double acimaDiag(double[][]M)
//Objetivo: determina qual o maior valor acima da diagonal principal
//Argumentos:matriz real   
//Valor gerado: real maior valor acima da diag.princ.    
   {
      double maior=M[0][1];
      for(int i=0;i<M.length;i++)
      {
         for(int j=i+1;j<M[0].length;j++)
         {
            if(M[i][j]>maior)
            maior=M[i][j];
         }   
      }
      return maior;
   }
}