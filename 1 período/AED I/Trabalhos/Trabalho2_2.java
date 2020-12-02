//Nome do programa: Exemplo
//Data da elaboração: 29/04/17  
//Autor: Luiza
import java.util.Scanner;
public class Trabalho2_2 
{
	public static void main(String[] args) 
   {
		double[][] M = new double[5][5];
		leMatriz(M);
		double maior = maiorMatriz(M); // maior valor da matriz
		double diagonalSec = somaDiagonalSec(M);  // soma da diagonal secudária
		if ( haZeros(M) ) 
      {  // verifica se há valores iguais a zero na matriz
			System.out.println("Ha " + qtZeros(M) + " valores iguais a zero."); // Qtde de zeros
		} // fim if
		System.out.println("Maior valor na matriz = " + maior);
		System.out.println("Soma da diagonal Secundaria= " + diagonalSec);
		double[][] N = new double[5][5];
		leMatriz(N);
		if ( linhasIguais(M,N,0) ) 
      {  // verifica se a primeira linha de ambas as matrizes são iguais
			System.out.println("A primeira linha das Matrizes sao iguais."); 
		} // fim if
	} // fim main()
   public static void leMatriz(double[][]X)
//Objetivos:colocar números na matriz
//Argumentos:matriz real
//Valor de retorno: nenhum   
   {
      Scanner s= new Scanner(System.in);
      for(int i=0;i<X.length;i++)   
      {
         for(int j=0;j<X[0].length;j++)
         {
            System.out.println("Insira o valor da linha "+i+" coluna"+j);
            X[i][j]=s.nextInt();
         }
      }
   }
   public static double maiorMatriz(double [][]X)
//Objetivos: determinar maior valor em uma matriz
//Argumentos:matriz real
//Valor de retorno: real maior valor da matriz     
   {
      double maior=0;
      int i, 
          j;
      for(i=0;i<X.length;i++)
      {
         for(j=0;j<X[0].length;j++)
         {
            if(X[i][j]>maior)
            {
               maior=X[i][j];
            }
         }
      }
    return maior;           
   }
   public static double somaDiagonalSec (double[][]X)
//Objetivos: determinar soma da diagonal secundaria
//Argumentos:matriz real
//Valor de retorno: real soma da diag. secundária
   {
      double soma=0;
      for (int i=X.length-1; i>=0;i--)
      {
         for(int j=X[0].length-1;j>=0;j--)
         {
            soma=X[i][j]+soma;
         }
      }
      return soma;
   }
   
   public static boolean haZeros(double [][]X)
//Objetivos:mandar parametros
//Argumentos:matriz real
//Valor de retorno: nenhum   
   {
      return haZeros(X, 0, 0);
   }
   
   public static boolean haZeros(double [][]X, int i, int j)
//Objetivos: determinar se em uma matriz há zeros ou não
//Argumentos:matriz real, inteiros linha e coluna
//Valor de retorno: boolean 
   {
      boolean temzero = false;
      if (i < X.length)
      {
         if (j < X[0].length)
         {
            if(X[i][j]==0) 
            {
               temzero = true;
            }else{
               if(j+1 >= X[0].length)
               {
                  temzero = haZeros(X, i+1, 0);
               } else{
                  temzero = haZeros(X, i, j+1);
               }
            }
         }
      }
      return temzero;           
   } 
   public static int qtZeros (double[][]X)
//Objetivos:mandar parametros
//Argumentos:matriz real
//Valor de retorno: nenhum     
   {
      return qtZeros(X, 0, 0);
   }  
   public static int qtZeros (double[][]X, int i, int j)
//Objetivos: determinar a quantidade de zeros na matriz
//Argumentos:matriz real, inteiros linha e coluna
//Valor de retorno: inteiro quantidade de zeros     
   {
      int qtd=0;
      if (i < X.length)
      {
         if (j < X[0].length)
         {
            if(X[i][j]==0) 
            {
               if(j+1 >= X[0].length)
               {
                  qtd = 1 + qtZeros(X, i+1, 0);
               } else
               {
                  qtd = 1 + qtZeros(X, i, j+1);
               }
            }else{
               if(j+1 >= X[0].length)
               {
                  qtd = qtZeros(X, i+1, 0);
               } else
               {
                  qtd = qtZeros(X, i, j+1);
               }
            }
         }
      }
      
      return qtd;
    }
   
   public static boolean linhasIguais( double[][]M, double N[][], int comp)
//Objetivos: determinar se a primeira linha da matriz m é igual a da matriz n
//Argumentos:matrizes reais e número inteiro da linha
//Valor de retorno: boolean
   {
      boolean iguais=true;
      int x=0;
      for(int j=0; j<M[0].length;j++)
      {
         if(M[comp][j]==N[comp][j])
         {
            x=x+1;
         }
      }
      if (x==M.length)
      {
         iguais=true;
      }else{
         iguais=false;
      }
      return iguais;   
   } 
} // fim classe Trabalho2_2
