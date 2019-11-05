
 CREATE TABLE IF NOT EXISTS mark_car (
    id             SERIAL PRIMARY KEY  NOT NULL,
    name           VARCHAR(100)        NOT NULL
 );


CREATE TABLE IF NOT EXISTS car_body (
  id   SERIAL PRIMARY KEY   NOT NULL,
  name VARCHAR(100) UNIQUE  NOT NULL
);

CREATE TABLE IF NOT EXISTS engine_type (
  id   SERIAL PRIMARY KEY   NOT NULL,
  name VARCHAR(100) UNIQUE  NOT NULL
);

CREATE TABLE IF NOT EXISTS engine_vol (
  id     SERIAL PRIMARY KEY       NOT NULL,
  volume NUMERIC(3, 1) UNIQUE     NOT NULL
);

CREATE TABLE IF NOT EXISTS car_engine (
  id        SERIAL PRIMARY KEY                   NOT NULL,
  power     SMALLINT,
  type_id   INTEGER REFERENCES engine_type (id)  NOT NULL,
  volume_id INTEGER REFERENCES engine_vol (id)   NOT NULL
);

CREATE TABLE IF NOT EXISTS car_transmission (
  id   SERIAL PRIMARY KEY    NOT NULL,
  name VARCHAR(100) UNIQUE   NOT NULL
);

CREATE TABLE IF NOT EXISTS car_model (
  id          SERIAL PRIMARY KEY                NOT NULL,
  name        VARCHAR(100) UNIQUE               NOT NULL,
  car_mark_id INTEGER REFERENCES car_mark (id)  NOT NULL
);

CREATE TABLE IF NOT EXISTS car_mark (
  id   SERIAL PRIMARY KEY                 NOT NULL,
  name VARCHAR(100) UNIQUE                NOT NULL
);

CREATE TABLE IF NOT EXISTS colour (
  id   SERIAL PRIMARY KEY       NOT NULL,
  name VARCHAR(100) UNIQUE      NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
  id       SERIAL PRIMARY KEY       NOT NULL,
  login    VARCHAR(100) UNIQUE      NOT NULL,
  password VARCHAR(100)             NOT NULL
);

CREATE TABLE IF NOT EXISTS car_category (
  id   SERIAL PRIMARY KEY       NOT NULL,
  name VARCHAR(100) UNIQUE      NOT NULL
);



CREATE TABLE IF NOT EXISTS years (
  id     SERIAL PRIMARY KEY       NOT NULL,
  name   VARCHAR (100) UNIQUE      NOT NULL
);



CREATE TABLE IF NOT EXISTS cars (
  id                 SERIAL PRIMARY KEY                        NOT NULL,
  mark_id            INTEGER                                   NOT NULL,
  model_id           INTEGER REFERENCES car_model (id)         NOT NULL,
  body_id            INTEGER REFERENCES car_body (id)          NOT NULL,
  engine_type_id     INTEGER REFERENCES engine_type (id)       NOT NULL,
  engine_vol_id      INTEGER REFERENCES engine_vol (id)        NOT NULL,
  transmission_id    INTEGER REFERENCES car_transmission (id)  NOT NULL,
  colour_id          INTEGER REFERENCES colour (id)            NOT NULL,
  year_id            INTEGER REFERENCES year (id)              NOT NULL,
  mileage            INTEGER                                   NOT NULL,
  category_id        INTEGER REFERENCES car_category (id)      NOT NULL,
  price              NUMERIC(15, 2)                            NOT NULL,
  user_id            INTEGER REFERENCES users (id)             NOT NULL,
  status             SMALLINT     DEFAULT 1                    NOT NULL,
  registration_time  TIMESTAMP WITHOUT TIME ZONE               NOT NULL,
  photo bytea
);







