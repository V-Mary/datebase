-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tickets
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tickets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tickets` DEFAULT CHARACTER SET utf8 ;
USE `tickets` ;

-- -----------------------------------------------------
-- Table `tickets`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `ordered_tickets` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`route` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from` VARCHAR(45) NOT NULL,
  `to` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`artist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`artist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `all_places` INT NOT NULL,
  `free_places` INT NULL,
  `route_id` INT NOT NULL,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`id`, `route_id`, `artist_id`),
  INDEX `fk_event_route1_idx` (`route_id` ASC) VISIBLE,
  INDEX `fk_event_artist1_idx` (`artist_id` ASC) VISIBLE,
  CONSTRAINT `fk_event_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `tickets`.`route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `tickets`.`artist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`insurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`insurance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `days` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`delivery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `place` INT NOT NULL,
  `price` INT NOT NULL,
  `event_id` INT NOT NULL,
  `insurance_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `delivery_id` INT NOT NULL,
  PRIMARY KEY (`id`, `event_id`, `insurance_id`, `user_id`, `delivery_id`),
  INDEX `fk_ticket_event_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_ticket_insurance1_idx` (`insurance_id` ASC) VISIBLE,
  INDEX `fk_ticket_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_ticket_delivery1_idx` (`delivery_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_event`
    FOREIGN KEY (`event_id`)
    REFERENCES `tickets`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_insurance1`
    FOREIGN KEY (`insurance_id`)
    REFERENCES `tickets`.`insurance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tickets`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_delivery1`
    FOREIGN KEY (`delivery_id`)
    REFERENCES `tickets`.`delivery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
