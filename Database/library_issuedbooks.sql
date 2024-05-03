-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `issuedbooks`
--

DROP TABLE IF EXISTS `issuedbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issuedbooks` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(60) DEFAULT NULL,
  `Author` varchar(60) DEFAULT NULL,
  `Issued Date` date DEFAULT NULL,
  `Issued Time` time DEFAULT NULL,
  `Issued To` int(11) DEFAULT NULL,
  `Returned Date` date DEFAULT NULL,
  `Returned Time` time DEFAULT NULL,
  `Received By` int(11) DEFAULT NULL,
  `Issued By` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Issued By` (`Issued By`),
  KEY `Received By` (`Received By`),
  KEY `Issued To` (`Issued To`),
  CONSTRAINT `issuedbooks_ibfk_1` FOREIGN KEY (`Issued By`) REFERENCES `librarystuff` (`ID`),
  CONSTRAINT `issuedbooks_ibfk_2` FOREIGN KEY (`Received By`) REFERENCES `librarystuff` (`ID`),
  CONSTRAINT `issuedbooks_ibfk_3` FOREIGN KEY (`Issued To`) REFERENCES `librarymember` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuedbooks`
--

LOCK TABLES `issuedbooks` WRITE;
/*!40000 ALTER TABLE `issuedbooks` DISABLE KEYS */;
INSERT INTO `issuedbooks` VALUES (1,'DragonBall','Akira','2019-09-07','16:41:39',1,'2019-09-07','21:34:52',1,1),(2,'DragonBall','Akira','2019-09-07','17:39:08',1,NULL,NULL,1,1),(3,'a','a','2019-09-07','17:49:57',1,NULL,NULL,NULL,1),(4,'a','a','2019-09-07','18:16:09',1,NULL,NULL,NULL,1),(5,'a','a','2019-09-07','18:16:09',1,NULL,NULL,NULL,1),(6,'a','a','2019-09-07','18:16:09',1,NULL,NULL,NULL,1),(7,'a','a','2019-09-01','18:17:53',1,'2019-09-08','02:09:30',1,1),(8,'a','a','2019-09-07','18:17:53',1,NULL,NULL,NULL,1),(9,'a','a','2019-09-07','18:17:53',1,NULL,NULL,NULL,1),(10,'a','a','2019-09-07','18:50:51',1,NULL,NULL,NULL,1),(11,'a','a','2019-09-07','19:02:12',1,NULL,NULL,NULL,1),(12,'a','a','2019-09-07','19:02:12',1,NULL,NULL,NULL,1),(13,'a','a','2019-09-07','19:06:07',1,NULL,NULL,NULL,1),(15,'Dragon Ball Super','Akira','2019-09-12','15:08:44',10,NULL,NULL,NULL,3);
/*!40000 ALTER TABLE `issuedbooks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-18 17:14:28
