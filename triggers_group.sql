USE lab7;

DELIMITER $$

drop trigger if exists before_delete_group $$
CREATE TRIGGER before_delete_group
before delete on lab7.group FOR EACH ROW
BEGIN
	if (old.id in (select id_group from student) ) 
    then
		SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Sorry, you use this id on table student";
		end if;
END$$


DELIMITER ;