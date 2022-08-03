-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: buza
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `ma_province`
--

DROP TABLE IF EXISTS `ma_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ma_province` (
  `PROVINCE_ID` int NOT NULL AUTO_INCREMENT,
  `PROVINCE_NAME` varchar(45) DEFAULT NULL,
  `PROVINCE_NAME_PINYIN` varchar(45) DEFAULT NULL,
  `PROVINCE_FULL_NAME` varchar(45) DEFAULT NULL,
  `PROVINCE_ENAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PROVINCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='省份表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_province`
--

LOCK TABLES `ma_province` WRITE;
/*!40000 ALTER TABLE `ma_province` DISABLE KEYS */;
INSERT INTO `ma_province` VALUES (1,'北京','B','北京市','Beijing'),(2,'天津','T','天津市','Tianjin'),(3,'河北','H','河北省','Hebei'),(4,'内蒙古','N','内蒙古自治区','Neimenggu'),(5,'辽宁','L','辽宁省','Liaoning'),(6,'吉林','J','吉林省','Jilin'),(7,'黑龙江','H','黑龙江省','Heilongjiang'),(8,'山东','S','山东省','Shandong'),(9,'河南','H','河南省','Henan'),(10,'上海','S','上海市','Shanghai'),(11,'江苏','J','江苏省','Jiangsu'),(12,'浙江','Z','浙江省','Zhejiang'),(13,'安徽','A','安徽省','An\'hui'),(14,'湖北','H','湖北省','Hubei'),(15,'福建','F','福建省','Fujian'),(16,'江西','J','江西省','Jiangxi'),(17,'湖南','H','湖南省','Hunan'),(18,'广东','G','广东省','Guangdong'),(19,'广西','G','广西壮族自治区','Guangxi'),(20,'海南','H','海南省','Hainan'),(21,'重庆','C','重庆市','Chongqing'),(22,'山西','S','山西省','Shanxi'),(23,'四川','S','四川省','Sichuan'),(24,'贵州','G','贵州省','Guizhou'),(25,'云南','Y','云南省','Yunnan'),(26,'陕西','S','陕西省','Shaanxi'),(27,'甘肃','G','甘肃省','Gansu'),(28,'青海','Q','青海省','Qinghai'),(29,'宁夏','N','宁夏回族自治区','Ningxia'),(30,'新疆','X','新疆维吾尔自治区','Xinjiang'),(31,'西藏','X','西藏自治区','Xizang');
/*!40000 ALTER TABLE `ma_province` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-30 13:51:01
