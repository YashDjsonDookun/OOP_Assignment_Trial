-- MariaDB dump 10.19  Distrib 10.4.18-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: mentcare_trial
-- ------------------------------------------------------
-- Server version	10.4.18-MariaDB

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
-- Table structure for table `Patients`
--

DROP TABLE IF EXISTS `Patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Patients` (
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
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patients`
--

LOCK TABLES `Patients` WRITE;
/*!40000 ALTER TABLE `Patients` DISABLE KEYS */;
INSERT INTO `Patients` VALUES (1,'Yash Djson','Dookun','yash.dookun@email.com','Ave, Swami Vivekananda, Clairfonds No.3, Vacoas','1999-01-11',57522027,'MALE','Rick Sanchez','Brain Damage, Weight Loss','NONE','NO','25-03-2021 11:05:51'),(2,'Ervin','Howell','Shanna@melissa.tv','Victor Plains, Suite 987, Wisokyburgh','1997-09-11',51234567,'MALE','Deckow Crist','Diabetes','Insuline Shots','NO','25-03-2021 11:35:18'),(3,'Patricia','Lebsack','Julianne.OConner@kory.org','Hoeger Mall, Apt. 692, South Elvis','2000-08-07',51234567,'FEMALE','Robel Corkery','Deep Cut','Stiches','YES','25-03-2021 11:41:04'),(4,'Glenna','Reichert','Chaim_McDermott@dana.io','Dayna Park, Suite 449, Bartholomebury','1978-06-08',51254584,'FEMALE','Kattie Turnpike','GSW (Gun Shot Wound) to the chest','NONE','NO','25-03-2021 11:44:21'),(7,'Chelsey','Dietrich','Lucio_Hettinger@annie.ca','Skiles Walks, Suite 351, Roscoeview','1995-07-08',56325458,'FEMALE','Demarco Keebler','Mild Fever','NONE','NO','25-03-2021 11:52:41'),(8,'Nicholas','Runolfsdottir','Sherwood@rosamond.me','Ellsworth Summit, Suite 729, Aliyaview','1990-04-16',58645692,'MALE','jacynthe Abernathy','3rd Degree Burns','Plastic Surgery','NO','25-03-2021 13:04:13'),(9,'Dennis','Schulist','Karley_Dach@jasper.info','Norberto Crossing, Apt. 950, South Christy','1989-05-23',52530215,'FEMALE','Considine Lockman','-','-','NO','25-03-2021 13:06:09'),(10,'Clementine','Bauch','Nathan@yesenia.net','Douglas Extension, Suite 847, McKenziehaven','1992-12-05',59590415,'FEMALE','Samantha Jacobson','Hormonal Disbalance','NONE','NO','25-03-2021 13:11:20'),(11,'Karianne','Corkery','kale@Romaguera.com','8, Shoshone Alley, Tennessee','1993-07-29',56968654,'FEMALE','Mariana Joly','-','-','YES','25-03-2021 14:31:18'),(12,'Adolf','Hitler','adolf@hitler.com','Führerbunker, Berlin, Germany','1889-04-20',57777777,'MALE','Nazi Braun','Asphyxia','NONE','YES','27-03-2021 10:39:15');
/*!40000 ALTER TABLE `Patients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-27 10:46:42
