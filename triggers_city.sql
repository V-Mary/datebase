USE lab7;

DELIMITER $$

DROP TRIGGER IF EXISTS lab7.before_insert_city;
CREATE TRIGGER before_insert_city
before insert on  city FOR EACH ROW
BEGIN
if (new.id_region not in (select id from city) ) then
SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
	end if;
END$$


drop trigger if exists before_delete_city $$
CREATE TRIGGER before_delete_city
before delete on city FOR EACH ROW
BEGIN
	if (old.id in (select id_city from school) ) 
    then
		SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Sorry, you use this id on table school";
		end if;
END$$
DELIMITER ;