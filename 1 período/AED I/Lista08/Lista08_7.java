import java.util.Scanner;
public class Lista08_7
{
   public static void main(String[]args)
   {
      int n,
          x;
      Scanner s= new Scanner(System.in);    
      System.out.println("Digite o 1 numero");
      n=s.nextInt();
      System.out.println("Digite o ultimo numero");
      x=s.nextInt();    
      sequenciaEinverso(n,x);
   }
   public static void sequenciaEinverso(int n, int x)
   //escrever de um numero ao outro e voltar de forma que o usuario escolhe os numeros
   {
      if(n<=x)
      {
          System.out.println(n);
          sequenciaEinverso(n+1,x); 
          System.out.println(n);
  
      }   
   }
}