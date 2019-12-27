var titulo = document.querySelector('h1')
//titulo.innerText = 'Título creado desde JavaScript'
titulo.innerHTML = 'Título creado desde <a href="#">JavaScript</a>'

console.log(titulo.innerText)
console.log(titulo.innerHTML)

titulo.classList.add('azul')
titulo.classList.remove('azul')

titulo.id = 'titulo'

var items = document.querySelectorAll('li')
console.log(items)

for(var i=0; i<items.length; i++) {
    items[i].innerHTML = 'Elemento Nro. <strong>' + (i+1) + '</strong>'
    items[i].style.color = 'red'
}


var parrafo = document.createElement('p')
parrafo.innerText = 'Soy un párrafo'
parrafo.style.color = 'green'
parrafo.id = 'parrafo'
parrafo.classList.add('txt')
document.body.appendChild(parrafo)


