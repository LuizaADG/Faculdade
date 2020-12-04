class aquecimento
{
   public static void main (String[] args)
   {
      String[] palavra = new String[1000];
      int n= 0; //contador
      boolean pal=false;
      int quant=0;
      do 
      {
         palavra[n] = MyIO.readLine();
	 pal=equals(palavra[n],"FIM");
	if(pal==false)//se nao for igual a FIM
	{
	   quant=conta(palavra[n]);
	   MyIO.println(quant);
	n++;//mudar de linha
	}//fim de if
      } while (pal== false);//realizado enquanto nao se igualar a FIM        
   }//fim de main
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
	}//fim de equals
	 public static int conta(String s)//metodo que recebe a string e envia a string e posicao
        {
  		 return conta(s, 0);
	}//fim de metodo
	public static int conta(String s, int i)//metodo recursivo contagem de maiusculas	
	{
		int  resp=0;
	         do
                 {
                 	if(i== s.length())//quando igualar o comprimento
                 	{	
				return resp;//retornara 0
			}
                        if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') == true)
                 	{	
					return conta(s,i+1)+resp+1;//acrescenta um numero
                   	}else
			{
                          return resp = conta(s,i+1); //uso do metodo recursivo.Mesma string, posicao diferente
			}	
                }while (i < s.length());//so sera feito, caso a posicao exista na string
	}//fim de metodo
}//fim da classe
