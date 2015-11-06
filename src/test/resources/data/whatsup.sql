-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.9-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for whatsup
DROP DATABASE IF EXISTS `whatsup`;
CREATE DATABASE IF NOT EXISTS `whatsup` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `whatsup`;


-- Dumping structure for table whatsup.whatsup_app_image
DROP TABLE IF EXISTS `whatsup_app_image`;
CREATE TABLE IF NOT EXISTS `whatsup_app_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `path` varchar(255) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table whatsup.whatsup_app_image: ~0 rows (approximately)
DELETE FROM `whatsup_app_image`;
/*!40000 ALTER TABLE `whatsup_app_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `whatsup_app_image` ENABLE KEYS */;


-- Dumping structure for table whatsup.whatsup_app_item
DROP TABLE IF EXISTS `whatsup_app_item`;
CREATE TABLE IF NOT EXISTS `whatsup_app_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `description` varchar(255) NOT NULL,
  `item_type` varchar(50) NOT NULL,
  `publish_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table whatsup.whatsup_app_item: ~5 rows (approximately)
DELETE FROM `whatsup_app_item`;
/*!40000 ALTER TABLE `whatsup_app_item` DISABLE KEYS */;
INSERT INTO `whatsup_app_item` (`id`, `name`, `description`, `item_type`, `publish_date`, `user_id`) VALUES
	(1, 'item1', 'My first item.', 'provided', '2012-07-04 02:00:00', 1),
	(2, 'item2', 'My 2 item.', 'provided', '2013-06-04 02:00:00', 1),
	(3, 'item2', 'My 3 item.', 'provided', '2011-06-04 02:00:00', 1),
	(4, 'item2', 'My 4 item.', 'provided', '2014-06-04 02:00:00', 1),
	(5, 'item2', 'My 5 item.', 'provided', '2015-06-04 02:00:00', 1);
/*!40000 ALTER TABLE `whatsup_app_item` ENABLE KEYS */;


-- Dumping structure for table whatsup.whatsup_app_user
DROP TABLE IF EXISTS `whatsup_app_user`;
CREATE TABLE IF NOT EXISTS `whatsup_app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_sync_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_sync_location` varchar(128) DEFAULT NULL,
  `image_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table whatsup.whatsup_app_user: ~2 rows (approximately)
DELETE FROM `whatsup_app_user`;
/*!40000 ALTER TABLE `whatsup_app_user` DISABLE KEYS */;
INSERT INTO `whatsup_app_user` (`id`, `name`, `email`, `password`, `register_date`, `last_sync_date`, `last_sync_location`, `image_id`) VALUES
	(1, 'Lei', 'lei@coolerspark.com', 'abc', '2012-06-04 02:00:00', '2012-06-04 02:00:00', 'A*B', NULL),
	(2, 'CC', 'coceicei@123.com', NULL, '2015-11-04 18:03:25', '0000-00-00 00:00:00', NULL, NULL);
/*!40000 ALTER TABLE `whatsup_app_user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
