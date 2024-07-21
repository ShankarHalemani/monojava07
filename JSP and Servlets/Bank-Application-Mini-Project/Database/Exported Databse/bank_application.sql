CREATE DATABASE  IF NOT EXISTS `bank_application` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bank_application`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: bank_application
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `account_number` int NOT NULL AUTO_INCREMENT,
  `custid` int NOT NULL,
  `balance` decimal(15,2) DEFAULT '500.00',
  PRIMARY KEY (`account_number`),
  UNIQUE KEY `custid` (`custid`),
  CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`custid`) REFERENCES `customer` (`custid`)
) ENGINE=InnoDB AUTO_INCREMENT=50010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (50000,10000,100000.00),(50001,10001,2000.00),(50002,10002,1500.00),(50003,10003,2500.00),(50004,10004,3000.00),(50005,10005,3500.00),(50006,10006,4000.00),(50007,10007,4500.00),(50008,10008,5000.00),(50009,10009,5500.00);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `custid` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  PRIMARY KEY (`custid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (10000,'John','Doe','john.doe@example.com','password123'),(10001,'Jane','Smith','jane.smith@example.com','password456'),(10002,'Michael','Johnson','michael.johnson@example.com','password789'),(10003,'Emily','Davis','emily.davis@example.com','password321'),(10004,'David','Wilson','david.wilson@example.com','password654'),(10005,'Sarah','Brown','sarah.brown@example.com','password987'),(10006,'James','Taylor','james.taylor@example.com','password111'),(10007,'Laura','Lee','laura.lee@example.com','password222'),(10008,'Daniel','Walker','daniel.walker@example.com','password333'),(10009,'Anna','Robinson','anna.robinson@example.com','password444');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `tnumber` int NOT NULL AUTO_INCREMENT,
  `sender_account_number` int NOT NULL,
  `receiver_account_number` int NOT NULL,
  `date_of_transaction` datetime DEFAULT CURRENT_TIMESTAMP,
  `transaction_type` varchar(20) DEFAULT NULL,
  `transaction_amount` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`tnumber`),
  KEY `sender_account_number` (`sender_account_number`),
  KEY `receiver_account_number` (`receiver_account_number`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`sender_account_number`) REFERENCES `accounts` (`account_number`),
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`receiver_account_number`) REFERENCES `accounts` (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=80010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (80000,50000,50001,'2024-07-18 10:15:00','transfer',100.00),(80001,50002,50000,'2024-07-19 11:30:00','transfer',200.00),(80002,50001,50003,'2024-07-20 12:45:00','transfer',150.00),(80003,50004,50005,'2024-07-21 14:00:00','transfer',300.00),(80004,50006,50007,'2024-07-22 15:15:00','transfer',400.00),(80005,50008,50009,'2024-07-23 16:30:00','transfer',500.00),(80006,50003,50006,'2024-07-24 17:45:00','transfer',250.00),(80007,50007,50002,'2024-07-25 19:00:00','transfer',350.00),(80008,50005,50004,'2024-07-26 20:15:00','transfer',450.00),(80009,50009,50008,'2024-07-27 21:30:00','transfer',550.00);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-21 16:37:39
