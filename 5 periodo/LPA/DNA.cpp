#include <stdio.h>
#include <string.h>
#include <iostream>
using namespace std;
char p1 [100];
char p2 [100];
int main(){
	int mfinal [100][100];
	int lcs[100][100];
	int a;
	int x;
	int nTam;
	while(cin>>nTam && nTam){	
		//cin>>nTam;
		scanf("%s %s",p1,p2);
		a=strlen(p1);
		x=strlen(p2);
		/*
		*Preenchendo as matrizes
		*/
		for(int i=1;i<=a;i++) mfinal[i][0]=0;
		for(int j=1;j<=x;j++)mfinal[0][j]=0;
		for(int i=1;i<=a;i++) lcs[i][0]=0;
		for(int j=1;j<=x;j++)lcs[0][j]=0;
		
		/*LCS*/
		for(int i=1;i<=a;i++){
			for(int j=1;j<=x;j++){
				if(p1[i-1]==p2[j-1])
					mfinal[i][j]=mfinal[i-1][j-1]+1;//nesse caso, soma-se o da diagonal com 1 
				else 
					mfinal[i][j]=0;
			}
		}	
		for(int i=1;i<=a;i++){
			for(int j=1;j<=x;j++){
				lcs[i][j]=max(lcs[i-1][j], lcs[i][j-1]);
				for(int s=nTam; s<=mfinal[i][j]; s++)
                    lcs[i][j] = max(lcs[i][j], lcs[i-s][j-s]+s); 
			}
		}	
		cout<< lcs[a][x]<<endl;
	}
	return 0;
}

