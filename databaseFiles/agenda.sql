create table agenda(
    agenda_id uuid not null,
    agenda_name varchar(150) not null,

    primary key (agenda_id)
);

insert into agenda(agenda_id, agenda_name)
values (uuid_generate_v1(), 'Test agenda');