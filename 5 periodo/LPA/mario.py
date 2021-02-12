import networkx as nx
testes=int(input())
for t in range (testes):
	G=nx.DiGraph()
	A, B,L,K,M= map(int, input().split()) 
	G.add_nodes_from([1,A+B])
	i=0
	z=A+B
	while i<z:
	  q, y, w = map(int,input().split())
	  G.add_edge(q,y,weight=w)
	  G.add_edge(y,q,weight=w)
	  i=i+1
	paths= nx.all_simple_paths(G, source = A+B, target = 1)
	distanciaMax = -1
	for pat in paths:
		dist = 0
		bota = M
		distMax = K
		castelo = False
		for f,e in enumerate(pat):
			if(e != 1):
				proximo = pat[f+1]
				atravessa = (proximo > A)
				if not atravessa:
						if(bota > 0 and distMax > 0 and not castelo):
							distMax = distMax - G[e][proximo]['weight']
						else:
							dist = dist + G[e][proximo]['weight']
							castelo = False
				else:
					dist = dist + G[e][proximo]['weight']
					castelo = True
			if(distMax <= 0):
				bota= bota - 1
		if(dist < distanciaMax or distanciaMax == -1):
			distanciaMax = distancia
	print(distanciaMax)