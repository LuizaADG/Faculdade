#include <iostream>
#include <stdio.h>
using namespace std;
int main(){
	int n;
	int i, j;
	cin >> n;
	int matriz[n][n];
	int sup = 0;
	int inf = 0;
	//Colocar os numeros no array
	for (i = 0; i <= n-1; i++){
     for (j = 0; j <= n-1; j++){
     	cin >> matriz[i][j];
     	//cout<< "\npassei aqui na vez: " << i << j;
	 }
    } 
    //output da matriz
    /*for (i = 0; i <= n-1; i++)
     {
     for (j = 0; j <= n-1; j++)
           cout << matriz[i][j]<<" ";
     cout << endl;
     }*/
    int aux[n+1][n+1];
     // zerando a linha do topo e a coluna da esquerda
    for (int a = 0; a < n+1; a++) { 
		aux[0][a] = 0; 
		aux[a][0] = 0; 
	}
        // todas as somas usando aux, res deve ser o menor numero da questão
   for (int a = 1; a < n+1; a++)
        for (int b = 1; b < n+1; b++)
        aux[a][b] = aux[a-1][b] + aux[a][b-1] - aux[a-1][b-1] + matriz[a-1][b-1];
        int res = -127;
        /*Calculando todas as somas usando o auxiliar
        * e colocando o maior resultado em res
        *os primeiros dois são usados 
		*/
        for (int a = 1; a < n+1; a++){
        	for (int b = 1; b < n+1; b++){
        		for (int c = a-1; c >= 0; c--){
        			for (int d = b-1; d >= 0; d--){
        				if (aux[a][b] + aux[c][d] - aux[a][d] - aux[c][b] > res){
							res = aux[a][b] + aux[c][d] - aux[a][d] - aux[c][b];
						} 
					}
				}
			}
		}  
        cout << res << endl;
	return 0;  
}//fim de main
