ALTER TABLE users
    ADD COLUMN email varchar(255) AFTER name;

ALTER TABLE users
    ADD COLUMN password varchar(255) AFTER email;
