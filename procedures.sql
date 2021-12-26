USE `lab7`;

DELIMITER $$

DROP procedure IF EXISTS `insert_student`;
CREATE DEFINER=`root`@`localhost` 
PROCEDURE `insert_student`(
    in new_name varchar(45),
    in new_surname varchar(45),
    in new_rating int,
    in new_birthday date,
    in new_date_admission date,
     in new_student_number int,
    in new_id_city int,
    in new_id_group int,
    in new_id_school int
)
BEGIN
    INSERT INTO `lab7`.`student` 
        (`surname`, `name`, `rating`, `birthday`, `date_admission`, `student_number`, `id_city`, `id_group`, `id_school`) 
    VALUES 
        (new_name, new_surname, new_rating, new_birthday, new_date_admission, new_student_number, new_id_city, new_id_group, new_id_school);
END$$

DROP procedure IF EXISTS `fill_city`;
CREATE DEFINER=`root`@`localhost`
PROCEDURE `fill_city` ()
BEGIN
    declare counter int default 0;
    declare city_num int;
    declare expected_new_city varchar(10);
    
    while counter < 10 do
        set city_num = FLOOR(RAND()*1000);
        set expected_new_city = concat("Noname", city_num);
        if (not exists(select * from `city` where city.`city` = expected_new_city))
            then 
            insert into `city`(`city`, `id_region`) values (expected_new_city, '1');
            set counter = counter + 1;
        end if;
    end while;
END$$

DROP procedure IF EXISTS `create_tables`;
CREATE DEFINER=`root`@`localhost` 
PROCEDURE `create_tables`()
begin
	DECLARE finished INTEGER default 0;
    DECLARE curr_db_name VARCHAR(20) default "";
    DECLARE tables_count INT default 0;
    DECLARE table_counter INT default 1;
    
    DECLARE current_region CURSOR FOR
		SELECT region from region;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

OPEN current_region;
    
    get_region: Loop
		Fetch current_region INTO curr_db_name;
        if finished = 1 then
			LEAVE get_region;
		END if;
        
       SET tables_count = FLOOR( 1 + RAND( ) *9 );
       SET @create_db = concat('CREATE SCHEMA IF NOT EXISTS ', curr_db_name, ' DEFAULT CHARACTER SET utf8');
       PREPARE stmt FROM @create_db;
	   EXECUTE stmt;
       DEALLOCATE PREPARE stmt;
       
		SET table_counter = 1;
        WHILE table_counter <= tables_count DO
			SET @create_table = concat('CREATE TABLE IF NOT EXISTS `', curr_db_name, '`.`', curr_db_name, table_counter, '` (
			`region` VARCHAR(20) NOT NULL,
			PRIMARY KEY (`region`))
			ENGINE = InnoDB;');
            PREPARE stmt2 FROM @create_table;
            EXECUTE stmt2;
            DEALLOCATE PREPARE stmt2;
            SET table_counter = table_counter + 1;
            
        END WHILE;
        
	END LOOP get_region;
    
    CLOSE current_region;

END$$

DELIMITER ;
