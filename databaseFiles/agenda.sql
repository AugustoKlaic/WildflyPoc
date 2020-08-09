create table agenda(
    agenda_id uuid primary key,
    agenda_name varchar(150) not null,
    agenda_duration interval default '00:01:00'
);

insert into agenda(agenda_id, agenda_name, agenda_duration)
values (uuid_generate_v1(), 'Test agenda', '00:02:00');