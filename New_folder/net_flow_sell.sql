-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 05:56 PM
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
-- Table structure for table `net_flow_sell`
--

CREATE TABLE `net_flow_sell` (
  `sr_no` int(11) NOT NULL,
  `Order_Id` int(11) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `Total` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `net_flow_sell`
--

INSERT INTO `net_flow_sell` (`sr_no`, `Order_Id`, `user_id`, `name`, `Total`, `type`, `date`) VALUES
(1, 30, 'vendor_1', 'prasant', 32, 'TOTAL:', '2020-03-10'),
(2, 31, 'vendor_1', 'prasant', 120, 'TOTAL:', '2020-03-10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `net_flow_sell`
--
ALTER TABLE `net_flow_sell`
  ADD PRIMARY KEY (`sr_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `net_flow_sell`
--
ALTER TABLE `net_flow_sell`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
