console.log('Clase 02 JavaScript Avanzado')

var ul = document.createElement('ul')
/*for(var i = 0; i<10; i++){
    var li = document.createElement('li')
    li.innerHTML = 'Elemento Nro. ' + (i+1)
    ul.appendChild(li)
}*/
for(var i = 0; i<10; i++){
    ul.innerHTML += '<li>Elemento Nro. ' + (i+1) + '</li>' 
}
document.body.appendChild(ul)