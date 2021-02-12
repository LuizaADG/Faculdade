import networkx as nx
a, b= map(int, input().split())
i=1
while(a!=0 and b!=0):
  print("Instancia "+ str(i))
  G=nx.Graph()
  G.add_nodes_from([1,a])
  for i in range (b):
    q, y, w = map(int,input().split())
    G.add_edge(q,y,weight=int(w))
  vezes=input()
  for j in range (int(vezes)):
    maxi=[]
    ori, dest= map(int, input().split())
    tamanho = 100000
    for path in nx.all_simple_paths(G, source=ori, target=dest):
      lista = path
      tamanho=len(lista)
      #print (lista)
      a1 = 0
      for i in range (tamanho-1):
        #print("i: "+str(i))
        ar= int(G[lista[i]][lista[i+1]]['weight'])
       # print(cam)
        if(ar>a1):
          #print("cam:"+str(cam))
          a1=ar
      #print(a1)
      maxi.append(a1)
    print(min(maxi))        
  i=i+1
  a, b= map(int, input().split())