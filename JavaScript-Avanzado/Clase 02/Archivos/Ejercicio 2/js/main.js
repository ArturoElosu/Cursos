console.log('Clase 2 JSAv')

var uno = () => {
    console.log('Soy la función uno')
}

var dos = () => {
    console.log('Soy la función dos')
}

uno()
dos()

function prueba(item, callback){ // Se puede abreviar CALLBACK como CB.
    console.log(item)
    if(callback) callback() // No necesito las {} si es 1 línea.
    else console.log('Callback no definido!!')
}

prueba(1, uno)
prueba(2, dos)

/*prueba(3, function(){
    console.log('Soy una función antigua!!')
})*/

prueba(3, () => { // Se puede escribir como arrow!!
    console.log('Soy una función antigua!!')
})

var btn = document.getElementById('btn')

/* btn.onclick = () => console.log('Me apretaron!') */
/* btn.onclick = () => {
    uno()
    dos()
} */
/* btn.addEventListener('click', uno)
btn.addEventListener('click', dos)
 */

btn.addEventListener('click', e => { // e es un objeto que permite obtener información de eventos sucedidos en pantalla
    console.log(e)
})


var divUno = document.getElementById('uno')
var divDos = document.getElementById('dos')
var divTres = document.getElementById('tres')

divTres.addEventListener('click', function(){
    console.log('click 3')
}, false) // false = Bubbling / true = Capturing

divDos.addEventListener('click', function(){
    console.log('click 2')
}, false)

divUno.addEventListener('click', function(){
    console.log('click 1')
}, false)

var botonCreado = false
var estatico = document.getElementById('estatico')
estatico.addEventListener('click', function(){
    console.log('Sot btn estatico')
    if(!botonCreado){
        botonCreado = true
        var dinamico = document.createElement('button')
        dinamico.innerText = ('DINAMICO')
        dinamico.id = 'dinamico'
        document.body.appendChild(dinamico)
    }
})


document.addEventListener('click', function(e){
    //console.log('Click sobre el documento web')
    //console.log(e.target.id)
    if(e.target.id == 'dinamico'){
        console.log('Soy btn dinamico')
    }
})

document.getElementById('link').addEventListener('click', function(e){
    e.preventDefault()
    console.log('Click en link')
    // location.href = 'https://www.facebook.com'
})

window.addEventListener('resize', () => {
    console.log('Resize en navegador')
    document.getElementById('parrafo').innerHTML = 'El tamaño del navegador es de: ' + window.innerHeight + 'px de altura y ' + window.innerWidth + 'px de ancho.'
})

var ev = new Event('look', {'bubbles': true, 'cancelable': true})
document.addEventListener('look', () => {
    console.log('Look!!')
})

document.getElementById('evLook').addEventListener('click', () => {
    document.dispatchEvent(ev)
})