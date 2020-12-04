class Algebra//classe de algebra booleana--- Retorna resolução da operação booleana
{
	public static void main(String[]args)
	{
	 String palavra []= new String[1000];//nova palavra
         int n=0;//contador
	 boolean pal=false;

		do
		{
			palavra[n]=MyIO.readLine();
			pal=equals(palavra[n],"FIM");
			if(pal==false)//so entra caso nao seja a palavra FIM
			{
				boolean output = false;
            			boolean[] inputs = new boolean[Character.getNumericValue(str.charAt(0))];
            			for (int i = 0, p = 2; i < inputs.length; i++, p+=2)
				{
                			inputs[i] = str.charAt(p) == '1';
                                }  
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
}
