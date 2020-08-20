create table session(
    session_id uuid not null,
    session_agenda uuid not null,
    session_duration numeric not null default 1,
    session_creation_time timestamp not null,

    primary key (session_id),
    constraint agenda_session foreign key (session_agenda) references agenda(agenda_id)
);