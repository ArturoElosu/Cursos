/*console.log('primero')
console.log('segundo')

setTimeout(function(){
    console.log('primero')
},5000)
console.log('segundo')

function hacerTarea(tema, callback){
    alert(`Starting my ${tema} homework.`)
    callback()
}

hacerTarea('Matemática', function(){
    alert('Terminé mi tarea')
})*/

// Formas de agregar eventos al DOM
// 1)
/*btn = document.getElementById('soyBoton');
btn.addEventListener('click', function(){
    console.log('Me apretaron');
});
btn.removeEventListener('click', function(){
    console.log('Me apretaron');
})
*/

// 2)
/*
btn = document.getElementById('soyBoton');
btn.onclick = () => {
    console.log('Fui clickeado')
}
*/
// 3)
/* Agregar en el archivo .html el atributo 'onclick' + acción al elemento.
*/