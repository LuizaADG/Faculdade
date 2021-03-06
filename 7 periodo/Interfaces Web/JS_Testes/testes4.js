let a = "5";
let b =5;
let c= 2;

console.log(1,a>c);
console.log(2,b>c);
console.log(3,b>=c);
console.log(4,b<c);
console.log(5,b<=c);
console.log(6,b!=c);
console.log(7,a!=c);
console.log(8,a!=b);
console.log(9,a==b);
console.log(10,a===b);

console.log(11, 'Z'>'A');
console.log(11, 'Z'>'a');
console.log(13, 'Pato'>'Pata');
console.log(14, 'Dezena'>'Dez');

let x;
console.log(15, x==undefined);
console.log(16, x==null);
console.log(17, x===undefined);
console.log(18, x===null);

console.log(19, a==b && b>c);
console.log(20, a===b && b>c);
console.log(21, a==b && b<c);
console.log(22, a===b && b<c);

console.log(23, a==b || b>c);
console.log(24, a===b || b>c);
console.log(25, a==b || b<c);
console.log(26, a===b || b<c);

console.log(27, !(b>c));