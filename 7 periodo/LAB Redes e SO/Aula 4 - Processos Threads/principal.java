public class principal {
   public static void main(String[] args) {
      //Cria o contexto de execução
      escrita eThread = new escrita();
      //Ativa a thread
      eThread.start();
   }
}