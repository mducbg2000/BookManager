CREATE SCHEMA `db_05` ;

CREATE TABLE `db_05`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `publisher` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `db_05`.`user` (
  `username` VARCHAR(40) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE USER IF NOT EXISTS test123@localhost
IDENTIFIED BY 'test123';

GRANT ALL ON db_05.* TO test123@localhost

