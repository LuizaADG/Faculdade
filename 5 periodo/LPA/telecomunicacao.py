import networkx as nx
n,p,k= map(int, input().split())
while(n>0 and p>0 and k>0):
  G=nx.Graph()
  G.add_nodes_from([1,n])
  lista=[n]
  for i in range (p):
    emp1, emp2= map(int, input().split())
    G.add_edge(emp1,emp2)      
  lista=[]  
  for j in range (1,n+1):
    lista.append(j)
  remover=[]  
  for r in range(0,n):
    if(G.degree[lista[r]]<k):
      G.remove_node(lista[r])
      remover.append(r) 
  for g in range (0,len(remover)-1):
    for o in range (0,len(lista)-1):
       if(lista[o]==(remover[g]+1)):
         lista.pop(o)
  for t in reversed (range(len(lista)-1)):
    if(G.degree[lista[t]]<k):
      G.remove_node(lista[t])
  resp= list(sorted(nx.connected_components(G),key=len,reverse=True))  
  if(len(resp)==0):
    print("0")
  else:
    print(len(resp[0]))
  n,p,k= map(int, input().split())               