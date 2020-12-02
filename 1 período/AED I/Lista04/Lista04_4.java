import java.util.Scanner;
public class Lista04_4
{
   public static void main (String []args)
   {
     int ant=1,
         novo,
         atual=1,
         i=1,
         n;
     Scanner s=new Scanner (System.in);
     System.out.println("Digite a quantidade de numeros da sequencia");
     n=s.nextInt();  
     System.out.println(atual + " ");
     while (i<n)
     {
      System.out.println(atual+" ");
      novo=atual+ant;
      ant=atual;
      atual=novo;
      i++;
     } 
   } 
}              
    
         
     
          