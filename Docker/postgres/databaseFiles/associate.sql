create table associate(
    associate_cpf varchar(12) not null,
    associate_name varchar(100) not null,

    primary key (associate_cpf),
    constraint unique_associate unique (associate_cpf)
);

insert into associate (associate_cpf, associate_name)
values('86101153053','Augusto');