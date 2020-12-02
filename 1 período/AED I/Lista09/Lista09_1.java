public class Lista09_1
{
   public static void main (String[]args)
   {
      int A[];
      A= new int[3];
      A[0]=2;
      A[1]=4;
      A[2]=9;
      trocarElem(A);
      System.out.print("0 1 termo="+A[0]+" 0 2="+A[1]+" O terceiro="+A[2]);
   }
   public static void trocarElem(int A[])
   {
      int i=0,
          j=A[i];
      A[i]=A[A.length-1];
      A[A.length-1]=j;
   }
}