-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema notes_database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema notes_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `notes_database` DEFAULT CHARACTER SET utf8 ;
USE `notes_database` ;

-- -----------------------------------------------------
-- Table `notes_database`.`sub_topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`sub_topic` (
  `sub_topic_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sub_topic_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`sub_topic_id`),
  UNIQUE INDEX `sub_topic_name_UNIQUE` (`sub_topic_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`topic` (
  `topic_id` INT(11) NOT NULL AUTO_INCREMENT,
  `topic_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`topic_id`),
  UNIQUE INDEX `topic_name_UNIQUE` (`topic_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`file`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`file` (
  `file_id` INT(11) NOT NULL AUTO_INCREMENT,
  `topic_id` INT(11) NOT NULL,
  `sub_topic_id` INT(11) NOT NULL,
  `file_path` VARCHAR(500) NOT NULL,
  `file_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`file_id`),
  INDEX `file_topic_id_idx` (`topic_id` ASC),
  INDEX `FK_file_sub_topic_id_idx` (`sub_topic_id` ASC),
  CONSTRAINT `FK_file_sub_topic_id`
    FOREIGN KEY (`sub_topic_id`)
    REFERENCES `notes_database`.`sub_topic` (`sub_topic_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_file_topic_id`
    FOREIGN KEY (`topic_id`)
    REFERENCES `notes_database`.`topic` (`topic_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`gamer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`gamer` (
  `gamer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `gamer_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`gamer_id`),
  UNIQUE INDEX `gamer_id_UNIQUE` (`gamer_id` ASC),
  UNIQUE INDEX `gamer_name_UNIQUE` (`gamer_name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`group` (
  `group_id` INT(11) NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`group_id`),
  UNIQUE INDEX `group_name_UNIQUE` (`group_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`gamer_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`gamer_group` (
  `group_id` INT(11) NOT NULL,
  `gamer_id` INT(11) NOT NULL,
  `gamer_group_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`gamer_group_id`),
  INDEX `FK_gamer_group_id_idx` (`gamer_id` ASC),
  INDEX `FK_group_gamer_id` (`group_id` ASC),
  CONSTRAINT `FK_gamer_group_id`
    FOREIGN KEY (`gamer_id`)
    REFERENCES `notes_database`.`gamer` (`gamer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_group_gamer_id`
    FOREIGN KEY (`group_id`)
    REFERENCES `notes_database`.`group` (`group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`leaks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`leaks` (
  `leaks_id` INT(11) NOT NULL AUTO_INCREMENT,
  `leaks_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`leaks_id`),
  UNIQUE INDEX `leaks_name_UNIQUE` (`leaks_name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`gamer_leaks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`gamer_leaks` (
  `gamer_leaks_id` INT(11) NOT NULL AUTO_INCREMENT,
  `gamer_id` INT(11) NOT NULL,
  `leaks_id` INT(11) NOT NULL,
  PRIMARY KEY (`gamer_leaks_id`),
  INDEX `FK_gamer_leaks_idx` (`gamer_id` ASC),
  INDEX `FK_leaks_idx` (`leaks_id` ASC),
  CONSTRAINT `FK_gamer_leaks`
    FOREIGN KEY (`gamer_id`)
    REFERENCES `notes_database`.`gamer` (`gamer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_leaks`
    FOREIGN KEY (`leaks_id`)
    REFERENCES `notes_database`.`leaks` (`leaks_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`gamer_picture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`gamer_picture` (
  `picture_id` INT(11) NOT NULL AUTO_INCREMENT,
  `gamer_id` INT(11) NOT NULL,
  `picture_link` LONGBLOB NOT NULL,
  PRIMARY KEY (`picture_id`),
  INDEX `FK_gamer_picture_id_idx` (`gamer_id` ASC),
  INDEX `INDEX_gamer_id` (`gamer_id` ASC),
  CONSTRAINT `FK_gamer_picture_id`
    FOREIGN KEY (`gamer_id`)
    REFERENCES `notes_database`.`gamer` (`gamer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 44
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`last_searched_gamers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`last_searched_gamers` (
  `last_searched_gamers_id` INT(11) NOT NULL AUTO_INCREMENT,
  `gamer_id` INT(11) NOT NULL,
  PRIMARY KEY (`last_searched_gamers_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 74
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `notes_database`.`notes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notes_database`.`notes` (
  `note_id` INT(11) NOT NULL AUTO_INCREMENT,
  `gamer_id` INT(11) NOT NULL,
  `note` VARCHAR(5000) NOT NULL,
  PRIMARY KEY (`note_id`),
  INDEX `FK_note_gamer_id_idx` (`gamer_id` ASC),
  CONSTRAINT `FK_note_gamer_id`
    FOREIGN KEY (`gamer_id`)
    REFERENCES `notes_database`.`gamer` (`gamer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = utf8;

USE `notes_database` ;

-- -----------------------------------------------------
-- procedure insert_gamer
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_gamer`(in gamer_name varchar(100))
BEGIN
insert into notes_database.gamer(gamer_name) 
values (gamer_name);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_gamer_leak
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_gamer_leak`(in leaks_id int,in gamer_id int)
BEGIN
insert into notes_database.gamer_leaks(leaks_id,gamer_id) 
values (leaks_id,gamer_id);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_last_searched_id
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_last_searched_id`(in gamer_id int)
BEGIN
insert into notes_database.last_searched_gamers(gamer_id) 
values (gamer_id);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_leak
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_leak`(in leaks_name varchar(100))
BEGIN
insert into notes_database.leaks(leaks_name) 
values (leaks_name);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_note
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_note`(in gamer_id int, in note varchar(5000))
BEGIN
insert into notes_database.notes(gamer_id, note) 
values (gamer_id, note);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_picture
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_picture`(in gamer_id int, in picture_link LONGBLOB)
BEGIN
insert into notes_database.gamer_picture(gamer_id, picture_link) 
values (gamer_id, picture_link);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_sub_topic
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_sub_topic`(in sub_topic_name varchar(255))
BEGIN
insert into notes_database.sub_topic(sub_topic_name) 
values (sub_topic_name);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_topic
-- -----------------------------------------------------

DELIMITER $$
USE `notes_database`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_topic`(in topic_name varchar(255))
BEGIN
insert into notes_database.topic(topic_name) 
values (topic_name);
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
