select * from clientes;
describe clientes;
select * from localidades;

insert into clientes (id_localidad, nombre, apellido, telefono, mail, fechaNac) values (1, 'Pepe', 'Botella', '4206-4985', 'pepebotella@gmail.com', '1768-01-07');
insert into clientes (id_localidad, nombre, apellido, telefono, mail, fechaNac) values (2, 'Alfredo', 'Hërtzmann', '4335-3215', 'alfred@gmail.com', '1968-05-12');
insert into clientes (id_localidad, nombre, apellido, telefono, mail, fechaNac) values (3, 'Ludwin', 'Von Carstein', '4816-3598', 'ludwin@gmail.com', '1982-06-29');
insert into clientes (id_localidad, nombre, apellido, telefono, mail, fechaNac) values (4, 'Catalina', 'Ausf', '4658-1235', 'cata@gamil.com', '1958-11-16');
insert into clientes (id_localidad, nombre, apellido, telefono, mail, fechaNac) values (5, 'Summer', 'Williams', '4682-1358', 'summer@gmail.com', '1985-08-19');

select * from clientes;

ALTER TABLE clientes ADD cuit VARCHAR(20) NULL;

select * from clientes;

insert into clientes (nombre, apellido, cuit) values ('Yoquese', 'Awebo', '13-16581638-8');
insert into clientes (nombre, apellido, cuit) values ('Yosiqnose', 'Awebaso', '13-16581646-8');
insert into clientes (nombre, apellido, cuit) values ('NiIdea', 'Yoqc', '13-16581746-8');
insert into clientes (nombre, apellido, cuit) values ('Awebo', 'Awebonao', '13-16581613-8');
insert into clientes (nombre, apellido, cuit) values ('Awebonadisimo', 'Awebon', '13-16581468-8');

select * from clientes;

update 
	clientes
set
	nombre = 'Jose'
    where id_cliente = 1;
    
select * from clientes;

update 
	clientes
set
	nombre = 'Pablo', apellido = 'Fuentes', cuit = '20-21053119-0'
    where id_cliente = 3;
    
select * from clientes;

update
	clientes
set
	id_localidad = '''', nombre= '''', apellido = '''', telefono = '''', mail= '''', fechaNac= ''''
    where null;
    
select * from clientes;

SET SQL_SAFE_UPDATES = 0;

delete from 
	clientes
where 
	apellido = 'Perez';
    
SET SQL_SAFE_UPDATES = 1;
    
select * from clientes;

SET SQL_SAFE_UPDATES = 0;

delete from
	clientes
where
	cuit like '%0';
    
SET SQL_SAFE_UPDATES = 1;

select * from clientes;

select * from articulos;

SET SQL_SAFE_UPDATES = 0;

update
	articulos
set
	precio = (precio * 1.2)
	where precio <= 50;
    
SET SQL_SAFE_UPDATES = 1;
    
select * from articulos;

SET SQL_SAFE_UPDATES = 0;

update
	articulos
set
	precio = (precio * 1.15)
	where precio > 50;
    
SET SQL_SAFE_UPDATES = 1;

select * from articulos;

SET SQL_SAFE_UPDATES = 0;

update
	articulos
set
	precio = (precio * 0.95)
	where precio > 200;
    
SET SQL_SAFE_UPDATES = 1;

select * from articulos;

SET SQL_SAFE_UPDATES = 0;

delete from articulos
where stock < 0;
    
SET SQL_SAFE_UPDATES = 1;

select * from articulos;

