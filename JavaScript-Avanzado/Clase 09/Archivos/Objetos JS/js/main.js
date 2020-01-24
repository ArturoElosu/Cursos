console.log('Funciones y Objetos')

// ******************************************************
// * FUNCIONES: FORMAS DE EJECUCIÓN, CAMBIO DE CONTEXTO *
// ******************************************************

/* function ctx(a,b) {
    console.log(this,a,b)
}

console.dir(ctx)

ctx(6,7)
ctx.apply({x:1},[6,7])
ctx.call({x:1},6,7) */

// ***************************
// * FUNCIONES CONSTRUCTORAS *
// ***************************

/* 
// ***** No es la forma correcta de hacerlo!!! *****
// ** Ambos objetos apuntan a la misma referencia **

var persona = {
    nombre: null,
    edad: null
}

var juan = persona
var maria = persona */

/*
// ***** Forma correcta de hacerlo!!! *****
// ** Función constructora / Fábrica de objetos **

function persona(nombre, edad) {
    console.log('Creando objetos')
    var p = {
        nombre: nombre,
        edad: edad
    }
    return p
}

var juan = persona('Juan', 23)
var maria = persona('Maria', 22) */

function Persona(nombre, edad) {
    console.log(this)
    this.nombre = nombre
    this.edad = edad
}

Persona()

let juan = new Persona('Juan', 23)
let maria = new Persona('Maria', 22)

/*
1- NEW crea en algún lugar un objeto en forma literal
    a={}
2- NEW ejecuta la función constructora (pasado a su derecha) en el ámbito del objeto creado
    Persona.call(a, , )  <--- rellena los campos vacíos con los parámetros pasados
3- NEW retorna el objeto
    return a
*/

