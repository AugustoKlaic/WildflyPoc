FROM ubuntu:latest

MAINTAINER augusto-sopelsa augusto.klaic@ilegra.com

#add all dependecies needed for postgres
RUN apt-get update
RUN apt-get install -y apt-utils
RUN apt-get install -y wget ca-certificates
RUN apt-get install -y gnupg2

#create the directory to copy files scripts
RUN mkdir dbFiles/

#copy files from the system to the container
COPY associate.sql dbFiles/
COPY agenda.sql dbFiles/
COPY session.sql dbFiles/
COPY vote.sql dbFiles/

#get all license key to get postgres
RUN wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add -
RUN sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'

#Define timezone to not need to set it manually
ENV TZ=America/Brazil
RUN apt-get install -y tzdata

#get postgres
RUN apt-get install -y postgresql postgresql-contrib

##set to root user to start postgres and create your user
USER postgres

#start postgres, create the user, database, set the password and run scripts
RUN service postgresql start &&\
    psql --command "CREATE USER voterguy WITH SUPERUSER PASSWORD 'v0t3r';" &&\
    createdb -O voterguy voter-app-db &&\
    psql -d voter-app-db --command "CREATE EXTENSION IF NOT EXISTS \"uuid-ossp\";" &&\
    psql -d voter-app-db -f "dbFiles/associate.sql" &&\
    psql -d voter-app-db -f "dbFiles/agenda.sql" &&\
    psql -d voter-app-db -f "dbFiles/session.sql" &&\
    psql -d voter-app-db -f "dbFiles/vote.sql";

#configure the postgres to accept remote connections
RUN echo "host all  all    0.0.0.0/0  md5" >> /etc/postgresql/12/main/pg_hba.conf

# And add ``listen_addresses`` to ``/etc/postgresql/12/main/postgresql.conf``
RUN echo "listen_addresses='*'" >> /etc/postgresql/12/main/postgresql.conf

# Expose the PostgreSQL port
EXPOSE 5432

# Add VOLUMEs to allow backup of config, logs and databases
VOLUME  ["/etc/postgresql", "/var/log/postgresql", "/var/lib/postgresql"]

CMD ["/usr/lib/postgresql/12/bin/postgres", "-D", "/var/lib/postgresql/12/main", "-c", "config_file=/etc/postgresql/12/main/postgresql.conf"]