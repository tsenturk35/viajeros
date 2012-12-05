SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `viajeros` ;
CREATE SCHEMA IF NOT EXISTS `viajeros` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `viajeros` ;

-- -----------------------------------------------------
-- Table `viajeros`.`destn`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viajeros`.`destn` ;

CREATE  TABLE IF NOT EXISTS `viajeros`.`destn` (
  `destn_id` INT NOT NULL AUTO_INCREMENT ,
  `desc` VARCHAR(50) NOT NULL ,
  `lat` DOUBLE NULL ,
  `long` DOUBLE NULL ,
  PRIMARY KEY (`destn_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viajeros`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viajeros`.`client` ;

CREATE  TABLE IF NOT EXISTS `viajeros`.`client` (
  `client_id` INT NOT NULL ,
  `client_name` VARCHAR(45) NULL ,
  `address` VARCHAR(250) NULL ,
  PRIMARY KEY (`client_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viajeros`.`vehicle_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viajeros`.`vehicle_type` ;

CREATE  TABLE IF NOT EXISTS `viajeros`.`vehicle_type` (
  `vehicle_type_id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `capacity` INT NULL ,
  PRIMARY KEY (`vehicle_type_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viajeros`.`trans_rate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viajeros`.`trans_rate` ;

CREATE  TABLE IF NOT EXISTS `viajeros`.`trans_rate` (
  `trans_rate_id` INT NOT NULL AUTO_INCREMENT ,
  `src_id` INT NULL ,
  `dest_id` INT NULL ,
  `client_id` INT NULL ,
  `vehicle_typ_id` INT NULL DEFAULT 0 ,
  `amount` DOUBLE NULL DEFAULT 0 ,
  `last_up_dt` TIMESTAMP NULL ,
  `last_up_by` VARCHAR(45) NULL ,
  `created_dt` TIMESTAMP NULL ,
  `created_by` VARCHAR(45) NULL ,
  PRIMARY KEY (`trans_rate_id`) ,
  INDEX `fk_trans_rate_src` (`src_id` ASC) ,
  INDEX `fk_trans_rate_dest` (`dest_id` ASC) ,
  INDEX `fk_trans_rate_clientid` (`client_id` ASC) ,
  INDEX `fk_trans_rate_vtypid` (`vehicle_typ_id` ASC) ,
  CONSTRAINT `fk_trans_rate_src`
    FOREIGN KEY (`src_id` )
    REFERENCES `viajeros`.`destn` (`destn_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trans_rate_dest`
    FOREIGN KEY (`dest_id` )
    REFERENCES `viajeros`.`destn` (`destn_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trans_rate_clientid`
    FOREIGN KEY (`client_id` )
    REFERENCES `viajeros`.`client` (`client_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trans_rate_vtypid`
    FOREIGN KEY (`vehicle_typ_id` )
    REFERENCES `viajeros`.`vehicle_type` (`vehicle_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viajeros`.`deten_rate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viajeros`.`deten_rate` ;

CREATE  TABLE IF NOT EXISTS `viajeros`.`deten_rate` (
  `deten_rate_id` INT NOT NULL AUTO_INCREMENT ,
  `src_id` INT NULL ,
  `dest_id` INT NULL ,
  `client_id` INT NULL ,
  `vehicle_typ_id` INT NULL DEFAULT 0 ,
  `amount` DOUBLE NULL DEFAULT 0 ,
  `deten_days` INT NULL ,
  `last_up_dt` TIMESTAMP NULL ,
  `last_up_by` VARCHAR(45) NULL ,
  `created_dt` TIMESTAMP NULL ,
  `created_by` VARCHAR(45) NULL ,
  PRIMARY KEY (`deten_rate_id`) ,
  INDEX `fk_trans_rate_src` (`src_id` ASC) ,
  INDEX `fk_trans_rate_dest` (`dest_id` ASC) ,
  INDEX `fk_detn_rate_clientid` (`client_id` ASC) ,
  INDEX `fk_detn_rate_vtypid` (`vehicle_typ_id` ASC) ,
  CONSTRAINT `fk_dest_rate_src`
    FOREIGN KEY (`src_id` )
    REFERENCES `viajeros`.`destn` (`destn_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dest_rate_dest`
    FOREIGN KEY (`dest_id` )
    REFERENCES `viajeros`.`destn` (`destn_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detn_rate_clientid`
    FOREIGN KEY (`client_id` )
    REFERENCES `viajeros`.`client` (`client_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detn_rate_vtypid`
    FOREIGN KEY (`vehicle_typ_id` )
    REFERENCES `viajeros`.`vehicle_type` (`vehicle_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viajeros`.`invoice_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viajeros`.`invoice_detail` ;

CREATE  TABLE IF NOT EXISTS `viajeros`.`invoice_detail` (
  `invoice_id` INT NOT NULL ,
  `inv_dt` DATE NULL ,
  `veichle_no` VARCHAR(45) NULL ,
  `veichle_typ_id` INT NULL ,
  `delivery_dt` DATE NULL ,
  `lr_no` VARCHAR(45) NULL ,
  `deten_days` INT NULL ,
  `amount` DOUBLE NULL ,
  `created_by` VARCHAR(45) NULL ,
  `created_dt` TIMESTAMP NULL ,
  PRIMARY KEY (`invoice_id`) ,
  INDEX `fk_invdtl_vtypid` (`veichle_typ_id` ASC) ,
  CONSTRAINT `fk_invdtl_vtypid`
    FOREIGN KEY (`veichle_typ_id` )
    REFERENCES `viajeros`.`vehicle_type` (`vehicle_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------
--            create user
-- -----------------------------------------

-- CREATE USER 'viajeros'@'localhost' IDENTIFIED BY 'test123';
-- GRANT ALL ON viajeros.* TO 'viajeros'@'localhost';



