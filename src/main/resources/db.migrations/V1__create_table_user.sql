CREATE TABLE IF NOT EXISTS users (
    id bigint not null,
    name varchar(255),
    registrationDate LocalDateTime,
    isSatisfied boolean,
    gender varchar(10),
    aged boolean,
    timeOfService bigint,
    exitForecast LocalDateTime,
    primary key(id)
);