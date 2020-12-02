public class Lista08_6
{
   public static void main(String[]args)
   {
      int n=1;
      sequenciaEinverso(n);
   }
   public static void sequenciaEinverso(int n)
   //escrever até 5 e voltar em recursiva
   {
      if(n<=5)
      {
          System.out.println(n);
          sequenciaEinverso(n+1); 
          System.out.println(n);
  
      }   
   }
}