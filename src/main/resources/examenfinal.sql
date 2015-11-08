
--
-- Base de datos: `examenfinal`
--
CREATE DATABASE IF NOT EXISTS `examenfinal` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `examenfinal`;
  
  /**************************** VENTAS *******************************/
  
  
DROP TABLE IF EXISTS DETALLE;
DROP TABLE IF EXISTS VENTA;
DROP TABLE IF EXISTS CLIENTE;
DROP TABLE IF EXISTS ARTICULO;


CREATE TABLE ARTICULO
(
	art_id               int(10) unsigned NOT NULL AUTO_INCREMENT,  
	art_codigo           CHAR(20) NOT NULL,
	art_nombre           VARCHAR(100) NOT NULL,
	art_precio           NUMERIC(10,2) NOT NULL,
	art_stock            INTEGER NOT NULL,
	PRIMARY KEY (art_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE CLIENTE
(
	cli_id               INTEGER AUTO_INCREMENT,
	cli_nombre           VARCHAR(100) NOT NULL,
	cli_tipo           VARCHAR(100) NULL,
	PRIMARY KEY (cli_id)
);



CREATE TABLE DETALLE
(
	det_id               INTEGER AUTO_INCREMENT,
	ven_id               INTEGER NOT NULL,
	art_id               int(10) unsigned NOT NULL,
	det_precio           NUMERIC(10,2) NOT NULL,
	det_cantidad         INTEGER NOT NULL,
	det_subtotal         NUMERIC(10,2) NOT NULL,
	PRIMARY KEY (det_id)
);


CREATE TABLE EMPLEADO
(
	emp_id               INTEGER AUTO_INCREMENT,
	emp_nombre           VARCHAR(100) NOT NULL,
	emp_usuario          VARCHAR(20) NOT NULL,
	emp_clave            VARCHAR(10) NOT NULL,
	PRIMARY KEY (emp_id)
);


CREATE TABLE VENTA
(
	ven_id               INTEGER AUTO_INCREMENT,
	cli_id               INTEGER NOT NULL,
	emp_id               INTEGER NOT NULL,
	ven_fecha            DATE NOT NULL,
	ven_subtotal         NUMERIC(10,2) NOT NULL,
	ven_impuesto         NUMERIC(10,2) NOT NULL,
	ven_total            NUMERIC(10,2) NOT NULL,
	PRIMARY KEY (ven_id)
);



ALTER TABLE DETALLE
ADD FOREIGN KEY FK_DETALLE_VENTA (ven_id) REFERENCES VENTA (ven_id);



ALTER TABLE DETALLE
ADD FOREIGN KEY FK_DETALLE_ARTICULO (art_id) REFERENCES ARTICULO (art_id);



ALTER TABLE VENTA
ADD FOREIGN KEY FK_VENTA_CLIENTE (cli_id) REFERENCES CLIENTE (cli_id);



ALTER TABLE VENTA
ADD FOREIGN KEY FK_VENTA_EMPLEADO (emp_id) REFERENCES EMPLEADO (emp_id);






INSERT INTO ARTICULO(art_codigo,art_nombre,art_precio,art_stock) VALUES
('ART_01','LAPTOP',2600.0,50),
('ART_02','LAVADORA',1567.0,80),
('ART_03','REFRIGERADORA',1437.0,85),
('ART_04','PC COMPATIBLE',1799.0,150),
('ART_05','IMPRESORA',480.0,250),
('ART_06','COCINA ELECTRICA',1499.0,75),
('ART_07','HORNO MICROHONDA',289.0,350);

INSERT INTO CLIENTE(cli_nombre,cli_tipo) VALUES
('Larriega Oscar','juridica'),
('Falla Alfonso','narural'),
('Escobedo Antony','juridica'),
('Huanay Omar','narural'),
('Luna David','juridica'),
('Coronel Gustavo','narural');

INSERT INTO EMPLEADO(emp_nombre,emp_usuario,emp_clave)
VALUES
('Raúl Romaní Flores','admin','admin'),
('adelayda herrera','user','user');
  
  
  
  
  
  
  
  
