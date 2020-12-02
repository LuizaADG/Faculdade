import java.util.Scanner;
public class Lista02_3
{
   public static void main(String[]args)
   {
      char gen;
      double alt,
             peso1,
             peso2;
      Scanner s=new Scanner (System.in);
      System.out.print("Digite o sexo como feminino ou masculino");
      gen=s.nextLine().charAt(0);   
      System.out.print("Digite a altura");   
      alt=s.nextDouble();
      peso1=(alt*62.1)-44.7;
      peso2=(alt*72.7)-58.0;
      if (gen=='f');
         {
         System.out.print(peso1);
         }
      if(gen=='m')
         {
         System.out.print(peso2);
         }
   }
}               