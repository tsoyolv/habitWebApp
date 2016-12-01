-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema habitdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema habitdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `habitdb` DEFAULT CHARACTER SET utf8 ;
USE `habitdb` ;

-- -----------------------------------------------------
-- Table `habitdb`.`habit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habitdb`.`habit` (
  `idhabit` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `score` INT NULL,
  PRIMARY KEY (`idhabit`),
  UNIQUE INDEX `idhabit_UNIQUE` (`idhabit` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habitdb`.`user` (
  `iduser` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `second_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `score` INT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitdb`.`habit_to_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habitdb`.`habit_to_user` (
  `idhabit_to_user` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `habit_idhabit` INT UNSIGNED NOT NULL,
  `user_iduser` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idhabit_to_user`, `habit_idhabit`, `user_iduser`),
  INDEX `fk_habit_to_user_habit_idx` (`habit_idhabit` ASC),
  INDEX `fk_habit_to_user_user1_idx` (`user_iduser` ASC),
  CONSTRAINT `fk_habit_to_user_habit`
    FOREIGN KEY (`habit_idhabit`)
    REFERENCES `habitdb`.`habit` (`idhabit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_habit_to_user_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `habitdb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
