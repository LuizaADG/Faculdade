var linhas;
var colunas;
var controle;//variavel de controle com o numero de linhas
function valorReal(i, j, array, preco) {
    return array[i][j] - preco[j];
}
//retornando agente alocado
function pessoaAlocada(objeto, alocacao) {
    for (let i = 0; i < controle; i++) {
        if (alocacao[i] == objeto) {
            return i;
        }
    }
    return -1;
}
//verificando atribuição ou não
function naoAtribuidas(alocacao) {
    for (let i = 0; i < controle; i++) {
        if (alocacao[i] == -1) {
            return true;
        }
    }
    return false;
}

//Identificando o primeiro e o segundo melhor objeto
function primeiroObjeto(pessoa, array, preco) {

    let melhor = 0;
    let valor_real = array[pessoa][melhor] - preco[melhor];
    for (let j = 1; j < controle; j++) {
        if (array[pessoa][j] - preco[j] > valor_real) {
            valor_real = valorReal(pessoa, j, array, preco);
            melhor = j;
        }
    }
    return melhor;
}
function segundoObjeto(pessoa, melhorObjeto, array, preco)
{
    let segundoMelhor = 0;
    while (segundoMelhor == melhorObjeto) {
        segundoMelhor++;
    }
    let valor_real = array[pessoa][segundoMelhor] - preco[segundoMelhor];
    for (let j = 1; j < controle; j++) {
        if (array[pessoa][j] - preco[j] > valor_real && j != melhorObjeto) {
            valor_real = valorReal(pessoa, j, array, preco);
            segundoMelhor = j;
        }
    }
    return segundoMelhor;
}
//metodo de criação da tabela para mostrar na tela e inserir valores
function criarTabela (){
    linhas = parseInt(document.getElementById("policiais").value) + 1;
    colunas = parseInt(document.getElementById("regioes").value) + 1;
        var tabela = document.getElementById("tabela");
        var linha = tabela.insertRow();
        var celula;
        let posicao = 1;
        celula = linha.insertCell(0);
        celula.innerHTML = "    ";
        for (let i = 1; i < colunas; i++){
            celula  = linha.insertCell(i);
            celula.innerHTML = "Tarefa " + i;
        } 
        linha = tabela.insertRow();
        for (let i = 1; i < linhas; i++){
            celula = linha.insertCell(0);
            celula.innerHTML = "Empregado " + i;
            for (let i = 1; i < colunas; i++){
                celula  = linha.insertCell(i);
                celula.innerHTML = '<input type="number" id="pos'+posicao+'">';
                posicao++;
            }
            linha = tabela.insertRow();
        }       
        document.getElementById("tabela").style.display = 'block';
        document.getElementById("maximizar").style.display = 'block';
}
async function main()
{
    controle = linhas-1;    
    var entrada = "";
    let constante = 0.1;
    // Criação da matriz  
    let array = new Array(controle);
     for(let i = 0; i < controle; i++){
        array[i] = new Array(controle);
    }
    //setando posições
    let posicao = 1;
    let id = "";
    id = "pos"+posicao;
    for(let i = 0; i < controle; i++){
        for(let j = 0; j < controle; j++){
            id = "pos"+posicao;
            array[i][j] = parseFloat(document.getElementById(id).value);
            posicao++;
        }
    }    
    // Preços inicializados com 0 
    let precos = new Array(controle);
    for(let i = 0; i < controle; i++){
        precos[i] = 0;
    }
    // Vetor alocacao
    let alocacao = new Array(controle);
    for(let i = 0; i < controle; i++){
        alocacao[i] = -1;
    }
    // Enquanto existirem pessoas não atribuidas
    while (naoAtribuidas(alocacao))
    {
        // Para cada pessoa nao atribuída, faça:
        for (let i = 0; i < controle; i++)
        {
            if (alocacao[i] == -1)
            {
                //pegar melhor e segundo melhor objetos
                let melhorObjeto = primeiroObjeto(i, array, precos);
                let segundo = segundoObjeto(i, melhorObjeto, array, precos); 
                //define o lance
                let incremento = valorReal(i, melhorObjeto, array, precos) - valorReal(i, segundo, array, precos) + constante;
                // Aumenta o valor do melhor objeto
                precos[melhorObjeto] = precos[melhorObjeto] + incremento;
                // Desfazendo a atribuição de quem estava no melhor objeto
                let perdedor = pessoaAlocada(melhorObjeto, alocacao);
                if (perdedor >= 0) {
                    alocacao[perdedor] = -1;
                }
                // Atribui a pessoa ao melhor objeto
                alocacao[i] = melhorObjeto;
            }
        }
    }
    //printando e calculando o lucro
    entrada = entrada + "Lucro Total:" + '<br>';
    let lucro = 0;
    for(let i = 0; i < controle; i++){
        let pos = parseInt(alocacao[i]);
        lucro = lucro + parseInt(array[i][pos]);
    }
    entrada = entrada + lucro + '<br>';

    document.getElementById("entrada").innerHTML = entrada;
    document.getElementById("botaoTabela").style.display = 'none'; 
    document.getElementById("maximizar").style.display = 'none';
}