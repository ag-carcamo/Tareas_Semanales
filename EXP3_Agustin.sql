CREATE TABLE PAIS (
    id_pais NUMBER PRIMARY KEY,
    nom_pais VARCHAR2(30)
);

CREATE TABLE CIUDAD (
    id_ciudad NUMBER(3) PRIMARY KEY,
    nom_ciudad VARCHAR2(30),
    cod_pais NUMBER,
    CONSTRAINT fk_ciudad_pais
        FOREIGN KEY (cod_pais) REFERENCES PAIS(id_pais)
);

CREATE TABLE SUCURSAL (
    id_sucursal CHAR(3) PRIMARY KEY,
    nom_sucursal VARCHAR2(30),
    calle VARCHAR2(30),
    num_calle NUMBER(4),
    cod_ciudad NUMBER(3),
    CONSTRAINT fk_sucursal_ciudad
        FOREIGN KEY (cod_ciudad) REFERENCES CIUDAD(id_ciudad)
);

CREATE TABLE MARCA (
    id_marca NUMBER(2) PRIMARY KEY,
    descripcion VARCHAR2(20)
);

CREATE TABLE MODELO (
    id_modelo NUMBER(5),
    marca_id NUMBER(2),
    descripcion VARCHAR2(30),
    CONSTRAINT pk_modelo PRIMARY KEY (id_modelo, marca_id),
    CONSTRAINT fk_modelo_marca
        FOREIGN KEY (marca_id) REFERENCES MARCA(id_marca)
);

CREATE TABLE TIPO_AUTOMOVIL (
    id_tipo CHAR(3) PRIMARY KEY,
    descripcion VARCHAR2(20)
);

CREATE TABLE CLIENTE (
    rut NUMBER(8) PRIMARY KEY,
    dv CHAR(1),
    pnombre VARCHAR2(20),
    snombre VARCHAR2(20),
    apaterno VARCHAR2(20),
    amaterno VARCHAR2(20),
    telefono VARCHAR2(12),
    email VARCHAR2(40),
    tipo_cli CHAR(1)
);

CREATE TABLE MECANICO (
    cod_mecanico NUMBER PRIMARY KEY,
    pnombre VARCHAR2(20),
    snombre VARCHAR2(20),
    apaterno VARCHAR2(20),
    amaterno VARCHAR2(20),
    bono_jefatura NUMBER(10),
    sueldo NUMBER(10),
    monto_impuestos NUMBER(10),
    cod_supervisor NUMBER(5)
);

CREATE TABLE SERVICIO (
    id_servicio NUMBER(3) PRIMARY KEY,
    descripcion VARCHAR2(100),
    costo NUMBER(7)
);

CREATE TABLE AUTOMOVIL (
    patente CHAR(8) PRIMARY KEY,
    anio NUMBER(4),
    cant_puertas NUMBER(1),
    km NUMBER(6),
    color VARCHAR2(30),
    cod_tipo CHAR(3),
    cod_modelo NUMBER(5),
    cod_marca NUMBER(2),
    cli_rut NUMBER(8),
    CONSTRAINT fk_auto_cliente FOREIGN KEY (cli_rut)
        REFERENCES CLIENTE(rut),
    CONSTRAINT fk_auto_modelo FOREIGN KEY (cod_modelo, cod_marca)
        REFERENCES MODELO(id_modelo, marca_id),
    CONSTRAINT fk_auto_tipo FOREIGN KEY (cod_tipo)
        REFERENCES TIPO_AUTOMOVIL(id_tipo)
);

CREATE TABLE MANTENCION (
    num_mantencion NUMBER(4),
    cod_sucursal CHAR(3),
    fecha_ingreso DATE,
    fecha_salida DATE,
    patente_auto CHAR(8),
    cod_mecanico NUMBER,
    estado VARCHAR2(15),
    CONSTRAINT pk_mantencion PRIMARY KEY (num_mantencion, cod_sucursal),
    CONSTRAINT fk_mant_auto FOREIGN KEY (patente_auto)
        REFERENCES AUTOMOVIL(patente),
    CONSTRAINT fk_mant_mecanico FOREIGN KEY (cod_mecanico)
        REFERENCES MECANICO(cod_mecanico),
    CONSTRAINT fk_mant_sucursal FOREIGN KEY (cod_sucursal)
        REFERENCES SUCURSAL(id_sucursal)
);

CREATE TABLE DETALLE_SERVICIO (
    mantencion_num NUMBER(4),
    cod_sucursal CHAR(3),
    cod_servicio NUMBER(3),
    descuento_serv NUMBER(4,3),
    cantidad NUMBER(3),
    CONSTRAINT pk_detalle PRIMARY KEY (mantencion_num, cod_sucursal, cod_servicio),
    CONSTRAINT fk_det_mant FOREIGN KEY (mantencion_num, cod_sucursal)
        REFERENCES MANTENCION(num_mantencion, cod_sucursal),
    CONSTRAINT fk_det_serv FOREIGN KEY (cod_servicio)
        REFERENCES SERVICIO(id_servicio)
);


ALTER TABLE CLIENTE
ADD CONSTRAINT un_email UNIQUE (email);

ALTER TABLE CLIENTE
ADD CONSTRAINT ck_dv
CHECK (dv IN ('0','1','2','3','4','5','6','7','8','9','K'));

ALTER TABLE MECANICO
ADD CONSTRAINT ck_sueldo
CHECK (sueldo >= 510000);

ALTER TABLE MANTENCION
ADD CONSTRAINT ck_estado
CHECK (estado IN ('Reserva','Ingresado','Entregado','Anulado'));

INSERT INTO PAIS VALUES (9,'Chile');
INSERT INTO PAIS VALUES (12,'Peru');
INSERT INTO PAIS VALUES (15,'Colombia');

INSERT INTO CIUDAD VALUES (165,'Santiago',9);
INSERT INTO CIUDAD VALUES (170,'Lima',12);
INSERT INTO CIUDAD VALUES (175,'Bogota',15);

INSERT INTO SUCURSAL VALUES ('S01','Providencia','Av. A. Varas',234,165);
INSERT INTO SUCURSAL VALUES ('S02','Las 4 esquinas','Av. Latina',669,170);
INSERT INTO SUCURSAL VALUES ('S03','El Cafetero','Av. El Faro',900,175);

INSERT INTO MARCA VALUES (1,'Toyota');
INSERT INTO MODELO VALUES (100,1,'Rav4');
INSERT INTO TIPO_AUTOMOVIL VALUES ('SUV','Deportivo');

INSERT INTO CLIENTE VALUES
(11111111,'K','Maria','Elena','Lopez','Diaz','987654321','maria@mail.com','E');

INSERT INTO MECANICO VALUES (460,'Jorge','Pablo','Soto','Sierra',540000,2759000,223580,NULL);
INSERT INTO MECANICO VALUES (467,'Pedro','Jose','Manriquez','Corral',NULL,759000,23980,NULL);
INSERT INTO MECANICO VALUES (474,'Sandra','Josefa','Letelier','S.',0,659000,22358,460);
INSERT INTO MECANICO VALUES (481,'Felipe',NULL,'Vidal','A.',NULL,759000,23580,460);
INSERT INTO MECANICO VALUES (488,'Jose','Miguel','Troncoso','B.',NULL,659000,44580,474);
INSERT INTO MECANICO VALUES (495,'Juan','Pablo','Sanchez','R.',NULL,859000,23380,474);
INSERT INTO MECANICO VALUES (502,'Carlos','Felipe','Soto','J.',0,597000,23580,474);
INSERT INTO MECANICO VALUES (509,'Alberto',NULL,'Cerda','Ramirez',NULL,559000,22380,460);
INSERT INTO MECANICO VALUES (516,'Alejandra','Gabriela','Infanti','R.',NULL,659000,22380,460);
INSERT INTO MECANICO VALUES (523,'Roberto','Patricio','Gutierrez','Sosa',NULL,859000,22380,NULL);

INSERT INTO MANTENCION VALUES (101,'S01',DATE '2023-04-12',NULL,NULL,481,'Reserva');
INSERT INTO MANTENCION VALUES (102,'S02',DATE '2023-02-21',DATE '2023-02-21',NULL,502,'Entregado');
INSERT INTO MANTENCION VALUES (103,'S02',DATE '2023-10-09',NULL,NULL,502,'Anulado');
INSERT INTO MANTENCION VALUES (104,'S03',DATE '2023-08-11',DATE '2023-08-18',NULL,509,'Entregado');
INSERT INTO MANTENCION VALUES (105,'S03',DATE '2023-12-03',NULL,NULL,509,'Ingresado');

COMMIT;

SELECT
    cod_mecanico AS "ID MECANICO",
    pnombre || ' ' || apaterno AS "NOMBRE MECANICO",
    sueldo AS "SALARIO",
    monto_impuestos AS "IMPUESTO ACTUAL",
    monto_impuestos * 0.8 AS "IMPUESTO REBAJADO",
    sueldo - (monto_impuestos * 0.8) AS "SUELDO CON REBAJA IMPUESTOS"
FROM MECANICO
WHERE bono_jefatura IS NULL
AND monto_impuestos < 40000
ORDER BY monto_impuestos DESC, apaterno ASC;

SELECT
    cod_mecanico AS "IDENTIFICADOR",
    pnombre || ' ' || snombre || ' ' || apaterno AS "MECANICO",
    sueldo AS "SALARIO ACTUAL",
    sueldo * 0.05 AS "AJUSTE",
    sueldo + (sueldo * 0.05) AS "SUELDO_REAJUSTADO"
FROM MECANICO
WHERE (sueldo BETWEEN 600000 AND 900000)
   OR cod_supervisor IS NULL
ORDER BY sueldo ASC, "MECANICO" DESC;