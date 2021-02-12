#variaveis de decisao
param p {i in T, j in M};#tempo de processamento maquina k com tarefa i
param maq {i in T};#maquina processa i-ésima tarefa

#constante Ma
param Ma =100;

#variáveis de decisão
var C {i in T, j in M};
var X {i in T, j in T, k in M} binary;

#problema
maximize job_shop: sum {i in T, m in M} C[i,m];

#restricoes

#primeira tarefa termina em cada maquina
subject to termino_tempo{i in T}:
C[i]*maq[1] >= p[i]*maq[1];

#a operação k + 1 seja concluída depois do término da operação k e do tempo de processamento da operação k + 1. 
subject to operacao {i in T, k in M}:
C[i, maq[k+1]] >= p[i, maq[k+1]] + C[i, maq[k]];

# na máquina k, a tarefa i precede a tarefa j, ou a tarefa j precede a tarefa i
subject to process1 {i in T, j in T, k in M}:
C[j,k]>= C[i,k] + p[j,k] - Ma*(1-X[i,j,k]);

subject to process2 {i in T, j in T, k in M}:
C[j,k]>= C[i,k] + p[j,k] - Ma*(X[i,j,k]);

#termino>=0
subject to maior_que_zero {i in T, k in M}:
C[i,k]>= 0;
 