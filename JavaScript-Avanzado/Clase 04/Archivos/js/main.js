console.log('Ajax')
/*
// -----------------------------------------------------------
// Código sincrónico
console.log(1)
for(let i = 0; i < 1e9; i++){}
console.log(2)
for(let i = 0; i < 1e9; i++){}
console.log(3)
for(let i = 0; i < 1e9; i++){}
console.log(4)
for(let i = 0; i < 1e9; i++){}
*/
/*
// -------------------------------------------------------------
// Código asincrónico
console.log(1)
setTimeout(()=> {
    console.log(2)
    setTimeout(()=> {
        console.log(3)
        setTimeout(()=> {
            console.log(4)
        }, 1000)
    }, 1000)
}, 1000)
console.log('Otra tarea...')
*/

// **************************----------**************************
// AJAX (Asincronic Javascript and XML)
// **************************----------**************************

let xhr = new XMLHttpRequest
console.log(xhr.readyState)
xhr.addEventListener('readystatechange', () => {
    console.log(xhr.readyState)
    if(xhr.readyState == 2) {
        let header = xhr.getAllResponseHeaders()
        let tipo = xhr.getResponseHeader('content-type')
        /* console.log('--- HEADER ---')
        console.log(header)
        console.log('--- TIPO ---')
        console.log(tipo) */
        if(tipo != 'text/html'){
            //xhr.abort()
        }
    }
    else if(xhr.readyState == 4){
        /* if(xhr.status == 200){
            // console.log(xhr.status)
            console.log(xhr.response)
        } else {
        console.log('Error de comunicación. Status: ' + xhr.status)
        } */
    } 
})

xhr.addEventListener('load', () => {
    if(xhr.status == 200){
        console.log(xhr.response)
    } else {
        console.log(`Error de comunicación. Status: ${xhr.status}`)
    }
})

xhr.addEventListener('timeout', () => {
    console.log('Error timeout de comunicación.')
})

/* xhr.addEventListener('error', () => {
    console.log('Error AJAX!!')
}) */

xhr.open('GET', 'texto.txt')
//console.log(xhr.readyState)

xhr.timeout = 40

xhr.send()
/* 
setTimeout(() => {
    console.log(xhr.readyState)
    console.log(xhr.response)
},100) */




