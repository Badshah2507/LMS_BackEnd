-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.0.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `test`;

-- Dumping structure for table test.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `date_of_birth` date DEFAULT NULL,
  `date_of_joining` date DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) NOT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test.employee: ~3 rows (approximately)
DELETE FROM `employee`;
INSERT INTO `employee` (`date_of_birth`, `date_of_joining`, `department`, `designation`, `employee_id`, `employee_name`, `gender`) VALUES
	('2001-01-29', '2023-01-24', 'Technology', 'Associate', '20801160', 'Om', 'Male'),
	('2001-02-15', '2023-01-23', 'Finance', 'Manager', '20801161', 'Anish', 'Male'),
	('2001-11-11', '2022-12-20', 'Human Resources', 'Executive', '20801162', 'Harhsita', 'Female');

-- Dumping structure for table test.employee_card
CREATE TABLE IF NOT EXISTS `employee_card` (
  `card_issue_date` date DEFAULT NULL,
  `employee_card_id` bigint(20) NOT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `loan_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_card_id`),
  KEY `FK5wgsru6m1w1xocmq7basxbldb` (`employee_id`),
  KEY `FK8tknkancrkuhagefihdb4xl97` (`loan_id`),
  CONSTRAINT `FK5wgsru6m1w1xocmq7basxbldb` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FK8tknkancrkuhagefihdb4xl97` FOREIGN KEY (`loan_id`) REFERENCES `loan_card` (`loan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test.employee_card: ~0 rows (approximately)
DELETE FROM `employee_card`;

-- Dumping structure for table test.employee_issue_details
CREATE TABLE IF NOT EXISTS `employee_issue_details` (
  `issue_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `issue_id` bigint(20) NOT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `item_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `FK5kosep0gdr2l2x6ddvr9d9hr` (`employee_id`),
  KEY `FKpr7w23joae87cf26068cfs0rx` (`item_id`),
  CONSTRAINT `FK5kosep0gdr2l2x6ddvr9d9hr` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKpr7w23joae87cf26068cfs0rx` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test.employee_issue_details: ~0 rows (approximately)
DELETE FROM `employee_issue_details`;

-- Dumping structure for table test.item
CREATE TABLE IF NOT EXISTS `item` (
  `item_valuation` int(11) DEFAULT NULL,
  `issue_status` varchar(255) DEFAULT NULL,
  `item_category` varchar(255) DEFAULT NULL,
  `item_description` varchar(255) DEFAULT NULL,
  `item_id` varchar(255) NOT NULL,
  `item_make` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test.item: ~4 rows (approximately)
DELETE FROM `item`;
INSERT INTO `item` (`item_valuation`, `issue_status`, `item_category`, `item_description`, `item_id`, `item_make`) VALUES
	(5000, 'Y', 'Furniture', 'Tea Table', '10001', 'Wooden'),
	(15000, 'Y', 'Furniture', 'Dining Table', '10002', 'Wooden'),
	(9000, 'N', 'Crockery', 'Dining Set', '10018', 'Glass'),
	(2000, 'Y', 'Stationery', 'Pen Set', '10020', 'Plastic');

-- Dumping structure for table test.loan_card
CREATE TABLE IF NOT EXISTS `loan_card` (
  `loan_duration_yrs` int(11) DEFAULT NULL,
  `loan_id` varchar(255) NOT NULL,
  `loan_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`loan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test.loan_card: ~3 rows (approximately)
DELETE FROM `loan_card`;
INSERT INTO `loan_card` (`loan_duration_yrs`, `loan_id`, `loan_type`) VALUES
	(5, 'L0001', 'Furniture'),
	(1, 'L0002', 'Stationery'),
	(2, 'L0003', 'Crockery');

-- Dumping structure for table test.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test.user: ~4 rows (approximately)
DELETE FROM `user`;
INSERT INTO `user` (`id`, `employee_id`, `name`, `password`, `role`) VALUES
	(101, 'E0001', 'Prathamesh', 'YWRtaW4=', 'Admin'),
	(1101, '20801160', 'Om', 'dXNlcg==', 'User'),
	(1102, '20801161', 'Anish', 'dXNlcg==', 'User'),
	(1103, '20801162', 'Harhsita', 'dXNlcg==', 'User');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
