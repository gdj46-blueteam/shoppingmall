-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.2.43-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- shoppingmall 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `shoppingmall` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shoppingmall`;

-- 테이블 shoppingmall.address 구조 내보내기
CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zip_code` char(5) NOT NULL COMMENT '우편번호',
  `province` varchar(30) NOT NULL COMMENT '시도',
  `city` varchar(30) NOT NULL COMMENT '시군구',
  `town` varchar(30) NOT NULL COMMENT '읍면',
  `street` varchar(50) NOT NULL COMMENT '도로명',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6337163 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.admin 구조 내보내기
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` varchar(20) NOT NULL,
  `admin_pw` varchar(500) NOT NULL,
  `admin_phone` varchar(45) NOT NULL,
  `admin_email` varchar(50) NOT NULL,
  `adminAddress_id` int(11) NOT NULL,
  `admin_addressDtail` varchar(100) NOT NULL,
  `create_date` datetime NOT NULL,
  `authority` int(11) NOT NULL DEFAULT 3,
  PRIMARY KEY (`admin_id`),
  KEY `FK_admin_address` (`adminAddress_id`) USING BTREE,
  CONSTRAINT `FK_admin_address` FOREIGN KEY (`adminAddress_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.announcement 구조 내보내기
CREATE TABLE IF NOT EXISTS `announcement` (
  `announcement_no` int(11) NOT NULL AUTO_INCREMENT,
  `announcement_title` varchar(45) NOT NULL,
  `announcement_content` text NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`announcement_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.country 구조 내보내기
CREATE TABLE IF NOT EXISTS `country` (
  `country` varchar(50) NOT NULL,
  PRIMARY KEY (`country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.customer 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` varchar(20) NOT NULL,
  `customer_pw` varchar(500) NOT NULL,
  `customer_gender` varchar(10) NOT NULL,
  `customer_age` int(11) NOT NULL,
  `customer_phone` varchar(50) NOT NULL,
  `customer_email` varchar(100) NOT NULL,
  `customer_country` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `authority` int(11) NOT NULL DEFAULT 1,
  `customer_name` varchar(50) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK_customer_country` (`customer_country`) USING BTREE,
  CONSTRAINT `FK_customer_country` FOREIGN KEY (`customer_country`) REFERENCES `country` (`country`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.employee 구조 내보내기
CREATE TABLE IF NOT EXISTS `employee` (
  `employee_no` int(11) NOT NULL AUTO_INCREMENT,
  `employee_pw` varchar(500) NOT NULL,
  `employee_sn` varchar(14) NOT NULL,
  `empAddress_id` int(11) NOT NULL,
  `employee_addressDetail` varchar(100) NOT NULL,
  `employee_name` varchar(45) NOT NULL,
  `employee_email` varchar(50) NOT NULL,
  `employee_phone` varchar(20) NOT NULL,
  `employee_gender` varchar(45) NOT NULL,
  `employee_image` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `authority` int(11) NOT NULL DEFAULT 2,
  `employee_Introduce` varchar(100) NOT NULL,
  PRIMARY KEY (`employee_no`),
  KEY `FK_employee_address` (`empAddress_id`) USING BTREE,
  CONSTRAINT `FK_employee_address` FOREIGN KEY (`empAddress_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.employee_image 구조 내보내기
CREATE TABLE IF NOT EXISTS `employee_image` (
  `employee_imageNo` int(11) NOT NULL AUTO_INCREMENT,
  `employee_no` int(11) NOT NULL,
  `employee_imageName` varchar(50) NOT NULL,
  `employee_imageType` varchar(20) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`employee_imageNo`),
  KEY `FK_employee_image_employee` (`employee_no`),
  CONSTRAINT `FK_employee_image_employee` FOREIGN KEY (`employee_no`) REFERENCES `employee` (`employee_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.employee_language 구조 내보내기
CREATE TABLE IF NOT EXISTS `employee_language` (
  `employee_language_no` int(11) NOT NULL AUTO_INCREMENT,
  `language_no` int(11) NOT NULL,
  `employee_no` int(11) NOT NULL,
  PRIMARY KEY (`employee_language_no`),
  KEY `FK_employee_language_language` (`language_no`),
  KEY `FK_employee_language_employee` (`employee_no`),
  CONSTRAINT `FK_employee_language_employee` FOREIGN KEY (`employee_no`) REFERENCES `employee` (`employee_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_employee_language_language` FOREIGN KEY (`language_no`) REFERENCES `language` (`language_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.estimate 구조 내보내기
CREATE TABLE IF NOT EXISTS `estimate` (
  `estimate_no` int(11) NOT NULL AUTO_INCREMENT,
  `tourdiy_no` int(11) NOT NULL,
  `admin_id` varchar(20) NOT NULL,
  `employee_no` int(11) NOT NULL,
  `estimate_price` int(11) NOT NULL,
  `estimate_ing` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`estimate_no`),
  KEY `FK_estimate_tourdiy` (`tourdiy_no`),
  KEY `FK_estimate_admin` (`admin_id`),
  KEY `FK_estimate_employee` (`employee_no`),
  CONSTRAINT `FK_estimate_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_estimate_employee` FOREIGN KEY (`employee_no`) REFERENCES `employee` (`employee_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_estimate_tourdiy` FOREIGN KEY (`tourdiy_no`) REFERENCES `tourdiy` (`tourdiy_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.language 구조 내보내기
CREATE TABLE IF NOT EXISTS `language` (
  `language_no` int(11) NOT NULL AUTO_INCREMENT,
  `language` varchar(45) NOT NULL,
  PRIMARY KEY (`language_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.question 구조 내보내기
CREATE TABLE IF NOT EXISTS `question` (
  `question_no` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(20) NOT NULL,
  `question_title` varchar(45) NOT NULL,
  `question_content` text NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`question_no`),
  KEY `FK_question_customer` (`customer_id`),
  CONSTRAINT `FK_question_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.review 구조 내보내기
CREATE TABLE IF NOT EXISTS `review` (
  `review_no` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(20) NOT NULL,
  `review` text NOT NULL,
  `tourdiy_no` int(11) NOT NULL,
  `estimate_no` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`review_no`),
  KEY `FK_review_customer` (`customer_id`),
  KEY `FK_review_tourdiy` (`tourdiy_no`),
  KEY `FK_review_estimate` (`estimate_no`),
  CONSTRAINT `FK_review_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_review_estimate` FOREIGN KEY (`estimate_no`) REFERENCES `estimate` (`estimate_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_review_tourdiy` FOREIGN KEY (`tourdiy_no`) REFERENCES `tourdiy` (`tourdiy_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.tour 구조 내보내기
CREATE TABLE IF NOT EXISTS `tour` (
  `tour_no` int(11) NOT NULL AUTO_INCREMENT,
  `tourarea_id` int(11) NOT NULL,
  `tour_name` varchar(50) NOT NULL,
  `tour_description` text NOT NULL,
  `tour_image` varchar(45) NOT NULL,
  PRIMARY KEY (`tour_no`),
  KEY `tourarea_id` (`tourarea_id`),
  CONSTRAINT `FK_tour_tourarea` FOREIGN KEY (`tourarea_id`) REFERENCES `tourarea` (`tourarea_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.tourarea 구조 내보내기
CREATE TABLE IF NOT EXISTS `tourarea` (
  `tourarea_id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`tourarea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.tourdiy 구조 내보내기
CREATE TABLE IF NOT EXISTS `tourdiy` (
  `tourdiy_no` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(20) NOT NULL,
  `language_no` int(11) NOT NULL,
  `tourarea_id` int(11) NOT NULL,
  `tourdiy_people` int(11) NOT NULL,
  `tourdiy_term` date NOT NULL,
  `tourdiy_stay` varchar(45) NOT NULL,
  `tourdiy_etc` text NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`tourdiy_no`) USING BTREE,
  KEY `FK_tourdiy_customer` (`customer_id`),
  KEY `FK_tourdiy_language` (`language_no`),
  KEY `FK_tourdiy_tourarea` (`tourarea_id`),
  CONSTRAINT `FK_tourdiy_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tourdiy_language` FOREIGN KEY (`language_no`) REFERENCES `language` (`language_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tourdiy_tourarea` FOREIGN KEY (`tourarea_id`) REFERENCES `tourarea` (`tourarea_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.tourdiy_transportation 구조 내보내기
CREATE TABLE IF NOT EXISTS `tourdiy_transportation` (
  `transportation_no` int(11) NOT NULL,
  `tourdiy_no` int(11) NOT NULL,
  PRIMARY KEY (`transportation_no`,`tourdiy_no`),
  KEY `FK__tourdiy` (`tourdiy_no`),
  CONSTRAINT `FK__tourdiy` FOREIGN KEY (`tourdiy_no`) REFERENCES `tourdiy` (`tourdiy_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__transportation` FOREIGN KEY (`transportation_no`) REFERENCES `transportation` (`transportation_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.tourimage 구조 내보내기
CREATE TABLE IF NOT EXISTS `tourimage` (
  `tourimage_no` int(11) NOT NULL AUTO_INCREMENT,
  `tour_no` int(11) NOT NULL,
  `tourimage_name` varchar(45) NOT NULL,
  `tourimage_type` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`tourimage_no`),
  KEY `FK_tourimage_tour` (`tour_no`),
  CONSTRAINT `FK_tourimage_tour` FOREIGN KEY (`tour_no`) REFERENCES `tour` (`tour_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.tourkind 구조 내보내기
CREATE TABLE IF NOT EXISTS `tourkind` (
  `tourkind_no` int(11) NOT NULL AUTO_INCREMENT,
  `tourkind` varchar(45) NOT NULL,
  `tourkind_description` text NOT NULL,
  PRIMARY KEY (`tourkind_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.tourkind_diy 구조 내보내기
CREATE TABLE IF NOT EXISTS `tourkind_diy` (
  `tourkind_no` int(11) NOT NULL,
  `tourdiy_no` int(11) NOT NULL,
  PRIMARY KEY (`tourkind_no`,`tourdiy_no`),
  KEY `FK_tourkind_diy_tourdiy` (`tourdiy_no`),
  CONSTRAINT `FK_tourkind_diy_tourdiy` FOREIGN KEY (`tourdiy_no`) REFERENCES `tourdiy` (`tourdiy_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tourkind_diy_tourkind` FOREIGN KEY (`tourkind_no`) REFERENCES `tourkind` (`tourkind_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shoppingmall.transportation 구조 내보내기
CREATE TABLE IF NOT EXISTS `transportation` (
  `transportation_no` int(11) NOT NULL AUTO_INCREMENT,
  `transportation` varchar(45) NOT NULL,
  PRIMARY KEY (`transportation_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
