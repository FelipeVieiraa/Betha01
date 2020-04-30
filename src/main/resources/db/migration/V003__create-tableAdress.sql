create table adress (
street varchar(100) not null,
num_street int not null,
cep varchar(15) not null,
main_adress boolean not null default 0,
id_cli int not null,

foreign key (id_cli) references clients(id_cli)
);