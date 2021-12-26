USE lab7;

DELIMITER $$

drop trigger if exists before_insert_in_join_tables $$
CREATE TRIGGER before_insert_in_join_tables
before insert on student_debt FOR EACH ROW
BEGIN
	if (new.id_student not in (select id from student) ) or
     (new.id_debt not in (select id from debt) )
    then
		SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
		end if;
END$$


DELIMITER ;