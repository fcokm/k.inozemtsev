
--Запрос на вывод списока всех машин и все привязанных к ним деталей
 select m.name as mark, cl.name,  b.carBodyType as CarBody, e.name,t.type as transmissionType 
  from car as c 
  inner join markCar as m on c.mark_id = m.id
  inner join сolour as cl on c.сolour_id = cl.id
  inner join carBody as b on c.body_id = b.id
  inner join engine as e on c. engine_id = e.id
  inner join transmission as t on c.transmission_id = t.id;


-- Запрос списка всех деталей, которые не используются в машине.
select e.name as engine  from car as c 
right join  engine as e on  c.engine_id = e.id 
where c.id is null
 UNION
select b.carbodytype  from car as c 
right join  carBody as b  on  c.body_id = b.id 
where c.id is null
 UNION
select t.type as gearboxType  from car as c 
right join transmission  as t on c.transmission_id = t.id 
where c.id is null;