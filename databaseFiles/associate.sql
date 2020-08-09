create table associate(
    associate_id uuid primary key,
    associate_cpf varchar(12) unique not null,
    associate_name varchar(100) not null
);

insert into associate (associate_id, associate_cpf, associate_name)
values(uuid_generate_v1(), '86101153053','Augusto');