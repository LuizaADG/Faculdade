class CiframentoR
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
				
				MyIO.println(criptografa(palavra[n]));//imprime palavra	
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
	public static String criptografa(String s)
	{	
		return criptografa(s,0);
	}
	public static String criptografa(String s,int o)
	{ 
		int tam = s.length();//tamanho da string 
		int val;
		String palCrip=""; 
        
		if(o<tam)//soh serah executado nesse limite
        {
			val=(int)s.charAt(o)+3;//armazena o valor novo da letra de acordo com ASCII
			palCrip+=(char)val+criptografa(s,++o);//acrescenta a char a string e retorna para o metodo
		}
		return palCrip;
	}//fim de metodo
}//fim de classe
