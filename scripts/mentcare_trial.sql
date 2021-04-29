-- MariaDB dump 10.17  Distrib 10.4.13-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: mentcare_trial
-- ------------------------------------------------------
-- Server version	10.4.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrators`
--

DROP TABLE IF EXISTS `administrators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrators` (
  `adminID` int(11) NOT NULL,
  `firstName` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DOB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` int(8) NOT NULL,
  `clearance_level` int(1) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrators`
--

LOCK TABLES `administrators` WRITE;
/*!40000 ALTER TABLE `administrators` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors` (
  `doctorID` int(11) NOT NULL,
  `firstName` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DOB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` int(8) NOT NULL,
  `category` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `clearance_level` int(1) NOT NULL,
  PRIMARY KEY (`doctorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1810111,'Will','Kingsbury','wkingsbury3@oaic.gov.au','2020-11-13','MALE','633, Ridge Oak Road, Burghill',4942281,'TEAM_DOCTOR, QUALIFIED_DOCTOR',2),(3030303,'Allison','Ammer','aammert@google.com.au','2020-09-20','FEMALE','9 1st Plaza',58421697,'HOSPITAL_DOCTOR, CONSULTANT',0),(9696969,'Junie','Cashmore','jcashmore2n@ehow.com','2020-10-09','FEMALE','08539 Prentice Crossing',4421085,'GENERAL_PRACTITIONER',1);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicalreceptionists`
--

DROP TABLE IF EXISTS `medicalreceptionists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicalreceptionists` (
  `medicReceptionistID` int(11) NOT NULL,
  `firstName` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DOB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` int(8) NOT NULL,
  `clearance_level` tinyint(1) NOT NULL,
  PRIMARY KEY (`medicReceptionistID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalreceptionists`
--

LOCK TABLES `medicalreceptionists` WRITE;
/*!40000 ALTER TABLE `medicalreceptionists` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicalreceptionists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `DOB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `phoneNumber` int(8) NOT NULL,
  `gender` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `assignedDoctor` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `conditions` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `treatments` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `selfHarm_Violence` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `dateRegistered` varchar(19) COLLATE utf8_unicode_ci NOT NULL,
  `lastConsultation` varchar(19) COLLATE utf8_unicode_ci NOT NULL,
  `vip` tinyint(1) NOT NULL,
  `classified` tinyint(1) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (14,'Mickey','Mouse','Mickey@Mouse.com','Miska Moska House, MickeyLand','2011-12-13',99999999,'MALE','Dr. Kingsbury, Will','Fever','Panadol','NO','28-04-2021 21:10:51','28-04-2021 21:10:51',0,0),(15,'Christina','Seale','cseale2w@comsenz.com','6 David, Parkway, Lorianna','1996-02-18',56428479,'FEMALE','Dr. Cashmore, Junie','Brain Damage','NONE','NO','28-04-2021 21:27:27','28-04-2021 21:27:27',0,0),(16,'Sissy','Haddinton','shaddinton3i@mediafire.com','11791 Rieder Circle','1972-11-18',90643681,'MALE','Dr. Kingsbury, Will','Gun Wound','Surgery','YES','28-04-2021 21:34:44','28-04-2021 21:34:44',1,0),(17,'Trever','Hoofe','thoofe3x@bluehost.com','9253 Pleasure Trail','1992-06-22',91009058,'MALE','Dr. Cashmore, Junie','3rd Degree Burn','Surgery','NO','28-04-2021 21:44:07','28-04-2021 21:44:07',1,1),(18,'Alicea','Dorber','adorber62@alibaba.com','819 Lien Trail','1986-10-31',51328652,'FEMALE','Dr. Kingsbury, Will','Stressed','NONE','NO','29-04-2021 09:05:21','29-04-2021 09:05:21',0,0),(19,'Sheila','Agneau','sagneau6h@hubpages.com','5478 Randy Crossing','2020-08-20',59612099,'MALE','Dr. Cashmore, Junie','Rash','Ointment','NO','29-04-2021 09:16:40','29-04-2021 09:16:40',0,0);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29 14:44:34
