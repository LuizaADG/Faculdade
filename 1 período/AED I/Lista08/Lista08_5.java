public class Lista08_5
{
   public static void main(String []args)
   {
      int x=1;
      sequencia(x);    
   }
   public static void sequencia(int x)
   //escrever até 10 em recursiva
   {    
     if (x>10)
     {
      return;
     }
     else
     {
      System.out.println(x);
      sequencia(x+1);
     }
   }
}      