import java.util.Scanner;
public class Lisa03_1B
{
   public static void main (String[]args)
   {
      char    op,
              esc;
      double  resultado,
              A,
              B;
      do
      {
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
         System.out.print ("O resultado="+resultado+"\n Sair do programa?Digite 'v' se sim, e 'f' se não");
         esc=leia.next().charAt(0);
         if (esc=='v') System.out.print("Obrigada por usar o programa");
      }while(esc=='f');
  }//fim de main
}//fim da classe              