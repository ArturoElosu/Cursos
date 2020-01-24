console.log('Objetos JavaScript')


// ***************************************
// * Creación de Objeto en forma LITERAL *
// ***************************************

let a = {nombre: 'Juan'}
console.log(a.hasOwnProperty('nombre'))
console.log(a.hasOwnProperty('edad'))


// **************************************************
// * Creación de Obejto utilizando el Método CREATE *
// **************************************************

let prototipo1 = {
    saludo : function() {
        console.log('Hola')
    }
}

let prototipo2 = {
    saludo2 : function() {
        console.log('Hola2')
    }
}

let b = Object.create(prototipo1)
b.saludo()
let c = Object.create(prototipo2)
c.saludo2()

console.log(prototipo1.isPrototypeOf(b))
console.log(prototipo2.isPrototypeOf(b))
console.log(prototipo2.isPrototypeOf(c))


// **********************************************************
// * Configuración avanzada de las propiedades de un Objeto *
// **********************************************************

//let d = {x:1}

let prototipo3 = Object.create(null, {
    saludo3 : {
        value : function() {
        console.log('Hola3')
        },
        writable: !false,
        configurable: !false,
        enumerable: !false
    }
})

let d = Object.create(prototipo3, {
    x: {
        value: 1,
        writable: false, // d.x = 10
        configurable: !false, // delete d.x
        enumerable: !false // for(let key in d){console.log(key)}
    },
    y: {
        value: 22,
        writable: false,
        configurable: !false,
        enumerable: !false
    },
    saludo: {
        value: function() {console.log('Holaaa!!!')},
        writable: false,
        configurable: !false,
        enumerable: !false
    }
})

// ***********************************************
// * Funciones, Scope, Ámbito, Contexto, Closure *
// ***********************************************

// ***** FUNCIONES *****

function foo() {

}

console.dir(foo)
foo.x = true
console.log(foo.x)

function sumar(a, b) {
    return ((typeof a != 'undefined')?a:0) + ((typeof b != 'undefined')?b:0)
}

// ((typeof a != 'undefined')?a:0) es un operador ternario.

console.log(sumar(8, 9))
console.log(sumar(8))
console.log(sumar(5, 7, 10))

// ***** ÁMBITO & SCOPE *****

var q = 2
function foo2(r) {
    var w = 10
    console.log(q, w, r)
}

foo2(30)

/* 
La diferencia entre las variables q, w y r es que w y r viven dentro de la función. q no.
*/

// ***** CLOSURE *****

function externa(t) {
    // console.log(t)
    // return t
    return function interna(u) {
        console.log(u+t)
    }
}

var resultado = externa(50)

console.log(resultado)
resultado(10)

/*
El compilador se da cuenta que la variable t, una vez finalizada la function, va a desaparecer.
Por ello, la guarda de forma temporal en una zona llamada "Closure" para que pueda ser utilizada
por la function interna()
*/

// ***** CONTEXTO *****

function foo3() {
    console.log(this) // Acá el Objeto contenedor es GLOBAL
}
foo3()

var persona = {
    nombre: 'Juan',
    saludo : function() {
        console.log(this)
    }
}

persona.saludo()

function ctx(a, b) {
    console.log(this, a, b)
}

ctx(4, 5)
ctx.apply({x:1}, [4, 5])
ctx.call({x:1}, 4, 5)

/*
apply() y call() hacen lo mismo. La diferencia está en cómo se pasan los parámetros.
En apply() se pasan como un array. En call() de forma normal.
En ambos casos se cambió el contexto de la función.
*/

// *************************************************************
// * Creación de un Objeto utilizando una función constructora *
// *************************************************************


