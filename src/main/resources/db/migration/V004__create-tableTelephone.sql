create table telephone (
ddd varchar(10) not null,
type_tell varchar(15) not null,
tell varchar(15) not null,
id_cli int not null,

foreign key (id_cli) references clients(id_cli)
);