let nome = "Bruno"
var idade = 20
var 🖥 = "Ciência da Computação"

idade += 1
//nome = "Marco"
print(🖥)

// Optionals e Unwrap
var pessoa: String? = nil

func comprimenta(_ nome: String = "Pessoa", comprimento frase: String) {
    print(frase + ", " + nome + "!")
}

comprimenta(comprimento: "Bom Dia") // Bom dia, Pessoa!

comprimenta(pessoa, comprimento: "Bom Dia") // Bom dia, Pessoa!
comprimenta(pessoa!, comprimento: "Bom Dia") // ERRO de execução

if let pessoa = pessoa {
    comprimenta(pessoa, comprimento: "Bom Dia") // Não é executado
}

comprimenta(pessoa ?? "Marco", comprimento: "Bom Dia") // Bom dia, Marco!

// Class, Enums e Struct
class Aula {

    enum Materia: String {
        case LP, PAA, FTC, SO, LPA, ESII
    }

    struct Avaliacao {
        var valor: Int
        var data: String?

        init(_ valor: Int, _ data: String? = nil) {
            self.valor = valor
            self.data = data
        }
    }

    let materia: Materia
    var avaliacoes: [Avaliacao] = []

    init(materia: Materia) {
        self.materia = materia
    }

    func novaAvaliacao(valor: Int, data: String? = nil) {
        avaliacoes.append(Avaliacao(valor, data))
    }

    func getAvaliacoes() -> [Avaliacao]? {
        if self.avaliacoes.isEmpty {
            return nil
        } else {
            return self.avaliacoes
        }
    }
}

var aulaLP = Aula(materia: .LP)
// aulaLP.novaAvaliacao(valor: 25)
// aulaLP.novaAvaliacao(valor: 30, data: "03/06")

if let avaliacoes = aulaLP.getAvaliacoes() {
    print(avaliacoes)
} else {
    print("não tem avaliacoes")
}

// Generics e Closure
func ordena<T>(_ arr: inout [T], by: (T, T) -> Bool) {
    for i in 0...arr.count-1 {
        for j in i...arr.count-1 {
            if by(arr[i], arr[j]) {
                let aux = arr[i]
                arr[i] = arr[j]
                arr[j] = aux
            }
        }
    }
}

var intArr: [Int] = [2, 1, 7, 84, 3, 12, 65]
var strArr: [String] = ["Luiz", "Bruno", "Pedro", "Luiza", "Gabriel"]

ordena(&intArr, by: {(s1, s2) in return s1 > s2})
ordena(&strArr, by: {$0 > $1})

print(intArr) // [1, 2, 3, 7, 12, 65, 84 ]
print(strArr) // ["Bruno", "Gabriel", "Luiz", "Luiza", "Pedro"]

// enum Aluno: String {
//     case Bruno, Luiz, Luiza, Pedro, Gabriel
// }

// func comprimenta(para nome: String = "Pessoa", comprimento: String) {
//     print(comprimento + ", " + nome + "!")
// }

// var pessoa: Aluno = .Bruno

// comprimenta(para: pessoa.rawValue, comprimento: "Bom Dia")
// comprimenta(comprimento: "Bom Dia")


// Exemplo if let

// enum Erro: Error {
//     case EROUU, ERRO
// }

// func disparaErro(_ erro: Erro, _ dispara: Bool) throws -> Int? {
//     if dispara {
//         throw erro
//     } else {
//         return 0
//     }
// }

// let int: Int?

// do {
//     try int = disparaErro(.EROUU, true)
// } catch let err {
//     print(err)
// }

// if let retorno = disparaErro(.EROUU, false) {
//     print(retorno)
// }






// func pow(_ base: Double, exp: Double = 2.0) -> Double {
//     if exp == 0 {
//         return 1
//     } else {
//         return base * pow(base, exp: exp-1);
//     } 
// }

// func maior<T>(_ lista: [T], f: (T, T) -> Bool) -> T {
//     var maior = lista[0];
//     for i in 1..<lista.count {
//         if f(maior,lista[i]) {
//             maior = lista[i]
//         }
//     }
 
//     return maior 
// }

// class Veiculo {
//     var nome: String
// }

// class Carro: Veiculo {

// }

// protocol Vegetal {
//     var especie: String { get }
//     var comeCarne: Bool { get }
// }

// protocol Carnivoro {
//     var kilogramasNescessariosPorDia: Double { get }
// }

// struct Ventricosa: Vegetal, Carnivoro {
//     let especie: String = "Nepenthes Ventricosa"
//     let comeCarne: Bool = true
    
//     let kilogramasNescessariosPorDia: Double = 0.02
// }

// struct OrquideaQualquer: Vegetal {
//     let especie: String = "Cattleya Labiata"
//     let comeCarne: Bool = false
// }

// extension Vegetal {
//     var comeCarne: Bool { return self is Carnivoro }
// }

// struct Ventricosa: Vegetal, Carnivoro {
//     let especie: String = "Nepenthes Ventricosa"
    
//     let kilogramasNescessariosPorDia: Double = 0.02
// }

// struct OrquideaQualquer: Vegetal {
//     let especie: String = "Cattleya Labiata"
// }

// enum SouthAmericanDrosera: String, Vegetal, Carnivora {
//     case tentaculata = "tentaculata"
//     case sessilifolia = "sessilifolia"
//     case roraimae = "roraimae"
//     case unknown
    
//     var species: String { 
//         return (self != .unknown) ? "Drosera \(self.rawValue)" : "Unknown"
//     }
    
//     var kilogramsRequiredPerDay: Double { return 0.03 }
// }

// print( SouthAmericanDrosera.roraimae.eatsMeat ? "Carnivora" : "Não Carnivora")
