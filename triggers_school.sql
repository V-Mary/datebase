USE lab7;

DELIMITER $$

DROP TRIGGER IF EXISTS lab7.before_insert_school;
CREATE TRIGGER before_insert_school
before insert on  school FOR EACH ROW
BEGIN
	if (new.id_city not in (select id from region) ) then
	SIGNAL SQLSTATE '45000'
		set MESSAGE_TEXT = "Sorry, that id cannot be foreign key.";
	end if;
    
    if(new.phone_number not rlike "380[0-9]{6}")
    then signal sqlstate '45000' set message_text = 'Cannot insert new value: wrong phone_number parameter';
    end if;
END$$

drop trigger if exists lab7.before_delete_student ;
CREATE TRIGGER before_delete_student
before delete on student FOR EACH ROW
BEGIN
	if (old.id_student in (select id_student from student_debt) ) 
    then
		SIGNAL SQLSTATE '45000'
			set MESSAGE_TEXT = "Sorry, you use this id on table student_debt";
		end if;
END$$

DELIMITER ;