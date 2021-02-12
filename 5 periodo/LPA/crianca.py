import networkx as nx
a, b= map(int, input().split())
while a>0:
  if b!=0:
    G=nx.DiGraph()
    G.add_nodes_from([1,a])
    for i in range(b):
      v, w=map(int, input().split())
      G.add_edge(v,w)
      G.add_edge(w,v) 
    if(nx.is_strongly_connected(G)):    
      print ('Y')
    else:
      print ('N')
  else:
    print ('Y')
  a, b= map(int, input().split())       