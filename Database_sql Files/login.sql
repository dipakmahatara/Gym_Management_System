-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 23, 2018 at 11:43 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gym_mgmt_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `security_question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `full_name`, `security_question`, `answer`) VALUES
(1, 'admin', 'password', '', '', ''),
(2, 'D_admin', 'password', '', '', ''),
(3, 'Barney', 'barney', 'Barney Singh', 'What is your father name', 'Dipak'),
(4, 'Barney', 'barney', 'Barney Singh', 'What is your father name', 'Dipak'),
(5, 'prerana', 'prerana', 'Prerana Adhikari', 'Who is your Best Actor?', 'dayahang'),
(6, 'giriraj', 'giriraj', 'Giriraj Pokhrel', 'What is your born city?', 'dahachour'),
(8, 'Ankit Vosodi', 'ankit', 'ankit', 'Who is your Best Actor?', 'Deep Da'),
(10, 'dipak', 'dipak', 'Dipak Mahatara', 'What is your father name?', 'Karn Bahadur Mahatara');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
