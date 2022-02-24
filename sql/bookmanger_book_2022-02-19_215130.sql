-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookmanger
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `addTime` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `borrower` varchar(255) DEFAULT NULL,
  `lendTime` varchar(255) DEFAULT NULL,
  `returnTime` varchar(255) DEFAULT NULL,
  `isAvailable` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `book_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'时间简史','姜梓杰','2022-02-19 07:30:00','科普，物理','null','null','null',0),(2,'达‘芬奇密码','曹然','2022-02-19 09:28:50','推理小说','陈一凡','2022-02-19 15:53:13','null',1),(3,'离开前，请叫醒我','曹然','2022-02-19 09:29:47','','null','null','null',0),(4,'明朝那些事','曹然','2022-02-19 09:30:16','','null','null','null',0),(5,'果壳中的宇宙','姜梓杰','2022-02-19 09:31:17','科普，物理','姜梓杰','2022-02-19 10:11:52','null',1),(6,'植物知道生命的答案','姜梓杰','2022-02-19 09:32:03','科普，生物','null','null','null',0),(7,'呐喊','许嘉祚','2022-02-19 09:32:57','鲁迅小说','null','null','null',0),(8,'彷徨','许嘉祚','2022-02-19 09:33:36','鲁迅小说','null','null','null',0),(9,'活着','许嘉祚','2022-02-19 09:34:11','小说','null','null','null',0),(10,'围城','许嘉祚','2022-02-19 09:34:36','小说','null','null','null',0),(11,'肖申克的救赎','许嘉祚','2022-02-19 09:35:18','小说集','许嘉祚','2022-02-19 16:44:54','null',1),(12,'海底两万里','许嘉祚','2022-02-19 09:35:51','科幻小说','null','null','null',0),(13,'契诃夫短篇小说选','许嘉祚','2022-02-19 09:36:29','小说集','null','null','null',0),(14,'契科夫短篇小说精选','纪德鼎','2022-02-19 09:38:14','小说','曹然','2022-02-19 16:45:11','null',1),(15,'莫泊桑短篇小说精选','纪德鼎','2022-02-19 09:39:29','小说集','null','null','null',0),(16,'酒国','纪德鼎','2022-02-19 09:40:18','小说','null','null','null',0),(17,'丰乳肥臀','纪德鼎','2022-02-19 09:41:12','小说','null','null','null',0),(18,'我与地坛','徐华卿','2022-02-19 09:41:57','散文集','null','null','null',0),(19,'皮囊','徐华卿','2022-02-19 09:42:32','散文集','null','null','null',0),(20,'人间失格','徐华卿','2022-02-19 09:42:55','小说集','叶鑫','2022-02-19 12:02:18','null',1),(21,'球状闪电','徐华卿','2022-02-19 09:43:28','科幻小说','null','null','null',0),(22,'超新星纪元','徐华卿','2022-02-19 09:43:48','小说','纪德鼎','2022-02-19 20:51:58','null',1),(23,'带上她的眼睛','徐华卿','2022-02-19 09:44:20','小说集','黄磊','2022-02-19 12:01:49','null',1),(24,'梦之海','徐华卿','2022-02-19 09:44:49','小说集','null','null','null',0),(25,'千年一叹','徐华卿','2022-02-19 09:45:20','散文集','null','null','null',0),(26,'李煜词传','刘添','2022-02-19 09:49:35','文学','胡雄','2022-02-19 18:39:37','null',1),(27,'纳兰词','刘添','2022-02-19 09:50:36','文学','null','null','null',0),(28,'世界通史','胡浩','2022-02-19 09:52:54','历史','null','null','null',0),(29,'资治通鉴','胡浩','2022-02-19 09:53:32','历史','null','null','null',0),(30,'荷塘月色','胡源','2022-02-19 09:54:26','散文集','null','null','null',0),(31,'人间词话','胡源','2022-02-19 09:55:44','诗词研究','null','null','null',0),(32,'约翰。克里斯朵夫','祝家仪','2022-02-19 10:07:30','英语，音乐，成长','null','null','null',0),(33,'巴黎圣母院','侯依凡','2022-02-19 10:08:31','文学','null','null','null',0),(34,'时间之箭','叶鑫','2022-02-19 12:01:30','物理','null','null','null',0),(35,'天才在左，疯子在右','陈浩淼','2022-02-19 18:39:06','小说','null','null','null',0),(36,'狂想代理人','陈浩淼','2022-02-19 18:40:21','','祝家仪','2022-02-19 20:58:45','null',1),(37,'人人都能，梦的解析','陈浩淼','2022-02-19 18:40:56','科普','null','null','null',0),(38,'时间简史','陈浩淼','2022-02-19 19:45:10','科普','null','null','null',0),(39,'宇宙简史','陈浩淼','2022-02-19 19:45:52','科普','null','null','null',0),(40,'果壳中的宇宙','陈浩淼','2022-02-19 19:47:48','科普','null','null','null',0),(41,'大设计','陈浩淼','2022-02-19 19:48:09','科普','null','null','null',0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-19 21:52:11
