//Nome do programa: Lista07_6 
//Data da elaboração: 02/04/17
//Autor: Luiza
//Objetivo: Determina o tipo de triangulo
//Argumentos: lados,tipo
//Valor gerado: valor numerico correspondente ao tipo
import java.util.Scanner;
public class Lista07_6
{
   public static void main(String[]args)
   {
      int v,
          lado1,
          lado2,
          lado3;
      lado1=leiaLado1();
      lado2=leiaLado2();
      lado3=leiaLado3();
      v=idTipo(lado1,lado2,lado3);
      System.out.println("Caso o valor de retorno=0, não e um triangulo, caso seja 1 e equilatero, 2 e isosceles e 3 e escaleno");
      System.out.println(v);    
   }
   public static int leiaLado1()
   {
      int lado1;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite o 1 lado");
      lado1=s.nextInt();
      return lado1;
   }       
   public static int leiaLado2()
   {
      int lado2;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite o 2 lado");
      lado2=s.nextInt();
      return lado2;
   }       
   public static int leiaLado3()
   {
      int lado3;
      Scanner s= new Scanner(System.in);
      System.out.println("Digite o 3 lado");
      lado3=s.nextInt();
      return lado3;
   } 
   public static int idTipo(int lado1,int lado2,int lado3)
   {
      int v=0;
      boolean equi,
              iso,
              nop,
              esc;
      equi=lado1/lado2==1&&lado3/2==1;
      iso=(lado1/lado2!=1&&lado1/lado3==1)||(lado2/lado3!=1&&lado2/lado1==1)||(lado3/lado1!=1&&lado3/lado2==1);
      esc=lado1/lado2!=1&&lado2/lado3!=1;
      nop=lado1>(lado2+lado3);
      if (equi) v=1;
      if (iso) v=2;
      if (esc) v=3;
      if (nop) v=0;
      return v;
   }         
}