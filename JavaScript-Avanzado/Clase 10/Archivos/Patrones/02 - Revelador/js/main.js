console.log('Patrón Revelador');

const librería = (function(debug) {
    'use strict'

    // Propiedad privada
    var Pi = Math.PI

    // ***********************
    // * Calc Circ y Wrapper *
    // ***********************

    // Método privado
    function calcLongCirc(r) {
        return 2*Pi*r
    }

    // Método público
    function wrapperCalcLongCirc(r) {
        return calcLongCirc(r)
    }

    // ***********************
    // * Calc Rect y Wrapper *
    // ***********************

    // Método privado
    function calcPerimRect(b, h) {
        return 2*b + 2*h
    }

    // Método público
    function wrapperCalcPerimRect(b, h) {
        return calcPerimRect(b, h)
    }

    if(debug) console.log('IIFE ok')

    // ********************
    // * Métodos públicos *
    // ********************
    return {
        calcLongCirc : wrapperCalcLongCirc,
        calcPerimRect : wrapperCalcPerimRect
    }
})(true)

/*
    El Patrón Revelador sirve para ocultar y proteger el código que no se quiere que sea visible.
    Generalmente son métodos auxiliares.
    Se le puede pasar un parámetro a la IIFE, por ejemplo, true / false para realizar un debug.
*/