console.log('Patrón PubSub');

// *****************
// * Objeto Mailer *
// *****************

/* var Mailer = function() {}
Mailer.prototype = {
    enviarMailDeCompra: function(mail) {
        console.log('Enviando email...')
        setTimeout(() => {
            console.log('Email enviado a ' + mail)
        }, 2000)
    }
}

// ****************
// * Objeto Orden *
// ****************

var Orden = function(mail) {
    this.mail = mail
}
Orden.prototype = {
    enviar: function() {
        console.log('Orden guardada')
        this.enviarMail(this.mail)
    },
    enviarMail: function(mail) {
        // ********************************************
        // * Fuerte acoplamiento entre MAILER y ORDEN *
        var mailer = new Mailer() // ******************
        mailer.enviarMailDeCompra(mail) // ************
        // ********************************************
    }
} */

// **********
// * Acción *
// **********

/* var orden = new Orden('juan@gmail.com')
orden.enviar() */

// ****************************************
// * Bus de Comunicación c/ Patrón PubSub *
// ****************************************

var BusComunicacion = {
    acciones: {},
    suscribir: function(servicio, cb) {
        if(!this.acciones[servicio]) this.acciones[servicio] = []
        this.acciones[servicio].push(cb)
    },
    publicar: function(servicio, datos) {
        if(!this.acciones[servicio] || this.acciones[servicio].length < 1) {
            console.log('ERROR: Servicio "' + servicio + '" no suscripto.')
            return
        }
        this.acciones[servicio].forEach(function(cb) {
            if(cb) cb(datos || {})
        })
    }
}

// ***********************************************
// * Prueba Bus de Comunicación c/ Patrón PubSub *
// ***********************************************

/* BusComunicacion.suscribir('Diario del Domingo', console.log)
BusComunicacion.suscribir('Diario del Domingo', alert)
console.log('Servicio de diario Suscripto')

setTimeout(() => {
    BusComunicacion.publicar('Diario del Domingo', 'Llegó el diario')
}, 2000) */

// *****-----*****-----*****-----*****-----*****-----*****-----*****-----*****
// -----*****-----*****-----*****-----*****-----*****-----*****-----*****-----
// *****-----*****-----*****-----*****-----*****-----*****-----*****-----*****
// -----*****-----*****-----*****-----*****-----*****-----*****-----*****-----
// *****-----*****-----*****-----*****-----*****-----*****-----*****-----*****

// *******************************************************
// * Utilización del Bus de Comunicación para desacoplar *
// * los objetos mailer y orden **************************
// *******************************************************

// *****************
// * Objeto Mailer *
// *****************

var Mailer = function() {
    BusComunicacion.suscribir('orden', this.enviarMailDeCompra)
    BusComunicacion.suscribir('orden', dato => setTimeout(() =>
            console.log(dato), 3000
        )
    )
    BusComunicacion.suscribir('orden', dato => setTimeout(() =>
            alert(dato), 5000
        )
    )
    BusComunicacion.suscribir('orden', dato => setTimeout(() =>
            document.write(dato), 7000
        )
    )
}
Mailer.prototype = {
    enviarMailDeCompra: function(mail) {
        console.log('Enviando email...')
        setTimeout(() => {
            console.log('Email enviado a ' + mail)
        }, 2000)
    }
}

// ****************
// * Objeto Orden *
// ****************

var Orden = function(mail) {
    this.mail = mail
}
Orden.prototype = {
    enviar: function() {
        console.log('Orden guardada')
        this.enviarMail(this.mail)
    },
    enviarMail: function(mail) {
        BusComunicacion.publicar('orden', mail)
    }
}

// **********
// * Acción *
// **********

var mailer = new Mailer()
console.log('Mailer suscripto')

var orden = new Orden('juan@gmail.com')
orden.enviar()

