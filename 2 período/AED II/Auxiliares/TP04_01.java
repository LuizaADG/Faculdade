import java.util.*;
import java.io.*;
class Series
{
	/*
	Construcao de objetos da classe serie referente a cada serie
	*/
	private String Nome;
	private String Formato;
	private String Duracao;
	private String PaisDeOrigem;
	private String IdiomaOriginal;
	private String EmissoraDeTelevisao;
	private String TransmissaoOriginal;
	private int NDeTemporadas;
	private int NDeEpisodios;
	public void lerArq(String serie) 
	{
		  	Arq.openRead("/tmp/"+serie);//ler o arquivo da serie na pasta tmp
			/*Declaração de strings que serao lidas*/			
			String titulo="";	
			String formato="";	 
			String duracao="";
			String pO="";
			String Io="";
			String ETO="";
			String TO="";
			String ler="";
			String lerE="";
			try{
			while(Arq.hasNext()==true)//enquanto ainda estiver string no arquivo
		  	{
				serie = Arq.readLine();//ler a string
			if(serie.contains("<h1 id"))//se tiver <h1 id 
			{													
						titulo=serie;//a string iguala a linha
						titulo = titulo.split("<[^>]*>")[2]; /*ignora tudo que esta entre < e > terminando em > e vai para a posicao 2 depois
															vai para a posicao 2 dos intervalos*/
						titulo = titulo.trim();//retira espaços vazios
						setNome(titulo);//manda para set
			}
			if(serie.contains("<td scope"))//se tiver isso na string
			{
				if(serie.contains("Formato</td>"))//se tiver isso na string
				{

					formato=Arq.readLine();//ler linha
					formato = formato.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					formato = formato.trim();//retira espaços vazios
					setFormato(formato);//manda para set
				}
				if(serie.contains("Duração</td>"))//se tiver isso na string
				{
					duracao=Arq.readLine();//ler linha
					duracao = duracao.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					duracao = duracao.trim();//retira espaços vazios
					setDuracao(duracao);//manda para set
				}
				if(serie.contains("País de origem</td>"))//se tiver isso na string
				{
					pO=Arq.readLine();//ler linha
					pO = pO.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					pO= pO.replaceAll("&#160;","");//repoe isso com espaço vazio
    				pO= pO.replaceAll("&nbsp;","");//repoe isso com espaço vazio
					pO= pO.trim();//retira espaços vazios
					setPaisDeOrigem(pO);//manda para set
				}
				if(serie.contains("Idioma original</td>"))//se tiver isso na string
				{
					Io=Arq.readLine();//ler linha
					Io= Io.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					Io= Io.trim();//retira espaços vazios
					setIdiomaOriginal(Io);//manda para set
				}
				if(serie.contains("Emissora de televisão original</td>"))//se tiver isso na string
				{
					ETO=Arq.readLine();//ler linha
					ETO= ETO.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					ETO= ETO.trim();//retira espaços vazios
					setEmissoraDeTelevisao(ETO);//manda para set
				}
				if(serie.contains("Transmissão original</td>"))//se tiver isso na string
				{
					TO=Arq.readLine();//ler linha
					TO= TO.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					TO= TO.replaceAll("&#160;", "");//repoe isso com espaço vazio
					TO= TO.replaceAll("&nbsp;", "");//repoe isso com espaço vazio					
					TO= TO.trim();//retira espaços vazios
					setTransmissaoOriginal(TO);//manda para set
				}
				if(serie.contains("N.º de temporadas</td>"))//se tiver isso na string
				{
					ler=Arq.readLine();//ler linha
					ler= ler.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					ler=ler.trim();//retira espaços vazios
					String []leia=ler.split("");//ignora os espaços vazios					
					setNDeTemporadas(Integer.parseInt(leia[0]));//transforma string em inteiro e manda para set
				}
				if(serie.contains("N.º de episódios</td>"))//se tiver isso na string
				{
					lerE=Arq.readLine();//ler linha
					lerE= lerE.replaceAll("<[^>]*>", "");//coloca vazio em tudo que esta entre < e >(o que esta fora eh o que vc quer)
					lerE=lerE.trim();//retira espaços vazios
					String []leia=lerE.split(" ");//ignora os espaços vazios
					setNDeEpisodios(Integer.parseInt(leia[0]));//transforma string em inteiro e manda para set
				}
			}//fim de if
		  }//fim de while	
		}catch(IllegalStateException ex){
			System.err.println("Fim do arquivo");
		}
	}//fim de ler	
	/*
	Construtor vazio
	*/
	public Series()
	{
		setNome();
		setFormato();
		setDuracao();
		setPaisDeOrigem();
		setIdiomaOriginal();
		setEmissoraDeTelevisao();
		setTransmissaoOriginal();
		setNDeEpisodios();
		setNDeTemporadas();
	}
	/*Construtor*/
	public Series(String N, String F, String D, String P, String ET,String IO,String TO,int NE, int NT)
	{
		setNome(N);
                setFormato(F);
                setDuracao(D);
                setPaisDeOrigem(P);
                setIdiomaOriginal(IO);
               	setEmissoraDeTelevisao(ET);
                setTransmissaoOriginal(TO);
                setNDeEpisodios(NE);
                setNDeTemporadas(NT);
	}
	/*Metodos set Construtor vazio*/
		public void setNome()
		{
	 	this.Nome="";
		}
		public void setFormato()
		{
         	this.Formato="";
		}
		public void setDuracao()
		{
         	this.Duracao="";
        }
		public void setPaisDeOrigem()
		{ 
			this.PaisDeOrigem="";
		}
		public void setIdiomaOriginal()
        { 
			this.IdiomaOriginal="";
		}
		public void setEmissoraDeTelevisao()
		{
         	this.EmissoraDeTelevisao="";
        }
		public void setTransmissaoOriginal()
		{ 
			this.TransmissaoOriginal="";
    	}
		public void setNDeEpisodios()
		{ 
			this.NDeEpisodios=0;
    	    }
		public void setNDeTemporadas()
		{ 
			this.NDeTemporadas=0;
		}
		/*Metodos set do Construtor normal*/
	public void setNome(String N)
        {
                this.Nome=N;
        }
        public void setFormato(String F)
        {
                this.Formato=F;
        }
        public void setDuracao(String D)
        {
                this.Duracao=D;
        }
        public void setPaisDeOrigem(String PO)
        {
                this.PaisDeOrigem=PO;
        }
        public void setIdiomaOriginal(String IO)
        {
                this.IdiomaOriginal=IO;
        }
        public void setEmissoraDeTelevisao(String ET)
        {
                this.EmissoraDeTelevisao=ET;
        }
        public void setTransmissaoOriginal(String TO)
        {
                this.TransmissaoOriginal=TO;
        }
        public void setNDeEpisodios(int NE)
        {       
                this.NDeEpisodios=NE;
        }
        public void setNDeTemporadas(int NT)
        {
                this.NDeTemporadas=NT;
        }
	/*Metodos get*/
		public String getNome()
		{
			return this.Nome;
		}
        public String  getFormato()
        {
        	return this.Formato;        
        }
        public String getDuracao()
        {
                return this.Duracao;
        }
        public String getPaisDeOrigem()
        {
                return this.PaisDeOrigem;
        }
        public String getIdiomaOriginal()
        {
                return this.IdiomaOriginal;
        }
        public String getEmissoraDeTelevisao()
        {
                return this.EmissoraDeTelevisao;
        }
        public String  getTransmissaoOriginal()
        {
                return this.TransmissaoOriginal;
        }
        public int getNDeEpisodios()
        {       
                return this.NDeEpisodios;
        }
        public int getNDeTemporadas()
        {
                return this.NDeTemporadas;
        }
	public void clone()//metodo clone
   {
      return new Series(this.Nome, this.Formato,this.Duracao, this.PaisDeOrigem, this.IdiomaOriginal, this.EmissoraDeTelevisao, this.TransmissaoOriginal, this.NDeEpisodios,  this.NDeTemporadas);  
   }
   public static void imprimirArq(Series serie)//imprimir dados do arquivo + espaço vazio
	{
		MyIO.print(serie.getNome() + " ");
		MyIO.print(serie.getFormato() + " ");
		MyIO.print(serie.getDuracao() + " ");
		MyIO.print(serie.getPaisDeOrigem() + " ");
		MyIO.print(serie.getIdiomaOriginal() + " ");
		MyIO.print(serie.getEmissoraDeTelevisao() + " ");
		MyIO.print(serie.getTransmissaoOriginal() + " ");
		MyIO.print(serie.getNDeTemporadas()+ " ");
		MyIO.println(serie.getNDeEpisodios());
	}//fim de imprimir
}//fim da classe Series
public class TP04_01
{
	public static void main(String[]args)
	{
		String serie="";//inicializa a string	
		Series series=new Series();//inicio do objeto Series
		serie=MyIO.readLine();			
		do
		{				
				series.lerArq(serie);//metodo para ler o arquivo a partir da string
				Series.imprimirArq(series);//metodo para imprimir o arquivo
				serie=MyIO.readLine();//ler a proxima linha		
		}while(!serie.equals("FIM"));//ocorre enquanto nao igualar a fim
	}//fim de main
}//fim de classe
