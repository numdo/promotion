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
-- Table structure for table `meta`
--

DROP TABLE IF EXISTS `meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `page_id` bigint NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `property` varchar(200) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `itemprop` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_id` (`page_id`),
  CONSTRAINT `meta_ibfk_1` FOREIGN KEY (`page_id`) REFERENCES `pages` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meta`
--

LOCK TABLES `meta` WRITE;
/*!40000 ALTER TABLE `meta` DISABLE KEYS */;
INSERT INTO `meta` VALUES (1,1,'description','og:description','홈페이지 설명입니다.','description'),(2,1,'keywords','og:keywords','Spring, Boot, JPA','keywords'),(3,2,'description','og:description','소개 페이지 설명입니다.','description'),(4,4,'description','og:description','프로모션 페이지의 상세 설명입니다.','description'),(5,4,'keywords','og:keywords','프로모션, 할인, 이벤트','keywords'),(6,1,'charset',NULL,'utf-8',NULL),(7,1,'generator',NULL,'Rhymix',NULL),(8,1,'viewport',NULL,'width=device-width, initial-scale=1.0, user-scalable=yes',NULL),(9,1,'http-equiv','X-UA-Compatible','IE=edge',NULL),(10,1,'keywords',NULL,'중앙공원 롯데캐슬 10년임대, 중앙공원 롯데캐슬 임대, 중앙공원 롯데캐슬 10년전세',NULL),(11,1,'description',NULL,'중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(12,1,'viewport',NULL,'width=device-width, initial-scale=1.0',NULL),(13,1,'format-detection',NULL,'telephone=no',NULL),(14,1,'twitter:card',NULL,'summary',NULL),(15,1,'twitter:title',NULL,'&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(16,1,'twitter:description',NULL,'중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(17,1,'csrf-token',NULL,'0oYTwLLC4CjSuzX5',NULL),(18,1,NULL,'og:title','&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(19,1,NULL,'og:site_name','&#039;중앙공원 롯데캐슬 10년임대&quot;',NULL),(20,1,NULL,'og:description','중앙공원 롯데캐슬 10년임대ㅣ☎1661-5220ㅣ청약접수신청ㅣ중앙공원 롯데캐슬 임대ㅣ10년후 분양전환ㅣ모델하우스ㅣ방문예약ㅣ10년전세ㅣ분양가ㅣ광주 중앙공원 롯데캐슬',NULL),(21,1,NULL,'og:type','website',NULL),(22,1,NULL,'og:url','http://www.dn-thesharp.co.kr/',NULL),(23,1,NULL,'og:locale','ko_KR',NULL);
/*!40000 ALTER TABLE `meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(400) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `created_at` datetime NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_notice_user` (`user_id`),
  CONSTRAINT `fk_notice_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (4,'새로운 공지사항','이것은 새로운 공지사항의 내용입니다.','2024-04-27 12:00:00',2);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pages`
--

DROP TABLE IF EXISTS `pages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pages` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pages`
--

LOCK TABLES `pages` WRITE;
/*!40000 ALTER TABLE `pages` DISABLE KEYS */;
INSERT INTO `pages` VALUES (1,'/'),(2,'/home'),(3,'about'),(4,'promotion-page');
/*!40000 ALTER TABLE `pages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `page_id` bigint NOT NULL,
  `tag_id` varchar(100) DEFAULT NULL,
  `src` varchar(300) DEFAULT NULL,
  `value` varchar(1000) DEFAULT NULL,
  `href` varchar(300) DEFAULT NULL,
  `css_class` varchar(200) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `alt` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_id` (`page_id`),
  CONSTRAINT `tag_ibfk_1` FOREIGN KEY (`page_id`) REFERENCES `pages` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,1,'header','','','/','main-header','환영합니다!','','홈 헤더'),(2,1,'footer','','','/','main-footer','푸터 내용입니다.','','홈 푸터'),(3,2,'header','','','/','about-header','소개 페이지에 오신 것을 환영합니다!','','소개 헤더'),(4,4,'header','/images/header.png','','/home','header-class','환영합니다!','헤더 이미지','헤더 타이틀'),(5,4,'footer','/images/footer.png','','/contact','footer-class','문의하기','푸터 이미지','푸터 타이틀');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `user_password` varchar(200) NOT NULL,
  `role` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'admin','$2a$10$NGokSVk2dbL8MyvGdYf3eekw3oHhmgfoxMinyS9RSTjyXzoa7TjpC','ADMIN');
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

-- Dump completed on 2024-11-05 22:39:41
