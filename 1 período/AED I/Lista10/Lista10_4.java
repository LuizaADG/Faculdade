//Nome do programa: Maior Valor Linha
//Data da elabora��o: 26/04/17  
//Autor: Luiza
public class Lista10_4
{
   public static void main (String[]args)
   {
      double [][]M= {{1,2,3},{2,3,4},{1,3,5},{2,4,6}};
      maiorValor(M);
      double linha=(maiorValor(M));
      System.out.print(linha);
   }
   public static double maiorValor(double[][]M)
//Objetivo: determinar o maior valor de uma matriz e retornar sua posi��o
//Argumentos:matriz real   
//Valor gerado: real posi��o do valor 
   {
      double maior=M[0][0];
      int c=0,
          l=0;
      for(int i=0;i<M.length;i++)
      {
         for (int j=0; j<M[0].length;j++)
         {
            if (M[i][j]>maior)
            {
               maior =M[i][j];
               l=i;
            }
         }
      }
   return l;   
   }
}