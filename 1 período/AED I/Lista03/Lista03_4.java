import java.util.Scanner;
public class Lista03_4
{
   public static void main(String[]args)
   {
      int i,
          f;
      System.out.print("Digite o numero inicial da contagem regreassiva");
      Scanner s=new Scanner(System.in);
      i=s.nextInt();
      System.out.print("Digite ultimo numero da contagem");
      f=s.nextInt();
      while (i>=f)
      {
         System.out.println(i);
         i=(i-1);
      }
       while (i<=f)
      {
         System.out.println(i);
         i=(i+1);
      }
   }      
}         