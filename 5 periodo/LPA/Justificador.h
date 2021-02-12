#include <iostream>

using namespace std;

bool check_string(const char* string) {
  const int string_len = strlen(string);
  for(int i = 0; i < string_len; ++i) {
    if(!isdigit(string[i])) 
      return false;
  }
  return true;
}

int main() {
	int nLinhas;
	int n;
	char  array [1000];
	cin >> nLinhas;
	    for(int i=0; i< nLinhas; i++){
	        if(check_string(array[])==true-){
	           for(int j=0; ;j++){ 
	            cin >> array[j];
	       
	           }        
	       }
	    }
	cin >> nLinhas;        
}
