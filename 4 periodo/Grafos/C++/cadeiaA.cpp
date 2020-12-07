#include <map>
#include <iterator>
#include <utility>
#include <iostream>
#include <list>
#include <algorithm>
#include<vector>

using namespace std;

//constantes
#define infinito 99999999
/*
    Classe grafos deve possuir um numero de vertices e dois ponteiros para array, um para a lista de adjacencias e o outro para a invertida
*/
class Grafos{
	int N; 
	public:
	map<pair<int,int>, int> adj;
	map<pair<int,int>, int> adjI;

/*
    Construtor receberá numero de vertices (qtd de especies)
*/
	Grafos(int N){
		this->N = N; 
	}// fim construtor
/*
    Metodo adicionar acrescentara nas listas de adjacencias vertices e pesos
*/
	void adicionar(int v1, int v2, int peso){
		adj.insert(make_pair(make_pair(v1, v2), peso));
		adjI.insert(make_pair(make_pair(v2, v1), peso));
	}// fim 
/*
    Metodo utiliza de iterator para comparar as listas adjacentes e suas posicoes. 
    A ideia é de comparar a ordenação dos vertices e se reparar que as duas apresentam valores iguais em seus y e x tem como "ir" e "voltar" 
*/
	void relacionamento(){
		int xa, ya, xb, yb;
		map<pair<int,int>, int> :: iterator iterator1;
		map<pair<int,int>, int> :: iterator iterator2;
		bool bolada = false;
		iterator2 = adjI.begin();
		for(iterator1 = adj.begin(); iterator1 != adj.end(); iterator1++, iterator2++){
			xb = (iterator2->first).first;
			yb = (iterator2->first).second;
			xa = (iterator1->first).first;
			ya = (iterator1->first).second;
			if(xa == xb && ya == yb){
				bolada = true;
			}//fim if
		}//fim for

		if(bolada){
			cout << "Bolada" << endl;
		} else{
			cout << "Nao Bolada" << endl;
		}//fim if/else 
	}//fim
};//fim 
/*
    Metodo main recebe quantidade de especies, relações e quantidade de vertices
*/
int main(){
		int qtdEspecies, numCasos;
		int esp1, esp2; 
		cin >> numCasos;
		cin >> qtdEspecies;
		Grafos G(qtdEspecies);
		for(int i = 0; i < numCasos; i++){
    	cin >> esp1;
    	cin >> esp2;
			G.adicionar(esp1, esp2, 0);
		}// end for
    G.relacionamento();
  return 0;
}
