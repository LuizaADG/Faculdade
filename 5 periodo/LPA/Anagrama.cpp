#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <sstream>
#include <algorithm>
#include <iterator>
using namespace std;
static map<string, string> memoria;
/* Checar se s tem as frases do dicionario principal começando  por iterStart.
* frase  -- frases originais.
* anagramas -- armazena os anagramas.
* bateu  -- bateu[i] = true if s[i] bateu com o dic; false, caso não tenha batido.
*/
void procurar(const vector<string> &frase, const map<string, string>::iterator &iterStart, vector<string> &anagramas, const string &s, vector<bool> &bateu)
{
    //s tem todos os elementos marcados
    if (count(bateu.begin(), bateu.end(), false) == 0)
    {
        copy(frase.begin(), frase.end(), ostream_iterator<string>(cout, " "));
        cout << "=";
        for (size_t i = 0; i < anagramas.size(); ++i){
            cout << " " << anagramas[i];
    	}
        cout << endl;
        return;
    }
    map<string, string>::iterator iter = iterStart;
    for (; iter != memoria.end(); ++iter)
    {
        vector<size_t> marcaPos;
        for (size_t i = 0, j = 0; i < s.size(); ++i)
        {
            if (!bateu[i] && s[i] == iter->second[j])
            {
                marcaPos.push_back(i);
                // Bateu
                if (j == iter->second.size() - 1 && find(frase.begin(), frase.end(), iter->first) == frase.end())
                {
                    // Marcar os elementos que batem
                    for (size_t k = 0; k < marcaPos.size(); ++k)
                    {
	                    bateu[marcaPos[k]] = true;//guardar os anagramas
	            	}
					anagramas.push_back(iter->first);
	                procurar(frase, iter, anagramas, s, bateu);
	                anagramas.pop_back();
                    //Desmarcar
	                    for (size_t k = 0; k < marcaPos.size(); ++k){
	                        bateu[marcaPos[k]] = false;
	                	}
	                    break;
                }else
                    ++j;
            }
        }
    }
}
int main()
{  
    string dic;
    // Guardando o dicionário
    while (getline(cin, dic), dic != "#")
    {
        string chave = dic;
        sort(chave.begin(), chave.end());
        memoria[dic] = chave;
    }
    // Analisando palavras. Para isso armazenaremos elas em um vetor
    while (getline(cin, dic), dic != "#")
    {
        string s = dic;
        vector<string> frase;
        stringstream ss(dic);
        while (ss >> dic)
            frase.push_back(dic);
        s.erase(remove(s.begin(), s.end(), ' '), s.end());//remove espaços
        sort(s.begin(), s.end());//ordenando s
        vector<bool> bateu(s.size(), false);//marcando s que bate em outros
        vector<string> anagramas;//armazenando os anagramas
        procurar(frase, memoria.begin(), anagramas, s, bateu);
    }
    return 0;
}
