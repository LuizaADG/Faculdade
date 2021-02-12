public class Tenis extends Thread {
   private String palavra;
   private int time;
   private static int lastTeamPlay = 0;
   public Tenis(String palavra,int time) {
      this.palavra= palavra;
	  this.time = time;
   }
   public static synchronized void play(String palavra,int time){
		if (lastTeamPlay != time)
		System.out.print("\n" + palavra + " Time: " +time+ " REBATEU");
		lastTeamPlay = time;
	}
   public void run() {
      
         try {
            for(int i= 0; i < 30; i++) {
                play(palavra,time);  
				Thread.sleep(100);
            }
         }
         catch (InterruptedException e) {
            return;
         }
      
   }
   public static void main(String [] args) {
      Thread t1= new Tenis("Luiza",0);
      Thread t3= new Tenis("Stefany",0);
      Thread t2= new Tenis("Ana",1);
      Thread t4= new Tenis("Carol",1);
      t1.start();
      t2.start(); 
      t3.start();
      t4.start();      
   }
}