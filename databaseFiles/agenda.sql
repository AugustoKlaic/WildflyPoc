create table agenda(
    agenda_id uuid primary key,
    agenda_name varchar(150) not null,
    agenda_duration numeric default 1
);

insert into agenda(agenda_id, agenda_name, agenda_duration)
values (uuid_generate_v1(), 'Test agenda', 2);