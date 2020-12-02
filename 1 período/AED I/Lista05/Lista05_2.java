import java.util.Scanner;
public class Lista05_2
{
   public static void main(String[]args)
   {
      int n,
          maior=0,
          amp,
          menor;
      char SAIR;
      boolean ERRO;
      Scanner leia= new Scanner(System.in);    
      do
      {   
         do
         {     
            System.out.println("Digite o número. Para encerrar a leitura digite 0");
            n=leia.nextInt(); 
            ERRO=n<0;
            if (ERRO) System.out.println("Valor inválido");
            menor=n;
         }while(ERRO);
         while(n!=0)
         {
            System.out.println("Digite o número. Para encerrar a leitura digite 0");
            n=leia.nextInt(); 
            ERRO=n<0;
            if (ERRO) System.out.println("Valor inválido");
            if (n>maior) maior=n;
            if (n<=menor&&n!=0)menor=n; 
         }  
      amp=maior-menor;      
      if (amp!=0)System.out.println("A amplitude="+amp); 
      if(amp==0) System.out.println("Nenhum valor informado");
      System.out.println("Deseja sair do programa? Digite 's' para sair e 'c' para continuar");      
      do
      {
         SAIR=leia.next().charAt(0);
         if (SAIR!='c'&&SAIR!='s')  
         {
         System.out.print("Erro.Digite novamente.");
         } 
      }while (SAIR!='c'&&SAIR!='s');
   }while(SAIR!='s');
   System.out.print("Obrigada para usar o programa");    
  }
}              