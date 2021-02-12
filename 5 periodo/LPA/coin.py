vezes = int(input())
j=1
while(j<(vezes+1)):
  tipos = int(input())
  lista = list(map(int, input().split()))
  maior=lista[0]
  moeda=1
  for i in range (1,tipos-1):
    if((maior+lista[i])<lista[i+1]):
      maior=maior+lista[i]
      moeda=moeda+1
      #print(moeda)
  moeda=moeda+1
  print(moeda)
  j=j+1