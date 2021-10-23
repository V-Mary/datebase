-- -----------------------------------------------------
-- Schema martciv_maria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `martciv_maria` DEFAULT CHARACTER SET utf8 ;
USE `martciv_maria` ;

DROP TABLE IF EXISTS `martciv_maria`.`user`;
DROP TABLE IF EXISTS `martciv_maria`.`city`;
DROP TABLE IF EXISTS `martciv_maria`.`street`;
DROP TABLE IF EXISTS `martciv_maria`.`delivery`;
DROP TABLE IF EXISTS `martciv_maria`.`artist`;
DROP TABLE IF EXISTS `martciv_maria`.`route`;
DROP TABLE IF EXISTS `martciv_maria`.`event`;
DROP TABLE IF EXISTS `martciv_maria`.`insurance`;
DROP TABLE IF EXISTS `martciv_maria`.`ticket`;

CREATE TABLE `martciv_maria`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `sex` ENUM('women', 'men') NULL,
  `ordered_tickets` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `martciv_maria`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `martciv_maria`.`street` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `martciv_maria`.`delivery` (
  `id` INT NOT NULL,
  `delivery` ENUM('post', 'courier') NOT NULL,
  `city_id` INT NOT NULL,
  `street_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_id`, `street_id`),
    FOREIGN KEY (`city_id`)
    REFERENCES `martciv_maria`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`street_id`)
    REFERENCES `martciv_maria`.`street` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `martciv_maria`.`artist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `martciv_maria`.`route` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from` VARCHAR(45) NOT NULL,
  `to` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `martciv_maria`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('concert', 'train', 'plane') NOT NULL,
  `time_start` TIME NOT NULL,
  `time_end` TIME NOT NULL,
  `all_places` INT NOT NULL,
  `free_places` INT NOT NULL,
  `city_id` INT NOT NULL,
  `street_id` INT NOT NULL,
  `artist_id` INT NULL,
  `route_id` INT NULL,
  PRIMARY KEY (`id`, `city_id`, `street_id`),
    FOREIGN KEY (`city_id`)
    REFERENCES `martciv_maria`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`street_id`)
    REFERENCES `martciv_maria`.`street` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`artist_id`)
    REFERENCES `martciv_maria`.`artist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`route_id`)
    REFERENCES `martciv_maria`.`route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE INDEX event_free_places on `martciv_maria`.`event` (free_places ASC) VISIBLE;

CREATE TABLE `martciv_maria`.`insurance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `days` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
CREATE INDEX insurance_price on `martciv_maria`.`insurance` (price ASC) VISIBLE;

CREATE TABLE `martciv_maria`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `place` INT NOT NULL,
  `price` INT NOT NULL,
  `date` DATE NOT NULL,
  `payment` ENUM('cash', 'card') NOT NULL,
  `user_id` INT NOT NULL,
  `delivery_id` INT NULL,
  `event_id` INT NOT NULL,
  `insurance_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `event_id`, `insurance_id`),
    FOREIGN KEY (`user_id`)
    REFERENCES `martciv_maria`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`delivery_id`)
    REFERENCES `martciv_maria`.`delivery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`event_id`)
    REFERENCES `martciv_maria`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`insurance_id`)
    REFERENCES `martciv_maria`.`insurance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE INDEX ticket_place on `martciv_maria`.`ticket` (place ASC) VISIBLE;

