import java.util.Scanner;
public class Lista001
{
   public static void main(String[]args)
   {
   Scanner s= new Scanner (System.in);
   int idade,
       dias,
       diasvividos;
   idade= s.nextInt();
   dias=365;
   diasvividos=dias*idade;
   System.out.print(diasvividos); 
   }
}           