#include <iostream>
#include <string.h>
#include <stdio.h>
#include <iomanip>
using namespace std;
/*
*Metodos trim para deletar espaços da string
*/
string esquerda_trim(string s){
    return s.substr(s.find_first_not_of( " " ));
}
  
string direita_trim(string s){
    return s.substr(0, s.find_last_not_of(" ") + 1);
}
  
string trim(string s){
    return direita_trim(esquerda_trim(s));
}
/*Metodo para remover os espaços extras que estão na string 
*	Caso o ponteiro aponte para algo diferente de espaço
*testamos se o numero de espaços é maior que zero 
*acrescentamos um espaço na string e zeramos os espaços
* caso o contrário, vamos acrescentar o numero de espaços. PALAVRA A VISTA
*/
string apagar(string teste){ 
    string vai = "";
    string::iterator it;//como um ponteiro
    int espacos = 0;
    for(it = teste.begin(); it != teste.end(); it++){
        if(*it != ' '){
            if(espacos > 0) {
                vai = vai+ " ";
                //cout<<vai;
                espacos = 0;
            }         
            vai = vai + *it;
            //cout<<vai;
        }
        else {
            espacos =espacos+1;
            //cout<<vai;
        }
    }
    return vai;
} 
/*
	*Enquanto o numero de linhas for diferente de 0 o programa irá ler linha por linha e preencherá o array de strings
	*a string teste vai enchendo de acordo com as linhas e separando por linhas
	* depois, apagamos os espaços da string
*/
int main() {
	int nLinhas;
	//string  array [1000];
	//string teste ="";
	int max=0;
	//string tempo="";
	bool primeiro = true;
	while(cin >> nLinhas && nLinhas){
		string *denovo= new string[nLinhas]; 
		cin.ignore();
		max=0;
		if(primeiro) primeiro = false;
        else cout << endl;
		for(int i=0;i<nLinhas;i++){
			//cin.ignore();
			getline(cin,denovo[i]);
			denovo[i]=apagar(trim(denovo[i]));
			//teste=denovo[i];
			if(denovo[i].size()>max) max=denovo[i].size();
			//cout<<max;
			//cout<<teste;
	    	//cout<<"passei aqui"<< nLinhas<<endl;
	    //tempo="";
		//cout<<tempo;	
		}
		for(short i = 0; i <nLinhas; i++){
            cout << setw(max) << denovo[i] << endl;
        }
		//cin>>nLinhas;   
	}      
}
