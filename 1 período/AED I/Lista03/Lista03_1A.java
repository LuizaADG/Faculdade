import java.util.Scanner;
public class Lista03_1A
{
   public static void main (String[]args)
   {
      char    op;
      double  resultado,
              A,
              B;
      System.out.print("Digite 'm' para multiplicação, 'd' para divisão, 's' para subtração e 'a' para adição");
      Scanner leia=new Scanner (System.in);
      op=leia.next().charAt(0);
      System.out.print("Digite os dois números");
      A=leia.nextDouble();
      B=leia.nextDouble();
      switch (op)
      {
         case 'm':resultado=A*B;
              break;
         case 'd': resultado=A/B;
              break;
         case 'a':resultado=A+B;
              break;     
         case's': resultado=A-B;
              break;
         default:resultado=0;
      }//fim switch
      System.out.print ("O resultado="+resultado);
   }//fim de main
}//fim da classe                                                                                   