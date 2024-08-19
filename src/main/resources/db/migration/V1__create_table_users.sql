CREATE TABLE IF NOT EXISTS users (
    id bigint not null auto_increment,
    name varchar(255),
    registration_date datetime,
    is_satisfied boolean,
    gender varchar(10),
    aged boolean,
    time_of_service bigint,
    exit_forecast datetime,
    primary key(id)
);