drop database if exists intro;
create database intro;
use intro;
drop table if exists autos;
create table autos
	(codigo	integer,
    marca	varchar(255),
    modelo	varchar(255),
    color	varchar(255),
    anio	integer,
    precio	double,
    PRIMARY KEY (codigo)
);
describe autos;
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 1, 'Volkswagen', 'Amarok', 'Plateado', 2017, 300000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 1, 'Volkswagen', 'Suran', 'Rojo', 2018, 288000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 2, 'Honda', 'Civic', 'Plateado', 2019, 750000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 3, 'Peugeot', '206', 'Blanco', 2008, 120000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 3, 'Peugeot', '207', 'Negro', 2009, 160000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 2, 'Honda', 'CR-V', 'Negro', 2018, 600000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 1, 'Volkswagen', 'Polo', 'Azul', 2011, 145000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 1, 'Volkswagen', 'Gol', 'Plateado', 2013, 172000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 4, 'Ford', 'Fiesta', 'Azul', 2017, 350000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 2, 'Honda', 'Fit', 'Blanco', 2014, 295000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 2, 'Honda', 'Accord', 'Negro', 2019, 810000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 4, 'Ford', 'Focus', 'Negro', 2003, 45000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 1, 'Volkswagen', 'Bora', 'Rojo', 2008, 150000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 3, 'Peugeot', '308', 'Marrón', 2018, 675000.00);
insert into autos (codigo, marca, modelo, color, anio, precio) values ( 2, 'Honda', 'WR-V', 'Gris', 2019, 980000.00);
select * from autos;