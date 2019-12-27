select * from facturas
where letra = 'A' and numero = 1;

select nombre, apellido, id_localidad from clientes
where id_cliente = 1;

select nombre from articulos
where id_codigo = 1;

select localidad, id_provincia from localidades
where id_localidad = 1;

select provincia from provincias
where id_provincia = 1;

-- -------------------------------------------------------------------

-- Seleccionar muchas facturas en 1 solo llamado. --------------------

-- Forma VIEJA! ------------------------------------------------------

select
	f.letra
	,f.numero
    ,c.nombre
    ,c.apellido
    ,l.localidad
    ,p.provincia
    ,a.nombre
from
	facturas f
    ,clientes c
    ,localidades l
    ,provincias p
    ,articulos a
where
	f.id_cliente=c.id_cliente
    and c.id_localidad=l.id_localidad
    and l.id_provincia=p.id_provincia
    and f.id_codigo=a.id_codigo;

-- Forma NUEVA! ------------------------------------------------------

select
	f.letra
	,f.numero
    ,c.nombre
    ,c.apellido
    ,l.localidad
    ,p.provincia
    ,a.nombre
from
	facturas f
    
    inner join clientes c
    on f.id_cliente=c.id_cliente
    
	inner join localidades l
    on c.id_localidad=l.id_localidad
    
    inner join provincias p
    on l.id_provincia=p.id_provincia
    
    inner join articulos a
    on f.id_codigo=a.id_codigo;

-- -------------------------------------------------------------------

-- Obtener nombre y fecha nac del ciente -----------------------------
-- cuya factura es B 4 -----------------------------------------------

select
	c.nombre
    ,c.fechaNac
from
	clientes c
    
	inner join facturas f
    on c.id_cliente=f.id_cliente
where
	f.letra='B' and
    f.numero=4;

-- Pasos a seguir para realizar una consulta: ------------------------
-- Paso 1: Busco las tablas (from) -----------------------------------
-- Paso 2: Predicado (where) -----------------------------------------
-- Paso 3: Funciones de agregado o group by --------------------------
-- Paso 4: Predicado (having) ----------------------------------------
-- Paso 5: Select (lo que quiero buscar) -----------------------------
-- Paso 6: Order by --------------------------------------------------
-- Paso 7: Limit -----------------------------------------------------
-- -------------------------------------------------------------------

-- -------------------------------------------------------------------
-- Obtener la localidad de los clientes cuyo nombre ------------------
-- contenga una letra u ----------------------------------------------
-- -------------------------------------------------------------------

select
	l.localidad
from
	clientes c
    
    inner join localidades l
    on c.id_localidad=l.id_localidad
    
where c.nombre like '%u%';

-- -------------------------------------------------------------------

-- -------------------------------------------------------------------
-- Obtener el nombre de los artículos cuyo precio --------------------
-- de venta sea mayor e igual a 500 y menor o igual a 2000 -----------
-- -------------------------------------------------------------------

select
	a.nombre
from
	articulos a
	
    inner join facturas f
    on a.id_codigo=f.id_codigo
where
	f.monto between 500 and 2000;

-- -------------------------------------------------------------------

-- -------------------------------------------------------------------
-- Obtener fechaNac del cliente más joven que compró -----------------
-- -------------------------------------------------------------------

select
	max(fechaNac) as 'Mas Joven'
from
	clientes c
    
    inner join facturas f
    on c.id_cliente=f.id_cliente;

-- -------------------------------------------------------------------