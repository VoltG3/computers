CREATE SCHEMA IF NOT EXISTS migrations;

CREATE TABLE IF NOT EXISTS migrations.people
(
    id   INT2,
    name TEXT NOT NULL,
    role TEXT NOT NULL,
    PRIMARY KEY (id)
);