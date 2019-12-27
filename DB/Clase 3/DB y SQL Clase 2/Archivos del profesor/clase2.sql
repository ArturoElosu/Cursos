select * from clientes;


select 
		nombre
        ,apellido
        ,2+2 as Calculo
        ,'Hola Mundo' as Saludo
from 
		clientes;
        
select precio from articulos order by precio;
select precio from articulos order by precio desc;


select 
		nombre
        ,apellido
from 
		clientes
order by nombre asc, apellido desc
limit 5;

describe clientes;

select  nombre, apellido
from clientes
order by id_cliente desc
limit 1;

select * from articulos
where 
		-- operadores de comparacion >;<;<=;<=;<>;=
        precio>20 and precio<50 
        and stock>=40 and stock<=50;
        
select * from articulos
where 
		-- between es equivalente a >=<=
        precio>20 and precio<50 
        and stock between 40 and 50; -- not between  
        
        
select nombre from articulos
where -- Operadores logicos
		precio=20 or precio=35;


select nombre from articulos
where nombre='Pala' or nombre='Maza' or nombre='Martillo';
      
select nombre from articulos
where nombre in('Pala', 'Maza', 'Martillo');  -- not in

-- --- like
select nombre from articulos
where nombre like '%a_a%';

-- obtener los clientes que su mail contenga el caracter '_'
select mail from clientes
where mail like '%\_%'; -- not like

-- Nulos
select mail from clientes where mail is null;
select mail from clientes where mail is not null;




		

