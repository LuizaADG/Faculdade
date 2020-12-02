//Data:06/06/17
import java.util.Scanner;
public class TF_1
{
   public static void main(String[]args)
   {
      double A[][]=new double [2][2];
      double At[][]=new double[2][2];//matriz transposta
      escreve(A);
      maiorVLinha(A);
      mediaDiagP(A);
      maiorValorAbaixoDiagP(A);
      numeroColunaMaiorV(A);
      trasposicaoMatriz(A,At);
   }
   public static void escreve(double A[][])//método para prencher a matriz
   {
      Scanner s=new Scanner(System.in);
      for(int i=0; i<A.length;i++)
      {
         for(int j=0; j<A[0].length;j++)
         {
            System.out.printf("Digite um numero da posicao %d e %d",(i+1),(j+1));
            A[i][j]=s.nextDouble();
         }//fim de for2
      }//fim de for1
   }//fim de escreve
   public static void maiorVLinha (double [][]A)//método para imprimir o maior valor de cada linha
   {
      double maior=0;
      for(int i=0; i<A.length;i++)
      {
         for(int j=0; j<A[0].length;j++)
         {
            maior=A[i][j];
            if(A[i][j]>maior)
            {
               maior=A[i][j];
            }//fim de if
         }//fim de for2
         System.out.println("Maior da linha "+(i+1)+"= "+maior);
      }//fim de for1 
   }//fim de maiorVLinha
   public static void mediaDiagP (double A[][])//método para fazer a média da diagonal principal
   {
      double soma=0;
      for (int i=0; i<A.length;i++)
      {
         for(int j=0; j<A[0].length;j++)
         {
            if(i==j)
            {
               soma=A[i][j]+soma;
            }//fim de if   
         }//fim de for2
      }//fim de for1
      double media= soma/A.length;
      System.out.println("A media da diagonal principal= "+media);
   }//fim de mediaDiagP
   public static void maiorValorAbaixoDiagP(double [][]A)//método para determinar o maior valor 
   {                                                     //abaixo da diagonal principal   
      double maior=0;
       for (int i=1; i<A.length;i++)
      {
         for(int j=0; j<A[0].length;j++)
         {
            if(A[i][j]>maior)
            {
               maior=A[i][j];
            }//fim de if
         }//fim de for2
      }//fim de for1
   System.out.println("Maior abaixo da diagonal principal= "+maior);                                              
   }//fim de maiorValorAbaixoDiagP
   public static void numeroColunaMaiorV (double [][]A)
   {
      double maior=0;
      int coluna=0;
      for(int i=0; i<A.length;i++)
      {
         for(int j=0; j<A[0].length;j++)
         {
            if(A[i][j]>maior)
            {
               maior=A[i][j];
               coluna=j;
            }//fim de if
         }//fim de for2
      }//fim de for1 
   System.out.println("Na coluna "+(coluna+1)+" esta o maior valor");   
   }//fim de numeroColunaMaiorV
   public static void trasposicaoMatriz (double[][]A, double [][]B)
   {
      for(int i=0; i<A.length;i++)
      {
         for(int j=0;j<A[0].length;j++)
         {
            B[i][j]=A[j][i];
         }//fim de for2
      }//fim de for1
      for(int i=0; i<B.length;i++)
      {
         for(int j=0;j<B[0].length;j++)
         {
            System.out.println("A linha"+(i+1)+" com a coluna"+(j+1)+" eh na matriz transposta"+B[i][j]);
         }//fim de for2
      }//fim de for1

   }//fim de trasposicaoMatriz
}//fim da classe