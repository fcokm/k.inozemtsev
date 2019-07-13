CREATE TABLE IF NOT EXISTS item (
    id         SERIAL PRIMARY KEY  NOT NULL,
    name       VARCHAR(100)        NOT NULL,
    created    TIMESTAMP           NOT NULL,
    done       BOOLEAN             NOT NULL
 )





