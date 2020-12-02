//Nome do programa: calcula o n�mero de ocorr�ncias em uma matriz que seu valor m�dio 
//Data da elabora��o: 26/04/17  
//Autor: Luiza
public class Lista10_5
{
   public static void main(String[]args)
   {
       double [][]M= {{1,2,3},{2,3,4},{1,3,5},{2,4,6}};
       double s = maiorMedia(M);
       System.out.println("O numero de vezes que aparecem um numero maior que a media="+s);
   }
   public static double media(double [][]M)
//Objetivo: determinar a media da matriz
//Argumentos:matriz real   
//Valor gerado: real m�dia da matriz    
   {
      double soma=0,
             c=0;
      for (int i=0; i<M.length;i++)
      {
         for(int j=0;j<M[0].length;j++)
         {
            soma=soma+M[i][j];
            c++;        
         }   
      }
      double media=soma/c;
      return media;
   }   
   public static double maiorMedia(double[][]M)
//Objetivo: determinar quantos n�meros na matriz s�o maiores que sua m�dia
//Argumentos: matriz real   
//Valor gerado: real quantidade de n�meros  
   {
      int soma=0;
      double med= media(M);
      for(int i=0;i<M.length;i++)
      {
         for(int j=0; j<M[0].length;j++)
         {
            if(M[i][j]>med)
            {
               soma=soma+1;
            }
         }
      }
   return soma;   
   }   
}