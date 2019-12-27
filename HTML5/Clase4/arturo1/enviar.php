<?php 



$nombres=$_POST['nombres'];

$correo=$_POST['correo'];

$mensaje=$_POST['mensaje'];




// configuramos datos de email

$destinatario="arturo.elosu@gmail.com";

$asunto= "Consulta Web";



// cuerpo de email

$cuerpo.="Nombres: ".$nombres."\n";

$cuerpo.="E-mail: ".$correo."\n";

$cuerpo.="Consulta: ".$mensaje."\n";





// enviamos el email

mail($destinatario,$asunto,$cuerpo);



echo $nombre, "Gracias por contactarnos!!!";		



 ?>