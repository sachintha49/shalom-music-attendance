-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: attendance_db
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `attendance_date` date NOT NULL,
  `autoMarked` bit(1) NOT NULL,
  `cardIdUsed` varchar(255) DEFAULT NULL,
  `createdAt` datetime(6) NOT NULL,
  `deviceId` varchar(255) DEFAULT NULL,
  `manualOverride` bit(1) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `punchTime` datetime(6) DEFAULT NULL,
  `punchType` varchar(255) DEFAULT NULL,
  `status` enum('ABSENT','EXCUSED','LATE','PRESENT') NOT NULL,
  `updatedAt` datetime(6) DEFAULT NULL,
  `student_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKtc2hy77ldgu1s2a7r0ws0h0gi` (`student_id`,`attendance_date`),
  CONSTRAINT `FK7121lveuhtmu9wa6m90ayd5yg` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_fees`
--

DROP TABLE IF EXISTS `class_fees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_fees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amountDue` decimal(38,2) NOT NULL,
  `createdAt` datetime(6) NOT NULL,
  `dueDate` date NOT NULL,
  `notes` text,
  `paid` bit(1) NOT NULL,
  `paymentDate` datetime(6) DEFAULT NULL,
  `updatedAt` datetime(6) NOT NULL,
  `class_session_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ng70ggiiwttg3fk6q1u9shq4` (`class_session_id`),
  KEY `FKfr2i5pfy368cb6pu0xnm4g3ge` (`student_id`),
  CONSTRAINT `FK4ng70ggiiwttg3fk6q1u9shq4` FOREIGN KEY (`class_session_id`) REFERENCES `class_schedule` (`id`),
  CONSTRAINT `FKfr2i5pfy368cb6pu0xnm4g3ge` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_fees`
--

LOCK TABLES `class_fees` WRITE;
/*!40000 ALTER TABLE `class_fees` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_fees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_schedule`
--

DROP TABLE IF EXISTS `class_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_schedule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `classType` enum('ONLINE','PHYSICAL') NOT NULL,
  `endTime` datetime(6) NOT NULL,
  `notes` text,
  `schedule_type` enum('FRIDAY_3_4','FRIDAY_4_15_5_15','FRIDAY_5_30_6_30','MONDAY_3_4','MONDAY_4_15_5_15','MONDAY_5_30_6_30','SATURDAY_3_4','SATURDAY_4_15_5_15','SATURDAY_5_30_6_30','THURSDAY_3_4','THURSDAY_4_15_5_15','THURSDAY_5_30_6_30','TUESDAY_3_4','TUESDAY_4_15_5_15','TUESDAY_5_30_6_30','WEDNESDAY_3_4','WEDNESDAY_4_15_5_15','WEDNESDAY_5_30_6_30') NOT NULL,
  `sessionName` varchar(255) NOT NULL,
  `startTime` datetime(6) NOT NULL,
  `teacherName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_schedule`
--

LOCK TABLES `class_schedule` WRITE;
/*!40000 ALTER TABLE `class_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_student`
--

DROP TABLE IF EXISTS `class_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_student` (
  `class_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  KEY `FKcod8qhu7x0rlng3t2wyc9yhwb` (`student_id`),
  KEY `FKjsfjmef29oumnnng22l9bfnxi` (`class_id`),
  CONSTRAINT `FKcod8qhu7x0rlng3t2wyc9yhwb` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `FKjsfjmef29oumnnng22l9bfnxi` FOREIGN KEY (`class_id`) REFERENCES `class_schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_student`
--

LOCK TABLES `class_student` WRITE;
/*!40000 ALTER TABLE `class_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdAt` datetime(6) DEFAULT NULL,
  `messageContent` text,
  `notificationType` enum('CALENDAR','EMAIL','WHATSAPP') DEFAULT NULL,
  `scheduledDate` datetime(6) DEFAULT NULL,
  `status` enum('FAILED','PENDING','SENT') DEFAULT NULL,
  `updatedAt` datetime(6) DEFAULT NULL,
  `classSession_id` bigint DEFAULT NULL,
  `student_student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrcl177rjmob1w65ogo5mk9duh` (`classSession_id`),
  KEY `FK7v78s71lqijo03bx9yry1qu92` (`student_student_id`),
  CONSTRAINT `FK7v78s71lqijo03bx9yry1qu92` FOREIGN KEY (`student_student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `FKrcl177rjmob1w65ogo5mk9duh` FOREIGN KEY (`classSession_id`) REFERENCES `class_schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progress`
--

DROP TABLE IF EXISTS `progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `progress` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdAt` datetime(6) DEFAULT NULL,
  `performanceDate` date DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `remarks` text,
  `songName` varchar(255) DEFAULT NULL,
  `updatedAt` datetime(6) DEFAULT NULL,
  `classSession_id` bigint DEFAULT NULL,
  `student_student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe512yad3hch4x4wn2e49dcnxn` (`classSession_id`),
  KEY `FKbk6454uoh4vdfj44m198noelc` (`student_student_id`),
  CONSTRAINT `FKbk6454uoh4vdfj44m198noelc` FOREIGN KEY (`student_student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `FKe512yad3hch4x4wn2e49dcnxn` FOREIGN KEY (`classSession_id`) REFERENCES `class_schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress`
--

LOCK TABLES `progress` WRITE;
/*!40000 ALTER TABLE `progress` DISABLE KEYS */;
/*!40000 ALTER TABLE `progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` bigint NOT NULL AUTO_INCREMENT,
  `classType` varchar(255) DEFAULT NULL,
  `createdAt` datetime(6) NOT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enrollmentDate` date DEFAULT NULL,
  `firstName` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) NOT NULL,
  `mobileWhatsApp` varchar(255) DEFAULT NULL,
  `notes` text,
  `parentName` varchar(255) DEFAULT NULL,
  `personType` enum('ADULT','CHILD') NOT NULL,
  `status` enum('ACTIVE','COMPLETED','INACTIVE','SUSPENDED') DEFAULT NULL,
  `student_code` varchar(255) NOT NULL,
  `updatedAt` datetime(6) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `requestedClassScheduleDateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `UK_cgcf3r5xk73o0etbduc1qxnol` (`student_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'attendance_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-25 16:46:43
