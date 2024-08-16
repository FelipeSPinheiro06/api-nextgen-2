CREATE TABLE IF NOT EXISTS users (
    id bigint not null,
    name varchar(255),
    registration_date Date,
    is_satisfied boolean,
    gender varchar(10),
    aged boolean,
    time_of_service bigint,
    exit_forecast Date,
    primary key(id)
);