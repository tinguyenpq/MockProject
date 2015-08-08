-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mock_db
-- ------------------------------------------------------
-- Server version	5.6.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `address3` varchar(255) DEFAULT NULL,
  `address4` varchar(255) DEFAULT NULL,
  `address5` varchar(255) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `sate` varchar(45) DEFAULT NULL,
  `country` varchar(45) NOT NULL,
  `post_code` varchar(45) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'ADD1','ADD2','ADD3','ADD4','ADD5','HO CHI MINH','VIETNAM','VIET NAM','70000'),(2,'ADD1','ADD2','ADD3','ADD4','ADD5','HA NOI','VIET NAM','VIET NAM','50000');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agreement_dealer`
--

DROP TABLE IF EXISTS `agreement_dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agreement_dealer` (
  `agreement_dealer` int(11) NOT NULL AUTO_INCREMENT,
  `agreement_number` int(11) NOT NULL,
  `dealer_id` int(11) NOT NULL,
  `variant_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`agreement_dealer`),
  KEY `fk_Agreement_Dealer_Dealer1_idx` (`dealer_id`),
  KEY `fk_Agreement_Dealer_Agreements1` (`agreement_number`),
  CONSTRAINT `fk_Agreement_Dealer_Agreements1` FOREIGN KEY (`agreement_number`) REFERENCES `agreements` (`agreement_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agreement_Dealer_Dealer1` FOREIGN KEY (`dealer_id`) REFERENCES `dealer` (`dealer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agreement_dealer`
--

LOCK TABLES `agreement_dealer` WRITE;
/*!40000 ALTER TABLE `agreement_dealer` DISABLE KEYS */;
/*!40000 ALTER TABLE `agreement_dealer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agreement_r_f_o`
--

DROP TABLE IF EXISTS `agreement_r_f_o`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agreement_r_f_o` (
  `r_f_o_number` varchar(45) NOT NULL,
  `agreement_number` int(11) NOT NULL,
  `variant_number` int(11) NOT NULL,
  PRIMARY KEY (`r_f_o_number`,`agreement_number`),
  KEY `fk_Agreement_R_F_O_R_F_O_Number1_idx` (`r_f_o_number`),
  KEY `fk_Agreement_R_F_O_Agreements1_idx` (`agreement_number`),
  CONSTRAINT `fk_Agreement_R_F_O_Agreements1` FOREIGN KEY (`agreement_number`) REFERENCES `agreements` (`agreement_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agreement_R_F_O_R_F_O_Number1` FOREIGN KEY (`r_f_o_number`) REFERENCES `r_f_o_number` (`r_f_o_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agreement_r_f_o`
--

LOCK TABLES `agreement_r_f_o` WRITE;
/*!40000 ALTER TABLE `agreement_r_f_o` DISABLE KEYS */;
/*!40000 ALTER TABLE `agreement_r_f_o` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agreement_status`
--

DROP TABLE IF EXISTS `agreement_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agreement_status` (
  `agreement_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `agreement_status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`agreement_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agreement_status`
--

LOCK TABLES `agreement_status` WRITE;
/*!40000 ALTER TABLE `agreement_status` DISABLE KEYS */;
INSERT INTO `agreement_status` VALUES (1,'Draft'),(2,'Awaiting Approval'),(3,'Signature Required'),(4,'Approved'),(5,'Rejected'),(6,'Discontinued'),(7,'Archived'),(8,'Overdue');
/*!40000 ALTER TABLE `agreement_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agreements`
--

DROP TABLE IF EXISTS `agreements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agreements` (
  `agreement_number` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `variant_number` int(11) NOT NULL,
  `agreement_name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `is_sign_required` tinyint(1) NOT NULL,
  `funding_method` varchar(45) NOT NULL,
  `payment_to` varchar(45) NOT NULL,
  `agenda_payment` varchar(45) NOT NULL,
  `handling_charge` double NOT NULL,
  `dealer_visibility` varchar(45) NOT NULL,
  `volume_discount_type` varchar(45) NOT NULL,
  `discount_unit` varchar(45) NOT NULL,
  `combinability` varchar(45) NOT NULL,
  `status_id` int(11) NOT NULL,
  `is_sign_received` tinyint(1) DEFAULT NULL,
  `authorised_by` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `number_of_registrations` int(11) DEFAULT NULL,
  `sign_received_date` datetime DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`agreement_number`),
  KEY `fk_Agreements_User1_idx` (`user_id`),
  KEY `fk_Agreements_Agreement_Status1_idx` (`status_id`),
  CONSTRAINT `fk_Agreements_Agreement_Status1` FOREIGN KEY (`status_id`) REFERENCES `agreement_status` (`agreement_status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agreements_User1` FOREIGN KEY (`user_id`) REFERENCES `r_f_o_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agreements`
--

LOCK TABLES `agreements` WRITE;
/*!40000 ALTER TABLE `agreements` DISABLE KEYS */;
/*!40000 ALTER TABLE `agreements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banding`
--

DROP TABLE IF EXISTS `banding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banding` (
  `banding_id` int(11) NOT NULL AUTO_INCREMENT,
  `volume_id` int(11) NOT NULL,
  `min` int(11) NOT NULL,
  `max` int(11) NOT NULL,
  PRIMARY KEY (`banding_id`),
  KEY `fk_Banding_Volume1_idx` (`volume_id`),
  CONSTRAINT `fk_Banding_Volume1` FOREIGN KEY (`volume_id`) REFERENCES `volume` (`volume_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banding`
--

LOCK TABLES `banding` WRITE;
/*!40000 ALTER TABLE `banding` DISABLE KEYS */;
/*!40000 ALTER TABLE `banding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `company_type` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `sector` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `fax_number` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `business_area` varchar(45) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`company_id`),
  KEY `fk_Company_Address1_idx` (`address_id`),
  CONSTRAINT `fk_Company_Address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'FPT 2',2,NULL,NULL,NULL,NULL,NULL,'fpt2@gamil.com','Area 2','2015-06-06 00:00:00','2015-06-06 00:00:00'),(2,'FPT',1,'',NULL,NULL,NULL,NULL,'fpt@gamil.com','Area 1','2015-06-06 00:00:00','2015-06-06 00:00:00');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_node_text`
--

DROP TABLE IF EXISTS `credit_node_text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_node_text` (
  `credit_node_text_id` int(11) NOT NULL AUTO_INCREMENT,
  `agreement_number` int(11) NOT NULL,
  `variant_number` int(11) DEFAULT NULL,
  `credit_note` varchar(255) DEFAULT NULL,
  `justification` varchar(255) NOT NULL,
  `date_time` datetime NOT NULL,
  PRIMARY KEY (`credit_node_text_id`),
  KEY `fk_Credit_Node_Text_Agreements1_idx` (`agreement_number`),
  CONSTRAINT `fk_Credit_Node_Text_Agreements1` FOREIGN KEY (`agreement_number`) REFERENCES `agreements` (`agreement_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_node_text`
--

LOCK TABLES `credit_node_text` WRITE;
/*!40000 ALTER TABLE `credit_node_text` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit_node_text` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_type` (
  `customer_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Fleet'),(2,'Leasing');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dealer`
--

DROP TABLE IF EXISTS `dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dealer` (
  `dealer_id` int(11) NOT NULL AUTO_INCREMENT,
  `dealer_code` varchar(45) NOT NULL,
  `dealer_name` varchar(45) NOT NULL,
  `town` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealer`
--

LOCK TABLES `dealer` WRITE;
/*!40000 ALTER TABLE `dealer` DISABLE KEYS */;
/*!40000 ALTER TABLE `dealer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_f_o_number`
--

DROP TABLE IF EXISTS `r_f_o_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_f_o_number` (
  `r_f_o_number` varchar(45) NOT NULL,
  `r_f_o_name` varchar(45) NOT NULL,
  `customer_type_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`r_f_o_number`),
  KEY `fk_RFO_Number_Customer_Type1_idx` (`customer_type_id`),
  KEY `fk_RFO_Number_Company1_idx` (`company_id`),
  CONSTRAINT `fk_RFO_Number_Company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RFO_Number_Customer_Type1` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`customer_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_f_o_number`
--

LOCK TABLES `r_f_o_number` WRITE;
/*!40000 ALTER TABLE `r_f_o_number` DISABLE KEYS */;
INSERT INTO `r_f_o_number` VALUES ('S001','JACK',1,1,'2015-06-06 00:00:00','2015-06-06 00:00:00'),('S002','TOM',2,1,'2015-06-06 00:00:00','2015-06-06 00:00:00'),('S003','HONEY',1,2,'2015-06-06 00:00:00','2015-06-06 00:00:00');
/*!40000 ALTER TABLE `r_f_o_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_f_o_user`
--

DROP TABLE IF EXISTS `r_f_o_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_f_o_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `user_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_User_User_Type_idx` (`user_type_id`),
  CONSTRAINT `fk_User_User_Type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_f_o_user`
--

LOCK TABLES `r_f_o_user` WRITE;
/*!40000 ALTER TABLE `r_f_o_user` DISABLE KEYS */;
INSERT INTO `r_f_o_user` VALUES (1,'Title','admin','admin','admin@gmail.com','Administrator','X',1,7),(2,'Title','cms','cms','cms@gmail.com','CSM','X',1,4);
/*!40000 ALTER TABLE `r_f_o_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_config`
--

DROP TABLE IF EXISTS `system_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_config` (
  `system_config_id` int(11) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(45) NOT NULL,
  PRIMARY KEY (`system_config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_config`
--

LOCK TABLES `system_config` WRITE;
/*!40000 ALTER TABLE `system_config` DISABLE KEYS */;
INSERT INTO `system_config` VALUES (1,'PAYMENT TO'),(2,'DEALER VISIBILITY'),(3,'DISCOUNT UNIT'),(4,'COMBINABILITY'),(5,'TRIGGER CREDIT'),(6,'CRM AGREEMENT FILE LOCATION'),(7,'FUNDING TYPE'),(8,'FUNDING STATUS'),(9,'ARCHIVE YEARS'),(10,'SCHEDULED DATES'),(11,'VOLUME DISCOUNT TYPE'),(12,'BUSINESS AREA'),(13,'NUMBER LEVEL'),(14,'SIGNED CONTRACT DEFAULT'),(15,'ORDER TYPE'),(16,'REG TYPE'),(17,'FUNDING MATCH BASED ON');
/*!40000 ALTER TABLE `system_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_config_value`
--

DROP TABLE IF EXISTS `system_config_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_config_value` (
  `system_config_value_id` int(11) NOT NULL AUTO_INCREMENT,
  `system_config_id` int(11) NOT NULL,
  `config_value` varchar(45) NOT NULL,
  `order` varchar(45) NOT NULL,
  PRIMARY KEY (`system_config_value_id`),
  KEY `fk_System_Config_Value_System_Config1_idx` (`system_config_id`),
  CONSTRAINT `fk_System_Config_Value_System_Config1` FOREIGN KEY (`system_config_id`) REFERENCES `system_config` (`system_config_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_config_value`
--

LOCK TABLES `system_config_value` WRITE;
/*!40000 ALTER TABLE `system_config_value` DISABLE KEYS */;
INSERT INTO `system_config_value` VALUES (1,1,'Customer','1'),(2,1,'Dealer','2'),(3,2,'All','1'),(4,2,'Preferred dealers only','2'),(5,2,'Selected dealers only','3'),(6,2,'Leasing co. preferred dealers only','4'),(7,3,'£','1'),(8,3,'%','2'),(13,4,'End user support only','1'),(14,4,'Leasing support only','2'),(15,4,'End user and Leasing','3'),(16,5,'End of ki','1'),(17,5,'End of month','2'),(18,5,'End of quarter','3'),(19,5,'June 30th & Dec 31st','4'),(20,5,'End of calendar year','5'),(21,5,'Move to next Banding','6'),(22,7,'End User','1'),(23,7,'Leasing','2'),(24,8,'Active','1'),(25,8,'InActive','2'),(26,10,'Immediate','1'),(27,10,'Daily','2'),(28,10,'Weekly','3'),(29,10,'None','4'),(30,11,'None','1'),(31,11,'Banding','2'),(32,11,'Retrospective Banding','3'),(33,12,'0 - 100','1'),(34,12,'100+','2'),(35,13,'8','1'),(36,14,'Yes(Enable)','1'),(37,14,'Yes(Protected)','2'),(38,14,'No','3'),(39,15,'Fleet','1'),(40,15,'Leasing','2'),(41,16,'R','1'),(42,16,'P','2'),(43,17,'Registration date','1'),(44,17,'Order date','2'),(45,4,'Leasing campaign: In lieu of end user support','4');
/*!40000 ALTER TABLE `system_config_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_type` (
  `user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES (1,'Read Only User'),(2,'Dealer'),(3,'Dealer Proposer'),(4,'CSM'),(5,'Corporate Management Team'),(6,'Corporate Sales Administrator'),(7,'System Admin'),(8,'LSM');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volume`
--

DROP TABLE IF EXISTS `volume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volume` (
  `volume_id` int(11) NOT NULL AUTO_INCREMENT,
  `agreement_number` int(11) NOT NULL,
  `trigger_credit` varchar(45) NOT NULL,
  `payment_to` varchar(45) NOT NULL,
  `variant_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`volume_id`),
  KEY `fk_Volume_Agreements1_idx` (`agreement_number`),
  CONSTRAINT `fk_Volume_Agreements1` FOREIGN KEY (`agreement_number`) REFERENCES `agreements` (`agreement_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volume`
--

LOCK TABLES `volume` WRITE;
/*!40000 ALTER TABLE `volume` DISABLE KEYS */;
/*!40000 ALTER TABLE `volume` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-08 16:17:38
