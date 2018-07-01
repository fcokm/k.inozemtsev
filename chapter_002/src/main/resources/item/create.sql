
create database itemDb;

create table if not exists role  (
 id serial primary key   NOT NULL,
 name varchar(30)      NOT NULL
);


create table if not exists rules  (
 id serial primary key   NOT NULL,
 name varchar(30)      NOT NULL
);


create table if not exists category  (
 id serial primary key   NOT NULL,
 name text   NOT NULL
);


create table if not exists role_has_rules  (
 id serial primary key   NOT NULL,
 role_id integer  references role(id) NOT NULL ,
 rules_id integer  references rules(id) NOT NULL
);

          
create table if not exists state  (
 id serial primary key   NOT NULL,
 name varchar(50)  NOT NULL
);


create table if not exists attachs  (
 id serial primary key   NOT NULL,
 name varchar(50)  NOT NULL,
 fileUser VARCHAR(100),
 item_id integer references item(id)  NOT NULL
);


create table if not exists "user"  (
 id serial primary key   NOT NULL,
 login varchar(100) unique   NOT NULL,
 password varchar(100)    NOT NULL,
 role_id integer references role(id)  NOT NULL
);


create table if not exists item  (
 id serial primary key   NOT NULL,
 name varchar(50)  NOT NULL,
 dataCreate  timestamp    NOT NULL,
 category_id integer  references category(id) NOT NULL ,
 state_id integer  references state(id) NOT NULL,
 user_id integer  references "user"(id) NOT NULL
);


create table if not exists comments  (
 id serial primary key   NOT NULL,
 description text      NOT NULL,
 item_id integer references item(id)  NOT NULL
);



create table if not exists userdata (
 user_id integer primary key references "user"(id) NOT NULL,
 name  varchar(50)  NOT NULL,
 surname varchar(50)  NOT NULL,
 dateBirth date NOT NULL,
 numberPhone varchar(20) NOT NULL 
);
