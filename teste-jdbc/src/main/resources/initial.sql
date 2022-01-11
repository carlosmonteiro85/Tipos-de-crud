
CREATE DATABASE IF NOT EXISTS `teste-jdbc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


CREATE TABLE IF NOT EXISTS `teste-jdbc`.aluno (
	id bigint(100) auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	idade bigint(200) NULL,
	estado varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
