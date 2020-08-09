create table votes(
    vote_agenda uuid not null,
    vote_associate uuid not null,
    vote_value boolean not null,

    primary key (vote_agenda, vote_associate),
    constraint  unique_vote unique (vote_associate, vote_agenda, vote_value)
);
