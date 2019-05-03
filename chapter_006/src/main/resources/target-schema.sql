CREATE TABLE IF NOT EXISTS users (
     id                 INTEGER PRIMARY KEY
  ,  name               CHARACTER VARYING(70)
  ,  login              CHARACTER VARYING(70)
  ,  email              CHARACTER VARYING(30)
  ,  password           CHARACTER VARYING(50)
  ,  data               TIMESTAMP WITHOUT TIME  ZONE
  ,  role               CHARACTER VARYING(10)
  ,  refbook_country_id INTEGER REFERENCES country(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS ref_book_country (
     id                  INTEGER PRIMARY KEY
  ,  name                CHARACTER VARYING(70)
  ,  city_id             INTEGER REFERENCES country(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS ref_book_city (
     id                  INTEGER PRIMARY KEY
  ,  name                CHARACTER VARYING(70)
);
