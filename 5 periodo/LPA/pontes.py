#Ideia básica:
#Criar uma lista com os nodulos
#Checar se cada um dos vertices possui um caminho que liga com outro que não seu vizinho
#Para isso, checarei se ele liga com dois, ou seja, com seu sucessor e o sucessor do sucessor e assim por diante
import networkx as nx
a, b= map(int, input().split())
while True:
  G=nx.Graph()
  G.add_nodes_from([1,a+1])
  for i in range(b):
    v, w=map(int, input().split())
    G.add_edge(v,w)
  lista=[]  
  for j in range (1,a+1):
    lista.append(j)
  pontes=0	
  for q in range (0,len(lista)-2):
    for t in range (q+1,len(lista)-1):
      #print("q:"+str(q))
      #print("t:"+str(t))
      if(lista[q] in G[lista[t]]and lista[t+1]in G [lista[q]]):
          pontes=pontes+1
          #print("aqui"+str(lista[q]))
          #print("aqui2"+str(lista[t]))
      #print("q:"+str(q))
      #print("t:"+str(t))    
  print(nx.number_of_edges(G)-pontes)			
#a, b= map(int, input().split())       