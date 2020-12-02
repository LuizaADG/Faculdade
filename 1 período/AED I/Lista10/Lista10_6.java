//Nome do programa: Determinar Primeira Linha=Diagonal 
//Data da elaboração: 28/04/17  
//Autor: Luiza
public class Lista10_6
{
   public static void main(String[]args)
   {
      double [][]M= {{1,2,3,4},{3,2,4,5},{1,7,3,8},{2,5,10,4}};
      boolean v= igualDiag(M);
      if (v)
      {
         System.out.println("Correspondem");
      }else{
         System.out.println("Nao correspondem");
      }
   }
   public static boolean igualDiag(double [][]M)
//Objetivo: determinar se a primeira linha de uma matriz é igula a sua diagonal principal 
//Argumentos:matriz real   
//Valor gerado: boolean  
   {
      boolean verdade=true;
      for(int i=0;i<M.length;i++)
      {
         if (M[i][i]==M[0][i])
         {
            verdade=true;
         }else{
            verdade=false;
         }
      }
      return verdade;
   }
}