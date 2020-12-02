//Nome do programa:  Soma de coluna determinada
//Data da elaboração: 28/04/17  
//Autor: Luiza
import java.util.Scanner;
public class Lista10_9
{
   public static void main(String[]args)
   {
      Scanner s= new Scanner (System.in);
      double [][]M= {{1,2,3,4},{3,2,11,6},{1,17,3,8},{2,0,10,4}};
      int x=0;
      do
      { 
         System.out.println("Digite o numero da coluna");
         x=s.nextInt();
         if(x<0||x>3) System.out.println("Erro. Numeros de 0 a 3");
      }while (x<0||x>3);   
      double soma=somaColuna(M,x);
      System.out.println("A soma da coluna "+x+" = "+soma);
   }
   public static double somaColuna(double [][]M, int x)
//Objetivo: calcular a soma de determinada coluna da matriz
//Argumentos:matriz real e valor inteiro relativo a coluna  
//Valor gerado: real soma da coluna da matriz
   {
      double soma=0;
      int l=M[0].length-1;
      do
      {
         for (int i=0; i<M.length; i++)
         {
            soma=soma+M[i][x];
            l--;
         }
      }while(l>=0);
      return soma;
   }
}