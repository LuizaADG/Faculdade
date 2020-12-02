//Data:09/07/17
import java.util.Scanner;
import java.util.InputMismatchException;//implementação da excessaõ do tipo incompatível
public class TF_31
{
   public static void main(String[]args)
   {
      Scanner s=new Scanner(System.in);
      boolean continualaco=true;
      do
      {
         try
         {
            Data.entrarData();//colocar data no programa
            int dia=9;//valores para comparar com data emitida pelo usuario
            int mes=7;
            int ano=2017;
            boolean bissexto=Data.bissexto();//determinar se um ano é bissexto ou não
            if(bissexto)
            {
               System.out.println("O ano nao eh bissexto");
            }else{
               System.out.println("O ano eh bissexto");
            }
            String extenso=Data.mesExtenso();//escrever o mes por extenso
            System.out.println(extenso);
            boolean dataV=Data.dataValida();//verificar se a data é válida
            if(dataV)
            {
               System.out.println("Data valida");
            }else{
               System.out.println("Data invalida");
            }
            int aux=Data.recente(dia,mes,ano);
            if(aux==3)
            {
               System.out.printf("Data mais recente:%d/%d/%d\n",Data.getDia(),Data.getMes(),Data.getAno());
            }else{
               System.out.printf("Data mais recente :%d/%d/%d\n",dia,mes,ano);
            }
            boolean recenteb=Data.recenteb(dia,mes,ano);
            if(recenteb)
            {
               System.out.println("Data enviada mais recente");
            }else{
               System.out.println("Data enviada menos recente que a do programa");
            }
            continualaco=false;
         }
         catch(InputMismatchException inputMismatchException)//para valores inválidos
            {
               System.err.printf("\nException:%s\n",inputMismatchException);
               s.nextLine();
               System.out.println("Somente numeros inteiros");
            }//fim de catch
            catch(ArithmeticException arithmeticException)
            {
               System.err.printf("\nException: %s\n", arithmeticException);
               s.nextLine();
               System.out.println("Zero é um valor inválido. Tente novamente.\n");
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
            {
               System.err.printf("\nException: %s\n", arrayIndexOutOfBoundsException);
               s.nextLine();
               System.out.println("Acabou array.\n");
            }
            catch(NullPointerException nullPointerException)
            {
               System.err.printf("\nException: %s\n", nullPointerException);
               s.nextLine();
               System.out.println("Referencia ao objeto nao existe.\n");
            }
      }while(continualaco);                  
   }//fim de main
}
class Data
{
   private static int dia;
   private static int mes;
   private static int ano;
   public static void entrarData()throws InputMismatchException,ArithmeticException
   {
      Scanner s=new Scanner(System.in);
      int d,m,a;
      System.out.println("Digite o dia");
      d=s.nextInt();
      System.out.println("Digite o mes");
      m=s.nextInt();
      System.out.println("Digite o ano");
      a=s.nextInt();
      Data data=new Data(d,m,a);  
      escreveData(d,m,a);    
   }
   public static void escreveData(int d, int m, int a)
   {
      System.out.printf("%d/%d/%d\n",d,m,a);
   }
   Data(int dia, int mes, int ano)
   {
      setDia(dia);
      setMes(mes);
      setAno(ano);
   }
   Data()
   {
      setDia();
      setMes();
      setAno();
   }
   public void setDia(int dia)
   {
      this.dia=dia;
   }
   public void setDia()
   {
      this.dia=0;
   }
   public void setMes(int mes)
   {
      this.mes=mes;
   }
   public void setMes()
   {
      this.mes=0;
   }
   public void setAno(int ano)
   {
      this.ano=ano;
   }
   public void setAno()
   {
      this.ano=0;
   }
   public static int getDia()
   {
      return dia;
   }
   public static int getMes()
   {
      return mes;
   }
   public static int getAno()
   {
      return ano;
   }
   public static boolean bissexto()
   {
      boolean bissexto=true,
              porq,
              porc,
              porqc; 
      porq=getAno()%4==0;
      porc=getAno()%100==0;
      porqc=getAno()%400==0;
      if(porq)
      {
         if (porc)
         {
            if (porqc)
            {
               bissexto=false;
            }else
            {
               bissexto=true;
            }
         }else
         {
            bissexto=false;
         }
      }  
      return bissexto; 
   }
   public static String mesExtenso()throws ArithmeticException
   {
      if(getMes()==1)
      {  
         return "Janeiro";
      }
      if(getMes()==2)
      {  
         return "Fevereiro";
      }
      if(getMes()==3)
      {  
         return "Marco";
      }
      if(getMes()==4)
      {  
         return "Abril";
      }
      if(getMes()==5)
      { 
         return "Maio";
      }
      if(getMes()==6)
      {  
         return "Junho";
      }
      if(getMes()==7)
      {  
            return "Julho";
      }
      if(getMes()==8)
      {  
         return "Agosto";
      }
      if(getMes()==9)
      {  
         return "Setembro";
      }
      if(getMes()==10)
      {  
         return "Outubro";
      }
      if(getMes()==11)
      {  
         return "Novembro";
      }
      if(getMes()==12)
      {  
         return "Dezembro";
      }
   return "Mes invalido";   
   } 
   public static boolean dataValida()
   {
      if(getDia()<=0||getDia()>30)
      {
         if(getMes()>12)
         {
            return false;
         }   
      }else{
         return true;
      }
      return true;
   } 
   public static int recente(int d, int m, int a)
   {
      int aux=0;
      if(getDia()>d)
      {
         aux++;
      }
      if(getMes()>m)
      {
         aux++;
      }
      if(getAno()>a)
      {
         aux++;
      }
      return aux;
   }
   public static boolean recenteb(int d, int m, int a)
   {
      int aux=0;
      if(getDia()>d)
      {
         aux++;
      }
      if(getMes()>m)
      {
         aux++;
      }
      if(getAno()>a)
      {
         aux++;
      }
      if(aux==3)
      {
         return true;
      }else{
         return false;
      }
   }                          
}