create schema Banco;

create table cliente
(
    id_cliente     bigint unsigned auto_increment
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

create table cuentas
(
    numero_cuenta  VARCHAR(50) not null,
    alias          VARCHAR(50) not null,
    estado         VARCHAR(10) not null,
    tipo_cuenta    VARCHAR(20) not null,
    balance        DOUBLE      not null,
    interes        DOUBLE      not null,
    fecha_creacion DATETIME    not null,
    constraint cuentas_pk
        primary key (numero)
);

create table cuentas_cliente
(
    id            BIGINT auto_increment,
    numero_cuenta VARCHAR(50) null,
    id_cliente    BIGINT      not null,
    constraint cuentas_cliente_pk
        primary key (id),
    constraint cuentas_cliente_cliente_id_cliente_fk
        foreign key (id_cliente) references cliente (id_cliente),
    constraint cuentas_cliente_cuentas_numero_fk
        foreign key (numero_cuenta) references cuentas (numero)
);