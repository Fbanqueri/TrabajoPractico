CREATE DATABASE pronosticos;
-- --------------------
USE pronosticos;
-- ---------------------
CREATE TABLE participante(
	idpart INT NOT NULL AUTO_INCREMENT,
    nombre CHAR(100) NOT NULL,
    PRIMARY KEY(idpart)
);
-- ----------------------
CREATE TABLE pronostico(
	equipo1 CHAR(100) NOT NULL,
    ganae1 CHAR,
    empate CHAR,
    ganae2 CHAR,
    equipo2 char(100) NOT NULL,
    idpart int,
    FOREIGN KEY(idpart)
		REFERENCES participante(idpart)
);
-- ------------------------
INSERT INTO participante (nombre) VALUES('Mariana');
INSERT INTO participante (nombre) VALUES('Pedro');
INSERT INTO participante (nombre) VALUES('Pepe');
-- ------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Argentina','X',null,null,'Arabia Saudita',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Polonia',null,'X',null,'MÃ©xico',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Argentina','X',null,null,'MÃ©xico',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Arabia Saudita','X',null,null,'Polonia',1);
-- -----------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Espana','X',NULL,NULL,'Peru',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Colombia',null,'X',NULL,'Uruguay',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Peru',NULL,null,'X','Colombia',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Uruguay','X',null,NULL,'Espana',1);
-- ------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('China',NULL,NULL,'X','Japon',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Bolivia','X',NULL,NULL,'Paraguay',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Japon',NULL,NULL,'X','Bolivia',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Paraguay',NULL,'X',NULL,'China',1);
-- -------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Portugal',NULL,NULL,'X','Brazil',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Canada',NULL,'X',NULL,'Rusia',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Brazil',NULL,NULL,'X','Canada',1);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Rusia','X',NULL,NULL,'Portugal',1);
-- --------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Argentina','X',null,null,'Arabia Saudita',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Polonia',null,null,'X','MÃ©xico',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Argentina','X',null,null,'MÃ©xico',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Arabia Saudita',null,'X',null,'Polonia',2);
-- -----------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Espana','X',NULL,NULL,'Peru',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Colombia',NULL,NULL,'X','Uruguay',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Peru',NULL,'X',NULL,'Colombia',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Uruguay',NULL,'X',NULL,'Espana',2);
-- ------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('China',NULL,'X',NULL,'Japon',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Bolivia','X',NULL,NULL,'Paraguay',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Japon',NULL,'X',NULL,'Bolivia',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Paraguay',null,NULL,'X','China',2);
-- -------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Portugal','X',NULL,NULL,'Brazil',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Canada',NULL,NULL,'X','Rusia',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Brazil',NULL,'X',NULL,'Canada',2);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Rusia','X',NULL,NULL,'Portugal',2);
-- ------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Argentina','X',null,null,'Arabia Saudita',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Polonia',null,'X',null,'MÃ©xico',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Argentina',null,null,'X','MÃ©xico',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Arabia Saudita','X',null,null,'Polonia',3);
-- -----------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Espana','X',NULL,NULL,'Peru',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Colombia',NULL,'X',NULL,'Uruguay',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Peru',NULL,NULL,'X','Colombia',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Uruguay','X',NULL,NULL,'Espana',3);
-- ------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('China',NULL,'X',NULL,'Japon',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Bolivia','X',NULL,NULL,'Paraguay',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Japon',NULL,NULL,'X','Bolivia',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Paraguay','X',NULL,NULL,'China',3);
-- -------------------------
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Portugal',NULL,'X',NULL,'Brazil',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Canada',NULL,NULL,'X','Rusia',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Brazil','X',NULL,NULL,'Canada',3);
INSERT INTO pronostico (equipo1,ganae1,empate,ganae2,equipo2,idpart) VALUES('Rusia',NULL,'X',NULL,'Portugal',3);