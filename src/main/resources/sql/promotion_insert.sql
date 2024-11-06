CREATE DATABASE  IF NOT EXISTS `promotion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `promotion`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: promotion
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Dumping data for table `meta`
--

LOCK TABLES `meta` WRITE;
/*!40000 ALTER TABLE `meta` DISABLE KEYS */;
INSERT INTO `meta` VALUES (1,1,'description','og:description','홈페이지 설명입니다.','description'),(2,1,'keywords','og:keywords','Spring, Boot, JPA','keywords'),(3,2,'description','og:description','소개 페이지 설명입니다.','description'),(4,4,'description','og:description','프로모션 페이지의 상세 설명입니다.','description'),(5,4,'keywords','og:keywords','프로모션, 할인, 이벤트','keywords'),(6,1,'charset',NULL,'utf-8',NULL),(7,1,'generator',NULL,'Rhymix',NULL),(8,1,'viewport',NULL,'width=device-width, initial-scale=1.0, user-scalable=yes',NULL),(9,1,'http-equiv','X-UA-Compatible','IE=edge',NULL),(10,1,'keywords',NULL,'중앙공원 롯데캐슬 10년임대, 중앙공원 롯데캐슬 임대, 중앙공원 롯데캐슬 10년전세',NULL),(11,1,'description',NULL,'중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(12,1,'viewport',NULL,'width=device-width, initial-scale=1.0',NULL),(13,1,'format-detection',NULL,'telephone=no',NULL),(14,1,'twitter:card',NULL,'summary',NULL),(15,1,'twitter:title',NULL,'&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(16,1,'twitter:description',NULL,'중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(17,1,'csrf-token',NULL,'0oYTwLLC4CjSuzX5',NULL),(18,1,NULL,'og:title','&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(19,1,NULL,'og:site_name','&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(20,1,NULL,'og:description','중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(21,1,NULL,'og:type','website',NULL),(22,1,NULL,'og:url','http://www.dn-thesharp.co.kr/',NULL),(23,1,NULL,'og:locale','ko_KR',NULL),(24,2,'charset',NULL,'utf-8',NULL),(25,2,'generator',NULL,'Rhymix',NULL),(26,2,'viewport',NULL,'width=device-width, initial-scale=1.0, user-scalable=yes',NULL),(27,2,'http-equiv','X-UA-Compatible','IE=edge',NULL),(28,2,'keywords',NULL,'중앙공원 롯데캐슬 10년임대, 중앙공원 롯데캐슬 임대, 중앙공원 롯데캐슬 10년전세',NULL),(29,2,'description',NULL,'중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(30,2,'viewport',NULL,'width=device-width, initial-scale=1.0',NULL),(31,2,'format-detection',NULL,'telephone=no',NULL),(32,2,'twitter:card',NULL,'summary',NULL),(33,2,'twitter:title',NULL,'&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(34,2,'twitter:description',NULL,'중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(35,2,'csrf-token',NULL,'0oYTwLLC4CjSuzX5',NULL),(36,2,NULL,'og:title','&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(37,2,NULL,'og:site_name','&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(38,2,NULL,'og:description','중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(39,2,NULL,'og:type','website',NULL),(40,2,NULL,'og:url','http://www.dn-thesharp.co.kr/',NULL),(41,2,NULL,'og:locale','ko_KR',NULL);
/*!40000 ALTER TABLE `meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pages`
--

LOCK TABLES `pages` WRITE;
/*!40000 ALTER TABLE `pages` DISABLE KEYS */;
INSERT INTO `pages` VALUES (1,'/'),(2,'/home'),(3,'about'),(4,'promotion-page');
/*!40000 ALTER TABLE `pages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (1,2,'body','<p>Welcome to the home page!</p>',1);
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'admin','$2a$10$E0sMRZtI2su57IlDB5Rwre6j5A7HfXu4CAZGvVF9xGf02sMCysX6m','ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-07  5:25:26
