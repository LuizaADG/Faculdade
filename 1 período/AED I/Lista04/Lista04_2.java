import java.util.Scanner;
public class Lista04_2  
{
   public static void main (String []args)
   {
      double t,
             B=100,
             n;
     Scanner s=new Scanner(System.in);
      System.out.print("Digite o numero de termos");
      n=s.nextInt();    
      for(int a=1;a<=n;a++)
      {
         if (a%2==1)                                                    
         {
            t=(double)a/(double)B;
         }else
         {
            t=(double)B/(double)a; 
         }
         B=B-3;
     System.out.println("O valor de "+a+"="+ t);    
     }//fim de for a
   }//fim de main
}//fim de class    