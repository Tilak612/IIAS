-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 05:57 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `froze`
--

-- --------------------------------------------------------

--
-- Table structure for table `stock_information`
--

CREATE TABLE `stock_information` (
  `date` date NOT NULL,
  `item_code` varchar(50) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `quality` int(11) NOT NULL,
  `dymanic_quality` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_information`
--

INSERT INTO `stock_information` (`date`, `item_code`, `item_name`, `quality`, `dymanic_quality`, `Amount`, `price`) VALUES
('2020-03-09', 'I01', 'Chocolate ice cream', 15, 0, 90, 6),
('2020-03-09', 'I01', 'Chocolate ice cream', 15, 0, 90, 6),
('2020-03-09', 'I01', 'Chocolate ice cream', 15, 0, 90, 6),
('2020-03-09', 'I01', 'Chocolate ice cream', 15, 0, 90, 6),
('2020-03-10', 'I01', 'Chocolate ice cream', 15, 0, 60, 4),
('2020-03-10', 'I02', 'Vanilla ice cream', 20, 7, 100, 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
