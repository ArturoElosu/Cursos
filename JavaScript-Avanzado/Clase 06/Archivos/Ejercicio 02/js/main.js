console.log('JavaScript Avanzado - Clase 06 - Drag&Drop')


function cargarImagen(url){
    let progress = document.querySelector('progress')
    let span = document.querySelector('span')
    let img = document.querySelector('img')

    img.src = ''
    progress.value = 0
    span.innerHTML = ''

    let xhr = new XMLHttpRequest
    xhr.responseType = 'blob'

    let urlSinCache = url + '?' + Date.now()
    console.log(urlSinCache)
    
    xhr.open('get', urlSinCache)
    xhr.addEventListener('load', () => {
        if(xhr.status == 200) {
            let imagenBlob = xhr.response
            console.log(imagenBlob)
            let url = URL.createObjectURL(imagenBlob)
            console.log(url)

            img.src = url
        }
    })

    xhr.addEventListener('progress', e => {
        //console.log(e)
        if(e.lengthComputable) {
            let porcentaje = parseInt((e.loaded * 100) / e.total)
            console.log(porcentaje)
            progress.value = porcentaje
            span.innerHTML = porcentaje + '%'
        }
    })
    xhr.send()
}

let drop = document.getElementById('drop')

let body = document.querySelector('body')

body.addEventListener('dragenter', e => {
    e.preventDefault()
    //console.log('asfadsg')
})

body.addEventListener('dragleave', e => {
    e.preventDefault()
    //console.log('adsgfsadgs')
})

body.addEventListener('dragover', e => {
    e.preventDefault()
})

body.addEventListener('drop', e => {
    e.preventDefault()
})

drop.addEventListener('dragenter', e => {
    e.preventDefault()
    console.log('Estoy adentro del DROP')
})

drop.addEventListener('dragleave', e => {
    e.preventDefault()
    console.log('Estoy afuera del DROP')
})

drop.addEventListener('dragover', e => {
    e.preventDefault()
    console.log('Estoy encima del DROP')
})

drop.addEventListener('drop', e => {
    e.preventDefault()
    console.log('Solté el recurso dentro del DROP')
    //console.log(e.dataTransfer.files[0])
    let archivo = e.dataTransfer.files[0].name
    cargarImagen(archivo)
})

let input = document.querySelector('input')
input.addEventListener('change', () => {
    console.log(input.files[0].name)
    let archivo = input.files[0].name
    cargarImagen(archivo)
})

