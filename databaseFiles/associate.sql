create table associate(
    associate_id uuid not null,
    associate_cpf varchar(12) not null,
    associate_name varchar(100) not null,

    primary key (associate_id),
    constraint unique_associate unique (associate_cpf)
);

insert into associate (associate_id, associate_cpf, associate_name)
values(uuid_generate_v1(), '86101153053','Augusto');