CREATE TABLE IF NOT EXISTS accident (
    id serial primary key,
    name varchar(300),
    description text,
    created timestamp,
    address varchar(500),
    type_id int NOT NULL REFERENCES types(id)
);

CREATE TABLE IF NOT EXISTS types (
    id serial primary key,
    name varchar(200)
);

CREATE TABLE IF NOT EXISTS accident_rules (
    id serial primary key,
    accident_id INT REFERENCES accident(id),
    rules_id INT REFERENCES rules(id)
);

CREATE TABLE IF NOT EXISTS rules (
    id serial primary key,
    name varchar(200)
);