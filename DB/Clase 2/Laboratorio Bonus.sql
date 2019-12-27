drop database if exists laboratorio_bonus;

create database laboratorio_bonus;

use laboratorio_bonus;

drop table if exists articulos;

create table articulos
(
	codigo integer,
    nombre varchar(20),
    descripcion varchar(30),
    precio float,
    cantidad integer
);

describe articulos;

insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (1, 'Monitor'		, 'Samsung S19D300'			, 3500.00, 15)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (2, 'Mother'		, 'Asus 870DX'				, 2240.00, 10)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (3, 'Mouse'		, 'Escorpex 190'			, 565.00, 6)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (4, 'Parlante'		, 'AMDX 7500'				, 855.65, 3)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (5, 'Teclado'		, 'Galmax Ch 855'			, 356.20, 5)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (6, 'Cable USB'	, 'Generic'					, 20.00, 40)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (7, 'Fuente'		, 'AMD Fx 220'				, 1999.99, 2)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (8, 'Placa RAM'	, 'FFx 8GB DDR5'			, 4000.00, 10)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (9, 'Placa Video'	, 'NVIDIA GTX 1350 4GB'		, 16000.00, 4)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (10, 'Procesador'	, 'Snapdragon 8c 3200GHz'	, 10000.00, 8)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (11, 'Gabinete'	, 'Generic Gamer'			, 1200.00, 11)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (12, 'Cooler'		, 'Generic Gamer'			, 55.65, 50)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (13, 'Disco Duro'	, 'Sata 2Tb'				, 3500.00, 25)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (14, 'Lector DVD'	, 'AMX 955'					, 3000.00, 18)	;
insert into articulos (codigo, nombre, descripcion, precio, cantidad) values (15, 'Cables'		, 'Generic'					, 99.99, 150)	;

select * from articulos;

select * from articulos
where precio >= 500;

select * from articulos
where cantidad < 30;

select nombre, descripcion from articulos
where precio not like 100;

select * from articulos
where descripcion like '%Stylus%';

select * from articulos
where precio between 100 and 200;

select * from articulos
where precio * 1.21 < 100;

select * from articulos
where cantidad < 10 and precio * 1.21 > 200;

select * from articulos
where precio / 3 < 50;