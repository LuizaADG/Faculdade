import java.util.Scanner;
public class Lista04_3
{
   public static void main(String[]args)
   {
      int c,
          a=1,
          n=0,
          b=0,
          c2=0,
          c1=0,
          i;    
      Scanner s=new Scanner(System.in);
      do 
      {
         System.out.println("Digite o numero de alunos");
         i=s.nextInt();
         if (i==0) System.out.println("Erro, digite novamente"); 
      }while (i==0);   
      do 
      {
        System.out.println("Digite 1 para a chapa 1 , 2 para a chapa 2, 3 para branco, 4 para nulo e 0 para sair do programa");
        c=s.nextInt(); 
        if (c==1)c1++;
        if (c==2)c2++;
        if (c==3)b++;     
        if (c==4)n++; 
        if (c==0)System.out.println("Obrigada por usar o programa");
        a++;
      }   
      while (a<=i&&c!=0);   
        if (c2>c1) 
        {
         c2=c2+b;
         System.out.print("Chapa dois ganhou com "+((double)c2/(double)i)*100+"% dos votos");
        } 
        if (c1>c2) 
        {
         c1=c1+b;
         System.out.print("Chapa um ganhou com "+((double)c1/(double)i)*100+"% dos votos");
        } 
        if (c1==c2&&c1!=0&&c2!=0)System.out.print("Empate");
        if (c<0||c>4)System.out.print("Erro, digite novamente"); 
        if (n>c1&&n>c2) System.out.println("Maioria voto nulo. Refaça votacao");    
   }//fim de main
}//fim de class        
                  