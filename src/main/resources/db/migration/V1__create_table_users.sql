CREATE TABLE IF NOT EXISTS users (
    id bigint not null,
    name varchar(255),
    registrationDate Date,
    isSatisfied boolean,
    gender varchar(10),
    aged boolean,
    timeOfService bigint,
    exitForecast Date,
    primary key(id)
);