class Ciframento
{
	public static void main(String args[])
	{
		String palavra[]=new String[1000];//declara a String
		int n=0;//contador
		boolean pal=false;
		do
		{
			palavra[n]=MyIO.readLine();
			pal=equals(palavra[n],"FIM");
			if(pal==false)//so entra caso nao seja a palavra FIM
			{
				criptografa(palavra[n]);
				n++;//mudar de linha
			}
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
	public static void criptografa(String s)
	{
		String textoCifrado="";//criar nova string 
		int i;//contador
                int tam = s.length();//tamanho da string  
                for(i=0; i < tam; i++)//soh serah executado nesse limite
                {
			int next=(int)s.charAt(i)+3;//acrescimo de 3 em cada letra
			char ela=(char)next;//transforma o numero em letra de acordo com ASCII
			textoCifrado=textoCifrado+ela;//acrescimo de chars na string vazia
	        }//fim de for  
		MyIO.println(textoCifrado);//printar strings
	}
}//fim de classe
