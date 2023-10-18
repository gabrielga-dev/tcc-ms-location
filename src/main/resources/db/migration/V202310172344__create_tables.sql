CREATE TABLE country
(
    id   BIGINT primary key not null,
    name varchar(300)       not null,
    iso2 varchar(500)       not null
);

CREATE TABLE state
(
    id         BIGINT primary key not null,
    name       varchar(300)       not null,
    iso2       varchar(500)       not null,
    country_id BIGINT             not null,
    FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE city
(
    id         BIGINT primary key not null,
    name       varchar(300)       not null,
    state_id BIGINT             not null,
    FOREIGN KEY (state_id) REFERENCES state (id)
);
