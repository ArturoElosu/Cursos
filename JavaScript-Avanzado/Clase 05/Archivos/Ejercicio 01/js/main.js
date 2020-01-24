console.log('JPA JS Av')


function ajax(url, metodo) {
    let httpMetodo = metodo || 'get'
    let xhr = new XMLHttpRequest()
    xhr.open(httpMetodo, url)
    xhr.send()

    return xhr
}


let main = document.querySelector('main')
let links = document.querySelectorAll('a')

// ***************************************************************
// Navegación SIN HISTORY ****************************************
// ***************************************************************

/* links.forEach(link => {
    link.addEventListener('click', e => {
        e.preventDefault()

        let id = link.id
        location.hash = id
        //console.log(id)

        let archivo = id + '.html'
        //console.log(archivo)

        let xhr = ajax(archivo)
        xhr.addEventListener('load', () => {
            if(xhr.status == 200) {
                main.innerHTML = xhr.response
            }
        })
    })
}) */

// ***************************************************************
// Navegación con HASH *******************************************
// ***************************************************************

/* links.forEach(link => {
    link.addEventListener('click', e => {
        e.preventDefault()

        let id = link.id
        location.hash = id
    })
}) 

window.addEventListener('hashchange', () => {
    console.log('Cambió URL')

    let ruta = location.hash
    console.log(ruta)

    let archivo = ruta.split('#')[1] + '.html'
    //console.log(archivo)

    let xhr = ajax(archivo)
    xhr.addEventListener('load', () => {
        if(xhr.status == 200) {
            main.innerHTML = xhr.response
        }
    })
}) */

// ***************************************************************
// Navegación con PUSH STATE *************************************
// ***************************************************************

links.forEach(link => {
    link.addEventListener('click', e => {
        e.preventDefault()

        let id = link.id
        
        let archivo = id + '.html'
        //console.log(archivo)

        let xhr = ajax(archivo)
        xhr.addEventListener('load', () => {
            if(xhr.status == 200) {
                main.innerHTML = xhr.response
                history.pushState({
                    template: xhr.response
                }, '', id)
            }
        })
    })
})

window.addEventListener('popstate', e => {
    console.log('Click en navegación (explorador)')

    console.log(e.state)

    if(e.state.template){
        main.innerHTML = e.state.template
    } else {
        let ruta = location.pathname
        console.log(ruta)

        let archivo = ruta.split('/')[1] + '.html'
        //console.log(archivo)

        let xhr = ajax(archivo)
        xhr.addEventListener('load', () => {
            if(xhr.status == 200) {
                main.innerHTML = xhr.response
                history.pushState({
                    template: xhr.response
                }, '', id)
            }
        })
    }    
})




// -----------------------------------
// Página de INICIO.
// -----------------------------------

let xhr = ajax('home.html')
xhr.addEventListener('load', () => {
    if(xhr.status == 200) {
        main.innerHTML = xhr.response
    }
})