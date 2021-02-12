import networkx as nx
teste=input()
while (teste!=''):
  regiao, pontes= map(int, teste.split())
  G=nx.DiGraph()
  G.add_nodes_from([1,regiao])
  i=0
  while((i<pontes)):
    v, w=map(int, input().split())
    G.add_edge(v,w)
    G.add_edge(w,v)
    i=i+1
  soma=0   
  for j in range (1, regiao+1):
    for k in range(1, regiao):
      if(G.has_edge(j, k)):
        soma=soma+2
        if(soma==regiao):
          print("S")
          break
  if(soma!=regiao):
    print("N")  
  teste=input()