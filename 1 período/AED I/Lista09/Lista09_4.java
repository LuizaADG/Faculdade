import java.util.Scanner;
public class Lista09_4
{
   public static void main(String[] args) 
   {
        	int[] A = {6, 5, 4, 3, 2, 1};
      	int[] B = {3, 1, 6, 4, 2, 5};
      	int[] C = new int[6];
         leArranjo(C); 
         ordena(A);   
         ordena(B);
   	   ordena(C);  
         escreveArranjo(A);   
         escreveArranjo(B);
	      escreveArranjo(C);
   }
   public static void leArranjo(int C[])
   {
      Scanner s=new Scanner(System.in);
      System.out.println("Digite uma sequencia de 6 numeros p/ armazenar no arranjo");
      for(int i=0;i<C.length;i++)
      {
         C[i]=s.nextInt();
      }
   }
   public static void ordena(int X[])
   {
      int n;
      for (int i=0;i<X.length;i++)
      {
         for (int l=0;l<X.length-1;l++)
         {
            if (X[l]>X[l+1])
            {
               n=X[l];
               X[l]=X[l+1];
               X[l+1]=n;
            }   
         }   
      }
   }
   public static void escreveArranjo(int X[])
   {
      for (int i=0; i<X.length;i++)
      {
         System.out.println("O numero "+(i+1)+" do arranjo="+X[i]);
      }
   }
}         