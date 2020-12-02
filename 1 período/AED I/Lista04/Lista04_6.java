import java.util.Scanner;
public class Lista04_6
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
      char gen;
      boolean ERRO;
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
            System.out.println("Digite 'm' para mulher e 'h' para homem");
            gen=s.next().charAt(0);
            ERRO=gen!='m'&&gen!='h';
            if(ERRO)System.out.println("Erro"); 
         } while (ERRO);
         do
         {
            System.out.println("Digite sua idade");
            idade=s.nextInt();
            ERRO= idade<0||idade>100;
            if (ERRO)System.out.println("Erro");
         }while (ERRO);
         
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