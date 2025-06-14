-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_hib
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
-- Table structure for table `mygroup`
--

DROP TABLE IF EXISTS `mygroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mygroup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `groupName` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mygroup`
--

LOCK TABLES `mygroup` WRITE;
/*!40000 ALTER TABLE `mygroup` DISABLE KEYS */;
INSERT INTO `mygroup` VALUES (1,'Карандаши'),(2,'Ручки'),(3,'Линейки'),(4,'Ножницы'),(5,'Точилки'),(6,'Фломастеры'),(7,'Скрепки'),(8,'Скобки'),(9,'Блокноты'),(10,'Пакеты'),(11,'Маркеры'),(12,'Пеналы'),(13,'Штрихи'),(14,'Стикеры'),(15,'Кнопки'),(16,'Корректоры'),(17,'Органайзеры'),(18,'Резаки'),(19,'Стержни'),(20,'Файлы');
/*!40000 ALTER TABLE `mygroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mygroup_tovar`
--

DROP TABLE IF EXISTS `mygroup_tovar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mygroup_tovar` (
  `tovar_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`tovar_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `mygroup_tovar_ibfk_1` FOREIGN KEY (`tovar_id`) REFERENCES `tovar` (`id`),
  CONSTRAINT `mygroup_tovar_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mygroup_tovar`
--

LOCK TABLES `mygroup_tovar` WRITE;
/*!40000 ALTER TABLE `mygroup_tovar` DISABLE KEYS */;
INSERT INTO `mygroup_tovar` VALUES (1,2),(2,2),(3,2),(8,2),(16,2),(30,2),(40,2);
/*!40000 ALTER TABLE `mygroup_tovar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(55) DEFAULT NULL,
  `dAndT` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  `person_id` int DEFAULT NULL,
  `tovar_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `person_id` (`person_id`),
  KEY `tovar_id` (`tovar_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `user` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`tovar_id`) REFERENCES `tovar` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'f85bfd72-8791-4415-83b1-26fcf514fa3a','2025-05-01 09:01:05',1,2,1),(2,'f85bfd72-8791-4415-83b1-26fcf514fa3a','2025-05-01 09:01:05',1,2,2),(3,'f85bfd72-8791-4415-83b1-26fcf514fa3a','2025-05-01 09:01:05',1,2,3),(4,'f85bfd72-8791-4415-83b1-26fcf514fa3a','2025-05-01 09:01:05',1,2,5),(5,'7d46fd24-af22-4f52-9766-a6684f3268d7','2025-05-01 09:02:09',1,3,1),(6,'7d46fd24-af22-4f52-9766-a6684f3268d7','2025-05-01 09:02:09',1,3,16),(7,'7d46fd24-af22-4f52-9766-a6684f3268d7','2025-05-01 09:02:09',1,3,17),(8,'bc198600-08e8-406d-a999-e0f2e1e68ebe','2025-05-01 09:08:13',1,4,11),(9,'bc198600-08e8-406d-a999-e0f2e1e68ebe','2025-05-01 09:08:13',1,4,12),(10,'a7dbb137-020f-443a-9299-602f52b052eb','2025-05-01 09:16:57',1,16,17),(11,'0b6218e9-4511-4cf8-9681-10a42dddf75a','2025-05-01 16:25:28',1,2,1),(12,'0b6218e9-4511-4cf8-9681-10a42dddf75a','2025-05-01 16:25:28',1,2,2),(13,'0b6218e9-4511-4cf8-9681-10a42dddf75a','2025-05-01 16:25:28',1,2,22),(14,'4009fc8a-f9cc-4117-867e-7465258aa564','2025-05-01 17:10:59',2,5,8),(15,'4009fc8a-f9cc-4117-867e-7465258aa564','2025-05-01 17:10:59',2,5,11),(16,'612821e4-24a1-4a15-b80a-23f98196255f','2025-05-02 09:21:18',1,6,8),(17,'612821e4-24a1-4a15-b80a-23f98196255f','2025-05-02 09:21:18',1,6,17),(18,'b09417aa-03f9-46dc-a4cc-2a1a4ac21f0a','2025-05-02 09:29:39',1,7,1),(19,'b09417aa-03f9-46dc-a4cc-2a1a4ac21f0a','2025-05-02 09:29:39',1,7,8),(20,'366508f7-8c89-4070-a47e-e93a14c3107f','2025-05-02 09:39:25',1,8,5),(21,'366508f7-8c89-4070-a47e-e93a14c3107f','2025-05-02 09:39:25',1,8,8),(22,'d90d2269-0ce7-443b-bf50-3780ee8e4ae4','2025-05-02 09:42:57',1,8,1),(23,'5b208293-0d34-49f1-94df-f3486e543704','2025-05-02 09:55:11',1,8,1),(24,'5b208293-0d34-49f1-94df-f3486e543704','2025-05-02 09:55:11',1,8,5),(25,'d4e7c537-dae8-46b4-aa2b-cadc39124ebd','2025-05-02 09:58:28',1,8,5),(26,'d4e7c537-dae8-46b4-aa2b-cadc39124ebd','2025-05-02 09:58:28',1,8,8),(27,'14ce8f88-07eb-4d64-9957-a6a0f65682bd','2025-05-02 10:00:26',1,9,1),(28,'14ce8f88-07eb-4d64-9957-a6a0f65682bd','2025-05-02 10:00:26',1,9,5),(29,'14ce8f88-07eb-4d64-9957-a6a0f65682bd','2025-05-02 10:00:26',1,9,8),(30,'79785231-18da-47c4-a059-2209624ca78e','2025-05-02 10:03:24',1,10,1),(31,'79785231-18da-47c4-a059-2209624ca78e','2025-05-02 10:03:24',1,10,5),(32,'79785231-18da-47c4-a059-2209624ca78e','2025-05-02 10:03:24',1,10,8),(33,'27b2df7a-12b3-472f-a409-eda9a8baf0e3','2025-05-02 10:28:18',1,10,1),(34,'27b2df7a-12b3-472f-a409-eda9a8baf0e3','2025-05-02 10:28:18',1,10,5),(35,'a29a0501-285f-4614-b1ee-c48de4738b8b','2025-05-02 10:37:04',1,10,5),(36,'a29a0501-285f-4614-b1ee-c48de4738b8b','2025-05-02 10:37:04',1,10,8),(37,'bd1ec113-395b-401a-9872-c1b65552d3a6','2025-05-02 14:37:00',1,2,8),(38,'4705193a-a474-4a02-b891-9289e5bb865f','2025-05-02 14:57:54',1,2,1),(39,'4705193a-a474-4a02-b891-9289e5bb865f','2025-05-02 14:57:54',1,2,8),(40,'bad776fd-dd0d-41d0-b0c8-73d45a7de8fb','2025-05-02 15:05:37',1,3,2),(41,'bad776fd-dd0d-41d0-b0c8-73d45a7de8fb','2025-05-02 15:05:37',1,3,3),(42,'86be7e91-4c92-4c0a-9174-8928ff1a98e0','2025-05-02 15:12:14',1,4,2),(43,'86be7e91-4c92-4c0a-9174-8928ff1a98e0','2025-05-02 15:12:14',1,4,11),(44,'db2ed967-660c-4c19-8ccc-420e16ada631','2025-05-02 15:21:40',1,11,1),(45,'db2ed967-660c-4c19-8ccc-420e16ada631','2025-05-02 15:21:40',1,11,22),(46,'2939d446-e5e6-4d63-9552-cbe45120bd86','2025-05-02 16:47:35',1,2,19),(47,'2939d446-e5e6-4d63-9552-cbe45120bd86','2025-05-02 16:47:35',1,2,23),(48,'24a82d72-1047-4f5d-942e-83c48f4379b1','2025-05-02 16:55:39',1,3,8),(49,'24a82d72-1047-4f5d-942e-83c48f4379b1','2025-05-02 16:55:39',1,3,13),(50,'07ba99ed-f08f-4246-a720-31d0515e6b3b','2025-05-03 16:36:49',1,2,31),(51,'07ba99ed-f08f-4246-a720-31d0515e6b3b','2025-05-03 16:36:49',1,2,32),(52,'0cd3686e-fa31-48fd-9b3d-d3e60d269dc7','2025-05-03 17:08:25',3,19,16),(53,'0cd3686e-fa31-48fd-9b3d-d3e60d269dc7','2025-05-03 17:08:25',3,19,24),(54,'ba6177f3-7d31-4956-8a5d-cd1b7740e7e2','2025-05-05 10:45:39',1,19,5),(55,'ba6177f3-7d31-4956-8a5d-cd1b7740e7e2','2025-05-05 10:45:39',1,19,8),(56,'001660f1-29aa-4218-a28c-f83c84d23025','2025-05-05 10:50:37',1,19,1),(57,'001660f1-29aa-4218-a28c-f83c84d23025','2025-05-05 10:50:37',1,19,5),(58,'8dce4a28-95de-484f-bd9c-7145362b532b','2025-05-05 10:52:14',1,19,16),(59,'8dce4a28-95de-484f-bd9c-7145362b532b','2025-05-05 10:52:14',1,19,17),(60,'e881ed62-b0fc-48d1-8c1b-f9aaf4d15a8f','2025-05-06 15:57:13',1,21,17),(61,'e881ed62-b0fc-48d1-8c1b-f9aaf4d15a8f','2025-05-06 15:57:13',1,21,23),(62,'e881ed62-b0fc-48d1-8c1b-f9aaf4d15a8f','2025-05-06 15:57:13',1,21,24),(63,'2daba436-7940-43ea-9bd9-cfe5bba2a389','2025-05-07 13:05:13',1,22,24),(64,'2daba436-7940-43ea-9bd9-cfe5bba2a389','2025-05-07 13:05:13',1,22,34),(65,'f328e0a3-2d72-475f-8143-ea9a99bdd065','2025-05-07 13:06:35',1,22,1),(66,'f328e0a3-2d72-475f-8143-ea9a99bdd065','2025-05-07 13:06:35',1,22,2),(67,'f328e0a3-2d72-475f-8143-ea9a99bdd065','2025-05-07 13:06:35',1,22,3),(68,'934950e9-4571-4c8a-b078-bcfc0ad7f09a','2025-05-08 16:21:43',1,7,22),(69,'934950e9-4571-4c8a-b078-bcfc0ad7f09a','2025-05-08 16:21:43',1,7,24),(70,'950f5549-2eab-4b2b-b71d-d537b17e227f','2025-05-10 15:26:46',1,14,22),(71,'950f5549-2eab-4b2b-b71d-d537b17e227f','2025-05-10 15:26:46',1,14,24),(72,'950f5549-2eab-4b2b-b71d-d537b17e227f','2025-05-10 15:26:46',1,14,28),(73,'80aa7f7e-e727-462b-9059-f2fc4fd7d4d8','2025-05-10 15:34:35',1,12,1),(74,'80aa7f7e-e727-462b-9059-f2fc4fd7d4d8','2025-05-10 15:34:35',1,12,16),(75,'80aa7f7e-e727-462b-9059-f2fc4fd7d4d8','2025-05-10 15:34:35',1,12,24),(76,'bed0507a-01fb-4ca4-ab0a-5bc3a8ef9cc4','2025-05-12 11:06:09',2,2,24),(77,'bed0507a-01fb-4ca4-ab0a-5bc3a8ef9cc4','2025-05-12 11:06:09',2,2,30),(78,'bed0507a-01fb-4ca4-ab0a-5bc3a8ef9cc4','2025-05-12 11:06:09',2,2,40),(79,'8b3e48b3-03f6-4d35-8417-979a7fca02ae','2025-05-16 11:22:16',1,25,8),(80,'8b3e48b3-03f6-4d35-8417-979a7fca02ae','2025-05-16 11:22:16',1,25,12),(81,'292ce2f0-d0ce-4e98-b541-c2af90560a9f','2025-05-16 11:23:10',2,25,1),(82,'292ce2f0-d0ce-4e98-b541-c2af90560a9f','2025-05-16 11:23:10',2,25,2),(83,'7fc633c7-eaa5-48e5-b946-94e3507200d3','2025-05-20 11:09:34',3,26,31),(84,'7fc633c7-eaa5-48e5-b946-94e3507200d3','2025-05-20 11:09:34',3,26,34),(85,'f0e7b216-8d73-4466-b81b-614ea4d60509','2025-05-20 14:52:35',3,27,1),(86,'f0e7b216-8d73-4466-b81b-614ea4d60509','2025-05-20 14:52:35',3,27,2),(87,'4d5c5213-a8bb-4d80-9c07-669b99210616','2025-05-20 14:57:27',1,27,24),(88,'4d5c5213-a8bb-4d80-9c07-669b99210616','2025-05-20 14:57:27',1,27,36),(89,'d37c787b-348f-4e9e-a2f4-5b773fbbf960','2025-05-27 15:00:38',1,24,2),(90,'d37c787b-348f-4e9e-a2f4-5b773fbbf960','2025-05-27 15:00:38',1,24,24),(91,'2b523da1-5f40-4244-801e-aeb93d23c73e','2025-05-27 15:02:17',3,24,24),(92,'2b523da1-5f40-4244-801e-aeb93d23c73e','2025-05-27 15:02:17',3,24,36),(93,'cf3fabce-d35a-4043-aa04-811cb4158912','2025-06-04 11:30:52',2,17,1),(94,'cf3fabce-d35a-4043-aa04-811cb4158912','2025-06-04 11:30:52',2,17,24),(95,'cf3fabce-d35a-4043-aa04-811cb4158912','2025-06-04 11:30:52',2,17,30),(96,'cf3fabce-d35a-4043-aa04-811cb4158912','2025-06-04 11:30:52',2,17,48),(97,'6e5010dd-d910-4768-9768-0d27c713c7ca','2025-06-05 16:13:03',2,2,24),(98,'6e5010dd-d910-4768-9768-0d27c713c7ca','2025-06-05 16:13:03',2,2,40),(99,'2370d5df-1a56-4cbd-922b-dddedd57cfcd','2025-06-09 11:11:23',2,13,1),(100,'2370d5df-1a56-4cbd-922b-dddedd57cfcd','2025-06-09 11:11:23',2,13,10),(101,'2370d5df-1a56-4cbd-922b-dddedd57cfcd','2025-06-09 11:11:23',2,13,24),(102,'15bd4414-56f2-4790-8ca4-e375608411ca','2025-06-10 14:44:05',3,2,1),(103,'15bd4414-56f2-4790-8ca4-e375608411ca','2025-06-10 14:44:05',3,2,10),(104,'15bd4414-56f2-4790-8ca4-e375608411ca','2025-06-10 14:44:05',3,2,24);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tovar`
--

DROP TABLE IF EXISTS `tovar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tovar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tovarName` varchar(25) DEFAULT NULL,
  `tovarPrice` double DEFAULT NULL,
  `tovarCode` varchar(25) DEFAULT NULL,
  `mygroup_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mygroup_id` (`mygroup_id`),
  CONSTRAINT `tovar_ibfk_1` FOREIGN KEY (`mygroup_id`) REFERENCES `mygroup` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tovar`
--

LOCK TABLES `tovar` WRITE;
/*!40000 ALTER TABLE `tovar` DISABLE KEYS */;
INSERT INTO `tovar` VALUES (1,'Карандаш1',10,'PP0001',1),(2,'Карандаш2',10,'PP0002',1),(3,'Карандаш3',20,'PP0003',1),(5,'Линейка1',1,'LI0001',3),(8,'Ножницы1',20,'NO0001',4),(9,'Ручка1',10,'RR0001',2),(10,'Ручка2',20,'RR0002',2),(11,'Линейка2',10,'LI0002',3),(12,'Линейка3',20,'LI0003',3),(13,'Ножницы2',30,'NO0002',4),(16,'Точилка1',10,'TT0001',5),(17,'Точилка2',11,'TT0002',5),(19,'Фломастер1',5,'FF0001',6),(22,'Блокнот1',2,'BB0001',9),(23,'Карандаш4',5.5,'PP0004',1),(24,'Пакет1',1,'PA0001',10),(26,'Ручка3',2,'RR0003',2),(27,'Линейка4',4,'LI0004',3),(28,'Маркер1',3,'MM0001',11),(29,'Карандаш5',5,'PP0005',1),(30,'Пенал1',2,'PE0001',12),(31,'Скрепки1',1,'SC0001',7),(32,'Скобки1',1,'SS0001',8),(34,'Пенал2',2,'PE0002',12),(36,'Штрих1',2,'SH0001',13),(37,'Пенал3',5,'PE0003',12),(38,'Стикеры1',3,'ST0001',14),(40,'Кнопка1',1,'KN0001',15),(41,'Кнопки2',2,'KN0002',15),(45,'Резак1',10,'RE0001',18),(48,'Стержни1',2,'SZ0001',19),(50,'Стержень2',4,'SZ0002',19),(51,'Стержень3',7,'SZ0003',19),(52,'Файлы1',7,'FA0001',20),(53,'Файлы2',8,'FA0002',20),(54,'Файлы3',5,'FA0003',20),(55,'Файлы4',4,'FA0004',20),(56,'Файлы5',5,'FA0005',20),(57,'Файлы6',2,'FA0006',20);
/*!40000 ALTER TABLE `tovar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `patronymic` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `telephone_number` varchar(25) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  `login` varchar(25) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Первов','Перв','Первович','1@ya.ru','+7-000-000-00-01','администратор','1','$2a$10$T4gT.b3zcdKQxS8eT0jMge5HQF8FJlz3XgBHj4mlKUes.kb7yiwqC'),(2,'Второв','Втор','Вторович','2@ya.ru','+7-000-000-00-02','пользователь','2','$2a$10$QkQ4DXEXlsDqQrBlUwIzIePOin0176ty7Rt1yjawTpzDtRMROSUXC'),(3,'Третьев','Трет','Третьевич','3@ya.ru','+7-000-000-00-03','пользователь','3','$2a$10$jMxtSxeKTxCkYDw.fdePxuAu5yNHzlR0YuKcUXpTuHZOyJpm4h0a2'),(4,'Четвертов','Четверт','Четвертович','4@ya.ru','+7-000-000-00-04','пользователь','4','$2a$10$A1MTf/oaGgceOVkSfAf1S.lKAU.PDn.EHoTXoZH7JsWfkEcZIgWj.'),(5,'Пятов','Пят','Пятович','5@ya.ru','+7-000-000-00-05','пользователь','5','$2a$10$Bwwk0ZTQWTABzJUN3tYJG.DpEJZdAr0J2VEpvpI5VNCGl/d/HBkxi'),(6,'Шестов','Шест','Шестович','6@ya.ru','+7-000-000-00-06','пользователь','6','$2a$10$HG5KRh0hu39vnOJeNas8qexkLjYR3nZiNjJOUCzURioN6HLkaVUXW'),(7,'Седьмов','Седьм','Седьмович','7@ya.ru','+7-000-000-00-07','пользователь','7','$2a$10$Ty9jnuS8vhR6Xehl2coN0eG2s57i4fiZmMFNsEjsIZQH9X2VCBe02'),(8,'Восьмов','Восьм','Восьмович','8@ya.ru','+7-000-000-00-08','пользователь','8','$2a$10$rXc.umYEXHLXDZqwsCzbtezzE.z3ldSCh9GdD2F3Z2dWVUeeGiNZK'),(9,'Девятов','Девят','Девятович','9@ya.ru','+7-000-000-00-09','пользователь','9','$2a$10$egrmJA23M882LxH/.vQJYei/qBjWbSUyLs6ZBl3rPgdzhQRMZBhQW'),(10,'Десятов','Десят','Десятович','10@ya.ru','+7-000-000-00-10','пользователь','10','$2a$10$MfW5LHmXkjm/MDSnUEKdnuSxI0a.vGFqurWk3F06cYSyIIfFaXIWG'),(11,'Одиннадцатов','Одиннадцат','Одиннадцатович','11@ya.ru','+7-000-000-00-11','пользователь','11','$2a$10$Bp4IPTPpcOXr.xuZldzwQOKMPSx7tU7XAoVEO5vGORJxOK9g9PhKe'),(12,'Двенадцатов','Двенадцат','Двенадцатович','12@ya.ru','+7-000-000-00-12','пользователь','12','$2a$10$941IzFIHjbXWy4KI7Y3oXe0NFv5Co4AbBYCm7qstwCWL3qEUwCaO2'),(13,'Тринадцатов','Тринадцат','Тринадцатович','13@ya.ru','+7-000-000-00-13','пользователь','13','$2a$10$hulb89sQzvNNKYyvzm2VHeOOkm.tqQedYyNiZfiU5Eo3daqz32EnC'),(14,'Четырнадцатов','Четырнадцат','Четырнадцатович','14@ya.ru','+7-000-000-00-14','пользователь','14','$2a$10$OjMfZdL4x2bzpptkFWBNp.apReaGR4x/NJp7sF0nmeLeqm4U7R4Hi'),(15,'Пятнадцатов','Пятрадцат','Пятнадцатович','15@ya.ru','+7-000-000-00-15','пользователь','15','$2a$10$J/Gu7740BRR8p.bElhdEsuqj2Ra3jbXej9ZL6BiFHZS3baZ.Dxvui'),(16,'Шестнадцатов','Шестнадцат','Шестнадцатович','16@ya.ru','+7-000-000-00-16','пользователь','16','$2a$10$uEtURpHOgY9UDjOsiANvUeJw0a2uOpUo/UnvKB88w5erAtqrleKpe'),(17,'Семнадцатов','Семнадцат','Семнадцатович','17@ya.ru','+7-000-000-00-17','пользователь','17','$2a$10$cEn/UQqXJUdg0mMOUvYONupPVUmczaAfklJN6wh9gk76WFGAnByfe'),(18,'Восемнадцатов','Восемнадцат','Восемнадцатович','18@ya.ru','+7-000-000-00-18','пользователь','18','$2a$10$zsZdjsuvMN.HO2ln5Rj/IOJFxYqt/FWccq8XpJcoRcoxfLRKDke62'),(19,'Девятнадцатов','Девятнадцат','Девятнадцатович','19@ya.ru','+7-000-000-00-19','пользователь','19','$2a$10$DyLOHu0X7Yet7p7w5ly8ROwvAdz28/yv3vChNJE0zVkAHi4lUYvEe'),(20,'Двадцатов','Двадцат','Двадцатович','20@ya.ru','+7-000-000-00-20','пользователь','20','$2a$10$Ix9k65Z4IuNx1PtfTUAineEwFHB/PaKbS.w03QIfq9.f5mHul9cIC'),(21,'Двадцатьпервов','Двадцатьперв','Двадцатьпервович','21@ya.ru','+7-000-000-00-21','пользователь','21','$2a$10$jwIzNq.byHsZtNARrMvt7elevfznu5dJexEc2jG1D7bQbpVNYt76K'),(22,'Двадцатьвторов','Двадцатьвтор','Двадцатьвторович','22@ya.ru','+7-000-000-00-22','пользователь','22','$2a$10$anhfnCRDfQWgLeII6N.FJO7xpZtluBNV5xWRxa8Ej51/oiH3ZPf6a'),(23,'Двадцатьтретьев','Двадцатьтрет','Двадцатьтретьевич','23@ya.ru','+7-000-000-00-23','пользователь','23','$2a$10$iFFXt2L3K55qY/AL4qpODOF8X5o6GGoXmf1M654NCmGmflsv80rwu'),(24,'Двадцатьчетвертов','Двадцатьчетверт','Двадцатьчетвертович','24@ya.ru','+7-000-000-00-24','пользователь','24','$2a$10$8TlqtPRMzqYh4HKVkXSDAuImPnfAOmg2DusmYrSpacitbIjkqSuVe'),(25,'Двадцатьпятов','Двадцатьпят','Двадцатьпятович','25@ya.ru','+7-000-000-00-25','пользователь','25','$2a$10$iGRdhtNUGlVOULT7I8td8.scD3t3PsdleibRDbnfTMze7VCMt2PIe'),(26,'Двадцатьшестов','Двадцатьшест','Двадцатьшестович','26@ya.ru','+7-000-000-00-26','пользователь','26','$2a$10$LVQh8ac8apLr53uEHn6tZOX7cuWdufXI3rbCleaezlGBNtUI4o3.O'),(27,'Двадцатьседьмов','Двадцатьседьм','Двадцатьседьмович','27@ya.ru','+7-000-000-00-27','пользователь','27','$2a$10$MUhq7zCEGcKmJu.SriyNneDMr0hC4p2tLfh657tUTQNyzjuhU8tvK'),(28,'Двадцатьдевятов','Двадцатьдевят','Двадцатьдевятович','29@ya.ru','+7-000-000-00-29','пользователь','29','$2a$10$94u7rDtNIwdtaw9YUs1EmuTnOpm1Bp9NR2J.kShSUhq83sla1oiNa'),(29,'Тридцатов','Тридцат','Тридцатович','30@ya.ru','+7-000-000-00-30','пользователь','30','$2a$10$wL5LGhZI/1pqLI6618cRlOBq19bmxfKof7UYmliSxCJuPB45x2.h.'),(30,'Тридцатьпервов','Тридцатьперв','Тридцатьпервович','31@ya.ru','+7-000-000-00-31','пользователь','31','$2a$10$lkWhU6VXdBuyOvZHyb1NEOXKzIP7jZTi.8ui4Em5dKeN9ir4yI7Ie'),(31,'Тридцатьвторов','Тридцатьвтор','Тридцатьвторович','32@ya.ru','+7-000-000-00-32','пользователь','32','$2a$10$EgrlQNIDkZfbre4VfVfBTud9AGBXalocI3K3TBM69fN5LW5KXqSuO'),(32,'Тридцатьтретьев','Тридцатьтрет','Тридцатьтретьевич','33@ya.ru','+7-000-000-00-33','пользователь','33','$2a$10$dqe7qFtBStgq2LLTeEdLJuykCISxxmeGzAtfIJGb9e6PWDLz9PgGS'),(33,'Тридцатьчетвертов','Тридцатьчетверт','Тридцатьчетвертович','34@ya.ru','+7-000-000-00-34','пользователь','34','$2a$10$7uY592rJU3BbFBiqePrhr.7OaE1lK7/sKWy3foPJmagGtQJIn3f0q'),(34,'Тридцатьпятов','Тридцатьпят','Тридцатьпятович','35@ya.ru','+7-000-000-00-35','пользователь','35','$2a$10$IK1Ho9uKw4fORuZ65xOWqui3BIJqscydj9BPy5z1JlA/brMVXY6kK'),(35,'Тридцатьшестов','Тридцатьшест','Тридцатьшестович','36@ya.ru','+7-000-000-00-36','пользователь','36','$2a$10$mPjFlmYZv.ul1sDXpWu9MOL0FJwGtwr/w3LeUrPimPE0UIBmS1Pwe'),(36,'Тридцатьседьмов','Тридцатьседьм','Тридцатьседьмович','37@ya.ru','+7-000-000-00-37','пользователь','37','$2a$10$N/bmLuTnZ/1ZLO2CdN/kMeF8ewJVsuy.SQv3OYzilPpKE6IpEQxre'),(37,'Тридцатьвосьмов','Тридцатьвосьм','Тридцатьвосьмович','38@ya.ru','+7-000-000-00-38','пользователь','38','$2a$10$mQdvHnUtzoC2C0qaAomLRul/q9c/y.kItPQhoEjoqhbzrPl2KvHkS');
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

-- Dump completed on 2025-06-14 17:33:27
