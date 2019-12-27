console.log('Curso JavaScript Avanzado - Clase 01')

{
    let a1 = 6
    console.log(a1)
}
//console.log(a1)

if(true){
    let c1 = 7
    console.log(c1)
}
//console.log(c1)

function foo(){
    let f1 = 8
    console.log(f1)
}
foo()
//console.log(f1)

/*function dobleDe(a){
    return 2*a
}

const dobleDe = function(a){
    return 2*a
}
*/

// Arrow function o Lambda expressions
//const dobleDe = a => 2*a 

const dobleDe = (a) => {
    let res = 2*a
    return res
}

const getObj = () => ({x:1})

console.log('El resultado es', dobleDe(7))

console.log(getObj());


// Funciones autoinvocadas
/*(function (){
    console.log('Soy una función autoinvocada')
})()*/

var persona = (function () {
    this.edad = 32
    //var that = this // se pone el this en una variable para q funcione correctamente

    return {
        getEdad : () => this.edad // también se puede arreglar con una funcion arrow
        /* getEdad : function() {
            return that.edad
        } */
    }
})()

console.log(persona.getEdad())


var a = 1
var b = a
a = 10
console.log(a)
console.log(b)


var titulo = document.getElementById('titulo')
titulo.innerHTML = '<i>Otro titulo</i>'

var p = document.createElement('p')
p.innerText = 'Lorem ipsum...'
var body = document.getElementsByTagName('body')[0]
body.appendChild(p)

