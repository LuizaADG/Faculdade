set ORIG; # Origens
set DEST; # Destinos

param oferta {ORIG} >= 0;
# quantidade disponível nas origens
param demanda {DEST} >= 0;
# quantidade requerida nos destinos

check : sum {i in ORIG} oferta[i] = sum {j in DEST} demanda[j]; #tratamento entradas

param Custo {ORIG,DEST} >= 0; # custo de entrega (por unidade) na rota i,j

var X {ORIG,DEST} >= 0; # Varíaveis de decisão unidades a serem entregues na rota ( i,j

minimize Custo_Total:
sum {i in ORIG, j in DEST} Custo[i,j] * X[i,j];

#restricoes
subject to Oferta {i in ORIG}:
sum {j in DEST} X[i,j ] = oferta[i];
subject to Demanda {j in DEST}:
sum {i in ORIG} X[i,j] = demanda[j];