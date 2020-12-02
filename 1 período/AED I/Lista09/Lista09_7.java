public class Lista09_7
{
   public static void main(String[]args)
   {
      fibonacci(); 
   }
   public static void fibonacci()
   {
      int F[]=new int [10];
      F[0]=1;
      F[1]=1;
      for(int i=2; i<F.length;i++)
      {
         F[i] = F[i-1] + F[i-2];
      }
      for(int j=0; j< F.length; j++) 
      {
         System.out.print(F[j] + " ");
      }
   }
}