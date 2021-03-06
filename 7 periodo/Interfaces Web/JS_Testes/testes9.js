let frutas = ['laranja','maçã', 'banana'];
//console.log(frutas);
//console.log(frutas[0]);
//console.log(frutas[1]);
//console.log(frutas[2]);

let numeros = [1,5,3,8,0,6,9];
//console.log(numeros);

let misturado = ['José', 35, true];
//console.log(misturado);

//Inserções
frutas[2]='limão';
//console.log(frutas);
frutas[3]='pera'
//console.log(frutas);
//console.log(frutas.length);

frutas[6]='abacaxi';
//console.log(frutas);
//console.log(frutas.length);
//console.log(frutas[4]);

frutas = []; //alt new Array();
frutas[frutas.length]='melao';
frutas[frutas.length]='melancia';
frutas[frutas.length]='morango';
frutas[frutas.length]='uva';

//for(let i=0;i<frutas.length;i++) console.log(i,frutas[i]);

frutas.sort();
console.log(frutas);

frutas.push('banana');
console.log(frutas);

let f = frutas.pop();
console.log(f);
console.log(frutas);

frutas.unshift('banana');
console.log(frutas);

let g = frutas.shift();
console.log(g);
console.log(frutas);

frutas.forEach((f) => console.log(f));

let frutas2 = frutas.map(
    (f)=>f.toLocaleUpperCase()
);
console.log(frutas2);

let lista = [3, 2];
lista[4] = 5;
console.log( lista[3] );