--1. Запрос получение всех продуктов с типом "СЫР"

select * from product as p inner join type as t on p.type_id = t.id 
 where t.name = 'сыр';

--2. Запрос получения всех продуктов, у кого в имени есть слово "мороженное"

select * from product as p inner join type as t on p.type_id = t.id 
where t.name like 'мороженное';

--3. Запрос, который выводит все продукты, срок годности которых
 заканчивается в следующем месяце.
 
select * from product as p inner join type as t on p.type_id = t.id 
where p.expired_date  BETWEEN '2018-07-01 00:00:00' AND '2018-07-31 23:59:59';

--4. Запрос, который вывод самый дорогой продукт.

select MAX(price) as price from  product;

--5. Запрос, который выводит количество всех продуктов определенного типа.

select  p.name, count(t.name) as countProduct from product as p 
   inner join type as t on p.type_id = t.id 
    group by p.name;


--6. Запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select  * from product as p 
   inner join type as t on p.type_id = t.id 
   where t.name  in ('сыр','молоко');

 
--7. Запрос, который выводит тип продуктов, которых осталось меньше 10 штук. 
   select t.name , count(p.type_id) from type as t  inner join
   product as p on p.type_id = t.id 
   group by  t.name
   HAVING  count(p.type_id) < 10;