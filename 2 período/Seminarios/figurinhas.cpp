#include <stdio.h>
#include <stdlib.h>
  int main()
    {
        int tam=0;
        scanf("%d",&tam);
        int array[tam][tam];
        int i;
        int j;
        int u;
        int h;
        scanf("%d %d",&i ,&j);
        array[i][j]; 
        scanf("%d %d",&u,&h);
        array[u][h];
        if((i-u)%2!=0||i==u)
        {
		if((j-h)%2!=0||j==h)
		{
            		printf("S");
		}else{
            printf("N");
		}
        }
    return 0;	
    }
