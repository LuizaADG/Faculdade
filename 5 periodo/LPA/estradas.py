import networkx as nx
a, b= map(int, input().split())
while(a!=0 and b!=0):
  G=nx.Graph()
  G.add_nodes_from([0,(a-1)])
  tot=0
  lista=[]
  for i in range (b):
    q, y, w = map(int,input().split())
    G.add_edge(q,y,weight=w)
    tot=tot+w
  T=nx.minimum_spanning_tree(G,weight='weight')
  #print(T.edges(data=True))
  ilumina=0
  #print(tot)
  for (u, v, w) in T.edges.data('weight'):
    ilumina= ilumina+ (T.edges[u, v]['weight'])
  #print(ilumina)  
  economiza=tot-ilumina
  print(economiza)
  a, b= map(int, input().split())
