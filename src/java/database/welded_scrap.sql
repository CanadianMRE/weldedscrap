DROP DATABASE IF EXISTS welded_scrap;
CREATE DATABASE welded_scrap;

USE welded_scrap;

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: welded_scrap
-- ------------------------------------------------------
-- Server version	5.7.43-log

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
-- Table drops
--
DROP TABLE IF EXISTS `order_product`;

DROP TABLE IF EXISTS `orders`;


DROP TABLE IF EXISTS `cart_product`;

DROP TABLE IF EXISTS `users`;

DROP TABLE IF EXISTS `payment`;

DROP TABLE IF EXISTS `product`;

DROP TABLE IF EXISTS `role`;

--
-- Table structure for table `role`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleId` int(8) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `stock` int(10) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `imagePath` VARCHAR(255),
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `paymentId` int(8) NOT NULL,
  `processed` int(1) NOT NULL,
  `cost` decimal(8,2) NOT NULL,
  `processedDate` date NOT NULL,
  PRIMARY KEY (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId`  int(8) AUTO_INCREMENT NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `roleId` int(8) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `roleId_idx` (`roleId`),
  CONSTRAINT `user_roleId_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `order`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderId` int(8) NOT NULL,
  `completed` int(1) NOT NULL,
  `orderDate` date NOT NULL,
  `paymentId` int(8) NOT NULL,
  `userId` int(8) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `order_userId_fk` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cart_product`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_product` (
  `productid` int(8) NOT NULL,
  `userid` int(8) NOT NULL,
  PRIMARY KEY (`userid`,`productid`),
  KEY `productId_idx` (`productid`),
  KEY `userId_idx` (`userid`),
  CONSTRAINT `cart_prodcut_fk_userId` FOREIGN KEY (`userid`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cart_product_fk_productId` FOREIGN KEY (`productid`) REFERENCES `product` (`productId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_product`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `productId` int(8) NOT NULL,
  `orderId` int(8) NOT NULL,
  KEY `order_product_fk_productId_idx` (`productId`),
  KEY `order_product_fk_orderId_idx` (`orderId`),
  CONSTRAINT `order_product_fk_orderId` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_product_fk_productId` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--Data for role
INSERT INTO `role` VALUES (1, 'system admin');
INSERT INTO `role` VALUES (2, 'regular user');
	
-- Sample data for the "users" table
INSERT INTO `users` (`userId`, `firstName`, `lastName`, `email`, `password`, `address`, `roleId`)
VALUES
    (1, 'Gurshaan', 'Gill', 'gurshaan-gill@hotmail.com','password','123 up your street',1),
    (2, 'John', 'Doe', 'johndoe@example.com', 'password', '123 Main St', 2),
    (3, 'Alice', 'Smith', 'alicesmith@example.com', 'password', '456 Elm St', 2),
    (4, 'Bob', 'Johnson', 'bj@example.com', 'password', '789 Oak St', 2),
    (5, 'John', 'Madden', 'johnmadden@example.com', 'password', '69 Football Ave', 2),
    (6, 'Walter', 'White', 'notheisenberg@example.com', 'password', '208 Negra Arroya Lane', 2);

-- Sample data for the "product" table
INSERT INTO `product` (`productId`, `name`, `description`, `stock`, `price`, imagePath)
VALUES
    (1, 'metal horse', 'dank metal horse for your living room', 12, 49.99, './images/ph1.jpg'),
    (2, 'ferrous mona lisa', 'the mona lisa but metal to impress that punk art major girl you are inviting over', 69, 42.69,'./images/ph2.jpg'),
    (3, 'big metal pipe', 'makes loud funny meme noise when dropped on floor', 26, 10.00,'./images/ph3.jpg'),
    (4, 'cool ninja star', 'throw it at a wall to make a hole in it. If you throw it hard enough it might stick to it.', 20, 20.50, './images/ph4.jpg'),
    (5, 'la obeja', '6 foot tall metal sheep to guard your home', 2, 10.79, './images/ph5.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-02 18:58:09


