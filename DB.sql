INSERT INTO `martciv_maria`.`user` (`name`, `age`, `sex`, `ordered_tickets`) VALUES ('Ann', '20', 'women', '13');
INSERT INTO `martciv_maria`.`user` (`name`, `age`, `sex`, `ordered_tickets`) VALUES ('Bob', '25', 'men', '7');
INSERT INTO `martciv_maria`.`user` (`name`, `age`, `sex`, `ordered_tickets`) VALUES ('Mary', '36', 'women', '5');
INSERT INTO `martciv_maria`.`user` (`name`, `age`, `ordered_tickets`) VALUES ('Ket', '18', '20');

INSERT INTO `martciv_maria`.`artist` (`name`) VALUES ('Kazka');
INSERT INTO `martciv_maria`.`artist` (`name`) VALUES ('Verba');
INSERT INTO `martciv_maria`.`artist` (`name`) VALUES ('Vunnuk');
INSERT INTO `martciv_maria`.`artist` (`name`) VALUES ('Tik');

INSERT INTO `martciv_maria`.`city` (`city`) VALUES ('Lviv');
INSERT INTO `martciv_maria`.`city` (`city`) VALUES ('Kiev');
INSERT INTO `martciv_maria`.`city` (`city`) VALUES ('London');
INSERT INTO `martciv_maria`.`city` (`city`) VALUES ('Paris');
INSERT INTO `martciv_maria`.`city` (`city`) VALUES ('Rome');


INSERT INTO `martciv_maria`.`street` (`street`, `number`) VALUES ('Valova', '20');
INSERT INTO `martciv_maria`.`street` (`street`, `number`) VALUES ('Green', '30');
INSERT INTO `martciv_maria`.`street` (`street`, `number`) VALUES ('Kush', '2');
INSERT INTO `martciv_maria`.`street` (`street`, `number`) VALUES ('Small', '64');
INSERT INTO `martciv_maria`.`street` (`street`, `number`) VALUES ('Central', '8');

INSERT INTO `martciv_maria`.`delivery` (`id`, `delivery`, `street_id`, `city_id`) VALUES ('1', 'Post', '1', 'London');
INSERT INTO `martciv_maria`.`delivery` (`id`, `delivery`, `street_id`, `city_id`) VALUES ('2', 'Post', '2', 'Lviv');
INSERT INTO `martciv_maria`.`delivery` (`id`, `delivery`, `street_id`, `city_id`) VALUES ('3', 'Courier', '3', 'Kiev');
INSERT INTO `martciv_maria`.`delivery` (`id`, `delivery`, `street_id`, `city_id`) VALUES ('4', 'Courier', '4', 'Lviv');

INSERT INTO `martciv_maria`.`route` (`from`, `to`) VALUES ('Lviv', 'Kiev');
INSERT INTO `martciv_maria`.`route` (`from`, `to`) VALUES ('Kiev', 'Lviv');
INSERT INTO `martciv_maria`.`route` (`from`, `to`) VALUES ('Kiev', 'Paris');

INSERT INTO `martciv_maria`.`insurance` (`name`, `price`, `days`) VALUES ('Super', '400', '20');
INSERT INTO `martciv_maria`.`insurance` (`name`, `price`, `days`) VALUES ('Normal', '200', '10');
INSERT INTO `martciv_maria`.`insurance` (`name`, `price`, `days`) VALUES ('Minimal', '100', '5');


INSERT INTO `martciv_maria`.`event` (`type`, `time_start`, `time_end`, `all_places`, `free_places`, `street_id`, `artist_id`, `city_id`) VALUES ('concert', '12:00', '14:00', '100', '50', '1', '1', 'Lviv');
INSERT INTO `martciv_maria`.`event` (`type`, `time_start`, `time_end`, `all_places`, `free_places`, `street_id`, `route_id`, `city_id`) VALUES ('train', '13:00', '20:00', '50', '10', '2', '1', 'Kiev');

INSERT INTO `martciv_maria`.`ticket` (`name`, `place`, `price`, `date`, `payment`, `user_id`, `event_id`, `insurance_id`) VALUES ('Weekend', '20', '200', '12.11.2021', 'cash', '1', '2', '1');
INSERT INTO `martciv_maria`.`ticket` (`name`, `place`, `price`, `date`, `payment`, `user_id`, `delivery_id`, `event_id`, `insurance_id`) VALUES ('Relax', '15', '300', '06.04.2019', 'card', '2', '1', '2', '2');
INSERT INTO `martciv_maria`.`ticket` (`name`, `place`, `price`, `date`, `payment`, `user_id`, `delivery_id`, `event_id`, `insurance_id`) VALUES ('Party', '3', '50', '12.01.2021', 'cash', '3', '2', '1', '3');
