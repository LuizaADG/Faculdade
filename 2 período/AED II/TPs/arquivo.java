import java.io.RandomAccessFile;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;

class arquivo//ler arquivo raf em java
{
		public static RandomAccessFile raf;//declaracao de raf 
		public static void main(String[]args)throws Exception
		{
			try
			{
				Locale.setDefault(Locale.ENGLISH);
				raf = new RandomAccessFile("pub2.out","rw");//cria arquivo
				int i = MyIO.readInt();
				 for(int n=0;n<i;n++)
                        	{
                                	raf.writeDouble(MyIO.readDouble());//escreve no arquivo
                        	}//fim de for
				raf.close();
				DecimalFormat df= new DecimalFormat("0.#####");//definicao do formato decimal
				raf = new RandomAccessFile("pub2.out","rw");//cria arquivo 
				double num=0;
				for(int posicao = 8*(i-1); posicao >= 0 ; posicao -= 8)//para escrever ao contrario por bits
				{
                        		raf.seek(posicao);//aponta para a posicao de bits
					num=raf.readDouble();//armazena o numero lido	
                        		MyIO.println(df.format(num));//escreve no formato decimal caso seja decimal
				}
			}catch(IOException ioException){
				MyIO.println("ERRO");
			}
		}//fim de main
}//fim de classe

