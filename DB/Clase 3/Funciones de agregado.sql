select sum(monto) Total from facturas;
select count(*) Cantidad from facturas;
select max(monto) Maximo from facturas;
select min(monto) Minimo from facturas;
select avg(monto) Promedio from facturas;

select sum(monto) Total,
		count(*) Cantidad,
        max(monto) Maximo,
        min(monto) Minimo,
        avg(monto) Promedio
from facturas;

-- Agrupamiento

select letra, sum(monto) Total from facturas group by letra;
select letra, count(*) Cantidad from facturas group by letra;
select letra, max(monto) Maximo from facturas group by letra;
select letra, min(monto) Minimo from facturas group by letra;
select letra, avg(monto) Promedio from facturas group by letra;

select letra Letra, 
		sum(monto) Total,
		count(*) Cantidad,
        max(monto) Maximo,
        min(monto) Minimo,
        avg(monto) Promedio
from facturas  group by letra;

-- Predicado

select letra, sum(monto) Total from facturas group by letra having sum(monto) between 300 and 50000;
-- muestra sólo los sum que se encuentran en ese rango
select letra, count(*) Cantidad from facturas group by letra;
select letra, max(monto) Maximo from facturas group by letra;
select letra, min(monto) Minimo from facturas group by letra;
select letra, avg(monto) Promedio from facturas group by letra;

-- ---------------------------------------------------------------------------------

select
	count(1) as cantidad,
    month(fecha) as mes,
    year(fecha) as año
from
	facturas
group by year(fecha), month(fecha);