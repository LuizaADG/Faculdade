import java.util.Scanner;
public class DistanciaPontos
{
   public static void main (String[]args)
   {
   double xa,
          xb,
          ya,
          yb,
          op1,
          op2,
          distancia;
   Scanner s= new Scanner(System.in);
   System.out.println("Insira x do 1 ponto");
   xa=s.nextDouble();
   System.out.println("Insira y do 1 ponto");
   ya=s.nextDouble();
   System.out.println("Insira x do 2 ponto"); 
   xb=s.nextDouble(); 
   System.out.println("Insira y do 2 ponto");   
   yb=s.nextDouble();
   op1=Math.pow(xb-xa,2);
   op2=Math.pow(yb-ya,2);
   distancia=Math.sqrt(op1+op2);
   System.out.println("A distancia entre os dois pontos é"+distancia);
   }
}   
   
   