let btn = document.querySelector('button')
let elementoCreado = false
btn.addEventListener('click', () => {
    console.log('click')

    if(!elementoCreado){
        let xhr = new XMLHttpRequest
        xhr.open('GET', 'plantilla.html')
        xhr.addEventListener('load', () => {
            if(xhr.status == 200) {
                let plantilla = xhr.response
                //console.log(plantilla)
                /* let div = document.createElement('div')
                div.innerHTML = plantilla
                document.body.appendChild(div) */

                document.getElementById('contenido').innerHTML = plantilla

                elementoCreado = true
            }
        })
        xhr.send()
    }
})
