import java.util.Scanner;
public class Lista05_3
{
   public static void main(String[]args)
   {
      int a,
          r,
          n=1,
          x,
          i=0,
          t,
          b;
      char SAIR;    
		Scanner leia = new Scanner(System.in);
		do
      {
         System.out.println("Digite o primeiro termo da PA");
   		a=leia.nextInt();
   		System.out.println("Digite a razão");
   		r=leia.nextInt();
   		System.out.println("Digite o número de termos");
   		b=leia.nextInt();
         System.out.println("Digite o número para a divisão");
         x=leia.nextInt();
         while(b!=n-1)
   		{
   			t=(a+(n-1)*r);
   			n++;
   			System.out.println(t);
            if (t%x==0)i++;
   		}
         System.out.println("O número de termos da PA divisiveis pelo numeo"+x+" ="+i);  
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