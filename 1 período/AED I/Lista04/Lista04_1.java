import java.util.Scanner;
public class Lista04_1  
{
   public static void main (String []args)
   {
      double H=0,
             t,
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
         H=H+t;
     }//fim de for a
   System.out.print("O valor de H="+H);
   }//fim de main
}//fim de class                                                