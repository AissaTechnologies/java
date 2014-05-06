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

/*INSERT INTO `anagrafica` VALUES (1,'Mario','Rossi','mat01','MMMRRR01M11R111R','2013-05-13','2013-04-01',2),(2,'Paolo','Bianchi','mat02','PPPBBB02P22B222B','2030-12-31','2029-12-31',2),(3,'Stefania','Verdi','mat03','SSSVVV03S33V333V','2015-11-08','2016-12-31',3),(4,'Anna','Parisi','mat04','AAAPPP04A44F444P','2013-01-16','2013-02-10',2),(5,'Francesco','Guerra','mat05','FFFGGG05F55G555G','2013-01-23','2013-02-08',2),(6,'Giovanna','Palmieri','mat06','GGGPPP06G66P666P','2013-03-03','2013-01-06',1),(7,'Sara','Salvi','mat07','SSSSSS07S77S777S','2013-04-19','2013-06-28',3),(8,'Roberto','Barbieri','mat08','RRRBBB08R88B888B','2013-08-08','2014-08-15',3);*/
INSERT INTO `anagrafica` VALUES (1,'Mario','Rossi','mat01','MMMRRR01M11R111R','2013-05-13','2013-04-01',2),(2,'Paolo','Bianchi','mat02','PPPBBB02P22B222B','2030-12-31','2029-12-31',2),(3,'Stefania','Verdi','mat03','SSSVVV03S33V333V','2015-11-08','2016-12-31',3),(4,'Anna','Parisi','mat04','AAAPPP04A44F444P','2013-01-16','2013-02-10',2),(5,'Francesco','Guerra','mat05','FFFGGG05F55G555G','2013-01-23','2013-02-08',2),(6,'Giovanna','Palmieri','mat06','GGGPPP06G66P666P','2013-03-03','2013-01-06',1),(7,'Sara','Salvi','mat07','SSSSSS07S77S777S','2013-04-19','2013-06-28',3),(8,'Roberto','Barbieri','mat08','RRRBBB08R88B888B','2013-08-08','2014-08-15',3);

/*PROFILO*/
CREATE TABLE `profilo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  `flag_tipo_profilo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `profilo` VALUES (1,'admin',1),(2,'dip',2),(3,'collab',3);

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

INSERT INTO `login` VALUES (1,'a','a','AAAAAA11A11A111A','admin',1),(2,'m','r','MMMRRR01M11R111R','dip',2),(3,'s','s','SSSSSS07S77S777S','collab',3);

/*FUNZIONE*/
CREATE TABLE `funzione` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codice` varchar(8) DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `path` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*INSERT INTO `funzione` VALUES (1,'LOGIN','Login','/login.action'),(2,'LOGOUT','Logout','/logout.action'),(3,'LISTPROF','Lista Profilo','/listProfilo.action'),(4,'INSPROF','Inserisci Profilo','/inserisciProfilo.action'),(5,'SALPROF','Salva Profilo','/salvaProfilo.action'),(6,'MODPROF','Modifica Profilo','/modificaProfilo.action'),(7,'AGGPROF','Aggiorna Profilo','/aggiornaProfilo.action'),(8,'CANCPROF','Cancella Profilo','/cancellaProfilo.action'),(9,'LISTFUNZ','Lista Funzione','/listaFunzione.action'),(10,'INSFUNZ','Inserisci Funzione','/inserisciFunzione.action'),(11,'SALFUNZ','Salva Funzione','/salvaFunzione.action'),(12,'MODFUNZ','Modifica Funzione','/modificaFunzione.action'),(13,'AGGFUNZ','Aggiorna Funzione','/aggiornaFunzione.action'),(14,'CANCFUNZ','Cancella Funzione','/cancellaFunzione.action'),(15,'LISTABIL','Lista Abilitazione','/listaAbilitazione.action'),(16,'INSABIL','Inserisci Abilitazione','/inserisciAbilitazione.action');*/
INSERT INTO `funzione` VALUES (1,'LOGIN','Login','/login.action'),(2,'LOGOUT','Logout','/logout.action'),(3,'LISTPROF','Lista Profilo','/listProfilo.action'),(4,'INSPROF','Inserisci Profilo','/inserisciProfilo.action'),(5,'SALPROF','Salva Profilo','/salvaProfilo.action'),(6,'MODPROF','Modifica Profilo','/modificaProfilo.action'),(7,'AGGPROF','Aggiorna Profilo','/aggiornaProfilo.action'),(8,'CANCPROF','Cancella Profilo','/cancellaProfilo.action'),(9,'LISTFUNZ','Lista Funzione','/listaFunzione.action'),(10,'INSFUNZ','Inserisci Funzione','/inserisciFunzione.action'),(11,'SALFUNZ','Salva Funzione','/salvaFunzione.action'),(12,'MODFUNZ','Modifica Funzione','/modificaFunzione.action'),(13,'AGGFUNZ','Aggiorna Funzione','/aggiornaFunzione.action'),(14,'CANCFUNZ','Cancella Funzione','/cancellaFunzione.action'),(15,'LISTABIL','Lista Abilitazione','/listaAbilitazione.action'),(16,'INSABIL','Inserisci Abilitazione','/inserisciAbilitazione.action');

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

/*INSERT INTO `abilitazione` VALUES (1,1,1,1),(2,1,2,1),(3,1,3,1),(4,1,NULL,1),(5,2,1,1),(6,2,2,1),(7,2,3,1),(8,2,NULL,1),(9,3,1,0),(10,4,1,1),(11,5,1,1),(12,6,1,1),(13,7,1,1),(14,8,1,1),(16,15,1,1);*/
INSERT INTO `abilitazione` VALUES (1,1,1,1),(2,1,2,1),(3,1,3,1),(4,2,1,1),(5,2,2,1),(6,2,3,1),(7,3,1,1),(8,3,2,1),(9,3,3,1),(10,4,1,1),(11,4,2,0),(12,4,3,0),(13,5,1,1),(14,5,2,0),(16,5,3,0),(17,6,1,1),(18,6,2,0),(19,6,3,0),(20,7,1,1),(21,7,2,0),(22,7,3,0),(23,8,1,1),(25,8,2,0),(26,8,3,0),(27,9,1,1),(28,9,2,1),(29,9,3,1),(30,10,1,1),(31,10,2,0),(32,10,3,0);
