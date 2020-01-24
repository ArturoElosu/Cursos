console.log('JavaScript Avanzado - Clase 06 - Ajax Binario')

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

            /* let img = document.createElement('img')
            img.src = url
            document.body.appendChild(img) */

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

let form = document.querySelector('form')
form.addEventListener('submit', e => {
    e.preventDefault()
    //console.dir(form[0])
    let archivo = form[0].files[0].name
    console.log(archivo)
    cargarImagen(archivo)
})
