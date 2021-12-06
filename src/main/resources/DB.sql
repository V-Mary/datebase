-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema martciv_maria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema martciv_maria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `martciv_maria` DEFAULT CHARACTER SET utf8 ;
USE `martciv_maria` ;

-- -----------------------------------------------------
-- Table `martciv_maria`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `ordered_tickets` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`street` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`delivery` (
  `id` INT NOT NULL,
  `city_id` INT NOT NULL,
  `street_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_id`, `street_id`),
  INDEX `fk_delivery_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_delivery_street1_idx` (`street_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `martciv_maria`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_street1`
    FOREIGN KEY (`street_id`)
    REFERENCES `martciv_maria`.`street` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`artist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`artist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`route` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from` VARCHAR(45) NOT NULL,
  `to` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(30) NOT NULL,
  `all_places` INT NOT NULL,
  `free_places` INT NOT NULL,
  `city_id` INT NOT NULL,
  `street_id` INT NOT NULL,
  `artist_id` INT NULL,
  `route_id` INT NULL,
  PRIMARY KEY (`id`, `city_id`, `street_id`),
  INDEX `fk_event_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_event_street1_idx` (`street_id` ASC) VISIBLE,
  INDEX `fk_event_artist1_idx` (`artist_id` ASC) VISIBLE,
  INDEX `fk_event_route1_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_event_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `martciv_maria`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_street1`
    FOREIGN KEY (`street_id`)
    REFERENCES `martciv_maria`.`street` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `martciv_maria`.`artist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `martciv_maria`.`route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`insurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`insurance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `days` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `martciv_maria`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `martciv_maria`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `place` INT NOT NULL,
  `price` INT NOT NULL,
  `user_id` INT NOT NULL,
  `delivery_id` INT NULL,
  `event_id` INT NOT NULL,
  `insurance_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `event_id`, `insurance_id`),
  INDEX `fk_ticket_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_ticket_delivery1_idx` (`delivery_id` ASC) VISIBLE,
  INDEX `fk_ticket_event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_ticket_insurance1_idx` (`insurance_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `martciv_maria`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_delivery1`
    FOREIGN KEY (`delivery_id`)
    REFERENCES `martciv_maria`.`delivery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `martciv_maria`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_insurance1`
    FOREIGN KEY (`insurance_id`)
    REFERENCES `martciv_maria`.`insurance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
