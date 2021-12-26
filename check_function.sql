select * from student 
where rating < avg_rating();

SELECT id, name_school, name_director, phone_number, select_city(id)
 as id_city from school ;
 