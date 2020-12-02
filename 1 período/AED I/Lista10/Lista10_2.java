//Nome do programa: Matrizes iguais
//Data da elaboração: 26/04/17  
//Autor: Luiza
public class Lista10_2
{
   public static void main(String[]args)
   {
      double [][]M= {{1,2,3,4},{2,3,4,5},{1,3,5,7},{2,4,6,8}};
      double [][]N= {{1,2,3,4},{2,3,4,5},{1,3,5,7},{2,4,6,8}};
      iguais(M,N);
      if (iguais(M,N))
      {
         System.out.println("Iguais");
      }else{
         System.out.println("Diferentes");
      }
   }
   public static boolean iguais(double [][]M, double [][]N)
//Objetivo: determinar se duas matrizes são iguais
//Argumentos:duas matrizes reais   
//Valor gerado: boolean
   {
      int i=0,
          j;
      while(i<M.length)
      {
         j=0;
         while(j<M.length&&M[i][j]==N[i][j])
         {
            j++;
         }
         if(j<M[i].length)
         {
            return false;
         }   
         i++;
      }
   return true;       
   }
}