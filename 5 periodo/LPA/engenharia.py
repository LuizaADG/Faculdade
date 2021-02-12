#Ideia basica:
#O engenheiro só conseguirá realizar a ação 
# se o grafo for fortemente conectado
#Caso contrário, não consegue
import networkx as nx
a= input()
instancias=int(a)
i=1
while(i<(instancias+1)):
  #print("\n")
  programadores=int(input())
  G=nx.DiGraph()
  G.add_nodes_from([1,programadores])
  j=1
  while(j<(programadores+1)):
    lista = list(map(int, input().split()))
    for k in range(1,lista[0]+1):
      G.add_edge(j, lista[k])
      #print(j)
      #print(lista[k])
    j=j+1
  print("Instancia "+ str(i))
  if(nx.is_strongly_connected(G)):    
    print ("pair programming"+"\n")
  else:
    print ("extreme programming"+"\n")  
  i=i+1    
  