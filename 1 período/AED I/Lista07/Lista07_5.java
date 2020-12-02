//Nome do programa: Lista07_5 
//Data da elaboração: 02/04/17
//Autor: Luiza
//Objetivo: Calcula o perimetro de um retangulo
//Argumentos: base, altura, perimetro
//Valor gerado: perimetro
import java.util.Scanner;
public class Lista07_5
{
   public static void main(String[]args)
   {
      int base,
          h,
          per;
     base= leituraBase();
     h=leituraAlt();
     per = perimetro(base,h);
     escreva(per);      
   }
   public static int leituraBase()
   {
      int base;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite a base");
      base=s.nextInt();
      return base;
   }
   public static int  leituraAlt()
   {
      int h;
      Scanner s= new Scanner(System.in); 
      System.out.println("Digite a altura");
      h=s.nextInt();
      return h;
   }
   public static int perimetro (int base, int h)
   {
      int per;
      per=(2*base)+(2*h);
      return per;
   }
   public static void escreva(int per)
   {
      System.out.println("O valor do perimetro=" +per);
   }
}