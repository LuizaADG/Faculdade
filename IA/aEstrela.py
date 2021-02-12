import random

objetivo = [[1, 2, 3],
               [4, 5, 6],
               [7, 8, 0]]


#Funcao pra validar se o item existe no array
#se exisitr retorna o indice se nao retorna -1
def index(item, seq):
    if item in seq:
        return seq.index(item)
    else:
        return -1


class EightPuzzle:
    #Metodo padrao inicial
    # valorHeuristica da heurisitica
    # profundidade dos movimentos = quantidade
    # vizinhos nos vizinhos
    # matrizAdjacente

    def __init__(self):
        self.valorHeuristica = 0
        self.profundidade = 0
        self.vizinhos = None
        self.matrizAdjacente = []
        for i in range(3):
            self.matrizAdjacente.append(objetivo[i][:])

    def __str__(self):
        res = ''
        for linha in range(3):
            res += ' '.join(map(str, self.matrizAdjacente[linha]))
            res += '\r\n'
        return res

    def _clonarMatriz(self):
        p = EightPuzzle()
        for i in range(3):
            p.matrizAdjacente[i] = self.matrizAdjacente[i][:]
        return p

    #Metodo para obter os movimentos possiveis com o espaco em branco
    #Retorna uma lista de tuplas (linha, coluna)
    def obterMovimentosPossiveis(self):
        # obtem as coordenadas do espaco em branco
        linha, coluna = self.procurarNo(0)
        livre = []

        # # acha quais pecas podem se movimentar
        if linha > 0:
            livre.append((linha - 1, coluna))
        if coluna > 0:
            livre.append((linha, coluna - 1))
        if linha < 2:
            livre.append((linha + 1, coluna))
        if coluna < 2:
            livre.append((linha, coluna + 1))

        return livre

    def gerarMovimentos(self):
        free = self.obterMovimentosPossiveis()
        zero = self.procurarNo(0)

        def movimentar(a, b):
            p = self._clonarMatriz()
            p.swap(a, b)
            p.profundidade = self.profundidade + 1
            p.vizinhos = self
            return p

        return map(lambda pair: movimentar(zero, pair), free)

    def obterCaminhoDaSolucao(self, path):
        if self.vizinhos == None:
            return path
        else:
            path.append(self)
            return self.vizinhos.obterCaminhoDaSolucao(path)

    #Executa o A* e retora o numero de movimentacoes e o caminho
    def solve(self, h):

        def is_solved(puzzle):
            return puzzle.matrizAdjacente == objetivo

        openl = [self]
        closedl = []
        movimentos = 0
        while len(openl) > 0:
            x = openl.pop(0)
            movimentos += 1
            if (is_solved(x)):
                if len(closedl) > 0:
                    return x.obterCaminhoDaSolucao([]), movimentos
                else:
                    return [x]

            succ = x.gerarMovimentos()
            idx_open = idx_closed = -1
            for move in succ:
                # valida se o no já foi visitado
                idx_open = index(move, openl)
                idx_closed = index(move, closedl)
                hval = h(move)
                fval = hval + move.profundidade

                if idx_closed == -1 and idx_open == -1:
                    move.valorHeuristica = hval
                    openl.append(move)
                elif idx_open > -1:
                    copia = openl[idx_open]
                    if fval < copia.valorHeuristica + copia.profundidade:
                        # copiar os valores do movimento sobre os existentes
                        copia.valorHeuristica = hval
                        copia.vizinhos = move.vizinhos
                        copia.profundidade = move.profundidade
                elif idx_closed > -1:
                    copia = closedl[idx_closed]
                    if fval < copia.valorHeuristica + copia.profundidade:
                        move.valorHeuristica = hval
                        closedl.remove(copia)
                        openl.append(move)

            closedl.append(x)
            openl = sorted(openl, key=lambda p: p.valorHeuristica + p.profundidade)

        # if finished state not found, return failure
        return [], 0

    
    def shuffle(self, step_count):
        for i in range(step_count):
            linha, coluna = self.procurarNo(0)
            free = self.obterMovimentosPossiveis()
            target = random.choice(free)
            self.swap((linha, coluna), target)
            linha, coluna = target

#   retorna as coordenadas de um valor especifico
    def procurarNo(self, value):
        if value < 0 or value > 8:
            raise Exception("Valo não encontrado")

        for linha in range(3):
            for coluna in range(3):
                if self.matrizAdjacente[linha][coluna] == value:
                    return linha, coluna

    def obterValor(self, linha, coluna):
        """returns the value at the specified linha and colunaumn"""
        return self.matrizAdjacente[linha][coluna]

    def setarValor(self, linha, coluna, value):
        self.matrizAdjacente[linha][coluna] = value

    def swap(self, pos_a, pos_b):
        temp = self.obterValor(*pos_a)
        self.setarValor(pos_a[0], pos_a[1], self.obterValor(*pos_b))
        self.setarValor(pos_b[0], pos_b[1], temp)

#paramentros puzzle
#item_total_calc = linha atual, linha destino, coluna atual e coluna destino
# Retorna int.
#total_calc - recebe 1 parâmetro, a soma de item_total_calc sobre todas as entradas, e retorna int.
def heur(puzzle, item_total_calc, total_calc):
    t = 0
    for linha in range(3):
        for coluna in range(3):
            val = puzzle.obterValor(linha, coluna) - 1
            target_coluna = val % 3
            target_linha = val / 3

            # account for 0 as blank
            if target_linha < 0:
                target_linha = 2

            t += item_total_calc(linha, target_linha, coluna, target_coluna)

    return total_calc(t)

#metodo utilizado para inicializar o algoritmo
def h_manhattan(puzzle):
    return heur(puzzle,
                lambda r, tr, c, tc: abs(tr - r) + abs(tc - c),
                lambda t: t)


def h_default(puzzle):
    return 0


def main():
    p = EightPuzzle()
    p.shuffle(20)
    print(p)

    path, count = p.solve(h_manhattan)
    path.reverse()
    for i in path:
        print(i)

    print("Resolvido usando a distância de Manhattan", count, "movimentos")


if __name__ == "__main__":
    main()