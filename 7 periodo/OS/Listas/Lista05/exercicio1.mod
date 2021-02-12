set D;
set Q;

param t {i in Q};

minimize C;

var X {i in M, j in N} binary ; # variáveis de decisao (vetor X)

subject to Execucao_em_processador {i in Q}:
sum{j in D} X[i,j];

subject to Tempo_em_processador {j in D}:
sum{i in Q} t[j]X[i,j] <=C;

subject to Entre_numeros1 {j in D}:
sum {i in Q} X[i,j] <= 1;

subject to Entre_numeros2 {j in D}:
sum {i in Q} X[i,j] >=0;
