//Nome do programa: Lista07_3 
//Data da elaboração: 02/04/17
//Autor: Luiza
//Objetivo: Converte minutos em segundos
//Argumentos: minutos, segundos
//Valor gerado: segundos
import java.util.Scanner;
public class Lista07_3
{
   public static void main(String[]args)
   {
      double min,
             seg;
      min=leia();
      seg=conversao(min);
      escreva(seg);
   }
   public static double leia()
   {
      Scanner s= new Scanner(System.in);
      double min;
      System.out.println("Digite o numero de minutos");
      min=s.nextDouble();
      return min;
   } 
   public static double conversao(double min)
   {
      double seg=min*60;
      return seg;
   }
   public static void escreva(double seg)
   {
      System.out.println("O numero de minutos =" +seg+"segundos");
   }
}