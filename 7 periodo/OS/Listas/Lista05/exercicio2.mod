set C;
set I;

#variaveis de decisao
var y {i in C} binary;
var x {i in C, j in I} binary;

minimize bin_packing: 
sum{i in C} y[i];

subject to var_X_sum{i in C}:
sum{j in I} x[i,j] =1;

subject to var_X_sum{i in C}:
sum{j in I} x[i,j]*peso[j]<=cap[i]*y[i];

