
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `viajeros` ;
CREATE SCHEMA IF NOT EXISTS `viajeros` DEFAULT CHARACTER SET utf8 ;
USE `viajeros` ;

-- -----------------------------------------------------
-- Table `viajeros`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viajeros`.`user` ;

CREATE  TABLE IF NOT EXISTS `viajeros`.`user` (
  `user_id` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  `first_name` VARCHAR(150) NULL DEFAULT NULL ,
  `last_name` VARCHAR(150) NULL DEFAULT NULL ,
  `role_id` INT(5) NULL DEFAULT NULL ,
  `email_id` VARCHAR(150) NULL DEFAULT NULL ,
  `last_login_time` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`user_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- **********************************************************
-- *************** Data population *************************

-- CREATE USER 'viajeros'@'localhost' IDENTIFIED BY 'test123';
-- GRANT ALL ON viajeros.* TO 'viajeros'@'localhost';

-- USER and Roles
INSERT INTO `viajeros`.`user` (`user_id`, `password`, `first_name`, `last_name`, `role_id`, `email_id`, `last_login_time`) VALUES ('ranjanr', 'test', 'Ritesh', 'Ranjan', 1, 'riteshranjan007@gmail.com', '2012-11-21 20:32:14.0');
INSERT INTO `viajeros`.`user` (`user_id`, `password`, `first_name`, `last_name`, `role_id`, `email_id`, `last_login_time`) VALUES ('sahas3', 'test', 'Deep', 'Saha', 1, 'test@gmail.com', '2012-11-21  05:43:43');
INSERT INTO `viajeros`.`user` (`user_id`, `password`, `first_name`, `last_name`, `role_id`, `email_id`, `last_login_time`) VALUES ('raij', 'test', 'Jainendra', 'Rai', 1, 'test@gmail.com', '2012-11-21  05:43:43');
