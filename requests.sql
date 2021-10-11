SELECT model, ram, price FROM Laptop
WHERE ram=64 ORDER BY screen ASC;

SELECT name FROM labor_sql.ships
WHERE name like 'W%n';

 SELECT C1.model model1, C2.model model2, C1.ram, C1.speed FROM PC C1, PC C2
 WHERE C1.ram = C2.ram AND C1.speed = C2.speed AND C1.model > C2.model;
 
 SELECT ship, battle, date FROM Battles JOIN Outcomes 
ON battle=name 
WHERE result LIKE 'damaged';

SELECT distinct maker FROM labor_sql.product, labor_sql.pc
where speed >= 750;

SELECT DATE_FORMAT(date,'%d.%m.%Y') as date FROM income;

SELECT maker,  COUNT(*) FROM labor_sql.product
where type = 'PC' GROUP BY maker
HAVING COUNT(*)>=2;

SELECT distinct maker, speed as min_speed FROM labor_sql.product, labor_sql.laptop
where speed >= 600;

SELECT trip_no, plane, town_from, town_to, 
CASE
WHEN TIME(time_out) > TIME(time_in) 
	THEN TIME(time_out) - TIME(time_in)
ELSE TIME(time_in) - '24:00:00' - TIME(time_out)
END as airtime 
FROM trip;

SELECT name FROM ships WHERE name like '% % %'
UNION
SELECT ship FROM outcomes WHERE ship like '% % %';