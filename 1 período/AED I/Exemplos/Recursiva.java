public class Recursiva
 {
  static void contagemRegressiva (int n )
  {
    if ( n == 0 )
    {
      System.out.println("Explosão!!!");
    }
    else
    {
      System.out.println(n);
      contagemRegressiva (n-1);
    }
  }
  public static void main(String[] args)
  {
   int contagem = 10;
   System.out.println("Iniciando contagem regressiva");
   contagemRegressiva(contagem);
  }
}