CREATE DATABASE  IF NOT EXISTS `quiz_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quiz_db`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz_db
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `opt1` varchar(100) NOT NULL,
  `opt2` varchar(100) NOT NULL,
  `opt3` varchar(100) NOT NULL,
  `opt4` varchar(100) NOT NULL,
  `correct_options` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Which keyword is used to define a constant in java?','static','const','final','fixed','3'),(2,'Which loop execute at least once?','for','while','do-while',' nested for','3'),(3,'Which data structure follows the LIFO principle?','Queue','Stack','Tree','Graph','2'),(4,'Which data structure is used in BFS?','Stack','Queue','Array','Heap','2'),(5,'Which SQL command retrieves data from a database?','INSERT','UPDATE','SELECT','DELETE','3'),(6,'Which of the following is an operating system?','Linux','Oracle','Java','HTML','1'),(7,'Which protocol is commonly used to access web pages securely?','HTTP','FTP','HTTPS','SMTP','3'),(8,'Which language is also known as markup language','Java','Python','C','HTML','4'),(9,'Which keyword refers to the current object in Java?','super','this','self','current','2'),(10,'Which keyword is used to define a constant in java?','static','const','final','fixed','3'),(11,'Which loop execute at least once?','for','while','do-while',' nested for','3'),(12,'Which data structure follows the LIFO principle?','Queue','Stack','Tree','Graph','2'),(13,'Which of these is a non-primitive data type in java?','char','float','boolean','array','4'),(14,'Which data structure is used in BFS?','Stack','Queue','Array','Heap','2'),(15,'Which SQL command retrieves data from a database?','INSERT','UPDATE','SELECT','DELETE','3'),(16,'Which of the following is an operating system?','Linux','Oracle','Java','HTML','1'),(17,'Which protocol is commonly used to access web pages securely?','HTTP','FTP','HTTPS','SMTP','3'),(18,'Which language is also known as markup language','Java','Python','C','HTML','4'),(19,'Which keyword refers to the current object in Java?','super','this','self','current','2'),(20,'Which keyword is used to define a constant in java?','static','const','final','fixed','3'),(21,'Which loop execute at least once?','for','while','do-while',' nested for','3'),(22,'Which data structure follows the LIFO principle?','Queue','Stack','Tree','Graph','2'),(23,'Which of these is a non-primitive data type in java?','char','float','boolean','array','4'),(24,'Which data structure is used in BFS?','Stack','Queue','Array','Heap','2'),(25,'Which SQL command retrieves data from a database?','INSERT','UPDATE','SELECT','DELETE','3'),(26,'Which of the following is an operating system?','Linux','Oracle','Java','HTML','1'),(27,'Which protocol is commonly used to access web pages securely?','HTTP','FTP','HTTPS','SMTP','3'),(28,'Which language is also known as markup language','Java','Python','C','HTML','4'),(29,'Which keyword refers to the current object in Java?','super','this','self','current','2'),(30,'Which keyword is used to define a constant in java?','static','const','final','fixed','3'),(31,'Which loop execute at least once?','for','while','do-while',' nested for','3'),(32,'Which data structure follows the LIFO principle?','Queue','Stack','Tree','Graph','2'),(33,'Which of these is a non-primitive data type in java?','char','float','boolean','array','4'),(34,'Which data structure is used in BFS?','Stack','Queue','Array','Heap','2'),(35,'Which SQL command retrieves data from a database?','INSERT','UPDATE','SELECT','DELETE','3'),(36,'Which of the following is an operating system?','Linux','Oracle','Java','HTML','1'),(37,'Which protocol is commonly used to access web pages securely?','HTTP','FTP','HTTPS','SMTP','3'),(38,'Which language is also known as markup language','Java','Python','C','HTML','4'),(39,'Which keyword refers to the current object in Java?','super','this','self','current','2'),(40,'Which keyword is used to define a constant in java?','static','const','final','fixed','3'),(41,'Which loop execute at least once?','for','while','do-while',' nested for','3'),(42,'Which data structure follows the LIFO principle?','Queue','Stack','Tree','Graph','2'),(43,'Which of these is a non-primitive data type in java?','char','float','boolean','array','4'),(44,'Which data structure is used in BFS?','Stack','Queue','Array','Heap','2'),(45,'Which SQL command retrieves data from a database?','INSERT','UPDATE','SELECT','DELETE','3'),(46,'Which of the following is an operating system?','Linux','Oracle','Java','HTML','1'),(47,'Which protocol is commonly used to access web pages securely?','HTTP','FTP','HTTPS','SMTP','3'),(48,'Which language is also known as markup language','Java','Python','C','HTML','4'),(49,'Which keyword refers to the current object in Java?','super','this','self','current','2'),(50,'Which keyword is used to define a constant in java?','static','const','final','fixed','3'),(51,'Which loop execute at least once?','for','while','do-while',' nested for','3'),(52,'Which data structure follows the LIFO principle?','Queue','Stack','Tree','Graph','2'),(53,'Which data structure is used in BFS?','Stack','Queue','Array','Heap','2'),(54,'Which SQL command retrieves data from a database?','INSERT','UPDATE','SELECT','DELETE','3'),(55,'Which of the following is an operating system?','Linux','Oracle','Java','HTML','1'),(56,'Which protocol is commonly used to access web pages securely?','HTTP','FTP','HTTPS','SMTP','3'),(57,'Which language is also known as markup language','Java','Python','C','HTML','4'),(58,'Which keyword refers to the current object in Java?','super','this','self','current','2'),(59,'Which are OOP concepts?','Inheritance','Encapsulation','Compilation','Polymorphism','1,2,4'),(60,'Which are Java access modifiers?','public','private','protected','static','1,2,3'),(61,'Which can be inherited from a parent class?','Methods','Variables','Constructors','Properties','1,2,4'),(62,'Which are types of polymorphism?','Method overloading','Method overriding','Inheritance','Compilation','1,2'),(63,'Which are features of a constructor?','Same name as class','No return type','Called when object is created','Must be static','1,2,3'),(64,'Which keywords are used in inheritance?','extends','super','implements','private','1,2,3'),(65,'Which are benefits of encapsulation?','Data hiding','Security','Code reuse','Controlled access','1,2,4'),(66,'Which can be members of a class?','Variables','Methods','Constructors','Packages','1,2,3'),(67,'Which are used to achieve abstraction?','Abstract class','Interface','Constructor','Abstract method','1,2,4'),(68,'Which are examples of OOP languages?','Java','C++','Python','HTML','1,2,3');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `score` decimal(5,2) NOT NULL,
  `total` int NOT NULL,
  `taken_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `results_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (1,1,6.00,9,'2026-10-21 12:18:54'),(2,2,3.00,10,'2026-10-21 12:22:46'),(3,1,5.00,10,'2026-10-21 12:25:28'),(4,1,7.00,10,'2026-10-21 12:36:05'),(5,1,7.00,10,'2026-10-21 13:33:02'),(6,1,8.00,10,'2026-10-21 13:34:36'),(7,3,9.00,10,'2026-10-21 13:36:10'),(8,3,9.00,10,'2026-10-21 13:36:58'),(9,3,10.00,10,'2026-10-21 13:38:04'),(10,4,10.00,10,'2026-10-21 13:39:38'),(11,5,9.00,10,'2026-10-21 13:44:18'),(12,6,10.00,10,'2026-10-21 13:53:26'),(13,4,10.00,10,'2026-10-22 07:12:44'),(14,9,9.00,10,'2026-10-22 11:06:16'),(15,10,9.00,10,'2026-10-22 11:07:20'),(16,7,10.00,10,'2026-10-22 11:08:04'),(17,11,10.00,10,'2026-10-22 11:11:39'),(18,3,10.00,10,'2026-10-22 13:43:18'),(19,8,10.00,10,'2026-10-22 13:44:46'),(20,9,8.67,10,'2026-10-22 14:31:54'),(21,4,7.00,10,'2026-10-22 14:39:19');
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'aqeel'),(2,'Aahil'),(3,'a'),(4,'K'),(5,'Rubeena'),(6,'Angelina'),(7,'aq'),(8,'d'),(9,'AY'),(10,'ak'),(11,'srk');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-22 20:24:51
