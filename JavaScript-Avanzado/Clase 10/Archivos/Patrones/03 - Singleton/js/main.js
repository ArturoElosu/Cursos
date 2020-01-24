console.log('Patrón Singleton');

// **************************************
// * Patrón Singleton con patrón módulo *
// **************************************

(function() {
    'use strict'
    let instancia 

    function App() {
        if(instancia == undefined){
            this.id = Math.random()
            instancia = this
        } else {
            throw Error('No se permite más de una instancia de ésta función constructora')
            //return instancia
        }        
    }

    window.app = App

    console.log('IIFE ok')

})()
