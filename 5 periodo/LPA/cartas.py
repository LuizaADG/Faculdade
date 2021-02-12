import networkx as nx
a = input()
q=int(a)
G=nx.Graph()
G.add_nodes_from([1,a])
lista=[int(x) for x in input().split()]
i=1
while i<=(q-1):
  v,w=map(int, input().split())
  G.add_edge(v,w)
  i=i+1        
maxi=0
for i in range (0,q-1):
  for j in range (i+1,q):
    if(lista[i]==lista[j]):
      maxi=nx.shortest_path_length(G, source=(i+1), target=(j+1))+maxi
if(maxi>0):
  print(maxi)