import java.util.Random;
class AlterarR//alteracao aleatoria
{
	public static void main(String[]args)
	{
	 String palavra []= new String[1000];//nova palavra
     int n=0;//contador
	 boolean pal=false;
	 Random gerador=new Random();//gerar random
	 gerador.setSeed(4);
					
		do
		{
			char v=(char)('a'+(Math.abs(gerador.nextInt()%26)));//geraçao aleatoria
	 		char k=(char)('a'+(Math.abs(gerador.nextInt()%26)));			
			palavra[n]=MyIO.readLine();
			pal=equals(palavra[n],"FIM");
			if(pal==false)//so entra caso nao seja a palavra FIM
			{
				MyIO.println(alteracao(palavra[n],gerador, 0, "",v,k));
			}//fim de if
			n++;//mudar de linha


		}while(pal==false);//so serah realizado se nao igualar a FIM
	}
	public static boolean equals(String p1, String p2)//metodo booleano para comparar strings
	{
		int tam1=p1.length();//tamanho 1 palavra
		int tam2=p2.length();//tamanho 2 palavra
		boolean pal=true;
		if(tam1==tam2)//Primeiro passo: verificar se o tamanho eh igual
		{
			for(int i=0;i<tam1;i++)
			{
				if(p1.charAt(i)!=p2.charAt(i))
				{
					pal= false;
				}//fim de if
			}//fim for
		}else{
			pal=false;
		}
		return pal;
	}
	public static String alteracao(String s, Random gerador, int i, String alterada,char v, char k)
	{		
			 		
		if(i<s.length()){		//caso seja de tamanho menor
		
			char n= s.charAt(i);//armazena char da string

			if(n==v)//caso sejam iguais
			{
				n=k;//troca a letra
			} 
		alterada=alterada+n;//string vazia vai enchendo
		return alteracao(s, gerador, i+1, alterada,v,k);	//recursiva	
		}
	return alterada;
	}
	
}
