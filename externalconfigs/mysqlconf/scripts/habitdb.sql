-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema habitdb
-- -----------------------------------------------------
-- This is database for habit application

-- -----------------------------------------------------
-- Schema habitdb
--
-- This is database for habit application
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `habitdb` DEFAULT CHARACTER SET utf8 ;
USE `habitdb` ;

-- -----------------------------------------------------
-- Table `habitdb`.`habit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habitdb`.`habit` (
  `idhabit` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `score` INT NULL,
  PRIMARY KEY (`idhabit`),
  UNIQUE INDEX `idhabit_UNIQUE` (`idhabit` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habitdb`.`users` (
  `idusers` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL,
  `secondname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `score` INT NULL,
  `habit_idhabit` INT UNSIGNED NOT NULL,
  `password` BINARY(64) NOT NULL,
  PRIMARY KEY (`idusers`, `habit_idhabit`),
  UNIQUE INDEX `idusers_UNIQUE` (`idusers` ASC),
  INDEX `fk_users_habit_idx` (`habit_idhabit` ASC),
  CONSTRAINT `fk_users_habit`
    FOREIGN KEY (`habit_idhabit`)
    REFERENCES `habitdb`.`habit` (`idhabit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
