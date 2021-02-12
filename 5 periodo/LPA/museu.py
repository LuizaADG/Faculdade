import networkx as nx
def get_len_path(G,x):
    weigth = 0
    for i in range(len(x) - 1):
        weigth +=  G[x[i]][x[i + 1]]['weight']
    return weigth
museus=input()
while (museus!='0'):
  nVert=int(museus)
  museus_list = [i for i in range(nVert + 1)]
  museus_list.remove(0)
  G=nx.DiGraph()
  G.add_nodes_from(museus_list)
  pesos = input().split(' ')
  dict_pesos = {museus_list[i]:int(pesos[i])
                  for i in range(len(museus_list))}
  for i in G.nodes:
        arestas = input().split(' ')
        for j in museus_list:
            if int(arestas[j - 1]) == 0:
                pass
            else:
                G.add_edge(int(i),j,weight=int(arestas[j - 1]) +  dict_pesos[j])
  valids_path = []
  for i in museus_list:
    for j in museus_list:
      paths = nx.all_simple_paths(G,i,j)
      for k in paths:
        total = 0
        total += get_len_path(G,k)
        total+= dict_pesos[k[-1]]
        if total <= (60*7):
          valids_path.append(k)
  if valids_path:
    x = max([len(valids_path[i]) for i in range(len(valids_path))])
    print(x)
  else:
    um_museu = False
    for i in dict_pesos.keys():
      if dict_pesos[i] < (60*7):
        um_museu = True
        break
    if um_museu:
      print(1)
    else:
      print(0)   
  museus=input()