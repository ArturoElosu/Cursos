console.log('JavaScript Avanzado - Clase 07')


// ************************
// PEDIDO AJAX CON PROMESAS
// ************************
function getComentarioPromesa(num) {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest
        xhr.open('get', 'https://jsonplaceholder.typicode.com/comments/' + num)
        xhr.addEventListener('load', () => {
            if(xhr.status == 200) {
                let respuesta = JSON.parse(xhr.response)
                console.log(respuesta)
                resolve(respuesta)
            } else {
                let error = {
                    type: 'Error status AJAX',
                    body: xhr.status
                }
                reject(error)
            }
        })
        xhr.addEventListener('error', e => {
            let error = {
                type: 'Error gral. AJAX',
                body: e
            }
            reject(error)
        })
        xhr.send()
    })
}

/* getComentarioPromesa(1).then(respuesta => getComentarioPromesa(2)) 
Ésto (arriba) es lo mismo que lo de abajo */

/* getComentarioPromesa(1)
.then(respuesta => getComentarioPromesa(2))
.then(respuesta => getComentarioPromesa(3))
.then(respuesta => getComentarioPromesa(4))
.catch(error => console.log('ERROR!!!', e)) */

async function getComentarios(){
    try{
        await getComentarioPromesa(1)
        await getComentarioPromesa(2)
        await getComentarioPromesa(3)
        await getComentarioPromesa(4)
    } catch(e) {
        console.log('ERROR!!!', e)
    }
}
//getComentarios()

// *****
// FETCH
// *****

function getComentarioFetch(num) {
    return fetch('https://jsonplaceholder.typicode.com/comments/' + num)
    .then(response => response.json())
    /* .then(json => {
        console.log(json)
        return Promise.resolve(json)
    }) */
}
getComentarioFetch(1)
.then(respuesta => {console.log(respuesta); return getComentarioFetch(2)})
.then(respuesta => {console.log(respuesta); return getComentarioFetch(3)})
.then(respuesta => {console.log(respuesta); return getComentarioFetch(4)})
.then(respuesta => console.log(respuesta))
.catch(error => console.log('ERROR!!!', e))


// ************************
// PEDIDO AJAX CON CALLBACK
// ************************
function getComentarioCallBack(num, cb) {
    let xhr = new XMLHttpRequest
    xhr.open('get', 'https://jsonplaceholder.typicode.com/comments/' + num)
    xhr.addEventListener('load', () => {
        if(xhr.status == 200) {
            let respuesta = JSON.parse(xhr.response)
            console.log(respuesta)
            if(cb) cb(respuesta)
        }
    })
    xhr.send()
}
/*
getComentarioCallBack(1, respuesta => {
    getComentarioCallBack(2, respuesta => {
        getComentarioCallBack(3, respuesta => {
            getComentarioCallBack(4, respuesta => {
                getComentarioCallBack(5, respuesta => {
                    getComentarioCallBack(6, respuesta => {
                        getComentarioCallBack(7, respuesta => {
                            getComentarioCallBack(8, respuesta => {
        
                            })
                        })
                    })
                })
            })
        })
    })
})  */

// *************
// PEDIDO 1 AJAX
// *************
function getComentario1() {
    let xhr = new XMLHttpRequest
    xhr.open('get', 'https://jsonplaceholder.typicode.com/comments/' + '1')
    xhr.addEventListener('load', () => {
        if(xhr.status == 200) {
            let respuesta = JSON.parse(xhr.response)
            console.log(respuesta)
            getComentario2()
        }
    })
    xhr.send()
}
// *************
// PEDIDO 2 AJAX
// *************
function getComentario2() {
    let xhr = new XMLHttpRequest
    xhr.open('get', 'https://jsonplaceholder.typicode.com/comments/' + '2')
    xhr.addEventListener('load', () => {
        if(xhr.status == 200) {
            let respuesta = JSON.parse(xhr.response)
            console.log(respuesta)
            getComentario3()
        }
    })
    xhr.send()
}

// *************
// PEDIDO 3 AJAX
// *************
function getComentario3() {
    let xhr = new XMLHttpRequest
    xhr.open('get', 'https://jsonplaceholder.typicode.com/comments/' + '3')
    xhr.addEventListener('load', () => {
        if(xhr.status == 200) {
            let respuesta = JSON.parse(xhr.response)
            console.log(respuesta)
        }
    })
    xhr.send()
}


//getComentario1()

