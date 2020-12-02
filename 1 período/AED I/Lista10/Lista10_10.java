//Nome do programa: Valor presente ou não
//Data da elaboração: 28/04/17  
//Autor: Luiza
import java.util.Scanner;
public class Lista10_10
{   
   public static void main(String[]args)
   {
      double [][]M= {{1,2,3,4},{2,3,4,5},{1,3,5,7},{2,4,6,8}};
      double x=0;
      Scanner s=new Scanner (System.in);
      System.out.println("Digite o numero");
      x=s.nextDouble();
      boolean resultado=chavePesquisa(M,x);
      if(resultado)
      {
         System.out.println("Numero esta na matriz");
      }else{
         System.out.println("Numero nao esta na matriz");
      }   
   }
   public static boolean chavePesquisa(double[][]M, double x)
//Objetivo: determinar se determinado valor está presente ou não na matriz
//Argumentos:matriz real e valor real que deve ser pesquisado  
//Valor gerado: boolean
   {
      int v=0;
      boolean verdadeiro=true;
         for(int i=0;i<M.length;i++)
         {
            for(int j=0;j<M.length;j++)
            {   
               if(M[i][j]==x)
               {
                  v=v+1;;
               }
            }     
         }
      if (v>=1)
      {
         verdadeiro=true;
      }else{
         verdadeiro=false;
      }         
   return verdadeiro;   
   }   
}