-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `viagem`
--

DROP TABLE IF EXISTS `viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viagem` (
  `idViagem` int(11) NOT NULL,
  `dataSolicitacao` varchar(45) DEFAULT NULL,
  `qtdPassageiros` varchar(45) DEFAULT NULL,
  `vlCustoEstadia` float DEFAULT NULL,
  `vlCustoEstVeiculo` float DEFAULT NULL,
  `veiculo` int(11) NOT NULL,
  `unidade` int(11) NOT NULL,
  `tipoDeslocamento` int(11) NOT NULL,
  `situacao` int(11) NOT NULL,
  `motorista` int(11) NOT NULL,
  PRIMARY KEY (`idViagem`),
  KEY `fk_Viagem_Veiculo_idx` (`veiculo`),
  KEY `fk_Viagem_Unidade1_idx` (`unidade`),
  KEY `fk_Viagem_TipoDeslocamento1_idx` (`tipoDeslocamento`),
  KEY `fk_Viagem_Situacao1_idx` (`situacao`),
  KEY `fk_Viagem_Motorista1_idx` (`motorista`),
  CONSTRAINT `fk_Viagem_Motorista1` FOREIGN KEY (`motorista`) REFERENCES `motorista` (`idMotorista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viagem_Situacao1` FOREIGN KEY (`situacao`) REFERENCES `situacao` (`idSituacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viagem_TipoDeslocamento1` FOREIGN KEY (`tipoDeslocamento`) REFERENCES `tipodeslocamento` (`idTipoDeslocamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viagem_Unidade1` FOREIGN KEY (`unidade`) REFERENCES `unidade` (`idUnidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Viagem_Veiculo` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`idVeiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viagem`
--

LOCK TABLES `viagem` WRITE;
/*!40000 ALTER TABLE `viagem` DISABLE KEYS */;
/*!40000 ALTER TABLE `viagem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02 20:16:22
