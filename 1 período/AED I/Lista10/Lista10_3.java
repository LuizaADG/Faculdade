//Nome do programa: Chave de Pesquisa
//Data da elaboração: 26/04/17  
//Autor: Luiza
public class Lista10_3
{   
   public static void main(String[]args)
   {
      double [][]M= {{1,2,3,4},{2,3,4,5},{1,3,5,7},{2,4,6,8}};
      double resultado=chavePesquisa(M);
      System.out.println(resultado);
   }
   public static double chavePesquisa(double[][]M)
//Objetivo: determinar se um número aparece na matriz
//Argumentos:matriz real   
//Valor gerado: inteiro soma   
   {
      int soma=0;
      for(int i=0;i<M.length;i++)
      {
         for(int j=0; j<M.length;j++)
         {
            if(M[i][j]==3)
            {
               soma=soma+1;
            }
         }
      }
   return soma;   
   }   
}