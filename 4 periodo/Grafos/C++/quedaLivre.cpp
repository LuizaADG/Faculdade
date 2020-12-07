#include <map>
#include <iterator>
#include <utility>
#include <math.h>
#include <iostream>
#include <list>
#include <algorithm>
#include <stdio.h>
#include <vector>

using namespace std;

/*
    Constantes utilizadas
*/
#define infinito 999999999
#define maximo 500
/*
    Estrutura de coordenadas possui as coordenadas e 
*/
typedef struct {
  float x,y;
  int noAdd;
} Coordenadas;
/*
    Classe grafos possui vertices, arestas e Coordenadas
*/
class Grafos{
	int N; 
	int e; 
	int aux;
	Coordenadas coordenadas[maximo];

	public:
	float caminhoMenosPeso;
/*
    Metodo que retorna a quantidade de arestas
*/
    int quantArestas(int n){
        int e;
        e=(n*(n-1))/2;
        return e;
    }
/*
    Metodo construtor de Grafos recebe um numero de vertices, quantidade de arestas e zera o auxiliar
*/
	Grafos(int N){
		this->N = N; 
		this->e = quantArestas(N); 
		this->aux = 0;
	}// fim construtor
    /*
        Metodo coloca as coordenadas na estrutura, além de somar 1 no auxiliar e igular a 0 o noAdd
    */
	void coordenada(int x, int y, int noAdd){
		coordenadas[aux].x = x;
		coordenadas[aux].y = y;
		coordenadas[aux].noAdd = noAdd;
		aux++;
	}// fim adicionarAresta
/*
    Metodo com formula que retorna a distancia entre os dois pontoss
*/

    float dist(int xa, int xb, int ya, int yb){
         float peso=0;
         peso=sqrt(pow((xb - xa),2) + pow((yb - ya),2));
         return peso;
    } 
/*
    Metodo prim será usado para cada uma das arvores,
*/
	void prim(){
		int prox, xa, xb, ya, yb, aux = 0;
		float menor, peso = 0;
		caminhoMenosPeso = 0;
		aux = coordenadas[0].noAdd = 1;// primeiro vertice sendo usado
		while(aux < N){
		menor = infinito;
			for(int i = 0; i != N; i++){             //Loop dos vertices pertencentes a arvore.
				if(coordenadas[i].noAdd == 1){      //Checagem do no na arvore
					for(int j = 0; j != N; j++){    // Loop dos vertices que ainda nao foram adicionados a arvore. 
						if(coordenadas[j].noAdd != 1){
							xa = coordenadas[i].x;
							ya = coordenadas[i].y;
							xb = coordenadas[j].x;
							yb = coordenadas[j].y;
							peso =dist(xa,xb,ya,yb);
							if(menor == infinito || peso < menor){
								menor = peso;
								prox = j;
							}//fim if
						}//fim if
					}//fim for 
				}//fim if
			}// fim for 
			caminhoMenosPeso += menor;
			coordenadas[prox].noAdd = 1;
			aux++;
		}
    printf("%.2f\n\n", caminhoMenosPeso/100);

	}//fim prim
};//fim Grafo
/*
    Metodo main contém o numero de casos teste, numero de pessoas, coordenadas, peso, criação do grafo, adição de coordenadas e prim para solucionar o problema
*/
int main(){
	int numCasos; 
	int pes; 
	int x,y; 
	float peso = infinito;
	cin >> numCasos;
	for(int i = 0; i < numCasos; i++){
  	cin >> pes;
		if(pes > 500){
			cout << "Nope!" << endl;
			cin >> pes;
		}//fim if
  	Grafos G(pes);
  	for(int j = 0; j < pes; j++){
			cin >> x;
			if(x > 100000 || x < 0){
				cout << "Nope!" << endl;
				cin >> x;
			}
			cin >> y;
			if(y > 100000 || y < 0){
				cout << "Nope!" << endl;
				cin >> y;
			}
			G.coordenada(x,y,0);
  	}// fim for
		G.prim();
	}//fim for
  return 0;
}// fim main
