create table vote(
    vote_agenda uuid not null,
    vote_associate uuid not null,
    vote_session uuid not null,
    vote_value boolean not null,

    primary key (vote_agenda, vote_associate),
    constraint unique_vote unique (vote_associate, vote_agenda, vote_value),
    constraint agenda_vote foreign key (vote_agenda) references agenda(agenda_id),
    constraint associate_vote foreign key (vote_associate) references associate(associate_id),
    constraint session_vote foreign key (vote_session) references session(session_id)
);
