-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema school
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema school
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `school` DEFAULT CHARACTER SET utf8 ;
USE `school` ;

-- -----------------------------------------------------
-- Table `school`.`addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school`.`addresses` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `street` VARCHAR(100) NOT NULL,
  `number` INT(11) NOT NULL,
  `floor` INT(11) NULL DEFAULT NULL,
  `apartment_no` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school`.`disciplines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school`.`disciplines` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school`.`students` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `enrollment_date` DATE NOT NULL,
  `address_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_address_id_idx` (`address_id` ASC),
  CONSTRAINT `FK_address_student_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `school`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school`.`disciplines_studied`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school`.`disciplines_studied` (
  `student_id` INT(11) NOT NULL,
  `discipline_id` INT(11) NOT NULL,
  PRIMARY KEY (`student_id`, `discipline_id`),
  INDEX `FK_discipline_id_idx` (`discipline_id` ASC),
  CONSTRAINT `FK_discipline_id`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `school`.`disciplines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `school`.`students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school`.`teachers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `salary` DECIMAL(10,0) NOT NULL,
  `address_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_address_id_idx` (`address_id` ASC),
  CONSTRAINT `FK_address_teacher_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `school`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school`.`disciplines_taught`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school`.`disciplines_taught` (
  `teacher_id` INT(11) NOT NULL,
  `discipline_id` INT(11) NOT NULL,
  PRIMARY KEY (`discipline_id`, `teacher_id`),
  INDEX `FK_teacher_id_idx` (`teacher_id` ASC),
  CONSTRAINT `FK_teacher_discipline_id`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `school`.`disciplines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_teacher_id`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `school`.`teachers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
