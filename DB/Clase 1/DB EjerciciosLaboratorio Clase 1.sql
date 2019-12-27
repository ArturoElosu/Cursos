drop database if exists Laboratorio;
create database Laboratorio;

use Laboratorio;

drop table if exists Facturas;
create table Facturas
(
	Letra		char,
	Numero		integer unsigned,
	Fecha		date,
	Monto		double,
    PRIMARY KEY (letra, numero)
);

drop table if exists Articulos;
create table Articulos
(
	Codigo		integer,
    Nombre		varchar(50),
    Precio		double,
    Stock		integer unsigned,
    PRIMARY KEY (codigo)
);

insert into Facturas (letra, numero, fecha, monto) values ('A', 1, '2019-01-27', 1999.00);
insert into Facturas (letra, numero, fecha, monto) values ('A', 3, '2019-02-18', 3599.35);
insert into Facturas (letra, numero, fecha, monto) values ('A', 2, '2019-03-01', 785.83);
insert into Facturas (letra, numero, fecha, monto) values ('A', 5, '2019-04-12', 125.09);
insert into Facturas (letra, numero, fecha, monto) values ('A', 6, '2019-05-29', 15327.65);

select * from Facturas;

insert into Articulos (codigo, nombre, precio, stock) values (1549, 'Destornillador', 85.65, 25);
insert into Articulos (codigo, nombre, precio, stock) values (3256, 'Pinza de presion', 345.00, 13);
insert into Articulos (codigo, nombre, precio, stock) values (0165, 'Metro', 35.00, 43);
insert into Articulos (codigo, nombre, precio, stock) values (0125, 'Martillo', 145.00, 9);
insert into Articulos (codigo, nombre, precio, stock) values (0322, 'Clavo', 0.15, 865);

select * from Articulos;

drop table if exists Agenda;
create table Agenda
(
	Nombre		varchar(20),
	Domicilio	varchar(30),
	Telefono	integer
);

show tables;

describe Agenda;

insert into Agenda (nombre, domicilio, telefono) values ('Armando', 'Paredes', 48293018);
insert into Agenda (nombre, domicilio, telefono) values ('Esteban', 'Quito', 48046543);
insert into Agenda (nombre, domicilio, telefono) values ('Alberto', 'Menendez', 48134318);
insert into Agenda (nombre, domicilio, telefono) values ('Juan', 'Jimenez', 48353133);
insert into Agenda (nombre, domicilio, telefono) values ('Marie', 'Curie', 48391685);

select * from Agenda;

