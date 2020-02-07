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
-- Table structure for table `history`
--

CREATE TABLE IF NOT EXISTS `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `task` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `date`, `task`) VALUES
(1, '2018-05-21 11:53:26', 'Logged in by admin'),
(2, '2018-05-21 11:56:47', 'Members are aaded by admin'),
(3, '2018-05-21 11:57:54', 'Members are aaded by dipak'),
(4, '2018-05-22 11:05:14', 'Member Prakash Oli is aded by '),
(5, '2018-05-22 11:08:58', 'Logged in by Prerana Adhikari'),
(6, '2018-05-22 11:56:17', 'Logged in by dipak'),
(7, '2018-05-22 01:05:37', 'Member Sabita Dangi is aded by '),
(8, '2018-05-22 01:26:22', 'Member Deep Dai is updated to Deep Dai by '),
(19, '2018-05-22 02:53:21', 'Member Gangaram Subedi is updated to null by null'),
(10, '2018-05-22 01:37:15', 'Logged in by giriraj'),
(11, '2018-05-22 01:37:41', 'Member Rasu Lal Chaudhary is updated to null by null'),
(12, '2018-05-22 02:15:41', 'Logged in by giriraj'),
(13, '2018-05-22 02:17:50', 'Member Kalu Pande is added by null'),
(14, '2018-05-22 02:19:25', 'Logged in by prerana'),
(15, '2018-05-22 02:21:44', 'Member Gangaram Subedi is added by null'),
(16, '2018-05-22 02:23:23', 'Logged in by admin'),
(17, '2018-05-22 02:27:37', 'Logged in by admin'),
(18, '2018-05-22 02:29:21', 'Member Barsha Rawat is added by '),
(20, '2018-05-22 02:55:21', 'Member Gangaram Subedi is updated to null by null'),
(21, '2018-05-22 02:59:00', 'Member Polo is updated to null by null'),
(22, '2018-05-23 10:49:24', 'Logged in by dipak');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
