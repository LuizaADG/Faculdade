let acessoPermitido =false;
let idade =21;
if(idade>=18)acessoPermitido = true;
else acessoPermitido=false;

console.log(acessoPermitido);

let n = 12;
let ehPar = n%2 ==0  ? true:false;
console.log(ehPar);

let dividendo =12;
let divisor =3;
let quociente = divisor !=0 ? dividendo/divisor: Infinity;
console.log(quociente);

let nota =55;
let frequencia =0.6;
let resultado;
if(nota>=60){
    if(frequencia>=0.75){
        resultado ='aprovado';
    }else resultado ="reprovado por frequencia";
}else{
    if(frequencia>=0.75){
        resultado ='reprovado por nota';
    }else resultado ="reprovado por nota e frequencia";
}
console.log(resultado);

let a=5, b=3, operador ='-', result;
switch(operador){
    case '+': result = a+b;
    break;
    case '-': result = a-b;
    break;
    case '*': result = a*b;
    break;
    case '/': result = a/b;
    break;
    default:
        console.log('operador invalido')
        result =null;
}
console.log(`resultado = ${result}`);