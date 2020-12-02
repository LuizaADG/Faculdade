import java.util.Scanner;
public class Lista04_7
{
   public static void main(String[]args)
   {
      int n,
          idade,
          maior=0,
          h=0,
          m=0,
          a=0;
      double media;
      char gen,
            M;
      boolean ERRO1,
              ERRO2;
      Scanner s= new Scanner(System.in);
      do
      {
         System.out.println("Digite a quantidade de alunos");
         n=s.nextInt();
         if(n<1)System.out.println("Quantidade inválida."); 
      }while(n<1);
      
         for(int i=0;i<n;i++)
         {
          do
          {  
             do
             {
                System.out.println("Digite sua idade");
                idade=s.nextInt();
                ERRO2= idade<0||idade>100;
                if (ERRO2)System.out.println("Erro");
             }while (ERRO2);
             do
            {   
               System.out.println("Digite 'm' para mulher e 'h' para homem e 's' para sair");
               gen=s.next().charAt(0);
               ERRO1=gen!='m'&&gen!='h'&&gen!='s';
               if(ERRO1)System.out.println("Erro");
               if(gen=='s') System.out.println("Obrigada por usar o programa");  
               M=gen;
            }while(ERRO1);  
           } while (M!='s');
            if (idade>=18) maior++;
            a=idade+a;
            if(gen=='m')m++;
            if(gen=='h')h++;
         } 
       media= (double)a/(double)n;
      System.out.println(" A media da idade dos alunos="+media);
      System.out.println("a porcentagem de homens e de"+((double)h/(double)n)*100);
      System.out.println("a porcentagem de mulheres ="+((double)m/(double)n)*100);
      System.out.println("a porcentagem de maiores e"+((double)maior/(double)n)*100);
   }   
}