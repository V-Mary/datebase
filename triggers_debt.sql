USE lab7;

DELIMITER $$

drop trigger if exists before_delete_debt $$
CREATE TRIGGER before_delete_debt
before delete on debt FOR EACH ROW
BEGIN
	if (old.id_debt in (select id_debt from student_debt) ) 
    then
		SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Sorry, you use this id on table student_debt";
		end if;
END$$


DELIMITER ;