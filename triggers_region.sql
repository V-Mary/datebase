USE lab7;

DELIMITER $$

drop trigger if exists before_delete_region $$
CREATE TRIGGER before_delete_region
before delete on region FOR EACH ROW
BEGIN
	if (old.id in (select id_region from city) ) 
    then
		SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Sorry, you use this id on table city";
		end if;
END$$


DELIMITER ;