import copy
import time

#Metodo utilzado para mostrar os nos do pluzze
def mostrarNo(no):
    print(no[0], no[1], no[2])
    print(no[3], no[4], no[5])
    print(no[6], no[7], no[8])
    global numeroNo
    print('No:', numeroNo)
    print('Profundidade:', len(no[9:]))
    print('Moveminento:', no[9:])
    numeroNo += 1

#Validar se foi encontrado o no final
def validarFinal(no):
    if no[:9] == noFinal:
        mostrarNo(no)
        return True
    global indiceInsercao
    if no[:9] not in listaNosVisitados:
        mostrarNo(no)
        pilha.insert(indiceInsercao, no)
        indiceInsercao += 1
        listaNosVisitados.append(no[:9])
    return False

#Main
#0 quadrado vazio
#NoInicial como vai comecar o puzzle
#NoFinal o que se deseja encontrar
#Roda enquanto a flag de encontrado nao for true e enquanto existirem nos na pilha
#   A cada interacao se remove um no da pilha e compara com os nos adjacentes
#   Entao é feito o movimento e adicionado no vetor para indicar o movimento
#   E se chama o metodo para verificar se encontrou o resultado final desejado
if __name__ == '__main__':
    noInicial = [1, 2, 5, 3, 4, 8, 6, 7, 0]
    noFinal = [0, 1, 2, 3, 4, 5, 6, 7, 8]

    encontrado = False
    numeroNo = 0
    listaNosVisitados = pilha = []
    pilha.append(noInicial)
    listaNosVisitados.append(noInicial)
    mostrarNo(noInicial)
    t0 = time.time()

    while not encontrado and not len(pilha) == 0:
        noAtual = pilha.pop(0)
        quadradoVazio = noAtual.index(0)
        indiceInsercao = 0
        if quadradoVazio != 0 and quadradoVazio != 1 and quadradoVazio != 2:
            noSuperior = copy.deepcopy(noAtual)
            noSuperior[quadradoVazio] = noSuperior[quadradoVazio - 3]
            noSuperior[quadradoVazio - 3] = 0
            noSuperior.append('cima')
            encontrado = validarFinal(noSuperior)
        if quadradoVazio != 0 and quadradoVazio != 3 and quadradoVazio != 6 and not encontrado:
            noEsquerda = copy.deepcopy(noAtual)
            noEsquerda[quadradoVazio] = noEsquerda[quadradoVazio - 1]
            noEsquerda[quadradoVazio - 1] = 0
            noEsquerda.append('esquerda')
            encontrado = validarFinal(noEsquerda)
        if quadradoVazio != 6 and quadradoVazio != 7 and quadradoVazio != 8 and not encontrado:
            noInferior = copy.deepcopy(noAtual)
            noInferior[quadradoVazio] = noInferior[quadradoVazio + 3]
            noInferior[quadradoVazio + 3] = 0
            noInferior.append('baixo')
            encontrado = validarFinal(noInferior)
        if quadradoVazio != 2 and quadradoVazio != 5 and quadradoVazio != 8 and not encontrado:
            noDireita = copy.deepcopy(noAtual)
            noDireita[quadradoVazio] = noDireita[quadradoVazio + 1]
            noDireita[quadradoVazio + 1] = 0
            noDireita.append('direita')
            encontrado = validarFinal(noDireita)

    t1 = time.time()
    print('-------------------------------------------')
    print('Tempo de Execução:', t1 - t0)
    print('-------------------------------------------')
