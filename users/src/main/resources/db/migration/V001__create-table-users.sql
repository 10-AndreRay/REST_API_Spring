create table users(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    cpf varchar(11) not null,
    primary key (id)
)