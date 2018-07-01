create table carBody  (
 id serial primary key   NOT NULL,
 carBodyType varchar(50)   NOT NULL
);


 

 create table engine  (
 id serial primary key   NOT NULL,
 name varchar(50)       NOT NULL
);



create table transmission  (
 id serial primary key   NOT NULL,
 type  varchar(50)       NOT NULL
);
 


create table markCar (
id serial primary key   NOT NULL,
name  varchar(50)       NOT NULL
);
 

create table сolour (
id serial primary key   NOT NULL,
name  varchar(50)       NOT NULL
); 


create table car (
 id serial primary key   NOT NULL,
 mark_id integer references markCar(id)  NOT NULL,
 сolour_id integer references сolour(id)  NOT NULL,
 body_id integer references carBody(id)  NOT NULL,
 engine_id integer references engine(id)  NOT NULL,
 transmission_id integer references carBody(id)  NOT NULL

);


