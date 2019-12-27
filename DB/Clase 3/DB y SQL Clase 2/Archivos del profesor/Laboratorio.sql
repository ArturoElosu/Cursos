drop database if exists Laboratorios;

create database Laboratorios;

use Laboratorios;

-- Crear la tabla Facturas dentro de la base de datos con el siguiente detalle:
-- Letra char y PK
-- Numero integer y PK
-- Fecha date
-- Monto double
-- PK significa Primary Key
-- observar que se está declarando una clave primaria compuesta
-- es decir (letra, código)
-- cada campo por sí solo no es clave, ni tampoco identifica al registro
-- pero la suma de los dos forman la clave

drop table if exists facturas;
Create table facturas
(
	letra 	char,
	Numero	integer,
	Fecha	date,
	Monto 	double,
	Primary key(letra,numero)
);
describe facturas;

-- Crear la tabla Artículos dentro de la base de datos con el siguiente detalle:
-- Codigo integer y PK
-- Nombre varchar (50)
-- Precio double
-- Stock intege
drop table if exists articulos;
create table Articulos
(
	codigo int,
	nombre	varchar(50),
    precio	double,
    stock	int,
    Primary key(codigo)
);
describe Articulos;

show tables;    
-- 3- Cargar 5 registros en la tabla Facturas y Artículo    
insert into facturas (letra, Numero, Fecha, Monto) values ('A', 1, '2018-02-05', 200);
insert into facturas (letra, Numero, Fecha, Monto) values ('A', 2, '2018-02-05', 500);
insert into facturas (letra, Numero, Fecha, Monto) values ('A', 3, '2018-02-05', 1500);
insert into facturas (letra, Numero, Fecha, Monto) values ('B', 1, '2018-02-07', 900);
insert into facturas (letra, Numero, Fecha, Monto) values ('B', 2, '2018-02-07', 600);
insert into facturas (letra, Numero, Fecha, Monto) values ('B', 3, '2018-02-07', 900);
insert into facturas (letra, Numero, Fecha, Monto) values ('C', 1, '2018-02-07', 1900);
insert into facturas (letra, Numero, Fecha, Monto) values ('C', 2, '2018-02-07', 100);
insert into facturas (letra, Numero, Fecha, Monto) values ('C', 3, '2018-02-07', 10);

select * from facturas;  

insert into articulos (codigo, nombre, precio, stock) values (1, 'destornillador', 25.25, 50);
insert into articulos (codigo, nombre, precio, stock) values (2, 'pinza'		 , 35.00, 22);
insert into articulos (codigo, nombre, precio, stock) values (3, 'martillo'		 , 15.78, 28);
insert into articulos (codigo, nombre, precio, stock) values (4, 'maza'			 , 35.00, 18);
insert into articulos (codigo, nombre, precio, stock) values (5, 'balde'		 , 55.00, 13);
insert into articulos (codigo, nombre, precio, stock) values (6, 'plomada'		 , 35.00, 100);
insert into articulos (codigo, nombre, precio, stock) values (7, 'pala'			 , 11.00, 15);
  
select * from articulos;  



-- -----------------------------------------------------------------------------------------------

drop table if exists clientes;
create table Clientes
(
	id_cliente integer unsigned NOT NULL auto_increment,
    nombre varchar(40),
    apellido varchar(100),
    mail varchar(100),
    cuil varchar(100),
    comentarios varchar(100),
    direccion varchar(100),
    Primary Key (id_cliente)
);
describe Clientes;

insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Pedro'		, 'Urquiza'		, 'pepeu@gmail.com'			, '23256348597', 'Se atrasa con los pagos'	, 'Santa fe 5354');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Marcelo'	, 'Cespedes'	, 'marce795832@gmail.com'	, '23298645797', 'Se atrasa con los pagos'	, 'Cordoba 1245');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Alfredo'	, 'Gonzalez'	, 'a.gonzalez@gmail.com'	, '23135689787', 'Paga en tiempo y forma'	, 'Santa fe 3215');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Maria'		, 'Alberdi'		, 'marialberdi@gmail.com'	, '27253264895', 'Se atrasa con los pagos'	, 'Bulnes 1325');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Sofia'		, 'Skovia'		, 'sofi.skovia@gmail.com'	, '27451327685', 'Paga en tiempo y forma'	, 'Corrientes 5102');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Eugenia'	, 'Martinez'	, 'euge_mar@gmail.com'		, '27136549875', 'Paga en tiempo y forma'	, 'Entre Rios 205');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Gustavo'	, 'Passalaqua'	, 'gus_pas@gmail.com'		, '23265579587', 'Paga en tiempo y forma'	, 'Callao 1325');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Carlos'	, 'Marquez'		, 'charly158mz@gmail.com'	, '23386495327', 'Paga en tiempo y forma'	, 'Montevideo 15');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Juan'		, 'Perez'		, 'juan_p@gmail.com'		, '23413461287', 'Se atrasa con los pagos'	, 'Salta 156');
insert into clientes (nombre, apellido, mail, cuil, comentarios, direccion) values ('Patricia'	, 'Bustamante'	, 'pat.bus@gmail.com'		, '27361935845', 'Paga en tiempo y forma'	, 'Chile 369');

select * from clientes;

insert into facturas (letra, Numero, Fecha, Monto) values ('A', 4, '2018-02-05', 3500);

select * from facturas;

insert into articulos (codigo, nombre, precio, stock) values (8, 'amoladora', 3255.00	, 12);
insert into articulos (codigo, nombre, precio, stock) values (9, 'cal'		, 355.00	, 55);
insert into articulos (codigo, nombre, precio, stock) values (10, 'estanio'	, 95.00		, 39);

select * from articulos
where precio >100;

select * from articulos
where precio <20 and precio >40;

select * from articulos
where precio between 40 and 60;

select * from articulos
where precio = 20 and stock > 30;

select * from articulos
where precio = 12 or precio = 20 or precio = 30;

select * from articulos
where precio in(12, 20, 30);

select * from articulos
where precio not in (12, 20, 30);

select * from articulos
order by precio, nombre asc; -- desc

