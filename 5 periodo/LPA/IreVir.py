import networkx as nx
a, b= map(int, input().split())
while a>0 and b>0:
  G=nx.DiGraph()
  G.add_nodes_from([1,a])
  for i in range(b):
    v, w, m=map(int, input().split())
    if m==2:
      G.add_edge(v,w)
      G.add_edge(w,v)
    else:
      G.add_edge(v,w) 
  if(nx.is_strongly_connected(G)):    
    print ('1')
  else:
    print ('0')
  a, b= map(int, input().split())       