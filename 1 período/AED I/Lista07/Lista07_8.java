//Nome do programa: Lista07_8 
//Data da elaboração: 02/04/17
//Autor: Luiza
//Objetivo: Calcular a media da turma e apresentar a menor e a maior nota
//Argumentos: nota
//Valor gerado: media, maior e menor
import java.util.Scanner;
public class Lista07_8
{
   public static int lerNota()
   {
      Scanner s= new Scanner(System.in);
      int n;
      do
      {
         System.out.println("Digite a nota. Digite -1 para parar.");
         n=s.nextInt();
         if((n<0||n>100)&&n!=-1)System.out.println("ERRO");
      }while ((n<0||n>100)&&n!=-1);
      return n;
   }//fim lerIdade()  
   public static void main(String[]args)
   {
      int i=0,
          nota,
          soma=0,
          maior=0,
          menor=0;
      double media;    
      Scanner s=new Scanner(System.in);
         nota=lerNota();
         maior=nota;
         menor=nota;
         while(nota!=-1) 
         {
            i++;
            soma=soma+nota;
            if (nota>maior) maior=nota;
            if (nota<menor) menor=nota;
            nota=lerNota();
         }//fim while    
      media=(double)soma/(double)i;
      System.out.println("A media="+media+"a maior nota="+maior+"e a menor="+menor);
   }//fim main
}//fim class             