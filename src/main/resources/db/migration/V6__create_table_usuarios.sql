CREATE TABLE usuarios(

    id bigint identity(1,1) not null,
    login varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)

);