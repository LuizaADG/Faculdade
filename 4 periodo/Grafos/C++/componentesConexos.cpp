#include <iostream>
#include <algorithm> // funcao find
#include<vector>
#include <map>
#include <iterator>
#include <list>
#include <utility>

using namespace std;

//constantes
#define corB 2
#define corC 1
#define corP 0
/*
    Classe Grafos contém os numeros de vertices do Grafo; e um ponteiro cor publico e um para um array que tem listas de adjacencias  
*/
class Grafos{
	int N; 
	public:
	    int *cor ;
	    map<pair<char,char>, int> adj;
/*
    Metodo construtor dos grafos que atribui o numero de vertices ao grafo, cria um novo ponteiro cor com o numero de vertices e coloca todas como corB
*/
	Grafos(int N){
		this->N = N; 
		cor = new int[N];
		for(int i = 0; i < N; i++){
			cor[i] = corB;
		}//fim for
	}// fim 
    /*
        Metodo adicionar acrescenta os vertices na lista de adjacencias com pesos para cada aresta criada 
    */
	void adicionar(char v1, char v2, int peso){
		adj.insert(make_pair(make_pair(v1, v2), peso));
	}// fim
    /*
        Metodo dfs chama o metodo de visita
    */
	void dfs(){
		int comp = 0;
		for(int i = 0; i < N; i++){
			if(cor[i] == corB){
				comp++;
				visita(i);
				cout << endl;
			}//fim if
		}// fim for
		cout << comp <<" connected components"<< endl;
	}// fim dfs
/*
    Metodo visita marca o vertice que foi visitado como corC, cria um iterator para andar pelo array
*/
	void visita(int i){
		cor[i] = corC;
		map<pair<char,char>, int> :: iterator iterator;
		int j = 0;
		int aux=0;
		char letra = (char)('a' + i);//cria um vertice a medida que o 'i' varia, acrescentando letras  
		cout << letra <<",";
		for(iterator = adj.begin(); iterator != adj.end(); iterator++){
			if((iterator->first).first == letra){
				aux = (iterator->first).second - 'a';
				if(aux >= 0){
					j = aux;
				} else {
					j = 'a' - (iterator->first).second;
				}// fim 
			}//fim de if 
			if(cor[j] == corB){
					visita(j);
			}//fim if
		}//fim for
		cor[i] = corP;
	}// fim visita
};//fim Grafo
/*
    Metodo main recebe os valores dos numCasos casos, v vertices e das a arestas, acrescenta as arestas a medida que 
*/
int main()
{
    char letra1, letra2, aux1, aux2;
	int numCasos=0;
	int v=0;
	int e=0; 
	cin >> numCasos;//le numero de casos
		for(int i = 0; i < numCasos; i++){
        	cin >> v; // le qtd vertices
        	cin >> e; // le qtd arestas
        	cout << "Case #" << i + 1 << ":" << endl;
        	Grafos G(v);//cria um grafo para cada caso
        	for(int j = 0; j < e; j++){
              	cin >> letra1;//le as letras para cada caso
              	cin >> letra2;
              	    if(letra1 > letra2){
					aux1 = letra2;
					aux2 = letra1;
				} else {
					aux1 = letra1;
					aux2 = letra2;
				}
        		G.adicionar(aux1, aux2, 0);
    	    }//fim do for
    G.dfs();
    cout << endl;
  }// fim do for 
  return 0;
}
