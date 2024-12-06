-- si ya tienen una base de datos pointodsale, recomiendo usar el drop
drop database pointofsale;
create database pointOfSale;
use pointOfSale;

-- Tabla de empleados
create table employees (
    EmployeeID varchar(10) primary key,
    pass char(64) not null,
    nam varchar(50) not null,
    surname varchar(50),
    rfc char(13) unique,
    address varchar(100),
    postalCode char(5),
    city varchar(50),
    phone1 char(12) not null,
    email varchar(50) not null
);

-- Tabla de clientes
create table customers (
    CustomerID char(10) primary key,
    nam varchar(50) not null,
    surname varchar(100) not null,
    address varchar(100),
    postalCode char(5),
    city varchar(50),
    phone char(12) not null,
    email varchar(50) not null
);

-- Tabla de ventas
CREATE TABLE orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    date DATETIME,
    EmployeeID CHAR(10),
    CONSTRAINT fk_EmployeeID FOREIGN KEY (EmployeeID)
    REFERENCES employees(EmployeeID),
    CustomerID CHAR(10),
    CONSTRAINT fk_CustomerID FOREIGN KEY (CustomerID)
    REFERENCES customers(CustomerID)
);

create table categories (
	categoryID int primary key auto_increment,
    categoriname varchar(50) not null,
    descript varchar(100)
);

-- Tabla de productos
CREATE TABLE products (
    ProductCode CHAR(12) PRIMARY KEY unique,
    categoryID int not null,
    nam VARCHAR(40) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    quantityAvailable INT NOT NULL,
    constraint fk_cateogoryID foreign key (categoryid)
    references categories(categoryid)
    on update cascade
);

-- Tabla intermedia para detallar productos en cada orden
CREATE TABLE order_details (
    OrderDetailID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    ProductCode CHAR(12),
    quantity TINYINT NOT NULL,
    price DECIMAL(6,2) NOT NULL, -- Precio del producto en el momento de la orden
    total DECIMAL(6,2) AS (price * quantity) STORED, -- Total calculado
    CONSTRAINT fk_OrderID FOREIGN KEY (OrderID)
    REFERENCES orders(OrderID)
    on delete cascade on update cascade, -- jovanny: i added this.
    CONSTRAINT fk_ProductCode FOREIGN KEY (ProductCode)
    REFERENCES products(ProductCode)
    on update cascade
);
insert into employees values
('s22120001',sha2('pass1',256),'Luis Manuel','Cardenas Ibarra','CAIL041104HMG','Maria Calderon #52','38880','Moroleon','445 139 6514','s22120001@alumnos.itsur.edu.mx'),
('s22120002',sha2('pass2',256),'Jovanny','Lobato Garcia','LOGJ0404HMBN5','Dalia #42','38980','Uriangato','445 455 5701','s22120002@alumnos.itsur.edu.mx'),
('s22120003',sha2('pass3',256),'Braulio Aaron','Solorio Morales','SOMB020816HPM','Av. Independencia #167','58500','Puruandiro','438 121 5420','s22120003@alumnos.itsur.edu.mx'),
('s22120004',sha2('pass4',256),'Yareli Yoselin','Gaona Ceja','GACY041002MUG','Magisterio #19','38983','Uriangato','445 143 3563','s22120004@alumnos.itsur.edu.mx'),
('lupita',sha2('1234',256),'Guadalupe Elizabeth','Camarena','CAGG060204HMN','Aldama #121','38980','Uriangato','4451591620','m22120024@alumnos.itsur.edu.mx');

insert into categories (categoriname, descript) values
('Bebidas','Liquidos refrescantes'),
('Comida','Alimentos saludables'),
('Frutas y verduras','Para crecer grandes y fuertes'),
('Cereales','Granos y legumbres'),
('Lacteos','Derivados de la leche'),
('Limpieza','Ideal para la limpieza del hogar'),
('Higiene personal','Una buena higiene es una buena salud');

   
INSERT INTO products (productcode, categoryID, nam, price, quantityAvailable)
VALUES
-- Productos de categoría 1
('934815812361', 1, 'Jugo de mango BOING 500ml', 10.50, 3100),
('934815812362', 1, 'Agua de Limon Del Valle 500ml', 15.30, 1800),
('934815812363', 1, 'Fuze tea 600ml', 20.00, 1500),
('934815812364', 1, 'Jumex Frutzzo 1L', 25.75, 2500),
('934815812365', 1, 'Ciel Exprim Limón y Menta 1L', 30.40, 1200),
('934815812366', 1, 'Frutsu 200ml', 13.00, 2200),
('934815812367', 1, 'Coca-Cola 355ml', 17.00, 2000),
-- Productos de categoría 2
('934815822361', 2, 'Arroz Basmati 1kg', 45.25, 3000),
('934815822362', 2, 'Pechuga de pollo 650g', 78.60, 2800),
('934815822363', 2, 'Jamón de pechuga de pavo 275g', 53.45, 3200),
('934815822374', 2, 'Aceite de oliva 1L', 62.00, 2500),
('934816822375', 2, 'Costillas de cerdo 500g', 67.50, 1900),
('934816822376', 2, 'Filetes de pescado 450g', 56.75, 1800),
('934816822377', 2, 'Avena 1kg', 50.75, 2000),
-- Productos de categoría 3
('934816832371', 3, 'Manzana 1k', 50.10, 1999),
('934816832372', 3, 'Mango 1k', 30.30, 2600),
('934816832373', 3, 'Pimientos Morrones 1k', 60.00, 2100),
('934816832374', 3, 'Aguacate 1k', 65.20, 2000),
('934816832375', 3, 'Cereza 1k', 70.40, 1800),
('934816832376', 3, 'Lechuga 1k', 45.00, 3200),
('934816832377', 3, 'Tomate 1k', 52.00, 3000),
-- Productos de categoría 4
('934816842371', 4, 'Lentejas 1k', 30.50, 2250),
('934816842382', 4, 'Frijol 1k', 32.30, 1800),
('934817842383', 4, 'Garbanzo seco 1k', 26.20, 2300),
('934817842384', 4, 'Quinoa 750g', 40.00, 2000),
('934817842385', 4, 'Trigo', 45.30, 1500),
('934817842386', 4, 'Sorgo 1k', 38.75, 1200),
-- Productos de categoría 5
('934817852381', 5, 'Leche 1L', 27.00, 2000),
('934817852382', 5, 'Queso crema 220g', 38.60, 1400),
('934817852383', 5, 'Yogur griego natural 400 g', 60.20, 1500),
('934817852384', 5, 'Queso cotija 250g', 55.50, 1800),
('934817852385', 5, 'Yogurt Danone 450ml', 33.30, 1000),
('934817852396', 5, 'Leche evaporada 360ml', 40.00, 2500),
-- Productos de categoría 6
('934818862391', 6, 'Detergente en polvo Ariel 500g', 32.75, 3100),
('934818862392', 6, 'Limpiador multiusos Fabuloso 500ml', 28.20, 2250),
('934818862393', 6, 'Jabón liquido para trastes Dawn 750ml', 40.10, 1900),
('934818862394', 6, 'Cloro Clorox 1L', 35.30, 2400),
('934818862395', 6, 'Desengrasante Mr. Musculo 500g', 43.50, 2900),
('934818862396', 6, 'Fregona', 37.50, 3200),
-- Productos de categoría 7
('934818872391', 7, 'Enjuague bucal Listerine 600ml', 61.00, 5000),
('934818872392', 7, 'Desodorante en aerosol Nivea 150ml', 45.20, 2600),
('934818872393', 7, 'Jabon de banio (barra) Dove', 29.30, 3600),
('934818872394', 7, 'Shampoo Sedal 225ml', 20.50, 2000),
('934818872405', 7, 'Espuma de afeitar Gillette 250ml', 70.75, 1789),
('934818872406', 7, 'Pasta de dientes Colgate', 52.75, 1800);


delimiter |
create procedure insert_random_customers(i int)
begin
	-- contador para la cantidad de operaciones que se van a realizar
	declare j int default 0;
    -- variables para los valores aleatorios que se insertarán
    declare randomName varchar(50);
    declare randomLastName1 varchar(50);
    declare randomLastName2 varchar(50);
    declare finalLastname varchar(50);
    declare randomAddress varchar(100);
    declare randomCity varchar(50);
    declare idcustomer int default 10;
    -- tablas temporales para guardar valores random
    create temporary table listNames(
    `names` varchar (50)
    );
    
    create temporary table listLastNames(
    lastNames varchar (100)
    );
    
    create temporary table listAddress(
    address varchar(100)
    );
    
    create temporary table listCitys(
    citys varchar(50)
    );
    -- insertar muchos datos en la tablas temporales
    insert into listNames values
    ('Juan'), ('Andres'), ('Maria'), ('Carla'),('José'), ('Alfredo'),('Milagros'),('Lupita'),
    ('Manuel Sebastian'),('Luis Martin'),('Maria Guadalupe'),('Leah Fernanda'),('Elliot Samuel'),('Clinton Alejandro'),('Valeria Sofia'),('Ana Isabella'),
    ('Mateo'), ('Daniel'), ('Camila'), ('Martina'),('Nicolas'), ('Lucas'),('Gabriela'),('Mariana'),
    ('Diego Santiago'), ('Javier Andrés'), ('Fernanda Emilia'), ('Paula Elena'),('Rodrigo Adrian'), ('Oscar Rafael'),('Claudia Lorena'),('Natalia Laura');
    
    insert into listLastNames values
    ('Cardenas'), ('Zavala'), ('Martinez'), ('Hernandez'),('Perez'), ('Sanchez'),('Lara'),('Torres'),
    ('Castillo'),('Cruz'),('Silva'),('Lopez'),('Amezcua'),('Gutierrez'), ('Guzman'),('Quintana'),('Rojas'),
    ('Garcia'), ('Rodriguez'), ('Escobar'),('Fernandez'),('Ramirez'), ('Flores'),('Diaz'),('Morales'),
    ('Salinas'),('Jimenez'),('Castro'),('Varas'),('Mendoza'),('Ortiz'), ('Navarro'),('Montes'),('Peredes');
    
   INSERT INTO listAddress (address) VALUES
	('Hidalgo'),('Av. Morelos'),('Matamoros'),('Emiliano Zapata'),('Pípila'),('Guadalupe Victoria'),('Juarez'),('Reforma'),
    ('Madero'),('Zaragoza'),('5 de Mayo'),('20 de Noviembre'), ('Independencia'), ('Morelos'),('Allende'),('Benito Juarez'),
    ('Carranza'), ('Guerrero'),('Iturbide'),('Libertad'),('Victoria'),('Revolucion'), ('Insurgentes'),('Francisco Villa'),
    ('Constitucion'),('Pino Suarez'),('Niños Heroes'),('Alvaro Obregon'), ('Lazaro Cardenas'),('Cortes'),('Colon'), ('Primavera'),
    ('Venustiano Carranza'),('Francisco I. Madero'), ('Progreso'),('Angel Flores'),('16 de Septiembre'),('Primero de Mayo'),
    ('Lerdo de Tejada'),('Miguel Aleman'), ('Constituyentes'),('Bosques'),('America'),('Manuel Avila Camacho'),('Pnacho Villa'),
    ('Jose Maria Morelos y Pavon'),	('Porfirio Diaz'),('Universidad'),('Arboledas'),('Ejercito Nacional'),('La Paz');
    
    INSERT INTO listCitys (citys) VALUES
	('Ciudad de Mexico'),('Toluca'),('Puebla'),('Cuernavaca'),('Querataro'),('San Luis Potosi'),('Leon'),('Guanajuato'), ('Morelia'),('Aguas Calientes'),('Zacatecas'),
    ('Monterrey'),('Saltillo'),('Torreon'),('Durango'),('Chihuahua'), ('Ciudad Juarez'),('Tijuana'),('Mexicali'),('Ensenada'),('Hemosillo'),('Nogales'),('Zapopan'),
    ('Puerto Vallarta'), ('Colima'),('Manzanillo'),('Cancun'),('Playa del Carmen'),('Tulum'),('Merida'),('Campeche'),('Chetumal'),('Oaxaca de Juarez'), ('Puerto Escondido'),
    ('Tuxtla Gutierrez'),('San Cristobal Colon'),('Veracruz'),('Xalapa'),('Coatzacoalcos'),('Nuevo Laredo'),('Reynosa'),('Matamoros'),('Tequila'),('Guadalajara'),('Patzcuaro'),
    ('Valle de Bravo'),('San Miguel de Allende'),('Taxco');
    
    -- ciclo que hará los insert
    while j<i do
		-- asignar 1 valor random de las tamblas temporales a cada varable
		select `names` into randomName from listNames
        order by rand() limit 1;
        
        select lastNames into randomLastName1 from listLastNames
        order by rand() limit 1;
        
        select lastNames into randomLastName2 from listLastNames
        order by rand() limit 1;
        
        select address into randomAddress from listAddress
        order by rand() limit 1;
        
        select citys into randomCity from listCitys
        order by rand() limit 1;
        
        -- insertar valores random 
        INSERT INTO customers (CustomerID, nam, surname, address, postalCode, city, phone, email)VALUES 
		(concat('CU2473',idcustomer),
        randomName, 
        concat(randomLastName1,' ',randomLastName2),
        concat(randomAddress,floor(1 + (rand()*300))), 
        floor(10000 + (rand()*90000)), 
        randomCity, 
        concat(floor(400 + (rand()*600)),' ',floor(100 + (rand()*800)),' ',floor(1000 + (rand()*8000))), 
        concat('cu2473',floor(1 + (rand()*30)),'@gmail.com'));
        set j=j+1;
        set idcustomer=idcustomer+1;
    end while;
    -- eliminar tablas temporales
    drop temporary table listNames;
    drop temporary table listLastNames;
    drop temporary table listAddress;
    drop temporary table listCitys;
end|

create procedure insert_random_orders(num int)
begin
	-- contador de la cantidad de operaciones que se van a realizar
	declare i int default 0;
    
    while i<num DO
		-- insertar ordenes con datos aleatorios
		insert into orders (date,employeeid,customerid)values(
		concat('2024-',floor(1 + (rand()*12)),'-',floor(1 + (rand()*28))),
		concat('s2212000',floor(1 + (rand()*4))),
		concat('CU2473',floor(10 + (rand()*50))));
        set i=i+1;
    end while;
end|

create procedure insert_random_orderDetails(i int)
begin
	-- contador de la cantidad de operaciones que se van a realizar
	declare j int default 0;
    -- varibles para valores random
	declare idOrder int;
	declare codeProduct char(12);
    declare precio decimal(6,2);
    
    while j<i do
    -- seleccionar valores random de las tablas ya creadas
    select orderid into idOrder from orders
    order by rand() limit 1;
    
    select productcode into codeProduct from products
    order by rand() limit 1;
    
    select price into precio from products where codeProduct=productCode;
    -- insertar valores random
    insert into order_details(orderId,productCode, quantity, price) values
		(idOrder,codeProduct,floor(1 + (rand()*30)),precio);
	set j=j+1;
    end while;
end|

create procedure insertOrderDetails(p_orderID int, p_productcode char(12), p_quantity tinyint, p_price decimal(6,2))
begin
	declare available_quantity int;
    
    select quantityAvailable into available_quantity from products where productcode=p_productcode;
    
    insert into order_details (OrderID, ProductCode, quantity, price) 
    values (p_orderID, p_productcode, p_quantity, p_price);

	update products set quantityAvailable=quantityAvailable-p_quantity
    where productcode=p_productcode;
end|

delimiter $$
-- Procedimiento para insertar clientes
CREATE PROCEDURE InsertCustomer(
    IN p_CustomerID CHAR(10),
    IN p_nam VARCHAR(50),
    IN p_surname VARCHAR(100),
    IN p_address VARCHAR(100),
    IN p_postalCode CHAR(5),
    IN p_city VARCHAR(50),
    IN p_phone CHAR(12),
    IN p_email VARCHAR(50)
)
BEGIN
    INSERT INTO customers (CustomerID, nam, surname, address, postalCode, city, phone, email)
    VALUES (p_CustomerID, p_nam, p_surname, p_address, p_postalCode, p_city, p_phone, p_email);
END$$

-- Procedimiento para actualizar clientes
CREATE PROCEDURE UpdateCustomer(
    IN p_CustomerID CHAR(10),
    IN p_nam VARCHAR(50),
    IN p_surname VARCHAR(100),
    IN p_address VARCHAR(100),
    IN p_postalCode CHAR(5),
    IN p_city VARCHAR(50),
    IN p_phone CHAR(12),
    IN p_email VARCHAR(50)
)
BEGIN
    UPDATE customers
    SET nam = p_nam, surname = p_surname, address = p_address, 
        postalCode = p_postalCode, city = p_city, phone = p_phone, email = p_email
    WHERE CustomerID = p_CustomerID;
END$$

-- Procedimiento para eliminar clientes
CREATE PROCEDURE DeleteCustomer(IN p_CustomerID CHAR(10))
BEGIN
    DELETE FROM customers WHERE CustomerID = p_CustomerID;
END$$

DELIMITER ;
-- llamar los procedure's para ingresar valores
call insert_random_customers(50);
call insert_random_orders(300);
call insert_random_orderDetails(5000);

-- vistas de reporte de ventas por mes
delimiter |
create procedure salesReport_month(in anio char(4), in mes char(2))
begin
	select od.orderid as `num.Orden`, o.date as Fecha, c.nam as Cliente, e.nam as Empleado, sum(od.total) as Total,
    count(od.orderid) as `cant.Detalles` from
	order_details od join orders o on o.orderid=od.orderid join customers c on c.customerid=o.customerid
	join employees e on e.employeeid = o.employeeid where year(o.date)=anio and month(o.date)=mes
	group by o.OrderID, DATE(o.date), e.nam, e.surname, c.nam, c.surname order by od.orderid asc, o.date asc; 
end|

create procedure saleReport_byEmployee(anio char(4), mes char(2))
begin
	SELECT CONCAT(e.nam, ' ', e.surname) AS `Empleado`, SUM(od.total) AS `Total`, COUNT(DISTINCT o.orderid) AS `Cant. Ventas` FROM orders o
	JOIN order_details od ON o.orderid = od.orderid JOIN employees e ON e.employeeid = o.employeeid
	where year(o.date)=anio and month(o.date)=mes
	GROUP BY  o.employeeid, CONCAT(e.nam, ' ', e.surname) ORDER BY  `Total` DESC;
end|

DELIMITER ;
-- espacio de trabajo de jovanny el más capito
create view reporte_ventas_trimestrales as
select 
    p.nam as producto,
    -- solo secciona entre trimestres
    sum(case when month(o.date) between 1 and 3 then od.quantity else 0 end) as 'trim 1',
    sum(case when month(o.date) between 4 and 6 then od.quantity else 0 end) as 'trim 2',
    sum(case when month(o.date) between 7 and 9 then od.quantity else 0 end) as 'trim 3',
    sum(case when month(o.date) between 10 and 12 then od.quantity else 0 end) as 'trim 4'
from orders o 
join order_details od on o.orderid = od.orderid
join products p on od.productcode = p.productcode
where year(o.date) = 2024
group by p.nam 
order by p.nam;
-- drop view reporte_ventas_trimestrales;
-- SELECT * FROM reporte_ventas_trimestrales;
-- describe reporte_ventas_trimestrales;

-- 7.- TRIGGERS DE AUDITORIA
create table audit_orders (
    auditid int auto_increment primary key,
    orderid int,
    accion varchar(10),
    usuario varchar(100),
    fecha datetime default current_timestamp,
    detalles text
);
Delimiter $$
-- TRIGGER DE INSERT
create trigger trigger_audit_orders_insert
after insert on orders
for each row
begin
    insert into audit_orders (orderid, accion, usuario, detalles)
    values (
        new.orderid,
        'insert',
        user(),
        concat('Nuevo pedido: fecha=', new.date, ', empleado=', new.employeeid, ', cliente=', new.customerid)
    );
end;
-- TRIGGER DE UPDATE
DELIMITER $$
create trigger trigger_audit_orders_update
after update on orders
for each row
begin
    insert into audit_orders (orderid, accion, usuario, detalles)
    VALUES (
        new.orderid,
        'update',
        user(),
        concat(
            'Cambio en pedidoid=', old.orderid,
            '. antes: fecha=', old.date, ', empleado=', old.employeeid, ', cliente=', old.customerid,
            '. después: fecha=', new.date, ', empleado=', new.employeeid, ', cliente=', new.customerid
        )
    );
end;
-- TRIGGER DE DELETE
DELIMITER $$
create trigger trigger_audit_orders_delete
after delete on orders
for each row
BEGIN
    INSERT INTO audit_orders (orderid, accion, usuario, detalles)
    Values (
        old.orderid,
        'delete',
        USER(),
        concat('pedido eliminado: fecha=', OLD.DATE, ', empleado=', OLD.employeeid, ', cliente=', OLD.customerid)
    );
END;
DELIMITER ;
-- SELECT * FROM audit_orders;
-- delete from orders where OrderID = 292;
-- SELECT * FROM orders;

-- 9.- FUNCION QUE CALCULA LA CANTIDAD DE PRODUCTOS QUE TIENE UNA VENTA.
Delimiter $$
create function calcular_cantidad_productos(venta_id int) 
returns int
deterministic
begin
    declare cantidad_total int;
	-- se cuantan cuantos productos hay en la venta con el id
    select sum(quantity) 
    into cantidad_total
    from order_details
    where orderid = venta_id;
    -- si no hay productos, devolver 0
    if cantidad_total is null then
        set cantidad_total = 0;
    end if;
    return cantidad_total;
end $$ 
DELIMITER ;
-- aqui me fijo cuantos productos tiene la venta con id=1
-- select * from order_details where orderID=1;
-- select * from products where ProductCode=934817842383;
-- describe order_details;
-- SELECT calcular_cantidad_productos(1);
 -- FIN DEL ESPACIO DE TRABAJO DE JOVANNY, GRACIAS POR SU ATENCION.
 
 --  Trigger de validacion (punto8)
 DELIMITER |
CREATE TRIGGER validar_producto
BEFORE update ON products
FOR EACH ROW
BEGIN
    -- Validar que el precio no sea negativo
    IF NEW.price < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El precio no puede ser negativo.';
    END IF;

    -- Validar que el nombre no sea vacío o contenga solo espacios
    IF TRIM(NEW.nam) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No pueden quedar espacios en blanco.';
    END IF;

    -- Validar que el código de barras,
    IF NEW.ProductCode IS NOT NULL THEN
        IF LENGTH(NEW.ProductCode) <12 or length(NEW.ProductCode) >12 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'El código de barras no es valido';
        END IF;
    END IF;
END|

delimiter ;