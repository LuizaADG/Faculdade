public class Lista09_2
{
   public static void main(String[]args)
   {
      int A[];
      A=new int[3];
      A[0]=2;
      A[1]=4;
      A[2]=9;
      int j=1,
          n=0;
      trocarDois(A,j,n);    
   }
   public static void trocarDois(int A[], int j,int n)
   {
      int i=A[n];
      A[n]=A[j];
      A[j]=i;
      System.out.print("0 1 termo="+A[0]+" 0 2="+A[1]+" O terceiro="+A[2]);
   }
}