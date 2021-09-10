-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 05:55 PM
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
-- Table structure for table `sales_information`
--

CREATE TABLE `sales_information` (
  `order_id` int(11) NOT NULL,
  `sr.no.` int(11) NOT NULL,
  `item_code` varchar(100) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `quality` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales_information`
--

INSERT INTO `sales_information` (`order_id`, `sr.no.`, `item_code`, `item_name`, `quality`, `Amount`, `price`) VALUES
(1, 1, 'I01', 'cc', 12, 24, 2),
(21, 0, 'I01', 'Chocolate ice cream', 15, 45, 3),
(22, 0, 'I01', 'Chocolate ice cream', 15, 105, 7),
(22, 0, 'I01', 'Chocolate ice cream', 15, 105, 7),
(24, 0, 'i01', 'Chocolate ice cream', 15, 45, 3),
(26, 0, 'I01', 'Chocolate ice cream', 15, 60, 4),
(26, 1, 'I02', 'Vanilla ice cream', 20, 100, 5),
(27, 0, 'I01', 'Chocolate ice cream', 15, 105, 7),
(27, 1, 'I02', 'Vanilla ice cream', 20, 80, 4),
(28, 0, 'I01', 'Chocolate ice cream', 15, 75, 5),
(29, 0, 'I02', 'Vanilla ice cream', 5, 100, 20),
(30, 0, 'I02', 'Vanilla ice cream', 5, 100, 20),
(31, 0, 'I02', 'Vanilla ice cream', 6, 120, 20);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
