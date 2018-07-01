insert  into role (name) values ('admin'), ('user');

insert  into rules (name) values ('create'), ('update'), ('delete');

insert  into category (name) values ('standard'), ('premium');

insert  into role_has_rules (role_id, rules_id) values 
                    (1, 1),
                    (1, 2),
                    (1, 3),   
                    (2, 1); 

insert  into state (name) values ('inWork'), ('completed');


insert  into attachs (name, fileUser) values 
                 ('file1', '/User/1.jpg', 1),
                  ('file2', '/User/2.jpg', 2);  


insert  into "user" (login, password, role_id) values 
            ('serg262', 123, 1),
            ('ivan987', 321, 2);


insert  into  item (name, datacreate, category_id, state_id, user_id) values 
             ('item1', '2018-06-10 08:05:06', 1, 1, 1),
             ('item2', '2018-06-15 10:05:00', 2 ,1, 2);


 insert  into  comments (description, item_id) values 
     ('desc1', 1),
     ('desc2', 2);


  insert  into  userdata (user_id, name, surname, dateBirth, numberPhone ) values 
      (1,'Sergey', 'Ivanov', '04.01.1990', '79995553322'),
      (2,'Ivan', 'Petrov',  '01.10.1987', '79774441155'); 