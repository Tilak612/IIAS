-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 05:58 PM
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
-- Table structure for table `inflow_sell_information`
--

CREATE TABLE `inflow_sell_information` (
  `Order_id` int(11) NOT NULL,
  `item_code` varchar(50) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `quality` int(11) NOT NULL,
  `Amount` float NOT NULL,
  `price` int(11) NOT NULL,
  `return_quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inflow_sell_information`
--

INSERT INTO `inflow_sell_information` (`Order_id`, `item_code`, `item_name`, `quality`, `Amount`, `price`, `return_quantity`) VALUES
(22, 'I01', 'Chocolate ice cream', 13, 91, 7, 2),
(22, 'I01', 'Chocolate ice cream', 15, 105, 7, 0),
(30, 'I02', 'Vanilla ice cream', 2, 40, 20, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
