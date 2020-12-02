//Data:06/06/17
public class TF_2
{
   public static void main(String[]args)
   {
      int fib=fibonacci(10);
      double[] array = new double[]{0,1,2,3};
      String palavra="asdfgfdsa";
      System.out.println(fib);
      inverterArray(array);
      for(int i=0; i<array.length;i++)
      {
         System.out.println(array[i]);//imprimir array
      }//fim de for
      boolean ehPalindromo=ehPalindromo(palavra);
      if(ehPalindromo)
      {
         System.out.println("Eh palindromo");
      }else{
         System.out.println("Nao eh palindromo");
      }   
   }//fim de main
   public static int fibonacci(int n)//método recursivo calcular fibonacci
   {
      if(n==0)return 0;
      else if(n==1) return 1;
      else
      {
         return fibonacci(n-1)+ fibonacci(n-2); 
      }
   }//fim de fibonacci
   public static void inverterArray(double []array)//método que manda parametros para inverter o array
   {
      inverte(array,0,array.length-1);
   }//fim de inverterArray
   public static void inverte( double array[], int n, int j)//método recursivo inversão de array
   {
      if(n<j)//troca
      {
         double x = array[n];
         array[n] = array[j];
         array[j] = x;
         inverte(array, ++n, --j);//Recursiva
      }   
   }//fim de inverte
   public static boolean ehPalindromo(String palavra)
   {
      return ehPalindromo(palavra, 0, palavra.length()-1);
   }//fim de ehPalindromo
   public static boolean ehPalindromo(String s, int i, int f)
   {
      boolean resp;
      if(i < (f/2))
      {
         resp = true;
      }//fim de if
      if(s.charAt(i) != s.charAt(f))
      {
         return resp = false;
      }else{
    	  if(i>=(s.length()-1)) return true;
    	  resp = ehPalindromo(s,i+1,f-1);
      }
      return resp;
   }//fim de ehPalindromo
}//fim da classe