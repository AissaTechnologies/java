CREATE DATABASE IF NOT EXISTS `aissatech`;
USE aissatech;

/*ANAGRAFICA*/
CREATE TABLE `anagrafica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `matricola` varchar(8) DEFAULT NULL,
  `codice_fiscale` varchar(16) NOT NULL,
  `data_validita` date DEFAULT NULL,
  `data_scadenza` date DEFAULT NULL,
  `flag_tipo_collab` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codice_fiscale_UNIQUE` (`codice_fiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `anagrafica` VALUES (1,'Camelia','Boban','77777','BBNCML65M49Z129H','2013-05-13',NULL,3),(2,'Pamela','Salvatori','5545','SLVPML82W54Q331P','2999-12-31','2999-12-31',2);

/*PROFILO*/
CREATE TABLE `profilo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  `flag_tipo_profilo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `profilo` VALUES (1,'admin',1),(2,'autor',2),(3,'user',3),(4,'guest',4);

/*LOGIN*/
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `codice_fiscale` varchar(16) DEFAULT NULL,
  `descrizione` varchar(100) DEFAULT NULL,
  `id_profilo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_login_profilo_idx` (`id_profilo`),
  CONSTRAINT `fk_login_profilo` FOREIGN KEY (`id_profilo`) REFERENCES `profilo` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `login` VALUES (1,'a','a','AAAAAA11A11A111A','admin',1),(2,'camelia','boban','BBNCML65M49Z129H','collab',3),(3,'pamela','salvatori','SLVPML82W54Q331P','dip',2);

/*FUNZIONE*/
CREATE TABLE `funzione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codice` varchar(8) DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `path` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* ABILITAZIONE*/
CREATE TABLE `abilitazione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_funzione` int(11) DEFAULT NULL,
  `id_profilo` int(11) DEFAULT NULL,
  `abilitato` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_abilitazione_profilo_idx` (`id_profilo`),
  KEY `fk_abilitazione_funzione_idx` (`id_funzione`),
  CONSTRAINT `fk_abilitazione_funzione` FOREIGN KEY (`id_funzione`) REFERENCES `funzione` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_abilitazione_profilo` FOREIGN KEY (`id_profilo`) REFERENCES `profilo` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
