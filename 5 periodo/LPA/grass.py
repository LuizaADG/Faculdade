from math import sqrt
while True:
    try:
      linhas, largura, altura= map(int, input().split())
    except:
      break
    A = []
    for x in range(linhas):
        pos, raio = map(int,input().split())
        if raio * 2 < altura:
            continue
        d = sqrt(raio ** 2 - (altura / 2.0) ** 2)
        esquerda, direita = max(0, pos - d), min(largura, pos + d)
        A.append((esquerda, direita))
    A.sort()
    esquerda = A[0][0]
    direita = A[0][1]
    count = 1
    for i in range(1, linhas):
        if A[i][0] > direita:
            break
        elif A[i][0] <= esquerda and A[i][1] > direita:
            direita = A[i][1]
        elif A[i][0] > esquerda and A[i][1] > direita:
            esquerda = direita
            direita = A[i][1]
            count += 1
    if direita != largura:
        count = -1
    print (count)