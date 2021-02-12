def ratio(mochila):
    totalWeight
testes = int(input())
for i in range(testes):
    numero = int(input())
    itens = []
    mochila = []
    pesoA = 0
    valorA = 0
    for i in range(numero):
        item = input().split()
        itens.append(item)
    capacidade = int(input())
    resistencia = int(input())
    for i in range(capacidade):
        for item in itens:
            if pesoA + int(item[1]) <= capacidade:
                mochila.append(item)
                pesoA = pesoA + int(item[1])
                valorA = valorA + int(item[0])
                itens.remove(item)
            else:
                for inclusion in mochila:
                    if  valorA/pesoA < (valorA - int(inclusion[0]) + int(item[0])) / (pesoA - int(inclusion[1]) + int(item[1])):
                        pesoA = pesoA - int(inclusion[1]) + int(item[1])
                        valorA = valorA - int(inclusion[0]) + int(item[0])
                        mochila.append(item)
                        mochila.remove(inclusion)
                        itens.remove(item)
                        itens.insert(0, inclusion)
                        break
    if valorA >= resistencia:
        print('Missao completada com sucesso')
    else:
        print('Falha na missao')