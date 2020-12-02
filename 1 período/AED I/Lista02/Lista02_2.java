import java.util.Scanner;
public class Lista02_2
{
   public static void main(String[]args)
   {
      double A,
             B,
             C;      
      Scanner s= new Scanner( System.in);       
      System.out.print("Digite os lados do triangulo");
      A=s.nextDouble();
      B=s.nextDouble();
      C=s.nextDouble();
      if ((A+B>C)&&(A+C>B)&&(B+C>A))
         {
         System.out.print("O triangulo é valido");
         if ((A==B)&&(B==C))
            {
            System.out.print(" e equilatero");
            }
         if ((A==B)&&(A!=C)||(A==C)&&(A!=B))
            {
            System.out.print(" e isosceles");
            }
         if ((A!=B)&&(A!=C))
            {
            System.out.print(" e escaleno");
            }
         }//fim de if
     else 
      {
      System.out.print("O triangulo nao é valido");
      }
   }//fim de main
}// fim da classe   
                      
