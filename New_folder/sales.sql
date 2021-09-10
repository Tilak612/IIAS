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
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `Order_id` int(11) NOT NULL,
  `sell_date` date NOT NULL DEFAULT current_timestamp(),
  `user_id` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `Total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`Order_id`, `sell_date`, `user_id`, `type`, `name`, `Total`) VALUES
(1, '2020-02-05', '1tt', 'Street Vendor', 't', 176),
(2, '2018-04-16', 'i01', 'Street Vendor', '444', 192),
(3, '2020-02-14', 'I01', 'Street Vendor', 'jkkk', 238),
(4, '2020-02-14', 'I01', 'Shop Vendor', 'il', 116),
(5, '2020-02-14', 'I03', 'Street Vendor', 'rkkk', 144),
(6, '2020-02-14', 'jj', 'Street Vendor', 'jjj', 88),
(7, '2020-02-14', 'll', 'Street Vendor', 'kkk', 88),
(8, '2020-02-14', 'I01', 'Street Vendor', 'dd', 138),
(9, '2020-02-14', '99', 'Street Vendor', 'jjjf', 144),
(10, '2020-02-14', 'pp', 'Street Vendor', 'ui', 80),
(11, '2020-02-25', '', 'Street Vendor', '', 260),
(12, '2020-02-26', 'vendor_1', 'Shop Vendor', 'prasant', 75),
(13, '2020-02-28', 'vendor_1', 'Shop Vendor', 'prasant', 260),
(14, '2020-02-28', 'vendor_1', 'Shop Vendor', 'prasant', 15),
(15, '2020-02-28', 'vendor_1', 'Shop Vendor', 'prasant', 250),
(16, '2020-03-02', 'vendor_1', 'Shop Vendor', 'prasant', 215),
(17, '2020-03-02', 'vendor_1', 'Shop Vendor', 'prasant', 215),
(18, '2020-03-03', 'vendor_1', 'Shop Vendor', 'prasant', 145),
(19, '2020-03-05', 'vendor_1', 'Shop Vendor', 'prasant', 300),
(20, '2020-03-10', 'VENDOR_1', 'Shop Vendor', 'prasant', 45),
(21, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 45),
(22, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 105),
(23, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 105),
(24, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 45),
(25, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 105),
(26, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 160),
(27, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 185),
(28, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 75),
(29, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 100),
(30, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 100),
(31, '2020-03-10', 'vendor_1', 'Shop Vendor', 'prasant', 120);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`Order_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `Order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
