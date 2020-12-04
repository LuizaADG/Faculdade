class Is
{
	public static void main(String[]args)
	{
	 String palavra []= new String[1000];//nova palavra
     int n=0;//contador
	 boolean pal=false;
	 boolean x1=false;
	 boolean x2=false;
	 boolean x3=false; 
	 boolean x4=false;//valor boolean para cada um		
		do
		{
			palavra[n]=MyIO.readLine();
			pal=equals(palavra[n],"FIM");
			if(pal==false)//so entra caso nao seja a palavra FIM
			{
				x1=determinaV(palavra[n]);				
				x2=determinaC(palavra[n]);
				x3=determinaI(palavra[n]);
				x4=determinaR(palavra[n]);
				if(x1)
				{
					MyIO.print("SIM ");
				}else{
					MyIO.print("NAO ");
				}
				if(x2)
				{
					MyIO.print("NAO ");
				}else{
					MyIO.print("SIM ");
				}
				if(x3)
				{
					MyIO.print("SIM ");
				}else{
					MyIO.print("NAO ");
				}
				if(x4)
				{
					MyIO.print("SIM");
				}else{
					MyIO.print("NAO");
				}
			MyIO.println("");
			n++;//mudar de linha
			}//fim de if
			
		}while(pal==false);//so serah realizado se nao igualar a FIM
	}
	public static boolean equals(String p1, String p2)   //metodo booleano para comparar strings
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
		}//fim de else
		return pal;
	}//fim de metodo
	public static boolean determinaV(String s)//metodo booleano para vogais
	{
		int count=0;		
		boolean soV=false;	
		count=determinaV(s,s.length(),0,count);//descobrir contagem com metodo recursivo		
		if(count==s.length())//caso seja igual
		{
			soV=true;
		}
		return soV;//retorno de valor booleano
	}//fim de metodo
	public static int determinaV(String s,int n, int i,int count)//metodo para caso so tenha vogais em recursao
	{		
		if(i<n)//caso ainda seja menor que a string
		{				
			if( (int)s.charAt(i)==65 || (int)s.charAt(i)==97 || (int)s.charAt(i)==69 || (int)s.charAt(i)==101 || (int)s.charAt(i)==73 || (int)s.charAt(i)==105 || (int)s.charAt(i)==79 || (int)s.charAt(i)==111 || (int)s.charAt(i)==85 ||(int)s.charAt(i)==117)//caso so tenha vogal pela tabela ASCII
			{						
					count++;
			}//fim de if
		return determinaV(s,n,++i,count);//chama novamente o metodo		
		}
	return count;
	}//fim de metodo
	public static boolean determinaC(String s)//metodo para caso so tenha consoantes
	{
		int count=0;
		boolean soC=true;
		count=determinaC(s,s.length(),0,count);//descobrir contagem com metodo recursivo
		if(count==s.length())
		{
			soC=false;
		}
		return soC;//retorno de valor booleano
	}	
	public static int determinaC(String s, int n, int i, int count)//metodo para caso so tenha consoantes em recursao
	{		
		char c[]={'a','e','i','o','u','A','E','I','O','U',',','.'};//char de vogais e pontos
		if(i<n)//caso ainda seja menor que a string
		{			
			for(int j=0;j<c.length;j++)
				{
					if(s.charAt(i)==c[j])
					{
						count++;		
					}
				}
			return determinaC(s,n,++i,count);//chama novamente o metodo
		}
		return count;
	}//fim de metodo
	public static boolean determinaI(String s)//metodo para caso so tenha inteiros
	{		
		int count =0;//contador
		boolean soI=false;	
		count=determinaI(s,s.length(),0,count);	//descobrir contagem com metodo recursivo
		if(count==s.length()) 
		{
			soI=true;
		}//fim de if
		return soI;//retorno de valor booleano
	}
	public static int determinaI(String s, int n, int i, int count)//metodo para caso so tenha inteiros em recursao
	{	
		if(i<n)//caso ainda seja menor que a string
		{		
			if((int)s.charAt(i)>47 && (int)s.charAt(i)<57)//transforma os caracteres de acordo com ASCII
			{
				count++;
			}//fim de if
			return determinaI(s,n,++i,count);//chama novamente o metodo
		}//fim de if
		return count;
	}//fim de metodo
	public static boolean determinaR(String s)//metodo para caso so tenha reais
	{	
		int count =0;//contador
		boolean soR=false;	
		count=determinaR(s,s.length(),0,count);//descobrir contagem com metodo recursivo
		if(count==s.length()) 
		{					
			soR=true;
		}//fim de if
		return soR;//retorno de valor booleano		
	}	
	public static int determinaR(String s,int n, int i, int count)//metodo para caso so tenha reais em recursao
	{		
		if(i<n)//caso ainda seja menor que a string
		{				
			if((int)s.charAt(i)>47 && (int)s.charAt(i)<57) 	
			{
				count++;
			}//fim de if
			else if(i==0||i==s.length()-1)
			{
				if((int)s.charAt(i)==44 || (int)s.charAt(i)==46)
				{
					count++;
				}
			}
			return determinaR(s,n,++i,count);//chama novamente o metodo
		}//fim de if
		return count;
	}//fim do metodo
}//fim de classe
