#include <iostream>
#include <bits/stdc++.h>

using namespace std;
/*
    Metodo main ocorre enquanto receber cidades. No caso, k serão as instancias, cidades os vertices, rotas as arestas, 'a' e 'b' cidades e 'c' será o custo da rota e d serão o numero de amigos.
    A ideia geral é a criação de uma matriz de adjacencias com as cidades e preenche-la com os custos apropriados.
    Depois calculara as rotas 
*/
int main() {
    int k = 1;
    int cidades;
    while (cin >> cidades) {
        cout << "Instancia " << k << "\n\n";
        int rotas, d, assentosLivres, nRot, a, b, c, nRotO;
        int cusTot = 0;
        cin >> rotas;
        int matriz[cidades][cidades];
        for (int i = 0; i < cidades; i++){
            for (int j = i + 1; j < cidades; j++){
                matriz[i][j] = -1;
            }//fim de for    
        }//fim de for        
        for (int i = 0; i < rotas; i++) {
            cin >> a >> b >> c;
            if (b > a){
                matriz[a-1][b-1] = c;
            }else{
                matriz[a-1][b-1] = c;
            }
        }//fim de for
        cin >> d >> assentosLivres;
        nRot = d / assentosLivres;//amigos por assentos Livres, para calcular as rotas
        if (nRot < 1)//acontece quando o numero de assentos é maior
            nRot = 1;
        nRotO = nRot;
        while (nRot > 0) {
            int taAqui = cidades-1;//o array começa do 0, então terá menos cidades
            int menor = 50000000;//aleatório
            int vaiPara = taAqui;
            int cusPar = 0;
            while(taAqui != 0) {
                for (int i = 0; i < taAqui; i++) {
                    if (matriz[i][taAqui] != -1 && matriz[i][taAqui] < menor) {
                        menor = matriz[i][taAqui];//pegar valor
                        matriz[i][taAqui] = -1;//anular pois já pegou
                        vaiPara = i;
                    }//fim de if
                }//fim de for
                cusPar= cusPar + menor;//ir acrescentando a medida que vai indo na rota
                if (cusPar == 50000000 || cusPar < 0) {
                    cout << "impossivel";
                    return 0;
                }// fim de if
                taAqui = vaiPara;
            }//fim de while
            cusTot= cusTot + (d / nRotO) * cusPar;
            nRot--;
        }//fim de while
        cout << cusTot << "\n\n\n\n";
        k++;
    }//fim de while
}//fim main
