console.log('Patrón Módulo');

(function() {
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

    // ********************
    // * Métodos públicos *
    // ********************
    window.libreria = {
        calcLongCirc : wrapperCalcLongCirc,
        calcPerimRect : wrapperCalcPerimRect
    }

    console.log('IIFE ok')
})()

/*
    El Patrón Módulo sirve para ocultar y proteger tu código. 
*/