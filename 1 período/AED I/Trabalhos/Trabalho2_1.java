//Nome do programa: Grafo de relações de amizade entre pessoas  
//Data da elaboração: 29/04/17  
//Autor: Luiza
import java.util.Scanner;
public class Trabalho2_1
{
   public static void main (String[]args)
   {
      Scanner s=new Scanner(System.in);
      int leMenu=-1,
          numpessoas=0;
      do
      {
         System.out.println("Quantas pessoas deseja cadastrar? Max:100");
         numpessoas=s.nextInt();
         if(numpessoas<0||numpessoas>100)System.out.println("Erro");
      }while (numpessoas<0||numpessoas>100);   
      int [][]M=new int [numpessoas][numpessoas];
      do
      {
         leMenu=Menu();
         switch (leMenu)
         {
            case 0:
               break;
            case 1: cadastro(M);
               break;   
            case 2: pesquisaRel(M);
               break;
            case 3: int soma=pesquisaNrel(M);
               System.out.println("A pessoa escolhida mantem "+soma+" relacoes de amizade");
               break;
            case 4: boolean anomalia= pesquisaAnom(M);
               if(anomalia)
               {
                  System.out.println("A pessoa tem amizade com ela mesma");
               }else
               {
                  System.out.println("A pessoa nao tem amizade com ela mesma");
               }
               break;
         }//fim de switch
      }while(leMenu!=0);               
   }
   public static int Menu()
//Objetivo: selecionar qual das opções o usuário quer exercer
//Argumentos:nenhum   
//Valor gerado: inteiro da lista
   {
      Scanner s= new Scanner(System.in);
      System.out.println("Para sair digite 0");
      System.out.println("Para cadastrar as relacoes de amizade digite 1");
      System.out.println("Para pesquisar quais as relacoes de amizade de uma pessoa digite 2");
      System.out.println("Para pesquisar o numero as relacoes de amizade de uma pessoa digite 3");
      System.out.println("Para verificar se há uma relacao de amizade de uma pessoa com ela mesma digite 4");
      int leMenu=s.nextInt();
      return leMenu;
   }
   public static int cadastro(int [][]M)
//Objetivo: colocar valores 1 ou 0 na matriz dependendo das relações entre as pessoas 
//Argumentos:matriz real   
//Valor gerado: nenhum
   {
      Scanner s=new Scanner(System.in);
      int l=0,
          g=-1,
          i=-1,
          j=-1,
          x=-1;
      for (g=0;g<M[0].length;g++)
      {
         do
         {
            System.out.println("Se a pessoa da posicao linha "+(l+1)+" e coluna"+(g+1)+" sao amigas, digite 1, caso contrario, digite 0");
            x=s.nextInt();
            M[l][g]=x;
            M[g][l]=M[l][g];
            if (x!=0 && x!=1) System.out.println("Erro");
         }while (x!=0 && x!=1);   
      }    
      for(i=1; i<M.length;i++)
      {   
         for(j=1;j<M[0].length;j++)
         {
            do
            {
               System.out.println("Se a pessoa da posicao linha "+(i+1)+" e coluna "+(j+1)+" são amigas, digite 1, caso contrário, digite 0");
               M[i][j]=s.nextInt();
               M[j][i]=M[i][j];
               if (M[i][j]!=0 && M[i][j]!=1) System.out.println("Erro");
            }while (M[i][j]!=0 && M[i][j]!=1);   
         }     
      }
      return 0;
   }
   public static int pesquisaRel(int[][]M)
//Objetivo: pesquisar quais as relações de uma pessoa
//Argumentos:matriz real   
//Valor gerado: nenhum
   {
      int pes=0,
          i=-1;
      Scanner s= new Scanner(System.in);
      do
      {
         System.out.println ("Digite o numero da pessoa a relacionar(linha em que esta. Comece de 1)");
         pes=s.nextInt();
         if(pes<1 || pes>M.length) System.out.println("Erro");
      }while(pes<1 || pes>M.length);   
         for(i=0;i<M.length;i++)
         {
            if(M[pes-1][i]==1)
            {
               System.out.println("Mantem relacoes de amizade com pessoa "+(i+1));
            }
         }
   return 0;      
   }
   public static int pesquisaNrel(int[][]M)
//Objetivo: pesquisar com quantas pessoas determinada pessoa mantém relações de amizade
//Argumentos:matriz real   
//Valor gerado: inteiro quantidade de pessoas
   {
      int pes=0;
      Scanner s=new Scanner(System.in);
      int soma=0;
      do
      {
         System.out.println ("Digite o numero da pessoa a relacionar(linha em que está, começando do 1)");
         pes=s.nextInt();
         if(pes<1||pes>M.length) System.out.println("Erro");
      }while(pes<1||pes>M.length);   
         for(int i=0;i<M.length;i++)
         {
            if(M[i][pes-1]==1)
            {
               soma=soma+1;
            }
         }
   return soma;      
   }
   public static boolean pesquisaAnom(int [][] M)
//Objetivo: determinar se uma pessoa é amiga dela mesma
//Argumentos:matriz real   
//Valor gerado: boolean
   {
      int pes=0;
      Scanner s=new Scanner (System.in);
      boolean anomalia=true;
      do
      {
         System.out.println("Digite a pessoa que se deve pesquisar a anomalia (comece com 1)");
         pes=s.nextInt();
         if(pes!=1 && pes!=M.length) System.out.println("Erro");
      }while(pes!=1 && pes!=M.length);  
      if (M[pes][pes]==1)
      {   
         anomalia=true;
      }else{
         anomalia=false;
      }
      return anomalia;   
   }
}