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
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `cost_price` double NOT NULL,
  `sell_price` double NOT NULL,
  `opening_stock` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `category`, `cost_price`, `sell_price`, `opening_stock`, `description`) VALUES
(1, 'New Era Powder', 'Powder', 4500, 5000, 10, 'Sugerless'),
(2, 'Hand Dumbles', 'Dumble', 6000, 6300, 30, 'Each of which are 5 kg'),
(3, 'Jeams Sweet', 'Dumbles', 600, 780, 100, 'for boosting'),
(4, 'Royel Boost', 'Boosts', 900, 1185, 1000, 'import from Korea'),
(5, 'Jeam Belt', 'Dumbles', 700, 840, 400, 'import from pokhara'),
(6, 'Gang Jotel', 'Dumbles', 890, 740, 800, 'Must keep in dry place'),
(7, 'Feasting klor', 'Dumbles', 9640, 1500, 1000, '6 mpnth Gurantee');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
