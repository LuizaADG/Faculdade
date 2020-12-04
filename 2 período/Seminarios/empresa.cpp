#include <stdio.h>
int main()
{
	int tam;
	scanf("%d",&tam);
	int A[tam][tam];
	int B[tam][tam];
	int C[tam][tam];
	int p,q,r,s,x,y;
	int i,j;
	scanf("%d %d %d %d %d %d %d %d",&p,&q,&r,&s,&x,&y,&i,&j);
	for(int k=0;k<tam;k++)
	{
		for(int o=0;o<tam;o++)
		{
			A[k][o]=(p*(k+1)+q*(o+1))%x;
			B[k][o]=(r*(k+1)+s*(o+1))%y;
		}
	}
	for(int g=0;g<tam;g++)
	{
		for(int l=0;l<tam;l++)
		{
			C[g][l]=0;
		}
	}
	for(int i=0;i<tam;i++)
	{
		for(int j=0;j<tam;j++)
		{
			for(int m=0;m<tam;m++)
			{
				C[i][j]+=A[i][m]*B[m][j];
			}
		}
	}
	printf("%d",C[i-1][j-1]);
return 0;
}
