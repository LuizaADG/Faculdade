#include <vector>
#include <math.h>
#include <stdio.h>
#include <iostream>
#include <list>
#include <algorithm>
#include <map>
#include <iterator>
#include <utility>

using namespace std;


#define corB 2
#define corC 1
#define corP 0
#define maximo 500

typedef struct {
  int nome,cor;
} Vertice;

typedef struct {
  int x,y;
} Aresta;
/*
    Classe Grafos contém os numeros de vertices do Grafo; e um ponteiro cor publico e um para um array que tem listas de adjacencias  
*/
class Grafos{
	int N; 
public:
  int posArestas;
  Vertice vertices[maximo];
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
	}// 
  void adicionar(char v1, char v2, int peso){
  	adj.insert(make_pair(make_pair(v1, v2), peso));
  }// fim adicionarAresta
/*
    Checar se é conexo ou não
*/
bool conexo(){
    bool conexo = true;
	int componentes = 0;
    int aux[N];
    for(int i = 0; i < N; i++){
      aux[i] = maximo; 
    }//fim for
    int aux1, aux2;
    map<pair<char,char>, int> :: iterator it;
    for(it = adj.begin(); it != adj.end(); it++){
      aux1 = (it->first).first - 'a';
      aux2 = (it->first).second - 'a';
      aux[aux1] = aux1;
      aux[aux2] = aux2;
		}// fim for
    for(int i = 0; i < N; i++){
      if(aux[i] == maximo){
        conexo = false;
      }
    }//fim for
		return conexo;
}// fim 
/*
    Metodo que verifica as adjacencias
*/
  bool vAdj(int i, int j){
    bool conexo = false;
    char a,b;
    map<pair<char,char>, int> :: iterator iterator;
    for(iterator = adj.begin(); iterator != adj.end(); iterator++){
      a = (iterator->first).first;
      b = (iterator->first).second;
      if(((a == i + 'a') && (b == j + 'a')) || ((b == i + 'a') && (a == j + 'a'))){
        conexo = true;
      }//fim if
    }//fim for
    return conexo;
  }//fim 
  /*
    Metodo de verificar  checa se é possivel construir
  */
    void verifica(int a1, int a2){
        for(int i = 0; (i < N) && (a2 != 0); i++){
          for(int j = 0; (j < N) && (a2 != 0); j++){
            if(vertices[i].cor != vertices[j].cor){
              if(!vAdj(i,j)){
                a2--;
                if(i > j){
                  adicionar(i + 'a', j + 'a',0);
      				  } else {
                  adicionar(j + 'a', i + 'a',0);
      				  }//fim 
              }//fim 
            }//fim 
          }//fim for
        }//fim for
        if(a2 == 0){
          if(conexo()){
            cout << "Y" << endl << endl;
          } else {
            cout << "N" << endl << endl;
          }//fim 
        } else {
          cout << "N" << endl << endl;
        }//fim 
    }// fim 
};
/*
    Metodo main recebe a quantidade de casos teste o numero de vertices (v), as arestas iniciais(a), as arestas que serão inseridas (aInsere) e o numero de cores(numCor)
    Após a criação do grafo, ele insere as cores nos vertices
*/
int main(){
		int numCasos; //quantidade de casos de teste
		int v, a, aInsere, numCor; 
		int cor, aux1, aux2;
		cin >> numCasos;
		for(int i = 0; i < numCasos; i++){
			cin >> v;
			cin >> a;
			cin >> aInsere;
			cin >> numCor;
      Grafos G(v);
			for(int j = 0; j < v; j++){
				G.vertices[j].nome = j;
				cin >> cor;
				G.vertices[j].cor = cor;
			}//fim for
        char o, r;
			for(int x = 0; x < a; x++){
				cin >> aux1;
				cin >> aux2;
        aux1 -= 1;
        aux2 -= 1;
        if(aux1 > aux2){
          G.adicionar(aux1 + 'a', aux2 + 'a',0);
				} else {
          G.adicionar(aux2 + 'a', aux1 + 'a',0);
				}//fim if/else
			}//fim for
        G.verifica(a,aInsere);
    }//fim for
      return 0;
}//fim main()
