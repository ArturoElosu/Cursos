/* 'use strict' */

console.log('Herencia JS')

// Cómo funciona el USE STRICT

/* var a = 6

let objDinamico = {x:1}
let objEstatico = Object.create(null, {
    x: {
        value: 1
    }
})

objDinamico.x = 11
objEstatico.x = 11 */

// ****************************************
// * PROTOTYPE en Funciones Constructoras *
// ****************************************

/* var a = {}

console.log(a)

function Persona(nombre) {
    this.nombre = nombre
}

console.dir(Persona)

//Persona.prototype.x = true
Persona.prototype.saludo = function() {
    console.log('Hola!')
}
Persona.prototype.caminar = function() {
    console.log('Caminando.....')
}

var juan = new Persona('Juan')
var ana = new Persona('Ana') */

// ************************************
// * Herencia y Composición de clases *
// ************************************

// ********************************************************
// * HERENCIA EN JS5 (Utilizando funciones constructoras) *
// ********************************************************

/* function Persona(nombre, edad) {
    this.nombre = nombre
    this.edad = edad
}

Persona.prototype.saludo = function() {
    console.log('Hola!')
}

let juan = new Persona('Juan', 23)

function Empleado(nombre, edad, sueldo) {
    Persona.call(this, nombre, edad)
    this.sueldo = sueldo
}

Empleado.prototype = Object.create(Persona.prototype)

Empleado.prototype.trabajar = function() {
    console.log('Trabajando...')
}

let empleado1 = new Empleado('Pedro', 23, 10000) */

// *******************************************
// * HERENCIA EN JS5 (Utilizando prototipos) *
// *******************************************

/* var persona = {
    saludo: function() {
        console.log('Hola!')
    }
}
var maria = Object.create(persona)
var pedro = Object.create(persona) */

/* var empleado = {
    trabajar: function() {
        console.log('Trabajando...')
    }
} */

/* var empleado = Object.create(persona, {
    trabajar: {
        value: function() {
            console.log('Trabajando...')
        },
        writable: true,
        enumerable: true,
        configurable: true
    }
})

var empleado1 = Object.create(empleado) */

// *******************
// * HERENCIA EN ES6 *
// *******************

/* class Persona {
    constructor(nombre, edad) {
        this.nombre = nombre
        this.edad = edad
    }
    saludo() {
        console.log('Hola!')
    }
}

var juan = new Persona('Juan', 23)

class Empleado extends Persona {
    constructor(nombre, edad, sueldo) {
        super(nombre, edad)
        this.sueldo = sueldo
    }
    trabajar() {
        console.log('Trabajando...')
    }
}

var empleado1 = new Empleado('Pedro', 26, 10000) */

// *******************************************
// * Definición de Clases con "class" en ES6 *
// *******************************************

/* class Persona {
    
}
console.dir(Persona) */

// *------------------------*------------------------*

/* function Persona(nombre, edad) {
    this.nombre = nombre
    this.edad = edad
}

// Método estático.
Persona.x = function() {
    console.log('x') 
}

Persona.prototype.saludo = function() {
    console.log('Hola!')
}

let juan = new Persona('Juan', 23) */

// *------------------------*------------------------*

/* class Persona {
    constructor(nombre, edad) {
        this.nombre = nombre
        this.edad = edad
    }
    static x() { // Se utiliza "static" para identificar el método estático.
        console.log('x')
    }
    saludo() {
        console.log('Hola!')
    }
}

var juan = new Persona('Juan', 23) */

// *************************************************************************
// * Funciones Autoinvocadas IIFE (Inmediatly Invoked Function Expression) *
// *************************************************************************

; // Antes de una IIFE SIEMPRE hay que poner ";" porque sino da ERROR
(function(numero) {
    console.log(numero)
    var codigo = 'qwerty123'
    console.log(codigo)
})(33)

//console.log(codigo)