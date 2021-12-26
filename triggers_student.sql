USE lab7;

DELIMITER $$

drop trigger if exists before_insert_student $$
CREATE TRIGGER before_insert_student
before insert on student FOR EACH ROW
BEGIN
	if (new.id_city not in (select id from city) ) or
     (new.id_school not in (select id from school) ) or
     (new.id_group not in (select id from lab7.group) )
    then
		SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
		end if;
END$$


DELIMITER ;