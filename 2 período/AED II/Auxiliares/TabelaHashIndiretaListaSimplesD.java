class TabelaHashLista{	
	public ListaDinamicaSimples[]tabela; 
	public void TabelaHashLista(int tam){
			tabela = new ListaDinamicaSimples[tam];
			for(int i=0;i<tam;i++){
				tabela[i]=new Lista();				
			}
	}	
}
public void inserir(int x){
	if(pesquisar(x)==true){
		System.out.println("Não pode inserir");	
	}else(x%tam==0){
		tabela[hash(x)].inserir(x);
	}	
}
public boolean pesquisar(int x){
	return tabela[hash(x)].pesquisar(x);
}
