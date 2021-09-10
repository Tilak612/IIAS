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
-- Table structure for table `inflow_sell`
--

CREATE TABLE `inflow_sell` (
  `Order_Id` int(11) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Total` int(11) NOT NULL,
  `Sum` int(11) NOT NULL,
  `percentage` int(11) NOT NULL,
  `date` date NOT NULL,
  `pay` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inflow_sell`
--

INSERT INTO `inflow_sell` (`Order_Id`, `user_id`, `name`, `Total`, `Sum`, `percentage`, `date`, `pay`) VALUES
(22, 'vendor_1', 'prasant', 157, 196, 20, '2020-03-10', 39),
(30, 'vendor_1', 'prasant', 32, 40, 20, '2020-03-10', 8);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
