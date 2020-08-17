create table agenda(
    agenda_id uuid primary key,
    agenda_name varchar(150) not null,
    agenda_duration numeric default 1,
    agenda_creation_time date not null
);

insert into agenda(agenda_id, agenda_name, agenda_duration, agenda_creation_time)
values (uuid_generate_v1(), 'Test agenda', 2, now());