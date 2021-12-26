USE `lab7`;
set global log_bin_trust_function_creators = 1;
DELIMITER $$

DROP function IF EXISTS avg_rating ;
CREATE FUNCTION avg_rating()
RETURNS INTEGER
BEGIN 
	RETURN (SELECT avg(rating) from student);
END $$

DROP function IF EXISTS select_city ;
CREATE function select_city(id_school int)
RETURNS VARCHAR(45)
BEGIN 
	RETURN (SELECT city from city where id = (select id_city from school where id = id_school));
END $$


DELIMITER ;


