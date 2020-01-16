create table associates(
    associates_id uuid primary key,
    associates_cpf varchar(12) unique not null,
    associates_name varchar(100) not null
);

insert into associates (associates_id, associates_cpf, associates_name)
values(uuid_generate_v1(), '86101153053','Augusto');