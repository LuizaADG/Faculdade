//Nome do programa: Lista07_1 
//Data da elaboração: 02/04/17
//Autor: Luiza
//Objetivo: Verificar aprovação ou não do aluno
//Argumentos: notas, soma,aprovado,mensagem
//Valor gerado: aprovação 
import java.util.Scanner;
public class Lista07_1
{
   public static void main (String[]args)
   {
      double nota1,
             nota2,
             soma;
      boolean aprovado,
              mensagem;          
      apresentacao();
      nota1=leNota1();
      nota2=leNota2();
      soma=soma(nota1,nota2);  
      aprovado=aprovado(soma);
      mensagem=mensagem(aprovado);
   }
   public static void apresentacao ()
   {
      System.out.println("O programa a seguir verificara se o aluno foi aprovado ou não");
   }
   public static double leNota1 ()
   {
      Scanner s= new Scanner(System.in);
      double n;
      do
      {
         System.out.println("Digite a 1 nota");
         n=s.nextDouble();
         if (n<0|| n>50) System.out.println("Valor Inválido");
      }while (n<0 || n>50);    
      return n;
   }   
   public static double leNota2 ()
   {
      Scanner s= new Scanner(System.in);
      double v;
      do
      {
         System.out.println("Digite a 2 nota");
         v=s.nextDouble();
         if (v<0|| v>50) System.out.println("Valor Inválido");
      }while (v<0 || v>50);    
      return v;
   }     
   public static double soma(double v, double n)
   {
      double soma=0;
      soma=v+n;
      return soma;
   }
   public static boolean aprovado(double soma)
   {
      boolean aprovado=true;
      if (soma<60)aprovado=false;
      return aprovado;
   }        
   public static boolean mensagem(boolean aprovado)
   {   
      if (aprovado)
      {
         System.out.println("O aluno foi aprovado");
      }
      else
      {
         System.out.println("O aluno não foi aprovado");
      }
      return aprovado;
   }      
}