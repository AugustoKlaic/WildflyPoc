create table session(
    session_id uuid not null,
    session_agenda uuid not null,
    session_duration timestamp not null default (now() + INTERVAL '1 min'),
    session_creation_time timestamp not null,
    session_status boolean not null,

    primary key (session_id),
    constraint agenda_session foreign key (session_agenda) references agenda(agenda_id)
);