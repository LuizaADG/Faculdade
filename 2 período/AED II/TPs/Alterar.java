import java.util.Random;
class Alterar//alteracao aleatoria
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
			palavra[n]=MyIO.readLine();
			pal=equals(palavra[n],"FIM");
			if(pal==false)//so entra caso nao seja a palavra FIM
			{
				MyIO.println(alteracao(palavra[n],gerador));
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
	public static String alteracao(String s, Random gerador)
	{
		 
		int v=((int)'a'+(Math.abs(gerador.nextInt()%26)));//geracao aleatoria
		int k=((int)'a'+(Math.abs(gerador.nextInt()%26)));		
		String alterada="";//string vazia
		for(int i=0;i<s.length();i++)//para cada valor menor que o tamanho da string
		{
			int n=(int)s.charAt(i);
			if(n==v)//caso sejam iguais
			{
				n=k;//troca
			} 
		alterada=alterada+(char)n;//enche string vazia
		}
	return alterada;//retorna string
	}
	
}
