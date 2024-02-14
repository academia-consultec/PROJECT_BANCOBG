create schema Banco;

create table if not exists cliente
(
    id_cliente     bigint auto_increment
        primary key,
    nombre         varchar(50)  not null,
    apellido       varchar(50)  not null,
    tipo_documento varchar(250) not null,
    id_documento   int          not null,
    edad           int          not null,
    sexo           varchar(1)   not null,
    direccion      varchar(50)  not null,
    telefono       varchar(15)  not null,
    email          varchar(50)  not null,
    estado         varchar(10)  not null,
    constraint id_cliente
        unique (id_cliente)
);

create table if not exists cuentas
(
    numero_cuenta  varchar(50) not null
        primary key,
    id_cliente     bigint      null,
    alias          varchar(50) not null,
    estado         varchar(10) not null,
    tipo_cuenta    varchar(20) not null,
    balance        double      not null,
    interes        double      not null,
    fecha_creacion datetime    not null,
    constraint cuentas_cliente_id_cliente_fk
        foreign key (id_cliente) references cliente (id_cliente)
);

create table if not exists transacciones
(
    id                    int auto_increment
        primary key,
    numero_cuenta_origen  varchar(50) not null,
    numero_cuenta_destino varchar(50) not null,
    fecha                 datetime    not null,
    monto                 float       not null,
    tasa                  float       not null,
    constraint transacciones_cuentas_numero_cuenta_fk
        foreign key (numero_cuenta_origen) references cuentas (numero_cuenta),
    constraint transacciones_cuentas_numero_cuenta_fk2
        foreign key (numero_cuenta_destino) references cuentas (numero_cuenta)
);

INSERT INTO banco.cliente (nombre, apellido, tipo_documento, id_documento, edad, sexo, direccion, telefono, email, estado) VALUES ('Alberto', 'Gonzalez', 'RUC', 600588568, 31, 'M', 'SUCURSAL', '99999999', 'test@test2.com', 'SUSPENDIDO')
INSERT INTO banco.cuentas (numero_cuenta, id_cliente, alias, estado, tipo_cuenta, balance, interes, fecha_creacion) VALUES ('5798-9874-1236-7844', 2, 'CUENTA PERSONAL', 'INACTIVO', 'PLAZO_FIJO', 500, 0.5, '2024-02-09 13:22:15')
INSERT INTO banco.transacciones (numero_cuenta_origen, numero_cuenta_destino, fecha, monto, tasa) VALUES ('4798-9874-1236-1235', '4798-9874-1236-7865', '2024-02-14 13:20:50', 10, 1.5)

SELECT t.numero_cuenta_destino, t.fecha, t.monto FROM banco.transacciones t INNER JOIN banco.cuentas c on t.numero_cuenta_origen = c.numero_cuenta INNER JOIN banco.cliente c2 on c.id_cliente = c2.id_cliente WHERE c.id_cliente = 1;
SELECT * FROM cuentas WHERE id_cliente = 2
