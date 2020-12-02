//Data:11/07/17
import java.util.Scanner;
import java.util.InputMismatchException;//implementação da excessaõ do tipo incompatível
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
public class TF_33
{
   public static void main(String[]args)
   {
      Scanner s=new Scanner(System.in);
      int sal=1200;
      boolean maior;
      boolean continualaco=true;
      int posicao;
      Funcionarios []F=new Funcionarios[1];
      int op=-1;
      do
      {
         try
         {
            do
            {
               op=menu();
               switch(op)
               {
                  case 0:break;
                  case 1:int i=Funcionarios.getQuant();
                  if(i<F.length)
                  {
                     Funcionarios.escrevefuncionarios(F);    
                  }
                  break;
                  case 2:maior=Funcionarios.descobreSal(sal);
                  if(maior)
                  {
                     System.out.println("O seu salario eh maior que o do sistema");
                  }else{
                     System.out.printf("O salario do sistema %d eh maio que o seu",sal);
                  }
                  break;
                  case 3:Funcionarios.chaveP(F);
                           break;
                  case 4:Funcionarios.ordena(F);
                           break;
                  case 5:posicao=Funcionarios.chavePes(F);
                  if(posicao>-1)
                  {
                     System.out.println(posicao);
                  }else{
                     System.out.println("Nao tem ningume com esse CPF");
                  }
                           break;
                  case 6:for(int j=0;j<F.length;j++)
                  {
                     Funcionarios.escreveF(F,j); 
                  }
                             break;
                  case 7:Funcionarios.criaArquivo(F);
                             break;
                  case 8:Funcionarios.escreveArquivo(F);
                              break;
                  case 9: Funcionarios.listaMaior(sal,F);
                              break;
                  case 10:Funcionarios.listaAdmissao(F);
                              break;     
                  case 11: System.out.println("Digite um mes");
                           int month=s.nextInt();
                           Funcionarios.aniversario(F,month);
                              break;                   
               }
         }while(op!=0);
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
   public static int menu()throws InputMismatchException
   {
      int op=0;
      Scanner s=new Scanner(System.in);
      System.out.println("Digite 0 para sair");
      System.out.println("Digite 1 para criar um funcionario");
      System.out.println("Digite 2 para descobrir se seu salario eh maior do que o do sistema");
      System.out.println("Digite 3 para pesquisar um funcionario");
      System.out.println("Digite 4 para ordenar os funcionarios de acordo com o CPF");
      System.out.println("Digite 5 para pesquisar um CPF");
      System.out.println("Digite 6 para escrever os funcionarios");
      System.out.println("Digite 7 para criar arquivo");
      System.out.println("Digite 8 para escrever arquivo");
      System.out.println("Digite 9 para listar todos os funcionarios que ganham mais que o valor no sistema");
      System.out.println("Digite 10 para pesquisar quem foi admitido a partir de uma data");
      System.out.println("Digite 11 para pesquisar quem faz aniversario em um determinado mes");
      op=s.nextInt();
      return op;
   }
}//fim da classe pública
class Funcionarios
{
   private static String nome;
   private static int CPF;
   private Data nascimento;
   private Data admissao;
   private static int salario;
   private static int quant=0;   public static void escrevefuncionarios(Funcionarios []F)throws InputMismatchException,ArrayIndexOutOfBoundsException,NullPointerException
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
   public static void listaMaior(int sal,Funcionarios []F) throws ArrayIndexOutOfBoundsException,NullPointerException
   {
      for(int i=0;i<F.length;i++)
      {
         if(F[i].getSalario()>sal)
         {
            System.out.printf("%s",F[i].getNome());
         }
      }
   }
   public static void criaArquivo(Funcionarios []F)
   {
      File arquivo = new File("Funcionarios.txt");
      String funcionario="";
      String f;
      int CPF=0;
      int c;
      int d=0;
      int nd;
      int ad;
      int nm;
      int am;
      int na;
      int aa;
      int salario=0;
      int sal;
      try(FileWriter fw = new FileWriter(arquivo))
      {
         for(int i=0;i<F.length;i++)
         {
            funcionario=F[i].getNome();
            CPF=F[i].getCPF();
            nd=F[i].getNascimento().getDia();
            ad=F[i].getAdmissao().getDia();
            nm=F[i].getNascimento().getMes();
            am=F[i].getAdmissao().getMes();
            na=F[i].getNascimento().getAno();
            aa=F[i].getAdmissao().getAno();
            f=funcionario;
            c=CPF;
            sal=salario;
            fw.write(f);
            fw.write(c);
            fw.write(ad);
            fw.write(nd);
            fw.write(am);
            fw.write(nm);
            fw.write(aa);
            fw.write(na);
            fw.write(sal);
            fw.flush();//limpa o buffer
         }
      }
       catch(IOException ioException)
            {
               System.out.print(ioException);
            }//fim de catch
   }
   public static void escreveArquivo(Funcionarios []F)
   {
      File arquivo = new File("funcionarios.txt");
      try( FileReader fr = new FileReader(arquivo) )//lê o arquivo
      {
         int  c = fr.read();
         while( c != -1)//enquanto o arquivo não acaba
         {
           System.out.print( (char) c );
           c = fr.read();
         } //fim de while
      } //fim de try
      catch(IOException ioException)
      { 
         System.out.print(ioException);
      }//fim de catch
   }
   public static void listaAdmissao(Funcionarios []F)throws InputMismatchException,ArrayIndexOutOfBoundsException,NullPointerException
   {
      int day, month,year;
      int aux=0;
      Scanner s=new Scanner(System.in);
      System.out.println("Digite a data de admissao desejada");
      day=s.nextInt();
      month=s.nextInt();
      year=s.nextInt();
      for(int i=0;i<F.length;i++)
      {
         if(year<F[i].getAdmissao().getAno())
         {
            if(month<F[i].getAdmissao().getMes())
            {
               if(day<F[i].getAdmissao().getDia())
               {
                  System.out.printf("%s\n",F[i].getNome());
                  aux++;
               }
            }
         }
      }
      if(aux==0)
      {
         System.out.println("Ninguem foi admitido a partir dessa data");
      }
   }
   public static void aniversario(Funcionarios []F,int month)throws ArrayIndexOutOfBoundsException,NullPointerException
   {
      int aux=0;
      for(int i=0;i<F.length;i++)
      {
         if(month==F[i].getNascimento().getMes())
         {
            System.out.printf("%s",F[i].getNome());
            aux++;
         }
      }
      if(aux==0)
      {
         System.out.println("Ninguem faz aniversario nesse mes");
      }   
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