-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 04, 2024 at 06:16 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `school_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `principal`
--

DROP TABLE IF EXISTS `principal`;
CREATE TABLE IF NOT EXISTS `principal` (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `p_fname` varchar(50) NOT NULL,
  `p_address` varchar(100) NOT NULL,
  `p_dob` date NOT NULL,
  `p_email` varchar(30) NOT NULL,
  `p_tel` int NOT NULL,
  `p_status` varchar(10) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `principal`
--

INSERT INTO `principal` (`p_id`, `p_fname`, `p_address`, `p_dob`, `p_email`, `p_tel`, `p_status`) VALUES
(1, 'Ramya Sirisena', 'No.17, Kandy Rd, Gampaha', '1964-10-13', 'siri@gmail.com', 715643299, 'Past'),
(2, 'Mahela Udukubura', 'No. 55, Polgahawela Rd, Kegalle', '1966-11-23', 'mahela@gmail.com', 710257756, 'Past');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `s_id` int NOT NULL AUTO_INCREMENT,
  `s_fname` varchar(50) NOT NULL,
  `s_address` varchar(100) NOT NULL,
  `s_dob` date NOT NULL,
  `s_tel` int NOT NULL,
  `s_parent_name` varchar(50) NOT NULL,
  `s_class` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`s_id`, `s_fname`, `s_address`, `s_dob`, `s_tel`, `s_parent_name`, `s_class`) VALUES
(1, 'Udesha Karunanayake', 'NO.152/5, Church Rd, Gampaha', '2001-12-18', 715556610, 'Devinda Karunanayake', '11'),
(2, 'Tharindu Nilanga', 'No.15/7, Bandaragama, Horana', '2002-01-04', 712236510, 'Rohitha Bandara', '10');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_fname` varchar(50) NOT NULL,
  `t_address` varchar(100) NOT NULL,
  `t_dob` date NOT NULL,
  `t_email` varchar(30) NOT NULL,
  `t_tel` int NOT NULL,
  `t_subject` varchar(20) NOT NULL,
  `t_section` varchar(20) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`t_id`, `t_fname`, `t_address`, `t_dob`, `t_email`, `t_tel`, `t_subject`, `t_section`) VALUES
(1, 'Chamara Kasun', 'No.65/4, Awissawella Rd, Polgahawela', '1988-07-14', 'chamara@gmail.com', 715564545, 'English', 'Senior'),
(4, 'Shanika Rajapakshe', 'No.5, Kandy Rd, Kadawatha', '1985-08-06', 'shanika@gmail.com', 715556944, 'Music', 'Primary');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_fname` varchar(50) NOT NULL,
  `user_address` varchar(100) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_tel` int NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  `con_password` varchar(16) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_fname`, `user_address`, `user_email`, `user_tel`, `username`, `password`, `con_password`, `role`) VALUES
(1, 'Ravindu', 'No.60, Yakkala Rd, Gampaha', 'ravindu@gmail.com', 712561313, 'ravindu', '123456', '123456', 'admin'),
(2, 'Adithya Rosayru', 'No 196/15A, Asgiriya, Gampaha', 'arosayru29@gmail.com', 718523135, 'arosa', '123456', '123456', 'Principal'),
(3, 'Sithija Sankalpa', 'No.56, Horowpathana Rd, Anuradhapuraya', 'sithija@gmail.com', 785454211, 'sithija', '123456', '123456', 'admin'),
(4, 'Chalitha Sathsara', 'No.16/5, Minuwangoda Rd, Gampaha', 'chali@gmail.com', 758882112, 'chali', '123456', '123456', 'admin'),
(5, 'Tharanga Prasad', 'No.15, Nallathanni', 'thara@gmail.com', 712225566, 'thara', '123456', '123456', 'Teacher'),
(6, 'Nuwan Thushara', 'No.12/2,Galle Rd, Colombo', 'nuwan@gmail.com', 767781155, 'nuwan', '123456', '123456', 'admin'),
(7, 'Adithya Rosayru', 'Colombo', 'arosa@gmail.com', 1111111111, 'rosa', '123456', '123456', 'admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
