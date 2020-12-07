import java.io.*;
public class Teste5 {


	  public static void main (String [] args)
	  throws Exception
	  {

	   ProcessBuilder pb;
	   Process p;
	   int j, contador = 0;
	   String x;
	   //Long start_time;
	   //Long diff_time;

	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   String entrada;
	  while(true) {
		entrada = in.readLine();
      if(entrada.equals(""))
		   contador++;
		j = 1 + (contador % 4);
	  	pb = new ProcessBuilder("envia.exe","com9",Integer.toString(j));
	  	p = pb.start();
//	   start_time = System.nanoTime();
	   p.waitFor( );//espera o processo acabar
//	       diff_time = (System.nanoTime() - start_time)/1000000; ver demora do processo

/*	   		try { Thread.sleep(tempo); }
						catch(Exception e)
						{ 	System.out.println("Ups!"); }
*/
//	   		System.out.println("i= "+i+" j= "+j+" x= "+x+" "+diff_time);
	    		System.out.println("contador= "+contador+" j = "+j+"-- O que foi enviado: envia.exe com... "+j);
		}


	}
}
