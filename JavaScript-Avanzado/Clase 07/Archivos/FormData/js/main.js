console.log('JavaScript Avanzado - Clase 07')

function mostrarValoresFormData(data) {
    let valores = data.values()
    let campos = data.keys()
    do{
        let valor = valores.next()
        let campo = campos.next()
        if(valor.done || campo.done) {
            break
        } else {
            console.log(campo.value, ':', valor.value)
        }
    } while(true)
}

/* *****************************************************************************
******************** FormData desde datos de un formulario *********************
***************************************************************************** */

let form = document.querySelector('form')
form.addEventListener('submit', e => {
    e.preventDefault()
    let data =  new FormData(form)
    mostrarValoresFormData(data)
})

/* ****************************************************************************
********************* FormData generado por input manual **********************
**************************************************************************** */

let btn = document.querySelectorAll('button')[1]
btn.addEventListener('click', () => {
    let data = new FormData()
    for(let i=0; i<10; i++) {
        data.append(`param-${i}`, i)
    }
    mostrarValoresFormData(data)
})

/* *****************************************************************************
*************** FormData utilizado para envío de datos vía AJAX ****************
***************************************************************************** */
let data = new FormData()
for(let i=0; i<10; i++) {
    data.append(`imagen-${i+1}`, `archivo${i+1}.jpg`)
}

let xhr = new XMLHttpRequest
xhr.open('post', 'url')
//xhr.setRequestHeader('content-type', 'application/json')
xhr.send(data)