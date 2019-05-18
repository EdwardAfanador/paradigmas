-- MySQL Workbench Forward Engineering
 drop database mydb;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Banco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Banco` (
  `ID_Banco` VARCHAR(60) NOT NULL,
  `Nombre_Banco` VARCHAR(45) NOT NULL,
  `Telefono_Banco` INT NOT NULL,
  `Url_Banco` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Banco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Arrendador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Arrendador` (
  `ID_Arrendador` VARCHAR(60) NOT NULL,
  `Nombre_Arrendador` VARCHAR(45) NOT NULL,
  `Apellido_Arrendador` VARCHAR(45) NOT NULL,
  `Numero_Arrendador` double NOT NULL,
  PRIMARY KEY (`ID_Arrendador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estudiante` (
  `ID_Estudiante` VARCHAR(45) NOT NULL,
  `Nombre_Estudiante` VARCHAR(60) NOT NULL,
  `Apellido_Estudiante` VARCHAR(60) NOT NULL,
  `Edad_Estudiante` INT NOT NULL,
  `Numero_Telefono` INT NOT NULL,
  `FK_ID_Arrendador` VARCHAR(60),
  `Universidad_Estudiante` VARCHAR(60) NOT NULL,
  `Pais_Estudiante` VARCHAR(60) NOT NULL,
  `Fecha_Ingreso` DATETIME,
  `Fecha_Salida` DATETIME,
  PRIMARY KEY (`ID_Estudiante`),
  
  CONSTRAINT `FK_Estudiante_Arrendador`
    FOREIGN KEY (`FK_ID_Arrendador`)
    REFERENCES `mydb`.`Arrendador` (`ID_Arrendador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pagos` (
  `ID_Pagos` VARCHAR(60) NOT NULL,
  `Cantidad` DOUBLE NOT NULL,
  `FK_ID_Banco` VARCHAR(60) NOT NULL,
  `Fecha_Pagos` VARCHAR(45) NOT NULL,
  `FK_ID_Estudiante` VARCHAR(45) NOT NULL,
  `Tarjeta_Credito` INT NOT NULL,
  PRIMARY KEY (`ID_Pagos`),
  CONSTRAINT `fk_Pagos_Banco`
    FOREIGN KEY (`FK_ID_Banco`)
    REFERENCES `mydb`.`Banco` (`ID_Banco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pagos_Estudiante`
    FOREIGN KEY (`FK_ID_Estudiante`)
    REFERENCES `mydb`.`Estudiante` (`ID_Estudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vivienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vivienda` (
  `ID_Vivienda` VARCHAR(45) NOT NULL,
  `Tipo_Vivienda` VARCHAR(45) NOT NULL,
  `Direccion_Vivienda` VARCHAR(45) NOT NULL,
  `Costo_Vivienda` DOUBLE NOT NULL,
  `Descripcion_Vivienda` VARCHAR(250) NOT NULL,
  `FK_ID_Arrendador` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`ID_Vivienda`),
  CONSTRAINT `fk_Vivienda_Arrendador1`
    FOREIGN KEY (`FK_ID_Arrendador`)
    REFERENCES `mydb`.`Arrendador` (`ID_Arrendador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Eventos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Eventos` (
  `ID_Eventos` VARCHAR(45) NOT NULL,
  `Ubicacion_Eventos` VARCHAR(45) NOT NULL,
  `Hora_Eventos` VARCHAR(45) NOT NULL,
  `Fecha_Eventos` VARCHAR(45) NOT NULL,
  `Descripcion_Eventos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Eventos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Eventos_has_Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Eventos_has_Estudiante` (
  `Eventos_ID_Eventos` VARCHAR(45) NOT NULL,
  `Estudiante_ID_Estudiante` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Eventos_ID_Eventos`, `Estudiante_ID_Estudiante`),
  CONSTRAINT `fk_Eventos_has_Estudiante_Eventos1`
    FOREIGN KEY (`Eventos_ID_Eventos`)
    REFERENCES `mydb`.`Eventos` (`ID_Eventos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Eventos_has_Estudiante_Estudiante1`
    FOREIGN KEY (`Estudiante_ID_Estudiante`)
    REFERENCES `mydb`.`Estudiante` (`ID_Estudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Comentarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Comentarios` (
  `ID_Comentarios` VARCHAR(45) NOT NULL,
  `Descripcion_Comentarios` VARCHAR(80) NOT NULL,
  `Estudiante_Comentarios` VARCHAR(60) NOT NULL,
  `FK_ID_Estudiante` VARCHAR(45) NOT NULL,
  `FK_ID_Vivienda` VARCHAR(45) NOT NULL,
  `Calificacion_Vivienda` DOUBLE NOT NULL,
  PRIMARY KEY (`ID_Comentarios`),
  CONSTRAINT `fk_Comentarios_Estudiante1`
    FOREIGN KEY (`FK_ID_Estudiante`)
    REFERENCES `mydb`.`Estudiante` (`ID_Estudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentarios_Vivienda1`
    FOREIGN KEY (`FK_ID_Vivienda`)
    REFERENCES `mydb`.`Vivienda` (`ID_Vivienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`login` (
  `Tipo_Usuario` VARCHAR(45) NOT NULL,
  `ID_Arrendador` VARCHAR(60),
  `ID_Estudiante` VARCHAR(45),
  `Usuario` VARCHAR(45) NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Usuario`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
