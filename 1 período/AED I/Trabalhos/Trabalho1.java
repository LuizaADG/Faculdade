import java.util.Scanner;
public class Trabalho1
{
   public static void main(String[]args)
   {
      int leMenu=-1;
      double ArranjoA[];
      ArranjoA=new double[3];
      double ArranjoB[];
      ArranjoB=new double [3];
      double ArranjoC[];
      ArranjoC=new double [ArranjoA.length+ArranjoB.length];
      do
      {
         leMenu=Menu();
         switch (leMenu)
         {
            case 0: 
               break;
            case 1: tamanho(ArranjoA, ArranjoB, ArranjoC);
               break;
            case 2: insereA(ArranjoA);
               break; 
            case 3: insereB (ArranjoB);
               break;
            case 4:calculeC(ArranjoA,ArranjoB,ArranjoC);
               break;
            case 5:maiorA (ArranjoA);
               break;
            case 6:mediaB (ArranjoB);
               break;
            case 7:CmaiorMedia (ArranjoC);
               break;
            case 8:AigualB(ArranjoA,ArranjoB);
               break;
            case 9:Cpositivo(ArranjoC);
               break;
            case 10:ordena(ArranjoC);
               break;
            case 11:printsoma(ArranjoC);
               break;
            case 12:AigualBrecursiva(ArranjoA,ArranjoB);
               break;
            case 13:ZerosArecursiva(ArranjoA,0);      
               break; 
         }//fim switch
      }while (leMenu!=0);
   }//fim main
   public static int Menu()
   {
      Scanner s= new Scanner(System.in);
      System.out.println("Digite 0 para sair");
      System.out.println("Digite 1 para saber tamanho dos arranjos");
      System.out.println("Digite 2 para inserir numeros reais no Arranjo A");
      System.out.println("Digite 3 para inserir numeros reais no Arranjo B");
      System.out.println("Digite 4 para calcular C: uniao dos arranjos A e B");
      System.out.println("Digite 5 para identificar o maior valor em A");
      System.out.println("Digite 6 para descobrir a media dos valores de B");
      System.out.println("Digite 7 para saber o numero de elementos de C maiores que a media desse arranjo");
      System.out.println("Digite 8 para verificar se A e B sao iguais");
      System.out.println("Digite 9 para verificar se os valores de C sao, todos, positivos");
      System.out.println("Digite 10 para saber C em ordem crescente");
      System.out.println("Digite 11 para saber a soma dos valores de C");
      System.out.println("Digite 12 para verificar se A e B são iguais"); 
      System.out.println("Digite 13 para contar o numero de zeros no arranjo A");
      int leMenu=s.nextInt();
      return leMenu;
   }
   public static void tamanho(double ArranjoA[],double ArranjoB[],double ArranjoC[])
   {
      Scanner s=new Scanner(System.in);
      System.out.println("O tamanho de A=" +ArranjoA.length);
      System.out.println("O tamanhode B=" +ArranjoB.length);
      System.out.println("O tamanho de C=" +ArranjoC.length);
   }//fim tamanho
   public static void insereA(double ArranjoA[] )
   {
      Scanner s=new Scanner(System.in);
      for (int i=0; i<ArranjoA.length; i++)
      {
         do
         {
            System.out.println("Digite o numero. Negativos nao serao levados em consideracao");
            ArranjoA[i]=s.nextDouble();  
         }while (ArranjoA[i]<0);
      } 
   }//fim insereA
   public static void insereB (double ArranjoB[])
   {
      Scanner s= new Scanner(System.in);
      for(int j=0; j<ArranjoB.length; j++)
      {
         do
         {
            System.out.println("Digite o numero.Negativos nao serao levados em consideracao");
            ArranjoB[j]=s.nextDouble();
         }while (ArranjoB[j]<0);   
      } 
   }//fim insereB
   public static void calculeC(double ArranjoA[], double ArranjoB[],double ArranjoC[])
   {
      for (int i=0;i<ArranjoA.length;i++)
      {
         ArranjoC[i]=ArranjoA[i];
      }
      int i=0;
      for (int n=3; n<ArranjoC.length;n++)
      {
         ArranjoC[n]=ArranjoB[i];
         i=i+1;
      }    
   }//fim calculeC
   public static void maiorA(double ArranjoA[])
   {
      double maior=0;
      for(int i=0; i<ArranjoA.length;i++)
      {
         if(ArranjoA[i]>maior)
         {
            maior = ArranjoA[i];
         }
      }   
      System.out.println(maior);
   }//fim maiorA
   public static void mediaB(double ArranjoB[])
   {
      double media=0,
             soma=0;
      for (int i=0; i<ArranjoB.length; i++)
      {
         soma=soma+ArranjoB[i];
      }     
      media=soma/ArranjoB.length;
      System.out.println(media);
   }//fim mediaB
   public static void CmaiorMedia (double ArranjoC[])
   {
      int i=0;
      double media=0,
             soma=0,
             n=0;
      for (int v=0; v<ArranjoC.length; v++)
      {
         soma=soma+ArranjoC[v];
      }     
      media=soma/ArranjoC.length;
      for(int f=0; f<ArranjoC.length;f++)
      {
         if(media>ArranjoC[f])
         {
            n++;
         }
      }
      System.out.println(n+" numeros de C sao maiores que "+media);   
   }//fim CmaiorMedia
   public static void AigualB(double ArranjoA[],double ArranjoB[])
   {
      int v=0;
      for(int i=0; i<ArranjoA.length;i++)
      {
         if (ArranjoA[i]==ArranjoB[i])
         {
            v++;
         }
      }
      if (v==ArranjoA.length)
      {
         System.out.println("Os dois arranjos sao iguais");
      }
      else 
      {
         System.out.println("Os dois arranjos sao diferentes");
      }    
   }//fim AigualB
   public static void Cpositivo(double ArranjoC[])
   {
      int n=0;
      for(int i=0;i<ArranjoC.length; i++)
      {
         if(ArranjoC[i]>=0)
         {
            n++;
         }   
      }
      if (n==ArranjoC.length)
      {
         System.out.println("O arranjo so tem numeros positivos");
      }
      else
      {
         System.out.println("O arranjo tem numeros negativos");
      }  
   }//fim Cpositivo
   public static void ordena(double ArranjoC[])
   {
      double ordena=0;
      for(int i=0;i<ArranjoC.length-1;i++)
      {
         for(int j=i+1;j<ArranjoC.length;j++)
         {
            if(ArranjoC[j]>ArranjoC[i])
            {
               ordena=ArranjoC[j];
               ArranjoC[j]=ArranjoC[i];
               ArranjoC[i]=ordena; 
            } 
         }
      }
      for(int g=0; g<ArranjoC.length;g++)
         {
         System.out.println(ArranjoC[g]);
         }
   }//fim ordena
   public static void printsoma(double ArranjoC[])
   {
      double soma=0;
      soma=somaC(ArranjoC,0);
      System.out.println(soma);
   }//fim printsoma
   public static double somaC(double ArranjoC[],int i)
   {
      double soma=0;
      if (ArranjoC[i]<ArranjoC.length)
      {
         soma = ArranjoC[i]+somaC(ArranjoC,i+1);
      }
      else
      {
         soma = ArranjoC[i];
      }
      return soma;  
   }//fim de somaC
   public static void AigualBrecursiva(double ArranjoA[], double ArranjoB[])
   {
      boolean g=AigualBrecursivaeq(ArranjoA,ArranjoB);
      if (g)
      {
         System.out.println("Iguais");
      }
      else   
      {
         System.out.println("Diferentes");
      }
   }//A=B recursiva
   public static boolean AigualBrecursivaeq (double ArranjoA[], double ArranjoB[])
   {
      for (int i=0; i<ArranjoA.length;i++)
      {
         if (ArranjoA[i]!=ArranjoB[i])
         {
            return false;
         }
      }
      return true;
   }//fim boolean A=B
   public static void ZerosArecursiva(double ArranjoA[],double n)
   {
      int soma=ZerosArecursivaeq(ArranjoA,0);
      System.out.println(soma);
   }
   public static int ZerosArecursivaeq(double ArranjoA[],double n)
   {
      int soma=0;
      for(int i=0;i<ArranjoA.length;i++)
      {
         if(ArranjoA[i]==0)
         {
         soma=soma+1;
         }
         else
         {
            soma=0;
         } 
      }
      return soma;
   }
}//fim classe