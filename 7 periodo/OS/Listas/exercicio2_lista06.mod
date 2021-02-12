set agente; 
set objetos; 
# custo de atribui��o
param beneficio {agente,objetos} >= 0;

var X {agente,objetos} binary ; # Var�aveis de decis�o

minimize Beneficio_Total:
sum {i in agente, j in objetos} beneficio[i,j] * X[i,j];

subject to Agentes {i in agente}:
sum {j in objetos} X[i,j] = 1;

subject to Objetos {j in objetos}:
sum {i in agente} X[i,j] = 1;