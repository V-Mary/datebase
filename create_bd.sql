-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab7
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab7
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab7` DEFAULT CHARACTER SET utf8 ;
USE `lab7` ;

-- -----------------------------------------------------
-- Table `lab7`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab7`.`student` (
  `id_student` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `rating` INT NOT NULL,
  `birthday` DATE NOT NULL,
  `date_admission` DATE NOT NULL,
  `student_number` INT NOT NULL,
  `id_city` INT NOT NULL,
  `id_group` INT NOT NULL,
  `id_school` INT NOT NULL,
  PRIMARY KEY (`id_student`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab7`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab7`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  `year` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab7`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab7`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  `id_region` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab7`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab7`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(45) NOT NULL,
  `code` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab7`.`school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab7`.`school` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_school` VARCHAR(45) NOT NULL,
  `name_director` VARCHAR(45) NOT NULL,
  `phone_number` INT NOT NULL,
  `id_city` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab7`.`debt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab7`.`debt` (
  `id_debt` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_debt`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab7`.`student_debt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab7`.`student_debt` (
  `id_student` INT NOT NULL,
  `id_debt` INT NOT NULL,
  PRIMARY KEY (`id_student`, `id_debt`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
