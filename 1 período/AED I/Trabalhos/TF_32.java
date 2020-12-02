//Data:10/07/17
import java.util.Scanner;
import java.util.InputMismatchException;//implementação da excessaõ do tipo incompatível
public class TF_32
{
   public static void main(String[]args)
   {
      Scanner s=new Scanner(System.in);
      int sal=1200;
      boolean maior;
      boolean continualaco=true;
      int posicao;
      Funcionarios []F=new Funcionarios[1];
      do
      {
         try
         {
            for(int i=0; i<F.length;i++)
            {
               Funcionarios.escrevefuncionarios(F);    
            }
            maior=Funcionarios.descobreSal(sal);
            if(maior)
            {
               System.out.println("O seu salario eh maior que o do sistema");
            }else{
               System.out.printf("O salario do sistema %d eh maio que o seu",sal);
            }
            Funcionarios.chaveP(F);
            Funcionarios.ordena(F);
            posicao=Funcionarios.chavePes(F);
            if(posicao>-1)
            {
               System.out.println(posicao);
            }else{
               System.out.println("Nao tem ningume com esse CPF");
            }
            for(int j=0;j<F.length;j++)
            {
               Funcionarios.escreveF(F,j); 
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
   }
}//fim da classe pública
class Funcionarios
{
   private static String nome;
   private static int CPF;
   private Data nascimento;
   private Data admissao;
   private static int salario;
   private static int quant=0;
   public static void escrevefuncionarios(Funcionarios []F)throws InputMismatchException,ArrayIndexOutOfBoundsException,NullPointerException
   {
      int d,m,a,dia,mes,ano;
      String nome;
      int CPF,salario;
         System.out.println("Digite nome,CPF e salario do funcionario");
         Scanner s=new Scanner(System.in);
         nome=s.next();
         CPF=s.nextInt();
         salario=s.nextInt();
         System.out.println("Digite o dia de admissao");
         d=s.nextInt();
         System.out.println("Digite o mes de admissao");
         m=s.nextInt();
         System.out.println("Digite o ano de admissao");
         a=s.nextInt();
         System.out.println("Digite o dia de nascimeto");
         dia=s.nextInt();
         System.out.println("Digite o mes de nascimeto");
         mes=s.nextInt();
         System.out.println("Digite o ano de nascimento");
         ano=s.nextInt();  
         Funcionarios Funcionarios = new Funcionarios(nome,CPF,salario,d,m,a,dia,mes,ano); 
   }
   public static void escreveF(Funcionarios []F, int i)throws InputMismatchException,ArrayIndexOutOfBoundsException,NullPointerException
   {
         System.out.printf(" O funcionario %s",F[i].getNome());
         System.out.printf(" Foi admitido em %d/%d/%d\n",F[i].getAdmissao().getDia(),F[i].getAdmissao().getMes(),F[i].getAdmissao().getAno());
         System.out.printf("Tem o CPF %d", F[i].getCPF());
         System.out.printf("Nasceu em %d/%d/%d", F[i].getNascimento().getDia(), F[i].getNascimento().getMes(), F[i].getNascimento().getAno());
         System.out.printf("Seu salario= %d",F[i].getSalario());   
   }
   public static boolean descobreSal(int sal)throws InputMismatchException
   {
      boolean maior=true;
      Scanner s=new Scanner(System.in);
      System.out.println("Digite seu salario");
      int sala=s.nextInt();
      if(sala<sal)
      {
         maior=false;
      }else{
         maior=true;
      } 
   return maior;   
   }
   public static void chaveP(Funcionarios []F)throws InputMismatchException,ArrayIndexOutOfBoundsException,NullPointerException
   {
      String n;
      Scanner s=new Scanner(System.in);
      System.out.println("Digite o nome que deseja procurar");
      n=s.next();
      for(int i=0;i<F.length;i++)
      {
         if(n==F[i].getNome())
         {
            System.out.printf(" O funcionario %s",F[i].getNome());
            System.out.printf(" Foi admitido em %d/%d/%d\n",F[i].getAdmissao().getDia(),F[i].getAdmissao().getMes(),F[i].getAdmissao().getAno());
            System.out.printf("Tem o CPF %d", F[i].getCPF());
            System.out.printf("Nasceu em %d/%d/%d\n",F[i].getNascimento().getDia(), F[i].getNascimento().getMes(), F[i].getNascimento().getAno());
            System.out.printf("Seu salario= %d",F[i].getSalario());
         }   
      }
   }
   public static void ordena(Funcionarios X[])throws ArrayIndexOutOfBoundsException,NullPointerException
   {
      Funcionarios n=new Funcionarios();
      for (int i=0;i<X.length;i++)
      {
         for (int l=0;l<X.length-1;l++)
         {
            if (X[l].getCPF()>X[l+1].getCPF())
            {
               n=X[l];
               X[l]=X[l+1];
               X[l+1]=n;
            }   
         }   
      }
   }
   public static int chavePes(Funcionarios []F)throws InputMismatchException, ArrayIndexOutOfBoundsException
   {
      int c;
      int pos=0;
      int posicao=0;
      int aux=0;
      Scanner s=new Scanner(System.in);
      System.out.println("Digite o CPF que deseja procurar");
      c=s.nextInt();
      for(int i=0;i<F.length;i++)
      {
         if(c==F[i].getCPF())
         {
            pos=i;
            aux++;
         }   
      }
      if(aux==1)
      {
         posicao=pos;
      }else{
         posicao=-1;
      }
    return posicao;  
   }
   Funcionarios(String nome,int CPF,int salario,int d, int m, int a, int dia, int mes, int ano)throws ArrayIndexOutOfBoundsException,NullPointerException
   {
      this.quant++;
      setNome(nome);
      setCPF(CPF);
      setAdmissao(d,m,a);
      setNascimento(dia,mes,ano);
      setSalario(salario);
   }//construtor
   Funcionarios()
   {
      this.quant++;
      setNome();
      setCPF();
      setAdmissao();
      setNascimento();
      setSalario();
   }//construtor
   public void setNome(String nome)
   {
      this.nome=nome;
   }
   public void setNome()
   {
      this.nome="sem";
   }
   public void setCPF(int CPF)
   {
      this.CPF=CPF;
   }
   public void setCPF()
   {
      this.CPF=0;
   }
   public void setAdmissao(int d, int m, int a )
   {
      this.admissao.setDia(d);
      this.admissao.setMes(m);
      this.admissao.setAno(a);
   }
   public void setAdmissao()
   {
      this.admissao.setDia();
      this.admissao.setMes();
      this.admissao.setAno();
   }
   public void setNascimento(int dia, int mes, int ano)
   {
      this.nascimento.setDia(dia);
      this.nascimento.setMes(mes);
      this.nascimento.setAno(ano);
   }
   public void setNascimento()
   {
      this.nascimento.setDia();
      this.nascimento.setMes();
      this.nascimento.setAno();
   }
    public void setSalario(int salario)
   {
      this.salario=salario;
   }
   public void setSalario()
   {
      this.salario=0;
   }
   public static String getNome()
   {
      return nome;
   }
   public static int getCPF()
   {
      return CPF;
   }
   public Data getNascimento()
   {
      return nascimento;
   }
   public Data getAdmissao()
   {
      return admissao;
   }
   public static int getSalario()
   {
      return salario;
   }
   public static int getQuant()
   {
      return quant;
   }
}//fim de funcionarios
class Data
{
   private static int dia;
   private static int mes;
   private static int ano;
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
}//fim de data   