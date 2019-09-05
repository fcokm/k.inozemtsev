<<<<<<< HEAD
CREATE TABLE IF NOT EXISTS item (
    id         SERIAL PRIMARY KEY  NOT NULL,
    name       VARCHAR(100)        NOT NULL,
    created    TIMESTAMP           NOT NULL,
    done       BOOLEAN             NOT NULL
 )
=======

CREATE TABLE IF NOT EXISTS car_body (
    id       SERIAL PRIMARY KEY      NOT NULL
    , name   VARCHAR(100)   UNIQUE   NOT NULL
 );

 CREATE TABLE IF NOT EXISTS engine (
    id       SERIAL PRIMARY KEY      NOT NULL
    , name   VARCHAR(100)   UNIQUE   NOT NULL
 );

 CREATE TABLE IF NOT EXISTS transmission (
    id        SERIAL PRIMARY KEY      NOT NULL
    , type    VARCHAR(100)   UNIQUE   NOT NULL
 );

 CREATE TABLE IF NOT EXISTS mark_car (
    id       SERIAL PRIMARY KEY      NOT NULL
    , name   VARCHAR(100)   UNIQUE   NOT NULL
 );

 CREATE TABLE IF NOT EXISTS colour (
    id       SERIAL PRIMARY KEY  NOT NULL
    , name   VARCHAR(100)   UNIQUE   NOT NULL
 );
 CREATE TABLE IF NOT EXISTS car (
    id                  SERIAL PRIMARY KEY                    NOT NULL
    , mark_id           INTEGER REFERENCES  markCar(id)       NOT NULL
    , body_id           INTEGER REFERENCES  car_body(id)      NOT NULL
    , engine_id         INTEGER REFERENCES  engine(id)        NOT NULL
    , transmission_id   INTEGER REFERENCES  transmission(id)  NOT NULL
    , colour_id         INTEGER REFERENCES  colour(id)        NOT NULL
 );



>>>>>>> task_4744
