import java.util.Scanner;
public class Lista03_6
{
   public static void main(String[]args)
   {
      char r;
      int ano;
      Scanner leia= new Scanner(System.in);
      do
      {
         System.out.print("Digite um ano");
         ano=leia.nextInt();
         if (ano%400==0||(ano%100!=0&&ano%4==0)) 
         {
         System.out.print("O ano e bissexto.");
         }
         else
         {
         System.out.print("O ano não e bissexto.");
         }
      System.out.println(" Deseja continuar? Digite 's' se sim e 'n' se não");
      do 
      {
         r=leia.next().charAt(0);
         if (r!='n'&&r!='s')  
         {
         System.out.print("Erro.Digite novamente.");
         } 
      }while (r!='n'&&r!='s');   
     } while (r=='s');
    {    
    System.out.print("Obrigada para usar o programa");
    }  
   }      
}                    