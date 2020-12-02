//Nome do programa: Diferença maior acima e maior abaixo  
//Data da elaboração: 28/04/17  
//Autor: Luiza
public class Lista10_8
{
   public static void main(String[]args)
   {
      double [][]M= {{1,2,3,4},{3,2,11,6},{1,17,3,8},{2,0,10,4}};
      double l=diferencaBaixCim(M);
      System.out.println("Diferenca="+l);
   }
   public static double diferencaBaixCim(double[][]M)
//Objetivo: subtrair do maior acima o maior abaixo
//Argumentos:matriz real   
//Valor gerado: real diferença entre os dois valores   
   {
      double maiorAcima= acimaDiag(M);
      double maiorAbaixo=baixoDiag(M);
      double diferenca=maiorAcima-maiorAbaixo;
      return diferenca;
   }
   public static double acimaDiag(double[][]M)
//Objetivo: calcular o maior valor acima da diagonal principal
//Argumentos:matriz real   
//Valor gerado: real maior valor acima da diagonal princ.   
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
   public static double baixoDiag(double[][]M)
//Objetivo: calcular o maior valor abaixo da diagonal principal 
//Argumentos:matriz real   
//Valor gerado: real maior valor abaixo da diag. princip.    
   {
      double maior=M[M.length-1][M[0].length-2];
      for(int i=M.length-1;i>=0;i--)
      {
         for(int j=i-1;j>=0;j--)
         {
            if(M[i][j]>maior)
            maior=M[i][j];
         }   
      }
      return maior;
   }      

}