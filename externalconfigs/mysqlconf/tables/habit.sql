CREATE TABLE IF NOT EXISTS `mydb`.`habit` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `score` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB