-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hometutors
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hometutors
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hometutors` DEFAULT CHARACTER SET latin1 ;
USE `hometutors` ;

-- -----------------------------------------------------
-- Table `hometutors`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hometutors`.`professor` (
  `prid` INT(11) NOT NULL AUTO_INCREMENT,
  `secretcode` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `profession` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`prid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hometutors`.`profads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hometutors`.`profads` (
  `pid` INT(11) NOT NULL AUTO_INCREMENT,
  `reviewcode` VARCHAR(45) NOT NULL,
  `information` VARCHAR(255) NOT NULL,
  `professor_prid` INT(11) NOT NULL,
  PRIMARY KEY (`pid`),
  INDEX `fk_profads_professor1_idx` (`professor_prid` ASC),
  CONSTRAINT `fk_profads_professor1`
    FOREIGN KEY (`professor_prid`)
    REFERENCES `hometutors`.`professor` (`prid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hometutors`.`reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hometutors`.`reviews` (
  `rid` INT(11) NOT NULL AUTO_INCREMENT,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stars` INT(11) NOT NULL,
  `evaluation` VARCHAR(255) NOT NULL,
  `profads_pid` INT(11) NOT NULL,
  PRIMARY KEY (`rid`),
  INDEX `fk_reviews_profads_idx` (`profads_pid` ASC),
  CONSTRAINT `fk_reviews_profads`
    FOREIGN KEY (`profads_pid`)
    REFERENCES `hometutors`.`profads` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
